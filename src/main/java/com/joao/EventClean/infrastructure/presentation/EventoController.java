package com.joao.EventClean.infrastructure.presentation;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.joao.EventClean.core.entities.Evento;
import com.joao.EventClean.core.usecases.BuscarEventoUseCase;
import com.joao.EventClean.core.usecases.CriarEventoUseCase;
import com.joao.EventClean.core.usecases.CriarRandomCodigoUseCase;
import com.joao.EventClean.core.usecases.FiltrarIdentificadorEventoUseCase;
import com.joao.EventClean.infrastructure.dtos.EventoDto;
import com.joao.EventClean.infrastructure.mapper.EventoDtoMapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("api/v1/")
public class EventoController {

    private final CriarEventoUseCase criarEventoCase;
    private final EventoDtoMapper eventoDtoMapper;
    private final BuscarEventoUseCase buscarEventoUseCase;
    private final FiltrarIdentificadorEventoUseCase filtrarIdentificadorEventoUseCase;
    private final CriarRandomCodigoUseCase criarRandomCodigoUseCase;
    
    public EventoController(CriarEventoUseCase criarEventoCase, EventoDtoMapper eventoDtoMapper,
            BuscarEventoUseCase buscarEventoUseCase, FiltrarIdentificadorEventoUseCase filtrarIdentificadorEventoUseCase,
            CriarRandomCodigoUseCase criarRandomCodigoUseCase) {
        this.criarEventoCase = criarEventoCase;
        this.eventoDtoMapper = eventoDtoMapper;
        this.buscarEventoUseCase = buscarEventoUseCase;
        this.filtrarIdentificadorEventoUseCase = filtrarIdentificadorEventoUseCase;
        this.criarRandomCodigoUseCase = criarRandomCodigoUseCase;
        
    }

    @PostMapping("criarevento")
    public ResponseEntity<Map<String, Object>> criarEvento(@RequestBody EventoDto dto) {
        Evento novoEvento = criarEventoCase.execute(eventoDtoMapper.toDomain(dto));
        Map<String, Object> response = new HashMap<>();
        EventoDto eventoDto = eventoDtoMapper.toDto(novoEvento);
        response.put("Mensagem:", "Evento cadastrado com sucesso no nosso banco de dados");
        response.put("Dados do evento", eventoDto);

        return ResponseEntity.ok(response);
    }

    @GetMapping("buscarevento")
    public List<EventoDto> listarEvento() {
        List<Evento> listaEventos = buscarEventoUseCase.execute();
        return listaEventos.stream().map(eventoDtoMapper::toDto).collect(Collectors.toList()); 
    }

    @GetMapping("identificador/{identificador}")
    public ResponseEntity<EventoDto> buscaPorIdentificador(@PathVariable  String identificador) {
        Evento evento = filtrarIdentificadorEventoUseCase.execute(identificador);
        return ResponseEntity.ok(eventoDtoMapper.toDto(evento));
    }

    @PostMapping("criar/identificador/auto")
    public ResponseEntity<Map<String, Object>> criarEventoCodeAuto(@RequestBody EventoDto dto) {
        Evento novoEvento = criarRandomCodigoUseCase.execute(eventoDtoMapper.toDomain(dto));
        Map<String, Object> response = new HashMap<>();
        EventoDto eventoDto = eventoDtoMapper.toDto(novoEvento);
        response.put("Mensagem:", "Evento cadastrado com sucesso no nosso banco de dados");
        response.put("Dados do evento", eventoDto);

        return ResponseEntity.ok(response); 
    }
    
    

}
