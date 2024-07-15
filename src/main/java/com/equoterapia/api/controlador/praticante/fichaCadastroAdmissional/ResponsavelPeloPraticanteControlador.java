package com.equoterapia.api.controlador.praticante.fichaCadastroAdmissional;

import com.equoterapia.api.dto.praticante.fichaCadastroAdmissional.ResponsavelPraticanteEntradaDTO;
import com.equoterapia.api.dto.praticante.fichaCadastroAdmissional.ResponsavelPraticanteSaidaDTO;
import com.equoterapia.api.dto.praticante.fichaCadastroAdmissional.ResponsavelPraticanteEntradaDTO;
import com.equoterapia.api.dto.praticante.fichaCadastroAdmissional.ResponsavelPraticanteSaidaDTO;
import com.equoterapia.api.mapeador.praticante.PraticanteMapeador;
import com.equoterapia.dominio.modelo.praticante.fichaCadastroAdmissional.ResponsavelPraticante;
import com.equoterapia.dominio.servico.praticante.fichaCadastroAdmissional.ResponsavelPraticanteServico;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/praticante/responsavel-pelo-praticante")
public class ResponsavelPeloPraticanteControlador {

    @Autowired
    private ResponsavelPraticanteServico responsavelPraticanteServico;

    @PostMapping(path = "/salvar-responsavel-do-praticante")
    public ResponseEntity<ResponsavelPraticanteSaidaDTO> salvarResponsavelPeloPraticante(@RequestBody ResponsavelPraticanteEntradaDTO responsavelPraticanteEntradaDTO) {
        return new ResponseEntity<ResponsavelPraticanteSaidaDTO>(PraticanteMapeador.converterResponsavelPraticanteEmResponsavelPraticanteSaidaDTO(responsavelPraticanteServico.salvar(PraticanteMapeador.converterResponsavelPraticanteEntradaDTOEmResponsavelPraticante(responsavelPraticanteEntradaDTO))), HttpStatus.CREATED);
    }
    @PutMapping("/atualizar-responsavel-do-praticante")
    public ResponseEntity<?> atualizarResponsavelPeloPraticante(@RequestBody @Valid ResponsavelPraticanteEntradaDTO responsavelPraticanteEntradaDTO){
        ResponsavelPraticante responsavelPraticante = PraticanteMapeador.converterResponsavelPraticanteEntradaDTOEmResponsavelPraticante(responsavelPraticanteEntradaDTO);
        ResponsavelPraticanteSaidaDTO responsavelPraticanteSaidaDTO = PraticanteMapeador.converterResponsavelPraticanteEmResponsavelPraticanteSaidaDTO(responsavelPraticanteServico.atualizar(responsavelPraticante));
        return new ResponseEntity<ResponsavelPraticanteSaidaDTO>(responsavelPraticanteSaidaDTO, HttpStatus.OK);
    }

    @GetMapping("/buscar-responsavel-do-praticante-por-id")
    public ResponseEntity<?> buscarResponsavelPeloPraticante(@RequestParam("id") Long id){
        ResponsavelPraticante responsavelPraticante = responsavelPraticanteServico.buscarPorId(id);
        ResponsavelPraticanteSaidaDTO responsavelPraticanteSaidaDTO = PraticanteMapeador.converterResponsavelPraticanteEmResponsavelPraticanteSaidaDTO(responsavelPraticante);
        return new ResponseEntity<ResponsavelPraticanteSaidaDTO>(responsavelPraticanteSaidaDTO, HttpStatus.OK);
    }
}
