package com.projeto.integrador.clientdesktop.resources;

import com.projeto.integrador.clientdesktop.config.RestTemplateResponseErrorHandler;
import com.projeto.integrador.clientdesktop.models.Room;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RoomResource {

  final static String NAMESPACE = "/rooms";

  private RestTemplate restTemplate;
  private RestTemplateResponseErrorHandler errorHandler;

  @Autowired
  public RoomResource(RestTemplate restTemplate) {
    this.restTemplate = restTemplate;
    this.errorHandler = new RestTemplateResponseErrorHandler();

    this.restTemplate.setErrorHandler(errorHandler);
  }

  public Room create(Room room) {
    ResponseEntity<Room> responseEntity = restTemplate.postForEntity(NAMESPACE, room, Room.class);

    if (responseEntity.getStatusCode() == HttpStatus.CREATED) {
      return responseEntity.getBody();
    } else {
      room.setErrors(errorHandler.getErrors());

      return room;
    }
  }

  public void update(Room room) {
    restTemplate.put(NAMESPACE + "/{id}", room, room.getId());

    if (errorHandler.getErrors() != null) {
      room.setErrors(errorHandler.getErrors());
    }
  }

  public void delete(Room room) {
    restTemplate.delete(NAMESPACE + "/{id}", room.getId());

    if (errorHandler.getErrors() != null) {
      room.setErrors(errorHandler.getErrors());
    }
  }

}
