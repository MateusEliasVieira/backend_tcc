package com.equoterapia.api.dto.praticante.avaliacaoFisioterapeutica;

import com.equoterapia.api.dto.praticante.PraticanteIdDTO;
import com.equoterapia.dominio.modelo.praticante.Praticante;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AvaliacaoFisioterapeuticaEntradaDTO {

    // Avaliação Fisioterapêutica
    private Long idAvaliacaoFisioterapeutica;
    private String diagnosticoFisioterapeutico;
    private String historicoGravidez;
    // Descrever Tonus Muscular
    private String tonusMuscular;
    // Conclusão/Indicação para Equoterapia
    private String conclusaoIndicacaoEquoterapia;

    @NotNull
    private PraticanteIdDTO praticante;

}


