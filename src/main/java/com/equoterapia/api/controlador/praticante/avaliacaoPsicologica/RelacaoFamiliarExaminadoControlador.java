package com.equoterapia.api.controlador.praticante.avaliacaoPsicologica;

import com.equoterapia.api.controlador.utilidades.Mensagem;
import com.equoterapia.api.dto.praticante.avaliacaoPsicologica.RelacaoFamiliarExaminadoEntradaDTO;
import com.equoterapia.api.mapeador.praticante.PraticanteMapeador;
import com.equoterapia.dominio.modelo.praticante.avaliacaoPsicologica.RelacaoFamiliarExaminado;
import com.equoterapia.dominio.servico.praticante.avaliacaoPsicologica.RelacaoFamiliarExaminadoServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/praticante/relacao-familiar-examinado")
public class RelacaoFamiliarExaminadoControlador {

    @Autowired
    private RelacaoFamiliarExaminadoServico relacaoFamiliarExaminadoServico;
    @PostMapping("/salvar-relacao-familiar-examinado-do-praticante")
    public ResponseEntity<?> salvarRelacaoFamiliarExaminado(@RequestBody RelacaoFamiliarExaminadoEntradaDTO relacaoFamiliarExaminadoEntradaDTO) {
        RelacaoFamiliarExaminado relacaoFamiliarExaminado = PraticanteMapeador.converterRelacaoFamiliarExaminadoEntradaDTOEmRelacaoFamiliarExaminado(relacaoFamiliarExaminadoEntradaDTO);
        relacaoFamiliarExaminadoServico.salvarRelacaoFamiliarExaminado(relacaoFamiliarExaminado);
        return new ResponseEntity<>(new Mensagem("RelacaoFamiliarExaminado do praticante cadastrada com sucesso!"), HttpStatus.CREATED);
    }

    @PutMapping("/atualizar-relacao-familiar-examinado-do-praticante")
    public ResponseEntity<?> atualizarRelacaoFamiliarExaminado(@RequestBody RelacaoFamiliarExaminadoEntradaDTO relacaoFamiliarExaminadoEntradaDTO) {
        RelacaoFamiliarExaminado relacaoFamiliarExaminado = PraticanteMapeador.converterRelacaoFamiliarExaminadoEntradaDTOEmRelacaoFamiliarExaminado(relacaoFamiliarExaminadoEntradaDTO);
        relacaoFamiliarExaminadoServico.atualizarRelacaoFamiliarExaminado(relacaoFamiliarExaminado);
        return new ResponseEntity<>(new Mensagem("RelacaoFamiliarExaminado do praticante atualizada com sucesso!"), HttpStatus.CREATED);
    }

    @GetMapping("/buscar-relacao-familiar-examinado-do-praticante-por-id")
    public ResponseEntity<?> buscarRelacaoFamiliarExaminadoPorId(@RequestParam("id") Long id) {
        return new ResponseEntity<>(PraticanteMapeador.converterRelacaoFamiliarExaminadoEmRelacaoFamiliarExaminadoSaidaDTO(relacaoFamiliarExaminadoServico.buscarRelacaoFamiliarExaminadoPorId(id)), HttpStatus.OK);
    }
}
