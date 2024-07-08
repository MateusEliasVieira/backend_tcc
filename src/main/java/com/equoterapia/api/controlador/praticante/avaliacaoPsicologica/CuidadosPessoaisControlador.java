package com.equoterapia.api.controlador.praticante.avaliacaoPsicologica;

import com.equoterapia.api.controlador.utilidades.Mensagem;
import com.equoterapia.api.dto.praticante.avaliacaoPsicologica.CuidadosPessoaisEntradaDTO;
import com.equoterapia.api.mapeador.praticante.PraticanteMapeador;
import com.equoterapia.dominio.modelo.praticante.avaliacaoPsicologica.CuidadosPessoais;
import com.equoterapia.dominio.servico.praticante.avaliacaoPsicologica.CuidadosPessoaisServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("praticante/cuidados-pessoais")
public class CuidadosPessoaisControlador {

    @Autowired
    private CuidadosPessoaisServico cuidadosPessoaisServico;

    @PostMapping("/salvar-cuidados-pessoais-do-praticante")
    public ResponseEntity<?> salvarCuidadosPessoais(@RequestBody CuidadosPessoaisEntradaDTO cuidadosPessoaisEntradaDTO) {
        CuidadosPessoais cuidadosPessoais = PraticanteMapeador.converterCuidadosPessoaisEntradaDTOEmCuidadosPessoais(cuidadosPessoaisEntradaDTO);
        cuidadosPessoaisServico.salvarCuidadosPessoais(cuidadosPessoais);
        return new ResponseEntity<>(new Mensagem("Cuidados pessoais do praticante cadastrado com sucesso!"), HttpStatus.CREATED);
    }

    @PutMapping("/atualizar-cuidados-pessoais-do-praticante")
    public ResponseEntity<?> atualizarCuidadosPessoais(@RequestBody CuidadosPessoaisEntradaDTO cuidadosPessoaisEntradaDTO) {
        CuidadosPessoais cuidadosPessoais = PraticanteMapeador.converterCuidadosPessoaisEntradaDTOEmCuidadosPessoais(cuidadosPessoaisEntradaDTO);
        cuidadosPessoaisServico.atualizarCuidadosPessoais(cuidadosPessoais);
        return new ResponseEntity<>(new Mensagem("Cuidados pessoais do praticante atualizado com sucesso!"), HttpStatus.CREATED);
    }

    @GetMapping("/buscar-cuidados-pessoais-do-praticante-por-id")
    public ResponseEntity<?> buscarCuidadosPessoaisPorId(@RequestParam("id") Long id) {
        return new ResponseEntity<>(PraticanteMapeador.converterCuidadosPessoaisEmCuidadosPessoaisSaidaDTO(cuidadosPessoaisServico.buscarCuidadosPessoaisPorId(id)), HttpStatus.OK);
    }
}
