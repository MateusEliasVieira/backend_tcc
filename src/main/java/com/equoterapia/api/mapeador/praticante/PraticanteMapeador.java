package com.equoterapia.api.mapeador.praticante;

import com.equoterapia.api.dto.praticante.fichaCadastroAdmissional.*;
import com.equoterapia.dominio.modelo.praticante.fichaCadastroAdmissional.*;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;

public class PraticanteMapeador {

    // Dados Pessoais
    public static DadosPessoais converterDadosPessoaisInputDTOParaDadosPessoais(DadosPessoaisEntradaDTO dadosPessoaisEntradaDTO) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(dadosPessoaisEntradaDTO, DadosPessoais.class);
    }

    public static DadosPessoaisSaidaDTO converterDadosPessoaisParaDadosPessoaisOutputDTO(DadosPessoais dadosPessoais) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(dadosPessoais, DadosPessoaisSaidaDTO.class);
    }

    public static List<DadosPessoaisSaidaDTO> converterListaDeDadosPessoaisParaListaDeDadosPessoaisOutputDTO(List<DadosPessoais> listaDadosPessoais) {
        ModelMapper modelMapper = new ModelMapper();
        List<DadosPessoaisSaidaDTO> listaOutputDTO = new ArrayList<>();
        for (DadosPessoais dadosPessoais : listaDadosPessoais) {
            DadosPessoaisSaidaDTO outputDTO = modelMapper.map(dadosPessoais, DadosPessoaisSaidaDTO.class);
            listaOutputDTO.add(outputDTO);
        }
        return listaOutputDTO;
    }

    // Completude Matricula
    public static CompletudeMatricula converterCompletudeMatriculaInputDTOParaCompletudeMatricula(CompletudeMatriculaEntradaDTO completudeMatriculaEntradaDTO) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(completudeMatriculaEntradaDTO, CompletudeMatricula.class);
    }

    public static CompletudeMatriculaSaidaDTO converterCompletudeMatriculaParaCompletudeMatriculaOutputDTO(CompletudeMatricula completudeMatricula) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(completudeMatricula, CompletudeMatriculaSaidaDTO.class);
    }

    public static List<CompletudeMatriculaSaidaDTO> converterListaDeCompletudeMatriculaParaListaDeCompletudeMatriculaOutputDTO(List<CompletudeMatricula> listaCompletudeMatricula) {
        ModelMapper modelMapper = new ModelMapper();
        List<CompletudeMatriculaSaidaDTO> listaOutputDTO = new ArrayList<>();
        for (CompletudeMatricula completudeMatricula : listaCompletudeMatricula) {
            CompletudeMatriculaSaidaDTO outputDTO = modelMapper.map(completudeMatricula, CompletudeMatriculaSaidaDTO.class);
            listaOutputDTO.add(outputDTO);
        }
        return listaOutputDTO;
    }

    // Educação Paciente

    public static EducacaoPraticante converterEducacaoPacienteInputDTOParaEducacaoPaciente(EducacaoPraticanteEntradaDTO educacaoPraticanteEntradaDTO) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(educacaoPraticanteEntradaDTO, EducacaoPraticante.class);
    }

    public static EducacaoPraticanteSaidaDTO converterEducacaoPacienteParaEducacaoPacienteOutputDTO(EducacaoPraticante educacaoPraticante) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(educacaoPraticante, EducacaoPraticanteSaidaDTO.class);
    }

    // Emergencia

    public static Emergencia converterEmergenciaInputDTOParaEmergencia(EmergenciaEntradaDTO emergenciaEntradaDTO) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(emergenciaEntradaDTO, Emergencia.class);
    }

    public static EmergenciaSaidaDTO converterEmergenciaParaEmergenciaOutputDTO(Emergencia emergencia) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(emergencia, EmergenciaSaidaDTO.class);
    }

    // Responsavel pelo paciente
    public static ResponsavelPraticante converterResponsavelPacienteInputDTOEmResponsavelPaciente(ResponsavelPraticanteEntradaDTO responsavelPraticanteEntradaDTO) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(responsavelPraticanteEntradaDTO, ResponsavelPraticante.class);
    }

    public static ResponsavelPraticanteSaidaDTO converterResponsavelPacienteEmResponsavelPacienteOutputDTO(ResponsavelPraticante responsavelPraticante) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(responsavelPraticante, ResponsavelPraticanteSaidaDTO.class);
    }


}
