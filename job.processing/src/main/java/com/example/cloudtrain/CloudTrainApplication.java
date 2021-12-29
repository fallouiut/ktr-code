package com.example.cloudtrain;

import com.mycorp.mynamespace.JobDesc;
import com.mycorp.mynamespace.JobStat;
import com.mycorp.mynamespace.PersonJob;
import io.confluent.kafka.serializers.AbstractKafkaAvroSerDeConfig;
import io.confluent.kafka.streams.serdes.avro.SpecificAvroSerde;
import kafka_tr_db.kafka_tr_db.t_job_desc.Envelope;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.KeyValue;
import org.apache.kafka.streams.kstream.Grouped;
import org.apache.kafka.streams.kstream.KGroupedStream;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.KTable;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Collections;
import java.util.Map;
import java.util.function.Function;

@SpringBootApplication
public class CloudTrainApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudTrainApplication.class, args);
    }

    // IN-0 = person-job topic     (String, PersonJob)
    // IN 1 = job desc otpic       (String, JobDesc)
    // OUT = person-job-stat topic (String, JobStat)
    @Bean
    public Function< KStream<String, PersonJob>, Function<KTable<String, Envelope>, KTable<String, JobStat>> > jobDescProcessing() {

        return personJobStream -> (
            jobDescStream -> (
                this.myTopology(personJobStream, jobDescStream)
            )
        );

    }

    // debezium send data as en envelope that contains (source, data before, data after)
    public KTable<String, JobStat> myTopology(KStream<String, PersonJob> personJobStream, KTable<String, Envelope> jobDescStream) {

        /**
         * count by jobs
         */
        KTable<String, JobStat> jobStatTable = countJobs(personJobStream);

        /**
         * left join between each job count and job desc then publish to jobStat
         */
        jobStatTable = joinToDescription(jobDescStream, jobStatTable);

        /**
         * JOINING TO JOB DESCS
         */
        return jobStatTable;

    }

    /**
     * in this method, we take personJobStream and we count how many people
     * grouped by jobs
     *
     * 1 . GROUPING
     * job1 -> [person1, person2], job2 -> [person4, person, 5, person6]
     *
     * 2. count by groups (aggregations)
     * for each group, we iterate on records and call aggregate()
     * we initialize aggregated object for each group before looping on records
     * on group iteration, for each record of the group, we pass the same object
     * and we can enrich our aggregated object by operation we do on record
     * this object is a result of aggregated records
     * aggregate = group, faire grossir un tas (selon moi)
     */
    private KTable<String, JobStat> countJobs(KStream<String, PersonJob> personJobStream) {
        // 1.
        KGroupedStream<String, String> grouped = personJobStream
            .map((key, valuePerson) -> new KeyValue<>(valuePerson.jobName, valuePerson.personName))
            .groupByKey(Grouped.with(Serdes.String(), Serdes.String()));

        // 2.
        KTable<String, JobStat> jobStatsStream = grouped.aggregate(
            () -> JobStat.newBuilder().setCount(0).setJobName("").setDescription("Aucune description").build(),

            (key, value, jobStatAggregate) -> { // String, String, JobState
                jobStatAggregate.setJobName(key);
                jobStatAggregate.setCount(jobStatAggregate.count + 1);
                return jobStatAggregate;
            }
        );

        return jobStatsStream;
    }

    /**
     * we join each job stat to its
     * existing description on JobDescTable
     */
    private KTable<String, JobStat> joinToDescription(KTable<String, Envelope> jobDescTable, KTable<String, JobStat> jobStatTable) {
        // re-key by job name to perform join
        jobStatTable = jobStatTable.toStream().map( (key, valueJobStat)  -> new KeyValue<>(valueJobStat.getJobName(), valueJobStat) ).toTable();
        jobDescTable = jobDescTable.toStream().map( (key, valueEnvelope) -> new KeyValue<>(valueEnvelope.getAfter().getJdName(), valueEnvelope) ).toTable();

        KTable<String, JobStat> jobStatTableFull =  jobStatTable.leftJoin(jobDescTable,
            (jobStat, jobDesc) -> {
                if(jobDesc != null) {
                    jobStat.setDescription(jobDesc.getAfter().getJdDesc());
                    System.err.println(jobStat.getCount() + " Job : " + jobStat.getJobName() + ", decs: (" + jobDesc.getAfter().getJdName() + ") " + jobDesc.getAfter().getJdDesc());
                }

                return jobStat;
            }
        );
        return jobStatTable;
    }

}