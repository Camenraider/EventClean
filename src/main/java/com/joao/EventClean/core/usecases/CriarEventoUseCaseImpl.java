package com.joao.EventClean.core.usecases;

import com.joao.EventClean.core.entities.Evento;
import com.joao.EventClean.core.gateway.EventoGateway;


public class CriarEventoUseCaseImpl implements CriarEventoUseCase{

    private final EventoGateway eventoGateway;

    public CriarEventoUseCaseImpl(EventoGateway eventoGateway) {
        this.eventoGateway = eventoGateway;
    }

    @Override
    public Evento execute(Evento evento) {
        return eventoGateway.criarEvento(evento);
    }
    
}
