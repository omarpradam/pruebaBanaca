package com.prueba.prueba.dto;

import org.springframework.stereotype.Component;

@Component
public class EstadoDto {

    private String numeroCuenta;
    private String saldo;
    private String estado;

    public EstadoDto() {
    }

    public EstadoDto(String numeroCuenta, String saldo, String estado) {
        this.numeroCuenta = numeroCuenta;
        this.saldo = saldo;
        this.estado = estado;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public String getSaldo() {
        return saldo;
    }

    public void setSaldo(String saldo) {
        this.saldo = saldo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "EstadoDto [numeroCuenta=" + numeroCuenta + ", saldo=" + saldo + ", estado=" + estado + "]";
    }

}
