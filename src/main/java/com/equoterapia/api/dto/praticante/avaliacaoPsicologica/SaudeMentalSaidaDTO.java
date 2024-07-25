package com.equoterapia.api.dto.praticante.avaliacaoPsicologica;

import com.equoterapia.dominio.enums.PreencherLegendaEnum;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class SaudeMentalSaidaDTO {

    // Saúde mental

    private Long idSaudeMental;
    private PreencherLegendaEnum apresentaConfusaoMental;
    private PreencherLegendaEnum apresentaDelirios;
    private PreencherLegendaEnum apresentaAlucinacoes;



}

