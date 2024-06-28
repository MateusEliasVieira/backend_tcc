package com.equoterapia.api.dto.praticante.avaliacaoPsicologica;

import com.equoterapia.api.dto.praticante.PraticanteIdDTO;
import com.equoterapia.dominio.enums.PreencherLegenda;
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
    @Enumerated @NotNull
    private PreencherLegenda apresentaConfusaoMental;
    @Enumerated @NotNull
    private PreencherLegenda apresentaDelirios;
    @Enumerated @NotNull
    private PreencherLegenda apresentaAlucinacoes;

    private PraticanteIdDTO praticante;

}

