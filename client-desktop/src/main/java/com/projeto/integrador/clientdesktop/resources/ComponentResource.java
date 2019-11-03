package com.projeto.integrador.clientdesktop.resources;

import com.projeto.integrador.clientdesktop.config.RestTemplateResponseErrorHandler;
import com.projeto.integrador.clientdesktop.models.Component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ComponentResource {

  final static String NAMESPACE = "/components";

  private RestTemplate restTemplate;
  private RestTemplateResponseErrorHandler errorHandler;

  @Autowired
  public ComponentResource(RestTemplate restTemplate) {
    this.restTemplate = restTemplate;
    this.errorHandler = new RestTemplateResponseErrorHandler();

    this.restTemplate.setErrorHandler(errorHandler);
  }

  public Component create(Component component) {
    ResponseEntity<Component> responseEntity = restTemplate.postForEntity(NAMESPACE, component, Component.class);

    if (responseEntity.getStatusCode() == HttpStatus.CREATED) {
      return responseEntity.getBody();
    } else {
      component.setErrors(errorHandler.getErrors());

      return component;
    }
  }

  public void update(Component component) {
    restTemplate.put(NAMESPACE + "/{id}", component, component.getId());

    if (errorHandler.getErrors() != null) {
      component.setErrors(errorHandler.getErrors());
    }
  }

  public void delete(Component component) {
    restTemplate.delete(NAMESPACE + "/{id}", component.getId());

    if (errorHandler.getErrors() != null) {
      component.setErrors(errorHandler.getErrors());
    }
  }

}
