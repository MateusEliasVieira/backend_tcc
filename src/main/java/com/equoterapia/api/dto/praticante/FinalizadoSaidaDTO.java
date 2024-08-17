package com.equoterapia.api.dto.praticante;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FinalizadoSaidaDTO {

    private Long idFinalizado;
    private Boolean finalizado;
    private PraticanteIdDTO praticante;

}
