package com.equoterapia.api.mapeador.praticante;

import com.equoterapia.api.dto.praticante.fichaCadastroAdmissional.*;
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


}
