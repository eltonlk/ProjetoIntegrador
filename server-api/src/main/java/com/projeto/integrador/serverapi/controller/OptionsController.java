package com.projeto.integrador.serverapi.controller;

import com.projeto.integrador.serverapi.model.Option;
import com.projeto.integrador.serverapi.repository.OptionsRepository;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"/options"})
@PreAuthorize("hasRole('ROLE_OPTIONS')")
public class OptionsController {

  private OptionsRepository repository;

  OptionsController(OptionsRepository optionsRepository) {
    this.setRepository(optionsRepository);
  }

  public OptionsRepository getRepository() {
    return repository;
  }

  public void setRepository(OptionsRepository repository) {
    this.repository = repository;
  }

  @GetMapping
  @PreAuthorize("hasAuthority('READ_PRIVILEGE')")
  public List<Option> findAll(){
    return repository.findAll();
  }

  @PutMapping(value="/{id}")
  @PreAuthorize("hasAuthority('UPDATE_PRIVILEGE')")
  public ResponseEntity<Option> update(@PathVariable("id") long id, @RequestBody Option option) {
    return repository.findById(id)
      .map(record -> {
        record.setName(option.getName());
        record.setValue(option.getValue());

        Option updated = repository.save(record);

        return ResponseEntity.ok().body(updated);
      }).orElse(ResponseEntity.notFound().build());
  }

}
