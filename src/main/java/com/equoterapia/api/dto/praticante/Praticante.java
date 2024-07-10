package com.equoterapia.api.dto.praticante;

import com.equoterapia.api.dto.usuario.UsuarioEntradaDTO;
import com.equoterapia.dominio.modelo.praticante.avaliacaoFisioterapeutica.SaudeGeralDosPraticantes;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Praticante {

    private Long idPraticante;

    private SaudeGeralDosPraticantes saudeGeralDosPraticantes;

    private UsuarioEntradaDTO usuarioEntradaDTO;

}
