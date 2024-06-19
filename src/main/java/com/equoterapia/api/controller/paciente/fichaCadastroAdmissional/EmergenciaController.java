package com.equoterapia.api.controller.paciente.fichaCadastroAdmissional;

import com.equoterapia.api.dto.paciente.fichaCadastroAdmissional.EmergenciaInputDTO;
import com.equoterapia.api.dto.paciente.fichaCadastroAdmissional.EmergenciaOutputDTO;
import com.equoterapia.api.mapper.paciente.PacienteMapper;
import com.equoterapia.domain.model.paciente.fichaCadastroAdmissional.Emergencia;
import com.equoterapia.domain.service.paciente.fichaCadastroAdmissional.EmergenciaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/paciente/emergencia")
public class EmergenciaController {

    @Autowired
    private EmergenciaService emergenciaService;

    @PostMapping("/salvar-emergencia")
    public ResponseEntity<?> salvarEmergencia(@RequestBody @Valid EmergenciaInputDTO emergenciaInputDTO){
        Emergencia emergencia = PacienteMapper.converterEmergenciaInputDTOParaEmergencia(emergenciaInputDTO);
        Emergencia emergenciaSalva = emergenciaService.salvarEmergencia(emergencia);
        EmergenciaOutputDTO emergenciaOutputDTO = PacienteMapper.converterEmergenciaParaEmergenciaOutputDTO(emergenciaSalva);
        return new ResponseEntity<EmergenciaOutputDTO>(emergenciaOutputDTO, HttpStatus.CREATED);
    }

    @PutMapping("/atualizar-emergencia")
    public ResponseEntity<?> atualizarEmergencia(@RequestBody @Valid EmergenciaInputDTO emergenciaInputDTO){
        Emergencia emergencia = PacienteMapper.converterEmergenciaInputDTOParaEmergencia(emergenciaInputDTO);
        Emergencia emergenciaSalva = emergenciaService.atualizarEmergencia(emergencia);
        EmergenciaOutputDTO emergenciaOutputDTO = PacienteMapper.converterEmergenciaParaEmergenciaOutputDTO(emergenciaSalva);
        return new ResponseEntity<EmergenciaOutputDTO>(emergenciaOutputDTO, HttpStatus.OK);
    }

    @GetMapping("/buscar-emergencia-por-id/{id}")
    public ResponseEntity<?> buscarEmergencia(@PathVariable("id") @Valid Long id){
        Emergencia emergenciaEncontrada = emergenciaService.buscarEmergencia(id);
        EmergenciaOutputDTO emergenciaOutputDTO = PacienteMapper.converterEmergenciaParaEmergenciaOutputDTO(emergenciaEncontrada);
        return new ResponseEntity<EmergenciaOutputDTO>(emergenciaOutputDTO, HttpStatus.OK);
    }

}
