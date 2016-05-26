package com.flipkart.hive.benchmarks.utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.mashape.unirest.request.BaseRequest;

import lombok.extern.slf4j.Slf4j;

import java.time.Duration;

@Slf4j
public class HttpUtils {

  static {
    Unirest.setTimeouts(Duration.ofMinutes(10).toMillis(), Duration.ofMinutes(15).toMillis());
  }

  public static <T> T get(String url, Class<T> klass) {
    return JsonUtils.fromJson(execute(Unirest.get(url).header("accept", "application/json")).getBody(), klass);
  }

  public static <T> T get(String url, Class<T> klass, ObjectMapper mapper) {
    return JsonUtils.fromJson(
        execute(Unirest.get(url).header("accept", "application/json")).getBody(), klass, mapper);
  }

  public static String getAsString(String uri) {
    return execute(Unirest.get(uri).header("accept", "application/json")).getBody();

  }
  public static String getAsString(BaseRequest request) {
    return execute(request.getHttpRequest().header("accept", "application/json")).getBody();

  }

  private static HttpResponse<String> execute(BaseRequest request) {
    try {
      log.info("Requesting data from url={}", request.getHttpRequest().getUrl());
      return request.asString();
    } catch (UnirestException e) {
      log.info("Failed to get response", e);
      throw new RuntimeException(e);
    }
  }

  public static <T> T get(BaseRequest request, Class<T> klass) {

    return JsonUtils.fromJson(execute(request).getBody(), klass);
  }

  public static <T> T get(BaseRequest request, TypeReference<T> type) {

    return JsonUtils.fromJson(execute(request).getBody(), type);
  }
}