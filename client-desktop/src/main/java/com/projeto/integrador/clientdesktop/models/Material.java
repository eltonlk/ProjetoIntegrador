package com.projeto.integrador.clientdesktop.models;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Material {

  private Long id;

  @NotBlank(message="Nome não pode ficar em branco.")
  private String name;

  @NotBlank(message="Tipo de Material não pode ficar em branco.")
  private String kind;

  private boolean active;

  @JsonProperty("thermal_conductivity_index")
  private double thermalConductivityIndex;

  @JsonProperty("solar_factor")
  private double solarFactor;

  private double resistance;

  public Material(Long id, String name, String kind, boolean active, double thermalConductivityIndex, double solarFactor, double resistance) {
    this.id = id;
    this.name = name;
    this.kind = kind;
    this.active = active;
    this.thermalConductivityIndex = thermalConductivityIndex;
    this.solarFactor = solarFactor;
    this.resistance = resistance;
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

  public String getKind() {
    return kind;
  }

  public void setKind(String kind) {
    this.kind = kind;
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

  public double getSolarFactor() {
    return solarFactor;
  }

  public void setSolarFactor(double solarFactor) {
    this.solarFactor = solarFactor;
  }

  public double getResistance() {
    return resistance;
  }

  public void setResistance(double resistance) {
    this.resistance = resistance;
  }

  @Override
  public String toString() {
    return name;
  }

}
