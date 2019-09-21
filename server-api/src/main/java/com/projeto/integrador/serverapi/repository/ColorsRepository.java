package com.projeto.integrador.serverapi.repository;

import com.projeto.integrador.serverapi.model.Color;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ColorsRepository extends JpaRepository<Color, Long> {
}
