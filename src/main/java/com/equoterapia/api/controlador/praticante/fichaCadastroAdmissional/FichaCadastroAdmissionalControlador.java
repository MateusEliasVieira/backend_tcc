package com.equoterapia.api.controlador.praticante.fichaCadastroAdmissional;

import com.equoterapia.api.dto.praticante.fichaCadastroAdmissional.DadosPessoaisEntradaDTO;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping( "/ficha-cadastro-admissional")
public class FichaCadastroAdmissionalControlador {

    public ResponseEntity<?> salvarDadosPessoais(@RequestBody @Valid DadosPessoaisEntradaDTO dadosPessoaisEntradaDTO){
        return new ResponseEntity<>(null, HttpStatus.CREATED);
    }

}
