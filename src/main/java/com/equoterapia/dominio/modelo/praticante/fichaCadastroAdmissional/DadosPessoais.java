package com.equoterapia.dominio.modelo.praticante.fichaCadastroAdmissional;

import com.equoterapia.dominio.enums.CorOuRaca;
import com.equoterapia.dominio.enums.Sexo;
import com.equoterapia.dominio.enums.TipoSanguineo;
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
public class DadosPessoais {

    // Dados Pessoais do Praticante

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDadosPessoais;
    private String nomeCompleto;
    private String diagnosticoClinico;
    private String queixaPrincipal; // Queixa principal (EX: dificuldade de concentração)
    private String CID;
    private Date dataNascimento;
    private Double peso;
    private TipoSanguineo tipoSanguineo;
    private String fatorRH;
    private Double altura;
    private Sexo sexo;
    private String naturalidade;
    private CorOuRaca corOuRaca;
    @Column(unique = true)
    private String cpf;
    @Column(unique = true)
    private String cartaoSUS;
    private String enderecoResidencial;
    private String bairro;
    private String cidade;
    private String cep;

    @OneToOne
    @JoinColumn
    private Praticante praticante;

}

