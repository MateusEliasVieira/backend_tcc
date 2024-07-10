package com.equoterapia.api.controlador.praticante.avaliacaoFisioterapeutica;

import com.equoterapia.api.controlador.utilidades.Mensagem;
import com.equoterapia.api.dto.praticante.avaliacaoFisioterapeutica.EquilibrioDinamicoEntradaDTO;
import com.equoterapia.api.mapeador.praticante.PraticanteMapeador;
import com.equoterapia.dominio.modelo.praticante.avaliacaoFisioterapeutica.EquilibrioDinamico;
import com.equoterapia.dominio.servico.praticante.avaliacaoFisioterapeutica.EquilibrioDinamicoServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("praticante/equilibrio-dinamico")
public class EquilibrioDinamicoControlador {
    @Autowired
    private EquilibrioDinamicoServico equilibrioDinamicoServicoServico;

    @PostMapping("/salvar-equilibrio-dinamico-do-praticante")
    public ResponseEntity<?> salvarEquilibrioDinamico(@RequestBody EquilibrioDinamicoEntradaDTO equilibrioDinamicoServicoEntradaDTO) {
        EquilibrioDinamico equilibrioDinamicoServico = PraticanteMapeador.converterEquilibrioDinamicoEntradaDTOEmEquilibrioDinamico(equilibrioDinamicoServicoEntradaDTO);
        equilibrioDinamicoServicoServico.salvarEquilibrioDinamico(equilibrioDinamicoServico);
        return new ResponseEntity<>(new Mensagem("Equilibrio dinamico do praticante cadastrada com sucesso!"), HttpStatus.CREATED);
    }

    @PutMapping("/atualizar-equilibrio-dinamico-do-praticante")
    public ResponseEntity<?> atualizarEquilibrioDinamico(@RequestBody EquilibrioDinamicoEntradaDTO equilibrioDinamicoServicoEntradaDTO) {
        EquilibrioDinamico equilibrioDinamicoServico = PraticanteMapeador.converterEquilibrioDinamicoEntradaDTOEmEquilibrioDinamico(equilibrioDinamicoServicoEntradaDTO);
        equilibrioDinamicoServicoServico.atualizarEquilibrioDinamico(equilibrioDinamicoServico);
        return new ResponseEntity<>(new Mensagem("Equilibrio dinamico do praticante atualizada com sucesso!"), HttpStatus.CREATED);
    }

    @GetMapping("/buscar-equilibrio-dinamico-do-praticante-por-id")
    public ResponseEntity<?> buscarEquilibrioDinamicoPorId(@RequestParam("id") Long id) {
        return new ResponseEntity<>(PraticanteMapeador.converterEquilibrioDinamicoEmEquilibrioDinamicoSaidaDTO(equilibrioDinamicoServicoServico.buscarEquilibrioDinamicoPorId(id)), HttpStatus.OK);
    }
}
