package com.equoterapia.dominio.modelo.praticante.fichaCadastroAdmissional;

import com.equoterapia.dominio.modelo.praticante.Praticante;
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
    @JoinColumn
    private Praticante praticante;
}

