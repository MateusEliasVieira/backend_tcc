package com.equoterapia.api.dto.praticante.fichaCadastroAdmissional;

import com.equoterapia.dominio.enums.ClasseDeEscola;
import com.equoterapia.dominio.enums.PeriodoEnum;
import com.equoterapia.dominio.enums.TipoDeInstituicaoEducacionalEnum;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class EducacaoPraticanteSaidaDTO {

    // Escolaridade do paciente

    private Long idEducacaoPraticante;
    @NotBlank
    private String serieEscolar;
    @Enumerated
    private ClasseDeEscola classeDeEscola;
    @NotBlank
    private String instituicaoEducacional;
    @Enumerated
    private TipoDeInstituicaoEducacionalEnum tipoDeInstituicaoEducacional;
    @Enumerated
    private PeriodoEnum periodo;

}

