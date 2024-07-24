package com.equoterapia.api.dto.praticante.fichaCadastroAdmissional;

import com.equoterapia.api.dto.praticante.PraticanteIdDTO;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.Date;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class FichaCadastroAdmissionalEntradaDTO {

    // Ficha Cadastral - Admissional CE

    private Long idFichaCadastroAdmissional;
    private Date dataAvaliacao; // Data da avaliação

    @NotNull
    private PraticanteIdDTO praticante;
}

