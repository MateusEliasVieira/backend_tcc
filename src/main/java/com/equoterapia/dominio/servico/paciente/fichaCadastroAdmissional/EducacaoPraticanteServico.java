package com.equoterapia.dominio.servico.paciente.fichaCadastroAdmissional;

import com.equoterapia.dominio.modelo.praticante.fichaCadastroAdmissional.EducacaoPraticante;

public interface EducacaoPraticanteServico {

    public EducacaoPraticante salvarEducacaoPaciente(EducacaoPraticante educacaoPraticante);
    public EducacaoPraticante atualizarEducacaoPaciente(EducacaoPraticante educacaoPraticante);
    public EducacaoPraticante buscarEducacaoPaciente(Long idEducacaoPaciente);
}
