package com.equoterapia.api.controlador.praticante.fichaCadastroAdmissional;

import com.equoterapia.api.controlador.utilidades.Mensagem;
import com.equoterapia.api.dto.praticante.fichaCadastroAdmissional.OutrasAtividadesTardeEntradaDTO;
import com.equoterapia.api.mapeador.praticante.PraticanteMapeador;
import com.equoterapia.dominio.servico.praticante.fichaCadastroAdmissional.OutrasAtividadesTardeServico;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/praticante/outras-atividades-tarde")
public class OutrasAtividadesTardeControlador {

    @Autowired
    private OutrasAtividadesTardeServico servico;
    @PostMapping("/salvar-outras-atividades-tarde-do-praticante")
    public ResponseEntity<?> salvarOutrasAtividadesTarde(@RequestBody @Valid OutrasAtividadesTardeEntradaDTO outrasAtividadesTardeEntradaDTO){
        servico.salvarOutrasAtividadesTarde(PraticanteMapeador.converterOutrasAtividadesTardeEntradaDTOEmOutrasAtividadesTarde(outrasAtividadesTardeEntradaDTO));
        return new ResponseEntity<Mensagem>(new Mensagem("Outras atividades da tarde salvas com sucesso!"), HttpStatus.CREATED);
    }

    @PutMapping("/atualizar-outras-atividades-tarde-do-praticante")
    public ResponseEntity<?> atualizarOutrasAtividadesTarde(OutrasAtividadesTardeEntradaDTO outrasAtividadesTardeEntradaDTO){
        servico.atualizarOutrasAtividadesTarde(PraticanteMapeador.converterOutrasAtividadesTardeEntradaDTOEmOutrasAtividadesTarde(outrasAtividadesTardeEntradaDTO));
        return new ResponseEntity<Mensagem>(new Mensagem("Outras atividades da tarde atualizadas com sucesso!"), HttpStatus.CREATED);
    }

    @GetMapping("/buscar-outras-atividades-tarde-do-praticante-por-id")
    public ResponseEntity<?> buscarOutrasAtividadesTarde(@RequestParam("id") Long id){
        return new ResponseEntity<>(PraticanteMapeador.converterOutrasAtividadesTardeEmOutrasAtividadesTardeSaidaDTO(servico.buscarOutrasAtividadesTardePorId(id)), HttpStatus.CREATED);
    }
}
