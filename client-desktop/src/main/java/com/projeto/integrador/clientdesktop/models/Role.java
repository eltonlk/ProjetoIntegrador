package com.projeto.integrador.clientdesktop.models;

import java.util.Collection;

import com.fasterxml.jackson.annotation.JsonIgnore;

import org.json.simple.JSONObject;

public class Role {

  private Long id;

  private String name;

  private Collection<User> users;

  private Collection<Privilege> privileges;

  @JsonIgnore
  private JSONObject errors;

  public Role(Long id, String name, Collection<Privilege> privileges) {
    this.id = id;
    this.name = name;
    this.privileges = privileges;
  }

  public Role() {
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

  public Collection<User> getUsers() {
    return users;
  }

  public void setUsers(Collection<User> users) {
    this.users = users;
  }

  public Collection<Privilege> getPrivileges() {
    return privileges;
  }

  public void setPrivileges(Collection<Privilege> privileges) {
    this.privileges = privileges;
  }

  public JSONObject getErrors() {
    return errors;
  }

  public void setErrors(JSONObject errors) {
    this.errors = errors;
  }

}
