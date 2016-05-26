package com.flipkart.hive.benchmarks.service;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;
import io.dropwizard.db.DataSourceFactory;
import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public class BenchmarksConfiguration extends Configuration {
  @Valid
  @NotNull
  @JsonProperty("dbConfig")
  @Setter
  @Getter
  private DataSourceFactory dbConfig;

}
