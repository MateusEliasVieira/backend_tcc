package com.equoterapia.api.controlador.praticante.avaliacaoPsicologica;

import com.equoterapia.api.controlador.utilidades.Mensagem;
import com.equoterapia.api.dto.praticante.avaliacaoPsicologica.HabilidadesSociaisEntradaDTO;
import com.equoterapia.api.mapeador.praticante.PraticanteMapeador;
import com.equoterapia.dominio.modelo.praticante.avaliacaoPsicologica.HabilidadesSociais;
import com.equoterapia.dominio.servico.praticante.avaliacaoPsicologica.HabilidadesSociaisServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/praticante/habilidades-sociais")
public class HabilidadesSociaisControlador {

    @Autowired
    private HabilidadesSociaisServico avaliacaoPsicologicaServico;
    @PostMapping("/salvar-habilidades-sociais-do-praticante")
    public ResponseEntity<?> salvarHabilidadesSociais(@RequestBody HabilidadesSociaisEntradaDTO avaliacaoPsicologicaEntradaDTO) {
        HabilidadesSociais avaliacaoPsicologica = PraticanteMapeador.converterHabilidadesSociaisEntradaDTOEmHabilidadesSociais(avaliacaoPsicologicaEntradaDTO);
        avaliacaoPsicologicaServico.salvarHabilidadesSociais(avaliacaoPsicologica);
        return new ResponseEntity<>(new Mensagem("Habilidades sociais do praticante cadastrada com sucesso!"), HttpStatus.CREATED);
    }

    @PutMapping("/atualizar-habilidades-sociais-do-praticante")
    public ResponseEntity<?> atualizarHabilidadesSociais(@RequestBody HabilidadesSociaisEntradaDTO avaliacaoPsicologicaEntradaDTO) {
        HabilidadesSociais avaliacaoPsicologica = PraticanteMapeador.converterHabilidadesSociaisEntradaDTOEmHabilidadesSociais(avaliacaoPsicologicaEntradaDTO);
        avaliacaoPsicologicaServico.atualizarHabilidadesSociais(avaliacaoPsicologica);
        return new ResponseEntity<>(new Mensagem("Habilidades sociais do praticante atualizada com sucesso!"), HttpStatus.CREATED);
    }

    @GetMapping("/buscar-habilidades-sociais-do-praticante-por-id")
    public ResponseEntity<?> buscarHabilidadesSociaisPorId(@RequestParam("id") Long id) {
        return new ResponseEntity<>(PraticanteMapeador.converterHabilidadesSociaisEmHabilidadesSociaisSaidaDTO(avaliacaoPsicologicaServico.buscarHabilidadesSociaisPorId(id)), HttpStatus.OK);
    }
}
