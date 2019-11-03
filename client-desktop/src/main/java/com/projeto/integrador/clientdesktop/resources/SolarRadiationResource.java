package com.projeto.integrador.clientdesktop.resources;

import com.projeto.integrador.clientdesktop.config.RestTemplateResponseErrorHandler;
import com.projeto.integrador.clientdesktop.models.SolarRadiation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class SolarRadiationResource {

  final static String NAMESPACE = "/solar_radiations";

  private RestTemplate restTemplate;
  private RestTemplateResponseErrorHandler errorHandler;

  @Autowired
  public SolarRadiationResource(RestTemplate restTemplate) {
    this.restTemplate = restTemplate;
    this.errorHandler = new RestTemplateResponseErrorHandler();

    this.restTemplate.setErrorHandler(errorHandler);
  }

  public SolarRadiation[] getAll() {
    SolarRadiation[] solarRadiations = restTemplate.getForObject(NAMESPACE, SolarRadiation[].class);

    return solarRadiations;
  }

  public SolarRadiation create(SolarRadiation solarRadiation) {
    ResponseEntity<SolarRadiation> responseEntity = restTemplate.postForEntity(NAMESPACE, solarRadiation, SolarRadiation.class);

    if (responseEntity.getStatusCode() == HttpStatus.CREATED) {
      return responseEntity.getBody();
    } else {
      solarRadiation.setErrors(errorHandler.getErrors());

      return solarRadiation;
    }
  }

  public void update(SolarRadiation solarRadiation) {
    restTemplate.put(NAMESPACE + "/{id}", solarRadiation, solarRadiation.getId());

    if (errorHandler.getErrors() != null) {
      solarRadiation.setErrors(errorHandler.getErrors());
    }
  }

  public void delete(SolarRadiation solarRadiation) {
    restTemplate.delete(NAMESPACE + "/{id}", solarRadiation.getId());

    if (errorHandler.getErrors() != null) {
      solarRadiation.setErrors(errorHandler.getErrors());
    }
  }

}
