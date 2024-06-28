package com.equoterapia.api.controlador.praticante.fichaCadastroAdmissional;

import com.equoterapia.api.controlador.utilidades.Mensagem;
import com.equoterapia.api.dto.praticante.fichaCadastroAdmissional.OutrasAtividadesManhaEntradaDTO;
import com.equoterapia.api.mapeador.praticante.PraticanteMapeador;
import com.equoterapia.dominio.servico.praticante.fichaCadastroAdmissional.OutrasAtividadesManhaServico;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/praticante/outras-atividades-manha")
public class OutrasAtividadesManhaControlador {

    @Autowired
    private OutrasAtividadesManhaServico servico;
    @PostMapping("/salvar-outras-atividades-manha-do-praticante")
    public ResponseEntity<?> salvarOutrasAtividadesManha(@RequestBody @Valid OutrasAtividadesManhaEntradaDTO outrasAtividadesManhaEntradaDTO){
        servico.salvarOutrasAtividadesManha(PraticanteMapeador.converterOutrasAtividadesManhaEntradaDTOEmOutrasAtividadesManha(outrasAtividadesManhaEntradaDTO));
        return new ResponseEntity<Mensagem>(new Mensagem("Outras atividades da manhã salvas com sucesso!"), HttpStatus.CREATED);
    }

    @PutMapping("/atualizar-outras-atividades-manha-do-praticante")
    public ResponseEntity<?> atualizarOutrasAtividadesManha(OutrasAtividadesManhaEntradaDTO outrasAtividadesManhaEntradaDTO){
        servico.atualizarOutrasAtividadesManha(PraticanteMapeador.converterOutrasAtividadesManhaEntradaDTOEmOutrasAtividadesManha(outrasAtividadesManhaEntradaDTO));
        return new ResponseEntity<Mensagem>(new Mensagem("Outras atividades da manhã atualizadas com sucesso!"), HttpStatus.CREATED);
    }

    @GetMapping("/buscar-outras-atividades-manha-do-praticante-por-id")
    public ResponseEntity<?> buscarOutrasAtividadesManha(@RequestParam("id") Long id){

        return new ResponseEntity<>(PraticanteMapeador.converterOutrasAtividadesManhaEmOutrasAtividadesManhaSaidaDTO(servico.buscarOutrasAtividadesManhaPorId(id)), HttpStatus.CREATED);
    }
}
