package com.equoterapia.dominio.servico.paciente.fichaCadastroAdmissional.impl;

import com.equoterapia.dominio.excecaoDeDominio.ExcecaoDeRegrasDeNegocio;
import com.equoterapia.dominio.modelo.praticante.fichaCadastroAdmissional.EducacaoPraticante;
import com.equoterapia.dominio.repositorio.praticante.PraticanteRepositorio;
import com.equoterapia.dominio.repositorio.praticante.fichaCadastroAdmissional.EducacaoPraticanteRepositorio;
import com.equoterapia.dominio.servico.paciente.fichaCadastroAdmissional.EducacaoPraticanteServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EducacaoPacienteServicoImplementacao implements EducacaoPraticanteServico {

    @Autowired
    private EducacaoPraticanteRepositorio educacaoPraticanteRepositorio;

    @Autowired
    private PraticanteRepositorio praticanteRepositorio;

    @Override
    public EducacaoPraticante salvarEducacaoPaciente(EducacaoPraticante educacaoPraticante) {
        try {
            if(educacaoPraticante.getPraticante().getIdPaciente() != null) {
                // passou o id do paciente
                praticanteRepositorio.findById(
                        educacaoPraticante.getPraticante().getIdPaciente()).orElseThrow(
                        () -> new ExcecaoDeRegrasDeNegocio("Não foi encontrado o praticante de id "
                                + educacaoPraticante.getPraticante().getIdPaciente() +
                                " vinculado a essa educação fornecida!"));


                return educacaoPraticanteRepositorio.save(educacaoPraticante);

            } else {
                throw new ExcecaoDeRegrasDeNegocio("É preciso informar o id do paciente, que é dono da educação informada!");
            }
            }catch (Exception e){
                throw new ExcecaoDeRegrasDeNegocio("Houve um erro ao salvar os dados da educação para o devido praticante!");
            }
    }

    @Override
    public EducacaoPraticante atualizarEducacaoPaciente(EducacaoPraticante educacaoPraticante) {
        praticanteRepositorio.findById(educacaoPraticante.getPraticante().getIdPaciente()).orElseThrow(() -> new ExcecaoDeRegrasDeNegocio("Não existe nenhum praticante com id "+ educacaoPraticante.getPraticante().getIdPaciente()+"!"));
        Optional<EducacaoPraticante> educacaoPacienteExistente = educacaoPraticanteRepositorio.findById(educacaoPraticante.getIdEducacaoPaciente());
        if (educacaoPacienteExistente.isPresent()) {
            educacaoPraticante.setIdEducacaoPaciente(educacaoPacienteExistente.get().getIdEducacaoPaciente());
            return educacaoPraticanteRepositorio.save(educacaoPraticante);
        } else {
            throw new ExcecaoDeRegrasDeNegocio("Não existe registros sobre a educação do praticante cadastrado no sistema!");
        }
    }

    @Override
    public EducacaoPraticante buscarEducacaoPaciente(Long idEducacaoPaciente) {
        return educacaoPraticanteRepositorio.findById(idEducacaoPaciente).orElseThrow(() -> new ExcecaoDeRegrasDeNegocio("Não foi encontrado a educação do paciente com id = " + idEducacaoPaciente + "!"));
    }

}
