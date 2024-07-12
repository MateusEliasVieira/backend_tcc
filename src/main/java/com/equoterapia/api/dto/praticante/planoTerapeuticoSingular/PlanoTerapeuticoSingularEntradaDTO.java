package com.equoterapia.api.dto.praticante.planoTerapeuticoSingular;

import com.equoterapia.api.dto.praticante.Praticante;

import com.equoterapia.api.dto.praticante.PraticanteIdDTO;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
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
    @NotNull
    private Date dataPlanejamento;
    @NotBlank
    private String responsavelTerapeutico;
    @NotBlank
    private String problema;
    @NotBlank
    private String justificativaHipotesesBiologicasSociaisEmocionais;
    @NotBlank
    private String objetivoTerapeutico;
    @NotBlank
    private String medida;
    @NotBlank
    private String estrategiasIntervencao;
    @NotBlank
    private String selasMediadorasAnimais;
    @NotBlank
    private String evolucao;
    @NotBlank
    private String fisioterapeutaImagemDaAssinaturaOuCarimbo;
    private PraticanteIdDTO praticante;

}
