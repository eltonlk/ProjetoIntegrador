package com.projeto.integrador.serverapi.controller;

import com.projeto.integrador.serverapi.model.Category;
import com.projeto.integrador.serverapi.repository.CategoriesRepository;

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
@RequestMapping({"/categories"})
@PreAuthorize("hasRole('ROLE_CATEGORIES')")
public class CategoriesController {

  private CategoriesRepository repository;

  CategoriesController(CategoriesRepository categoriesRepository) {
    this.setRepository(categoriesRepository);
  }

  public CategoriesRepository getRepository() {
    return repository;
  }

  public void setRepository(CategoriesRepository repository) {
    this.repository = repository;
  }

  @GetMapping
  @PreAuthorize("hasAuthority('READ_PRIVILEGE')")
  public List<Category> findAll(){
    return repository.findAll();
  }

  @GetMapping(path = {"/{id}"})
  @PreAuthorize("hasAuthority('READ_PRIVILEGE')")
  public ResponseEntity<Category> findById(@PathVariable long id) {
    return repository.findById(id)
      .map(record -> ResponseEntity.ok().body(record))
      .orElse(ResponseEntity.notFound().build());
  }

  @PostMapping
  @PreAuthorize("hasAuthority('CREATE_PRIVILEGE')")
  @ResponseStatus(HttpStatus.CREATED)
  public Category create(@RequestBody Category category) {
    return repository.save(category);
  }

  @PreAuthorize("hasAuthority('UPDATE_PRIVILEGE')")
  @PutMapping(value="/{id}")
  public ResponseEntity<Category> update(@PathVariable("id") long id, @RequestBody Category category) {
    return repository.findById(id)
      .map(record -> {
        record.setName(category.getName());
        record.setActive(category.isActive());

        Category updated = repository.save(record);

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
