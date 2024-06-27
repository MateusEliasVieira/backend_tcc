package com.equoterapia.dominio.modelo.praticante.avaliacaoPsicologica;

import com.equoterapia.dominio.enums.PreencherLegenda;
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
public class Linguagem {

    // Linguagem

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idLinguagem;
    private PreencherLegenda compreensaoVerbal;
    private PreencherLegenda gesto;
    private PreencherLegenda gritos;
    private PreencherLegenda mímicaFacial;
    private PreencherLegenda monossílabos;
    private PreencherLegenda frasesCurtas;
    private PreencherLegenda frasesCompletas;

    @OneToOne
    @JoinColumn
    private Praticante praticante;

}

