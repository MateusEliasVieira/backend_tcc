package com.equoterapia.dominio.servico.praticante.avaliacaoFisioterapeutica;


import com.equoterapia.dominio.modelo.praticante.avaliacaoFisioterapeutica.QuadroAtual;

public interface QuadroAtualServico {
    public QuadroAtual salvarQuadroAtual(QuadroAtual quadroAtual);
    public QuadroAtual atualizarQuadroAtual(QuadroAtual quadroAtual);
    public QuadroAtual buscarQuadroAtualPorId(Long idQuadroAtual);
}
