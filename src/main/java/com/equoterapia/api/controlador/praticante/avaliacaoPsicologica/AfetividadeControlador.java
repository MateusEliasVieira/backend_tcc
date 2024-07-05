package com.equoterapia.api.controlador.praticante.avaliacaoPsicologica;

import com.equoterapia.api.controlador.utilidades.Mensagem;
import com.equoterapia.api.dto.praticante.avaliacaoPsicologica.AfetividadeEntradaDTO;
import com.equoterapia.api.mapeador.praticante.PraticanteMapeador;
import com.equoterapia.dominio.modelo.praticante.avaliacaoPsicologica.Afetividade;
import com.equoterapia.dominio.servico.praticante.avaliacaoPsicologica.AfetividadeServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("praticante/afetividade")
public class AfetividadeControlador {

    @Autowired
    private AfetividadeServico afetividadeServico;

    @PostMapping("/salvar-afetividade-do-praticante")
    public ResponseEntity<?> salvarAfetividade(@RequestBody AfetividadeEntradaDTO afetividadeEntradaDTO) {
        Afetividade afetividade = PraticanteMapeador.converterAfetividadeEntradaDTOEmAfetividade(afetividadeEntradaDTO);
        afetividadeServico.salvarAfetividade(afetividade);
        return new ResponseEntity<>(new Mensagem("Afetividade do praticante cadastrada com sucesso!"), HttpStatus.CREATED);
    }

    @PutMapping("/atualizar-afetividade-do-praticante")
    public ResponseEntity<?> atualizarAfetividade(@RequestBody AfetividadeEntradaDTO afetividadeEntradaDTO) {
        Afetividade afetividade = PraticanteMapeador.converterAfetividadeEntradaDTOEmAfetividade(afetividadeEntradaDTO);
        afetividadeServico.atualizarAfetividade(afetividade);
        return new ResponseEntity<>(new Mensagem("Afetividade do praticante atualizada com sucesso!"), HttpStatus.CREATED);
    }

    @GetMapping("/buscar-afetividade-do-praticante-por-id")
    public ResponseEntity<?> buscarAfetividadePorId(@RequestParam("id") Long id) {
        return new ResponseEntity<>(PraticanteMapeador.converterAfetividadeEmAfetividadeSaidaDTO(afetividadeServico.buscarAfetividadePorId(id)), HttpStatus.OK);
    }
}
