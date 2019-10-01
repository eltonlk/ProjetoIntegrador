package com.projeto.integrador.serverapi.controller;

import com.projeto.integrador.serverapi.model.Color;
import com.projeto.integrador.serverapi.repository.ColorsRepository;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"/colors"})
@PreAuthorize("hasRole('ROLE_COLORS')")
public class ColorsController {

  private ColorsRepository repository;

  ColorsController(ColorsRepository colorsRepository) {
    this.setRepository(colorsRepository);
  }

  public ColorsRepository getRepository() {
    return repository;
  }

  public void setRepository(ColorsRepository repository) {
    this.repository = repository;
  }

  @GetMapping
  @PreAuthorize("hasAuthority('READ_PRIVILEGE')")
  public List<Color> findAll(){
    return repository.findAll();
  }

  @GetMapping(path = {"/{id}"})
  @PreAuthorize("hasAuthority('READ_PRIVILEGE')")
  public ResponseEntity<Color> findById(@PathVariable long id) {
    return repository.findById(id)
      .map(record -> ResponseEntity.ok().body(record))
      .orElse(ResponseEntity.notFound().build());
  }

  @PostMapping
  @PreAuthorize("hasAuthority('CREATE_PRIVILEGE')")
  @ResponseStatus(HttpStatus.CREATED)
  public Color create(@RequestBody Color color) {
    return repository.save(color);
  }

  @PreAuthorize("hasAuthority('UPDATE_PRIVILEGE')")
  @PutMapping(value="/{id}")
  public ResponseEntity<Color> update(@PathVariable("id") long id, @RequestBody Color color) {
    return repository.findById(id)
      .map(record -> {
        record.setName(color.getName());
        record.setAbsorbabilityIndex(color.getAbsorbabilityIndex());
        record.setActive(color.isActive());

        Color updated = repository.save(record);

        return ResponseEntity.ok().body(updated);
      }).orElse(ResponseEntity.notFound().build());
  }

  @DeleteMapping(path ={"/{id}"})
  @PreAuthorize("hasAuthority('DELETE_PRIVILEGE')")
  public ResponseEntity<?> delete(@PathVariable long id) {
    return repository.findById(id)
      .map(record -> {
        repository.deleteById(id);

        return ResponseEntity.ok().build();
      }).orElse(ResponseEntity.notFound().build());
  }

}
