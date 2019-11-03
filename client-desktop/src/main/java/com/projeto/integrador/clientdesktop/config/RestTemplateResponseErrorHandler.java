package com.projeto.integrador.clientdesktop.config;

import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.http.HttpStatus.Series;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.client.ResponseErrorHandler;

@Component
public class RestTemplateResponseErrorHandler implements ResponseErrorHandler {

  private JSONObject errors;

  @Override
  public boolean hasError(ClientHttpResponse httpResponse) throws IOException {
    return (httpResponse.getStatusCode().series() == Series.CLIENT_ERROR
        || httpResponse.getStatusCode().series() == Series.SERVER_ERROR);
  }

  @Override
  public void handleError(ClientHttpResponse httpResponse) throws IOException {
    String errorsMessage = new String(httpResponse.getBody().readAllBytes(), "UTF-8");

    errors = parseErrors(errorsMessage);
  }

  private JSONObject parseErrors(String errorsMessage) {
    JSONParser parser = new JSONParser();

    try {
      return (JSONObject) parser.parse(errorsMessage);
    } catch (ParseException e) {
      e.printStackTrace();
    }

    return null;
  }

  public JSONObject getErrors() {
    return errors;
  }
}
