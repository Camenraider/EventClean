package com.joao.EventClean.core.usecases;

import com.joao.EventClean.core.entities.Evento;
import com.joao.EventClean.core.gateway.EventoGateway;
import com.joao.EventClean.infrastructure.exception.NotFoundEventException;

public class FiltrarIdentificadorEventoUseCaseImpl implements FiltrarIdentificadorEventoUseCase{

    private final EventoGateway eventoGateway;

    public FiltrarIdentificadorEventoUseCaseImpl(EventoGateway eventoGateway) {
        this.eventoGateway = eventoGateway;
    }

    @Override
    public Evento execute(String identificador) {
        return eventoGateway.filtrarPorIdentificador(identificador).orElseThrow(
            () -> new NotFoundEventException("Evento com identificador: " + identificador + " não encontrado")
        );
    }

}
