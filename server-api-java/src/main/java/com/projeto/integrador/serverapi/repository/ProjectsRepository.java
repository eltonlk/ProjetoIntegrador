package com.projeto.integrador.serverapi.repository;

import com.projeto.integrador.serverapi.model.Project;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectsRepository extends JpaRepository<Project, Long> {
}
