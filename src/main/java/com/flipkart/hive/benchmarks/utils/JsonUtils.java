package com.flipkart.hive.benchmarks.utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fasterxml.jackson.module.jaxb.JaxbAnnotationModule;

import java.io.IOException;

public class JsonUtils {
  private static ObjectMapper mapper;

  public static ObjectMapper customRootMapper;

  static
  {
    mapper = new ObjectMapper();

    customRootMapper = new ObjectMapper();
    customRootMapper.configure(DeserializationFeature.UNWRAP_ROOT_VALUE, true);
    customRootMapper.configure(SerializationFeature.WRAP_ROOT_VALUE, true);
    customRootMapper.registerModule(new JaxbAnnotationModule());

  }

  public static<T> T fromJson(String json,Class<T> klass) {
    try {
      if(json == null)
        return null;
      return mapper.readValue(json, TypeFactory.defaultInstance().constructType(klass));
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
  public static<T> T fromJson(String json,Class<T> klass , ObjectMapper mapper) {
    try {
      if(json == null)
        return null;
      return mapper.readValue(json, TypeFactory.defaultInstance().constructType(klass));
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
  public static String toJson(Object o) {
    try {
      return mapper.writeValueAsString(o);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  public static<T> T fromJson(String jsonString, TypeReference<T> type) {
    try {
      return mapper.readValue(jsonString,TypeFactory.defaultInstance().constructType(type));
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
  public static <T> T convertValue(Object fromValue, Class<T> toValueType)
  {
    return (T) mapper.convertValue(fromValue, toValueType);
  }

  public static <T> T convertValue(Object fromValue, Class<T> toValueType, T defaultVal)
  {
    if(fromValue == null)
      return defaultVal;
    return (T) mapper.convertValue(fromValue, toValueType);
  }
}
