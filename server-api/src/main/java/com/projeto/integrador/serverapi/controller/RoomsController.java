package com.projeto.integrador.serverapi.controller;

import com.projeto.integrador.serverapi.model.Room;
import com.projeto.integrador.serverapi.repository.RoomsRepository;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.access.prepost.PreAuthorize;

@RestController
@RequestMapping({"/rooms"})
@PreAuthorize("hasRole('ROLE_ROOMS')")
public class RoomsController {

  private RoomsRepository repository;

  RoomsController(RoomsRepository roomsRepository) {
    this.setRepository(roomsRepository);
  }

  public RoomsRepository getRepository() {
    return repository;
  }

  public void setRepository(RoomsRepository repository) {
    this.repository = repository;
  }

  @GetMapping
  @PreAuthorize("hasAuthority('READ_PRIVILEGE')")
  public List<Room> findAll(){
    return repository.findAll();
  }

  @GetMapping(path = {"/{id}"})
  @PreAuthorize("hasAuthority('READ_PRIVILEGE')")
  public ResponseEntity<Room> findById(@PathVariable long id) {
    return repository.findById(id)
      .map(record -> ResponseEntity.ok().body(record))
      .orElse(ResponseEntity.notFound().build());
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  @PreAuthorize("hasAuthority('CREATE_PRIVILEGE')")
  public Room create(@RequestBody Room room) {

    System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>> aqui");
    System.out.println(room.getProject());


    return repository.save(room);
  }

  @PutMapping(value="/{id}")
  @PreAuthorize("hasAuthority('UPDATE_PRIVILEGE')")
  public ResponseEntity<Room> update(@PathVariable("id") long id, @RequestBody Room room) {
    return repository.findById(id)
      .map(record -> {
        record.setName(room.getName());
        record.setHeatLoad(room.getHeatLoad());
        record.setProject(room.getProject());

        Room updated = repository.save(record);

        return ResponseEntity.ok().body(updated);
      }).orElse(ResponseEntity.notFound().build());
  }

  @DeleteMapping(path ={"/{id}"})
  @PreAuthorize("hasAuthority('DELETE_PRIVILEGE')")
  public ResponseEntity<?> delete(@PathVariable long id) {
    return repository.findById(id)
      .map(record -> {
        repository.delete(record);

        return ResponseEntity.ok().build();
      }).orElse(ResponseEntity.notFound().build());
  }

}
