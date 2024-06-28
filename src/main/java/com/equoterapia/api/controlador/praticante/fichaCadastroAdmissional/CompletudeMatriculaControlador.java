package com.equoterapia.api.controlador.praticante.fichaCadastroAdmissional;

import com.equoterapia.api.dto.praticante.fichaCadastroAdmissional.CompletudeMatriculaEntradaDTO;
import com.equoterapia.api.dto.praticante.fichaCadastroAdmissional.CompletudeMatriculaSaidaDTO;
import com.equoterapia.api.mapeador.praticante.PraticanteMapeador;
import com.equoterapia.dominio.modelo.praticante.fichaCadastroAdmissional.CompletudeMatricula;
import com.equoterapia.dominio.servico.praticante.fichaCadastroAdmissional.CompletudeMatriculaServico;
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

    @PostMapping("/salvar-completude-matricula-do-praticante")
    public ResponseEntity<?> salvarCompletudeMatricula(@RequestBody @Valid CompletudeMatriculaEntradaDTO completudeMatriculaEntradaDTO){
        CompletudeMatricula completudeMatriculaSalvar = PraticanteMapeador.converterCompletudeMatriculaEntradaDTOParaCompletudeMatricula(completudeMatriculaEntradaDTO);
        CompletudeMatriculaSaidaDTO completudeMatriculaSaidaDTO = PraticanteMapeador.converterCompletudeMatriculaParaCompletudeMatriculaSaidaDTO(completudeMatriculaServico.salvarCompletudeMatricula(completudeMatriculaSalvar));
        return new ResponseEntity<CompletudeMatriculaSaidaDTO>(completudeMatriculaSaidaDTO, HttpStatus.CREATED);
    }

    @PutMapping("/atualizar-completude-matricula-do-praticante")
    public ResponseEntity<?> atualizarCompletudeMatricula(@RequestBody @Valid CompletudeMatriculaEntradaDTO completudeMatriculaEntradaDTO){
        CompletudeMatricula completudeMatriculaSalvar = PraticanteMapeador.converterCompletudeMatriculaEntradaDTOParaCompletudeMatricula(completudeMatriculaEntradaDTO);
        CompletudeMatriculaSaidaDTO completudeMatriculaSaidaDTO = PraticanteMapeador.converterCompletudeMatriculaParaCompletudeMatriculaSaidaDTO(completudeMatriculaServico.atualizarCompletudeMatricula(completudeMatriculaSalvar));
        return new ResponseEntity<CompletudeMatriculaSaidaDTO>(completudeMatriculaSaidaDTO, HttpStatus.CREATED);
    }

    @GetMapping("/buscar-completude-matricula-do-praticante-por-id/{id}")
    public ResponseEntity<?> buscarCompletudeMatricula(@Valid @PathVariable("id") Long id){
        CompletudeMatricula completudeMatricula = completudeMatriculaServico.buscarCompletudeMatricula(id);
        CompletudeMatriculaSaidaDTO completudeMatriculaSaidaDTO = PraticanteMapeador.converterCompletudeMatriculaParaCompletudeMatriculaSaidaDTO(completudeMatricula);
        return new ResponseEntity<CompletudeMatriculaSaidaDTO>(completudeMatriculaSaidaDTO,HttpStatus.OK);
    }



}
