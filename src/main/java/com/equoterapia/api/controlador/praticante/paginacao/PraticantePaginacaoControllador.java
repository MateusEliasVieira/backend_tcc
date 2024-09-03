package com.equoterapia.api.controlador.praticante.paginacao;

import com.equoterapia.api.dto.praticante.paginacao.PraticantePaginacaoDTO;
import com.equoterapia.dominio.servico.praticante.paginacao.PraticantePaginacaoServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/praticante/paginacao")
public class PraticantePaginacaoControllador {

    @Autowired
    private PraticantePaginacaoServico servico;

    @GetMapping("/buscar-pagina")
    public ResponseEntity<?> buscarPagina(@RequestParam("pagina") int pagina) {
        return ResponseEntity.ok(servico.buscarPraticantesPorPaginas(pagina));
    }

    @GetMapping("/buscar-quantidade-total-de-praticantes-e-paginas")
    public ResponseEntity<PraticantePaginacaoDTO> buscarQuantidadeTotalDePraticantes() {
        return ResponseEntity.ok(servico.quantidadeTotalDePraticantes());
    }
}

