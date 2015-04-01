/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.util.Date;

/**
 *
 * @author Paulo
 */
public class clsPromociones {
    private int idPromociones;
    private String dato;
    private Date fechaInicio;
    private Date fechaFin;
    private int estado;
    private clsSucursal objSucursal;

    public clsPromociones() {
    }

    public int getIdPromociones() {
        return idPromociones;
    }

    public String getDato() {
        return dato;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public int getEstado() {
        return estado;
    }

    public clsSucursal getObjSucursal() {
        return objSucursal;
    }

    public void setIdPromociones(int idPromociones) {
        this.idPromociones = idPromociones;
    }

    public void setDato(String dato) {
        this.dato = dato;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public void setObjSucursal(clsSucursal objSucursal) {
        this.objSucursal = objSucursal;
    }
}
