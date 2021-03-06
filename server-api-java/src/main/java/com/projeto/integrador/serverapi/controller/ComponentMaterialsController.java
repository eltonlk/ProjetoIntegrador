package com.projeto.integrador.serverapi.controller;

import com.projeto.integrador.serverapi.model.ComponentMaterial;
import com.projeto.integrador.serverapi.repository.ComponentMaterialsRepository;

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
@RequestMapping({"/component_materials"})
@PreAuthorize("hasRole('ROLE_COMPONENT_MATERIALS')")
public class ComponentMaterialsController {

  private ComponentMaterialsRepository repository;

  ComponentMaterialsController(ComponentMaterialsRepository componentMaterialsRepository) {
    this.setRepository(componentMaterialsRepository);
  }

  public ComponentMaterialsRepository getRepository() {
    return repository;
  }

  public void setRepository(ComponentMaterialsRepository repository) {
    this.repository = repository;
  }

  @GetMapping
  @PreAuthorize("hasAuthority('READ_PRIVILEGE')")
  public List<ComponentMaterial> findAll(){
    return repository.findAll();
  }

  @GetMapping(path = {"/{id}"})
  @PreAuthorize("hasAuthority('READ_PRIVILEGE')")
  public ResponseEntity<ComponentMaterial> findById(@PathVariable long id) {
    return repository.findById(id)
      .map(record -> ResponseEntity.ok().body(record))
      .orElse(ResponseEntity.notFound().build());
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  @PreAuthorize("hasAuthority('CREATE_PRIVILEGE')")
  public ComponentMaterial create(@RequestBody ComponentMaterial componentMaterial) {
    return repository.save(componentMaterial);
  }

  @PutMapping(value="/{id}")
  @PreAuthorize("hasAuthority('UPDATE_PRIVILEGE')")
  public ResponseEntity<ComponentMaterial> update(@PathVariable("id") long id, @RequestBody ComponentMaterial componentMaterial) {
    return repository.findById(id)
      .map(record -> {
        record.setWidth(componentMaterial.getWidth());
        record.setThermalConductivityIndex(componentMaterial.getThermalConductivityIndex());
        record.setResistance(componentMaterial.getResistance());
        record.setComponent(componentMaterial.getComponent());
        record.setMaterial(componentMaterial.getMaterial());

        ComponentMaterial updated = repository.save(record);

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
