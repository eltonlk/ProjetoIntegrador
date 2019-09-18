package com.projeto.integrador.clientdesktop.models;

public class TokenCredential {

  private String token;

  public TokenCredential(String token) {
    this.token = token;
  }

  public TokenCredential() {
  }

  public String getToken() {
    return token;
  }

  public void setToken(String token) {
    this.token = token;
  }

}
