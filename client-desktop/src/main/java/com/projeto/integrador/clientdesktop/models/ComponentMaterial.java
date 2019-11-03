package com.projeto.integrador.clientdesktop.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import org.json.simple.JSONObject;

public class ComponentMaterial {

  private Long id;

  private double width;

  @JsonProperty("thermal_conductivity_index")
  private double thermalConductivityIndex;

  @JsonProperty("solar_factor")
  private double solarFactor;

  private double resistance;

  @JsonIgnore
  private Component component;

  @JsonProperty("component_id")
  private Long componentId;

  private Material material;

  @JsonProperty("material_id")
  private Long materialId;

  @JsonIgnore
  private JSONObject errors;

  public ComponentMaterial(Long id, double width, double thermalConductivityIndex, double solarFactor, double resistance, Component component, Material material) {
    this.id = id;
    this.width = width;
    this.thermalConductivityIndex = thermalConductivityIndex;
    this.solarFactor = solarFactor;
    this.resistance = resistance;
    this.component = component;
    if (component != null) { this.componentId = component.getId(); }
    this.material = material;
    if (material != null) { this.materialId = material.getId(); }
  }

  public ComponentMaterial() {
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public double getWidth() {
    return width;
  }

  public void setWidth(double width) {
    this.width = width;
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

  public Component getComponent() {
    return component;
  }

  public void setComponent(Component component) {
    if (component != null) { this.componentId = component.getId(); }
    this.component = component;
  }

  public Material getMaterial() {
    return material;
  }

  public void setMaterial(Material material) {
    if (material != null) { this.materialId = material.getId(); }
    this.material = material;
  }

  public JSONObject getErrors() {
    return errors;
  }

  public void setErrors(JSONObject errors) {
    this.errors = errors;
  }

}
