package com.equoterapia.api.controlador.praticante.avaliacaoPsicologica;

import com.equoterapia.api.controlador.utilidades.Mensagem;
import com.equoterapia.api.dto.praticante.avaliacaoPsicologica.CompreensaoEntradaDTO;
import com.equoterapia.api.mapeador.praticante.PraticanteMapeador;
import com.equoterapia.dominio.modelo.praticante.avaliacaoPsicologica.Compreensao;
import com.equoterapia.dominio.servico.praticante.avaliacaoPsicologica.CompreensaoServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("praticante/compreensao")
public class CompreensaoControlador {

    @Autowired
    private CompreensaoServico compreensaoServico;

    @PostMapping("/salvar-compreensao-do-praticante")
    public ResponseEntity<?> salvarCompreensao(@RequestBody CompreensaoEntradaDTO compreensaoEntradaDTO) {
        Compreensao compreensao = PraticanteMapeador.converterCompreensaoEntradaDTOEmCompreensao(compreensaoEntradaDTO);
        compreensaoServico.salvarCompreensao(compreensao);
        return new ResponseEntity<>(new Mensagem("Compreensão do praticante cadastrada com sucesso!"), HttpStatus.CREATED);
    }

    @PutMapping("/atualizar-compreensao-do-praticante")
    public ResponseEntity<?> atualizarCompreensao(@RequestBody CompreensaoEntradaDTO compreensaoEntradaDTO) {
        Compreensao compreensao = PraticanteMapeador.converterCompreensaoEntradaDTOEmCompreensao(compreensaoEntradaDTO);
        compreensaoServico.atualizarCompreensao(compreensao);
        return new ResponseEntity<>(new Mensagem("Compreensão do praticante atualizada com sucesso!"), HttpStatus.CREATED);
    }

    @GetMapping("/buscar-compreensao-do-praticante-por-id")
    public ResponseEntity<?> buscarCompreensaoPorId(@RequestParam("id") Long id) {
        return new ResponseEntity<>(PraticanteMapeador.converterCompreensaoEmCompreensaoSaidaDTO(compreensaoServico.buscarCompreensaoPorId(id)), HttpStatus.OK);
    }
}
