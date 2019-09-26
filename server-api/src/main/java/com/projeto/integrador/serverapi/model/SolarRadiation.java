package com.projeto.integrador.serverapi.model;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.projeto.integrador.serverapi.model.observer.AuditListener;

@Entity
@EntityListeners(AuditListener.class)
@Table(name = "solar_radiations")
public class SolarRadiation {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotNull
  @NotEmpty
  private String name;

  @NotNull
  private double index;

  public SolarRadiation(Long id, String name, double index) {
    this.id = id;
    this.name = name;
    this.index = index;
  }

  public SolarRadiation() {
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public double getIndex() {
    return index;
  }

  public void setIndex(double index) {
    this.index = index;
  }

  @Override
  public String toString() {
    return "SolarRadiation{" +
      "id=" + id +
      ", name='" + name + '\'' +
      ", index='" + index + '\'' +
      '}';
  }

}
