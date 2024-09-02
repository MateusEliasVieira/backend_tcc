package com.equoterapia.api.dto.praticante.avaliacaoFisioterapeutica;

import com.equoterapia.api.dto.praticante.PraticanteIdDTO;
import com.equoterapia.dominio.modelo.praticante.Praticante;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class QuadroAtualSaidaDTO {

    // Quadro atual

    private Long idQuadroAtual;
    private String locomocaoAtual;
    private String restricoes;
    private String deformidades;

    private Boolean finalizado;

    private PraticanteIdDTO praticante;


}

