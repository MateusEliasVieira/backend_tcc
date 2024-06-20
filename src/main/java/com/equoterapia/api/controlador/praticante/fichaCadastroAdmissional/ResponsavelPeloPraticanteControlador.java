package com.equoterapia.api.controlador.praticante.fichaCadastroAdmissional;

import com.equoterapia.api.dto.praticante.fichaCadastroAdmissional.ResponsavelPraticanteEntradaDTO;
import com.equoterapia.api.dto.praticante.fichaCadastroAdmissional.ResponsavelPraticanteSaidaDTO;
import com.equoterapia.api.mapeador.praticante.PraticanteMapeador;
import com.equoterapia.dominio.servico.paciente.fichaCadastroAdmissional.ResponsavelPraticanteServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/praticante/responsavel-pelo-praticante")
public class ResponsavelPeloPraticanteControlador {

    @Autowired
    private ResponsavelPraticanteServico service;

    @PostMapping(path = "/salvar-responsavel-do-praticante")
    public ResponseEntity<ResponsavelPraticanteSaidaDTO> salvarResponsavelPeloPaciente(@RequestBody ResponsavelPraticanteEntradaDTO responsavelPraticanteEntradaDTO) {
        return new ResponseEntity<ResponsavelPraticanteSaidaDTO>(PraticanteMapeador.converterResponsavelPacienteEmResponsavelPacienteOutputDTO(service.salvar(PraticanteMapeador.converterResponsavelPacienteInputDTOEmResponsavelPaciente(responsavelPraticanteEntradaDTO))), HttpStatus.CREATED);
    }
}
