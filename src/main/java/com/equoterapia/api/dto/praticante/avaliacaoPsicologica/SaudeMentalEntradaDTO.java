package com.equoterapia.api.dto.praticante.avaliacaoPsicologica;

import com.equoterapia.api.dto.praticante.PraticanteIdDTO;
import com.equoterapia.dominio.enums.PreencherLegendaEnum;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class SaudeMentalEntradaDTO {

    // Saúde mental

    private Long idSaudeMental;
    private PreencherLegendaEnum apresentaConfusaoMental;
    private PreencherLegendaEnum apresentaDelirios;
    private PreencherLegendaEnum apresentaAlucinacoes;

    @NotNull
    private PraticanteIdDTO praticante;

}

