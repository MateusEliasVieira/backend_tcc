package com.equoterapia.dominio.servico.praticante.avaliacaoFisioterapeutica;


import com.equoterapia.dominio.modelo.praticante.avaliacaoFisioterapeutica.AvaliacaoFisioterapeutica;

public interface AvaliacaoFisioterapeuticaServico {
    public AvaliacaoFisioterapeutica salvarAvaliacaoFisioterapeutica(AvaliacaoFisioterapeutica avaliacaoFisioterapeutica);
    public AvaliacaoFisioterapeutica atualizarAvaliacaoFisioterapeutica(AvaliacaoFisioterapeutica avaliacaoFisioterapeutica);
    public AvaliacaoFisioterapeutica buscarAvaliacaoFisioterapeuticaPorId(Long idAvaliacaoFisioterapeutica);
}
