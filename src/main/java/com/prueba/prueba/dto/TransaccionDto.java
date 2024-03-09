package com.prueba.prueba.dto;

import org.springframework.stereotype.Component;

@Component
public class TransaccionDto {

    private String numeroDocumento;

    private String numeroCuentaDestino;

    private String numeroCuentaSalida;

    private String monto;

    private String movimiento;

    public TransaccionDto() {
    }

    public TransaccionDto(String numeroDocumento, String numeroCuentaDestino, String numeroCuentaSalida, String monto,
            String movimiento) {
        this.numeroDocumento = numeroDocumento;
        this.numeroCuentaDestino = numeroCuentaDestino;
        this.numeroCuentaSalida = numeroCuentaSalida;
        this.monto = monto;
        this.movimiento = movimiento;
    }

    public String getNumeroCuentaDestino() {
        return numeroCuentaDestino;
    }

    public void setNumeroCuentaDestino(String numeroCuentaDestino) {
        this.numeroCuentaDestino = numeroCuentaDestino;
    }

    public String getNumeroCuentaSalida() {
        return numeroCuentaSalida;
    }

    public void setNumeroCuentaSalida(String numeroCuentaSalida) {
        this.numeroCuentaSalida = numeroCuentaSalida;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public String getMonto() {
        return monto;
    }

    public void setMonto(String monto) {
        this.monto = monto;
    }

    public String getMovimiento() {
        return movimiento;
    }

    public void setMovimiento(String movimiento) {
        this.movimiento = movimiento;
    }

    @Override
    public String toString() {
        return "TransaccionDto [numeroDocumento=" + numeroDocumento + ", numeroCuentaDestino=" + numeroCuentaDestino
                + ", numeroCuentaSalida=" + numeroCuentaSalida + ", monto=" + monto + ", movimiento=" + movimiento
                + "]";
    }

}
