package com.projeto.integrador.clientdesktop.models;

import java.util.Collection;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Room {

  private Long id;

  private String name;

  @JsonProperty("heat_load")
  private double heatLoad;

  @JsonIgnore
  private Project project;

  @JsonProperty("project_id")
  private Long projectId;

  private Collection<Face> faces;

  public Room(Long id, String name, double heatLoad, Project project, Collection<Face> faces) {
    this.id = id;
    this.name = name;
    this.heatLoad = heatLoad;
    this.project = project;
    if (project != null) { this.projectId = project.getId(); }
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
    if (project != null) { this.projectId = project.getId(); }
    this.project = project;
  }

  public Collection<Face> getFaces() {
    return faces;
  }

  public void setFaces(Collection<Face> faces) {
    this.faces = faces;
  }

}
