package com.projeto.integrador.clientdesktop.models;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Audit {

  private Long id;

  @JsonProperty("auditable_type")
  private String auditableType;

  @JsonProperty("audited_changes")
  private String auditedChanges;

  private String username;

  @JsonProperty("created_at")
  private Date modifiedDate;

  private String action;

  public Audit(Long id, String auditableType, String auditedChanges, String username, Date modifiedDate, String action) {
    this.id = id;
    this.auditableType = auditableType;
    this.auditedChanges = auditedChanges;
    this.username = username;
    this.modifiedDate = modifiedDate;
    this.action = action;
  }

  public Audit() {
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getAuditableType() {
    return this.auditableType;
  }

  public void setAuditableType(String auditableType) {
    this.auditableType = auditableType;
  }

  public String getAuditedChanges() {
    return auditedChanges;
  }

  public void setAuditedChanges(String auditedChanges) {
    this.auditedChanges = auditedChanges;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public Date getModifiedDate() {
    return modifiedDate;
  }

  public void setModifiedDate(Date modifiedDate) {
    this.modifiedDate = modifiedDate;
  }

  public String getAction() {
    return action;
  }

  public void setAction(String action) {
    this.action = action;
  }

}
