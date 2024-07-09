package com.equoterapia.api.controlador.praticante.avaliacaoPsicologica;

import com.equoterapia.api.controlador.utilidades.Mensagem;
import com.equoterapia.api.dto.praticante.avaliacaoPsicologica.ComportamentoEntradaDTO;
import com.equoterapia.api.mapeador.praticante.PraticanteMapeador;
import com.equoterapia.dominio.modelo.praticante.avaliacaoPsicologica.Comportamento;
import com.equoterapia.dominio.servico.praticante.avaliacaoPsicologica.ComportamentoServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("praticante/comportamento")
public class ComportamentoControlador {

    @Autowired
    private ComportamentoServico comportamentoServico;

    @PostMapping("/salvar-comportamento-do-praticante")
    public ResponseEntity<?> salvarComportamento(@RequestBody ComportamentoEntradaDTO comportamentoEntradaDTO) {
        Comportamento comportamento = PraticanteMapeador.converterComportamentoEntradaDTOEmComportamento(comportamentoEntradaDTO);
        comportamentoServico.salvarComportamento(comportamento);
        return new ResponseEntity<>(new Mensagem("Comportamento do praticante cadastrada com sucesso!"), HttpStatus.CREATED);
    }

    @PutMapping("/atualizar-comportamento-do-praticante")
    public ResponseEntity<?> atualizarComportamento(@RequestBody ComportamentoEntradaDTO comportamentoEntradaDTO) {
        Comportamento comportamento = PraticanteMapeador.converterComportamentoEntradaDTOEmComportamento(comportamentoEntradaDTO);
        comportamentoServico.atualizarComportamento(comportamento);
        return new ResponseEntity<>(new Mensagem("Comportamento do praticante atualizada com sucesso!"), HttpStatus.CREATED);
    }

    @GetMapping("/buscar-comportamento-do-praticante-por-id")
    public ResponseEntity<?> buscarComportamentoPorId(@RequestParam("id") Long id) {
        return new ResponseEntity<>(PraticanteMapeador.converterComportamentoEmComportamentoSaidaDTO(comportamentoServico.buscarComportamentoPorId(id)), HttpStatus.OK);
    }
}
