package com.projeto.integrador.serverapi.controller;

import com.projeto.integrador.serverapi.model.SolarRadiation;
import com.projeto.integrador.serverapi.repository.SolarRadiationsRepository;

import java.util.List;

import org.springframework.data.domain.Sort;
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
@RequestMapping({"/solar_radiations"})
@PreAuthorize("hasRole('ROLE_SOLAR_RADIATIONS')")
public class SolarRadiationsController {

  private SolarRadiationsRepository repository;

  SolarRadiationsController(SolarRadiationsRepository solarRadiationRepository) {
    this.setRepository(solarRadiationRepository);
  }

  public SolarRadiationsRepository getRepository() {
    return repository;
  }

  public void setRepository(SolarRadiationsRepository repository) {
    this.repository = repository;
  }

  @GetMapping
  @PreAuthorize("hasAuthority('READ_PRIVILEGE')")
  public List<SolarRadiation> findAll(){
    return repository.findAll(Sort.by(Sort.Direction.ASC, "name"));
  }

  @GetMapping(path = {"/{id}"})
  @PreAuthorize("hasAuthority('READ_PRIVILEGE')")
  public ResponseEntity<SolarRadiation> findById(@PathVariable long id) {
    return repository.findById(id)
      .map(record -> ResponseEntity.ok().body(record))
      .orElse(ResponseEntity.notFound().build());
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  @PreAuthorize("hasAuthority('CREATE_PRIVILEGE')")
  public SolarRadiation create(@RequestBody SolarRadiation solarRadiation) {
    return repository.save(solarRadiation);
  }

  @PutMapping(value="/{id}")
  @PreAuthorize("hasAuthority('UPDATE_PRIVILEGE')")
  public ResponseEntity<SolarRadiation> update(@PathVariable("id") long id, @RequestBody SolarRadiation solarRadiation) {
    return repository.findById(id)
      .map(record -> {
        record.setName(solarRadiation.getName());
        record.setNorthIndex(solarRadiation.getNorthIndex());
        record.setNorthEastIndex(solarRadiation.getNorthEastIndex());
        record.setEastIndex(solarRadiation.getEastIndex());
        record.setSouthEastIndex(solarRadiation.getSouthEastIndex());
        record.setSouthIndex(solarRadiation.getSouthIndex());
        record.setSouthWestIndex(solarRadiation.getSouthWestIndex());
        record.setWestIndex(solarRadiation.getWestIndex());
        record.setNorthWestIndex(solarRadiation.getNorthWestIndex());

        SolarRadiation updated = repository.save(record);

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
