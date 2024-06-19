package com.equoterapia.api.mapper;

import com.equoterapia.api.dto.login.LoginInputDTO;
import com.equoterapia.api.dto.login.LoginOutputDTO;
import com.equoterapia.domain.model.usuario.Usuario;
import org.modelmapper.ModelMapper;

public class LoginMapper
{

    public static Usuario mapperLoginInputDTOParaUsuario(LoginInputDTO loginInputDTO)
    {
        ModelMapper mapper = new ModelMapper();
        return mapper.map(loginInputDTO, Usuario.class);
    }

    public static LoginOutputDTO mapperUsuarioParaLoginOutputDTO(Usuario usuario){
        ModelMapper mapper = new ModelMapper();
        return mapper.map(usuario,LoginOutputDTO.class);
    }
}
