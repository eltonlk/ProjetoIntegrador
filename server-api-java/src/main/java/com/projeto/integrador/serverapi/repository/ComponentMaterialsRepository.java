package com.projeto.integrador.serverapi.repository;

import com.projeto.integrador.serverapi.model.ComponentMaterial;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComponentMaterialsRepository extends JpaRepository<ComponentMaterial, Long> {
}
