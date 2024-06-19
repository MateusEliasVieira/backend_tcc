package com.equoterapia.api.controller.paciente.fichaCadastroAdmissional;

import com.equoterapia.api.dto.paciente.fichaCadastroAdmissional.ResponsavelPacienteInputDTO;
import com.equoterapia.api.dto.paciente.fichaCadastroAdmissional.ResponsavelPacienteOutputDTO;
import com.equoterapia.api.mapper.paciente.PacienteMapper;
import com.equoterapia.domain.model.paciente.fichaCadastroAdmissional.ResponsavelPaciente;
import com.equoterapia.domain.service.paciente.fichaCadastroAdmissional.ResponsavelPacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/paciente/responsavel-pelo-paciente")
public class ResponsavelPeloPacienteController {

    @Autowired
    private ResponsavelPacienteService service;

    @PostMapping(path = "/salvar-responsavel-pelo-paciente")
    public ResponseEntity<ResponsavelPacienteOutputDTO> salvarResponsavelPeloPaciente(@RequestBody ResponsavelPacienteInputDTO responsavelPacienteInputDTO) {
        return new ResponseEntity<ResponsavelPacienteOutputDTO>(PacienteMapper.converterResponsavelPacienteEmResponsavelPacienteOutputDTO(service.salvar(PacienteMapper.converterResponsavelPacienteInputDTOEmResponsavelPaciente(responsavelPacienteInputDTO))), HttpStatus.CREATED);
    }
}
