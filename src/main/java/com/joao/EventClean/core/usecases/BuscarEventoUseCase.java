package com.joao.EventClean.core.usecases;

import java.util.List;

import com.joao.EventClean.core.entities.Evento;

public interface BuscarEventoUseCase {

    public List<Evento> execute();
}
