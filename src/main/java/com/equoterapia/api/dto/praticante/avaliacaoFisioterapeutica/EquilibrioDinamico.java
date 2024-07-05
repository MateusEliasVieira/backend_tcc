package com.equoterapia.api.dto.praticante.avaliacaoFisioterapeutica;

import com.equoterapia.dominio.enums.EquilibrioEstaticoEnum;
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
    private EquilibrioEstaticoEnum engatinhar;
    @NotBlank
    private String comentariosEngatinhar;
    @Enumerated @NotBlank
    private EquilibrioEstaticoEnum marchaVoluntaria;
    @NotBlank
    private String comentariosMarchaVoluntaria;
    @Enumerated @NotBlank
    private EquilibrioEstaticoEnum saltarPesJuntos;
    @NotBlank
    private String comentariosSaltarPesJuntos;
    @Enumerated @NotBlank
    private EquilibrioEstaticoEnum correrDesviandoObstaculos;
    @NotBlank
    private String comentariosCorrerDesviandoObstaculos;


    private Praticante praticante;

}

