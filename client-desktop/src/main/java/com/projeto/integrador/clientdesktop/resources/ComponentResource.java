package com.projeto.integrador.clientdesktop.resources;

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

  @Autowired
  public ComponentResource(RestTemplate restTemplate) {
    this.restTemplate = restTemplate;
  }

  public Component create(Component component) {
    ResponseEntity<Component> responseEntity = restTemplate.postForEntity(NAMESPACE, component, Component.class);

    Component createdComponent = null;

    if (responseEntity.getStatusCode() == HttpStatus.CREATED) {
      createdComponent = responseEntity.getBody();
    }

    return createdComponent;
  }

  public void update(Component component) {
    restTemplate.put(NAMESPACE + "/{id}", component, component.getId());
  }

  public void delete(Component component) {
    restTemplate.delete(NAMESPACE + "/{id}", component.getId());
  }

}
