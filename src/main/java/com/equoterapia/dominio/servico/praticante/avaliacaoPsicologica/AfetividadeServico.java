package com.equoterapia.dominio.servico.praticante.avaliacaoPsicologica;

import com.equoterapia.dominio.modelo.praticante.avaliacaoPsicologica.Afetividade;

public interface AfetividadeServico {

    public Afetividade salvarAfetividade(Afetividade afetividade);
    public Afetividade atualizarAfetividade(Afetividade afetividade);
    public Afetividade buscarAfetividadePorId(Long idAfetividade);
}
