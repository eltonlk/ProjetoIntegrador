package com.projeto.integrador.clientdesktop.models;

public class Material {

  private Long id;

  private String name;

  private boolean active;

  private double thermalConductivityIndex;

  public Material(Long id, String name, boolean active, double thermalConductivityIndex) {
    this.id = id;
    this.name = name;
    this.active = active;
    this.thermalConductivityIndex = thermalConductivityIndex;
  }

  public Material() {
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

  public boolean isActive() {
    return active;
  }

  public void setActive(boolean active) {
    this.active = active;
  }

  public double getThermalConductivityIndex() {
    return thermalConductivityIndex;
  }

  public void setThermalConductivityIndex(double thermalConductivityIndex) {
    this.thermalConductivityIndex = thermalConductivityIndex;
  }

  @Override
  public String toString() {
    return name;
  }

}
