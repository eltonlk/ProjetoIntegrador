package com.projeto.integrador.clientdesktop.models;

import java.util.Collection;

public class Project {

  private Long id;

  private String name;

  private SolarRadiation solarRadiation;

  private Collection<Room> rooms;

  public Project(Long id, String name, SolarRadiation solarRadiation, Collection<Room> rooms) {
    this.id = id;
    this.name = name;
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
