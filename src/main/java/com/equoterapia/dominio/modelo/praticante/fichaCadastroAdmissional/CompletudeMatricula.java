package com.equoterapia.dominio.modelo.praticante.fichaCadastroAdmissional;

import com.equoterapia.dominio.modelo.praticante.Praticante;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

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
    private Praticante paciente;

}

