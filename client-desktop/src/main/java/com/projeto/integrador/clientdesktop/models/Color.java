package com.projeto.integrador.clientdesktop.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import org.json.simple.JSONObject;


public class Color {

  private Long id;

  private String name;

  @JsonProperty("absorbability_index")
  private double absorbabilityIndex;

  private boolean active;

  @JsonIgnore
  private JSONObject errors;

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

  public JSONObject getErrors() {
    return errors;
  }

  public void setErrors(JSONObject errors) {
    this.errors = errors;
  }

  @Override
  public String toString() {
    return name;
  }
}
