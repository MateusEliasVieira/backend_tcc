package com.equoterapia.api.dto.praticante.avaliacaoFisioterapeutica;

import com.equoterapia.api.dto.praticante.PraticanteIdDTO;
import com.equoterapia.dominio.enums.SImOuNaoEnum;
import com.equoterapia.dominio.modelo.praticante.Praticante;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class HabilidadesMotorasAVDEntradaDTO {

    // Habilidades Motoras/AVD's

    private Long idHabilidadesMotorasAVD;
    private SImOuNaoEnum alcancarObjetos;
    private String consideracoesAlcancarObjetos;
    private SImOuNaoEnum usoBimanual;
    private String consideracoesUsoBimanual;
    private SImOuNaoEnum alimentacaoIndependente;
    private String consideracoesAlimentacaoIndependente;
    private SImOuNaoEnum vestirIndependente;
    private String consideracoesVestirIndependente;
    private SImOuNaoEnum pegarObjetos;
    private String consideracoesPegarObjetos;
    private SImOuNaoEnum negligenciaMembro;
    private String consideracoesNegligenciaMembro;
    private SImOuNaoEnum higienePessoal;
    private String consideracoesHigienePessoal;
    private SImOuNaoEnum andar;
    private String consideracoesAndar;
    private SImOuNaoEnum escritaManual;
    private String consideracoesEscritaManual;

    @NotNull
    private PraticanteIdDTO praticante;

}

