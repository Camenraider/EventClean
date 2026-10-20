package com.joao.EventClean.core.usecases;

import com.joao.EventClean.core.entities.Evento;
import com.joao.EventClean.core.gateway.EventoGateway;
import com.joao.EventClean.infrastructure.exception.DuplicateEventException;


public class CriarEventoUseCaseImpl implements CriarEventoUseCase{

    private final EventoGateway eventoGateway;

    public CriarEventoUseCaseImpl(EventoGateway eventoGateway) {
        this.eventoGateway = eventoGateway;
    }

    @Override
    public Evento execute(Evento evento) {

        if (eventoGateway.existePorIdentificador(evento.identificador())) {
            throw new DuplicateEventException("O identificador número: " + evento.identificador() + " já está em uso!");
        }

        return eventoGateway.criarEvento(evento);
    }
    
}
