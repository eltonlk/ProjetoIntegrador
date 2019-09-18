package com.projeto.integrador.serverapi.controller;

import com.projeto.integrador.serverapi.model.Privilege;
import com.projeto.integrador.serverapi.model.Role;
import com.projeto.integrador.serverapi.model.User;
// import com.projeto.integrador.serverapi.repository.PrivilegesRepository;
// import com.projeto.integrador.serverapi.repository.RolesRepository;
import com.projeto.integrador.serverapi.repository.UsersRepository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

  // @Autowired
  // private PrivilegesRepository privilegesRepository;

  // @Autowired
  // private RolesRepository rolesRepository;

  private UsersRepository repository;

  UsersController(UsersRepository usersRepository) {
    this.setRepository(usersRepository);
  }

  public UsersRepository getRepository() {
    return repository;
  }

  public void setRepository(UsersRepository repository) {
    this.repository = repository;
  }

  @GetMapping
  public List<User> findAll(){
    return repository.findAll();
  }

  @GetMapping(path = {"/{id}"})
  public ResponseEntity<User> findById(@PathVariable long id) {
    return repository.findById(id)
      .map(record -> ResponseEntity.ok().body(record))
      .orElse(ResponseEntity.notFound().build());
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public User create(@RequestBody User user) {
    BCryptPasswordEncoder bCrypt = new BCryptPasswordEncoder();

    user.setPassword(bCrypt.encode(user.getPassword()));

    return repository.save(user);
  }

  @PutMapping(value="/{id}")
  public ResponseEntity<User> update(@PathVariable("id") long id, @RequestBody User user) {
    return repository.findById(id)
      .map(record -> {
        record.setEmail(user.getEmail());
        record.setName(user.getName());
        record.setUsername(user.getUsername());
        record.setActive(user.isActive());

        // for (Role role : record.getRoles()) {
        //   for (Privilege privilege : role.getPrivileges()) {
        //     privilegesRepository.delete(privilege);
        //   }

        //   rolesRepository.delete(role);
        // }

        // for (Role role : user.getRoles()) {
        //   List<Privilege> privileges = new ArrayList<>();

        //   for (Privilege privilege : role.getPrivileges()) {
        //     Privilege newPrivilege = new Privilege();
        //     newPrivilege.setName(privilege.getName());

        //     // privileges.add(privilegesRepository.save(newPrivilege));
        //   }

        //   Role newRole = new Role();
        //   newRole.setName(role.getName());
        //   newRole.setPrivileges(privileges);

        //   // rolesRepository.save(newRole);
        // }

        User updated = repository.save(record);

        return ResponseEntity.ok().body(updated);
      }).orElse(ResponseEntity.notFound().build());
  }

  @DeleteMapping(path ={"/{id}"})
  public ResponseEntity<?> delete(@PathVariable long id) {
    return repository.findById(id)
      .map(record -> {
        repository.delete(record);

        return ResponseEntity.ok().build();
      }).orElse(ResponseEntity.notFound().build());
  }
}
