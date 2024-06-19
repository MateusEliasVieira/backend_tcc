package com.equoterapia.api.dto.paciente.avaliacaoPsicologica;

import com.equoterapia.api.dto.paciente.PacienteIdDTO;
import com.equoterapia.domain.model.paciente.Paciente;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AvaliacaoPsicologicaInputDTO {

    // Avaliação dos aspectos psicológicos

    private Long idAvaliacaoPsicologica;

    private String expectativasFamiliaresTerapiaEquina;
    private String resumoCasoObservacoesComplementares;

    private String imagemAssinaturaOuCRPECarimbo;

    private PacienteIdDTO paciente;

}

