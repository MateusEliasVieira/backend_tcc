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
public class ResponsavelPraticante {

    // Responsável do paciente

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idResponsavelPraticante;
    private String nomeResponsavel;
    private String grauParentesco; // Parentesco
    private String profissao;
    private String telefone;
    private Date dataNascimento;
    private String email;
    private String telefoneTrabalho;
    private Double rendaFamiliar;

    @OneToOne
    @JoinColumn
    private Praticante praticante;

}

