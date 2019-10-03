package com.projeto.integrador.clientdesktop.resources;

import com.projeto.integrador.clientdesktop.models.Option;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OptionResource {

  final static String NAMESPACE = "/options";

  private RestTemplate restTemplate;

  @Autowired
  public OptionResource(RestTemplate restTemplate) {
    this.restTemplate = restTemplate;
  }

  public Option[] getAll() {
    Option[] options = restTemplate.getForObject(NAMESPACE, Option[].class);

    return options;
  }

  public void update(Option option) {
    restTemplate.put(NAMESPACE + "/{id}", option, option.getId());
  }

}
