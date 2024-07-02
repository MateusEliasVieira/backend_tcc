package com.equoterapia.dominio.servico.praticante.fichaCadastroAdmissional;

import com.equoterapia.dominio.modelo.praticante.fichaCadastroAdmissional.ResponsavelPraticante;

import java.util.Optional;

public interface ResponsavelPraticanteServico {

    public ResponsavelPraticante salvar(ResponsavelPraticante responsavelPraticante);
    public ResponsavelPraticante atualizar(ResponsavelPraticante responsavelPraticante);
    public ResponsavelPraticante buscarPorId(Long idResponsavelPraticante);
    public Optional<ResponsavelPraticante> buscarPorEmail(String email);
}
