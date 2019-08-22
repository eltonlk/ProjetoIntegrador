package com.projeto.integrador.serverapi.controller;

import com.projeto.integrador.serverapi.model.Audit;
import com.projeto.integrador.serverapi.repository.AuditsRepository;

import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"/audits"})
public class AuditsController {

  private AuditsRepository repository;

  AuditsController(AuditsRepository auditsRepository) {
    this.setRepository(auditsRepository);
  }

  public AuditsRepository getRepository() {
    return repository;
  }

  public void setRepository(AuditsRepository repository) {
    this.repository = repository;
  }

  @GetMapping
  @PreAuthorize("hasRole('ROLE_ADMIN')")
  public List<Audit> findAll() {
    return repository.findAll();
  }

}
