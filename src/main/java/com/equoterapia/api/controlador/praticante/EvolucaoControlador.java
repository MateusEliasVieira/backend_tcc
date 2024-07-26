package com.equoterapia.api.controlador.praticante;

import com.equoterapia.api.controlador.utilidades.Mensagem;
import com.equoterapia.api.dto.praticante.evolucao.EvolucaoEntradaDTO;
import com.equoterapia.api.dto.praticante.evolucao.EvolucaoParaGraficoEntradaDTO;
import com.equoterapia.api.dto.praticante.evolucao.EvolucaoParaGraficoSaidaDTO;
import com.equoterapia.api.dto.praticante.evolucao.EvolucaoSaidaDTO;
import com.equoterapia.api.mapeador.praticante.PraticanteMapeador;
import com.equoterapia.dominio.modelo.praticante.Evolucao;
import com.equoterapia.dominio.servico.praticante.evolucao.EvolucaoServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("praticante/evolucao")
public class EvolucaoControlador {

    @Autowired
    private EvolucaoServico evolucaoServico;

    @PostMapping("/salvar-evolucao-do-praticante")
    public ResponseEntity<?> salvarEvolucao(@RequestBody EvolucaoEntradaDTO evolucaoEntradaDTO) {
        System.out.println("Entrou aqui. " + evolucaoEntradaDTO.toString());
        Evolucao evolucao = PraticanteMapeador.converterEvolucaoEntradaDTOParaEvolucao(evolucaoEntradaDTO);
        evolucaoServico.salvarEvolucao(evolucao);
        return new ResponseEntity<Mensagem>(new Mensagem("Evolucao do praticante cadastrada com sucesso!"), HttpStatus.CREATED);
    }

    @PutMapping("/atualizar-evolucao-do-praticante")
    public ResponseEntity<?> atualizarEvolucao(@RequestBody EvolucaoEntradaDTO evolucaoEntradaDTO) {
        Evolucao evolucao = PraticanteMapeador.converterEvolucaoEntradaDTOParaEvolucao(evolucaoEntradaDTO);
        evolucaoServico.atualizarEvolucao(evolucao);
        return new ResponseEntity<Mensagem>(new Mensagem("Evolucao do praticante atualizada com sucesso!"), HttpStatus.CREATED);
    }

    @GetMapping("/buscar-evolucoes-do-praticante-por-id")
    public ResponseEntity<?> buscarEvolucoesPorId(@RequestParam("id") Long id) {
        return new ResponseEntity<List<EvolucaoSaidaDTO>>(PraticanteMapeador.converterListaDeEvolucaoParaListaDeEvolucaoSaidaDTO(evolucaoServico.listarTodasEvolucoesDoPraticante(id)), HttpStatus.OK);
    }

    @PostMapping ("/buscar-evolucao-do-praticante-por-intervalo-de-datas")
    public ResponseEntity<?> buscarEvolucaoPorIntervaloDeDatas(@RequestBody EvolucaoParaGraficoEntradaDTO evolucaoParaGraficoEntradaDTO) {
        return new ResponseEntity<EvolucaoParaGraficoSaidaDTO>(evolucaoServico.buscarEvolucaoPorIntervaloDeDatas(evolucaoParaGraficoEntradaDTO.getDataInicial(), evolucaoParaGraficoEntradaDTO.getDataFinal(), evolucaoParaGraficoEntradaDTO.getPraticante().getIdPraticante()), HttpStatus.OK);
    }


}
