package com.projeto.integrador.clientdesktop.resources;

import com.projeto.integrador.clientdesktop.models.ComponentMaterial;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ComponentMaterialResource {

  final static String NAMESPACE = "/component_materials";

  private RestTemplate restTemplate;

  @Autowired
  public ComponentMaterialResource(RestTemplate restTemplate) {
    this.restTemplate = restTemplate;
  }

  public ComponentMaterial create(ComponentMaterial componentMaterial) {
    ResponseEntity<ComponentMaterial> responseEntity = restTemplate.postForEntity(NAMESPACE, componentMaterial, ComponentMaterial.class);

    ComponentMaterial createdComponentMaterial = null;

    if (responseEntity.getStatusCode() == HttpStatus.CREATED) {
      createdComponentMaterial = responseEntity.getBody();
    }

    return createdComponentMaterial;
  }

  public void update(ComponentMaterial componentMaterial) {
    restTemplate.put(NAMESPACE + "/{id}", componentMaterial, componentMaterial.getId());
  }

  public void delete(ComponentMaterial componentMaterial) {
    restTemplate.delete(NAMESPACE + "/{id}", componentMaterial.getId());
  }

}
