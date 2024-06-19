package com.equoterapia.api.controller.paciente.fichaCadastroAdmissional;

import com.equoterapia.api.dto.paciente.fichaCadastroAdmissional.EducacaoPacienteInputDTO;
import com.equoterapia.api.dto.paciente.fichaCadastroAdmissional.EducacaoPacienteOutputDTO;
import com.equoterapia.api.mapper.paciente.PacienteMapper;
import com.equoterapia.domain.model.paciente.fichaCadastroAdmissional.EducacaoPaciente;
import com.equoterapia.domain.service.paciente.fichaCadastroAdmissional.EducacaoPacienteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/paciente/educacao-paciente")
public class EducacaoPacienteController {

    @Autowired
    private EducacaoPacienteService educacaoPacienteService;

    @PostMapping("/salvar-educacao-paciente")
    public ResponseEntity<?> salvarEducacaoPaciente(@RequestBody @Valid EducacaoPacienteInputDTO educacaoPacienteInputDTO){
        System.out.println("ID = "+educacaoPacienteInputDTO.getPaciente().getIdPaciente());
        EducacaoPaciente educacaoPaciente = PacienteMapper.converterEducacaoPacienteInputDTOParaEducacaoPaciente(educacaoPacienteInputDTO);
        EducacaoPacienteOutputDTO educacaoPacienteOutputDTO = PacienteMapper.converterEducacaoPacienteParaEducacaoPacienteOutputDTO(educacaoPacienteService.salvarEducacaoPaciente(educacaoPaciente));
        return new ResponseEntity<EducacaoPacienteOutputDTO>(educacaoPacienteOutputDTO, HttpStatus.CREATED);
    }

    @PutMapping("/atualizar-educacao-paciente")
    public ResponseEntity<?> atualizarEducacaoPaciente(@RequestBody @Valid EducacaoPacienteInputDTO educacaoPacienteInputDTO){
        EducacaoPaciente educacaoPaciente = PacienteMapper.converterEducacaoPacienteInputDTOParaEducacaoPaciente(educacaoPacienteInputDTO);
        EducacaoPacienteOutputDTO educacaoPacienteOutputDTO = PacienteMapper.converterEducacaoPacienteParaEducacaoPacienteOutputDTO(educacaoPacienteService.atualizarEducacaoPaciente(educacaoPaciente));
        return new ResponseEntity<EducacaoPacienteOutputDTO>(educacaoPacienteOutputDTO, HttpStatus.OK);
    }

    @GetMapping("/buscar-educacao-paciente-por-id/{id}")
    public ResponseEntity<?> buscarEducacaoPaciente(@Valid @PathVariable("id") Long id){
        EducacaoPaciente educacaoPaciente = educacaoPacienteService.buscarEducacaoPaciente(id);
        EducacaoPacienteOutputDTO educacaoPacienteOutputDTO = PacienteMapper.converterEducacaoPacienteParaEducacaoPacienteOutputDTO(educacaoPaciente);
        return new ResponseEntity<EducacaoPacienteOutputDTO>(educacaoPacienteOutputDTO, HttpStatus.OK);
    }

}
