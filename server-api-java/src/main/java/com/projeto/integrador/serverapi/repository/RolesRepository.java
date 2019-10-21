package com.projeto.integrador.serverapi.repository;

import com.projeto.integrador.serverapi.model.Role;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolesRepository extends JpaRepository<Role, Long> {
}
