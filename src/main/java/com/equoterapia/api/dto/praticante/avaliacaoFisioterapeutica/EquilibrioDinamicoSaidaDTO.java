package com.equoterapia.api.dto.praticante.avaliacaoFisioterapeutica;

import com.equoterapia.dominio.enums.EquilibrioDinamicoEnum;
import com.equoterapia.dominio.enums.EquilibrioEstaticoEnum;
import com.equoterapia.dominio.modelo.praticante.Praticante;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class EquilibrioDinamicoSaidaDTO {

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

}

