package com.projeto.integrador.clientdesktop.resources;

import com.projeto.integrador.clientdesktop.config.RestTemplateResponseErrorHandler;
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
  private RestTemplateResponseErrorHandler errorHandler;

  @Autowired
  public ComponentMaterialResource(RestTemplate restTemplate) {
    this.restTemplate = restTemplate;
    this.errorHandler = new RestTemplateResponseErrorHandler();

    this.restTemplate.setErrorHandler(errorHandler);
  }

  public ComponentMaterial create(ComponentMaterial componentMaterial) {
    ResponseEntity<ComponentMaterial> responseEntity = restTemplate.postForEntity(NAMESPACE, componentMaterial, ComponentMaterial.class);

    if (responseEntity.getStatusCode() == HttpStatus.CREATED) {
      return responseEntity.getBody();
    } else {
      componentMaterial.setErrors(errorHandler.getErrors());

      return componentMaterial;
    }
  }

  public void update(ComponentMaterial componentMaterial) {
    restTemplate.put(NAMESPACE + "/{id}", componentMaterial, componentMaterial.getId());

    if (errorHandler.getErrors() != null) {
      componentMaterial.setErrors(errorHandler.getErrors());
    }
  }

  public void delete(ComponentMaterial componentMaterial) {
    restTemplate.delete(NAMESPACE + "/{id}", componentMaterial.getId());

    if (errorHandler.getErrors() != null) {
      componentMaterial.setErrors(errorHandler.getErrors());
    }
  }

}
