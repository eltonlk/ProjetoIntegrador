package com.projeto.integrador.clientdesktop.models;

public class ComponentMaterial {

  private Long id;

  private double width;

  private double thermalConductitityIndex;

  private double resistance;

  private Component component;

  private Material material;

  public ComponentMaterial(Long id, double width, double thermalConductitityIndex, double resistance, Component component, Material material) {
    this.id = id;
    this.width = width;
    this.thermalConductitityIndex = thermalConductitityIndex;
    this.resistance = resistance;
    this.component = component;
    this.material = material;
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

  public double getThermalConductitityIndex() {
    return thermalConductitityIndex;
  }

  public void setThermalConductitityIndex(double thermalConductitityIndex) {
    this.thermalConductitityIndex = thermalConductitityIndex;
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
    this.component = component;
  }

  public Material getMaterial() {
    return material;
  }

  public void setMaterial(Material material) {
    this.material = material;
  }

}
