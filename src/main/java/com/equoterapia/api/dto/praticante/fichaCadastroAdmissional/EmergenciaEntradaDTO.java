package com.equoterapia.api.dto.praticante.fichaCadastroAdmissional;

import com.equoterapia.api.dto.praticante.PraticanteIdDTO;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.*;

import static com.equoterapia.utilidades.Resposta.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class EmergenciaEntradaDTO {

    // Emergência

    private Long idEmergencia;

    private String ligarPara;
    private String telefone;
    private Boolean possuiPlanoDeSaude;
    private String plano; // Caso tenha, qual é?

    @NotNull
    private PraticanteIdDTO praticante;

}
