package com.joao.EventClean.infrastructure.persistence;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.stereotype.Repository;

import com.joao.EventClean.core.entities.Evento;

// @Repository
public interface  EventoRepository extends JpaRepository<EventoEntity, Long>{
    
    Optional<Evento> findByIdentificador(String identificador);
}
