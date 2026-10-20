package com.joao.EventClean.core.usecases;

import com.joao.EventClean.core.entities.Evento;

public interface FiltrarIdentificadorEventoUseCase {

    public Evento execute(String identificador);
}
