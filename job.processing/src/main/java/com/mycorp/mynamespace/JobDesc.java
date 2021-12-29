/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package com.mycorp.mynamespace;

import org.apache.avro.specific.SpecificData;
import org.apache.avro.message.BinaryMessageEncoder;
import org.apache.avro.message.BinaryMessageDecoder;
import org.apache.avro.message.SchemaStore;

@SuppressWarnings("all")
@org.apache.avro.specific.AvroGenerated
public class JobDesc extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = -2633399876257644797L;
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"JobDesc\",\"namespace\":\"com.mycorp.mynamespace\",\"fields\":[{\"name\":\"before\",\"type\":[\"null\",{\"type\":\"record\",\"name\":\"Value\",\"fields\":[{\"name\":\"id\",\"type\":\"int\"},{\"name\":\"jd_desc\",\"type\":[\"null\",{\"type\":\"string\",\"avro.java.string\":\"String\"}],\"default\":null},{\"name\":\"jd_name\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}}],\"connect.name\":\"kafka_tr_db.kafka_tr_db.t_job_desc.Value\"}],\"default\":null},{\"name\":\"after\",\"type\":[\"null\",\"Value\"],\"default\":null},{\"name\":\"source\",\"type\":{\"type\":\"record\",\"name\":\"Source\",\"namespace\":\"io.debezium.connector.mysql\",\"fields\":[{\"name\":\"version\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"connector\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"name\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"ts_ms\",\"type\":\"long\"},{\"name\":\"snapshot\",\"type\":[{\"type\":\"string\",\"avro.java.string\":\"String\",\"connect.default\":\"false\",\"connect.name\":\"io.debezium.data.Enum\",\"connect.parameters\":{\"allowed\":\"true,last,false\"},\"connect.version\":1},\"null\"],\"default\":\"false\"},{\"name\":\"db\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"sequence\",\"type\":[\"null\",{\"type\":\"string\",\"avro.java.string\":\"String\"}],\"default\":null},{\"name\":\"table\",\"type\":[\"null\",{\"type\":\"string\",\"avro.java.string\":\"String\"}],\"default\":null},{\"name\":\"server_id\",\"type\":\"long\"},{\"name\":\"gtid\",\"type\":[\"null\",{\"type\":\"string\",\"avro.java.string\":\"String\"}],\"default\":null},{\"name\":\"file\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"pos\",\"type\":\"long\"},{\"name\":\"row\",\"type\":\"int\"},{\"name\":\"thread\",\"type\":[\"null\",\"long\"],\"default\":null},{\"name\":\"query\",\"type\":[\"null\",{\"type\":\"string\",\"avro.java.string\":\"String\"}],\"default\":null}],\"connect.name\":\"io.debezium.connector.mysql.Source\"}},{\"name\":\"op\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"ts_ms\",\"type\":[\"null\",\"long\"],\"default\":null},{\"name\":\"transaction\",\"type\":[\"null\",{\"type\":\"record\",\"name\":\"ConnectDefault\",\"namespace\":\"io.confluent.connect.avro\",\"fields\":[{\"name\":\"id\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"total_order\",\"type\":\"long\"},{\"name\":\"data_collection_order\",\"type\":\"long\"}]}],\"default\":null}],\"connect.name\":\"kafka_tr_db.kafka_tr_db.t_job_desc.Envelope\"}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  private static SpecificData MODEL$ = new SpecificData();

  private static final BinaryMessageEncoder<JobDesc> ENCODER =
      new BinaryMessageEncoder<JobDesc>(MODEL$, SCHEMA$);

  private static final BinaryMessageDecoder<JobDesc> DECODER =
      new BinaryMessageDecoder<JobDesc>(MODEL$, SCHEMA$);

  /**
   * Return the BinaryMessageDecoder instance used by this class.
   */
  public static BinaryMessageDecoder<JobDesc> getDecoder() {
    return DECODER;
  }

  /**
   * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
   * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
   */
  public static BinaryMessageDecoder<JobDesc> createDecoder(SchemaStore resolver) {
    return new BinaryMessageDecoder<JobDesc>(MODEL$, SCHEMA$, resolver);
  }

  /** Serializes this JobDesc to a ByteBuffer. */
  public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
    return ENCODER.encode(this);
  }

  /** Deserializes a JobDesc from a ByteBuffer. */
  public static JobDesc fromByteBuffer(
      java.nio.ByteBuffer b) throws java.io.IOException {
    return DECODER.decode(b);
  }

  @Deprecated public com.mycorp.mynamespace.Value before;
  @Deprecated public com.mycorp.mynamespace.Value after;
  @Deprecated public io.debezium.connector.mysql.Source source;
  @Deprecated public java.lang.String op;
  @Deprecated public java.lang.Long ts_ms;
  @Deprecated public io.confluent.connect.avro.ConnectDefault transaction;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public JobDesc() {}

  /**
   * All-args constructor.
   * @param before The new value for before
   * @param after The new value for after
   * @param source The new value for source
   * @param op The new value for op
   * @param ts_ms The new value for ts_ms
   * @param transaction The new value for transaction
   */
  public JobDesc(com.mycorp.mynamespace.Value before, com.mycorp.mynamespace.Value after, io.debezium.connector.mysql.Source source, java.lang.String op, java.lang.Long ts_ms, io.confluent.connect.avro.ConnectDefault transaction) {
    this.before = before;
    this.after = after;
    this.source = source;
    this.op = op;
    this.ts_ms = ts_ms;
    this.transaction = transaction;
  }

  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call.
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return before;
    case 1: return after;
    case 2: return source;
    case 3: return op;
    case 4: return ts_ms;
    case 5: return transaction;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  // Used by DatumReader.  Applications should not call.
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: before = (com.mycorp.mynamespace.Value)value$; break;
    case 1: after = (com.mycorp.mynamespace.Value)value$; break;
    case 2: source = (io.debezium.connector.mysql.Source)value$; break;
    case 3: op = (java.lang.String)value$; break;
    case 4: ts_ms = (java.lang.Long)value$; break;
    case 5: transaction = (io.confluent.connect.avro.ConnectDefault)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  /**
   * Gets the value of the 'before' field.
   * @return The value of the 'before' field.
   */
  public com.mycorp.mynamespace.Value getBefore() {
    return before;
  }

  /**
   * Sets the value of the 'before' field.
   * @param value the value to set.
   */
  public void setBefore(com.mycorp.mynamespace.Value value) {
    this.before = value;
  }

  /**
   * Gets the value of the 'after' field.
   * @return The value of the 'after' field.
   */
  public com.mycorp.mynamespace.Value getAfter() {
    return after;
  }

  /**
   * Sets the value of the 'after' field.
   * @param value the value to set.
   */
  public void setAfter(com.mycorp.mynamespace.Value value) {
    this.after = value;
  }

  /**
   * Gets the value of the 'source' field.
   * @return The value of the 'source' field.
   */
  public io.debezium.connector.mysql.Source getSource() {
    return source;
  }

  /**
   * Sets the value of the 'source' field.
   * @param value the value to set.
   */
  public void setSource(io.debezium.connector.mysql.Source value) {
    this.source = value;
  }

  /**
   * Gets the value of the 'op' field.
   * @return The value of the 'op' field.
   */
  public java.lang.String getOp() {
    return op;
  }

  /**
   * Sets the value of the 'op' field.
   * @param value the value to set.
   */
  public void setOp(java.lang.String value) {
    this.op = value;
  }

  /**
   * Gets the value of the 'ts_ms' field.
   * @return The value of the 'ts_ms' field.
   */
  public java.lang.Long getTsMs() {
    return ts_ms;
  }

  /**
   * Sets the value of the 'ts_ms' field.
   * @param value the value to set.
   */
  public void setTsMs(java.lang.Long value) {
    this.ts_ms = value;
  }

  /**
   * Gets the value of the 'transaction' field.
   * @return The value of the 'transaction' field.
   */
  public io.confluent.connect.avro.ConnectDefault getTransaction() {
    return transaction;
  }

  /**
   * Sets the value of the 'transaction' field.
   * @param value the value to set.
   */
  public void setTransaction(io.confluent.connect.avro.ConnectDefault value) {
    this.transaction = value;
  }

  /**
   * Creates a new JobDesc RecordBuilder.
   * @return A new JobDesc RecordBuilder
   */
  public static com.mycorp.mynamespace.JobDesc.Builder newBuilder() {
    return new com.mycorp.mynamespace.JobDesc.Builder();
  }

  /**
   * Creates a new JobDesc RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new JobDesc RecordBuilder
   */
  public static com.mycorp.mynamespace.JobDesc.Builder newBuilder(com.mycorp.mynamespace.JobDesc.Builder other) {
    return new com.mycorp.mynamespace.JobDesc.Builder(other);
  }

  /**
   * Creates a new JobDesc RecordBuilder by copying an existing JobDesc instance.
   * @param other The existing instance to copy.
   * @return A new JobDesc RecordBuilder
   */
  public static com.mycorp.mynamespace.JobDesc.Builder newBuilder(com.mycorp.mynamespace.JobDesc other) {
    return new com.mycorp.mynamespace.JobDesc.Builder(other);
  }

  /**
   * RecordBuilder for JobDesc instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<JobDesc>
    implements org.apache.avro.data.RecordBuilder<JobDesc> {

    private com.mycorp.mynamespace.Value before;
    private com.mycorp.mynamespace.Value.Builder beforeBuilder;
    private com.mycorp.mynamespace.Value after;
    private com.mycorp.mynamespace.Value.Builder afterBuilder;
    private io.debezium.connector.mysql.Source source;
    private io.debezium.connector.mysql.Source.Builder sourceBuilder;
    private java.lang.String op;
    private java.lang.Long ts_ms;
    private io.confluent.connect.avro.ConnectDefault transaction;
    private io.confluent.connect.avro.ConnectDefault.Builder transactionBuilder;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(com.mycorp.mynamespace.JobDesc.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.before)) {
        this.before = data().deepCopy(fields()[0].schema(), other.before);
        fieldSetFlags()[0] = true;
      }
      if (other.hasBeforeBuilder()) {
        this.beforeBuilder = com.mycorp.mynamespace.Value.newBuilder(other.getBeforeBuilder());
      }
      if (isValidValue(fields()[1], other.after)) {
        this.after = data().deepCopy(fields()[1].schema(), other.after);
        fieldSetFlags()[1] = true;
      }
      if (other.hasAfterBuilder()) {
        this.afterBuilder = com.mycorp.mynamespace.Value.newBuilder(other.getAfterBuilder());
      }
      if (isValidValue(fields()[2], other.source)) {
        this.source = data().deepCopy(fields()[2].schema(), other.source);
        fieldSetFlags()[2] = true;
      }
      if (other.hasSourceBuilder()) {
        this.sourceBuilder = io.debezium.connector.mysql.Source.newBuilder(other.getSourceBuilder());
      }
      if (isValidValue(fields()[3], other.op)) {
        this.op = data().deepCopy(fields()[3].schema(), other.op);
        fieldSetFlags()[3] = true;
      }
      if (isValidValue(fields()[4], other.ts_ms)) {
        this.ts_ms = data().deepCopy(fields()[4].schema(), other.ts_ms);
        fieldSetFlags()[4] = true;
      }
      if (isValidValue(fields()[5], other.transaction)) {
        this.transaction = data().deepCopy(fields()[5].schema(), other.transaction);
        fieldSetFlags()[5] = true;
      }
      if (other.hasTransactionBuilder()) {
        this.transactionBuilder = io.confluent.connect.avro.ConnectDefault.newBuilder(other.getTransactionBuilder());
      }
    }

    /**
     * Creates a Builder by copying an existing JobDesc instance
     * @param other The existing instance to copy.
     */
    private Builder(com.mycorp.mynamespace.JobDesc other) {
            super(SCHEMA$);
      if (isValidValue(fields()[0], other.before)) {
        this.before = data().deepCopy(fields()[0].schema(), other.before);
        fieldSetFlags()[0] = true;
      }
      this.beforeBuilder = null;
      if (isValidValue(fields()[1], other.after)) {
        this.after = data().deepCopy(fields()[1].schema(), other.after);
        fieldSetFlags()[1] = true;
      }
      this.afterBuilder = null;
      if (isValidValue(fields()[2], other.source)) {
        this.source = data().deepCopy(fields()[2].schema(), other.source);
        fieldSetFlags()[2] = true;
      }
      this.sourceBuilder = null;
      if (isValidValue(fields()[3], other.op)) {
        this.op = data().deepCopy(fields()[3].schema(), other.op);
        fieldSetFlags()[3] = true;
      }
      if (isValidValue(fields()[4], other.ts_ms)) {
        this.ts_ms = data().deepCopy(fields()[4].schema(), other.ts_ms);
        fieldSetFlags()[4] = true;
      }
      if (isValidValue(fields()[5], other.transaction)) {
        this.transaction = data().deepCopy(fields()[5].schema(), other.transaction);
        fieldSetFlags()[5] = true;
      }
      this.transactionBuilder = null;
    }

    /**
      * Gets the value of the 'before' field.
      * @return The value.
      */
    public com.mycorp.mynamespace.Value getBefore() {
      return before;
    }

    /**
      * Sets the value of the 'before' field.
      * @param value The value of 'before'.
      * @return This builder.
      */
    public com.mycorp.mynamespace.JobDesc.Builder setBefore(com.mycorp.mynamespace.Value value) {
      validate(fields()[0], value);
      this.beforeBuilder = null;
      this.before = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'before' field has been set.
      * @return True if the 'before' field has been set, false otherwise.
      */
    public boolean hasBefore() {
      return fieldSetFlags()[0];
    }

    /**
     * Gets the Builder instance for the 'before' field and creates one if it doesn't exist yet.
     * @return This builder.
     */
    public com.mycorp.mynamespace.Value.Builder getBeforeBuilder() {
      if (beforeBuilder == null) {
        if (hasBefore()) {
          setBeforeBuilder(com.mycorp.mynamespace.Value.newBuilder(before));
        } else {
          setBeforeBuilder(com.mycorp.mynamespace.Value.newBuilder());
        }
      }
      return beforeBuilder;
    }

    /**
     * Sets the Builder instance for the 'before' field
     * @param value The builder instance that must be set.
     * @return This builder.
     */
    public com.mycorp.mynamespace.JobDesc.Builder setBeforeBuilder(com.mycorp.mynamespace.Value.Builder value) {
      clearBefore();
      beforeBuilder = value;
      return this;
    }

    /**
     * Checks whether the 'before' field has an active Builder instance
     * @return True if the 'before' field has an active Builder instance
     */
    public boolean hasBeforeBuilder() {
      return beforeBuilder != null;
    }

    /**
      * Clears the value of the 'before' field.
      * @return This builder.
      */
    public com.mycorp.mynamespace.JobDesc.Builder clearBefore() {
      before = null;
      beforeBuilder = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'after' field.
      * @return The value.
      */
    public com.mycorp.mynamespace.Value getAfter() {
      return after;
    }

    /**
      * Sets the value of the 'after' field.
      * @param value The value of 'after'.
      * @return This builder.
      */
    public com.mycorp.mynamespace.JobDesc.Builder setAfter(com.mycorp.mynamespace.Value value) {
      validate(fields()[1], value);
      this.afterBuilder = null;
      this.after = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'after' field has been set.
      * @return True if the 'after' field has been set, false otherwise.
      */
    public boolean hasAfter() {
      return fieldSetFlags()[1];
    }

    /**
     * Gets the Builder instance for the 'after' field and creates one if it doesn't exist yet.
     * @return This builder.
     */
    public com.mycorp.mynamespace.Value.Builder getAfterBuilder() {
      if (afterBuilder == null) {
        if (hasAfter()) {
          setAfterBuilder(com.mycorp.mynamespace.Value.newBuilder(after));
        } else {
          setAfterBuilder(com.mycorp.mynamespace.Value.newBuilder());
        }
      }
      return afterBuilder;
    }

    /**
     * Sets the Builder instance for the 'after' field
     * @param value The builder instance that must be set.
     * @return This builder.
     */
    public com.mycorp.mynamespace.JobDesc.Builder setAfterBuilder(com.mycorp.mynamespace.Value.Builder value) {
      clearAfter();
      afterBuilder = value;
      return this;
    }

    /**
     * Checks whether the 'after' field has an active Builder instance
     * @return True if the 'after' field has an active Builder instance
     */
    public boolean hasAfterBuilder() {
      return afterBuilder != null;
    }

    /**
      * Clears the value of the 'after' field.
      * @return This builder.
      */
    public com.mycorp.mynamespace.JobDesc.Builder clearAfter() {
      after = null;
      afterBuilder = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    /**
      * Gets the value of the 'source' field.
      * @return The value.
      */
    public io.debezium.connector.mysql.Source getSource() {
      return source;
    }

    /**
      * Sets the value of the 'source' field.
      * @param value The value of 'source'.
      * @return This builder.
      */
    public com.mycorp.mynamespace.JobDesc.Builder setSource(io.debezium.connector.mysql.Source value) {
      validate(fields()[2], value);
      this.sourceBuilder = null;
      this.source = value;
      fieldSetFlags()[2] = true;
      return this;
    }

    /**
      * Checks whether the 'source' field has been set.
      * @return True if the 'source' field has been set, false otherwise.
      */
    public boolean hasSource() {
      return fieldSetFlags()[2];
    }

    /**
     * Gets the Builder instance for the 'source' field and creates one if it doesn't exist yet.
     * @return This builder.
     */
    public io.debezium.connector.mysql.Source.Builder getSourceBuilder() {
      if (sourceBuilder == null) {
        if (hasSource()) {
          setSourceBuilder(io.debezium.connector.mysql.Source.newBuilder(source));
        } else {
          setSourceBuilder(io.debezium.connector.mysql.Source.newBuilder());
        }
      }
      return sourceBuilder;
    }

    /**
     * Sets the Builder instance for the 'source' field
     * @param value The builder instance that must be set.
     * @return This builder.
     */
    public com.mycorp.mynamespace.JobDesc.Builder setSourceBuilder(io.debezium.connector.mysql.Source.Builder value) {
      clearSource();
      sourceBuilder = value;
      return this;
    }

    /**
     * Checks whether the 'source' field has an active Builder instance
     * @return True if the 'source' field has an active Builder instance
     */
    public boolean hasSourceBuilder() {
      return sourceBuilder != null;
    }

    /**
      * Clears the value of the 'source' field.
      * @return This builder.
      */
    public com.mycorp.mynamespace.JobDesc.Builder clearSource() {
      source = null;
      sourceBuilder = null;
      fieldSetFlags()[2] = false;
      return this;
    }

    /**
      * Gets the value of the 'op' field.
      * @return The value.
      */
    public java.lang.String getOp() {
      return op;
    }

    /**
      * Sets the value of the 'op' field.
      * @param value The value of 'op'.
      * @return This builder.
      */
    public com.mycorp.mynamespace.JobDesc.Builder setOp(java.lang.String value) {
      validate(fields()[3], value);
      this.op = value;
      fieldSetFlags()[3] = true;
      return this;
    }

    /**
      * Checks whether the 'op' field has been set.
      * @return True if the 'op' field has been set, false otherwise.
      */
    public boolean hasOp() {
      return fieldSetFlags()[3];
    }


    /**
      * Clears the value of the 'op' field.
      * @return This builder.
      */
    public com.mycorp.mynamespace.JobDesc.Builder clearOp() {
      op = null;
      fieldSetFlags()[3] = false;
      return this;
    }

    /**
      * Gets the value of the 'ts_ms' field.
      * @return The value.
      */
    public java.lang.Long getTsMs() {
      return ts_ms;
    }

    /**
      * Sets the value of the 'ts_ms' field.
      * @param value The value of 'ts_ms'.
      * @return This builder.
      */
    public com.mycorp.mynamespace.JobDesc.Builder setTsMs(java.lang.Long value) {
      validate(fields()[4], value);
      this.ts_ms = value;
      fieldSetFlags()[4] = true;
      return this;
    }

    /**
      * Checks whether the 'ts_ms' field has been set.
      * @return True if the 'ts_ms' field has been set, false otherwise.
      */
    public boolean hasTsMs() {
      return fieldSetFlags()[4];
    }


    /**
      * Clears the value of the 'ts_ms' field.
      * @return This builder.
      */
    public com.mycorp.mynamespace.JobDesc.Builder clearTsMs() {
      ts_ms = null;
      fieldSetFlags()[4] = false;
      return this;
    }

    /**
      * Gets the value of the 'transaction' field.
      * @return The value.
      */
    public io.confluent.connect.avro.ConnectDefault getTransaction() {
      return transaction;
    }

    /**
      * Sets the value of the 'transaction' field.
      * @param value The value of 'transaction'.
      * @return This builder.
      */
    public com.mycorp.mynamespace.JobDesc.Builder setTransaction(io.confluent.connect.avro.ConnectDefault value) {
      validate(fields()[5], value);
      this.transactionBuilder = null;
      this.transaction = value;
      fieldSetFlags()[5] = true;
      return this;
    }

    /**
      * Checks whether the 'transaction' field has been set.
      * @return True if the 'transaction' field has been set, false otherwise.
      */
    public boolean hasTransaction() {
      return fieldSetFlags()[5];
    }

    /**
     * Gets the Builder instance for the 'transaction' field and creates one if it doesn't exist yet.
     * @return This builder.
     */
    public io.confluent.connect.avro.ConnectDefault.Builder getTransactionBuilder() {
      if (transactionBuilder == null) {
        if (hasTransaction()) {
          setTransactionBuilder(io.confluent.connect.avro.ConnectDefault.newBuilder(transaction));
        } else {
          setTransactionBuilder(io.confluent.connect.avro.ConnectDefault.newBuilder());
        }
      }
      return transactionBuilder;
    }

    /**
     * Sets the Builder instance for the 'transaction' field
     * @param value The builder instance that must be set.
     * @return This builder.
     */
    public com.mycorp.mynamespace.JobDesc.Builder setTransactionBuilder(io.confluent.connect.avro.ConnectDefault.Builder value) {
      clearTransaction();
      transactionBuilder = value;
      return this;
    }

    /**
     * Checks whether the 'transaction' field has an active Builder instance
     * @return True if the 'transaction' field has an active Builder instance
     */
    public boolean hasTransactionBuilder() {
      return transactionBuilder != null;
    }

    /**
      * Clears the value of the 'transaction' field.
      * @return This builder.
      */
    public com.mycorp.mynamespace.JobDesc.Builder clearTransaction() {
      transaction = null;
      transactionBuilder = null;
      fieldSetFlags()[5] = false;
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public JobDesc build() {
      try {
        JobDesc record = new JobDesc();
        if (beforeBuilder != null) {
          record.before = this.beforeBuilder.build();
        } else {
          record.before = fieldSetFlags()[0] ? this.before : (com.mycorp.mynamespace.Value) defaultValue(fields()[0]);
        }
        if (afterBuilder != null) {
          record.after = this.afterBuilder.build();
        } else {
          record.after = fieldSetFlags()[1] ? this.after : (com.mycorp.mynamespace.Value) defaultValue(fields()[1]);
        }
        if (sourceBuilder != null) {
          record.source = this.sourceBuilder.build();
        } else {
          record.source = fieldSetFlags()[2] ? this.source : (io.debezium.connector.mysql.Source) defaultValue(fields()[2]);
        }
        record.op = fieldSetFlags()[3] ? this.op : (java.lang.String) defaultValue(fields()[3]);
        record.ts_ms = fieldSetFlags()[4] ? this.ts_ms : (java.lang.Long) defaultValue(fields()[4]);
        if (transactionBuilder != null) {
          record.transaction = this.transactionBuilder.build();
        } else {
          record.transaction = fieldSetFlags()[5] ? this.transaction : (io.confluent.connect.avro.ConnectDefault) defaultValue(fields()[5]);
        }
        return record;
      } catch (java.lang.Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumWriter<JobDesc>
    WRITER$ = (org.apache.avro.io.DatumWriter<JobDesc>)MODEL$.createDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumReader<JobDesc>
    READER$ = (org.apache.avro.io.DatumReader<JobDesc>)MODEL$.createDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

}
