package com.projeto.integrador.clientdesktop.resources;

import com.projeto.integrador.clientdesktop.models.Audit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AuditResource {

  final static String NAMESPACE = "/audits";

  private RestTemplate restTemplate;

  @Autowired
  public AuditResource(RestTemplate restTemplate) {
    this.restTemplate = restTemplate;
  }

  public Audit[] getAll() {
    Audit[] audits = restTemplate.getForObject(NAMESPACE, Audit[].class);

    return audits;
  }

}
