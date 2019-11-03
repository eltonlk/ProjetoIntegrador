package com.projeto.integrador.clientdesktop.resources;

import com.projeto.integrador.clientdesktop.config.RestTemplateResponseErrorHandler;
import com.projeto.integrador.clientdesktop.models.UserRole;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserRoleResource {

  final static String NAMESPACE = "/user_roles";

  private RestTemplate restTemplate;
  private RestTemplateResponseErrorHandler errorHandler;

  @Autowired
  public UserRoleResource(RestTemplate restTemplate) {
    this.restTemplate = restTemplate;
    this.errorHandler = new RestTemplateResponseErrorHandler();

    this.restTemplate.setErrorHandler(errorHandler);
  }

  public void update(UserRole userRole) {
    restTemplate.put(NAMESPACE + "/{id}", userRole, userRole.getId());

    if (errorHandler.getErrors() != null) {
      userRole.setErrors(errorHandler.getErrors());
    }
  }

}
