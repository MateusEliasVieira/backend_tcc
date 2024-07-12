package com.equoterapia.api.controlador.praticante.avaliacaoFisioterapeutica;

import com.equoterapia.api.controlador.utilidades.Mensagem;
import com.equoterapia.api.dto.praticante.avaliacaoFisioterapeutica.SaudeGeralDosPraticantesEntradaDTO;
import com.equoterapia.api.mapeador.praticante.PraticanteMapeador;
import com.equoterapia.dominio.modelo.praticante.avaliacaoFisioterapeutica.SaudeGeralDoPraticante;
import com.equoterapia.dominio.servico.praticante.avaliacaoFisioterapeutica.SaudeGeralDosPraticantesServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("praticante/saude-geral-do-praticante")
public class SaudeGeralDoPraticanteControlador {
    @Autowired
    private SaudeGeralDosPraticantesServico saudeGeralDosPraticantesServico;

    @PostMapping("/salvar-saude-geral-do-praticante")
    public ResponseEntity<?> salvarSaudeGeralDosPraticantes(@RequestBody SaudeGeralDosPraticantesEntradaDTO saudeGeralDosPraticantesServicoEntradaDTO) {
        SaudeGeralDoPraticante saudeGeralDoPraticante = PraticanteMapeador.converterSaudeGeralDosPraticantesEntradaDTOEmSaudeGeralDosPraticantes(saudeGeralDosPraticantesServicoEntradaDTO);
        saudeGeralDosPraticantesServico.salvarSaudeGeralDosPraticantes(saudeGeralDoPraticante);
        return new ResponseEntity<>(new Mensagem("Saúde geral do praticante cadastrada com sucesso!"), HttpStatus.CREATED);
    }

    @PutMapping("/atualizar-saude-geral-do-praticante")
    public ResponseEntity<?> atualizarSaudeGeralDosPraticantes(@RequestBody SaudeGeralDosPraticantesEntradaDTO saudeGeralDosPraticantesServicoEntradaDTO) {
        SaudeGeralDoPraticante saudeGeralDoPraticante = PraticanteMapeador.converterSaudeGeralDosPraticantesEntradaDTOEmSaudeGeralDosPraticantes(saudeGeralDosPraticantesServicoEntradaDTO);
        saudeGeralDosPraticantesServico.atualizarSaudeGeralDosPraticantes(saudeGeralDoPraticante);
        return new ResponseEntity<>(new Mensagem("Saúde geral do praticante atualizada com sucesso!"), HttpStatus.CREATED);
    }

    @GetMapping("/buscar-saude-geral-do-praticante-por-id")
    public ResponseEntity<?> buscarSaudeGeralDosPraticantesPorId(@RequestParam("id") Long id) {
        return new ResponseEntity<>(PraticanteMapeador.converterSaudeGeralDosPraticantesEmSaudeGeralDosPraticantesSaidaDTO(saudeGeralDosPraticantesServico.buscarSaudeGeralDosPraticantesPorId(id)), HttpStatus.OK);
    }
}
