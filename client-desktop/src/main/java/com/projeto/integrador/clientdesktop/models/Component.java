package com.projeto.integrador.clientdesktop.models;

import java.util.Collection;

public class Component {

  private Long id;

  private String name;

  private double area;

  private double thermalTransmittance;

  private Face face;

  private Color color;

  private Collection<ComponentMaterial> componentMaterials;

  public Component(Long id, String name, double area, Face face, Color color, Collection<ComponentMaterial> componentMaterials) {
    this.id = id;
    this.name = name;
    this.area = area;
    this.face = face;
    this.color = color;
    this.componentMaterials = componentMaterials;
  }

  public Component() {
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

  public double getArea() {
    return area;
  }

  public void setArea(double area) {
    this.area = area;
  }

  public double getThermalTransmittance() {
    return thermalTransmittance;
  }

  public void setThermalTransmittance(double thermalTransmittance) {
    this.thermalTransmittance = thermalTransmittance;
  }

  public Face getFace() {
    return face;
  }

  public void setFace(Face face) {
    this.face = face;
  }

  public Color getColor() {
    return color;
  }

  public void setColor(Color color) {
    this.color = color;
  }

  public Collection<ComponentMaterial> getComponentMaterials() {
    return componentMaterials;
  }

  public void setComponentMaterials(Collection<ComponentMaterial> componentMaterials) {
    this.componentMaterials = componentMaterials;
  }

}
