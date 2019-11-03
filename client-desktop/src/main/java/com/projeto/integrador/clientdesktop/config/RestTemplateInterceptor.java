package com.projeto.integrador.clientdesktop.config;

import java.io.IOException;

import com.projeto.integrador.clientdesktop.models.TokenCredential;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.StreamUtils;

import java.nio.charset.Charset;

public class RestTemplateInterceptor implements ClientHttpRequestInterceptor {

  private final Logger log = LoggerFactory.getLogger(this.getClass());

  @Override
  public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {
    request.getHeaders().add("Accept", "application/json");

    if (hasAuthentication()) {
      request.getHeaders().add("Authorization", getToken());
    }

    logRequest(request, body);

    ClientHttpResponse response = execution.execute(request, body);

    logResponse(response);

    return response;
  }

  private boolean hasAuthentication() {
    return SecurityContextHolder.getContext().getAuthentication() != null &&
      SecurityContextHolder.getContext().getAuthentication().isAuthenticated();
  }

  private String getToken() {
    TokenCredential tokenCredential = (TokenCredential) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

    String token = tokenCredential.getToken();

    return token;
  }

  private void logRequest(HttpRequest request, byte[] body) throws IOException {
    if (log.isDebugEnabled()) {
      log.debug("===========================request begin================================================");
      log.debug("URI         : {}", request.getURI());
      log.debug("Method      : {}", request.getMethod());
      log.debug("Headers     : {}", request.getHeaders());
      log.debug("Request body: {}", new String(body, "UTF-8"));
      log.debug("==========================request end================================================");
    }
  }

  private void logResponse(ClientHttpResponse response) throws IOException {
    if (log.isDebugEnabled()) {
      log.debug("============================response begin==========================================");
      log.debug("Status code  : {}", response.getStatusCode());
      log.debug("Status text  : {}", response.getStatusText());
      log.debug("Headers      : {}", response.getHeaders());
      log.debug("Response body: {}", StreamUtils.copyToString(response.getBody(), Charset.defaultCharset()));
      log.debug("=======================response end=================================================");
    }
  }
}
