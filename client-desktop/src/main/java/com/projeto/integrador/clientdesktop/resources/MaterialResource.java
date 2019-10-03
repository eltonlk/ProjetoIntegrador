package com.projeto.integrador.clientdesktop.resources;

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

  @Autowired
  public MaterialResource(RestTemplate restTemplate) {
    this.restTemplate = restTemplate;
  }

  public Material[] getAll() {
    Material[] materials = restTemplate.getForObject(NAMESPACE, Material[].class);

    return materials;
  }

  public Material create(Material material) {
    ResponseEntity<Material> responseEntity = restTemplate.postForEntity(NAMESPACE, material, Material.class);

    Material createdMaterial = null;

    if (responseEntity.getStatusCode() == HttpStatus.CREATED) {
      createdMaterial = responseEntity.getBody();
    }

    return createdMaterial;
  }

  public void update(Material material) {
    restTemplate.put(NAMESPACE + "/{id}", material, material.getId());
  }

  public void delete(Material material) {
    restTemplate.delete(NAMESPACE + "/{id}", material.getId());
  }

}
