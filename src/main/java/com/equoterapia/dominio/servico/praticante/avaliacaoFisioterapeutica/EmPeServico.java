package com.equoterapia.dominio.servico.praticante.avaliacaoFisioterapeutica;

import com.equoterapia.dominio.modelo.praticante.avaliacaoFisioterapeutica.EmPe;

public interface EmPeServico {
    public EmPe salvarEmPe(EmPe emPe);
    public EmPe atualizarEmPe(EmPe emPe);
    public EmPe buscarEmPePorId(Long idEmPe);
}
