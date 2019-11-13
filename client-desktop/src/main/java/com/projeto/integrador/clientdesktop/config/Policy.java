package com.projeto.integrador.clientdesktop.config;

import org.springframework.stereotype.Service;

@Service
public class Policy {

  public Boolean can() {

    // (String authority)

    return false;
  }

  public Boolean cannot() {
    return ! can();
  }

}
