package com.equoterapia.api.dto.praticante.avaliacaoPsicologica;

import com.equoterapia.api.dto.praticante.PraticanteIdDTO;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class RotinaEntradaDTO {

    // Rotina

    private Long idRotina;
    @NotBlank
    private String brincadeiras;
    @NotBlank
    private String preferenciasPorBrincadeiras;
    @NotBlank
    private Boolean aceitaMudancasNaRotina;
    @NotBlank
    private String consideracoesSobreRotina;

    private PraticanteIdDTO paciente;

}

