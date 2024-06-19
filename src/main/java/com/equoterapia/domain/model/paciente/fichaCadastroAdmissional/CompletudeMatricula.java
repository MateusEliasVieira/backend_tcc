package com.equoterapia.domain.model.paciente.fichaCadastroAdmissional;

import com.equoterapia.domain.model.paciente.Paciente;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

import static com.equoterapia.utils.Feedback.ASSINATURA_IMAGEM;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class CompletudeMatricula {

    // Sobre a efetivação da matrícula

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idCompletudeMatricula;
    private Date dataCompletudeMatricula;
    @Column(columnDefinition = "text")
    private String imagemAssinaturaResponsavel;

    @OneToOne
    @JoinColumn(name = "paciente_id_fk")
    private Paciente paciente;

}

