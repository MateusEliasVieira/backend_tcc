package com.equoterapia.dominio.servico.praticante.avaliacaoPsicologica;

import com.equoterapia.dominio.modelo.praticante.avaliacaoPsicologica.AvaliacaoPsicologica;

public interface AvaliacaoPsicologicaServico {
    public AvaliacaoPsicologica salvarAvaliacaoPsicologica(AvaliacaoPsicologica avaliacaoPsicologica);
    public AvaliacaoPsicologica atualizarAvaliacaoPsicologica(AvaliacaoPsicologica avaliacaoPsicologica);
    public AvaliacaoPsicologica buscarAvaliacaoPsicologicaPorId(Long idAvaliacaoPsicologica);
}
