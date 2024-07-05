package com.equoterapia.dominio.modelo.praticante.avaliacaoFisioterapeutica;

import com.equoterapia.dominio.enums.EquilibrioDinamicoEnum;
import com.equoterapia.dominio.modelo.praticante.Praticante;
import jakarta.persistence.*;
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
    private EquilibrioDinamicoEnum engatinhar;
    private String comentariosEngatinhar;
    private EquilibrioDinamicoEnum marchaVoluntaria;
    private String comentariosMarchaVoluntaria;
    private EquilibrioDinamicoEnum saltarPesJuntos;
    private String comentariosSaltarPesJuntos;
    private EquilibrioDinamicoEnum correrDesviandoObstaculos;
    private String comentariosCorrerDesviandoObstaculos;

    @OneToOne
    @JoinColumn
    private Praticante praticante;

}

