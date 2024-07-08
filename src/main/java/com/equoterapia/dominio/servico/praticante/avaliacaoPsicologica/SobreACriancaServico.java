package com.equoterapia.dominio.servico.praticante.avaliacaoPsicologica;


import com.equoterapia.dominio.modelo.praticante.avaliacaoPsicologica.SobreACrianca;

public interface SobreACriancaServico {
    public SobreACrianca salvarSobreACrianca(SobreACrianca sobreACrianca);
    public SobreACrianca atualizarSobreACrianca(SobreACrianca sobreACrianca);
    public SobreACrianca buscarSobreACriancaPorId(Long idSobreACrianca);
}
