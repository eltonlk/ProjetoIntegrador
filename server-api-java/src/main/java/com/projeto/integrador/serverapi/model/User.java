package com.projeto.integrador.serverapi.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import com.projeto.integrador.serverapi.serializer.UserSerializer;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@JsonSerialize(using = UserSerializer.class)
@Table(name = "users")
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotNull
  @NotEmpty
  private String name;

  @NotNull
  @NotEmpty
  private String email;

  @NotNull
  @NotEmpty
  private String username;

  @NotNull
  @NotEmpty
  private String password;

  private boolean active;

  @OneToMany(fetch = FetchType.EAGER, mappedBy="user", cascade = CascadeType.ALL)
  private Collection<UserRole> userRoles;

  public User(Long id, String name, String email, String username, String password, boolean active, Collection<UserRole> userRoles) {
    this.id = id;
    this.name = name;
    this.email = email;
    this.username = username;
    this.password = password;
    this.active = active;
    this.userRoles = userRoles;
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

  public Collection<UserRole> getUserRoles() {
    return userRoles;
  }

  public void setUserRoles(Collection<UserRole> userRoles) {
    this.userRoles = userRoles;
  }

}
