package com.equoterapia.api.controller.paciente.fichaCadastroAdmissional;

import com.equoterapia.api.dto.paciente.fichaCadastroAdmissional.CompletudeMatriculaInputDTO;
import com.equoterapia.api.dto.paciente.fichaCadastroAdmissional.CompletudeMatriculaOutputDTO;
import com.equoterapia.api.mapper.paciente.PacienteMapper;
import com.equoterapia.domain.model.paciente.fichaCadastroAdmissional.CompletudeMatricula;
import com.equoterapia.domain.service.paciente.fichaCadastroAdmissional.CompletudeMatriculaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/paciente/completude-matricula")
public class CompletudeMatriculaController {

    @Autowired
    private CompletudeMatriculaService completudeMatriculaService;

    @PostMapping("/salvar-completude-matricula")
    public ResponseEntity<?> salvarCompletudeMatricula(@RequestBody @Valid CompletudeMatriculaInputDTO completudeMatriculaInputDTO){
        CompletudeMatricula completudeMatriculaSalvar = PacienteMapper.converterCompletudeMatriculaInputDTOParaCompletudeMatricula(completudeMatriculaInputDTO);
        CompletudeMatriculaOutputDTO completudeMatriculaOutputDTO = PacienteMapper.converterCompletudeMatriculaParaCompletudeMatriculaOutputDTO(completudeMatriculaService.salvarCompletudeMatricula(completudeMatriculaSalvar));
        return new ResponseEntity<CompletudeMatriculaOutputDTO>(completudeMatriculaOutputDTO, HttpStatus.CREATED);
    }

    @PutMapping("/atualizar-completude-matricula")
    public ResponseEntity<?> atualizarCompletudeMatricula(@RequestBody @Valid CompletudeMatriculaInputDTO completudeMatriculaInputDTO){
        CompletudeMatricula completudeMatriculaSalvar = PacienteMapper.converterCompletudeMatriculaInputDTOParaCompletudeMatricula(completudeMatriculaInputDTO);
        CompletudeMatriculaOutputDTO completudeMatriculaOutputDTO = PacienteMapper.converterCompletudeMatriculaParaCompletudeMatriculaOutputDTO(completudeMatriculaService.atualizarCompletudeMatricula(completudeMatriculaSalvar));
        return new ResponseEntity<CompletudeMatriculaOutputDTO>(completudeMatriculaOutputDTO, HttpStatus.CREATED);
    }

    @GetMapping("/buscar-completude-matricula-por-id/{id}")
    public ResponseEntity<?> buscarCompletudeMatricula(@Valid @PathVariable("id") Long id){
        CompletudeMatricula completudeMatricula = completudeMatriculaService.buscarCompletudeMatricula(id);
        CompletudeMatriculaOutputDTO completudeMatriculaOutputDTO = PacienteMapper.converterCompletudeMatriculaParaCompletudeMatriculaOutputDTO(completudeMatricula);
        return new ResponseEntity<CompletudeMatriculaOutputDTO>(completudeMatriculaOutputDTO,HttpStatus.OK);
    }



}
