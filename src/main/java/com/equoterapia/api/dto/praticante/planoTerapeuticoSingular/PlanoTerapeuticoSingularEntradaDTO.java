package com.equoterapia.api.dto.praticante.planoTerapeuticoSingular;

import com.equoterapia.api.dto.praticante.Praticante;

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
    @NotBlank
    @NotNull
    @Size(min = 8, max = 10)
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

    private Boolean fisioterapia;
    private Boolean psicologia;
    private Boolean fonoaudiologia;
    private Boolean terapiaOcupacional;
    private Boolean educadorFisico;
    private Boolean pedagogia;
    private Boolean terapeutaComplementar;
    private Boolean assistenciaSocial;
    private Boolean enfermagem;

    private String fisioterapiaAssinaturaOuCarimbo;
    private String psicologiaAssinaturaOuCarimbo;
    private String fonoaudiologiaAssinaturaOuCarimbo;
    private String terapiaOcupacionalAssinaturaOuCarimbo;
    private String educadorFisicoAssinaturaOuCarimbo;
    private String pedagogiaAssinaturaOuCarimbo;
    private String terapeutaComplementarAssinaturaOuCarimbo;
    private String assistenciaSocialAssinaturaOuCarimbo;
    private String enfermagemAssinaturaOuCarimbo;

    private Praticante praticante;

}
