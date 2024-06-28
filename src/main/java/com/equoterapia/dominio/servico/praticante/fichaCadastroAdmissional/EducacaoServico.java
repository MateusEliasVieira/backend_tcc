package com.equoterapia.dominio.servico.praticante.fichaCadastroAdmissional;

import com.equoterapia.dominio.modelo.praticante.fichaCadastroAdmissional.EducacaoPraticante;

public interface EducacaoServico {

    public EducacaoPraticante salvarEducacaoPraticante(EducacaoPraticante educacaoPraticante);
    public EducacaoPraticante atualizarEducacaoPraticante(EducacaoPraticante educacaoPraticante);
    public EducacaoPraticante buscarEducacaoPraticante(Long idEducacaoPraticante);
}
