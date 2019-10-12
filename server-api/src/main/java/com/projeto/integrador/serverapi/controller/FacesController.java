package com.projeto.integrador.serverapi.controller;

import com.projeto.integrador.serverapi.model.Component;
import com.projeto.integrador.serverapi.model.Face;
import com.projeto.integrador.serverapi.repository.FacesRepository;

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
@RequestMapping({"/faces"})
@PreAuthorize("hasRole('ROLE_FACES')")
public class FacesController {

  private FacesRepository repository;

  FacesController(FacesRepository facesRepository) {
    this.setRepository(facesRepository);
  }

  public FacesRepository getRepository() {
    return repository;
  }

  public void setRepository(FacesRepository repository) {
    this.repository = repository;
  }

  @GetMapping
  @PreAuthorize("hasAuthority('READ_PRIVILEGE')")
  public List<Face> findAll(){
    return repository.findAll();
  }

  @GetMapping(path = {"/{id}"})
  @PreAuthorize("hasAuthority('READ_PRIVILEGE')")
  public ResponseEntity<Face> findById(@PathVariable long id) {
    return repository.findById(id)
      .map(record -> ResponseEntity.ok().body(record))
      .orElse(ResponseEntity.notFound().build());
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  @PreAuthorize("hasAuthority('CREATE_PRIVILEGE')")
  public Face create(@RequestBody Face face) {
    // face.setHeatFlow(heatFlowCanculatedFor(face));

    return repository.save(face);
  }

  @PutMapping(value="/{id}")
  @PreAuthorize("hasAuthority('UPDATE_PRIVILEGE')")
  public ResponseEntity<Face> update(@PathVariable("id") long id, @RequestBody Face face) {
    return repository.findById(id)
      .map(record -> {
        record.setName(face.getName());
        record.setHeatFlow(face.getHeatFlow());
        record.setRoom(face.getRoom());

        // record.setHeatFlow(heatFlowCanculatedFor(record));

        Face updated = repository.save(record);

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

  private double heatFlowCanculatedFor(Face face) {
    double heatFlow = 0;

    for (Component component : face.getComponents()) {
      heatFlow += component.getHeatFlow();
    }

    return heatFlow;
  }

}
