package com.equoterapia.dominio.servico.praticante.avaliacaoFisioterapeutica;


import com.equoterapia.dominio.modelo.praticante.avaliacaoFisioterapeutica.SaudeGeralDoPraticante;

public interface SaudeGeralDosPraticantesServico {
    public SaudeGeralDoPraticante salvarSaudeGeralDosPraticantes(SaudeGeralDoPraticante saudeGeralDoPraticante);
    public SaudeGeralDoPraticante atualizarSaudeGeralDosPraticantes(SaudeGeralDoPraticante saudeGeralDoPraticante);
    public SaudeGeralDoPraticante buscarSaudeGeralDosPraticantesPorId(Long idSaudeGeralDosPraticantes);
}
