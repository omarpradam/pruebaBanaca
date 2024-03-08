package com.prueba.prueba.usuarios.infrastructure;

import com.prueba.prueba.dto.ResponsDto;
import com.prueba.prueba.dto.UsuariosDto;

public interface IUsuariosService {

    public ResponsDto createUser( UsuariosDto usuariosDto) throws Exception;
	
	public ResponsDto updateUser(UsuariosDto usuariosDto) throws Exception;
	
	public ResponsDto deleteUser(UsuariosDto usuariosDto)throws Exception;

}
