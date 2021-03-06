package com.projeto.integrador.clientdesktop.models;

public class Option {

  private Long id;

  private String name;

  private String value;

  public Option(Long id, String name, String value) {
    this.id = id;
    this.name = name;
    this.value = value;
  }

  public Option() {
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

  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }

}
