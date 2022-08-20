package com.apirest.api.models;

import javax.persistence.*;

//se declaran las columnas y variables utilizadas. Generamos los getters y setters en la tabla accounts
@Entity
@Table(name = "accounts")
public class CuentaModel{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true,nullable = false)
    private Long id_cuenta; //numero de cuenta
    private String nombre_cliente;
    private Double saldo_cuenta;
    private boolean estado_cuenta;

    public CuentaModel(){

    }

    public CuentaModel(long id_cuenta, String nombre_cliente, Double saldo_cuenta, boolean estado_cuenta){
        this.id_cuenta = id_cuenta;
        this.nombre_cliente = nombre_cliente;
        this.saldo_cuenta = saldo_cuenta;
        this.estado_cuenta = estado_cuenta;
    }

    public CuentaModel(String nombre_cliente, Double saldo_cuenta, boolean estado_cuenta){
        this.nombre_cliente = nombre_cliente;
        this.saldo_cuenta = saldo_cuenta;
        this.estado_cuenta = estado_cuenta;
    }

    public CuentaModel(String nombre_cliente, Double saldo_cuenta){
        this.nombre_cliente = nombre_cliente;
        this.saldo_cuenta = saldo_cuenta;
    }

    public CuentaModel(Double saldo_cuenta){
        this.saldo_cuenta = saldo_cuenta;
    }

    public boolean isEstado_cuenta() {
        return estado_cuenta;
    }

    public void setEstado_cuenta(boolean isEstado_cuenta) {
        this.estado_cuenta = isEstado_cuenta;
    }

    public long getId_cuenta() {
        return this.id_cuenta;
    }

    public void setId_cuenta(long id_cuenta) {
        this.id_cuenta = id_cuenta;
    }

    public String getNombre_cliente() {
        return this.nombre_cliente;
    }

    public void setNombre_cliente(String nombre_cliente) {
        this.nombre_cliente = nombre_cliente;
    }

    public Double getSaldo_cuenta() {
        return this.saldo_cuenta;
    }

    public void setSaldo_cuenta(Double saldo_cuenta) {
        this.saldo_cuenta = saldo_cuenta;
    }

    @Override
     public String toString() {
         return "CuentaModel [id_cuenta=" + id_cuenta + ", nombre_cliente=" + nombre_cliente + ", saldo_cuenta=" + saldo_cuenta + ", estado_cuenta=" + estado_cuenta + "]";
     }

}