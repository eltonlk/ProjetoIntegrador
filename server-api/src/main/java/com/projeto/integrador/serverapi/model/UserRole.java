package com.projeto.integrador.serverapi.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import com.projeto.integrador.serverapi.serializer.UserRoleSerializer;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@JsonSerialize(using = UserRoleSerializer.class)
@Table(name = "user_roles")
public class UserRole {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @ManyToOne
  @JoinColumn(name="user_id", nullable=false)
  private User user;

  @ManyToOne
  @JoinColumn(name="role_id", nullable=false)
  private Role role;

  @ManyToOne
  @JoinColumn(name="privilege_id", nullable=false)
  private Privilege privilege;

  private boolean enable;

  public UserRole(Long id, User user, Role role, Privilege privilege, boolean enable) {
    this.id = id;
    this.user = user;
    this.role = role;
    this.privilege = privilege;
    this.enable = enable;
  }

  public UserRole() {
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public Role getRole() {
    return role;
  }

  public void setRole(Role role) {
    this.role = role;
  }

  public Privilege getPrivilege() {
    return privilege;
  }

  public void setPrivilege(Privilege privilege) {
    this.privilege = privilege;
  }

  public boolean isEnable() {
    return enable;
  }

  public void setEnable(boolean enable) {
    this.enable = enable;
  }

}
