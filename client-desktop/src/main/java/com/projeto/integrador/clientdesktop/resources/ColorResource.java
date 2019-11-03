package com.projeto.integrador.clientdesktop.resources;

import com.projeto.integrador.clientdesktop.config.RestTemplateResponseErrorHandler;
import com.projeto.integrador.clientdesktop.models.Color;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ColorResource {

  final static String NAMESPACE = "/colors";

  private RestTemplate restTemplate;
  private RestTemplateResponseErrorHandler errorHandler;

  @Autowired
  public ColorResource(RestTemplate restTemplate) {
    this.restTemplate = restTemplate;
    this.errorHandler = new RestTemplateResponseErrorHandler();

    this.restTemplate.setErrorHandler(errorHandler);
  }

  public Color[] getAll() {
    Color[] colors = restTemplate.getForObject(NAMESPACE, Color[].class);

    return colors;
  }

  public Color create(Color color) {
    ResponseEntity<Color> responseEntity = restTemplate.postForEntity(NAMESPACE, color, Color.class);

    if (responseEntity.getStatusCode() == HttpStatus.CREATED) {
      return responseEntity.getBody();
    } else {
      color.setErrors(errorHandler.getErrors());

      return color;
    }
  }

  public void update(Color color) {
    restTemplate.put(NAMESPACE + "/{id}", color, color.getId());

    if (errorHandler.getErrors() != null) {
      color.setErrors(errorHandler.getErrors());
    }
  }

  public void delete(Color color) {
    restTemplate.delete(NAMESPACE + "/{id}", color.getId());

    if (errorHandler.getErrors() != null) {
      color.setErrors(errorHandler.getErrors());
    }
  }

}
