/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.refugiate.app.entidades;

import java.util.Date;

/**
 *
 * @author Paulo
 */
public class clsSucursal {
    private int idSucursal;
    private String direccion;
    private int pisos;
    private String telefono;
    private double longitud;
    private double latitud;
    private int limpieza;
    private int servicio;
    private int comodidad;
    private int puntuacion;
    private int nivel;
    private String entrada;
    private String salida;
    private Date fecha;
    private Date update;
    private int estado;
    private clsDistrito objDistrito;
    private clsEmpresa objEmpresa;

    public clsSucursal() {
    }

    public clsSucursal(int idSucursal) {
        this.idSucursal = idSucursal;
    }

    public int getIdSucursal() {
        return idSucursal;
    }

    public String getDireccion() {
        return direccion;
    }

    public int getPisos() {
        return pisos;
    }

    public String getTelefono() {
        return telefono;
    }

    public double getLongitud() {
        return longitud;
    }

    public double getLatitud() {
        return latitud;
    }

    public int getLimpieza() {
        return limpieza;
    }

    public int getServicio() {
        return servicio;
    }

    public int getComodidad() {
        return comodidad;
    }

    public int getPuntuacion() {
        return puntuacion;
    }

    public int getNivel() {
        return nivel;
    }

    public String getEntrada() {
        return entrada;
    }

    public String getSalida() {
        return salida;
    }

    public Date getFecha() {
        return fecha;
    }

    public int getEstado() {
        return estado;
    }

    public clsDistrito getObjDistrito() {
        return objDistrito;
    }

    public clsEmpresa getObjEmpresa() {
        return objEmpresa;
    }

    public void setIdSucursal(int idSucursal) {
        this.idSucursal = idSucursal;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setPisos(int pisos) {
        this.pisos = pisos;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }

    public void setLatitud(double latitud) {
        this.latitud = latitud;
    }

    public void setLimpieza(int limpieza) {
        this.limpieza = limpieza;
    }

    public void setServicio(int servicio) {
        this.servicio = servicio;
    }

    public void setComodidad(int comodidad) {
        this.comodidad = comodidad;
    }

    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public void setEntrada(String entrada) {
        this.entrada = entrada;
    }

    public void setSalida(String salida) {
        this.salida = salida;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public void setObjDistrito(clsDistrito objDistrito) {
        this.objDistrito = objDistrito;
    }

    public void setObjEmpresa(clsEmpresa objEmpresa) {
        this.objEmpresa = objEmpresa;
    }

    public Date getUpdate() {
        return update;
    }

    public void setUpdate(Date update) {
        this.update = update;
    }
    
}
