package com.joao.EventClean.infrastructure.dtos;

import java.time.LocalDateTime;

import com.joao.EventClean.core.enums.TipoEvento;

public record EventoDto(
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
