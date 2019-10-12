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

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.projeto.integrador.serverapi.model.observer.AuditListener;
import com.projeto.integrador.serverapi.serializer.RoomSerializer;

@Entity
@EntityListeners(AuditListener.class)
@JsonSerialize(using = RoomSerializer.class)
@Table(name = "rooms")
public class Room {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotNull
  @NotEmpty
  private String name;

  @NotNull
  private double heatLoad;

  @ManyToOne
  @JoinColumn(name="project_id", nullable=false)
  private Project project;

  @OneToMany(fetch = FetchType.EAGER, mappedBy="room", cascade = CascadeType.ALL)
  private Collection<Face> faces;

  public Room(Long id, String name, double heatLoad, Project project, Collection<Face> faces) {
    this.id = id;
    this.name = name;
    this.heatLoad = heatLoad;
    this.project = project;
    this.faces = faces;
  }

  public Room() {
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

  public Project getProject() {
    return project;
  }

  public void setProject(Project project) {
    this.project = project;
  }

  public Collection<Face> getFaces() {
    return faces;
  }

  public void setFaces(Collection<Face> faces) {
    this.faces = faces;
  }

  @Override
  public String toString() {
    return "Room{" +
      "id=" + id +
      ", name='" + name + '\'' +
      ", heat_load='" + heatLoad + '\'' +
      ", project_id='" + project.getId() + '\'' +
      '}';
  }

}
