package com.equoterapia.api.controller.paciente.fichaCadastroAdmissional;

import com.equoterapia.api.dto.paciente.fichaCadastroAdmissional.DadosPessoaisInputDTO;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping( "/ficha-cadastro-admissional")
public class FichaCadastroAdmissionalController {

    public ResponseEntity<?> salvarDadosPessoais(@RequestBody @Valid DadosPessoaisInputDTO dadosPessoaisInputDTO){
        return new ResponseEntity<>(null, HttpStatus.CREATED);
    }

}
