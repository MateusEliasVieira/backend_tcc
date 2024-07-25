package com.equoterapia.api.dto.praticante.evolucao;

import com.equoterapia.api.dto.praticante.PraticanteIdDTO;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class EvolucaoEntradaDTO {

    private Date data;
    private Boolean estavaPresente;
    private String observacao;
    private PraticanteIdDTO praticante;

}
