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
public class CompreensaoEntradaDTO {

    // Compreensão

    private Long idCompreensao;
    @Enumerated @NotBlank
    private PreencherLegenda compreendeOrdens;
    @Enumerated @NotBlank
    private PreencherLegenda executaOrdensVerbaisSimples;
    @Enumerated @NotBlank
    private PreencherLegenda executaOrdensComplexas;


    private PraticanteIdDTO paciente;

}

