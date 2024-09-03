package com.equoterapia.api.dto.praticante.paginacao;

import com.equoterapia.api.dto.praticante.fichaCadastroAdmissional.DadosPessoaisSaidaDTO;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PraticantePaginacaoComDadosDTO {

    List<DadosPessoaisSaidaDTO> dadosPessoais;
    private int paginaSelecionada;
    private int quantidadePaginas;
    private int totalDePraticantes;

}
