package com.equoterapia.dominio.servico.praticante.avaliacaoFisioterapeutica;
import com.equoterapia.dominio.modelo.praticante.avaliacaoFisioterapeutica.EquilibrioDinamico;

public interface EquilibrioDinamicoServico {
    public EquilibrioDinamico salvarEquilibrioDinamico(EquilibrioDinamico equilibrioDinamico);

    public EquilibrioDinamico atualizarEquilibrioDinamico(EquilibrioDinamico equilibrioDinamico);

    public EquilibrioDinamico buscarEquilibrioDinamicoPorId(Long idEquilibrioDinamico);
}
