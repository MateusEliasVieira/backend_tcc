package com.equoterapia.api.controlador.praticante.fichaCadastroAdmissional;

import com.equoterapia.api.dto.praticante.fichaCadastroAdmissional.DadosPessoaisEntradaDTO;
import com.equoterapia.api.dto.praticante.fichaCadastroAdmissional.DadosPessoaisSaidaDTO;
import com.equoterapia.api.mapeador.praticante.PraticanteMapeador;
import com.equoterapia.dominio.modelo.praticante.fichaCadastroAdmissional.DadosPessoais;
import com.equoterapia.dominio.servico.paciente.fichaCadastroAdmissional.DadosPessoaisServico;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/praticante/dados-pessoais")
public class DadosPessoaisControlador {

    @Autowired
    private DadosPessoaisServico dadosPessoaisServico;

    @PostMapping("/salvar-dados-pessoais-do-praticante")
    public ResponseEntity<?> salvarDadosPessoais(@RequestBody @Valid DadosPessoaisEntradaDTO dadosPessoaisEntradaDTO){
        System.out.println("=============== Entrou para salvar os dados pessoais ===============");
        DadosPessoais dadosPessoais = PraticanteMapeador.converterDadosPessoaisInputDTOParaDadosPessoais(dadosPessoaisEntradaDTO);
        DadosPessoais dadosPessoaisSalvo = dadosPessoaisServico.salvarDadosPessoais(dadosPessoais);
        DadosPessoaisSaidaDTO dadosPessoaisSaidaDTO = PraticanteMapeador.converterDadosPessoaisParaDadosPessoaisOutputDTO(dadosPessoaisSalvo);
        return new ResponseEntity<DadosPessoaisSaidaDTO>(dadosPessoaisSaidaDTO, HttpStatus.CREATED);
    }

    @PutMapping("/atualizar-dados-pessoais-do-praticante")
    public ResponseEntity<?> atualizarDadosPessoais(@RequestBody @Valid DadosPessoaisEntradaDTO dadosPessoaisEntradaDTO){
        DadosPessoais dadosPessoais = PraticanteMapeador.converterDadosPessoaisInputDTOParaDadosPessoais(dadosPessoaisEntradaDTO);
        DadosPessoais dadosPessoaisAtualizado = dadosPessoaisServico.atualizarDadosPessoais(dadosPessoais);
        DadosPessoaisSaidaDTO dadosPessoaisSaidaDTO = PraticanteMapeador.converterDadosPessoaisParaDadosPessoaisOutputDTO(dadosPessoaisAtualizado);
        return new ResponseEntity<DadosPessoaisSaidaDTO>(dadosPessoaisSaidaDTO, HttpStatus.CREATED);
    }

    @GetMapping("/buscar-dados-pessoais-do-praticante-por-id/{id_paciente}")
    public ResponseEntity<?> buscarDadosPessoaisDosPacientes(@PathVariable("id_paciente") Long id_paciente){
        DadosPessoais dadosPessoais = dadosPessoaisServico.buscarDadosPessoaisPorID(id_paciente);
        DadosPessoaisSaidaDTO dadosPessoaisSaidaDTO = PraticanteMapeador.converterDadosPessoaisParaDadosPessoaisOutputDTO(dadosPessoais);
        return new ResponseEntity<DadosPessoaisSaidaDTO>(dadosPessoaisSaidaDTO, HttpStatus.OK);
    }

    @GetMapping("/buscar-dados-pessoais-dos-praticantes")
    public ResponseEntity<?> buscarDadosPessoaisDosPacientes(){
        List<DadosPessoais> listaDeDadosPessoaisDosPacientes = dadosPessoaisServico.buscarDadosPessoaisDosPacientes();
        List<DadosPessoaisSaidaDTO> listaDadosPessoaisDosPacientesOutputDTO = PraticanteMapeador.converterListaDeDadosPessoaisParaListaDeDadosPessoaisOutputDTO(listaDeDadosPessoaisDosPacientes);
        return new ResponseEntity<List<DadosPessoaisSaidaDTO>>(listaDadosPessoaisDosPacientesOutputDTO, HttpStatus.OK);
    }

}
