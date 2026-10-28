package com.joao.EventClean.core.gateway;

import java.util.List;
import java.util.Optional;

import com.joao.EventClean.core.entities.Evento;

public interface  EventoGateway {

    Optional<Evento> filtrarPorIdentificador(String identificador);

    Evento criarEvento(Evento evento);

    List<Evento> buscarEventos();

    boolean existePorIdentificador(String identificador);

    Evento criarCodigo(Evento evento);

}
