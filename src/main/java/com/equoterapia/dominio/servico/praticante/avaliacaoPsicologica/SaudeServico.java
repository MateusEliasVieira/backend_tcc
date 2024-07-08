package com.equoterapia.dominio.servico.praticante.avaliacaoPsicologica;


import com.equoterapia.dominio.modelo.praticante.avaliacaoPsicologica.Saude;

public interface SaudeServico {
    public Saude salvarSaude(Saude saude);
    public Saude atualizarSaude(Saude saude);
    public Saude buscarSaudePorId(Long idSaude);
}
