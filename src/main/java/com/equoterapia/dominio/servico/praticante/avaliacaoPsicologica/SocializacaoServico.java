package com.equoterapia.dominio.servico.praticante.avaliacaoPsicologica;

import com.equoterapia.dominio.modelo.praticante.avaliacaoPsicologica.Socializacao;

public interface SocializacaoServico {

    public Socializacao salvarSocializacao(Socializacao socializacao);
    public Socializacao atualizarSocializacao(Socializacao socializacao);
    public Socializacao buscarSocializacaoPorId(Long idSocializacao);
}
