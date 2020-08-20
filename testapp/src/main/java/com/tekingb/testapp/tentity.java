package com.tekingb.testapp;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZonedDateTime;
import java.util.UUID;

@Entity
@Table(name = "tentity")
public class tentity implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private UUID id;

  @Column(name = "name")
  private String name;

  @Column(name = "lifecycle")
  private Integer lifeCycle;

  @Column(name = "code")
  private Integer code;

  @Column(name = "modifiedDatetime", columnDefinition = "TIMESTAMP WITH TIME ZONE")
  private OffsetDateTime modifiedDatetime;

  @Column(name = "createdDatetime", columnDefinition = "TIMESTAMP WITH TIME ZONE")
  private ZonedDateTime createdDatetime;

  @Column(name = "localDatetime")
  private LocalDateTime localDatetime;

  @Column(name = "localDate", columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
  private LocalDate localDate;

  @Column(name = "published", columnDefinition = "BOOLEAN")
  private Boolean published;

  @Column(name = "quantity")
  private Long quantity;

  @Column(name = "price")
  private BigDecimal price;

  @Column(name = "quantityDouble", columnDefinition = "DOUBLE PRECISION")
  private Double quantityDouble;

  @ManyToOne private tutorial tutorial;

  @Column(name = "tid")
  private UUID tid;

  public tentity(
      Integer code,
      String name,
      Integer lifeCycle,
      OffsetDateTime modifiedDatetime,
      ZonedDateTime createdDatetime,
      LocalDateTime localDatetime,
      LocalDate localDate,
      Boolean published,
      Long quantity,
      BigDecimal price,
      Double quantityDouble,
      tutorial tutorial,
      UUID tid) {
    this.code = code;
    this.name = name;
    this.lifeCycle = lifeCycle;
    this.modifiedDatetime = modifiedDatetime;
    this.createdDatetime = createdDatetime;
    this.localDatetime = localDatetime;
    this.localDate = localDate;
    this.published = published;
    this.quantity = quantity;
    this.price = price;
    this.quantityDouble = quantityDouble;
    this.tutorial = tutorial;
    this.tid = tid;
  }

  public static long getSerialVersionUID() {
    return serialVersionUID;
  }

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Integer getLifeCycle() {
    return lifeCycle;
  }

  public void setLifeCycle(Integer lifeCycle) {
    this.lifeCycle = lifeCycle;
  }

  public OffsetDateTime getModifiedDatetime() {
    return modifiedDatetime;
  }

  public void setModifiedDatetime(OffsetDateTime modifiedDatetime) {
    this.modifiedDatetime = modifiedDatetime;
  }

  public ZonedDateTime getCreatedDatetime() {
    return createdDatetime;
  }

  public void setCreatedDatetime(ZonedDateTime createdDatetime) {
    this.createdDatetime = createdDatetime;
  }

  public LocalDateTime getLocalDatetime() {
    return localDatetime;
  }

  public void setLocalDatetime(LocalDateTime localDatetime) {
    this.localDatetime = localDatetime;
  }

  public LocalDate getLocalDate() {
    return localDate;
  }

  public void setLocalDate(LocalDate localDate) {
    this.localDate = localDate;
  }

  public Boolean getPublished() {
    return published;
  }

  public void setPublished(Boolean published) {
    this.published = published;
  }

  public Long getQuantity() {
    return quantity;
  }

  public void setQuantity(Long quantity) {
    this.quantity = quantity;
  }

  public BigDecimal getPrice() {
    return price;
  }

  public void setPrice(BigDecimal price) {
    this.price = price;
  }

  public Double getQuantityDouble() {
    return quantityDouble;
  }

  public void setQuantityDouble(Double quantityDouble) {
    this.quantityDouble = quantityDouble;
  }

  public tutorial getTutorial() {
    return tutorial;
  }

  public void setTutorial(tutorial tutorial) {
    this.tutorial = tutorial;
  }

  public UUID getTid() {
    return tid;
  }

  public void setTid(UUID tid) {
    this.tid = tid;
  }

  public Integer getCode() {
    return code;
  }

  public void setCode(Integer code) {
    this.code = code;
  }
}
