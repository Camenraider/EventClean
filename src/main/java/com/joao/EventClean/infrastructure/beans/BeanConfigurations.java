package com.joao.EventClean.infrastructure.beans;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.joao.EventClean.core.gateway.EventoGateway;
import com.joao.EventClean.core.usecases.BuscarEventoUseCase;
import com.joao.EventClean.core.usecases.BuscarEventoUseCaseImpl;
import com.joao.EventClean.core.usecases.CriarEventoUseCase;
import com.joao.EventClean.core.usecases.CriarEventoUseCaseImpl;

@Configuration 
public class BeanConfigurations {
    
    @Bean 
    public CriarEventoUseCase criarEventoUCase(EventoGateway eventoGateway) {
        return new CriarEventoUseCaseImpl(eventoGateway);
    }

    @Bean 
    public BuscarEventoUseCase buscarEventoUseCase(EventoGateway eventoGateway) {
        return new BuscarEventoUseCaseImpl(eventoGateway);
    }
}
