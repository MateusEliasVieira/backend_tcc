package com.equoterapia.api.mapeador;

import com.equoterapia.api.dto.login.LoginEntradaDTO;
import com.equoterapia.api.dto.login.LoginSaidaDTO;
import com.equoterapia.dominio.modelo.usuario.Usuario;
import org.modelmapper.ModelMapper;

public class LoginMapeador
{

    public static Usuario mapperLoginInputDTOParaUsuario(LoginEntradaDTO loginEntradaDTO)
    {
        ModelMapper mapper = new ModelMapper();
        return mapper.map(loginEntradaDTO, Usuario.class);
    }

    public static LoginSaidaDTO mapperUsuarioParaLoginOutputDTO(Usuario usuario){
        ModelMapper mapper = new ModelMapper();
        return mapper.map(usuario, LoginSaidaDTO.class);
    }
}
