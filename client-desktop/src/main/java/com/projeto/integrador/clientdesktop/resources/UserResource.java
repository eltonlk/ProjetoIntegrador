package com.projeto.integrador.clientdesktop.resources;

import com.projeto.integrador.clientdesktop.config.RestTemplateResponseErrorHandler;
import com.projeto.integrador.clientdesktop.models.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserResource {

  final static String NAMESPACE = "/users";

  private RestTemplate restTemplate;
  private RestTemplateResponseErrorHandler errorHandler;

  @Autowired
  public UserResource(RestTemplate restTemplate) {
    this.restTemplate = restTemplate;
    this.errorHandler = new RestTemplateResponseErrorHandler();

    this.restTemplate.setErrorHandler(errorHandler);
  }

  public User[] getAll() {
    User[] users = restTemplate.getForObject(NAMESPACE, User[].class);

    return users;
  }

  public User create(User user) {
    ResponseEntity<User> responseEntity = restTemplate.postForEntity(NAMESPACE, user, User.class);

    if (responseEntity.getStatusCode() == HttpStatus.CREATED) {
      return responseEntity.getBody();
    } else {
      user.setErrors(errorHandler.getErrors());

      return user;
    }
  }

  public void update(User user) {
    restTemplate.put(NAMESPACE + "/{id}", user, user.getId());

    if (errorHandler.getErrors() != null) {
      user.setErrors(errorHandler.getErrors());
    }
  }

  public void delete(User user) {
    restTemplate.delete(NAMESPACE + "/{id}", user.getId());

    if (errorHandler.getErrors() != null) {
      user.setErrors(errorHandler.getErrors());
    }
  }

}
