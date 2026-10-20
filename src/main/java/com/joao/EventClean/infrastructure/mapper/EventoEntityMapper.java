package com.joao.EventClean.infrastructure.mapper;

import org.springframework.stereotype.Component;

import com.joao.EventClean.core.entities.Evento;
import com.joao.EventClean.infrastructure.persistence.EventoEntity;

@Component 
public class EventoEntityMapper {
    
    public EventoEntity toEntity(Evento evento){
        EventoEntity entity = new EventoEntity(
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

        return entity;
    }

    public Evento toDomain(EventoEntity entity){
        Evento domain = new Evento(
            entity.getId(),
            entity.getNome(),
            entity.getDescricao(),
            entity.getIdentificador(),
            entity.getDataInicio(),
            entity.getDataFim(),
            entity.getLocalEvento(),
            entity.getCapacidade(),
            entity.getOrganizador(),
            entity.getTipo()

        );
        return domain;
    }

}
