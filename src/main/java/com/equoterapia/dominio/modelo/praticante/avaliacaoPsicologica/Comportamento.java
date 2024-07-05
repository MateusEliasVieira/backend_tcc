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
public class Comportamento {

    // Comportamento

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idComportamento;
    private PreencherLegendaEnum agitacao;
    private PreencherLegendaEnum toleranciaFrustracao;
    private PreencherLegendaEnum respeitaLimitesRegras;
    private PreencherLegendaEnum oposicao;
    private PreencherLegendaEnum atencaoConcentracao;

    @OneToOne
    @JoinColumn
    private Praticante praticante;

}
