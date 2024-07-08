package com.equoterapia.api.controlador.praticante.avaliacaoPsicologica;

import com.equoterapia.api.controlador.utilidades.Mensagem;
import com.equoterapia.api.dto.praticante.avaliacaoPsicologica.SobreACriancaEntradaDTO;
import com.equoterapia.api.mapeador.praticante.PraticanteMapeador;
import com.equoterapia.dominio.modelo.praticante.avaliacaoPsicologica.SobreACrianca;
import com.equoterapia.dominio.servico.praticante.avaliacaoPsicologica.SobreACriancaServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/praticante/sobre-a-crianca")
public class SobreACriancaControlador {

    @Autowired
    private SobreACriancaServico sobreACriancaServico;

    @PostMapping("/salvar-sobre-a-crianca-do-praticante")
    public ResponseEntity<?> salvarSobreACrianca(@RequestBody SobreACriancaEntradaDTO sobreACriancaEntradaDTO) {
        SobreACrianca sobreACrianca = PraticanteMapeador.converterSobreACriancaEntradaDTOEmSobreACrianca(sobreACriancaEntradaDTO);
        sobreACriancaServico.salvarSobreACrianca(sobreACrianca);
        return new ResponseEntity<>(new Mensagem("Dados sobre a criança/praticante cadastrada com sucesso!"), HttpStatus.CREATED);
    }

    @PutMapping("/atualizar-sobre-a-crianca-do-praticante")
    public ResponseEntity<?> atualizarSobreACrianca(@RequestBody SobreACriancaEntradaDTO sobreACriancaEntradaDTO) {
        SobreACrianca sobreACrianca = PraticanteMapeador.converterSobreACriancaEntradaDTOEmSobreACrianca(sobreACriancaEntradaDTO);
        sobreACriancaServico.atualizarSobreACrianca(sobreACrianca);
        return new ResponseEntity<>(new Mensagem("Dados sobre a criança/praticante atualizada com sucesso!"), HttpStatus.CREATED);
    }

    @GetMapping("/buscar-sobre-a-crianca-do-praticante-por-id")
    public ResponseEntity<?> buscarSobreACriancaPorId(@RequestParam("id") Long id) {
        return new ResponseEntity<>(PraticanteMapeador.converterSobreACriancaEmSobreACriancaSaidaDTO(sobreACriancaServico.buscarSobreACriancaPorId(id)), HttpStatus.OK);
    }
}
