package com.equoterapia.api.controlador.praticante.fichaCadastroAdmissional;

import com.equoterapia.api.dto.praticante.fichaCadastroAdmissional.CompletudeMatriculaEntradaDTO;
import com.equoterapia.api.dto.praticante.fichaCadastroAdmissional.CompletudeMatriculaSaidaDTO;
import com.equoterapia.api.mapeador.praticante.PraticanteMapeador;
import com.equoterapia.dominio.modelo.praticante.fichaCadastroAdmissional.CompletudeMatricula;
import com.equoterapia.dominio.servico.paciente.fichaCadastroAdmissional.CompletudeMatriculaServico;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/praticante/completude-matricula")
public class CompletudeMatriculaControlador {

    @Autowired
    private CompletudeMatriculaServico completudeMatriculaServico;

    @PostMapping("/salvar-completude-matricula")
    public ResponseEntity<?> salvarCompletudeMatricula(@RequestBody @Valid CompletudeMatriculaEntradaDTO completudeMatriculaEntradaDTO){
        CompletudeMatricula completudeMatriculaSalvar = PraticanteMapeador.converterCompletudeMatriculaInputDTOParaCompletudeMatricula(completudeMatriculaEntradaDTO);
        CompletudeMatriculaSaidaDTO completudeMatriculaOutputDTO = PraticanteMapeador.converterCompletudeMatriculaParaCompletudeMatriculaOutputDTO(completudeMatriculaServico.salvarCompletudeMatricula(completudeMatriculaSalvar));
        return new ResponseEntity<CompletudeMatriculaSaidaDTO>(completudeMatriculaOutputDTO, HttpStatus.CREATED);
    }

    @PutMapping("/atualizar-completude-matricula")
    public ResponseEntity<?> atualizarCompletudeMatricula(@RequestBody @Valid CompletudeMatriculaEntradaDTO completudeMatriculaEntradaDTO){
        CompletudeMatricula completudeMatriculaSalvar = PraticanteMapeador.converterCompletudeMatriculaInputDTOParaCompletudeMatricula(completudeMatriculaEntradaDTO);
        CompletudeMatriculaSaidaDTO completudeMatriculaOutputDTO = PraticanteMapeador.converterCompletudeMatriculaParaCompletudeMatriculaOutputDTO(completudeMatriculaServico.atualizarCompletudeMatricula(completudeMatriculaSalvar));
        return new ResponseEntity<CompletudeMatriculaSaidaDTO>(completudeMatriculaOutputDTO, HttpStatus.CREATED);
    }

    @GetMapping("/buscar-completude-matricula-por-id/{id}")
    public ResponseEntity<?> buscarCompletudeMatricula(@Valid @PathVariable("id") Long id){
        CompletudeMatricula completudeMatricula = completudeMatriculaServico.buscarCompletudeMatricula(id);
        CompletudeMatriculaSaidaDTO completudeMatriculaOutputDTO = PraticanteMapeador.converterCompletudeMatriculaParaCompletudeMatriculaOutputDTO(completudeMatricula);
        return new ResponseEntity<CompletudeMatriculaSaidaDTO>(completudeMatriculaOutputDTO,HttpStatus.OK);
    }



}
