package com.equoterapia.api.mapeador.praticante;

import com.equoterapia.api.dto.praticante.avaliacaoFisioterapeutica.*;
import com.equoterapia.api.dto.praticante.avaliacaoPsicologica.*;
import com.equoterapia.api.dto.praticante.fichaCadastroAdmissional.*;
import com.equoterapia.dominio.modelo.praticante.avaliacaoFisioterapeutica.*;
import com.equoterapia.dominio.modelo.praticante.avaliacaoPsicologica.*;
import com.equoterapia.dominio.modelo.praticante.fichaCadastroAdmissional.*;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;

public class PraticanteMapeador {

    // Dados Pessoais
    public static DadosPessoais converterDadosPessoaisEntradaDTOParaDadosPessoais(DadosPessoaisEntradaDTO dadosPessoaisEntradaDTO) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(dadosPessoaisEntradaDTO, DadosPessoais.class);
    }

    public static DadosPessoaisSaidaDTO converterDadosPessoaisParaDadosPessoaisSaidaDTO(DadosPessoais dadosPessoais) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(dadosPessoais, DadosPessoaisSaidaDTO.class);
    }

    public static List<DadosPessoaisSaidaDTO> converterListaDeDadosPessoaisParaListaDeDadosPessoaisSaidaDTO(List<DadosPessoais> listaDadosPessoais) {
        ModelMapper modelMapper = new ModelMapper();
        List<DadosPessoaisSaidaDTO> listaSaidaDTO = new ArrayList<>();
        for (DadosPessoais dadosPessoais : listaDadosPessoais) {
            DadosPessoaisSaidaDTO outputDTO = modelMapper.map(dadosPessoais, DadosPessoaisSaidaDTO.class);
            listaSaidaDTO.add(outputDTO);
        }
        return listaSaidaDTO;
    }

    // Completude Matricula
    public static CompletudeMatricula converterCompletudeMatriculaEntradaDTOParaCompletudeMatricula(CompletudeMatriculaEntradaDTO completudeMatriculaEntradaDTO) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(completudeMatriculaEntradaDTO, CompletudeMatricula.class);
    }

    public static CompletudeMatriculaSaidaDTO converterCompletudeMatriculaParaCompletudeMatriculaSaidaDTO(CompletudeMatricula completudeMatricula) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(completudeMatricula, CompletudeMatriculaSaidaDTO.class);
    }

    public static List<CompletudeMatriculaSaidaDTO> converterListaDeCompletudeMatriculaParaListaDeCompletudeMatriculaSaidaDTO(List<CompletudeMatricula> listaCompletudeMatricula) {
        ModelMapper modelMapper = new ModelMapper();
        List<CompletudeMatriculaSaidaDTO> listaSaidaDTO = new ArrayList<>();
        for (CompletudeMatricula completudeMatricula : listaCompletudeMatricula) {
            CompletudeMatriculaSaidaDTO outputDTO = modelMapper.map(completudeMatricula, CompletudeMatriculaSaidaDTO.class);
            listaSaidaDTO.add(outputDTO);
        }
        return listaSaidaDTO;
    }

    // Educação Praticante

    public static EducacaoPraticante converterEducacaoPraticanteEntradaDTOParaEducacaoPraticante(EducacaoPraticanteEntradaDTO educacaoPraticanteEntradaDTO) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(educacaoPraticanteEntradaDTO, EducacaoPraticante.class);
    }

    public static EducacaoPraticanteSaidaDTO converterEducacaoPraticanteParaEducacaoPraticanteSaidaDTO(EducacaoPraticante educacaoPraticante) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(educacaoPraticante, EducacaoPraticanteSaidaDTO.class);
    }

    // Emergencia

    public static Emergencia converterEmergenciaEntradaDTOParaEmergencia(EmergenciaEntradaDTO emergenciaEntradaDTO) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(emergenciaEntradaDTO, Emergencia.class);
    }

    public static EmergenciaSaidaDTO converterEmergenciaParaEmergenciaSaidaDTO(Emergencia emergencia) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(emergencia, EmergenciaSaidaDTO.class);
    }

    // Responsavel pelo paciente
    public static ResponsavelPraticante converterResponsavelPraticanteEntradaDTOEmResponsavelPraticante(ResponsavelPraticanteEntradaDTO responsavelPraticanteEntradaDTO) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(responsavelPraticanteEntradaDTO, ResponsavelPraticante.class);
    }

    public static ResponsavelPraticanteSaidaDTO converterResponsavelPraticanteEmResponsavelPraticanteSaidaDTO(ResponsavelPraticante responsavelPraticante) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(responsavelPraticante, ResponsavelPraticanteSaidaDTO.class);
    }

    // Outras Atividades Manha
    public static OutrasAtividadesManha converterOutrasAtividadesManhaEntradaDTOEmOutrasAtividadesManha(OutrasAtividadesManhaEntradaDTO outrasAtividadesManhaEntradaDTO) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(outrasAtividadesManhaEntradaDTO, OutrasAtividadesManha.class);
    }

    public static OutrasAtividadesManhaSaidaDTO converterOutrasAtividadesManhaEmOutrasAtividadesManhaSaidaDTO(OutrasAtividadesManha outrasAtividadesManha) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(outrasAtividadesManha, OutrasAtividadesManhaSaidaDTO.class);
    }

    // Outras Atividades Tarde
    public static OutrasAtividadesTarde converterOutrasAtividadesTardeEntradaDTOEmOutrasAtividadesTarde(OutrasAtividadesTardeEntradaDTO outrasAtividadesTardeEntradaDTO) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(outrasAtividadesTardeEntradaDTO, OutrasAtividadesTarde.class);
    }

    public static OutrasAtividadesTardeSaidaDTO converterOutrasAtividadesTardeEmOutrasAtividadesTardeSaidaDTO(OutrasAtividadesTarde outrasAtividadesTarde) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(outrasAtividadesTarde, OutrasAtividadesTardeSaidaDTO.class);
    }

    // Afetividade
    public static Afetividade converterAfetividadeEntradaDTOEmAfetividade(AfetividadeEntradaDTO afetividadeEntradaDTO) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(afetividadeEntradaDTO, Afetividade.class);
    }

    public static AfetividadeSaidaDTO converterAfetividadeEmAfetividadeSaidaDTO(Afetividade afetividade) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(afetividade, AfetividadeSaidaDTO.class);
    }

    // Avaliacao Psicologica
    public static AvaliacaoPsicologica converterAvaliacaoPsicologicaEntradaDTOEmAvaliacaoPsicologica(AvaliacaoPsicologicaEntradaDTO avaliacaoPsicologicaEntradaDTO) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(avaliacaoPsicologicaEntradaDTO, AvaliacaoPsicologica.class);
    }

    public static AvaliacaoPsicologicaSaidaDTO converterAvaliacaoPsicologicaEmAvaliacaoPsicologicaSaidaDTO(AvaliacaoPsicologica avaliacaoPsicologica) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(avaliacaoPsicologica, AvaliacaoPsicologicaSaidaDTO.class);
    }

    // Sobre a Criança
    public static SobreACrianca converterSobreACriancaEntradaDTOEmSobreACrianca(SobreACriancaEntradaDTO sobreACriancaEntradaDTO) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(sobreACriancaEntradaDTO, SobreACrianca.class);
    }

    public static SobreACriancaSaidaDTO converterSobreACriancaEmSobreACriancaSaidaDTO(SobreACrianca sobreACrianca) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(sobreACrianca, SobreACriancaSaidaDTO.class);
    }

    // Saúde
    public static Saude converterSaudeEntradaDTOEmSaude(SaudeEntradaDTO saudeEntradaDTO) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(saudeEntradaDTO, Saude.class);
    }

    public static SaudeSaidaDTO converterSaudeEmSaudeSaidaDTO(Saude saude) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(saude, SaudeSaidaDTO.class);
    }

    // Rotina
    public static Rotina converterRotinaEntradaDTOEmRotina(RotinaEntradaDTO rotinaEntradaDTO) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(rotinaEntradaDTO, Rotina.class);
    }

    public static RotinaSaidaDTO converterRotinaEmRotinaSaidaDTO(Rotina rotina) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(rotina, RotinaSaidaDTO.class);
    }

    // Cuidados Pessoais
    public static CuidadosPessoais converterCuidadosPessoaisEntradaDTOEmCuidadosPessoais(CuidadosPessoaisEntradaDTO cuidadosPessoaisEntradaDTO) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(cuidadosPessoaisEntradaDTO, CuidadosPessoais.class);
    }

    public static RotinaSaidaDTO converterCuidadosPessoaisEmCuidadosPessoaisSaidaDTO(CuidadosPessoais cuidadosPessoais) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(cuidadosPessoais, RotinaSaidaDTO.class);
    }

    // Traços de Personalidade
    public static TracosDePersonalidade converterTracosDePersonalidadeEntradaDTOEmTracosDePersonalidade(TracosDePersonalidadeEntradaDTO tracosDePersonalidadeEntradaDTO) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(tracosDePersonalidadeEntradaDTO, TracosDePersonalidade.class);
    }

    public static TracosDePersonalidadeSaidaDTO converterTracosDePersonalidadeEmTracosDePersonalidadeSaidaDTO(TracosDePersonalidade tracosDePersonalidade) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(tracosDePersonalidade, TracosDePersonalidadeSaidaDTO.class);
    }

    // Linguagem
    public static Linguagem converterLinguagemEntradaDTOEmLinguagem(LinguagemEntradaDTO linguagemEntradaDTO) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(linguagemEntradaDTO, Linguagem.class);
    }

    public static LinguagemSaidaDTO converterLinguagemEmLinguagemSaidaDTO(Linguagem linguagem) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(linguagem, LinguagemSaidaDTO.class);
    }

    // Compreensão
    public static Compreensao converterCompreensaoEntradaDTOEmCompreensao(CompreensaoEntradaDTO compreensaoEntradaDTO) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(compreensaoEntradaDTO, Compreensao.class);
    }

    public static CompreensaoSaidaDTO converterCompreensaoEmCompreensaoSaidaDTO(Compreensao compreensao) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(compreensao, CompreensaoSaidaDTO.class);
    }

    // Saúde Mental
    public static SaudeMental converterSaudeMentalEntradaDTOEmSaudeMental(SaudeMentalEntradaDTO saudeMentalEntradaDTO) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(saudeMentalEntradaDTO, SaudeMental.class);
    }

    public static SaudeMentalSaidaDTO converterSaudeMentalEmSaudeMentalSaidaDTO(SaudeMental saudeMental) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(saudeMental, SaudeMentalSaidaDTO.class);
    }

    // Socialização
    public static Socializacao converterSocializacaoEntradaDTOEmSocializacao(SocializacaoEntradaDTO socializacaoEntradaDTO) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(socializacaoEntradaDTO, Socializacao.class);
    }

    public static SocializacaoSaidaDTO converterSocializacaoEmSocializacaoSaidaDTO(Socializacao socializacao) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(socializacao, SocializacaoSaidaDTO.class);
    }

    // Comportamento
    public static Comportamento converterComportamentoEntradaDTOEmComportamento(ComportamentoEntradaDTO comportamentoEntradaDTO) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(comportamentoEntradaDTO, Comportamento.class);
    }

    public static ComportamentoSaidaDTO converterComportamentoEmComportamentoSaidaDTO(Comportamento comportamento) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(comportamento, ComportamentoSaidaDTO.class);
    }

    // Habilidades Sociais
    public static HabilidadesSociais converterHabilidadesSociaisEntradaDTOEmHabilidadesSociais(HabilidadesSociaisEntradaDTO habilidadesSociaisEntradaDTO) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(habilidadesSociaisEntradaDTO, HabilidadesSociais.class);
    }

    public static HabilidadesSociaisSaidaDTO converterHabilidadesSociaisEmHabilidadesSociaisSaidaDTO(HabilidadesSociais habilidadesSociais) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(habilidadesSociais, HabilidadesSociaisSaidaDTO.class);
    }

    // Relação Familiar Examinado
    public static RelacaoFamiliarExaminado converterRelacaoFamiliarExaminadoEntradaDTOEmRelacaoFamiliarExaminado(RelacaoFamiliarExaminadoEntradaDTO relacaoFamiliarExaminadoEntradaDTO) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(relacaoFamiliarExaminadoEntradaDTO, RelacaoFamiliarExaminado.class);
    }

    public static RelacaoFamiliarExaminadoSaidaDTO converterRelacaoFamiliarExaminadoEmRelacaoFamiliarExaminadoSaidaDTO(RelacaoFamiliarExaminado relacaoFamiliarExaminado) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(relacaoFamiliarExaminado, RelacaoFamiliarExaminadoSaidaDTO.class);
    }

    // Avaliação Fisioterapeutica
    public static AvaliacaoFisioterapeutica converterAvaliacaoFisioterapeuticaEntradaDTOEmAvaliacaoFisioterapeutica(AvaliacaoFisioterapeuticaEntradaDTO avaliacaoFisioterapeuticaEntradaDTO) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(avaliacaoFisioterapeuticaEntradaDTO, AvaliacaoFisioterapeutica.class);
    }

    public static AvaliacaoFisioterapeuticaSaidaDTO converterAvaliacaoFisioterapeuticaEmAvaliacaoFisioterapeuticaSaidaDTO(AvaliacaoFisioterapeutica avaliacaoFisioterapeutica) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(avaliacaoFisioterapeutica, AvaliacaoFisioterapeuticaSaidaDTO.class);
    }

    // Coordenação Motora
    public static CoordenacaoMotora converterCoordenacaoMotoraEntradaDTOEmCoordenacaoMotora(CoordenacaoMotoraEntradaDTO coordenacaoMotoraEntradaDTO) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(coordenacaoMotoraEntradaDTO, CoordenacaoMotora.class);
    }

    public static CoordenacaoMotoraSaidaDTO converterCoordenacaoMotoraEmCoordenacaoMotoraSaidaDTO(CoordenacaoMotora coordenacaoMotora) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(coordenacaoMotora, CoordenacaoMotoraSaidaDTO.class);
    }

    // Equilibrio Dinamico
    public static EquilibrioDinamico converterEquilibrioDinamicoEntradaDTOEmEquilibrioDinamico(EquilibrioDinamicoEntradaDTO equilibrioDinamicoEntradaDTO) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(equilibrioDinamicoEntradaDTO, EquilibrioDinamico.class);
    }

    public static EquilibrioDinamicoSaidaDTO converterEquilibrioDinamicoEmEquilibrioDinamicoSaidaDTO(EquilibrioDinamico equilibrioDinamico) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(equilibrioDinamico, EquilibrioDinamicoSaidaDTO.class);
    }

    // Equilibrio Estático
    public static EquilibrioEstatico converterEquilibrioEstaticoEntradaDTOEmEquilibrioEstatico(EquilibrioEstaticoEntradaDTO equilibrioEstaticoEntradaDTO) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(equilibrioEstaticoEntradaDTO, EquilibrioEstatico.class);
    }

    public static EquilibrioEstaticoSaidaDTO converterEquilibrioEstaticoEmEquilibrioEstaticoSaidaDTO(EquilibrioEstatico equilibrioEstatico) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(equilibrioEstatico, EquilibrioEstaticoSaidaDTO.class);
    }

    // Forma de Comunicação
    public static FormaDeComunicacao converterFormaDeComunicacaoEntradaDTOEmFormaDeComunicacao(FormaDeComunicacaoEntradaDTO formaDeComunicacaoEntradaDTO) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(formaDeComunicacaoEntradaDTO, FormaDeComunicacao.class);
    }

    public static FormaDeComunicacaoSaidaDTO converterFormaDeComunicacaoEmFormaDeComunicacaoSaidaDTO(FormaDeComunicacao formaDeComunicacao) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(formaDeComunicacao, FormaDeComunicacaoSaidaDTO.class);
    }


}
