package com.joao.EventClean.infrastructure.beans;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.joao.EventClean.core.gateway.EventoGateway;
import com.joao.EventClean.core.usecases.BuscarEventoUseCase;
import com.joao.EventClean.core.usecases.BuscarEventoUseCaseImpl;
import com.joao.EventClean.core.usecases.CriarEventoUseCase;
import com.joao.EventClean.core.usecases.CriarEventoUseCaseImpl;
import com.joao.EventClean.core.usecases.CriarRandomCodigoUseCase;
import com.joao.EventClean.core.usecases.CriarRandomCodigoUseCaseImpl;
import com.joao.EventClean.core.usecases.FiltrarIdentificadorEventoUseCase;
import com.joao.EventClean.core.usecases.FiltrarIdentificadorEventoUseCaseImpl;

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

    @Bean 
    public FiltrarIdentificadorEventoUseCase filtrarIdentificadorEventoUseCase(EventoGateway eventoGateway) {
        return new FiltrarIdentificadorEventoUseCaseImpl(eventoGateway);
    }

    @Bean 
    public CriarRandomCodigoUseCase criarRandomCodigoUseCase(EventoGateway eventoGateway) {
        return new CriarRandomCodigoUseCaseImpl(eventoGateway);
    }
}
