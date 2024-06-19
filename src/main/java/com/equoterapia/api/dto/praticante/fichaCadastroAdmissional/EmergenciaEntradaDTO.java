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
    @NotBlank(message = LIGAR_PARA)
    private String ligarPara;
    @NotBlank(message = TELEFONE)
    @Pattern(regexp = "\\(\\d{2}\\)\\d{5}-\\d{4}", message = FORMATO_TELEFONE)
    private String telefone;
    @NotNull
    private Boolean possuiPlanoDeSaude;
    private String plano; // Caso tenha, qual é?


    private PraticanteIdDTO paciente;

}
