package com.equoterapia.dominio.modelo.praticante;

import com.equoterapia.dominio.modelo.praticante.avaliacaoFisioterapeutica.SaudeGeralDosPraticantes;
import com.equoterapia.dominio.modelo.praticante.fichaCadastroAdmissional.EducacaoPraticante;
import com.equoterapia.dominio.modelo.praticante.fichaCadastroAdmissional.ResponsavelPraticante;
import com.equoterapia.dominio.modelo.usuario.Usuario;

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
    private Long idPaciente;

    // Avaliação Fisioterapeutica
    @OneToOne(mappedBy = "paciente")
    private com.equoterapia.dominio.modelo.praticante.avaliacaoFisioterapeutica.AvaliacaoFisioterapeutica avaliacaoFisioterapeutica;
    @OneToOne(mappedBy = "paciente")
    private com.equoterapia.dominio.modelo.praticante.avaliacaoFisioterapeutica.CoordenacaoMotora coordenacaoMotora;
    @OneToOne(mappedBy = "paciente")
    private com.equoterapia.dominio.modelo.praticante.avaliacaoFisioterapeutica.EquilibrioDinamico equilibrioDinamico;
    @OneToOne(mappedBy = "paciente")
    private com.equoterapia.dominio.modelo.praticante.avaliacaoFisioterapeutica.EquilibrioEstatico equilibrioEstatico;
    @OneToOne(mappedBy = "paciente")
    private com.equoterapia.dominio.modelo.praticante.avaliacaoFisioterapeutica.FormaDeComunicacao formaDeComunicacao;
    @OneToOne(mappedBy = "paciente")
    private com.equoterapia.dominio.modelo.patient.physicalTherapyAssessment.GruposMusculares gruposMusculares;
    @OneToOne(mappedBy = "paciente")
    private com.equoterapia.dominio.modelo.praticante.avaliacaoFisioterapeutica.HabilidadesMotorasAVD habilidadesMotorasAVD;
    @OneToOne(mappedBy = "paciente")
    private com.equoterapia.dominio.modelo.patient.physicalTherapyAssessment.MobilidadeArticular mobilidadeArticular;
    @OneToOne(mappedBy = "paciente")
    private com.equoterapia.dominio.modelo.praticante.avaliacaoFisioterapeutica.QuadroAtual quadroAtual;
    @OneToOne(mappedBy = "paciente")
    private SaudeGeralDosPraticantes saudeGeralDosPraticantes;

    // Avaliação Psicológica
    @OneToOne(mappedBy = "paciente")
    private com.equoterapia.dominio.modelo.praticante.avaliacaoPsicologica.Afetividade afetividade;
    @OneToOne(mappedBy = "paciente")
    private com.equoterapia.dominio.modelo.praticante.avaliacaoPsicologica.AvaliacaoPsicologica avaliacaoPsicologica;
    @OneToOne(mappedBy = "paciente")
    private com.equoterapia.dominio.modelo.praticante.avaliacaoPsicologica.Comportamento comportamento;
    @OneToOne(mappedBy = "paciente")
    private com.equoterapia.dominio.modelo.praticante.avaliacaoPsicologica.Compreensao compreensao;
    @OneToOne(mappedBy = "paciente")
    private com.equoterapia.dominio.modelo.praticante.avaliacaoPsicologica.CuidadosPessoais cuidadosPessoais;
    @OneToOne(mappedBy = "paciente")
    private com.equoterapia.dominio.modelo.praticante.avaliacaoPsicologica.HabilidadesSociais habilidadesSociais;
    @OneToOne(mappedBy = "paciente")
    private com.equoterapia.dominio.modelo.praticante.avaliacaoPsicologica.Linguagem linguagem;
    @OneToOne(mappedBy = "paciente")
    private com.equoterapia.dominio.modelo.praticante.avaliacaoPsicologica.RelacaoFamiliarExaminado relacaoFamiliarExaminado;
    @OneToOne(mappedBy = "paciente")
    private com.equoterapia.dominio.modelo.praticante.avaliacaoPsicologica.Rotina rotina;
    @OneToOne(mappedBy = "paciente")
    private com.equoterapia.dominio.modelo.praticante.avaliacaoPsicologica.Saude saude;
    @OneToOne(mappedBy = "paciente")
    private com.equoterapia.dominio.modelo.praticante.avaliacaoPsicologica.SaudeMental saudeMental;
    @OneToOne(mappedBy = "paciente")
    private com.equoterapia.dominio.modelo.praticante.avaliacaoPsicologica.SobreACrianca sobreACrianca;
    @OneToOne(mappedBy = "paciente")
    private com.equoterapia.dominio.modelo.praticante.avaliacaoPsicologica.Socializacao socializacao;
    @OneToOne(mappedBy = "paciente")
    private com.equoterapia.dominio.modelo.praticante.avaliacaoPsicologica.TracosDePersonalidade tracosDePersonalidade;

    // Ficha Cadastro Admissional
    @OneToOne(mappedBy = "paciente")
    private com.equoterapia.dominio.modelo.praticante.fichaCadastroAdmissional.CompletudeMatricula completudeMatricula;
    @OneToOne(mappedBy = "paciente", cascade = CascadeType.ALL)
    private com.equoterapia.dominio.modelo.praticante.fichaCadastroAdmissional.DadosPessoais dadosPessoais;
    @OneToOne(mappedBy = "paciente")
    private EducacaoPraticante educacaoPraticante;
    @OneToOne(mappedBy = "paciente")
    private com.equoterapia.dominio.modelo.praticante.fichaCadastroAdmissional.Emergencia emergencia;
    @OneToOne(mappedBy = "paciente")
    private com.equoterapia.dominio.modelo.praticante.fichaCadastroAdmissional.FichaCadastroAdmissional fichaCadastroAdmissional;
    @OneToOne(mappedBy = "paciente")
    private com.equoterapia.dominio.modelo.praticante.fichaCadastroAdmissional.OutrasAtividadesManha outrasAtividadesManha;
    @OneToOne(mappedBy = "paciente")
    private com.equoterapia.dominio.modelo.praticante.fichaCadastroAdmissional.OutrasAtividadesTarde outrasAtividadesTarde;
    @OneToOne(mappedBy = "paciente")
    private ResponsavelPraticante responsavelPraticante;

    // Plano Terapeutico Singular
    @OneToOne(mappedBy = "paciente")
    private com.equoterapia.dominio.modelo.praticante.planoTerapeuticoSingular.PlanoTerapeuticoSingular planoTerapeuticoSingular;

//    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "usuario_id")
//    private Usuario usuario;


    // Ficha Cadastro Admissional

    // Plano Terapeutico Singular


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

}
