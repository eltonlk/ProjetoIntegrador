package com.projeto.integrador.clientdesktop.resources;

import com.projeto.integrador.clientdesktop.models.Face;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class FaceResource {

  final static String NAMESPACE = "/faces";

  private RestTemplate restTemplate;

  @Autowired
  public FaceResource(RestTemplate restTemplate) {
    this.restTemplate = restTemplate;
  }

  public Face create(Face face) {
    ResponseEntity<Face> responseEntity = restTemplate.postForEntity(NAMESPACE, face, Face.class);

    Face createdFace = null;

    if (responseEntity.getStatusCode() == HttpStatus.CREATED) {
      createdFace = responseEntity.getBody();
    }

    return createdFace;
  }

  public void update(Face face) {
    restTemplate.put(NAMESPACE + "/{id}", face, face.getId());
  }

  public void delete(Face face) {
    restTemplate.delete(NAMESPACE + "/{id}", face.getId());
  }

}
