package com.projeto.integrador.clientdesktop.resources;

import com.projeto.integrador.clientdesktop.models.TokenCredential;
import com.projeto.integrador.clientdesktop.models.UserCredential;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class SessionResource {

  final static String NAMESPACE = "/login";

  private RestTemplate restTemplate;

  @Autowired
  public SessionResource(RestTemplate restTemplate) {
    this.restTemplate = restTemplate;
  }

  public TokenCredential requestToken(UserCredential userCredential) throws Exception {
    ResponseEntity<TokenCredential> tokenCredential = restTemplate.postForEntity(NAMESPACE, userCredential, TokenCredential.class);

    return tokenCredential.getBody();
	}

}
