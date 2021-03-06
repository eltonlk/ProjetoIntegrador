package com.projeto.integrador.serverapi.model;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.projeto.integrador.serverapi.model.observer.AuditListener;
import com.projeto.integrador.serverapi.serializer.ComponentSerializer;

@Entity
@EntityListeners(AuditListener.class)
@JsonSerialize(using = ComponentSerializer.class)
@Table(name = "components")
public class Component {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotNull
  @NotEmpty
  private String name;

  @NotNull
  private double area;

  @NotNull
  @Column(name = "heat_flow")
  private double heatFlow;

  @ManyToOne
  @JoinColumn(name="face_id", nullable=false)
  private Face face;

  @ManyToOne
  @JoinColumn(name="color_id", nullable=false)
  private Color color;

  @OneToMany(fetch = FetchType.EAGER, mappedBy="component", cascade = CascadeType.ALL)
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

  @Override
  public String toString() {
    return "Component{" +
      "id=" + id +
      ", name=\'" + name + "\'" +
      ", area=" + area +
      ", heat_flow=" + heatFlow +
      ", face_id=" + face.getId() +
      ", color_id=" + color.getId() +
      "}";
  }

}
