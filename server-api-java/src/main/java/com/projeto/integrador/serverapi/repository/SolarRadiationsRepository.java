package com.projeto.integrador.serverapi.repository;

import com.projeto.integrador.serverapi.model.SolarRadiation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SolarRadiationsRepository extends JpaRepository<SolarRadiation, Long> {
}
