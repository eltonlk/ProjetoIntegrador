package com.projeto.integrador.serverapi.repository;

import com.projeto.integrador.serverapi.model.Option;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OptionsRepository extends JpaRepository<Option, Long> {
}
