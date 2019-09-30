package com.projeto.integrador.clientdesktop.models;

import java.util.Collection;

public class Face {

  private Long id;

  private String name;

  private double heatLoad;

  private Room room;

  private Collection<Component> components;

  public Face(Long id, String name, Room room, Collection<Component> components) {
    this.id = id;
    this.name = name;
    this.room = room;
    this.components = components;
  }

  public Face() {
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

  public double getHeatLoad() {
    return heatLoad;
  }

  public void setHeatLoad(double heatLoad) {
    this.heatLoad = heatLoad;
  }

  public Room getRoom() {
    return room;
  }

  public void setRoom(Room room) {
    this.room = room;
  }

  public Collection<Component> getComponents() {
    return components;
  }

  public void setComponents(Collection<Component> components) {
    this.components = components;
  }

}
