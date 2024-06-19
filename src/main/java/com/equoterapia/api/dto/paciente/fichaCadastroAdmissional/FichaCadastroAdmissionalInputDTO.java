package com.equoterapia.api.dto.paciente.fichaCadastroAdmissional;

import com.equoterapia.api.dto.paciente.Paciente;
import com.equoterapia.api.dto.paciente.PacienteIdDTO;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class FichaCadastroAdmissionalInputDTO {

    // Ficha Cadastral - Admissional CE

    private Long idFichaCadastroAdmissional;
    private Date dataAvaliacao; // Data da avaliação

    private PacienteIdDTO paciente;
}

