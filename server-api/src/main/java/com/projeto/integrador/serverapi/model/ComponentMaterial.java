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

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.projeto.integrador.serverapi.model.observer.AuditListener;
import com.projeto.integrador.serverapi.serializer.ComponentMaterialSerializer;

@Entity
@EntityListeners(AuditListener.class)
@JsonSerialize(using = ComponentMaterialSerializer.class)
@Table(name = "component_materials")
public class ComponentMaterial {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotNull
  private double width;

  @NotNull
  private double thermalConductivityIndex;

  @NotNull
  private double resistance;

  @ManyToOne
  @JoinColumn(name="component_id", nullable=false)
  private Component component;

  @ManyToOne
  @JoinColumn(name="material_id", nullable=false)
  private Material material;

  public ComponentMaterial(Long id, double width, double resistance, Component component, Material material) {
    this.id = id;
    this.width = width;
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

  public double getThermalConductivityIndex() {
    return thermalConductivityIndex;
  }

  public void setThermalConductivityIndex(double thermalConductivityIndex) {
    this.thermalConductivityIndex = thermalConductivityIndex;
  }

  public double getResistance() {
    return resistance;
  }

  public void setResistance(double resistance) {
    this.resistance = resistance;
  }

  public double setResistanceCalculated() {
    return getWidth() / getThermalConductivityIndex();
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
