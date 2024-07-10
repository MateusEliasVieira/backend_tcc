package com.equoterapia.api.dto.praticante.avaliacaoFisioterapeutica;

import com.equoterapia.api.dto.praticante.PraticanteIdDTO;
import com.equoterapia.dominio.modelo.praticante.Praticante;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.validator.constraints.NotBlank;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class MobilidadeArticularEntradaDTO {

    // Mobilidade articular

    private Long idMobilidadeArticular;

    // Ombro (Shoulder)
    @NotBlank
    private String flexaoAtivaOmbro;
    @NotBlank
    private String flexaoPassivaOmbro;
    @NotBlank
    private String abducaoAtivaOmbro;

    @NotBlank
    private String abducaoPassivaOmbro;
    @NotBlank
    private String aducaoAtivaOmbro;
    @NotBlank
    private String aducaoPassivaOmbro;

    // Cotovelo (Elbow)
    @NotBlank
    private String flexaoAtivaCotovelo;
    @NotBlank
    private String flexaoPassivaCotovelo;
    @NotBlank
    private String extensaoAtivaCotovelo;
    @NotBlank
    private String extensaoPassivaCotovelo;

    // Quadril (Hip)
    @NotBlank
    private String flexaoAtivaQuadril;
    @NotBlank
    private String flexaoPassivaQuadril;
    @NotBlank
    private String extensaoAtivaQuadril;
    @NotBlank
    private String extensaoPassivaQuadril;
    @NotBlank
    private String aducaoAtivaQuadril;
    @NotBlank
    private String aducaoPassivaQuadril;
    @NotBlank
    private String abducaoAtivaQuadril;
    @NotBlank
    private String abducaoPassivaQuadril;
    @NotBlank
    private String rotacaoInternaAtivaQuadril;
    @NotBlank
    private String rotacaoInternaPassivaQuadril;
    @NotBlank
    private String rotacaoExternaAtivaQuadril;
    @NotBlank
    private String rotacaoExternaPassivaQuadril;

    // Joelho (Knee)
    @NotBlank
    private String extensaoAtivaJoelho;
    @NotBlank
    private String extensaoPassivaJoelho;
    @NotBlank
    private String flexaoAtivaJoelho;
    @NotBlank
    private String flexaoPassivaJoelho;

    // Tornozelo (Ankle)
    @NotBlank
    private String dorsiflexaoAtivaTornozelo;
    @NotBlank
    private String dorsiflexaoPassivaTornozelo;
    @NotBlank
    private String flexaoPlantarAtivaTornozelo;
    @NotBlank
    private String flexaoPlantarPassivaTornozelo;

    @NotNull
    private PraticanteIdDTO praticante;
}

