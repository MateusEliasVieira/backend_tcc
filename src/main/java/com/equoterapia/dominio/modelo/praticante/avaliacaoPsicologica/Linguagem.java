package com.equoterapia.dominio.modelo.praticante.avaliacaoPsicologica;

import com.equoterapia.dominio.enums.PreencherLegendaEnum;
import com.equoterapia.dominio.modelo.praticante.Praticante;
import jakarta.persistence.*;
import lombok.*;

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
    private PreencherLegendaEnum mimicaFacial;
    private PreencherLegendaEnum monossilabos;
    private PreencherLegendaEnum frasesCurtas;
    private PreencherLegendaEnum frasesCompletas;

    private Boolean finalizado;

    @OneToOne
    @JoinColumn
    private Praticante praticante;

}

