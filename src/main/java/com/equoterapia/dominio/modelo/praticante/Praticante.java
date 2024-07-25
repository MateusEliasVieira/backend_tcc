package com.equoterapia.dominio.modelo.praticante;

import com.equoterapia.dominio.modelo.praticante.avaliacaoFisioterapeutica.*;
import com.equoterapia.dominio.modelo.praticante.avaliacaoPsicologica.*;
import com.equoterapia.dominio.modelo.praticante.fichaCadastroAdmissional.*;
import com.equoterapia.dominio.modelo.praticante.planoTerapeuticoSingular.*;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

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
    private AvaliacaoFisioterapeutica avaliacaoFisioterapeutica;
    @OneToOne(mappedBy = "praticante")
    private CoordenacaoMotora coordenacaoMotora;
    @OneToOne(mappedBy = "praticante")
    private EmPe emPe;
    @OneToOne(mappedBy = "praticante")
    private EquilibrioDinamico equilibrioDinamico;
    @OneToOne(mappedBy = "praticante")
    private EquilibrioEstatico equilibrioEstatico;
    @OneToOne(mappedBy = "praticante")
    private FormaDeComunicacao formaDeComunicacao;
    @OneToOne(mappedBy = "praticante")
    private GruposMusculares gruposMusculares;
    @OneToOne(mappedBy = "praticante")
    private HabilidadesMotorasAVD habilidadesMotorasAVD;
    @OneToOne(mappedBy = "praticante")
    private MobilidadeArticular mobilidadeArticular;
    @OneToOne(mappedBy = "praticante")
    private QuadroAtual quadroAtual;
    @OneToOne(mappedBy = "praticante")
    private SaudeGeralDoPraticante saudeGeralDoPraticante;

    // Avaliação Psicológica
    @OneToOne(mappedBy = "praticante")
    private Afetividade afetividade;
    @OneToOne(mappedBy = "praticante")
    private AvaliacaoPsicologica avaliacaoPsicologica;
    @OneToOne(mappedBy = "praticante")
    private Comportamento comportamento;
    @OneToOne(mappedBy = "praticante")
    private Compreensao compreensao;
    @OneToOne(mappedBy = "praticante")
    private CuidadosPessoais cuidadosPessoais;
    @OneToOne(mappedBy = "praticante")
    private HabilidadesSociais habilidadesSociais;
    @OneToOne(mappedBy = "praticante")
    private Linguagem linguagem;
    @OneToOne(mappedBy = "praticante")
    private RelacaoFamiliarExaminado relacaoFamiliarExaminado;
    @OneToOne(mappedBy = "praticante")
    private Rotina rotina;
    @OneToOne(mappedBy = "praticante")
    private Saude saude;
    @OneToOne(mappedBy = "praticante")
    private SaudeMental saudeMental;
    @OneToOne(mappedBy = "praticante")
    private SobreACrianca sobreACrianca;
    @OneToOne(mappedBy = "praticante")
    private Socializacao socializacao;
    @OneToOne(mappedBy = "praticante")
    private TracosDePersonalidade tracosDePersonalidade;

    // Ficha Cadastro Admissional
    @OneToOne(mappedBy = "praticante")
    private CompletudeMatricula completudeMatricula;
    @OneToOne(mappedBy = "praticante", cascade = CascadeType.ALL)
    private DadosPessoais dadosPessoais;
    @OneToOne(mappedBy = "praticante")
    private EducacaoPraticante educacaoPraticante;
    @OneToOne(mappedBy = "praticante")
    private Emergencia emergencia;
    @OneToOne(mappedBy = "praticante")
    private FichaCadastroAdmissional fichaCadastroAdmissional;
    @OneToOne(mappedBy = "praticante")
    private OutrasAtividadesManha outrasAtividadesManha;
    @OneToOne(mappedBy = "praticante")
    private OutrasAtividadesTarde outrasAtividadesTarde;
    @OneToOne(mappedBy = "praticante")
    private ResponsavelPraticante responsavelPraticante;

    // Plano Terapeutico Singular
    @OneToOne(mappedBy = "praticante")
    private PlanoTerapeuticoSingular planoTerapeuticoSingular;


    @OneToMany(mappedBy = "praticante")
    private List<Evolucao> historicoDeEvolucao;


}
