package com.equoterapia.api.dto.praticante.fichaCadastroAdmissional;

import com.equoterapia.api.dto.praticante.PraticanteIdDTO;
import com.equoterapia.dominio.enums.ClasseDeEscola;
import com.equoterapia.dominio.enums.PeriodoEnum;
import com.equoterapia.dominio.enums.TipoDeInstituicaoEducacionalEnum;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class EducacaoPraticanteEntradaDTO {

    // Escolaridade do paciente

    private Long idEducacaoPraticante;
   
    private String serieEscolar;
  
    private ClasseDeEscola classeDeEscola;
   
    private String instituicaoEducacional;
  
    private TipoDeInstituicaoEducacionalEnum tipoDeInstituicaoEducacional;
  
    private PeriodoEnum periodo;


    @NotNull
    private PraticanteIdDTO praticante;

}

