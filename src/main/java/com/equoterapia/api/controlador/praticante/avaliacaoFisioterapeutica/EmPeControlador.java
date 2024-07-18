package com.equoterapia.api.controlador.praticante.avaliacaoFisioterapeutica;

import com.equoterapia.api.controlador.utilidades.Mensagem;
import com.equoterapia.api.dto.praticante.avaliacaoFisioterapeutica.EmPeEntradaDTO;
import com.equoterapia.api.mapeador.praticante.PraticanteMapeador;
import com.equoterapia.dominio.modelo.praticante.avaliacaoFisioterapeutica.EmPe;
import com.equoterapia.dominio.servico.praticante.avaliacaoFisioterapeutica.EmPeServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("praticante/em-pe")
public class EmPeControlador {
    @Autowired
    private EmPeServico emPeServico;

    @PostMapping("/salvar-em-pe-do-praticante")
    public ResponseEntity<?> salvarEmPe(@RequestBody EmPeEntradaDTO emPeEntradaDTO) {
        EmPe emPe = PraticanteMapeador.converterEmPeEntradaDTOParaEmPe(emPeEntradaDTO);
        emPeServico.salvarEmPe(emPe);
        return new ResponseEntity<>(new Mensagem("Em pé do praticante cadastrada com sucesso!"), HttpStatus.CREATED);
    }

    @PutMapping("/atualizar-em-pe-do-praticante")
    public ResponseEntity<?> atualizarEmPe(@RequestBody EmPeEntradaDTO equilibrioDinamicoServicoEntradaDTO) {
        EmPe equilibrioDinamicoServico = PraticanteMapeador.converterEmPeEntradaDTOParaEmPe(equilibrioDinamicoServicoEntradaDTO);
        emPeServico.atualizarEmPe(equilibrioDinamicoServico);
        return new ResponseEntity<>(new Mensagem("Em pé do praticante atualizada com sucesso!"), HttpStatus.CREATED);
    }

    @GetMapping("/buscar-em-pe-do-praticante-por-id")
    public ResponseEntity<?> buscarEmPePorId(@RequestParam("id") Long id) {
        return new ResponseEntity<>(PraticanteMapeador.converterEmPeParaEmPeSaidaDTO(emPeServico.buscarEmPePorId(id)), HttpStatus.OK);
    }
}
