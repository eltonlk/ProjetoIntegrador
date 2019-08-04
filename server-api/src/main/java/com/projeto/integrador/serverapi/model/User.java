package com.projeto.integrador.serverapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "users")
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String login;
  private String name;

  public Long getId() {
    return id;
  }

  public String getLogin() {
    return login;
  }

  public String getName() {
    return name;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public void setLogin(String login) {
    this.login = login;
  }

  public void setName(String name) {
    this.name = name;
  }

}
