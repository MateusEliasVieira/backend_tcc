package com.equoterapia.api.controlador.praticante.avaliacaoPsicologica;

import com.equoterapia.api.controlador.utilidades.Mensagem;
import com.equoterapia.api.dto.praticante.avaliacaoPsicologica.LinguagemEntradaDTO;
import com.equoterapia.api.mapeador.praticante.PraticanteMapeador;
import com.equoterapia.dominio.modelo.praticante.avaliacaoPsicologica.Linguagem;
import com.equoterapia.dominio.servico.praticante.avaliacaoPsicologica.LinguagemServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("praticante/linguagem")
public class LinguagemControlador {

    @Autowired
    private LinguagemServico linguagemServico;

    @PostMapping("/salvar-linguagem-do-praticante")
    public ResponseEntity<?> salvarLinguagem(@RequestBody LinguagemEntradaDTO linguagemEntradaDTO) {
        Linguagem linguagem = PraticanteMapeador.converterLinguagemEntradaDTOEmLinguagem(linguagemEntradaDTO);
        linguagemServico.salvarLinguagem(linguagem);
        return new ResponseEntity<>(new Mensagem("Linguagem do praticante cadastrada com sucesso!"), HttpStatus.CREATED);
    }

    @PutMapping("/atualizar-linguagem-do-praticante")
    public ResponseEntity<?> atualizarLinguagem(@RequestBody LinguagemEntradaDTO linguagemEntradaDTO) {
        Linguagem linguagem = PraticanteMapeador.converterLinguagemEntradaDTOEmLinguagem(linguagemEntradaDTO);
        linguagemServico.atualizarLinguagem(linguagem);
        return new ResponseEntity<>(new Mensagem("Linguagem do praticante atualizada com sucesso!"), HttpStatus.CREATED);
    }

    @GetMapping("/buscar-linguagem-do-praticante-por-id")
    public ResponseEntity<?> buscarLinguagemPorId(@RequestParam("id") Long id) {
        return new ResponseEntity<>(PraticanteMapeador.converterLinguagemEmLinguagemSaidaDTO(linguagemServico.buscarLinguagemPorId(id)), HttpStatus.OK);
    }
}
