package com.equoterapia.api.dto.praticante.planoTerapeuticoSingular;

import com.equoterapia.api.dto.praticante.PraticanteIdDTO;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PlanoTerapeuticoSingularSaidaDTO {

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

    private PraticanteIdDTO praticante;


}
