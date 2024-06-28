package com.equoterapia.dominio.servico.praticante.fichaCadastroAdmissional.impl;

import com.equoterapia.dominio.excecaoDeDominio.ExcecaoDeRegrasDeNegocio;
import com.equoterapia.dominio.modelo.praticante.fichaCadastroAdmissional.Emergencia;
import com.equoterapia.dominio.repositorio.praticante.PraticanteRepositorio;
import com.equoterapia.dominio.repositorio.praticante.fichaCadastroAdmissional.EmergenciaRepositorio;
import com.equoterapia.dominio.servico.praticante.fichaCadastroAdmissional.EmergenciaServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmergenciaServicoImplementacao implements EmergenciaServico {

    @Autowired
    private EmergenciaRepositorio emergenciaRepositorio;

    @Autowired
    private PraticanteRepositorio praticanteRepositorio;

    @Override
    public Emergencia salvarEmergencia(Emergencia emergencia) {
        praticanteRepositorio.findById(emergencia.getPraticante().getIdPraticante()).orElseThrow(() -> new ExcecaoDeRegrasDeNegocio("Não existe nenhum praticante com id "+emergencia.getPraticante().getIdPraticante()+"!"));
        Optional<Emergencia> optional = emergenciaRepositorio.findByTelefone(emergencia.getTelefone());
        if(optional.isPresent()){
            throw new ExcecaoDeRegrasDeNegocio("Já existe um registro de emergência com esse telefone "+emergencia.getTelefone()+" para o praticante!");
        }else{
            return emergenciaRepositorio.save(emergencia);
        }
    }

    @Override
    public Emergencia atualizarEmergencia(Emergencia emergencia) { // id obrigatório
        praticanteRepositorio.findById(emergencia.getPraticante().getIdPraticante()).orElseThrow(() -> new ExcecaoDeRegrasDeNegocio("Não existe nenhum praticante com id "+emergencia.getPraticante().getIdPraticante()+"!"));
        if(emergencia.getIdEmergencia() != null){
            Optional<Emergencia> optional = emergenciaRepositorio.findById(emergencia.getIdEmergencia());
            if(optional.isPresent()){
                return emergenciaRepositorio.save(emergencia);
            }else{
                throw new ExcecaoDeRegrasDeNegocio("Não foi encontrado um registro de emergência com id "+emergencia.getIdEmergencia()+"!");
            }
        }else{
            throw new ExcecaoDeRegrasDeNegocio("O id do registro de emergência deve ser informado "+emergencia.getIdEmergencia()+"!");
        }
    }

    @Override
    public Emergencia buscarEmergencia(Long id_emergencia) {
        return emergenciaRepositorio.findById(id_emergencia).orElseThrow(()-> new ExcecaoDeRegrasDeNegocio("Não foi encontrado um registro de emergência com id "+id_emergencia+"!"));
    }

}
