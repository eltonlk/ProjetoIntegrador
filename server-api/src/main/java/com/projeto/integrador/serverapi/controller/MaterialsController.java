package com.projeto.integrador.serverapi.controller;

import com.projeto.integrador.serverapi.model.Material;
import com.projeto.integrador.serverapi.repository.MaterialsRepository;

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
@RequestMapping({"/materials"})
public class MaterialsController {

  private MaterialsRepository repository;

  MaterialsController(MaterialsRepository materialsRepository) {
    this.setRepository(materialsRepository);
  }

  public MaterialsRepository getRepository() {
    return repository;
  }

  public void setRepository(MaterialsRepository repository) {
    this.repository = repository;
  }

  @GetMapping
  @PreAuthorize("hasRole('ROLE_MATERIALS')")
  public List<Material> findAll(){
    return repository.findAll();
  }

  @GetMapping(path = {"/{id}"})
  @PreAuthorize("hasRole('ROLE_MATERIALS')")
  public ResponseEntity<Material> findById(@PathVariable long id) {
    return repository.findById(id)
      .map(record -> ResponseEntity.ok().body(record))
      .orElse(ResponseEntity.notFound().build());
  }

  @PostMapping
  @PreAuthorize("hasRole('ROLE_MATERIALS')")
  @ResponseStatus(HttpStatus.CREATED)
  public Material create(@RequestBody Material material) {
    return repository.save(material);
  }

  @PutMapping(value="/{id}")
  @PreAuthorize("hasRole('ROLE_MATERIALS')")
  public ResponseEntity<Material> update(@PathVariable("id") long id, @RequestBody Material material) {
    return repository.findById(id)
      .map(record -> {
        record.setName(material.getName());

        Material updated = repository.save(record);

        return ResponseEntity.ok().body(updated);
      }).orElse(ResponseEntity.notFound().build());
  }

  @DeleteMapping(path ={"/{id}"})
  @PreAuthorize("hasRole('ROLE_MATERIALS')")
  public ResponseEntity<?> delete(@PathVariable long id) {
    return repository.findById(id)
      .map(record -> {
        repository.deleteById(id);

        return ResponseEntity.ok().build();
      }).orElse(ResponseEntity.notFound().build());
  }
}
