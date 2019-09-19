package com.projeto.integrador.clientdesktop.config;

import java.io.IOException;

import com.projeto.integrador.clientdesktop.models.TokenCredential;

import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.security.core.context.SecurityContextHolder;

public class RestTemplateAuthenticationInterceptor implements ClientHttpRequestInterceptor {

  @Override
  public ClientHttpResponse intercept(
    HttpRequest request,
    byte[] body,
    ClientHttpRequestExecution execution
  ) throws IOException {
    request.getHeaders().add("Accept", "application/json");

    if (SecurityContextHolder.getContext().getAuthentication() != null &&
      SecurityContextHolder.getContext().getAuthentication().isAuthenticated()) {

      TokenCredential tokenCredential = (TokenCredential) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

      String token = tokenCredential.getToken();

      request.getHeaders().add("Authorization", token);
    }

    return execution.execute(request, body);
  }

}
