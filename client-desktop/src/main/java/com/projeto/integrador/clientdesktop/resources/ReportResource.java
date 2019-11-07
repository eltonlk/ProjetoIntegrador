package com.projeto.integrador.clientdesktop.resources;

import java.net.URISyntaxException;
import java.time.LocalDate;

import com.fasterxml.jackson.databind.JsonNode;
import com.projeto.integrador.clientdesktop.models.SolarRadiation;

import org.apache.http.client.utils.URIBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ReportResource {

  final static String NAMESPACE = "/reports";

  private RestTemplate restTemplate;

  @Autowired
  public ReportResource(RestTemplate restTemplate) {
    this.restTemplate = restTemplate;
  }

  public JsonNode getAll(LocalDate start_at, LocalDate end_at, SolarRadiation solarRadiation) {
    String url = NAMESPACE;

    URIBuilder builder = new URIBuilder();
    builder.addParameter("date_from", start_at.toString());
    builder.addParameter("date_to", end_at.toString());

    if (solarRadiation != null) {
      builder.addParameter("solar_radiation_id", solarRadiation.getId().toString());
    }

    try {
      url += builder.build().toString();
    } catch (URISyntaxException e) {
      e.printStackTrace();
    }

    HttpEntity<JsonNode> response = restTemplate.exchange(url + "", HttpMethod.GET, null, JsonNode.class);

    JsonNode json = response.getBody();

    return json;
  }
}
