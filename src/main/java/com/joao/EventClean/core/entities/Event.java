package com.joao.EventClean.core.entities;

import java.time.OffsetDateTime;

import com.joao.EventClean.core.entities.enums.Tipo;

public record Event(
    Long id,
    String nome,
    String descricao,
    OffsetDateTime inicio,
    OffsetDateTime fim,
    String lidentificador,
    String local,
    Tipo tipo
) {}
