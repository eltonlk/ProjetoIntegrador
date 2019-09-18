package com.projeto.integrador.clientdesktop.resources;

import com.projeto.integrador.clientdesktop.models.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class UserResource {

  @Autowired
	private RestTemplate restTemplate;

	private static final String URI_USER = "/users";

	public User[] getAll() {
		User[] users = restTemplate.getForObject(URI_USER, User[].class);

		return users;
	}

	public User create(User user) {
		ResponseEntity<User> responseEntity = restTemplate.postForEntity(URI_USER, user, User.class);

		User createdUser = null;

		if (responseEntity.getStatusCode() == HttpStatus.CREATED) {
      createdUser = responseEntity.getBody();
		}

    return createdUser;
	}

	public void update(User user) {
    restTemplate.put(URI_USER + "/{id}", user, user.getId());
	}

	public void delete(User user) {
    restTemplate.delete(URI_USER + "/{id}", user.getId());
  }

}
