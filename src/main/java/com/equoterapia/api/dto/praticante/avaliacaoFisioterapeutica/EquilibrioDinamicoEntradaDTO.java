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
    private EquilibrioDinamicoEnum engatinhar;
    private String comentariosEngatinhar;
    private EquilibrioDinamicoEnum marchaVoluntaria;
    private String comentariosMarchaVoluntaria;
    private EquilibrioDinamicoEnum saltarPesJuntos;
    private String comentariosSaltarPesJuntos;
    private EquilibrioDinamicoEnum correrDesviandoObstaculos;
    private String comentariosCorrerDesviandoObstaculos;

    @NotNull
    private PraticanteIdDTO praticante;

}

