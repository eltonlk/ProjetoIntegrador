package com.projeto.integrador.clientdesktop.resources;

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

  @Autowired
  public RoomResource(RestTemplate restTemplate) {
    this.restTemplate = restTemplate;
  }

  public Room create(Room room) {
    ResponseEntity<Room> responseEntity = restTemplate.postForEntity(NAMESPACE, room, Room.class);

    Room createdRoom = null;

    if (responseEntity.getStatusCode() == HttpStatus.CREATED) {
      createdRoom = responseEntity.getBody();
    }

    return createdRoom;
  }

  public void update(Room room) {
    restTemplate.put(NAMESPACE + "/{id}", room, room.getId());
  }

  public void delete(Room room) {
    restTemplate.delete(NAMESPACE + "/{id}", room.getId());
  }

}
