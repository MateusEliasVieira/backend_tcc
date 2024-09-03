package com.equoterapia.dominio.servico.praticante.paginacao;

import com.equoterapia.api.dto.praticante.paginacao.PraticantePaginacaoComDadosDTO;
import com.equoterapia.api.dto.praticante.paginacao.PraticantePaginacaoDTO;
import com.equoterapia.dominio.modelo.praticante.fichaCadastroAdmissional.DadosPessoais;
import org.springframework.data.domain.Page;

public interface PraticantePaginacaoServico {

    public PraticantePaginacaoComDadosDTO buscarPraticantesPorPaginas(int pagina);

    public PraticantePaginacaoDTO quantidadeTotalDePraticantes();
}
