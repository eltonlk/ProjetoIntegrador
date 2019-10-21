package com.projeto.integrador.serverapi.repository;

import com.projeto.integrador.serverapi.model.Material;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MaterialsRepository extends JpaRepository<Material, Long> {
}
