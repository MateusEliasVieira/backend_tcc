package com.equoterapia.domain.model.paciente.fichaCadastroAdmissional;

import com.equoterapia.domain.enums.*;
import com.equoterapia.domain.model.paciente.Paciente;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class EducacaoPaciente {

    // Escolaridade do paciente

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEducacaoPaciente;
    private String serieEscolar;
    private ClasseDeEscola classeDeEscola;
    private String instituicaoEducacional;
    private TipoDeInstituicaoEducacional tipoDeInstituicaoEducacional;
    private Periodo periodo;

    @OneToOne
    @JoinColumn(name = "paciente_id_fk")
    private Paciente paciente;

}

