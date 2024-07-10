package com.equoterapia.api.controlador.praticante.avaliacaoFisioterapeutica;

import com.equoterapia.api.controlador.utilidades.Mensagem;
import com.equoterapia.api.dto.praticante.avaliacaoFisioterapeutica.EquilibrioEstaticoEntradaDTO;
import com.equoterapia.api.mapeador.praticante.PraticanteMapeador;
import com.equoterapia.dominio.modelo.praticante.avaliacaoFisioterapeutica.EquilibrioEstatico;
import com.equoterapia.dominio.servico.praticante.avaliacaoFisioterapeutica.EquilibrioEstaticoServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("praticante/equilibrio-estatico")
public class EquilibrioEstaticoControlador {
    @Autowired
    private EquilibrioEstaticoServico equilibrioEstaticoServicoServico;

    @PostMapping("/salvar-equilibrio-estatico-do-praticante")
    public ResponseEntity<?> salvarEquilibrioEstatico(@RequestBody EquilibrioEstaticoEntradaDTO equilibrioEstaticoServicoEntradaDTO) {
        EquilibrioEstatico equilibrioEstaticoServico = PraticanteMapeador.converterEquilibrioEstaticoEntradaDTOEmEquilibrioEstatico(equilibrioEstaticoServicoEntradaDTO);
        equilibrioEstaticoServicoServico.salvarEquilibrioEstatico(equilibrioEstaticoServico);
        return new ResponseEntity<>(new Mensagem("Equilibrio estático do praticante cadastrada com sucesso!"), HttpStatus.CREATED);
    }

    @PutMapping("/atualizar-equilibrio-estatico-do-praticante")
    public ResponseEntity<?> atualizarEquilibrioEstatico(@RequestBody EquilibrioEstaticoEntradaDTO equilibrioEstaticoServicoEntradaDTO) {
        EquilibrioEstatico equilibrioEstaticoServico = PraticanteMapeador.converterEquilibrioEstaticoEntradaDTOEmEquilibrioEstatico(equilibrioEstaticoServicoEntradaDTO);
        equilibrioEstaticoServicoServico.atualizarEquilibrioEstatico(equilibrioEstaticoServico);
        return new ResponseEntity<>(new Mensagem("Equilibrio estático do praticante atualizada com sucesso!"), HttpStatus.CREATED);
    }

    @GetMapping("/buscar-equilibrio-estatico-do-praticante-por-id")
    public ResponseEntity<?> buscarEquilibrioEstaticoPorId(@RequestParam("id") Long id) {
        return new ResponseEntity<>(PraticanteMapeador.converterEquilibrioEstaticoEmEquilibrioEstaticoSaidaDTO(equilibrioEstaticoServicoServico.buscarEquilibrioEstaticoPorId(id)), HttpStatus.OK);
    }
}
