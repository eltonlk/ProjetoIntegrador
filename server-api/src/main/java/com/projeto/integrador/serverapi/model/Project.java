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
@Table(name = "projects")
public class Project {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotNull
  @NotEmpty
  private String name;

  @ManyToOne
  @JoinColumn(name="solar_radiation_id", nullable=false)
  private SolarRadiation solarRadiation;

  public Project(Long id, String name, SolarRadiation solarRadiation) {
    this.id = id;
    this.name = name;
    this.solarRadiation = solarRadiation;
  }

  public Project() {
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

  public SolarRadiation getSolarRadiation() {
    return solarRadiation;
  }

  public void setSolarRadiation(SolarRadiation solarRadiation) {
    this.solarRadiation = solarRadiation;
  }

  @Override
  public String toString() {
    return "Project{" +
      "id=" + id +
      ", name='" + name + '\'' +
      ", solar_radiation_id='" + solarRadiation.getId() + '\'' +
      '}';
  }

}
