package com.prueba.prueba.repository.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prueba.prueba.entity.Usuarios;
import com.prueba.prueba.repository.UsuariosRepository;
import com.prueba.prueba.repository.service.UsuariosRespositoryService;

@Service("UsuariosRepositoryServiceImpl")
public class UsuariosRepositoryServiceImpl implements UsuariosRespositoryService {

    @Autowired
    private UsuariosRepository usuariosRepository;

    @Override
    public Usuarios save(Usuarios Usuarios) {
        return usuariosRepository.save(Usuarios);
    }

    @Override
    public Usuarios searchByDocument(String document) {
        Usuarios userTem = usuariosRepository.findByNumeroIdentificacion(document);
        return userTem;
    }

    @Override
    public Usuarios deleteUsuarios(Usuarios Usuarios) {
        usuariosRepository.delete(Usuarios);
        return null;
    }

}
