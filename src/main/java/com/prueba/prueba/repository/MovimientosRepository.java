package com.prueba.prueba.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prueba.prueba.entity.Movimientos;

@Repository("MovimientosRepository")
public interface MovimientosRepository extends JpaRepository<Movimientos, Serializable> {

    List <Movimientos> findByNumeroDocumento(String numeroDocumento);

}
