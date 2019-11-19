package com.projeto.integrador.clientdesktop.resources;

import java.io.File;

import com.projeto.integrador.clientdesktop.models.SolarRadiation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@Service
public class SolarRadiationResource {

  final static String NAMESPACE = "/solar_radiations";

  private RestTemplate restTemplate;

  @Autowired
  public SolarRadiationResource(RestTemplate restTemplate) {
    this.restTemplate = restTemplate;
  }

  public SolarRadiation[] getAll() {
    SolarRadiation[] solarRadiations = restTemplate.getForObject(NAMESPACE, SolarRadiation[].class);

    return solarRadiations;
  }

  public SolarRadiation create(SolarRadiation solarRadiation) {
    ResponseEntity<SolarRadiation> responseEntity = restTemplate.postForEntity(NAMESPACE, solarRadiation, SolarRadiation.class);

    SolarRadiation createdSolarRadiation = null;

    if (responseEntity.getStatusCode() == HttpStatus.CREATED) {
      createdSolarRadiation = responseEntity.getBody();
    }

    return createdSolarRadiation;
  }

  public void update(SolarRadiation solarRadiation) {
    restTemplate.put(NAMESPACE + "/{id}", solarRadiation, solarRadiation.getId());
  }

  public void delete(SolarRadiation solarRadiation) {
    restTemplate.delete(NAMESPACE + "/{id}", solarRadiation.getId());
  }

  public void importFile(File file) {
    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.MULTIPART_FORM_DATA);

    MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();
    body.add("file", new FileSystemResource(file));

    HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(body, headers);

    restTemplate.postForEntity(NAMESPACE + "/import", requestEntity, String.class);
  }

}
