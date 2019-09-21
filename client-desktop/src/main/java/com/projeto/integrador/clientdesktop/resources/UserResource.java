package com.projeto.integrador.clientdesktop.resources;

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

  @Autowired
  public UserResource(RestTemplate restTemplate) {
    this.restTemplate = restTemplate;
  }

  public User[] getAll() {
    User[] users = restTemplate.getForObject(NAMESPACE, User[].class);

    return users;
  }

  public User create(User user) {
    ResponseEntity<User> responseEntity = restTemplate.postForEntity(NAMESPACE, user, User.class);

    User createdUser = null;

    if (responseEntity.getStatusCode() == HttpStatus.CREATED) {
      createdUser = responseEntity.getBody();
    }

    return createdUser;
  }

  public void update(User user) {
    restTemplate.put(NAMESPACE + "/{id}", user, user.getId());
  }

  public void delete(User user) {
    restTemplate.delete(NAMESPACE + "/{id}", user.getId());
  }

}
