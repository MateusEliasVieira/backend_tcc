package com.equoterapia.api.controlador.praticante.avaliacaoPsicologica;

import com.equoterapia.api.controlador.utilidades.Mensagem;
import com.equoterapia.api.dto.praticante.avaliacaoPsicologica.AvaliacaoPsicologicaEntradaDTO;
import com.equoterapia.api.mapeador.praticante.PraticanteMapeador;
import com.equoterapia.dominio.modelo.praticante.avaliacaoPsicologica.AvaliacaoPsicologica;
import com.equoterapia.dominio.servico.praticante.avaliacaoPsicologica.AvaliacaoPsicologicaServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/praticante/avaliacao-psicologica")
public class AvaliacaoPsicologicaControlador {

    @Autowired
    private AvaliacaoPsicologicaServico avaliacaoPsicologicaServico;
    @PostMapping("/salvar-avaliacao-psicologica-do-praticante")
    public ResponseEntity<?> salvarAvaliacaoPsicologica(@RequestBody AvaliacaoPsicologicaEntradaDTO avaliacaoPsicologicaEntradaDTO) {
        AvaliacaoPsicologica avaliacaoPsicologica = PraticanteMapeador.converterAvaliacaoPsicologicaEntradaDTOEmAvaliacaoPsicologica(avaliacaoPsicologicaEntradaDTO);
        avaliacaoPsicologicaServico.salvarAvaliacaoPsicologica(avaliacaoPsicologica);
        return new ResponseEntity<>(new Mensagem("AvaliacaoPsicologica do praticante cadastrada com sucesso!"), HttpStatus.CREATED);
    }

    @PutMapping("/atualizar-avaliacao-psicologica-do-praticante")
    public ResponseEntity<?> atualizarAvaliacaoPsicologica(@RequestBody AvaliacaoPsicologicaEntradaDTO avaliacaoPsicologicaEntradaDTO) {
        AvaliacaoPsicologica avaliacaoPsicologica = PraticanteMapeador.converterAvaliacaoPsicologicaEntradaDTOEmAvaliacaoPsicologica(avaliacaoPsicologicaEntradaDTO);
        avaliacaoPsicologicaServico.atualizarAvaliacaoPsicologica(avaliacaoPsicologica);
        return new ResponseEntity<>(new Mensagem("AvaliacaoPsicologica do praticante atualizada com sucesso!"), HttpStatus.CREATED);
    }

    @GetMapping("/buscar-avaliacao-psicologica-do-praticante-por-id")
    public ResponseEntity<?> buscarAvaliacaoPsicologicaPorId(@RequestParam("id") Long id) {
        return new ResponseEntity<>(PraticanteMapeador.converterAvaliacaoPsicologicaEmAvaliacaoPsicologicaSaidaDTO(avaliacaoPsicologicaServico.buscarAvaliacaoPsicologicaPorId(id)), HttpStatus.OK);
    }
}
