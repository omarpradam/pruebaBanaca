package com.prueba.prueba.repository.service;

import com.prueba.prueba.entity.Usuarios;

public interface UsuariosRespositoryService {
   
	public Usuarios save(Usuarios Usuarios);
	public Usuarios searchByDocument(String document);
	public Usuarios deleteUsuarios(Usuarios Usuarios);
	

}
