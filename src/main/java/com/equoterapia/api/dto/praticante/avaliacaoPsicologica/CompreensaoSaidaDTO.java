package com.equoterapia.api.dto.praticante.avaliacaoPsicologica;

import com.equoterapia.api.dto.praticante.Praticante;
import com.equoterapia.dominio.enums.PreencherLegenda;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CompreensaoSaidaDTO {

    // Compreensão

    private Long idCompreensao;
    @Enumerated @NotBlank
    private PreencherLegenda compreendeOrdens;
    @Enumerated @NotBlank
    private PreencherLegenda executaOrdensVerbaisSimples;
    @Enumerated @NotBlank
    private PreencherLegenda executaOrdensComplexas;


    private Praticante praticante;

}

