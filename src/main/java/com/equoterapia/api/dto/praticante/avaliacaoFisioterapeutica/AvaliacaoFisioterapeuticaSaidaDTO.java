package com.equoterapia.api.dto.praticante.avaliacaoFisioterapeutica;

import com.equoterapia.dominio.modelo.praticante.Praticante;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AvaliacaoFisioterapeuticaSaidaDTO {

    // Avaliação Fisioterapêutica
    private Long idAvaliacaoFisioterapeutica;
    private String diagnosticoFisioterapeutico;
    private String historicoGravidez;

    // Descrever Tonus Muscular
    private String tonusMuscular;

    // Conclusão/Indicação para Equoterapia
    private String conclusaoIndicacaoEquoterapia;


}


