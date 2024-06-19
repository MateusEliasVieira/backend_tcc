package com.equoterapia.api.dto.praticante.avaliacaoPsicologica;

import com.equoterapia.api.dto.praticante.PraticanteIdDTO;
import com.equoterapia.dominio.enums.PreencherLegenda;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class HabilidadesSociaisEntradaDTO {

    // Habilidades sociais

    private Long idHabilidadesSociais;
    @Enumerated @NotBlank
    private PreencherLegenda passividade;
    @Enumerated @NotBlank
    private PreencherLegenda autoagressao;
    @Enumerated @NotBlank
    private PreencherLegenda heteroagressividade;
    @Enumerated @NotBlank
    private PreencherLegenda assertividade;


    private PraticanteIdDTO paciente;

}

