package com.equoterapia.api.controlador.praticante.avaliacaoPsicologica;

import com.equoterapia.api.controlador.utilidades.Mensagem;
import com.equoterapia.api.dto.praticante.avaliacaoPsicologica.SaudeMentalEntradaDTO;
import com.equoterapia.api.mapeador.praticante.PraticanteMapeador;
import com.equoterapia.dominio.modelo.praticante.avaliacaoPsicologica.SaudeMental;
import com.equoterapia.dominio.servico.praticante.avaliacaoPsicologica.SaudeMentalServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/praticante/saude-mental")
public class SaudeMentalControlador {

    @Autowired
    private SaudeMentalServico saudeMentalServico;
    @PostMapping("/salvar-saude-mental-do-praticante")
    public ResponseEntity<?> salvarSaudeMental(@RequestBody SaudeMentalEntradaDTO saudeMentalEntradaDTO) {
        SaudeMental saudeMental = PraticanteMapeador.converterSaudeMentalEntradaDTOEmSaudeMental(saudeMentalEntradaDTO);
        saudeMentalServico.salvarSaudeMental(saudeMental);
        return new ResponseEntity<>(new Mensagem("Saúde mental do praticante cadastrada com sucesso!"), HttpStatus.CREATED);
    }

    @PutMapping("/atualizar-saude-mental-do-praticante")
    public ResponseEntity<?> atualizarSaudeMental(@RequestBody SaudeMentalEntradaDTO saudeMentalEntradaDTO) {
        SaudeMental saudeMental = PraticanteMapeador.converterSaudeMentalEntradaDTOEmSaudeMental(saudeMentalEntradaDTO);
        saudeMentalServico.atualizarSaudeMental(saudeMental);
        return new ResponseEntity<>(new Mensagem("SaudeMental do praticante atualizada com sucesso!"), HttpStatus.CREATED);
    }

    @GetMapping("/buscar-saude-mental-do-praticante-por-id")
    public ResponseEntity<?> buscarSaudeMentalPorId(@RequestParam("id") Long id) {
        return new ResponseEntity<>(PraticanteMapeador.converterSaudeMentalEmSaudeMentalSaidaDTO(saudeMentalServico.buscarSaudeMentalPorId(id)), HttpStatus.OK);
    }
}
