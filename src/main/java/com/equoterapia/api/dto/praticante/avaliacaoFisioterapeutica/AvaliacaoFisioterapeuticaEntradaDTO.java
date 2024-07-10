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
    @NotBlank
    private String diagnosticoFisioterapeutico;
    @NotBlank
    private String historicoGravidez;

    // Descrever Tonus Muscular
    @NotBlank
    private String tonusMuscular;

    // Conclusão/Indicação para Equoterapia
    @NotBlank
    private String conclusaoIndicacaoEquoterapia;

    @NotNull
    private PraticanteIdDTO praticante;

}


