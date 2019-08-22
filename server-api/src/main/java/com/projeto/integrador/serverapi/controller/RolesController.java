package com.projeto.integrador.serverapi.controller;

import com.projeto.integrador.serverapi.model.Role;
import com.projeto.integrador.serverapi.repository.RolesRepository;

import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"/roles"})
public class RolesController {

  private RolesRepository repository;

  RolesController(RolesRepository rolesRepository) {
    this.setRepository(rolesRepository);
  }

  public RolesRepository getRepository() {
    return repository;
  }

  public void setRepository(RolesRepository repository) {
    this.repository = repository;
  }

  @GetMapping
  @PreAuthorize("hasRole('ROLE_ADMIN')")
  public List<Role> findAll() {
    return repository.findAll();
  }

}
