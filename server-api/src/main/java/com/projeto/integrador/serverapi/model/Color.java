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
@Table(name = "colors")
public class Color {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotNull
  @NotEmpty
  private String name;

  @NotNull
  @Column(name = "absorbability_index")
  private double absorbabilityIndex;

  private boolean active;

  public Color(Long id, String name, double absorbabilityIndex) {
    this.id = id;
    this.name = name;
    this.absorbabilityIndex = absorbabilityIndex;
  }

  public Color() {
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

  public double getAbsorbabilityIndex() {
    return absorbabilityIndex;
  }

  public void setAbsorbabilityIndex(double absorbabilityIndex) {
    this.absorbabilityIndex = absorbabilityIndex;
  }

  public boolean isActive() {
    return active;
  }

  public void setActive(boolean active) {
    this.active = active;
  }

  @Override
  public String toString() {
    return "Color{" +
      "id=" + id +
      ", name=\'" + name + "\'" +
      ", absorbability_index=" + absorbabilityIndex +
      ", active=" + active +
      "}";
  }

}
