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
    @Column(name = "nome", length = 255, nullable = false) 
    private String nome;
    @Column(name = "descricao", columnDefinition = "TEXT")
    private String descricao;
    @Column(name = "identificador", nullable = false, unique = true)
    private String identificador;
    @Column(name = "data_inicio", nullable = false)
    private LocalDateTime dataInicio;
    @Column(name = "data_fim", nullable = false)
    private LocalDateTime dataFim;
    @Column(name = "local_evento", length = 255, nullable = false)
    private String localEvento;
    @Column(nullable = false) 
    private Integer capacidade;
    @Column(length = 255, nullable = false)
    private String organizador;
    @Column(length = 50, nullable = false)
    @Enumerated (EnumType.STRING)
    private TipoEvento tipo;
}
