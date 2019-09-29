package com.projeto.integrador.serverapi.model;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

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

  @NotNull
  private double resistance;

  @ManyToOne
  @JoinColumn(name="component_id", nullable=false)
  private Component component;

  @ManyToOne
  @JoinColumn(name="material_id", nullable=false)
  private Material material;

  public ComponentMaterial(Long id, double width, Component component, Material material) {
    this.id = id;
    this.width = width;
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

  @Override
  public String toString() {
    return "ComponentMaterial{" +
      "id=" + id +
      ", width='" + width + '\'' +
      ", component_id='" + component.getId() + '\'' +
      ", material_id='" + material.getId() + '\'' +
      '}';
  }

}
