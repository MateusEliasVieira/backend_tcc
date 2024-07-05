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
public class HabilidadesSociais {

    // Habilidades sociais

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idHabilidadesSociais;
    private PreencherLegendaEnum passividade;
    private PreencherLegendaEnum autoagressao;
    private PreencherLegendaEnum heteroagressividade;
    private PreencherLegendaEnum assertividade;

    @OneToOne
    @JoinColumn
    private Praticante praticante;
}

