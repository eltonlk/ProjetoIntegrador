package com.projeto.integrador.clientdesktop.resources;

import com.projeto.integrador.clientdesktop.models.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class SessionResource {

  @Autowired
	private RestTemplate restTemplate;

	final String ROOT_URI = "/login";

  public HttpStatus login(User user) {
    ResponseEntity<HttpStatus> response = restTemplate.postForEntity(ROOT_URI, user, HttpStatus.class);

    return response.getBody();
	}

}
