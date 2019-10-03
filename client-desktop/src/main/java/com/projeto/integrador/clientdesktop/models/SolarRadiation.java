package com.projeto.integrador.clientdesktop.models;

public class SolarRadiation {

  private Long id;

  private String name;

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
    return name;
  }

}
