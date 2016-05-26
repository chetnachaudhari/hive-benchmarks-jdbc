package com.flipkart.hive.benchmarks.utils;

import com.google.inject.Injector;

public class GuiceUtils {

  private static Injector injector;
  public static void initialize(Injector inj)
  {
    injector = inj;

  }
  public static <T> T getInstance(Class<T> type)
  {
    return injector.getInstance(type);
  }
}