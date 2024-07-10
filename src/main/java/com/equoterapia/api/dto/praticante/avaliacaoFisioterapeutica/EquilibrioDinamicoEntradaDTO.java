package com.equoterapia.api.dto.praticante.avaliacaoFisioterapeutica;

import com.equoterapia.api.dto.praticante.PraticanteIdDTO;
import com.equoterapia.dominio.enums.EquilibrioDinamicoEnum;
import com.equoterapia.dominio.enums.EquilibrioEstaticoEnum;
import com.equoterapia.dominio.modelo.praticante.Praticante;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class EquilibrioDinamicoEntradaDTO {

    // Equilíbrio Dinâmico

    private Long idEquilibrioDinamico;
    @Enumerated @NotBlank
    private EquilibrioDinamicoEnum engatinhar;
    @NotBlank
    private String comentariosEngatinhar;
    @Enumerated @NotBlank
    private EquilibrioDinamicoEnum marchaVoluntaria;
    @NotBlank
    private String comentariosMarchaVoluntaria;
    @Enumerated @NotBlank
    private EquilibrioDinamicoEnum saltarPesJuntos;
    @NotBlank
    private String comentariosSaltarPesJuntos;
    @Enumerated @NotBlank
    private EquilibrioDinamicoEnum correrDesviandoObstaculos;
    @NotBlank
    private String comentariosCorrerDesviandoObstaculos;

    @NotNull
    private PraticanteIdDTO praticante;

}

