package com.equoterapia.domain.model.paciente.fichaCadastroAdmissional;

import com.equoterapia.domain.model.paciente.Paciente;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import static com.equoterapia.utils.Feedback.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Emergencia {

    // Emergência

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEmergencia;
    private String ligarPara;
    @Column(unique = true)
    private String telefone;
    private Boolean possuiPlanoDeSaude;
    private String plano; // Caso tenha, qual é?

    @OneToOne
    @JoinColumn(name = "paciente_id_fk")
    private Paciente paciente;

}
