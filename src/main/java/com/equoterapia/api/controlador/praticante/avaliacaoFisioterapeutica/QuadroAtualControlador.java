package com.equoterapia.api.controlador.praticante.avaliacaoFisioterapeutica;

import com.equoterapia.api.controlador.utilidades.Mensagem;
import com.equoterapia.api.dto.praticante.avaliacaoFisioterapeutica.QuadroAtualEntradaDTO;
import com.equoterapia.api.mapeador.praticante.PraticanteMapeador;
import com.equoterapia.dominio.modelo.praticante.avaliacaoFisioterapeutica.QuadroAtual;
import com.equoterapia.dominio.servico.praticante.avaliacaoFisioterapeutica.QuadroAtualServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("praticante/quadro-atual")
public class QuadroAtualControlador {
    @Autowired
    private QuadroAtualServico quadroAtualServico;

    @PostMapping("/salvar-quadro-atual-do-praticante")
    public ResponseEntity<?> salvarQuadroAtual(@RequestBody QuadroAtualEntradaDTO quadroAtualServicoEntradaDTO) {
        QuadroAtual quadroAtual = PraticanteMapeador.converterQuadroAtualEntradaDTOEmQuadroAtual(quadroAtualServicoEntradaDTO);
        quadroAtualServico.salvarQuadroAtual(quadroAtual);
        return new ResponseEntity<>(new Mensagem("Quadro atual do praticante cadastrada com sucesso!"), HttpStatus.CREATED);
    }

    @PutMapping("/atualizar-quadro-atual-do-praticante")
    public ResponseEntity<?> atualizarQuadroAtual(@RequestBody QuadroAtualEntradaDTO quadroAtualServicoEntradaDTO) {
        QuadroAtual quadroAtual = PraticanteMapeador.converterQuadroAtualEntradaDTOEmQuadroAtual(quadroAtualServicoEntradaDTO);
        quadroAtualServico.atualizarQuadroAtual(quadroAtual);
        return new ResponseEntity<>(new Mensagem("Quadro atual do praticante atualizada com sucesso!"), HttpStatus.CREATED);
    }

    @GetMapping("/buscar-quadro-atual-do-praticante-por-id")
    public ResponseEntity<?> buscarQuadroAtualPorId(@RequestParam("id") Long id) {
        return new ResponseEntity<>(PraticanteMapeador.converterQuadroAtualEmQuadroAtualSaidaDTO(quadroAtualServico.buscarQuadroAtualPorId(id)), HttpStatus.OK);
    }
}
