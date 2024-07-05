package com.equoterapia.dominio.modelo.praticante.avaliacaoPsicologica;

import com.equoterapia.dominio.enums.PreencherLegendaEnum;
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
    private PreencherLegendaEnum compreensaoVerbal;
    private PreencherLegendaEnum gesto;
    private PreencherLegendaEnum gritos;
    private PreencherLegendaEnum mímicaFacial;
    private PreencherLegendaEnum monossílabos;
    private PreencherLegendaEnum frasesCurtas;
    private PreencherLegendaEnum frasesCompletas;

    @OneToOne
    @JoinColumn
    private Praticante praticante;

}

