package com.projeto.integrador.clientdesktop.models;

import java.util.Collection;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Face {

  private Long id;

  private String name;

  private String orientation;

  @JsonProperty("heat_flow")
  private double heatFlow;

  @JsonIgnore
  private Room room;

  @JsonProperty("room_id")
  private Long roomId;

  private Collection<Component> components;

  public Face(Long id, String name, String orientation, double heatFlow, Room room, Collection<Component> components) {
    this.id = id;
    this.name = name;
    this.orientation = orientation;
    this.heatFlow = heatFlow;
    this.room = room;
    if (room != null) { this.roomId = room.getId(); }
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

  public String getOrientation() {
    return orientation;
  }

  public void setOrientation(String orientation) {
    this.orientation = orientation;
  }

  public double getHeatFlow() {
    return heatFlow;
  }

  public void setHeatFlow(double heatFlow) {
    this.heatFlow = heatFlow;
  }

  public Room getRoom() {
    return room;
  }

  public void setRoom(Room room) {
    if (room != null) { this.roomId = room.getId(); }
    this.room = room;
  }

  public Collection<Component> getComponents() {
    return components;
  }

  public void setComponents(Collection<Component> components) {
    this.components = components;
  }

}
