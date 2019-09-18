package com.projeto.integrador.serverapi.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import com.projeto.integrador.serverapi.serializer.PrivilegeSerializer;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@JsonSerialize(using = PrivilegeSerializer.class)
@Table(name = "privileges")
public class Privilege {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @NotNull
  @NotEmpty
  private String name;

  // @ManyToMany(mappedBy = "privileges")
  // private Collection<Role> roles;

  public Privilege(Long id, String name) {
    this.id = id;
    this.name = name;
  }

  public Privilege() {
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

  // public Collection<Role> getRoles() {
  //   return roles;
  // }

  // public void setRoles(Collection<Role> roles) {
  //   this.roles = roles;
  // }

}
