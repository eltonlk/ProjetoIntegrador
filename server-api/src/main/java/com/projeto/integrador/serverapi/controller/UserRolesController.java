package com.projeto.integrador.serverapi.controller;

import com.projeto.integrador.serverapi.model.UserRole;
import com.projeto.integrador.serverapi.repository.UserRolesRepository;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"/user_roles"})
@PreAuthorize("hasRole('ROLE_USERS')")
public class UserRolesController {

  private UserRolesRepository repository;

  UserRolesController(UserRolesRepository userRolesRepository) {
    this.setRepository(userRolesRepository);
  }

  public UserRolesRepository getRepository() {
    return repository;
  }

  public void setRepository(UserRolesRepository repository) {
    this.repository = repository;
  }

  @PutMapping(value="/{id}")
  @PreAuthorize("hasAuthority('UPDATE_PERMISSIONS_PRIVILEGE')")
  public ResponseEntity<UserRole> update(@PathVariable("id") long id, @RequestBody UserRole userRole) {
    return repository.findById(id)
      .map(record -> {
        record.setEnable(userRole.isEnable());

        UserRole updated = repository.save(record);

        return ResponseEntity.ok().body(updated);
      }).orElse(ResponseEntity.notFound().build());
  }

}
