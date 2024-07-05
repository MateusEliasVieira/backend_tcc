package com.equoterapia.dominio.modelo.praticante;

import com.equoterapia.dominio.modelo.praticante.avaliacaoFisioterapeutica.EquilibrioEstatico;
import com.equoterapia.dominio.modelo.praticante.avaliacaoFisioterapeutica.FormaDeComunicacao;
import com.equoterapia.dominio.modelo.praticante.avaliacaoFisioterapeutica.SaudeGeralDosPraticantes;
import com.equoterapia.dominio.modelo.praticante.fichaCadastroAdmissional.EducacaoPraticante;
import com.equoterapia.dominio.modelo.praticante.fichaCadastroAdmissional.ResponsavelPraticante;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Praticante {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPraticante;

    // Avaliação Fisioterapeutica
    @OneToOne(mappedBy = "praticante")
    private com.equoterapia.dominio.modelo.praticante.avaliacaoFisioterapeutica.AvaliacaoFisioterapeutica avaliacaoFisioterapeutica;
    @OneToOne(mappedBy = "praticante")
    private com.equoterapia.dominio.modelo.praticante.avaliacaoFisioterapeutica.CoordenacaoMotora coordenacaoMotora;
    @OneToOne(mappedBy = "praticante")
    private com.equoterapia.dominio.modelo.praticante.avaliacaoFisioterapeutica.EquilibrioDinamico equilibrioDinamico;
    @OneToOne(mappedBy = "praticante")
    private EquilibrioEstatico equilibrioEstatico;
    @OneToOne(mappedBy = "praticante")
    private FormaDeComunicacao formaDeComunicacao;
    @OneToOne(mappedBy = "praticante")
    private com.equoterapia.dominio.modelo.patient.physicalTherapyAssessment.GruposMusculares gruposMusculares;
    @OneToOne(mappedBy = "praticante")
    private com.equoterapia.dominio.modelo.praticante.avaliacaoFisioterapeutica.HabilidadesMotorasAVD habilidadesMotorasAVD;
    @OneToOne(mappedBy = "praticante")
    private com.equoterapia.dominio.modelo.patient.physicalTherapyAssessment.MobilidadeArticular mobilidadeArticular;
    @OneToOne(mappedBy = "praticante")
    private com.equoterapia.dominio.modelo.praticante.avaliacaoFisioterapeutica.QuadroAtual quadroAtual;
    @OneToOne(mappedBy = "praticante")
    private SaudeGeralDosPraticantes saudeGeralDosPraticantes;

    // Avaliação Psicológica
    @OneToOne(mappedBy = "praticante")
    private com.equoterapia.dominio.modelo.praticante.avaliacaoPsicologica.Afetividade afetividade;
    @OneToOne(mappedBy = "praticante")
    private com.equoterapia.dominio.modelo.praticante.avaliacaoPsicologica.AvaliacaoPsicologica avaliacaoPsicologica;
    @OneToOne(mappedBy = "praticante")
    private com.equoterapia.dominio.modelo.praticante.avaliacaoPsicologica.Comportamento comportamento;
    @OneToOne(mappedBy = "praticante")
    private com.equoterapia.dominio.modelo.praticante.avaliacaoPsicologica.Compreensao compreensao;
    @OneToOne(mappedBy = "praticante")
    private com.equoterapia.dominio.modelo.praticante.avaliacaoPsicologica.CuidadosPessoais cuidadosPessoais;
    @OneToOne(mappedBy = "praticante")
    private com.equoterapia.dominio.modelo.praticante.avaliacaoPsicologica.HabilidadesSociais habilidadesSociais;
    @OneToOne(mappedBy = "praticante")
    private com.equoterapia.dominio.modelo.praticante.avaliacaoPsicologica.Linguagem linguagem;
    @OneToOne(mappedBy = "praticante")
    private com.equoterapia.dominio.modelo.praticante.avaliacaoPsicologica.RelacaoFamiliarExaminado relacaoFamiliarExaminado;
    @OneToOne(mappedBy = "praticante")
    private com.equoterapia.dominio.modelo.praticante.avaliacaoPsicologica.Rotina rotina;
    @OneToOne(mappedBy = "praticante")
    private com.equoterapia.dominio.modelo.praticante.avaliacaoPsicologica.Saude saude;
    @OneToOne(mappedBy = "praticante")
    private com.equoterapia.dominio.modelo.praticante.avaliacaoPsicologica.SaudeMental saudeMental;
    @OneToOne(mappedBy = "praticante")
    private com.equoterapia.dominio.modelo.praticante.avaliacaoPsicologica.SobreACrianca sobreACrianca;
    @OneToOne(mappedBy = "praticante")
    private com.equoterapia.dominio.modelo.praticante.avaliacaoPsicologica.Socializacao socializacao;
    @OneToOne(mappedBy = "praticante")
    private com.equoterapia.dominio.modelo.praticante.avaliacaoPsicologica.TracosDePersonalidade tracosDePersonalidade;

    // Ficha Cadastro Admissional
    @OneToOne(mappedBy = "praticante")
    private com.equoterapia.dominio.modelo.praticante.fichaCadastroAdmissional.CompletudeMatricula completudeMatricula;
    @OneToOne(mappedBy = "praticante", cascade = CascadeType.ALL)
    private com.equoterapia.dominio.modelo.praticante.fichaCadastroAdmissional.DadosPessoais dadosPessoais;
    @OneToOne(mappedBy = "praticante")
    private EducacaoPraticante educacaoPraticante;
    @OneToOne(mappedBy = "praticante")
    private com.equoterapia.dominio.modelo.praticante.fichaCadastroAdmissional.Emergencia emergencia;
    @OneToOne(mappedBy = "praticante")
    private com.equoterapia.dominio.modelo.praticante.fichaCadastroAdmissional.FichaCadastroAdmissional fichaCadastroAdmissional;
    @OneToOne(mappedBy = "praticante")
    private com.equoterapia.dominio.modelo.praticante.fichaCadastroAdmissional.OutrasAtividadesManha outrasAtividadesManha;
    @OneToOne(mappedBy = "praticante")
    private com.equoterapia.dominio.modelo.praticante.fichaCadastroAdmissional.OutrasAtividadesTarde outrasAtividadesTarde;
    @OneToOne(mappedBy = "praticante")
    private ResponsavelPraticante responsavelPraticante;

    // Plano Terapeutico Singular
    @OneToOne(mappedBy = "praticante")
    private com.equoterapia.dominio.modelo.praticante.planoTerapeuticoSingular.PlanoTerapeuticoSingular planoTerapeuticoSingular;

//    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "usuario_id")
//    private Usuario usuario;


    // Ficha Cadastro Admissional

    // Plano Terapeutico Singular


//    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "usuario_id")
//    private Usuario usuario;

}
