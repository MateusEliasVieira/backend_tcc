package com.equoterapia.domain.model.paciente.fichaCadastroAdmissional;

import com.equoterapia.domain.model.paciente.Paciente;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class FichaCadastroAdmissional {

    // Ficha Cadastral - Admissional CE

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFichaCadastroAdmissional;
    private Date dataAvaliacao; // Data da avaliação

    @OneToOne
    @JoinColumn(name = "paciente_id_fk")
    private Paciente paciente;
}

