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
public class TracosDePersonalidade {

    // Traços de personalidade

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTracosDePersonalidade;
    private PreencherLegendaEnum extroversao;
    private PreencherLegendaEnum fobia;
    private PreencherLegendaEnum obsessao;
    private PreencherLegendaEnum introversao;
    private PreencherLegendaEnum ansiedade;
    private PreencherLegendaEnum histeria;
    private PreencherLegendaEnum dependenciaEmocional;
    private PreencherLegendaEnum timidez;

    @OneToOne
    @JoinColumn
    private Praticante praticante;
}
