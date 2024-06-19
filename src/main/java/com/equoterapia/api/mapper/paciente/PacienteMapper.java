package com.equoterapia.api.mapper.paciente;

import com.equoterapia.api.dto.paciente.fichaCadastroAdmissional.*;
import com.equoterapia.domain.model.paciente.fichaCadastroAdmissional.*;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;

public class PacienteMapper {

    // Dados Pessoais
    public static DadosPessoais converterDadosPessoaisInputDTOParaDadosPessoais(DadosPessoaisInputDTO dadosPessoaisInputDTO) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(dadosPessoaisInputDTO, DadosPessoais.class);
    }

    public static DadosPessoaisOutputDTO converterDadosPessoaisParaDadosPessoaisOutputDTO(DadosPessoais dadosPessoais) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(dadosPessoais, DadosPessoaisOutputDTO.class);
    }

    public static List<DadosPessoaisOutputDTO> converterListaDeDadosPessoaisParaListaDeDadosPessoaisOutputDTO(List<DadosPessoais> listaDadosPessoais) {
        ModelMapper modelMapper = new ModelMapper();
        List<DadosPessoaisOutputDTO> listaOutputDTO = new ArrayList<>();
        for (DadosPessoais dadosPessoais : listaDadosPessoais) {
            DadosPessoaisOutputDTO outputDTO = modelMapper.map(dadosPessoais, DadosPessoaisOutputDTO.class);
            listaOutputDTO.add(outputDTO);
        }
        return listaOutputDTO;
    }

    // Completude Matricula
    public static CompletudeMatricula converterCompletudeMatriculaInputDTOParaCompletudeMatricula(CompletudeMatriculaInputDTO completudeMatriculaInputDTO) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(completudeMatriculaInputDTO, CompletudeMatricula.class);
    }

    public static CompletudeMatriculaOutputDTO converterCompletudeMatriculaParaCompletudeMatriculaOutputDTO(CompletudeMatricula completudeMatricula) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(completudeMatricula, CompletudeMatriculaOutputDTO.class);
    }

    public static List<CompletudeMatriculaOutputDTO> converterListaDeCompletudeMatriculaParaListaDeCompletudeMatriculaOutputDTO(List<CompletudeMatricula> listaCompletudeMatricula) {
        ModelMapper modelMapper = new ModelMapper();
        List<CompletudeMatriculaOutputDTO> listaOutputDTO = new ArrayList<>();
        for (CompletudeMatricula completudeMatricula : listaCompletudeMatricula) {
            CompletudeMatriculaOutputDTO outputDTO = modelMapper.map(completudeMatricula, CompletudeMatriculaOutputDTO.class);
            listaOutputDTO.add(outputDTO);
        }
        return listaOutputDTO;
    }

    // Educação Paciente

    public static EducacaoPaciente converterEducacaoPacienteInputDTOParaEducacaoPaciente(EducacaoPacienteInputDTO educacaoPacienteInputDTO) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(educacaoPacienteInputDTO, EducacaoPaciente.class);
    }

    public static EducacaoPacienteOutputDTO converterEducacaoPacienteParaEducacaoPacienteOutputDTO(EducacaoPaciente educacaoPaciente) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(educacaoPaciente, EducacaoPacienteOutputDTO.class);
    }

    // Emergencia

    public static Emergencia converterEmergenciaInputDTOParaEmergencia(EmergenciaInputDTO emergenciaInputDTO) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(emergenciaInputDTO, Emergencia.class);
    }

    public static EmergenciaOutputDTO converterEmergenciaParaEmergenciaOutputDTO(Emergencia emergencia) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(emergencia, EmergenciaOutputDTO.class);
    }

    // Responsavel pelo paciente
    public static ResponsavelPaciente converterResponsavelPacienteInputDTOEmResponsavelPaciente(ResponsavelPacienteInputDTO responsavelPacienteInputDTO) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(responsavelPacienteInputDTO, ResponsavelPaciente.class);
    }

    public static ResponsavelPacienteOutputDTO converterResponsavelPacienteEmResponsavelPacienteOutputDTO(ResponsavelPaciente responsavelPaciente) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(responsavelPaciente, ResponsavelPacienteOutputDTO.class);
    }


}
