package com.projeto.integrador.clientdesktop.resources;

import java.util.Arrays;
import java.util.List;

import com.projeto.integrador.clientdesktop.models.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class UserResource {

  @Autowired
	private RestTemplate restTemplate;

	final String ROOT_URI = "https://polar-ridge-82955.herokuapp.com/users";

  public List<User> getAll() {
    ResponseEntity<User[]> response = restTemplate.getForEntity(ROOT_URI, User[].class);

		return Arrays.asList(response.getBody());
	}

	public User getById(Long id) {
    ResponseEntity<User> response = restTemplate.getForEntity(ROOT_URI + "/"+id, User.class);

		return response.getBody();
	}

	public HttpStatus create(User user) {
		ResponseEntity<HttpStatus> response = restTemplate.postForEntity(ROOT_URI, user, HttpStatus.class);

    return response.getBody();
	}

	public void update(User user) {
		restTemplate.put(ROOT_URI, user);
	}

	public void delete(Long id) {
		restTemplate.delete(ROOT_URI + id);
	}

}
