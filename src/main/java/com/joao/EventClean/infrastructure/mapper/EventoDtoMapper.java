package com.joao.EventClean.infrastructure.mapper;

import org.springframework.stereotype.Component;

import com.joao.EventClean.core.entities.Evento;
import com.joao.EventClean.infrastructure.dtos.EventoDto;

@Component 
public class EventoDtoMapper {
    
    public EventoDto toDto(Evento evento) {
        EventoDto dto = new EventoDto(
            evento.id(),
            evento.nome(), 
            evento.descricao(),
            evento.identificador(),
            evento.dataInicio(),
            evento.dataFim(),
            evento.localEvento(),
            evento.capacidade(),
            evento.organizador(),
            evento.tipo()
        );
        return  dto;
    }

    public Evento toDomain(EventoDto dto) {
        Evento entity = new Evento(
            dto.id(), 
            dto.nome(), 
            dto.descricao(), 
            dto.identificador(), 
            dto.dataInicio(), 
            dto.dataFim(), 
            dto.localEvento(), 
            dto.capacidade(), 
            dto.organizador(),
            dto.tipo()
        );
        return entity;    
    }
}
