package com.joao.EventClean.core.entities;

import java.time.LocalDateTime;

import com.joao.EventClean.core.enums.TipoEvento;

public record Evento(
    Long id,
    String nome,
    String descricao,
    String identificador,
    LocalDateTime dataInicio,
    LocalDateTime dataFim,
    String localEvento,
    Integer capacidade,
    String organizador,
    TipoEvento tipo
) {}
