package com.projeto.integrador.clientdesktop.models;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Color {

  private Long id;

  @NotBlank(message="Nome não pode ficar em branco.")
  private String name;

  @JsonProperty("absorbability_index")
  @DecimalMin(value = "0.1", message = "Absorvidade deve ser maior que zero.")
  private double absorbabilityIndex;

  private boolean active;

  public Color(Long id, String name, double absorbabilityIndex) {
    this.id = id;
    this.name = name;
    this.absorbabilityIndex = absorbabilityIndex;
  }

  public Color() {
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

  public double getAbsorbabilityIndex() {
    return absorbabilityIndex;
  }

  public void setAbsorbabilityIndex(double absorbabilityIndex) {
    this.absorbabilityIndex = absorbabilityIndex;
  }

  public boolean isActive() {
    return active;
  }

  public void setActive(boolean active) {
    this.active = active;
  }

  @Override
  public String toString() {
    return name;
  }

}
