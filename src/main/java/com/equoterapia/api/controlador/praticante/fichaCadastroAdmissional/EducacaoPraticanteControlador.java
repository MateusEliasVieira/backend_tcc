package com.equoterapia.api.controlador.praticante.fichaCadastroAdmissional;

import com.equoterapia.api.dto.praticante.fichaCadastroAdmissional.EducacaoPraticanteEntradaDTO;
import com.equoterapia.api.dto.praticante.fichaCadastroAdmissional.EducacaoPraticanteSaidaDTO;
import com.equoterapia.api.mapeador.praticante.PraticanteMapeador;
import com.equoterapia.dominio.modelo.praticante.fichaCadastroAdmissional.EducacaoPraticante;
import com.equoterapia.dominio.servico.paciente.fichaCadastroAdmissional.EducacaoPraticanteServico;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/praticante/educacao-praticante")
public class EducacaoPraticanteControlador {

    @Autowired
    private EducacaoPraticanteServico educacaoPraticanteServico;

    @PostMapping("/salvar-educacao-do-praticante")
    public ResponseEntity<?> salvarEducacaoPaciente(@RequestBody @Valid EducacaoPraticanteEntradaDTO educacaoPraticanteEntradaDTO){
        System.out.println("ID = "+ educacaoPraticanteEntradaDTO.getPaciente().getIdPaciente());
        EducacaoPraticante educacaoPraticante = PraticanteMapeador.converterEducacaoPacienteInputDTOParaEducacaoPaciente(educacaoPraticanteEntradaDTO);
        EducacaoPraticanteSaidaDTO educacaoPraticanteSaidaDTO = PraticanteMapeador.converterEducacaoPacienteParaEducacaoPacienteOutputDTO(educacaoPraticanteServico.salvarEducacaoPaciente(educacaoPraticante));
        return new ResponseEntity<EducacaoPraticanteSaidaDTO>(educacaoPraticanteSaidaDTO, HttpStatus.CREATED);
    }

    @PutMapping("/atualizar-educacao-do-praticante")
    public ResponseEntity<?> atualizarEducacaoPaciente(@RequestBody @Valid EducacaoPraticanteEntradaDTO educacaoPraticanteEntradaDTO){
        EducacaoPraticante educacaoPraticante = PraticanteMapeador.converterEducacaoPacienteInputDTOParaEducacaoPaciente(educacaoPraticanteEntradaDTO);
        EducacaoPraticanteSaidaDTO educacaoPraticanteSaidaDTO = PraticanteMapeador.converterEducacaoPacienteParaEducacaoPacienteOutputDTO(educacaoPraticanteServico.atualizarEducacaoPaciente(educacaoPraticante));
        return new ResponseEntity<EducacaoPraticanteSaidaDTO>(educacaoPraticanteSaidaDTO, HttpStatus.OK);
    }

    @GetMapping("/buscar-educacao-do-praticante-por-id/{id}")
    public ResponseEntity<?> buscarEducacaoPaciente(@Valid @PathVariable("id") Long id){
        EducacaoPraticante educacaoPraticante = educacaoPraticanteServico.buscarEducacaoPaciente(id);
        EducacaoPraticanteSaidaDTO educacaoPraticanteSaidaDTO = PraticanteMapeador.converterEducacaoPacienteParaEducacaoPacienteOutputDTO(educacaoPraticante);
        return new ResponseEntity<EducacaoPraticanteSaidaDTO>(educacaoPraticanteSaidaDTO, HttpStatus.OK);
    }

}
