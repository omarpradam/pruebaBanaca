package com.prueba.prueba.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prueba.prueba.entity.Usuarios;

@Repository("UsuariosRepository")
public interface UsuariosRepository extends JpaRepository<Usuarios, Serializable> {

	Usuarios findByNumeroIdentificacion(String numeroIdentificacion);

}
