package com.projeto.integrador.clientdesktop.resources;

import com.projeto.integrador.clientdesktop.models.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CurrentUserResource {

  final static String NAMESPACE = "/user";

  private RestTemplate restTemplate;

  @Autowired
  public CurrentUserResource(RestTemplate restTemplate) {
    this.restTemplate = restTemplate;
  }

  public User get() {
    User user = restTemplate.getForObject(NAMESPACE, User.class);

    return user;
  }

}
