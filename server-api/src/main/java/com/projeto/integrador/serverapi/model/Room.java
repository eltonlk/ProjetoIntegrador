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
@Table(name = "rooms")
public class Room {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotNull
  @NotEmpty
  private String name;

  @ManyToOne
  @JoinColumn(name="project_id", nullable=false)
  private Project project;

  public Room(Long id, String name, Project project) {
    this.id = id;
    this.name = name;
    this.project = project;
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

  public Project getProject() {
    return project;
  }

  public void setProject(Project project) {
    this.project = project;
  }

  @Override
  public String toString() {
    return "Room{" +
      "id=" + id +
      ", name='" + name + '\'' +
      ", project_id='" + project.getId() + '\'' +
      '}';
  }

}
