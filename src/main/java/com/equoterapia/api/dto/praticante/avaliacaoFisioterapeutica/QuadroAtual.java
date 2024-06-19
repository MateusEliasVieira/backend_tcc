package com.equoterapia.api.dto.praticante.avaliacaoFisioterapeutica;

import com.equoterapia.dominio.modelo.praticante.Praticante;
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


    private Praticante paciente;

}

