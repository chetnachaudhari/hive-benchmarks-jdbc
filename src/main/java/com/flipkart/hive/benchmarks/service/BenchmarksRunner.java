package com.flipkart.hive.benchmarks.service;

import com.flipkart.hive.benchmarks.core.dao.BaseDao;
import com.flipkart.hive.benchmarks.utils.GuiceUtils;
import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import io.dropwizard.Application;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.hibernate.HibernateBundle;
import io.dropwizard.hibernate.ScanningHibernateBundle;
import io.dropwizard.hibernate.UnitOfWorkAwareProxyFactory;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import lombok.Getter;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BenchmarksRunner extends Application<BenchmarksConfiguration> {

  public static Injector injector;

  private static final Logger logger = LoggerFactory.getLogger(BenchmarksRunner.class);

  private final HibernateBundle<BenchmarksConfiguration> hibernateBundle = new
      ScanningHibernateBundle<BenchmarksConfiguration>("com.flipkart.hive.benchmarks.core") {
        @Override
        public DataSourceFactory getDataSourceFactory(BenchmarksConfiguration configuration) {
          return configuration.getDbConfig();
        }
      };
  @Getter
  private static BenchmarksConfiguration config;

  public static void main(final String[] args) throws Exception {
    new BenchmarksRunner().run(args);
  }

  @Override
  public String getName() {
    return "Hive Benchmarks Runner";
  }

  @Override
  public void initialize(final Bootstrap<BenchmarksConfiguration> bootstrap) {
    bootstrap.addBundle(hibernateBundle);
  }

  @Override
  public void run(final BenchmarksConfiguration configuration, final Environment environment) {
    config = configuration;
    initGuiceAndRegisterResourceClasses(environment, configuration);
  }

  private void initGuiceAndRegisterResourceClasses(Environment environment, BenchmarksConfiguration config) {

    injector = Guice.createInjector(new AbstractModule() {
      @Override
      protected void configure() {
        logger.info("Bind all DAO classes and create proxy session factories over them");
        bind(BenchmarksConfiguration.class).toInstance(config);

        bind(SessionFactory.class).toInstance(hibernateBundle.getSessionFactory());

        bind(BaseDao.class).toInstance(
            new UnitOfWorkAwareProxyFactory(hibernateBundle).create(BaseDao.class, SessionFactory.class,
                hibernateBundle.getSessionFactory()));

//        hibernateBundle.getDaoClasses().forEach(cls -> {
//          bind((Class) cls).toInstance(
//              new UnitOfWorkAwareProxyFactory(hibernateBundle).create(cls, SessionFactory.class,
//                  hibernateBundle.getSessionFactory()));
//        }));
      }
    });
    GuiceUtils.initialize(injector);
//    Reflections resourceClasses = new Reflections(resourcesPackage, new SubTypesScanner(false));
//    Set<Class<? extends Object>> allResourceCls = resourceClasses.getSubTypesOf(Object.class);
//    allResourceCls.forEach(cls -> environment.jersey().register(injector.getInstance(cls)));
  }

}
