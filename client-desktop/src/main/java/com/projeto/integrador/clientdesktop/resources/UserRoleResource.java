package com.projeto.integrador.clientdesktop.resources;

import com.projeto.integrador.clientdesktop.models.UserRole;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserRoleResource {

  final static String NAMESPACE = "/user_roles";

  private RestTemplate restTemplate;

  @Autowired
  public UserRoleResource(RestTemplate restTemplate) {
    this.restTemplate = restTemplate;
  }

  public void update(UserRole userRole) {
    restTemplate.put(NAMESPACE + "/{id}", userRole, userRole.getId());
  }

}
