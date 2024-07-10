package com.equoterapia.api.controlador.praticante.avaliacaoFisioterapeutica;

import com.equoterapia.api.controlador.utilidades.Mensagem;
import com.equoterapia.api.dto.praticante.avaliacaoFisioterapeutica.FormaDeComunicacaoEntradaDTO;
import com.equoterapia.api.mapeador.praticante.PraticanteMapeador;
import com.equoterapia.dominio.modelo.praticante.avaliacaoFisioterapeutica.FormaDeComunicacao;
import com.equoterapia.dominio.servico.praticante.avaliacaoFisioterapeutica.FormaDeComunicacaoServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("praticante/forma-de-comunicacao")
public class FormaDeComunicacaoControlador {
    @Autowired
    private FormaDeComunicacaoServico formaDeComunicacaopeuticaServicoServico;

    @PostMapping("/salvar-forma-de-comunicacao-do-praticante")
    public ResponseEntity<?> salvarFormaDeComunicacao(@RequestBody FormaDeComunicacaoEntradaDTO formaDeComunicacaopeuticaServicoEntradaDTO) {
        FormaDeComunicacao formaDeComunicacaopeuticaServico = PraticanteMapeador.converterFormaDeComunicacaoEntradaDTOEmFormaDeComunicacao(formaDeComunicacaopeuticaServicoEntradaDTO);
        formaDeComunicacaopeuticaServicoServico.salvarFormaDeComunicacao(formaDeComunicacaopeuticaServico);
        return new ResponseEntity<>(new Mensagem("Forma de comunicação do praticante cadastrada com sucesso!"), HttpStatus.CREATED);
    }

    @PutMapping("/atualizar-forma-de-comunicacao-do-praticante")
    public ResponseEntity<?> atualizarFormaDeComunicacao(@RequestBody FormaDeComunicacaoEntradaDTO formaDeComunicacaopeuticaServicoEntradaDTO) {
        FormaDeComunicacao formaDeComunicacaopeuticaServico = PraticanteMapeador.converterFormaDeComunicacaoEntradaDTOEmFormaDeComunicacao(formaDeComunicacaopeuticaServicoEntradaDTO);
        formaDeComunicacaopeuticaServicoServico.atualizarFormaDeComunicacao(formaDeComunicacaopeuticaServico);
        return new ResponseEntity<>(new Mensagem("Forma de comunicação do praticante atualizada com sucesso!"), HttpStatus.CREATED);
    }

    @GetMapping("/buscar-forma-de-comunicacao-do-praticante-por-id")
    public ResponseEntity<?> buscarFormaDeComunicacaoPorId(@RequestParam("id") Long id) {
        return new ResponseEntity<>(PraticanteMapeador.converterFormaDeComunicacaoEmFormaDeComunicacaoSaidaDTO(formaDeComunicacaopeuticaServicoServico.buscarFormaDeComunicacaoPorId(id)), HttpStatus.OK);
    }
}
