package com.projeto.integrador.clientdesktop.models;

import java.util.Date;

public class Audit {

  private Long id;

  private String content;

  private String modifiedBy;

  private Date modifiedDate;

  private String action;

  public Audit(Long id, String content, String modifiedBy, Date modifiedDate, String action) {
    this.id = id;
    this.content = content;
    this.modifiedBy = modifiedBy;
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

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public String getModifiedBy() {
    return modifiedBy;
  }

  public void setModifiedBy(String modifiedBy) {
    this.modifiedBy = modifiedBy;
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
