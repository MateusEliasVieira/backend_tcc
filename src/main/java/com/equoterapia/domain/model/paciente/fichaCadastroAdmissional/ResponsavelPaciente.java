package com.equoterapia.domain.model.paciente.fichaCadastroAdmissional;

import com.equoterapia.domain.model.paciente.Paciente;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

import static com.equoterapia.utils.Feedback.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ResponsavelPaciente {

    // Responsável do paciente

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idResponsavelPaciente;
    private String nomeResponsavel;
    private String grauParentesco; // Parentesco
    private String profissao;
    private String telefone;
    private Date dataNascimento;
    private String email;
    private String telefoneTrabalho;
    private Double rendaFamiliar;

    @OneToOne
    @JoinColumn(name = "paciente_id_fk")
    private Paciente paciente;

}

