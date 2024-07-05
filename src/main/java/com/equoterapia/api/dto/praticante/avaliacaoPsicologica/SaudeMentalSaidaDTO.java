package com.equoterapia.api.dto.praticante.avaliacaoPsicologica;

import com.equoterapia.api.dto.praticante.Praticante;
import com.equoterapia.dominio.enums.PreencherLegendaEnum;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class SaudeMentalSaidaDTO {

    // Saúde mental

    private Long idSaudeMental;
    @Enumerated @NotNull
    private PreencherLegendaEnum apresentaConfusaoMental;
    @Enumerated @NotNull
    private PreencherLegendaEnum apresentaDelirios;
    @Enumerated @NotNull
    private PreencherLegendaEnum apresentaAlucinacoes;

    private Praticante praticante;

}

