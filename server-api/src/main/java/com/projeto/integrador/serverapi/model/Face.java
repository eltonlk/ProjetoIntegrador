package com.projeto.integrador.serverapi.model;

import java.util.Collection;

import javax.persistence.CascadeType;
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

import com.projeto.integrador.serverapi.model.observer.AuditListener;

@Entity
@EntityListeners(AuditListener.class)
@Table(name = "faces")
public class Face {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotNull
  @NotEmpty
  private String name;

  @NotNull
  private double heatFlow;

  @ManyToOne
  @JoinColumn(name="room_id", nullable=false)
  private Room room;

  @OneToMany(fetch = FetchType.EAGER, mappedBy="face", cascade = CascadeType.ALL)
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

  @Override
  public String toString() {
    return "Face{" +
      "id=" + id +
      ", name='" + name + '\'' +
      ", heat_flow='" + heatFlow + '\'' +
      ", room_id='" + room.getId() + '\'' +
      '}';
  }

}
