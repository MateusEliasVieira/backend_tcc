package com.equoterapia.api.dto.praticante.evolucao;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EvolucaoSaidaDTO {

    private Long idEvolucao;
    private Date data;
    private Boolean estavaPresente;
    private String observacao;

}
