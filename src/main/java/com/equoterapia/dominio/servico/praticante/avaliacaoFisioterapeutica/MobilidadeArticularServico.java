package com.equoterapia.dominio.servico.praticante.avaliacaoFisioterapeutica;

import com.equoterapia.dominio.modelo.praticante.avaliacaoFisioterapeutica.MobilidadeArticular;

public interface MobilidadeArticularServico {
    public MobilidadeArticular salvarMobilidadeArticular(MobilidadeArticular mobilidadeArticular);
    public MobilidadeArticular atualizarMobilidadeArticular(MobilidadeArticular mobilidadeArticular);
    public MobilidadeArticular buscarMobilidadeArticularPorId(Long idMobilidadeArticular);
}
