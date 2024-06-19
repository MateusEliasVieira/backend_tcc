package com.equoterapia.domain.model.paciente.avaliacaoFisioterapeutica;

import com.equoterapia.domain.enums.EquilibrioEstatico;
import com.equoterapia.domain.model.paciente.Paciente;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class EquilibrioDinamico {

    // Equilíbrio Dinâmico

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEquilibrioDinamico;
    private EquilibrioEstatico engatinhar;
    private String comentariosEngatinhar;
    private EquilibrioEstatico marchaVoluntaria;
    private String comentariosMarchaVoluntaria;
    private EquilibrioEstatico saltarPesJuntos;
    private String comentariosSaltarPesJuntos;
    private EquilibrioEstatico correrDesviandoObstaculos;
    private String comentariosCorrerDesviandoObstaculos;

    @OneToOne
    @JoinColumn(name = "paciente_id_fk")
    private Paciente paciente;

}

