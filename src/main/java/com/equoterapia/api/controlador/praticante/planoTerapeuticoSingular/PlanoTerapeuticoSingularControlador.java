package com.equoterapia.api.controlador.praticante.planoTerapeuticoSingular;

import com.equoterapia.api.dto.praticante.planoTerapeuticoSingular.PlanoTerapeuticoSingularEntradaDTO;
import com.equoterapia.api.dto.praticante.planoTerapeuticoSingular.PlanoTerapeuticoSingularSaidaDTO;
import com.equoterapia.api.mapeador.praticante.PraticanteMapeador;
import com.equoterapia.dominio.modelo.praticante.planoTerapeuticoSingular.PlanoTerapeuticoSingular;
import com.equoterapia.dominio.servico.praticante.planoTerapeuticoSingular.PlanoTerapeuticoSingularServico;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/praticante/plano-terapeutico-singular")
public class PlanoTerapeuticoSingularControlador {

    @Autowired
    private PlanoTerapeuticoSingularServico planoTerapeuticoSingularServico;

    @PostMapping("/salvar-plano-terapeutico-singular-do-praticante")
    public ResponseEntity<?> salvarPlanoTerapeuticoSingular(@RequestBody @Valid PlanoTerapeuticoSingularEntradaDTO planoTerapeuticoSingularEntradaDTO) {
        PlanoTerapeuticoSingular planoTerapeuticoSingular = PraticanteMapeador.converterPlanoTerapeuticoSingularEntradaDTOEmPlanoTerapeuticoSingular(planoTerapeuticoSingularEntradaDTO);
        PlanoTerapeuticoSingularSaidaDTO planoTerapeuticoSingularSaidaDTO = PraticanteMapeador.converterPlanoTerapeuticoSingularEmPlanoTerapeuticoSingularSaidaDTO(planoTerapeuticoSingularServico.salvarPlanoTerapeuticoSingular(planoTerapeuticoSingular));
        return new ResponseEntity<PlanoTerapeuticoSingularSaidaDTO>(planoTerapeuticoSingularSaidaDTO, HttpStatus.CREATED);
    }

    @PutMapping("/atualizar-plano-terapeutico-singular-do-praticante")
    public ResponseEntity<?> atualizarPlanoTerapeuticoSingular(@RequestBody @Valid PlanoTerapeuticoSingularEntradaDTO planoTerapeuticoSingularEntradaDTO) {
        PlanoTerapeuticoSingular planoTerapeuticoSingular = PraticanteMapeador.converterPlanoTerapeuticoSingularEntradaDTOEmPlanoTerapeuticoSingular(planoTerapeuticoSingularEntradaDTO);
        PlanoTerapeuticoSingularSaidaDTO planoTerapeuticoSingularSaidaDTO = PraticanteMapeador.converterPlanoTerapeuticoSingularEmPlanoTerapeuticoSingularSaidaDTO(planoTerapeuticoSingularServico.atualizarPlanoTerapeuticoSingular(planoTerapeuticoSingular));
        return new ResponseEntity<PlanoTerapeuticoSingularSaidaDTO>(planoTerapeuticoSingularSaidaDTO, HttpStatus.CREATED);
    }

    @GetMapping("/buscar-plano-terapeutico-singular-do-praticante-por-id")
    public ResponseEntity<?> buscarPlanoTerapeuticoSingular(@RequestParam("id") Long id) {
        PlanoTerapeuticoSingular planoTerapeuticoSingular = planoTerapeuticoSingularServico.buscarPlanoTerapeuticoSingular(id);
        PlanoTerapeuticoSingularSaidaDTO planoTerapeuticoSingularSaidaDTO = PraticanteMapeador.converterPlanoTerapeuticoSingularEmPlanoTerapeuticoSingularSaidaDTO(planoTerapeuticoSingular);
        return new ResponseEntity<PlanoTerapeuticoSingularSaidaDTO>(planoTerapeuticoSingularSaidaDTO, HttpStatus.OK);
    }

}
