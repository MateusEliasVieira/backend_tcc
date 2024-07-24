package com.equoterapia.api.dto.praticante.avaliacaoFisioterapeutica;

import com.equoterapia.api.dto.praticante.PraticanteIdDTO;
import com.equoterapia.dominio.modelo.praticante.Praticante;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class QuadroAtualEntradaDTO {

    // Quadro atual

    private Long idQuadroAtual;
    private String locomocaoAtual;
    private String restricoes;
    private String deformidades;

    @NotNull
    private PraticanteIdDTO praticante;

}

