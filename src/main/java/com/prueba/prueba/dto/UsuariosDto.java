package com.prueba.prueba.dto;

import org.springframework.stereotype.Component;

import com.prueba.prueba.entity.Usuarios;

@Component
public class UsuariosDto {

    private Usuarios usuarios;

    public UsuariosDto() {
    }

    public UsuariosDto(Usuarios usuarios) {
        this.usuarios = usuarios;
    }

    public Usuarios getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(Usuarios usuarios) {
        this.usuarios = usuarios;
    }

    @Override
    public String toString() {
        return "UsuariosDto [usuarios=" + usuarios + "]";
    }

    

}
