package com.joao.EventClean.core.usecases;

import java.util.List;

import com.joao.EventClean.core.entities.Evento;
import com.joao.EventClean.core.gateway.EventoGateway;

public class BuscarEventoUseCaseImpl implements BuscarEventoUseCase{

    private final EventoGateway eventoGateway;

    public BuscarEventoUseCaseImpl(EventoGateway eventoGateway) {
        this.eventoGateway = eventoGateway;
    }

    @Override
    public List<Evento> execute() {
        return eventoGateway.buscarEventos();
    }
    
}
