package com.joao.EventClean.infrastructure.gateway;

import java.util.List;

import org.springframework.stereotype.Component;

import com.joao.EventClean.core.entities.Evento;
import com.joao.EventClean.core.gateway.EventoGateway;
import com.joao.EventClean.infrastructure.mapper.EventoEntityMapper;
import com.joao.EventClean.infrastructure.persistence.EventoEntity;
import com.joao.EventClean.infrastructure.persistence.EventoRepository;

@Component
public class EventoRepositoryGateway implements EventoGateway {

    private final EventoRepository eventoRepository;
    private final EventoEntityMapper mapper;

    public EventoRepositoryGateway(EventoRepository eventoRepository, EventoEntityMapper eventoEntityMapper) {
        this.eventoRepository = eventoRepository;
        this.mapper = eventoEntityMapper;
    }

    @Override
    public Evento criarEvento(Evento evento) {
        EventoEntity novoEvento = eventoRepository.save(mapper.toEntity(evento));
        return mapper.toDomain(novoEvento);
    }

    @Override
    public List<Evento> buscarEventos() {
        // return eventoRepository.findAll().stream().map(entity -> mapper.toDomain(entity)).toList();
        return eventoRepository.findAll().stream().map(mapper::toDomain).toList();
    }

    @Override
    public boolean existePorIdentificador(String identificador) {
        return eventoRepository.findAll().stream()
                    .anyMatch(evento -> evento.getIdentificador().equalsIgnoreCase(identificador));
    }

}
