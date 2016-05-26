package com.flipkart.hive.benchmarks.core.entities;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY,
    getterVisibility = JsonAutoDetect.Visibility.NONE,
    isGetterVisibility = JsonAutoDetect.Visibility.NONE,
    setterVisibility = JsonAutoDetect.Visibility.NONE)
@Table(name = "job_counters")
public class JobCounter extends BaseEntity{

  public String jobId;

  public Long FILE_BYTES_READ__totalCounterValue;
  public Long FILE_BYTES_READ__mapCounterValue;
  public Long FILE_BYTES_READ__reduceCounterValue;
  public Long FILE_BYTES_WRITTEN__totalCounterValue;
  public Long FILE_BYTES_WRITTEN__mapCounterValue;
  public Long FILE_BYTES_WRITTEN__reduceCounterValue;
  public Long FILE_LARGE_READ_OPS__totalCounterValue;
  public Long FILE_LARGE_READ_OPS__mapCounterValue;
  public Long FILE_LARGE_READ_OPS__reduceCounterValue;
  public Long FILE_READ_OPS__totalCounterValue;
  public Long FILE_READ_OPS__mapCounterValue;
  public Long FILE_READ_OPS__reduceCounterValue;
  public Long FILE_WRITE_OPS__totalCounterValue;
  public Long FILE_WRITE_OPS__mapCounterValue;
  public Long FILE_WRITE_OPS__reduceCounterValue;
  public Long HDFS_BYTES_READ__totalCounterValue;
  public Long HDFS_BYTES_READ__mapCounterValue;
  public Long HDFS_BYTES_READ__reduceCounterValue;
  public Long HDFS_BYTES_WRITTEN__totalCounterValue;
  public Long HDFS_BYTES_WRITTEN__mapCounterValue;
  public Long HDFS_BYTES_WRITTEN__reduceCounterValue;
  public Long HDFS_LARGE_READ_OPS__totalCounterValue;
  public Long HDFS_LARGE_READ_OPS__mapCounterValue;
  public Long HDFS_LARGE_READ_OPS__reduceCounterValue;
  public Long HDFS_READ_OPS__totalCounterValue;
  public Long HDFS_READ_OPS__mapCounterValue;
  public Long HDFS_READ_OPS__reduceCounterValue;
  public Long HDFS_WRITE_OPS__totalCounterValue;
  public Long HDFS_WRITE_OPS__mapCounterValue;
  public Long HDFS_WRITE_OPS__reduceCounterValue;
  public Long COMBINE_INPUT_RECORDS__totalCounterValue;
  public Long COMBINE_INPUT_RECORDS__mapCounterValue;
  public Long COMBINE_INPUT_RECORDS__reduceCounterValue;
  public Long COMBINE_OUTPUT_RECORDS__totalCounterValue;
  public Long COMBINE_OUTPUT_RECORDS__mapCounterValue;
  public Long COMBINE_OUTPUT_RECORDS__reduceCounterValue;
  public Long CPU_MILLISECONDS__totalCounterValue;
  public Long CPU_MILLISECONDS__mapCounterValue;
  public Long CPU_MILLISECONDS__reduceCounterValue;
  public Long FAILED_SHUFFLE__totalCounterValue;
  public Long FAILED_SHUFFLE__mapCounterValue;
  public Long FAILED_SHUFFLE__reduceCounterValue;
  public Long GC_TIME_MILLIS__totalCounterValue;
  public Long GC_TIME_MILLIS__mapCounterValue;
  public Long GC_TIME_MILLIS__reduceCounterValue;
  public Long SPLIT_RAW_BYTES__totalCounterValue;
  public Long SPLIT_RAW_BYTES__mapCounterValue;
  public Long SPLIT_RAW_BYTES__reduceCounterValue;
  public Long MAP_INPUT_RECORDS__totalCounterValue;
  public Long MAP_INPUT_RECORDS__mapCounterValue;
  public Long MAP_INPUT_RECORDS__reduceCounterValue;
  public Long MAP_OUTPUT_BYTES__totalCounterValue;
  public Long MAP_OUTPUT_BYTES__mapCounterValue;
  public Long MAP_OUTPUT_BYTES__reduceCounterValue;
  public Long MAP_OUTPUT_MATERIALIZED_BYTES__totalCounterValue;
  public Long MAP_OUTPUT_MATERIALIZED_BYTES__mapCounterValue;
  public Long MAP_OUTPUT_MATERIALIZED_BYTES__reduceCounterValue;
  public Long MAP_OUTPUT_RECORDS__totalCounterValue;
  public Long MAP_OUTPUT_RECORDS__mapCounterValue;
  public Long MAP_OUTPUT_RECORDS__reduceCounterValue;
  public Long MERGED_MAP_OUTPUTS__totalCounterValue;
  public Long MERGED_MAP_OUTPUTS__mapCounterValue;
  public Long MERGED_MAP_OUTPUTS__reduceCounterValue;
  public Long PHYSICAL_MEMORY_BYTES__totalCounterValue;
  public Long PHYSICAL_MEMORY_BYTES__mapCounterValue;
  public Long PHYSICAL_MEMORY_BYTES__reduceCounterValue;
  public Long REDUCE_INPUT_GROUPS__totalCounterValue;
  public Long REDUCE_INPUT_GROUPS__mapCounterValue;
  public Long REDUCE_INPUT_GROUPS__reduceCounterValue;
  public Long REDUCE_INPUT_RECORDS__totalCounterValue;
  public Long REDUCE_INPUT_RECORDS__mapCounterValue;
  public Long REDUCE_INPUT_RECORDS__reduceCounterValue;
  public Long REDUCE_OUTPUT_RECORDS__totalCounterValue;
  public Long REDUCE_OUTPUT_RECORDS__mapCounterValue;
  public Long REDUCE_OUTPUT_RECORDS__reduceCounterValue;
  public Long REDUCE_SHUFFLE_BYTES__totalCounterValue;
  public Long REDUCE_SHUFFLE_BYTES__mapCounterValue;
  public Long REDUCE_SHUFFLE_BYTES__reduceCounterValue;
  public Long SHUFFLED_MAPS__totalCounterValue;
  public Long SHUFFLED_MAPS__mapCounterValue;
  public Long SHUFFLED_MAPS__reduceCounterValue;
  public Long SPILLED_RECORDS__totalCounterValue;
  public Long SPILLED_RECORDS__mapCounterValue;
  public Long SPILLED_RECORDS__reduceCounterValue;
  public Long COMMITTED_HEAP_BYTES__totalCounterValue;
  public Long COMMITTED_HEAP_BYTES__mapCounterValue;
  public Long COMMITTED_HEAP_BYTES__reduceCounterValue;
  public Long VIRTUAL_MEMORY_BYTES__totalCounterValue;
  public Long VIRTUAL_MEMORY_BYTES__mapCounterValue;
  public Long VIRTUAL_MEMORY_BYTES__reduceCounterValue;
  public Long BAD_ID__totalCounterValue;
  public Long BAD_ID__mapCounterValue;
  public Long BAD_ID__reduceCounterValue;
  public Long CONNECTION__totalCounterValue;
  public Long CONNECTION__mapCounterValue;
  public Long CONNECTION__reduceCounterValue;
  public Long IO_ERROR__totalCounterValue;
  public Long IO_ERROR__mapCounterValue;
  public Long IO_ERROR__reduceCounterValue;
  public Long WRONG_LENGTH__totalCounterValue;
  public Long WRONG_LENGTH__mapCounterValue;
  public Long WRONG_LENGTH__reduceCounterValue;
  public Long WRONG_MAP__totalCounterValue;
  public Long WRONG_MAP__mapCounterValue;
  public Long WRONG_MAP__reduceCounterValue;
  public Long WRONG_REDUCE__totalCounterValue;
  public Long WRONG_REDUCE__mapCounterValue;
  public Long WRONG_REDUCE__reduceCounterValue;
  public Long BYTES_READ__totalCounterValue;
  public Long BYTES_READ__mapCounterValue;
  public Long BYTES_READ__reduceCounterValue;
  public Long BYTES_WRITTEN__totalCounterValue;
  public Long BYTES_WRITTEN__mapCounterValue;
  public Long BYTES_WRITTEN__reduceCounterValue;
}
