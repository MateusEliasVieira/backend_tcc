package com.equoterapia.api.dto.praticante.fichaCadastroAdmissional;

import com.equoterapia.dominio.enums.ClasseDeEscola;
import com.equoterapia.dominio.enums.Periodo;
import com.equoterapia.dominio.enums.TipoDeInstituicaoEducacional;
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

    private Long idEducacaoPaciente;
    @NotBlank
    private String serieEscolar;
    @Enumerated
    private ClasseDeEscola classeDeEscola;
    @NotBlank
    private String instituicaoEducacional;
    @Enumerated
    private TipoDeInstituicaoEducacional tipoDeInstituicaoEducacional;
    @Enumerated
    private Periodo periodo;

}

