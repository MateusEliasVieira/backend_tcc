package com.equoterapia.api.controlador.praticante.fichaCadastroAdmissional;

import com.equoterapia.api.dto.praticante.fichaCadastroAdmissional.EducacaoPraticanteEntradaDTO;
import com.equoterapia.api.dto.praticante.fichaCadastroAdmissional.EducacaoPraticanteSaidaDTO;
import com.equoterapia.api.mapeador.praticante.PraticanteMapeador;
import com.equoterapia.dominio.modelo.praticante.fichaCadastroAdmissional.EducacaoPraticante;
import com.equoterapia.dominio.servico.praticante.fichaCadastroAdmissional.EducacaoServico;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/praticante/educacao-praticante")
public class EducacaoPraticanteControlador {

    @Autowired
    private EducacaoServico educacaoServico;

    @PostMapping("/salvar-educacao-do-praticante")
    public ResponseEntity<?> salvarEducacaoPraticante(@RequestBody @Valid EducacaoPraticanteEntradaDTO educacaoPraticanteEntradaDTO){
        EducacaoPraticante educacaoPraticante = PraticanteMapeador.converterEducacaoPraticanteEntradaDTOParaEducacaoPraticante(educacaoPraticanteEntradaDTO);
        EducacaoPraticanteSaidaDTO educacaoPraticanteSaidaDTO = PraticanteMapeador.converterEducacaoPraticanteParaEducacaoPraticanteSaidaDTO(educacaoServico.salvarEducacaoPraticante(educacaoPraticante));
        return new ResponseEntity<EducacaoPraticanteSaidaDTO>(educacaoPraticanteSaidaDTO, HttpStatus.CREATED);
    }

    @PutMapping("/atualizar-educacao-do-praticante")
    public ResponseEntity<?> atualizarEducacaoPraticante(@RequestBody @Valid EducacaoPraticanteEntradaDTO educacaoPraticanteEntradaDTO){
        EducacaoPraticante educacaoPraticante = PraticanteMapeador.converterEducacaoPraticanteEntradaDTOParaEducacaoPraticante(educacaoPraticanteEntradaDTO);
        EducacaoPraticanteSaidaDTO educacaoPraticanteSaidaDTO = PraticanteMapeador.converterEducacaoPraticanteParaEducacaoPraticanteSaidaDTO(educacaoServico.atualizarEducacaoPraticante(educacaoPraticante));
        return new ResponseEntity<EducacaoPraticanteSaidaDTO>(educacaoPraticanteSaidaDTO, HttpStatus.OK);
    }

    @GetMapping("/buscar-educacao-do-praticante-por-id")
    public ResponseEntity<?> buscarEducacaoPraticante(@RequestParam("id") Long id){
        EducacaoPraticante educacaoPraticante = educacaoServico.buscarEducacaoPraticante(id);
        EducacaoPraticanteSaidaDTO educacaoPraticanteSaidaDTO = PraticanteMapeador.converterEducacaoPraticanteParaEducacaoPraticanteSaidaDTO(educacaoPraticante);
        return new ResponseEntity<EducacaoPraticanteSaidaDTO>(educacaoPraticanteSaidaDTO, HttpStatus.OK);
    }

}
