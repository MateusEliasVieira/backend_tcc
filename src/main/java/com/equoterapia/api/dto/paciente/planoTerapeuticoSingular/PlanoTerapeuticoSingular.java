package com.equoterapia.api.dto.paciente.planoTerapeuticoSingular;

import com.equoterapia.api.dto.paciente.Paciente;

import jakarta.persistence.*;
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
public class PlanoTerapeuticoSingular {

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
    @NotBlank
    private String imagemCarimboAssinaturaTerapeutas;

    private Paciente paciente;

}
