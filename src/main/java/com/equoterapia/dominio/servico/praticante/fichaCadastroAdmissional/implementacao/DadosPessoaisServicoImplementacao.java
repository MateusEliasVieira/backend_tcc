package com.equoterapia.dominio.servico.praticante.fichaCadastroAdmissional.implementacao;


import com.equoterapia.dominio.excecaoDeDominio.ExcecaoDeRegrasDeNegocio;
import com.equoterapia.dominio.modelo.praticante.Praticante;
import com.equoterapia.dominio.modelo.praticante.fichaCadastroAdmissional.DadosPessoais;
import com.equoterapia.dominio.modelo.praticante.fichaCadastroAdmissional.FichaCadastroAdmissional;
import com.equoterapia.dominio.repositorio.praticante.PraticanteRepositorio;
import com.equoterapia.dominio.repositorio.praticante.fichaCadastroAdmissional.DadosPessoaisRepositorio;
import com.equoterapia.dominio.servico.praticante.fichaCadastroAdmissional.DadosPessoaisServico;
import com.equoterapia.dominio.servico.praticante.fichaCadastroAdmissional.FichaCadastroAdmissionalServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


@Service
public class DadosPessoaisServicoImplementacao implements DadosPessoaisServico {

    @Autowired
    private PraticanteRepositorio praticanteRepositorio;

    @Autowired
    private DadosPessoaisRepositorio dadosPessoaisRepositorio;

    @Autowired
    private FichaCadastroAdmissionalServico fichaCadastroAdmissionalServico;

    @Override
    public DadosPessoais salvarDadosPessoais(DadosPessoais dadosPessoais) {

        if (dadosPessoaisRepositorio.findByCpf(dadosPessoais.getCpf()).isPresent()) {

            throw new ExcecaoDeRegrasDeNegocio("O praticante com CPF "
                    + dadosPessoais.getCpf() + " já está cadastrado no sistema!");

        } else if (dadosPessoaisRepositorio.findByCartaoSUS(dadosPessoais.getCartaoSUS()).isPresent()) {

            throw new ExcecaoDeRegrasDeNegocio("O praticante com cartão do SUS "
                    + dadosPessoais.getCartaoSUS()
                    + " já está cadastrado no sistema!");

        } else {
            Praticante praticante = new Praticante();
            praticante = praticanteRepositorio.save(praticante);
            dadosPessoais.setPraticante(praticante);
            FichaCadastroAdmissional fichaCadastroAdmissional = new FichaCadastroAdmissional();
            fichaCadastroAdmissional.setPraticante(praticante);
            fichaCadastroAdmissional.setDataAvaliacao(new Date());
            if (fichaCadastroAdmissionalServico.salvarFichaCadastroAdmissional(fichaCadastroAdmissional) != null) {
                return dadosPessoaisRepositorio.save(dadosPessoais);
            } else {
                throw new ExcecaoDeRegrasDeNegocio("Houve um erro ao salvar os dados pessoais do praticante!");
            }
        }

    }

    @Override
    public DadosPessoais atualizarDadosPessoais(DadosPessoais dadosPessoais) {
        try {
            if (dadosPessoais.getIdDadosPessoais() != null) {

                praticanteRepositorio.findById(dadosPessoais
                                .getPraticante()
                                .getIdPraticante())
                        .orElseThrow(() -> new ExcecaoDeRegrasDeNegocio("Não foi possível atualizar, pois não existe o praticante referente aos dados pessoais!"));

                if (dadosPessoaisRepositorio.findById(dadosPessoais.getIdDadosPessoais()).isPresent()) {

                    if (dadosPessoaisRepositorio.findByCpf(dadosPessoais.getCpf()).get().getIdDadosPessoais() != dadosPessoais.getIdDadosPessoais()) {
                        // cadastros diferentes
                        throw new ExcecaoDeRegrasDeNegocio("Já existe outro registro que possui o cpf " + dadosPessoais.getCpf());
                    } else if (dadosPessoaisRepositorio.findByCartaoSUS(dadosPessoais.getCartaoSUS()).get().getIdDadosPessoais() != dadosPessoais.getIdDadosPessoais()) {
                        // cadastros diferentes
                        throw new ExcecaoDeRegrasDeNegocio("Já existe outro registro que possui o cartão do SUS " + dadosPessoais.getCartaoSUS());
                    } else {
                        return dadosPessoaisRepositorio.save(dadosPessoais);
                    }
                } else {
                    throw new ExcecaoDeRegrasDeNegocio("Não foi possível atualizar, pois não existe o cadastro de dados pessoais!");
                }
            } else {
                throw new ExcecaoDeRegrasDeNegocio("Não foi possível atualizar os dados pessoais, pois não foi possível encontra-lo!");
            }
        } catch (Exception e) {
            throw new ExcecaoDeRegrasDeNegocio("Não foi possível realizar a atualização do cadastro!");
        }
    }

    @Override
    public DadosPessoais buscarDadosPessoaisPorID(Long idDadosPessoais) {
        return dadosPessoaisRepositorio.findById(idDadosPessoais).orElseThrow(() -> new ExcecaoDeRegrasDeNegocio("Dados pessoais do praticante não encontrado!"));
    }

    @Override
    public DadosPessoais buscarDadosPessoaisPorCPF(String cpf) {
        return dadosPessoaisRepositorio.findByCpf(cpf).orElseThrow(() -> new ExcecaoDeRegrasDeNegocio("Não existe nenhum praticante cadastrado no sistema com o cpf " + cpf));
    }

    @Override
    public List<DadosPessoais> buscarDadosPessoaisDosPraticantes() {
        return dadosPessoaisRepositorio.findAll();
    }

    @Override
    public List<DadosPessoais> buscarDadosPessoaisPorNome(String nome) {
        if (nome.isEmpty()) {
            return buscarDadosPessoaisDosPraticantes();
        }
        return dadosPessoaisRepositorio.findByNomeCompleto(nome);
    }

}
