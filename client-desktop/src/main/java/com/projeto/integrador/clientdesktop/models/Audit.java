package com.projeto.integrador.clientdesktop.models;

import java.util.Date;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import org.json.simple.JSONObject;

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class Audit {

  private Long id;

  private Long auditableId;

  private String auditableType;

  private Long associatedId;

  private String associatedType;

  private Long userId;

  private String userType;

  private String username;

  private String action;

  private JSONObject auditedChanges;

  private Long version;

  private String comment;

  private String remoteAddress;

  private String requestUuid;

  private Date createdAt;

  public Audit(Long id, Long auditableId, String auditableType, Long associatedId, String associatedType, Long userId,
    String userType, String username, String action, JSONObject auditedChanges, Long version, String comment,
    String remoteAddress, String requestUuid, Date createdAt) {

    this.id = id;
    this.auditableId = auditableId;
    this.auditableType = auditableType;
    this.associatedId = associatedId;
    this.associatedType = associatedType;
    this.userId = userId;
    this.userType = userType;
    this.username = username;
    this.action = action;
    this.auditedChanges = auditedChanges;
    this.version = version;
    this.comment = comment;
    this.remoteAddress = remoteAddress;
    this.requestUuid = requestUuid;
    this.createdAt = createdAt;
  }

  public Audit() {
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getAuditableId() {
    return auditableId;
  }

  public void setAuditableId(Long auditableId) {
    this.auditableId = auditableId;
  }

  public String getAuditableType() {
    return auditableType;
  }

  public void setAuditableType(String auditableType) {
    this.auditableType = auditableType;
  }

  public Long getAssociatedId() {
    return associatedId;
  }

  public void setAssociatedId(Long associatedId) {
    this.associatedId = associatedId;
  }

  public String getAssociatedType() {
    return associatedType;
  }

  public void setAssociatedType(String associatedType) {
    this.associatedType = associatedType;
  }

  public Long getUserId() {
    return userId;
  }

  public void setUserId(Long userId) {
    this.userId = userId;
  }

  public String getUserType() {
    return userType;
  }

  public void setUserType(String userType) {
    this.userType = userType;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getAction() {
    return action;
  }

  public void setAction(String action) {
    this.action = action;
  }

  public JSONObject getAuditedChanges() {
    return auditedChanges;
  }

  public void setAuditedChanges(JSONObject auditedChanges) {
    this.auditedChanges = auditedChanges;
  }

  public Long getVersion() {
    return version;
  }

  public void setVersion(Long version) {
    this.version = version;
  }

  public String getComment() {
    return comment;
  }

  public void setComment(String comment) {
    this.comment = comment;
  }

  public String getRemoteAddress() {
    return remoteAddress;
  }

  public void setRemoteAddress(String remoteAddress) {
    this.remoteAddress = remoteAddress;
  }

  public String getRequestUuid() {
    return requestUuid;
  }

  public void setRequestUuid(String requestUuid) {
    this.requestUuid = requestUuid;
  }

  public Date getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(Date createdAt) {
    this.createdAt = createdAt;
  }

}
