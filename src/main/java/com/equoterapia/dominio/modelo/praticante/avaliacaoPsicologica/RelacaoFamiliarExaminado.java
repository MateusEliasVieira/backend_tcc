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
public class RelacaoFamiliarExaminado {

    // Relação da família com o examinado (percepção do entrevistador)

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRelacaoFamiliarExaminado;
    private PreencherLegendaEnum adequado;
    private PreencherLegendaEnum superprotecao;
    private PreencherLegendaEnum dificuldadePerceberDeficiencias;
    private PreencherLegendaEnum rejeicao;
    private PreencherLegendaEnum indiferenca;
    private PreencherLegendaEnum ansiedadePercebidaEntrevistador;

    @OneToOne
    @JoinColumn
    private Praticante praticante;

}

