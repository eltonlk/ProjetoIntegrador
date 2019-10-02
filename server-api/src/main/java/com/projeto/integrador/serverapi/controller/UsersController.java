package com.projeto.integrador.serverapi.controller;

import com.projeto.integrador.serverapi.model.User;
import com.projeto.integrador.serverapi.repository.UserRolesRepository;
import com.projeto.integrador.serverapi.repository.UsersRepository;

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
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@RestController
@RequestMapping({"/users"})
@PreAuthorize("hasRole('ROLE_USERS')")
public class UsersController {

  private UserRolesRepository userRolesRepository;
  private UsersRepository repository;

  UsersController(UsersRepository usersRepository, UserRolesRepository userRolesRepository) {
    this.setRepository(usersRepository);
    this.setUserRolesRepository(userRolesRepository);
  }

  public UsersRepository getRepository() {
    return repository;
  }

  public void setRepository(UsersRepository repository) {
    this.repository = repository;
  }

  public UserRolesRepository getUserRolesRepository() {
    return userRolesRepository;
  }

  public void setUserRolesRepository(UserRolesRepository userRoleRepository) {
    this.userRolesRepository = userRoleRepository;
  }

  @GetMapping
  @PreAuthorize("hasAuthority('READ_PRIVILEGE')")
  public List<User> findAll() {
    return repository.findAll();
  }

  @GetMapping(path = {"/{id}"})
  @PreAuthorize("hasAuthority('READ_PRIVILEGE')")
  public ResponseEntity<User> findById(@PathVariable long id) {
    return repository.findById(id)
      .map(record -> ResponseEntity.ok().body(record))
      .orElse(ResponseEntity.notFound().build());
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  @PreAuthorize("hasAuthority('CREATE_PRIVILEGE')")
  public User create(@RequestBody User user) {
    BCryptPasswordEncoder bCrypt = new BCryptPasswordEncoder();

    user.setPassword(bCrypt.encode(user.getPassword()));

    User userCreated = repository.saveAndFlush(user);

    userCreated.setUserRoles(userRolesRepository.findByUserId(userCreated.getId()));

    return userCreated;
  }

  @PutMapping(value="/{id}")
  @PreAuthorize("hasAuthority('UPDATE_PRIVILEGE')")
  public ResponseEntity<User> update(@PathVariable("id") long id, @RequestBody User user) {
    return repository.findById(id)
      .map(record -> {
        record.setActive(user.isActive());
        record.setEmail(user.getEmail());
        record.setName(user.getName());
        record.setUsername(user.getUsername());

        User updated = repository.save(record);

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
