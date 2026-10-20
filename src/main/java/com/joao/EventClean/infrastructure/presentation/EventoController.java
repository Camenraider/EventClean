package com.joao.EventClean.infrastructure.presentation;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.joao.EventClean.core.entities.Evento;
import com.joao.EventClean.core.usecases.BuscarEventoUseCase;
import com.joao.EventClean.core.usecases.CriarEventoUseCase;
import com.joao.EventClean.infrastructure.dtos.EventoDto;
import com.joao.EventClean.infrastructure.mapper.EventoDtoMapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("api/v1/")
public class EventoController {

    private final CriarEventoUseCase criarEventoCase;
    private final EventoDtoMapper eventoDtoMapper;
    private final BuscarEventoUseCase buscarEventoUseCase;

    public EventoController(CriarEventoUseCase criarEventoCase, EventoDtoMapper eventoDtoMapper,
            BuscarEventoUseCase buscarEventoUseCase) {
        this.criarEventoCase = criarEventoCase;
        this.eventoDtoMapper = eventoDtoMapper;
        this.buscarEventoUseCase = buscarEventoUseCase;
    }

    @PostMapping("criarevento")
    public EventoDto criarEvento(@RequestBody EventoDto dto) {
        Evento novoEvento = criarEventoCase.execute(eventoDtoMapper.toDomain(dto));
        return eventoDtoMapper.toDto(novoEvento);
    }

    @GetMapping("buscarevento")
    public List<EventoDto> listarEvento() {
        List<Evento> listaEventos = buscarEventoUseCase.execute();
        return listaEventos.stream().map(eventoDtoMapper::toDto).collect(Collectors.toList()); 
    }

}
