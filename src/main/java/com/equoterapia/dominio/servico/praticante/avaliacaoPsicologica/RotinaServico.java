package com.equoterapia.dominio.servico.praticante.avaliacaoPsicologica;

import com.equoterapia.dominio.modelo.praticante.avaliacaoPsicologica.Rotina;

public interface RotinaServico {

    public Rotina salvarRotina(Rotina rotina);
    public Rotina atualizarRotina(Rotina rotina);
    public Rotina buscarRotinaPorId(Long idRotina);
}
