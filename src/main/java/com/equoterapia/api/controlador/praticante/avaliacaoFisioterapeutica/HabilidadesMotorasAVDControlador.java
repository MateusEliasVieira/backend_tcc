package com.equoterapia.api.controlador.praticante.avaliacaoFisioterapeutica;

import com.equoterapia.api.controlador.utilidades.Mensagem;
import com.equoterapia.api.dto.praticante.avaliacaoFisioterapeutica.HabilidadesMotorasAVDEntradaDTO;
import com.equoterapia.api.mapeador.praticante.PraticanteMapeador;
import com.equoterapia.dominio.modelo.praticante.avaliacaoFisioterapeutica.HabilidadesMotorasAVD;
import com.equoterapia.dominio.servico.praticante.avaliacaoFisioterapeutica.HabilidadesMotorasAVDServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("praticante/habilidades-motoras-avd")
public class HabilidadesMotorasAVDControlador {
    @Autowired
    private HabilidadesMotorasAVDServico habilidadesMotorasAVDServico;

    @PostMapping("/salvar-habilidades-motoras-avd-do-praticante")
    public ResponseEntity<?> salvarHabilidadesMotorasAVD(@RequestBody HabilidadesMotorasAVDEntradaDTO habilidadesMotorasAVDEntradaDTO) {
        HabilidadesMotorasAVD habilidadesMotorasAVD = PraticanteMapeador.converterHabilidadesMotorasAVDEntradaDTOEmHabilidadesMotorasAVD(habilidadesMotorasAVDEntradaDTO);
        habilidadesMotorasAVDServico.salvarHabilidadesMotorasAVD(habilidadesMotorasAVD);
        return new ResponseEntity<>(new Mensagem("Habilidades motoras AVD do praticante cadastrada com sucesso!"), HttpStatus.CREATED);
    }

    @PutMapping("/atualizar-habilidades-motoras-avd-do-praticante")
    public ResponseEntity<?> atualizarHabilidadesMotorasAVD(@RequestBody HabilidadesMotorasAVDEntradaDTO habilidadesMotorasAVDEntradaDTO) {
        HabilidadesMotorasAVD habilidadesMotorasAVD = PraticanteMapeador.converterHabilidadesMotorasAVDEntradaDTOEmHabilidadesMotorasAVD(habilidadesMotorasAVDEntradaDTO);
        habilidadesMotorasAVDServico.atualizarHabilidadesMotorasAVD(habilidadesMotorasAVD);
        return new ResponseEntity<>(new Mensagem("Habilidades motoras AVD do praticante atualizada com sucesso!"), HttpStatus.CREATED);
    }

    @GetMapping("/buscar-habilidades-motoras-avd-do-praticante-por-id")
    public ResponseEntity<?> buscarHabilidadesMotorasAVDPorId(@RequestParam("id") Long id) {
        return new ResponseEntity<>(PraticanteMapeador.converterHabilidadesMotorasAVDEmHabilidadesMotorasAVDSaidaDTO(habilidadesMotorasAVDServico.buscarHabilidadesMotorasAVDPorId(id)), HttpStatus.OK);
    }
}
