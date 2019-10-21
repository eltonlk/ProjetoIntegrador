package com.projeto.integrador.serverapi.repository;

import com.projeto.integrador.serverapi.model.Face;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FacesRepository extends JpaRepository<Face, Long> {
}
