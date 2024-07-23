package com.equoterapia.api.controlador.praticante.fichaCadastroAdmissional;

import com.equoterapia.api.dto.praticante.fichaCadastroAdmissional.DadosPessoaisEntradaDTO;
import com.equoterapia.api.dto.praticante.fichaCadastroAdmissional.DadosPessoaisSaidaDTO;
import com.equoterapia.api.mapeador.praticante.PraticanteMapeador;
import com.equoterapia.dominio.modelo.praticante.fichaCadastroAdmissional.DadosPessoais;
import com.equoterapia.dominio.servico.praticante.fichaCadastroAdmissional.DadosPessoaisServico;
import jakarta.validation.Valid;
import org.hibernate.validator.constraints.br.CPF;
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
        DadosPessoais dadosPessoais = PraticanteMapeador.converterDadosPessoaisEntradaDTOParaDadosPessoais(dadosPessoaisEntradaDTO);
        DadosPessoais dadosPessoaisSalvo = dadosPessoaisServico.salvarDadosPessoais(dadosPessoais);
        DadosPessoaisSaidaDTO dadosPessoaisSaidaDTO = PraticanteMapeador.converterDadosPessoaisParaDadosPessoaisSaidaDTO(dadosPessoaisSalvo);
        return new ResponseEntity<DadosPessoaisSaidaDTO>(dadosPessoaisSaidaDTO, HttpStatus.CREATED);
    }

    @PutMapping("/atualizar-dados-pessoais-do-praticante")
    public ResponseEntity<?> atualizarDadosPessoais(@RequestBody @Valid DadosPessoaisEntradaDTO dadosPessoaisEntradaDTO){
        DadosPessoais dadosPessoais = PraticanteMapeador.converterDadosPessoaisEntradaDTOParaDadosPessoais(dadosPessoaisEntradaDTO);
        DadosPessoais dadosPessoaisAtualizado = dadosPessoaisServico.atualizarDadosPessoais(dadosPessoais);
        DadosPessoaisSaidaDTO dadosPessoaisSaidaDTO = PraticanteMapeador.converterDadosPessoaisParaDadosPessoaisSaidaDTO(dadosPessoaisAtualizado);
        return new ResponseEntity<DadosPessoaisSaidaDTO>(dadosPessoaisSaidaDTO, HttpStatus.CREATED);
    }

    @GetMapping("/buscar-dados-pessoais-do-praticante-por-id")
    public ResponseEntity<?> buscarDadosPessoaisDoPraticantePorID(@RequestParam("id") Long id){
        DadosPessoais dadosPessoais = dadosPessoaisServico.buscarDadosPessoaisPorID(id);
        DadosPessoaisSaidaDTO dadosPessoaisSaidaDTO = PraticanteMapeador.converterDadosPessoaisParaDadosPessoaisSaidaDTO(dadosPessoais);
        return new ResponseEntity<DadosPessoaisSaidaDTO>(dadosPessoaisSaidaDTO, HttpStatus.OK);
    }

    @GetMapping("/buscar-dados-pessoais-do-praticante-por-cpf")
    public ResponseEntity<?> buscarDadosPessoaisDoPraticantePorCPF(@RequestParam("cpf") @Valid @CPF String cpf){
        DadosPessoais dadosPessoais = dadosPessoaisServico.buscarDadosPessoaisPorCPF(cpf);
        DadosPessoaisSaidaDTO dadosPessoaisSaidaDTO = PraticanteMapeador.converterDadosPessoaisParaDadosPessoaisSaidaDTO(dadosPessoais);
        return new ResponseEntity<DadosPessoaisSaidaDTO>(dadosPessoaisSaidaDTO, HttpStatus.OK);
    }

    @GetMapping("/buscar-dados-pessoais-dos-praticantes")
    public ResponseEntity<?> buscarDadosPessoaisDosPraticantes(){
        List<DadosPessoais> listaDeDadosPessoaisDosPraticantes = dadosPessoaisServico.buscarDadosPessoaisDosPraticantes();
        List<DadosPessoaisSaidaDTO> listaDadosPessoaisDosPraticantesSaidaDTO = PraticanteMapeador.converterListaDeDadosPessoaisParaListaDeDadosPessoaisSaidaDTO(listaDeDadosPessoaisDosPraticantes);
        return new ResponseEntity<List<DadosPessoaisSaidaDTO>>(listaDadosPessoaisDosPraticantesSaidaDTO, HttpStatus.OK);
    }

}
