package com.equoterapia.api.controlador.praticante.avaliacaoPsicologica;

import com.equoterapia.api.controlador.utilidades.Mensagem;
import com.equoterapia.api.dto.praticante.avaliacaoPsicologica.SocializacaoEntradaDTO;
import com.equoterapia.api.mapeador.praticante.PraticanteMapeador;
import com.equoterapia.dominio.modelo.praticante.avaliacaoPsicologica.Socializacao;
import com.equoterapia.dominio.servico.praticante.avaliacaoPsicologica.SocializacaoServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("praticante/socializacao")
public class SocializacaoControlador {

    @Autowired
    private SocializacaoServico socializacaoServico;

    @PostMapping("/salvar-socializacao-do-praticante")
    public ResponseEntity<?> salvarSocializacao(@RequestBody SocializacaoEntradaDTO socializacaoEntradaDTO) {
        Socializacao socializacao = PraticanteMapeador.converterSocializacaoEntradaDTOEmSocializacao(socializacaoEntradaDTO);
        socializacaoServico.salvarSocializacao(socializacao);
        return new ResponseEntity<>(new Mensagem("Socialização do praticante cadastrada com sucesso!"), HttpStatus.CREATED);
    }

    @PutMapping("/atualizar-socializacao-do-praticante")
    public ResponseEntity<?> atualizarSocializacao(@RequestBody SocializacaoEntradaDTO socializacaoEntradaDTO) {
        Socializacao socializacao = PraticanteMapeador.converterSocializacaoEntradaDTOEmSocializacao(socializacaoEntradaDTO);
        socializacaoServico.atualizarSocializacao(socializacao);
        return new ResponseEntity<>(new Mensagem("Socialização do praticante atualizada com sucesso!"), HttpStatus.CREATED);
    }

    @GetMapping("/buscar-socializacao-do-praticante-por-id")
    public ResponseEntity<?> buscarSocializacaoPorId(@RequestParam("id") Long id) {
        return new ResponseEntity<>(PraticanteMapeador.converterSocializacaoEmSocializacaoSaidaDTO(socializacaoServico.buscarSocializacaoPorId(id)), HttpStatus.OK);
    }
}
