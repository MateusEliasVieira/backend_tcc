package com.equoterapia.api.dto.praticante.evolucao;

import com.equoterapia.api.dto.praticante.PraticanteIdDTO;
import jakarta.validation.constraints.NotNull;
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

    @NotNull(message = "É preciso informar a data inicial!")
    private Date dataInicial;
    @NotNull(message = "É preciso informar a data final!")
    private Date dataFinal;

    @NotNull(message = "É preciso informar o praticante a ser atualizado!")
    private PraticanteIdDTO praticante;

}
