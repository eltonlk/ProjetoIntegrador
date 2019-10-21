package com.projeto.integrador.serverapi.repository;

import com.projeto.integrador.serverapi.model.Room;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomsRepository extends JpaRepository<Room, Long> {
}
