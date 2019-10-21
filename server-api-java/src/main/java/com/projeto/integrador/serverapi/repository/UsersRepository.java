package com.projeto.integrador.serverapi.repository;

import com.projeto.integrador.serverapi.model.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<User, Long> {

  User findByUsername(String username);

}
