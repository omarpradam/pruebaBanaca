package com.prueba.prueba.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.prueba.prueba.entity.Cuenta;


@Repository("CuentasRepository")
public interface CuentasRepository extends JpaRepository<Cuenta, Serializable> {

    Cuenta findByUsuario(String usuario);

    Cuenta findByNumeroCuenta(String numeroCuenta);

    // SELECT * FROM Cuentas WHERE usuario_id = '12345678' AND numero_cuenta =
    // '3315101039'
    @Query(value = "select p.* from cuentas p where p.usuario_id = :usuario and p.numero_cuenta = :numeroCuenta", nativeQuery = true)
    Cuenta findByUserCuenta(@Param("usuario") String usuario, @Param("numeroCuenta") String numeroCuenta);

}
