package kafka.training.person.producer;

import com.mycorp.mynamespace.PersonJob;
import io.confluent.kafka.serializers.KafkaAvroSerializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.Scheduled;
import service.KafkaProducerWrapper;
import service.PersonJobGenerator;

@SpringBootApplication
public class Application {
    
    final static String BOOT_SERVERS = "localhost:9092";
    final static String KEY_SER = StringSerializer.class.getName();//"org.apache.kafka.common.serialization.StringSerializer";
    final static String VAL_SER = KafkaAvroSerializer.class.getName();//"org.apache.kafka.common.serialization.StringSerializer";
    final static String REGISTRY = "http://localhost:8081";
    final static String TOPIC = "person-job";
    final static String KEY = "PERSON_JOB";
    final static int LIMIT = 100;

    static KafkaProducerWrapper producer = new KafkaProducerWrapper();

    @Scheduled(fixedDelay = 100)
    public void scheduleProducer() {

        PersonJobGenerator generator = new PersonJobGenerator();
        PersonJob personJob = generator.generate();
        producer.publish(TOPIC, KEY, personJob);
//        producer.close();

    }

    public static void main(String[] args) {

        producer.setBootStrapServers(BOOT_SERVERS)
                .setKeyValueSerializers(KEY_SER, VAL_SER)
                .setSchemaRegistryUrl(REGISTRY)
                .startProducing();

        SpringApplication.run(Application.class, args);

    }

}

