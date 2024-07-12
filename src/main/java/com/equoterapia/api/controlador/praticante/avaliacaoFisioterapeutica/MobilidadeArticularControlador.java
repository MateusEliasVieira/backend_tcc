package com.equoterapia.api.controlador.praticante.avaliacaoFisioterapeutica;

import com.equoterapia.api.controlador.utilidades.Mensagem;
import com.equoterapia.api.dto.praticante.avaliacaoFisioterapeutica.MobilidadeArticularEntradaDTO;
import com.equoterapia.api.mapeador.praticante.PraticanteMapeador;
import com.equoterapia.dominio.modelo.praticante.avaliacaoFisioterapeutica.MobilidadeArticular;
import com.equoterapia.dominio.servico.praticante.avaliacaoFisioterapeutica.MobilidadeArticularServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("praticante/mobilidade-articular")
public class MobilidadeArticularControlador {
    @Autowired
    private MobilidadeArticularServico mobilidadeArticularServico;

    @PostMapping("/salvar-mobilidade-articular-do-praticante")
    public ResponseEntity<?> salvarMobilidadeArticular(@RequestBody MobilidadeArticularEntradaDTO mobilidadeArticularServicoEntradaDTO) {
        MobilidadeArticular mobilidadeArticular = PraticanteMapeador.converterMobilidadeArticularEntradaDTOEmMobilidadeArticular(mobilidadeArticularServicoEntradaDTO);
        mobilidadeArticularServico.salvarMobilidadeArticular(mobilidadeArticular);
        return new ResponseEntity<>(new Mensagem("Mobilidade articular do praticante cadastrada com sucesso!"), HttpStatus.CREATED);
    }

    @PutMapping("/atualizar-mobilidade-articular-do-praticante")
    public ResponseEntity<?> atualizarMobilidadeArticular(@RequestBody MobilidadeArticularEntradaDTO mobilidadeArticularServicoEntradaDTO) {
        MobilidadeArticular mobilidadeArticular = PraticanteMapeador.converterMobilidadeArticularEntradaDTOEmMobilidadeArticular(mobilidadeArticularServicoEntradaDTO);
        mobilidadeArticularServico.atualizarMobilidadeArticular(mobilidadeArticular);
        return new ResponseEntity<>(new Mensagem("Mobilidade articular do praticante atualizada com sucesso!"), HttpStatus.CREATED);
    }

    @GetMapping("/buscar-mobilidade-articular-do-praticante-por-id")
    public ResponseEntity<?> buscarMobilidadeArticularPorId(@RequestParam("id") Long id) {
        return new ResponseEntity<>(PraticanteMapeador.converterMobilidadeArticularEmMobilidadeArticularSaidaDTO(mobilidadeArticularServico.buscarMobilidadeArticularPorId(id)), HttpStatus.OK);
    }
}
