package com.projeto.integrador.clientdesktop.resources;

import java.io.File;

import com.projeto.integrador.clientdesktop.models.Color;

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
public class ColorResource {

  final static String NAMESPACE = "/colors";

  private RestTemplate restTemplate;

  @Autowired
  public ColorResource(RestTemplate restTemplate) {
    this.restTemplate = restTemplate;
  }

  public Color[] getAll() {
    Color[] colors = restTemplate.getForObject(NAMESPACE, Color[].class);

    return colors;
  }

  public Color create(Color color) {
    ResponseEntity<Color> responseEntity = restTemplate.postForEntity(NAMESPACE, color, Color.class);

    Color createdColor = null;

    if (responseEntity.getStatusCode() == HttpStatus.CREATED) {
      createdColor = responseEntity.getBody();
    }

    return createdColor;
  }

  public void update(Color color) {
    restTemplate.put(NAMESPACE + "/{id}", color, color.getId());
  }

  public void delete(Color color) {
    restTemplate.delete(NAMESPACE + "/{id}", color.getId());
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
