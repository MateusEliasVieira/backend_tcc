package com.equoterapia.api.controlador.praticante.avaliacaoFisioterapeutica;

import com.equoterapia.api.controlador.utilidades.Mensagem;
import com.equoterapia.api.dto.praticante.avaliacaoFisioterapeutica.AvaliacaoFisioterapeuticaEntradaDTO;
import com.equoterapia.api.mapeador.praticante.PraticanteMapeador;
import com.equoterapia.dominio.modelo.praticante.avaliacaoFisioterapeutica.AvaliacaoFisioterapeutica;
import com.equoterapia.dominio.servico.praticante.avaliacaoFisioterapeutica.AvaliacaoFisioterapeuticaServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("praticante/avaliacao-fisioterapeutica")
public class AvaliacaoFisioterapeuticaControlador {
    @Autowired
    private AvaliacaoFisioterapeuticaServico avaliacaoFisioterapeuticaServicoServico;

    @PostMapping("/salvar-avaliacao-fisioterapeutica-do-praticante")
    public ResponseEntity<?> salvarAvaliacaoFisioterapeutica(@RequestBody AvaliacaoFisioterapeuticaEntradaDTO avaliacaoFisioterapeuticaServicoEntradaDTO) {
        AvaliacaoFisioterapeutica avaliacaoFisioterapeuticaServico = PraticanteMapeador.converterAvaliacaoFisioterapeuticaEntradaDTOEmAvaliacaoFisioterapeutica(avaliacaoFisioterapeuticaServicoEntradaDTO);
        avaliacaoFisioterapeuticaServicoServico.salvarAvaliacaoFisioterapeutica(avaliacaoFisioterapeuticaServico);
        return new ResponseEntity<>(new Mensagem("AvaliacaoFisioterapeutica do praticante cadastrada com sucesso!"), HttpStatus.CREATED);
    }

    @PutMapping("/atualizar-avaliacao-fisioterapeutica-do-praticante")
    public ResponseEntity<?> atualizarAvaliacaoFisioterapeutica(@RequestBody AvaliacaoFisioterapeuticaEntradaDTO avaliacaoFisioterapeuticaServicoEntradaDTO) {
        AvaliacaoFisioterapeutica avaliacaoFisioterapeuticaServico = PraticanteMapeador.converterAvaliacaoFisioterapeuticaEntradaDTOEmAvaliacaoFisioterapeutica(avaliacaoFisioterapeuticaServicoEntradaDTO);
        avaliacaoFisioterapeuticaServicoServico.atualizarAvaliacaoFisioterapeutica(avaliacaoFisioterapeuticaServico);
        return new ResponseEntity<>(new Mensagem("AvaliacaoFisioterapeutica do praticante atualizada com sucesso!"), HttpStatus.CREATED);
    }

    @GetMapping("/buscar-avaliacao-fisioterapeutica-do-praticante-por-id")
    public ResponseEntity<?> buscarAvaliacaoFisioterapeuticaPorId(@RequestParam("id") Long id) {
        return new ResponseEntity<>(PraticanteMapeador.converterAvaliacaoFisioterapeuticaEmAvaliacaoFisioterapeuticaSaidaDTO(avaliacaoFisioterapeuticaServicoServico.buscarAvaliacaoFisioterapeuticaPorId(id)), HttpStatus.OK);
    }
}
