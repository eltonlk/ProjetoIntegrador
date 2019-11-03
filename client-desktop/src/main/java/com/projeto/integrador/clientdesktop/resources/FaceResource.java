package com.projeto.integrador.clientdesktop.resources;

import com.projeto.integrador.clientdesktop.config.RestTemplateResponseErrorHandler;
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
  private RestTemplateResponseErrorHandler errorHandler;

  @Autowired
  public FaceResource(RestTemplate restTemplate) {
    this.restTemplate = restTemplate;
    this.errorHandler = new RestTemplateResponseErrorHandler();

    this.restTemplate.setErrorHandler(errorHandler);
  }

  public Face create(Face face) {
    ResponseEntity<Face> responseEntity = restTemplate.postForEntity(NAMESPACE, face, Face.class);

    if (responseEntity.getStatusCode() == HttpStatus.CREATED) {
      return responseEntity.getBody();
    } else {
      face.setErrors(errorHandler.getErrors());

      return face;
    }
  }

  public void update(Face face) {
    restTemplate.put(NAMESPACE + "/{id}", face, face.getId());

    if (errorHandler.getErrors() != null) {
      face.setErrors(errorHandler.getErrors());
    }
  }

  public void delete(Face face) {
    restTemplate.delete(NAMESPACE + "/{id}", face.getId());

    if (errorHandler.getErrors() != null) {
      face.setErrors(errorHandler.getErrors());
    }
  }

}
