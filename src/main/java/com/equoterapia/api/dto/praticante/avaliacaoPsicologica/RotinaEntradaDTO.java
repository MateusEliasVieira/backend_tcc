package com.equoterapia.api.dto.praticante.avaliacaoPsicologica;

import com.equoterapia.api.dto.praticante.PraticanteIdDTO;
import com.equoterapia.dominio.enums.SImOuNaoEnum;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class RotinaEntradaDTO {

    // Rotina

    private Long idRotina;
    private String brincadeiras;
    private String preferenciasPorBrincadeiras;
    private SImOuNaoEnum aceitaMudancasNaRotina;
    private String consideracoesSobreRotina;

    @NotNull
    private PraticanteIdDTO praticante;

}

