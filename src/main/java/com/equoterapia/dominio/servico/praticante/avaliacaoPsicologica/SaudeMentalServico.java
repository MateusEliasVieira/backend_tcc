package com.equoterapia.dominio.servico.praticante.avaliacaoPsicologica;


import com.equoterapia.dominio.modelo.praticante.avaliacaoPsicologica.SaudeMental;

public interface SaudeMentalServico {
    public SaudeMental salvarSaudeMental(SaudeMental saudeMental);
    public SaudeMental atualizarSaudeMental(SaudeMental saudeMental);
    public SaudeMental buscarSaudeMentalPorId(Long idSaudeMental);
}
