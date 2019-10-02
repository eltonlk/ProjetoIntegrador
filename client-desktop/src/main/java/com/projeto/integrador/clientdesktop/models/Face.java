package com.projeto.integrador.clientdesktop.models;

import java.util.Collection;

public class Face {

  private Long id;

  private String name;

  private double heatFlow;

  private Room room;

  private Collection<Component> components;

  public Face(Long id, String name, double heatFlow, Room room, Collection<Component> components) {
    this.id = id;
    this.name = name;
    this.heatFlow = heatFlow;
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

  public double getHeatFlow() {
    return heatFlow;
  }

  public void setHeatFlow(double heatFlow) {
    this.heatFlow = heatFlow;
  }

  public double getHeatFlowCalculated() {
    double heatFlow = 0;

    for (Component component : components) {
      heatFlow += component.getHeatFlow();
    }

    return heatFlow;
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
