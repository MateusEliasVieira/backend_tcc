package com.equoterapia.api.dto.paciente.avaliacaoFisioterapeutica;

import com.equoterapia.domain.enums.EquilibrioEstatico;
import com.equoterapia.domain.model.paciente.Paciente;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class EquilibrioDinamico {

    // Equilíbrio Dinâmico

    private Long idEquilibrioDinamico;
    @Enumerated @NotBlank
    private EquilibrioEstatico engatinhar;
    @NotBlank
    private String comentariosEngatinhar;
    @Enumerated @NotBlank
    private EquilibrioEstatico marchaVoluntaria;
    @NotBlank
    private String comentariosMarchaVoluntaria;
    @Enumerated @NotBlank
    private EquilibrioEstatico saltarPesJuntos;
    @NotBlank
    private String comentariosSaltarPesJuntos;
    @Enumerated @NotBlank
    private EquilibrioEstatico correrDesviandoObstaculos;
    @NotBlank
    private String comentariosCorrerDesviandoObstaculos;


    private Paciente paciente;

}

