package com.equoterapia.api.dto.praticante;

import com.equoterapia.api.dto.praticante.avaliacaoFisioterapeutica.SaudeGeralDosPraticantes;
import com.equoterapia.api.dto.usuario.UsuarioInputDTO;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Praticante {

    private Long idPaciente;

    private SaudeGeralDosPraticantes saudeGeralDosPraticantes;

    private UsuarioInputDTO usuarioInputDTO;

}
