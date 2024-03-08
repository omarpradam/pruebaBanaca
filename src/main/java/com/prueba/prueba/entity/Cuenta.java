package com.prueba.prueba.entity;

import java.math.BigDecimal;
import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="Cuentas")
public class Cuenta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tipoCuenta;
    private String numeroCuenta;
    private String estado;
    private BigDecimal saldo;
    private boolean exentaGmf;
    private Date fechaCreacion;
    private Date fechaModificacion;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuarios usuario;

    public Cuenta() {
        
    }

   
    
    public Cuenta(Long id, String tipoCuenta, String numeroCuenta, String estado, BigDecimal saldo, boolean exentaGmf,
            Date fechaCreacion, Date fechaModificacion, Usuarios usuario) {
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

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
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

    public Usuarios getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuarios usuario) {
        this.usuario = usuario;
    }



    @Override
    public String toString() {
        return "Cuenta [id=" + id + ", tipoCuenta=" + tipoCuenta + ", numeroCuenta=" + numeroCuenta + ", estado="
                + estado + ", saldo=" + saldo + ", exentaGmf=" + exentaGmf + ", fechaCreacion=" + fechaCreacion
                + ", fechaModificacion=" + fechaModificacion + ", usuario=" + usuario + "]";
    }

    

}
