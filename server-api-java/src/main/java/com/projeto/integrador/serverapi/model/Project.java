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
import com.projeto.integrador.serverapi.serializer.ProjectSerializer;

@Entity
@EntityListeners(AuditListener.class)
@JsonSerialize(using = ProjectSerializer.class)
@Table(name = "projects")
public class Project {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotNull
  @NotEmpty
  private String name;

  @NotNull
  @NotEmpty
  private String season;

  @NotNull
  @Column(name = "external_temperature")
  private int externalTemperature;

  @NotNull
  @Column(name = "internal_temperature")
  private int internalTemperature;

  @NotNull
  @ManyToOne
  @JoinColumn(name="solar_radiation_id", nullable=false)
  private SolarRadiation solarRadiation;

  @OneToMany(fetch = FetchType.EAGER, mappedBy="project", cascade = CascadeType.ALL)
  private Collection<Room> rooms;

  public Project(Long id, String name, String season, int externalTemperature, int internalTemperature, SolarRadiation solarRadiation, Collection<Room> rooms) {
    this.id = id;
    this.name = name;
    this.season = season;
    this.externalTemperature = externalTemperature;
    this.internalTemperature = internalTemperature;
    this.rooms = rooms;
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

  public String getSeason() {
    return season;
  }

  public void setSeason(String season) {
    this.season = season;
  }

  public int getExternalTemperature() {
    return externalTemperature;
  }

  public void setExternalTemperature(int externalTemperature) {
    this.externalTemperature = externalTemperature;
  }

  public int getInternalTemperature() {
    return internalTemperature;
  }

  public void setInternalTemperature(int internalTemperature) {
    this.internalTemperature = internalTemperature;
  }

  public SolarRadiation getSolarRadiation() {
    return solarRadiation;
  }

  public void setSolarRadiation(SolarRadiation solarRadiation) {
    this.solarRadiation = solarRadiation;
  }

  public Collection<Room> getRooms() {
    return rooms;
  }

  public void setRooms(Collection<Room> rooms) {
    this.rooms = rooms;
  }

  @Override
  public String toString() {
    return "Project{" +
      "id=" + id +
      ", name=\'" + name + "\'" +
      ", season=\'" + season + "\'" +
      ", external_temperature=" + externalTemperature +
      ", internal_temperature=" + internalTemperature +
      ", solar_radiation_id=" + solarRadiation.getId() +
      "}";
  }

}
