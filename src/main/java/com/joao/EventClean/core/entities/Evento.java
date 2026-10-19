package com.joao.EventClean.core.entities;

import java.time.LocalDateTime;

import com.joao.EventClean.core.enums.TipoEvento;

public record Evento(
    Long id,
    String nome,
    String descricao,
    String lidentificador,
    LocalDateTime inicio,
    LocalDateTime fim,
    String local,
    String organizador,
    TipoEvento tipo
) {}
