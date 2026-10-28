package com.joao.EventClean.core.usecases;

import java.util.Random;

import com.joao.EventClean.core.entities.Evento;
import com.joao.EventClean.core.gateway.EventoGateway;

public class CriarRandomCodigoUseCaseImpl implements CriarRandomCodigoUseCase{

    private final EventoGateway eventoGateway;

    public CriarRandomCodigoUseCaseImpl(EventoGateway eventoGateway) {
        this.eventoGateway = eventoGateway;
    }

    final String alphabetic = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    final String numeric = "0123456789";
    int total = alphabetic.length() + numeric.length();

    public String gerarCodigo() {
        StringBuilder sb = new StringBuilder(total);
        Random randon = new Random();
    
        while(sb.length() < 6) {
            if (sb.length() < 3) {
                sb.append(alphabetic.charAt(randon.nextInt(alphabetic.length())));
            } else {
                sb.append(numeric.charAt(randon.nextInt(numeric.length())));
            }
        }
        
        return sb.toString();
    }

    @Override
    public Evento execute(Evento ev) {
        String codigoGerado = gerarCodigo();
        Evento eventoNovo = new Evento(
            ev.id(),
            ev.nome(),
            ev.descricao(),
            codigoGerado,
            ev.dataInicio(),
            ev.dataFim(),
            ev.localEvento(),
            ev.capacidade(),
            ev.organizador(),
            ev.tipo()
    
    ); 
        return eventoGateway.criarCodigo(eventoNovo);
    }
}
// https://share.google/aimode/LAaIEDR5nI45mCe0d