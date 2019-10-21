package com.projeto.integrador.serverapi.repository;

import com.projeto.integrador.serverapi.model.Privilege;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrivilegesRepository extends JpaRepository<Privilege, Long> {
}
