package com.projeto.integrador.serverapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.projeto.integrador.serverapi.model.observer.AuditListener;

@Entity
@EntityListeners(AuditListener.class)
@Table(name = "materials")
public class Material {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotNull
  @NotEmpty
  private String name;

  private boolean active;

  @NotNull
  @Column(name = "thermal_conductivity_index")
  private double thermalConductivityIndex;

  public Material(Long id, String name, boolean active, double thermalConductivityIndex) {
    this.id = id;
    this.name = name;
    this.active = active;
    this.thermalConductivityIndex = thermalConductivityIndex;
  }

  public Material() {
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

  public boolean isActive() {
    return active;
  }

  public void setActive(boolean active) {
    this.active = active;
  }

  public double getThermalConductivityIndex() {
    return thermalConductivityIndex;
  }

  public void setThermalConductivityIndex(double thermalConductivityIndex) {
    this.thermalConductivityIndex = thermalConductivityIndex;
  }

  @Override
  public String toString() {
    return "Material{" +
      "id=" + id +
      ", name=\'" + name + "\'" +
      ", active=" + active +
      ", thermal_conductivity_index=" + thermalConductivityIndex +
      "}";
  }

}
