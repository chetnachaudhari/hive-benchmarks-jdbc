package com.flipkart.hive.benchmarks.core.dao;

import com.google.common.base.Preconditions;
import io.dropwizard.hibernate.AbstractDAO;
import io.dropwizard.hibernate.UnitOfWork;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;

public class BaseDao<T> extends AbstractDAO<T> {

  public BaseDao(SessionFactory sessionFactory) {
    super(sessionFactory);
  }

  @UnitOfWork
  public T save(T entity) {
    return  saveEntity(entity);

  }

  @UnitOfWork
  public<E > E saveEntity(E entity) throws HibernateException {
    currentSession().saveOrUpdate(Preconditions.checkNotNull(entity));
    return entity;
  }

  @UnitOfWork
  public T get(int id) {
    return super.get(id);
  }

  public Query getQuery(String queryStr)
  {
    return currentSession().createQuery(queryStr);
  }

}
