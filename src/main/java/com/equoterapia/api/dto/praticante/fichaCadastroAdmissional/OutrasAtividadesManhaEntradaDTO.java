package com.equoterapia.api.dto.praticante.fichaCadastroAdmissional;

import com.equoterapia.api.dto.praticante.PraticanteIdDTO;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class OutrasAtividadesManhaEntradaDTO {

    // Cronograma de atividade do paciente em outras instituições período matutino

    private Long idOutrasAtividadesManha;
    private String segundaFeira;
    private String tercaFeira;
    private String quartaFeira;
    private String quintaFeira;
    private String sextaFeira;
    private String sabado;
    private String domingo;

    @NotNull
    private PraticanteIdDTO praticante;

}
