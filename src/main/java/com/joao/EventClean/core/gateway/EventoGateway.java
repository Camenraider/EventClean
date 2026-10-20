package com.joao.EventClean.core.gateway;

import java.util.List;

import com.joao.EventClean.core.entities.Evento;

public interface  EventoGateway {

    Evento criarEvento(Evento evento);

    List<Evento> buscarEventos();
}
