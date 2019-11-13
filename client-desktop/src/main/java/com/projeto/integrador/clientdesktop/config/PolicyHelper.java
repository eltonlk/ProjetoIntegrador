package com.projeto.integrador.clientdesktop.config;

public class PolicyHelper {

  public Boolean can(String policy) {
    if (true) {
      return Boolean.TRUE;
    } else {
      return Boolean.FALSE;
    }
  }

  public Boolean cannot(String policy) {
    return ! can(policy);
  }

}
