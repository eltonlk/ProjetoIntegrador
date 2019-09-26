package com.projeto.integrador.serverapi.model;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.projeto.integrador.serverapi.model.observer.AuditListener;

@Entity
@EntityListeners(AuditListener.class)
@Table(name = "component_materials")
public class ComponentMaterial {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotNull
  private double width;

  @NotNull
  private double thermalConductitityIndex;

  @ManyToOne
  @JoinColumn(name="component_id", nullable=false)
  private Component component;

  @ManyToOne
  @JoinColumn(name="material_id", nullable=false)
  private Material material;

  public ComponentMaterial(Long id, double width, Face face, Color color) {
    this.id = id;
    this.name = name;
    this.area = area;
    this.face = face;
    this.color = color;
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

  @Override
  public String toString() {
    return "Component{" +
      "id=" + id +
      ", name='" + name + '\'' +
      ", area='" + area + '\'' +
      ", face_id='" + face.getId() + '\'' +
      ", color_id='" + color.getId() + '\'' +
      '}';
  }

}
