package com.equoterapia.api.dto.praticante.avaliacaoFisioterapeutica;

import com.equoterapia.dominio.enums.EquilibrioEstatico;
import com.equoterapia.dominio.modelo.praticante.Praticante;
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


    private Praticante paciente;

}

