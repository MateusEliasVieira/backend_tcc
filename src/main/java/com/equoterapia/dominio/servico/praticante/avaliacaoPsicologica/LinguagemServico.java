package com.equoterapia.dominio.servico.praticante.avaliacaoPsicologica;

import com.equoterapia.dominio.modelo.praticante.avaliacaoPsicologica.Linguagem;

public interface LinguagemServico {

    public Linguagem salvarLinguagem(Linguagem linguagem);
    public Linguagem atualizarLinguagem(Linguagem linguagem);
    public Linguagem buscarLinguagemPorId(Long idLinguagem);
}
