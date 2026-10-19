package com.joao.EventClean.infrastructure.persistence;

import java.time.LocalDateTime;

import com.joao.EventClean.core.enums.TipoEvento;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor 
@Data 
@Entity
@Table(name = "Eventos")
public class EventoEntity {

    @Id 
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    @Column 
    private String nome;
    @Column
    private String descricao;
    @Column
    private String identificador;
    @Column(name = "data_inicio")
    private LocalDateTime dataInicio;
    @Column(name = "data_fim")
    private LocalDateTime dataFim;
    @Column(name = "local_evento")
    private String localEvento;
    @Column 
    private Integer capacidade;
    @Column
    private String organizador;
    @Column
    @Enumerated (EnumType.STRING)
    private TipoEvento tipo;
}
