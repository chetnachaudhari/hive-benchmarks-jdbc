package com.flipkart.hive.benchmarks.blogic;

import com.flipkart.hive.benchmarks.convertors.Converter;
import com.flipkart.hive.benchmarks.core.entities.JobCounter;
import com.flipkart.hive.benchmarks.utils.JsonUtils;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import lombok.Data;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@Data
public class JobCountersResponse implements Converter<JobCounter> {
  private JobCounters jobCounters = new JobCounters();

  @Data public static class JobCounters {
    private String id;

    private List<CounterGroup> counterGroup = Lists.newArrayList();
  }

  @Data public static class CounterGroup {
    private String counterGroupName;

    private Counter[] counter;

  }

  @Data public static class Counter {

    private Long reduceCounterValue;

    private String name;

    private Long totalCounterValue;

    private Long mapCounterValue;

  }
  public JobCounter convert()
  {
    if(jobCounters == null || jobCounters.counterGroup == null )
      return null;
    List<Counter> allCounters = Lists.newArrayList();
    jobCounters.counterGroup.forEach(cg -> Collections.addAll(allCounters, cg.getCounter()));

    Map<String,Long> countersAsMap = Maps.newHashMap();
    allCounters.forEach(
        c ->
        {
          if(c == null)
            return;
          countersAsMap.put(c.getName() + "__totalCounterValue", c.getTotalCounterValue());
          countersAsMap.put(c.getName() + "__mapCounterValue", c.getMapCounterValue());
          countersAsMap.put(c.getName() + "__reduceCounterValue", c.getReduceCounterValue());
        }
    );

    return JsonUtils.convertValue(countersAsMap, JobCounter.class);
  }

}