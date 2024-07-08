package com.equoterapia.api.controlador.praticante.avaliacaoPsicologica;

import com.equoterapia.api.controlador.utilidades.Mensagem;
import com.equoterapia.api.dto.praticante.avaliacaoPsicologica.SaudeEntradaDTO;
import com.equoterapia.api.mapeador.praticante.PraticanteMapeador;
import com.equoterapia.dominio.modelo.praticante.avaliacaoPsicologica.Saude;
import com.equoterapia.dominio.servico.praticante.avaliacaoPsicologica.SaudeServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/praticante/saude")
public class SaudeControlador {

    @Autowired
    private SaudeServico saudeServico;

    @PostMapping("/salvar-saude-do-praticante")
    public ResponseEntity<?> salvarSaude(@RequestBody SaudeEntradaDTO saudeEntradaDTO) {
        Saude saude = PraticanteMapeador.converterSaudeEntradaDTOEmSaude(saudeEntradaDTO);
        saudeServico.salvarSaude(saude);
        return new ResponseEntity<>(new Mensagem("Dados sobre a saúde do praticante cadastrada com sucesso!"), HttpStatus.CREATED);
    }

    @PutMapping("/atualizar-saude-do-praticante")
    public ResponseEntity<?> atualizarSaude(@RequestBody SaudeEntradaDTO saudeEntradaDTO) {
        Saude saude = PraticanteMapeador.converterSaudeEntradaDTOEmSaude(saudeEntradaDTO);
        saudeServico.atualizarSaude(saude);
        return new ResponseEntity<>(new Mensagem("Dados sobre a saúde do praticante atualizada com sucesso!"), HttpStatus.CREATED);
    }

    @GetMapping("/buscar-saude-do-praticante-por-id")
    public ResponseEntity<?> buscarSaudePorId(@RequestParam("id") Long id) {
        return new ResponseEntity<>(PraticanteMapeador.converterSaudeEmSaudeSaidaDTO(saudeServico.buscarSaudePorId(id)), HttpStatus.OK);
    }
}
