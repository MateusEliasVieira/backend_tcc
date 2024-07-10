package com.equoterapia.dominio.servico.praticante.avaliacaoFisioterapeutica;

import com.equoterapia.dominio.modelo.praticante.avaliacaoFisioterapeutica.EquilibrioEstatico;

public interface EquilibrioEstaticoServico {
    public EquilibrioEstatico salvarEquilibrioEstatico(EquilibrioEstatico equilibrioEstatico);

    public EquilibrioEstatico atualizarEquilibrioEstatico(EquilibrioEstatico equilibrioEstatico);

    public EquilibrioEstatico buscarEquilibrioEstaticoPorId(Long idEquilibrioEstatico);
}
