package com.projeto.integrador.clientdesktop.models;

import java.util.Collection;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Project {

  private Long id;

  private String name;

  private String season;

  @JsonProperty("external_temperature")
  private int externalTemperature;

  @JsonProperty("internal_temperature")
  private int internalTemperature;

  @JsonProperty("solar_radiation")
  private SolarRadiation solarRadiation;

  private Collection<Room> rooms;

  public Project(Long id, String name, String season, int externalTemperature, int internalTemperature, SolarRadiation solarRadiation, Collection<Room> rooms) {
    this.id = id;
    this.name = name;
    this.season = season;
    this.externalTemperature = externalTemperature;
    this.internalTemperature = internalTemperature;
    this.solarRadiation = solarRadiation;
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

}
