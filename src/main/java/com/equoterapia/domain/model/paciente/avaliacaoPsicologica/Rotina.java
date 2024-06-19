package com.equoterapia.domain.model.paciente.avaliacaoPsicologica;

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
public class Rotina {

    // Rotina

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRotina;
    private String brincadeiras;
    private String preferenciasPorBrincadeiras;
    private Boolean aceitaMudancasNaRotina;
    private String consideracoesSobreRotina;

    @OneToOne
    @JoinColumn(name = "paciente_id_fk")
    private Paciente paciente;

}

