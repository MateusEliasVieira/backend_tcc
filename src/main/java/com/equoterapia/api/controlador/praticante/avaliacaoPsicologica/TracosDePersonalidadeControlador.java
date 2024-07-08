package com.equoterapia.api.controlador.praticante.avaliacaoPsicologica;

import com.equoterapia.api.controlador.utilidades.Mensagem;
import com.equoterapia.api.dto.praticante.avaliacaoPsicologica.TracosDePersonalidadeEntradaDTO;
import com.equoterapia.api.mapeador.praticante.PraticanteMapeador;
import com.equoterapia.dominio.modelo.praticante.avaliacaoPsicologica.TracosDePersonalidade;
import com.equoterapia.dominio.servico.praticante.avaliacaoPsicologica.TracosDePersonalidadeServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("praticante/tracos-de-personalidade")
public class TracosDePersonalidadeControlador {

    @Autowired
    private TracosDePersonalidadeServico tracosDePersonalidadeServico;

    @PostMapping("/salvar-tracos-de-personalidade-do-praticante")
    public ResponseEntity<?> salvarTracosDePersonalidade(@RequestBody TracosDePersonalidadeEntradaDTO tracosDePersonalidadeEntradaDTO) {
        TracosDePersonalidade tracosDePersonalidade = PraticanteMapeador.converterTracosDePersonalidadeEntradaDTOEmTracosDePersonalidade(tracosDePersonalidadeEntradaDTO);
        tracosDePersonalidadeServico.salvarTracosDePersonalidade(tracosDePersonalidade);
        return new ResponseEntity<>(new Mensagem("Traços de personalidade do praticante cadastrado com sucesso!"), HttpStatus.CREATED);
    }

    @PutMapping("/atualizar-tracos-de-personalidade-do-praticante")
    public ResponseEntity<?> atualizarTracosDePersonalidade(@RequestBody TracosDePersonalidadeEntradaDTO tracosDePersonalidadeEntradaDTO) {
        TracosDePersonalidade tracosDePersonalidade = PraticanteMapeador.converterTracosDePersonalidadeEntradaDTOEmTracosDePersonalidade(tracosDePersonalidadeEntradaDTO);
        tracosDePersonalidadeServico.atualizarTracosDePersonalidade(tracosDePersonalidade);
        return new ResponseEntity<>(new Mensagem("Traços de personalidade do praticante atualizado com sucesso!"), HttpStatus.CREATED);
    }

    @GetMapping("/buscar-tracos-de-personalidade-do-praticante-por-id")
    public ResponseEntity<?> buscarTracosDePersonalidadePorId(@RequestParam("id") Long id) {
        return new ResponseEntity<>(PraticanteMapeador.converterTracosDePersonalidadeEmTracosDePersonalidadeSaidaDTO(tracosDePersonalidadeServico.buscarTracosDePersonalidadePorId(id)), HttpStatus.OK);
    }
}
