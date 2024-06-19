package com.equoterapia.api.dto.paciente.fichaCadastroAdmissional;

import com.equoterapia.api.dto.paciente.PacienteIdDTO;
import com.equoterapia.domain.model.paciente.Paciente;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class OutrasAtividadesTardeInputDTO {

    // Cronograma de atividade do paciente em outras instituições período vespertino

    private Long idOutrasAtividadesTarde;
    private String segundaFeira;
    private String tercaFeira;
    private String quartaFeira;
    private String quintaFeira;
    private String sextaFeira;
    private String sabado;
    private String domingo;

    private PacienteIdDTO paciente;

}

