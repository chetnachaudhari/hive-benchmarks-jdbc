package com.flipkart.hive.benchmarks.core.entities;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.util.Date;

@MappedSuperclass
@Data
public class BaseEntity {

  @CreationTimestamp
  private Date createdAt;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

}
