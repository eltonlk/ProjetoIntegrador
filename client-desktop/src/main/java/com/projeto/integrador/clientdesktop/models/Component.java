package com.projeto.integrador.clientdesktop.models;

import java.util.Collection;

public class Component {

  private Long id;

  private String name;

  private double area;

  private double heatFlow;

  private Face face;

  private Color color;

  private Collection<ComponentMaterial> componentMaterials;

  public Component(Long id, String name, double area, double heatFlow, Face face, Color color, Collection<ComponentMaterial> componentMaterials) {
    this.id = id;
    this.name = name;
    this.area = area;
    this.heatFlow = heatFlow;
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

  public double getHeatFlow() {
    return heatFlow;
  }

  public void setHeatFlow(double heatFlow) {
    this.heatFlow = heatFlow;
  }

  public double getHeatFlowCalculated() {
    double u = getThermalTransmittance();
    double a = color.getAbsorbabilityIndex();
    double i = face.getRoom().getProject().getSolarRadiation().getIndex();
    double rse = 0.04;
    double te = 30; // TODO: get this value from user;
    double ti = 23; // TODO: get this value from user;

    return u * ( a * i * rse + te - ti );
  }

  private double getThermalTransmittance() {
    double thermalTransmittance = getArea() / getResistance();

    return thermalTransmittance;
  }

  private double getResistance() {
    // 0.04 = External Surface Resistance;
    // 0.13 = Internal Surface Resistance; TODO: get this value from user;

    double resistance = 0.04 + 0.13;

    for (ComponentMaterial componentMaterial : componentMaterials) {
      resistance += componentMaterial.getResistance();
    }

    return resistance;
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