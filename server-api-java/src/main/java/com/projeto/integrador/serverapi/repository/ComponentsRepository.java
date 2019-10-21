package com.projeto.integrador.serverapi.repository;

import com.projeto.integrador.serverapi.model.Component;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComponentsRepository extends JpaRepository<Component, Long> {
}
