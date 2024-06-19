package com.equoterapia.api.dto.paciente.avaliacaoFisioterapeutica;

import com.equoterapia.domain.model.paciente.Paciente;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AvaliacaoFisioterapeutica {

    // Avaliação Fisioterapêutica
    private Long idAvaliacaoFisioterapeutica;
    private String diagnosticoFisioterapeutico;
    private String historicoGravidez;

    // Descrever Tonus Muscular
    private String tonusMuscular;

    // Conclusão/Indicação para Equoterapia
    private String conclusaoIndicacaoEquoterapia;

    private Paciente paciente;

}


