package com.equoterapia.api.controlador.praticante.avaliacaoFisioterapeutica;

import com.equoterapia.api.controlador.utilidades.Mensagem;
import com.equoterapia.api.dto.praticante.avaliacaoFisioterapeutica.CoordenacaoMotoraEntradaDTO;
import com.equoterapia.api.mapeador.praticante.PraticanteMapeador;
import com.equoterapia.dominio.modelo.praticante.avaliacaoFisioterapeutica.CoordenacaoMotora;
import com.equoterapia.dominio.servico.praticante.avaliacaoFisioterapeutica.CoordenacaoMotoraServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("praticante/coordenacao-motora")
public class CoordenacaoMotoraControlador {
    @Autowired
    private CoordenacaoMotoraServico coordenacaoMotoraServicoServico;

    @PostMapping("/salvar-coordenacao-motora-do-praticante")
    public ResponseEntity<?> salvarCoordenacaoMotora(@RequestBody CoordenacaoMotoraEntradaDTO coordenacaoMotoraServicoEntradaDTO) {
        CoordenacaoMotora coordenacaoMotoraServico = PraticanteMapeador.converterCoordenacaoMotoraEntradaDTOEmCoordenacaoMotora(coordenacaoMotoraServicoEntradaDTO);
        coordenacaoMotoraServicoServico.salvarCoordenacaoMotora(coordenacaoMotoraServico);
        return new ResponseEntity<>(new Mensagem("Coordenação motora do praticante cadastrada com sucesso!"), HttpStatus.CREATED);
    }

    @PutMapping("/atualizar-coordenacao-motora-do-praticante")
    public ResponseEntity<?> atualizarCoordenacaoMotora(@RequestBody CoordenacaoMotoraEntradaDTO coordenacaoMotoraServicoEntradaDTO) {
        CoordenacaoMotora coordenacaoMotoraServico = PraticanteMapeador.converterCoordenacaoMotoraEntradaDTOEmCoordenacaoMotora(coordenacaoMotoraServicoEntradaDTO);
        coordenacaoMotoraServicoServico.atualizarCoordenacaoMotora(coordenacaoMotoraServico);
        return new ResponseEntity<>(new Mensagem("Coordenação motora do praticante atualizada com sucesso!"), HttpStatus.CREATED);
    }

    @GetMapping("/buscar-coordenacao-motora-do-praticante-por-id")
    public ResponseEntity<?> buscarCoordenacaoMotoraPorId(@RequestParam("id") Long id) {
        return new ResponseEntity<>(PraticanteMapeador.converterCoordenacaoMotoraEmCoordenacaoMotoraSaidaDTO(coordenacaoMotoraServicoServico.buscarCoordenacaoMotoraPorId(id)), HttpStatus.OK);
    }
}
