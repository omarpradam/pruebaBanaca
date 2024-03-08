package com.prueba.prueba.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "cuentas")
public class Cuenta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "tipo_cuenta")
    private String tipoCuenta;
    @Column(name = "numero_cuenta")
    private String numeroCuenta;
    @Column(name = "estado")
    private String estado;
    @Column(name = "saldo")
    private Float saldo;
    @Column(name = "exenta_gmf")
    private boolean exentaGmf;
    @Column(name = "fecha_creacion")
    private Date fechaCreacion;
    @Column(name = "fecha_modificacion")
    private Date fechaModificacion;
    @Column(name = "usuario_id")
    private String usuario;

    public Cuenta() {

    }

    public Cuenta(Long id, String tipoCuenta, String numeroCuenta, String estado, Float saldo, boolean exentaGmf,
            Date fechaCreacion, Date fechaModificacion, String usuario) {
        this.id = id;
        this.tipoCuenta = tipoCuenta;
        this.numeroCuenta = numeroCuenta;
        this.estado = estado;
        this.saldo = saldo;
        this.exentaGmf = exentaGmf;
        this.fechaCreacion = fechaCreacion;
        this.fechaModificacion = fechaModificacion;
        this.usuario = usuario;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipoCuenta() {
        return tipoCuenta;
    }

    public void setTipoCuenta(String tipoCuenta) {
        this.tipoCuenta = tipoCuenta;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Float getSaldo() {
        return saldo;
    }

    public void setSaldo(Float saldo) {
        this.saldo = saldo;
    }

    public boolean isExentaGmf() {
        return exentaGmf;
    }

    public void setExentaGmf(boolean exentaGmf) {
        this.exentaGmf = exentaGmf;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Date getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(Date fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    @Override
    public String toString() {
        return "Cuenta [id=" + id + ", tipoCuenta=" + tipoCuenta + ", numeroCuenta=" + numeroCuenta + ", estado="
                + estado + ", saldo=" + saldo + ", exentaGmf=" + exentaGmf + ", fechaCreacion=" + fechaCreacion
                + ", fechaModificacion=" + fechaModificacion + ", usuario=" + usuario + "]";
    }

}
