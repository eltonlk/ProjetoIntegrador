package com.projeto.integrador.clientdesktop.models;

import java.util.Collection;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Component {

  private Long id;

  private String name;

  private double area;

  @JsonProperty("heat_flow")
  private double heatFlow;

  @JsonIgnore
  private Face face;

  @JsonProperty("face_id")
  private Long faceId;

  private Color color;

  @JsonProperty("color_id")
  private Long colorId;

  @JsonProperty("component_materials")
  private Collection<ComponentMaterial> componentMaterials;

  public Component(Long id, String name, double area, double heatFlow, Face face, Color color, Collection<ComponentMaterial> componentMaterials) {
    this.id = id;
    this.name = name;
    this.area = area;
    this.heatFlow = heatFlow;
    this.face = face;
    if (face != null) { this.faceId = face.getId(); }
    this.color = color;
    if (color != null) { this.colorId = color.getId(); }
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

  public Face getFace() {
    return face;
  }

  public void setFace(Face face) {
    if (face != null) { this.faceId = face.getId(); }
    this.face = face;
  }

  public Color getColor() {
    return color;
  }

  public void setColor(Color color) {
    if (color == null) {
      this.colorId = null;
    } else {
      this.colorId = color.getId();
    }

    this.color = color;
  }

  public Collection<ComponentMaterial> getComponentMaterials() {
    return componentMaterials;
  }

  public void setComponentMaterials(Collection<ComponentMaterial> componentMaterials) {
    this.componentMaterials = componentMaterials;
  }

}
