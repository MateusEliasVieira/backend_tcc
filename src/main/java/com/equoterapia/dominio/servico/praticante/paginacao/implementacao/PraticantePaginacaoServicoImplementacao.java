package com.equoterapia.dominio.servico.praticante.paginacao.implementacao;

import com.equoterapia.api.dto.praticante.fichaCadastroAdmissional.DadosPessoaisSaidaDTO;
import com.equoterapia.api.dto.praticante.paginacao.PraticantePaginacaoComDadosDTO;
import com.equoterapia.api.dto.praticante.paginacao.PraticantePaginacaoDTO;
import com.equoterapia.dominio.modelo.praticante.fichaCadastroAdmissional.DadosPessoais;
import com.equoterapia.dominio.repositorio.praticante.paginacao.PraticantePaginacaoRepositorio;
import com.equoterapia.dominio.servico.praticante.paginacao.PraticantePaginacaoServico;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class PraticantePaginacaoServicoImplementacao implements PraticantePaginacaoServico {

    private final int ITENS_POR_PAGINA = 5; // 5 registros por página

    @Autowired
    private PraticantePaginacaoRepositorio repositorio;

    @Override
    public PraticantePaginacaoComDadosDTO buscarPraticantesPorPaginas(int pagina) {
        ModelMapper modelMapper = new ModelMapper();
        List<DadosPessoaisSaidaDTO> lista = new ArrayList<>();
        int totalPraticantes = quantidadeTotalDePraticantes().getQuantidade();
        int quantidadePaginas = totalPraticantes / ITENS_POR_PAGINA;
        int inicio = ((pagina * ITENS_POR_PAGINA) - ITENS_POR_PAGINA);
        List<DadosPessoais> resultado = repositorio.buscarPraticantesPorPagina(ITENS_POR_PAGINA, inicio);
        for (DadosPessoais dp : resultado) {
            lista.add(modelMapper.map(dp, DadosPessoaisSaidaDTO.class));
        }

        PraticantePaginacaoComDadosDTO ppdd = new PraticantePaginacaoComDadosDTO();
        ppdd.setDadosPessoais(lista);
        ppdd.setTotalDePraticantes(totalPraticantes);
        ppdd.setPaginaSelecionada(pagina);
        ppdd.setQuantidadePaginas(quantidadePaginas);

        return ppdd;
    }

    @Override
    public PraticantePaginacaoDTO quantidadeTotalDePraticantes() {
        PraticantePaginacaoDTO ppd = new PraticantePaginacaoDTO();
        ppd.setQuantidade(repositorio.quantidadeTotalDePraticantes());
        return ppd;
    }


}
