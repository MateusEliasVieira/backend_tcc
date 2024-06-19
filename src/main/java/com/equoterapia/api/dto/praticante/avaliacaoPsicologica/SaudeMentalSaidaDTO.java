package com.equoterapia.api.dto.praticante.avaliacaoPsicologica;

import com.equoterapia.api.dto.praticante.Praticante;
import com.equoterapia.dominio.enums.PreencherLegenda;
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
    private PreencherLegenda apresentaConfusaoMental;
    @Enumerated @NotNull
    private PreencherLegenda apresentaDelirios;
    @Enumerated @NotNull
    private PreencherLegenda apresentaAlucinacoes;

    private Praticante praticante;

}

