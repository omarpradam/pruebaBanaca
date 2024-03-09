package com.prueba.prueba.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Movimientos")
public class Movimientos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "numero_cuenta")
    private String numeroCuenta;

    @Column(name = "tipo_movimiento")
    private String tipoMovimiento;

    @Column(name = "saldo")
    private String monto;

    @Column(name = "saldo_actual")
    private String saldoActual;

    @Column(name = "fecha_movimiento")
    private Date fechaMovimiento;

    @Column(name = "usuario_id")
    private String numeroDocumento;

    public Movimientos() {
    }

    public Movimientos(Long id, String numeroCuenta, String tipoMovimiento, String monto, String saldoActual,
            Date fechaMovimiento, String numeroDocumento) {
        this.id = id;
        this.numeroCuenta = numeroCuenta;
        this.tipoMovimiento = tipoMovimiento;
        this.monto = monto;
        this.saldoActual = saldoActual;
        this.fechaMovimiento = fechaMovimiento;
        this.numeroDocumento = numeroDocumento;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public void setTipoMovimiento(String tipoMovimiento) {
        this.tipoMovimiento = tipoMovimiento;
    }

    public void setFechaMovimiento(Date fechaMovimiento) {
        this.fechaMovimiento = fechaMovimiento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public Long getId() {
        return id;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public String getTipoMovimiento() {
        return tipoMovimiento;
    }

    public Date getFechaMovimiento() {
        return fechaMovimiento;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public String getMonto() {
        return monto;
    }

    public void setMonto(String monto) {
        this.monto = monto;
    }

    public String getSaldoActual() {
        return saldoActual;
    }

    public void setSaldoActual(String saldoActual) {
        this.saldoActual = saldoActual;
    }

    @Override
    public String toString() {
        return "Movimientos [id=" + id + ", numeroCuenta=" + numeroCuenta + ", tipoMovimiento=" + tipoMovimiento
                + ", monto=" + monto + ", saldoActual=" + saldoActual + ", fechaMovimiento=" + fechaMovimiento
                + ", numeroDocumento=" + numeroDocumento + "]";
    }

}
