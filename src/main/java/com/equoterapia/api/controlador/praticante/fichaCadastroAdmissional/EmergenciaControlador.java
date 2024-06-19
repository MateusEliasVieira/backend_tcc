package com.equoterapia.api.controlador.praticante.fichaCadastroAdmissional;

import com.equoterapia.api.dto.praticante.fichaCadastroAdmissional.EmergenciaEntradaDTO;
import com.equoterapia.api.dto.praticante.fichaCadastroAdmissional.EmergenciaSaidaDTO;
import com.equoterapia.api.mapeador.praticante.PraticanteMapeador;
import com.equoterapia.dominio.modelo.praticante.fichaCadastroAdmissional.Emergencia;
import com.equoterapia.dominio.servico.paciente.fichaCadastroAdmissional.EmergenciaServico;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/paciente/emergencia")
public class EmergenciaControlador {

    @Autowired
    private EmergenciaServico emergenciaServico;

    @PostMapping("/salvar-emergencia")
    public ResponseEntity<?> salvarEmergencia(@RequestBody @Valid EmergenciaEntradaDTO emergenciaEntradaDTO){
        Emergencia emergencia = PraticanteMapeador.converterEmergenciaInputDTOParaEmergencia(emergenciaEntradaDTO);
        Emergencia emergenciaSalva = emergenciaServico.salvarEmergencia(emergencia);
        EmergenciaSaidaDTO emergenciaSaidaDTO = PraticanteMapeador.converterEmergenciaParaEmergenciaOutputDTO(emergenciaSalva);
        return new ResponseEntity<EmergenciaSaidaDTO>(emergenciaSaidaDTO, HttpStatus.CREATED);
    }

    @PutMapping("/atualizar-emergencia")
    public ResponseEntity<?> atualizarEmergencia(@RequestBody @Valid EmergenciaEntradaDTO emergenciaEntradaDTO){
        Emergencia emergencia = PraticanteMapeador.converterEmergenciaInputDTOParaEmergencia(emergenciaEntradaDTO);
        Emergencia emergenciaSalva = emergenciaServico.atualizarEmergencia(emergencia);
        EmergenciaSaidaDTO emergenciaSaidaDTO = PraticanteMapeador.converterEmergenciaParaEmergenciaOutputDTO(emergenciaSalva);
        return new ResponseEntity<EmergenciaSaidaDTO>(emergenciaSaidaDTO, HttpStatus.OK);
    }

    @GetMapping("/buscar-emergencia-por-id/{id}")
    public ResponseEntity<?> buscarEmergencia(@PathVariable("id") @Valid Long id){
        Emergencia emergenciaEncontrada = emergenciaServico.buscarEmergencia(id);
        EmergenciaSaidaDTO emergenciaSaidaDTO = PraticanteMapeador.converterEmergenciaParaEmergenciaOutputDTO(emergenciaEncontrada);
        return new ResponseEntity<EmergenciaSaidaDTO>(emergenciaSaidaDTO, HttpStatus.OK);
    }

}
