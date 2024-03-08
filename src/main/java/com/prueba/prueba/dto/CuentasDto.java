package com.prueba.prueba.dto;

import org.springframework.stereotype.Component;

import com.prueba.prueba.entity.Cuenta;

@Component
public class CuentasDto {

    private Cuenta cuenta;

    public CuentasDto() {
    }

    public CuentasDto(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

    public Cuenta getCuenta() {
        return cuenta;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

    @Override
    public String toString() {
        return "CuentasDto [cuenta=" + cuenta + "]";
    }

}
