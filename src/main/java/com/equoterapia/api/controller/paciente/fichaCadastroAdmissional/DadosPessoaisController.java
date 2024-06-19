package com.equoterapia.api.controller.paciente.fichaCadastroAdmissional;

import com.equoterapia.api.dto.paciente.fichaCadastroAdmissional.DadosPessoaisInputDTO;
import com.equoterapia.api.dto.paciente.fichaCadastroAdmissional.DadosPessoaisOutputDTO;
import com.equoterapia.api.mapper.paciente.PacienteMapper;
import com.equoterapia.domain.model.paciente.fichaCadastroAdmissional.DadosPessoais;
import com.equoterapia.domain.service.paciente.fichaCadastroAdmissional.DadosPessoaisService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/paciente/dados-pessoais")
public class DadosPessoaisController {

    @Autowired
    private DadosPessoaisService dadosPessoaisService;

    @PostMapping("/salvar-dados-pessoais")
    public ResponseEntity<?> salvarDadosPessoais(@RequestBody @Valid DadosPessoaisInputDTO dadosPessoaisInputDTO){
        DadosPessoais dadosPessoais = PacienteMapper.converterDadosPessoaisInputDTOParaDadosPessoais(dadosPessoaisInputDTO);
        DadosPessoais dadosPessoaisSalvo = dadosPessoaisService.salvarDadosPessoais(dadosPessoais);
        DadosPessoaisOutputDTO dadosPessoaisOutputDTO = PacienteMapper.converterDadosPessoaisParaDadosPessoaisOutputDTO(dadosPessoaisSalvo);
        return new ResponseEntity<DadosPessoaisOutputDTO>(dadosPessoaisOutputDTO, HttpStatus.CREATED);
    }

    @PutMapping("/atualizar-dados-pessoais")
    public ResponseEntity<?> atualizarDadosPessoais(@RequestBody @Valid DadosPessoaisInputDTO dadosPessoaisInputDTO){
        DadosPessoais dadosPessoais = PacienteMapper.converterDadosPessoaisInputDTOParaDadosPessoais(dadosPessoaisInputDTO);
        DadosPessoais dadosPessoaisAtualizado = dadosPessoaisService.atualizarDadosPessoais(dadosPessoais);
        DadosPessoaisOutputDTO dadosPessoaisOutputDTO = PacienteMapper.converterDadosPessoaisParaDadosPessoaisOutputDTO(dadosPessoaisAtualizado);
        return new ResponseEntity<DadosPessoaisOutputDTO>(dadosPessoaisOutputDTO, HttpStatus.CREATED);
    }

    @GetMapping("/buscar-dados-pessoais-por-id/{id_paciente}")
    public ResponseEntity<?> buscarDadosPessoaisDosPacientes(@PathVariable("id_paciente") Long id_paciente){
        DadosPessoais dadosPessoais = dadosPessoaisService.buscarDadosPessoaisPorID(id_paciente);
        DadosPessoaisOutputDTO dadosPessoaisOutputDTO = PacienteMapper.converterDadosPessoaisParaDadosPessoaisOutputDTO(dadosPessoais);
        return new ResponseEntity<DadosPessoaisOutputDTO>(dadosPessoaisOutputDTO, HttpStatus.OK);
    }

    @GetMapping("/buscar-dados-pessoais-dos-pacientes")
    public ResponseEntity<?> buscarDadosPessoaisDosPacientes(){
        List<DadosPessoais> listaDeDadosPessoaisDosPacientes = dadosPessoaisService.buscarDadosPessoaisDosPacientes();
        List<DadosPessoaisOutputDTO> listaDadosPessoaisDosPacientesOutputDTO = PacienteMapper.converterListaDeDadosPessoaisParaListaDeDadosPessoaisOutputDTO(listaDeDadosPessoaisDosPacientes);
        return new ResponseEntity<List<DadosPessoaisOutputDTO>>(listaDadosPessoaisDosPacientesOutputDTO, HttpStatus.OK);
    }

}
