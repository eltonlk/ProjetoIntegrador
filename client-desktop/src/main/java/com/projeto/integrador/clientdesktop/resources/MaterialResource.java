package com.projeto.integrador.clientdesktop.resources;

import com.projeto.integrador.clientdesktop.config.RestTemplateResponseErrorHandler;
import com.projeto.integrador.clientdesktop.models.Material;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MaterialResource {

  final static String NAMESPACE = "/materials";

  private RestTemplate restTemplate;
  private RestTemplateResponseErrorHandler errorHandler;

  @Autowired
  public MaterialResource(RestTemplate restTemplate) {
    this.restTemplate = restTemplate;
    this.errorHandler = new RestTemplateResponseErrorHandler();

    this.restTemplate.setErrorHandler(errorHandler);
  }

  public Material[] getAll() {
    Material[] materials = restTemplate.getForObject(NAMESPACE, Material[].class);

    return materials;
  }

  public Material create(Material material) {
    ResponseEntity<Material> responseEntity = restTemplate.postForEntity(NAMESPACE, material, Material.class);

    if (responseEntity.getStatusCode() == HttpStatus.CREATED) {
      return responseEntity.getBody();
    } else {
      material.setErrors(errorHandler.getErrors());

      return material;
    }
  }

  public void update(Material material) {
    restTemplate.put(NAMESPACE + "/{id}", material, material.getId());

    if (errorHandler.getErrors() != null) {
      material.setErrors(errorHandler.getErrors());
    }
  }

  public void delete(Material material) {
    restTemplate.delete(NAMESPACE + "/{id}", material.getId());

    if (errorHandler.getErrors() != null) {
      material.setErrors(errorHandler.getErrors());
    }
  }

}
