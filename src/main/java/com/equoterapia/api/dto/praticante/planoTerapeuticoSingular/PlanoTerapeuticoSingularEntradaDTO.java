package com.equoterapia.api.dto.praticante.planoTerapeuticoSingular;

import com.equoterapia.api.dto.praticante.PraticanteIdDTO;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PlanoTerapeuticoSingularEntradaDTO {

    // Plano Terapêutico Singular (PTS)

    private Long idPlanoTerapeuticoSingular;
    private Date dataPlanejamento;
    private String responsavelTerapeutico;
    private String problema;
    private String justificativaHipotesesBiologicasSociaisEmocionais;
    private String objetivoTerapeutico;
    private String medida;
    private String estrategiasIntervencao;
    private String selasMediadorasAnimais;
    private String evolucao;
    private String fisioterapeutaImagemDaAssinaturaOuCarimbo;

    @NotNull
    private PraticanteIdDTO praticante;

}
