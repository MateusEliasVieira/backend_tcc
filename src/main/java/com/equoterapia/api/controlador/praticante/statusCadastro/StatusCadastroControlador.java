package com.equoterapia.api.controlador.praticante.statusCadastro;

import com.equoterapia.api.dto.praticante.statusCadastro.StatusCadastroSaida;
import com.equoterapia.dominio.servico.praticante.statusCadastro.StatusCadastroServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/praticante/status-cadastro")
public class StatusCadastroControlador {

    @Autowired
    private StatusCadastroServico servico;

    @GetMapping("/verificar-status-do-cadastro-do-praticante")
    public ResponseEntity<StatusCadastroSaida> verificarStatusDoCadastro(@RequestParam("id") Long idPraticante){
        StatusCadastroSaida scs = servico.verificarQuantidadeCadastroRestante(idPraticante);
        return new ResponseEntity<StatusCadastroSaida>(scs, HttpStatus.OK);
    }


}
