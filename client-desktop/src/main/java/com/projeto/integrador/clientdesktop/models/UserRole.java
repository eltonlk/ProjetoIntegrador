package com.projeto.integrador.clientdesktop.models;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class UserRole {

  private Long id;

  private Long userId;

  private Long roleId;

  private Long Privilegeid;

  private boolean enable;

  private Role role;

  private Privilege privilege;

  public UserRole() {
  }

  public UserRole(Long id, Long userId, Long roleId, Long privilegeid, boolean enable) {
    this.id = id;
    this.userId = userId;
    this.roleId = roleId;
    Privilegeid = privilegeid;
    this.enable = enable;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getUserId() {
    return userId;
  }

  public void setUserId(Long userId) {
    this.userId = userId;
  }

  public Long getRoleId() {
    return roleId;
  }

  public void setRoleId(Long roleId) {
    this.roleId = roleId;
  }

  public Long getPrivilegeid() {
    return Privilegeid;
  }

  public void setPrivilegeid(Long privilegeid) {
    Privilegeid = privilegeid;
  }

  public boolean isEnable() {
    return enable;
  }

  public void setEnable(boolean enable) {
    this.enable = enable;
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

}
