package com.projeto.integrador.serverapi.repository;

import java.util.Collection;

import com.projeto.integrador.serverapi.model.UserRole;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRolesRepository extends JpaRepository<UserRole, Long> {

  Collection<UserRole> findByUserId(long userId);

}
