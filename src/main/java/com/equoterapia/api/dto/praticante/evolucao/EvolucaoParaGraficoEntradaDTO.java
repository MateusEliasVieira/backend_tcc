package com.equoterapia.api.dto.praticante.evolucao;

import com.equoterapia.api.dto.praticante.PraticanteIdDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EvolucaoParaGraficoEntradaDTO {

    private Date dataInicial;
    private Date dataFinal;
    private PraticanteIdDTO praticante;

}
