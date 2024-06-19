package com.equoterapia.api.dto.paciente.avaliacaoFisioterapeutica;

import com.equoterapia.domain.model.paciente.Paciente;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class QuadroAtual {

    // Quadro atual

    private Long idQuadroAtual;
    @NotBlank
    private String locomocaoAtual;
    @NotBlank
    private String restricoes;
    @NotBlank
    private String deformidades;


    private Paciente paciente;

}

