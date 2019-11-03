package com.projeto.integrador.clientdesktop.models;

import java.util.Collection;

import com.fasterxml.jackson.annotation.JsonIgnore;

import org.json.simple.JSONObject;

public class User {

  private Long id;

  private String name;

  private String email;

  private String username;

  private String password;

  private boolean active;

  private Collection<UserRole> roles;

  @JsonIgnore
  private JSONObject errors;

  public User(Long id, String name, String email, String username, String password, boolean active, Collection<UserRole> roles) {
    this.id = id;
    this.name = name;
    this.email = email;
    this.username = username;
    this.password = password;
    this.active = active;
    this.roles = roles;
  }

  public User(Long id, String name, String email, String username) {
    this.id = id;
    this.name = name;
    this.email = email;
    this.username = username;
  }

  public User() {
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

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public boolean isActive() {
    return active;
  }

  public void setActive(boolean active) {
    this.active = active;
  }

  public Collection<UserRole> getRoles() {
    return roles;
  }

  public void setRoles(Collection<UserRole> roles) {
    this.roles = roles;
  }

  public JSONObject getErrors() {
    return errors;
  }

  public void setErrors(JSONObject errors) {
    this.errors = errors;
  }

}
