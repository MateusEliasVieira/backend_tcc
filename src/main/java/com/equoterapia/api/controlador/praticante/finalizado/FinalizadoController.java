package com.equoterapia.api.controlador.praticante.finalizado;

import com.equoterapia.api.controlador.utilidades.Mensagem;
import com.equoterapia.api.dto.praticante.FinalizadoEntradaDTO;
import com.equoterapia.api.dto.praticante.FinalizadoSaidaDTO;
import com.equoterapia.api.mapeador.praticante.PraticanteMapeador;
import com.equoterapia.dominio.modelo.praticante.Finalizado;
import com.equoterapia.dominio.servico.praticante.finalizado.FinalizadoServico;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/praticante/finalizado")
public class FinalizadoController {

    @Autowired
    private FinalizadoServico servico;

    @PostMapping("/finalizar-cadastro")
    public ResponseEntity<Mensagem> finalizar(@RequestBody @Valid FinalizadoEntradaDTO finalizadoEntradaDTO) {
        Finalizado finalizado = PraticanteMapeador.converterFinalizadoEntradaDTOParaFinalizado(finalizadoEntradaDTO);
        finalizado = servico.finalizarCadastro(finalizado);
        FinalizadoSaidaDTO finalizadoSaidaDTO = PraticanteMapeador.converterFinalizadoParaFinalizadoSaidaDTO(finalizado);
        return new ResponseEntity<Mensagem>(new Mensagem("O cadastro do praticante foi finalizado com sucesso!"), HttpStatus.CREATED);
    }


    @GetMapping("/verificar-status")
    public ResponseEntity<FinalizadoSaidaDTO> finalizar(@RequestParam("idPraticante") Long idPraticante) {
        Finalizado finalizado = servico.verificarStatusCadastro(idPraticante);
        return new ResponseEntity<FinalizadoSaidaDTO>(PraticanteMapeador.converterFinalizadoParaFinalizadoSaidaDTO(finalizado), HttpStatus.OK);
    }


}
