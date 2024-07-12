package com.equoterapia.api.controlador.praticante.avaliacaoFisioterapeutica;

import com.equoterapia.api.controlador.utilidades.Mensagem;
import com.equoterapia.api.dto.praticante.avaliacaoFisioterapeutica.GruposMuscularesEntradaDTO;
import com.equoterapia.api.mapeador.praticante.PraticanteMapeador;
import com.equoterapia.dominio.modelo.praticante.avaliacaoFisioterapeutica.GruposMusculares;
import com.equoterapia.dominio.servico.praticante.avaliacaoFisioterapeutica.GruposMuscularesServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("praticante/grupos-musculares")
public class GruposMuscularesControlador {
    @Autowired
    private GruposMuscularesServico gruposMuscularesServico;

    @PostMapping("/salvar-grupos-musculares-do-praticante")
    public ResponseEntity<?> salvarGruposMusculares(@RequestBody GruposMuscularesEntradaDTO gruposMuscularesServicoEntradaDTO) {
        GruposMusculares gruposMusculares = PraticanteMapeador.converterGruposMuscularesEntradaDTOEmGruposMusculares(gruposMuscularesServicoEntradaDTO);
        gruposMuscularesServico.salvarGruposMusculares(gruposMusculares);
        return new ResponseEntity<>(new Mensagem("GruposMusculares do praticante cadastrada com sucesso!"), HttpStatus.CREATED);
    }

    @PutMapping("/atualizar-grupos-musculares-do-praticante")
    public ResponseEntity<?> atualizarGruposMusculares(@RequestBody GruposMuscularesEntradaDTO gruposMuscularesServicoEntradaDTO) {
        GruposMusculares gruposMusculares = PraticanteMapeador.converterGruposMuscularesEntradaDTOEmGruposMusculares(gruposMuscularesServicoEntradaDTO);
        gruposMuscularesServico.atualizarGruposMusculares(gruposMusculares);
        return new ResponseEntity<>(new Mensagem("GruposMusculares do praticante atualizada com sucesso!"), HttpStatus.CREATED);
    }

    @GetMapping("/buscar-grupos-musculares-do-praticante-por-id")
    public ResponseEntity<?> buscarGruposMuscularesPorId(@RequestParam("id") Long id) {
        return new ResponseEntity<>(PraticanteMapeador.converterGruposMuscularesEmGruposMuscularesSaidaDTO(gruposMuscularesServico.buscarGruposMuscularesPorId(id)), HttpStatus.OK);
    }
}
