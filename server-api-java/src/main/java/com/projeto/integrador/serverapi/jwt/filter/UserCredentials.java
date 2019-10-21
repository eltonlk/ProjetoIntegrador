package com.projeto.integrador.serverapi.jwt.filter;

public class UserCredentials {

  private String username;
  private String password;

  public UserCredentials(String username, String password) {
    this.username = username;
    this.password = password;
  }

  public UserCredentials() {
  }

  public String getPassword() {
    return password;
  }

  public String getUsername() {
    return username;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public void setUsername(String username) {
    this.username = username;
  }

}
