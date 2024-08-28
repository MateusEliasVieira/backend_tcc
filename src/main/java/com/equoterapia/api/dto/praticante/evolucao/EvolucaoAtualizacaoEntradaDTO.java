package com.equoterapia.api.dto.praticante.evolucao;

import com.equoterapia.api.dto.praticante.PraticanteIdDTO;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class EvolucaoAtualizacaoEntradaDTO {

    @NotNull(message = "O código da evolução deve ser informado!")
    private Long idEvolucao;
    @NotNull(message = "A data da evolução deve ser informada!")
    private Date data;
    @NotNull(message = "Deve ser informado se o praticante estava presente ou não!")
    private Boolean estavaPresente;
    private String observacao;

    @NotNull(message = "É preciso informar o praticante a ser atualizado!")
    private PraticanteIdDTO praticante;

}
