package com.equoterapia.api.controlador.praticante.avaliacaoPsicologica;

import com.equoterapia.api.controlador.utilidades.Mensagem;
import com.equoterapia.api.dto.praticante.avaliacaoPsicologica.RotinaEntradaDTO;
import com.equoterapia.api.mapeador.praticante.PraticanteMapeador;
import com.equoterapia.dominio.modelo.praticante.avaliacaoPsicologica.Rotina;
import com.equoterapia.dominio.servico.praticante.avaliacaoPsicologica.RotinaServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("praticante/rotina")
public class RotinaControlador {

    @Autowired
    private RotinaServico rotinaServico;

    @PostMapping("/salvar-rotina-do-praticante")
    public ResponseEntity<?> salvarRotina(@RequestBody RotinaEntradaDTO rotinaEntradaDTO) {
        Rotina rotina = PraticanteMapeador.converterRotinaEntradaDTOEmRotina(rotinaEntradaDTO);
        rotinaServico.salvarRotina(rotina);
        return new ResponseEntity<>(new Mensagem("Rotina do praticante cadastrada com sucesso!"), HttpStatus.CREATED);
    }

    @PutMapping("/atualizar-rotina-do-praticante")
    public ResponseEntity<?> atualizarRotina(@RequestBody RotinaEntradaDTO rotinaEntradaDTO) {
        Rotina rotina = PraticanteMapeador.converterRotinaEntradaDTOEmRotina(rotinaEntradaDTO);
        rotinaServico.atualizarRotina(rotina);
        return new ResponseEntity<>(new Mensagem("Rotina do praticante atualizada com sucesso!"), HttpStatus.CREATED);
    }

    @GetMapping("/buscar-rotina-do-praticante-por-id")
    public ResponseEntity<?> buscarRotinaPorId(@RequestParam("id") Long id) {
        return new ResponseEntity<>(PraticanteMapeador.converterRotinaEmRotinaSaidaDTO(rotinaServico.buscarRotinaPorId(id)), HttpStatus.OK);
    }
}
