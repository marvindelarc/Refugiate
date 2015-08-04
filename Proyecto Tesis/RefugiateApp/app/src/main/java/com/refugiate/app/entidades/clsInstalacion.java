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
public class clsInstalacion {
    private int idInstalacion;
    private String descripcion;
    private clsServicio objServicio;
    private clsSucursal objSucursal;
    private int estado;
    private Date update;
    
    public clsInstalacion() {
    }

    public int getIdInstalacion() {
        return idInstalacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public clsServicio getObjServicio() {
        return objServicio;
    }

    public clsSucursal getObjSucursal() {
        return objSucursal;
    }

    public int getEstado() {
        return estado;
    }

    public void setIdInstalacion(int idInstalacion) {
        this.idInstalacion = idInstalacion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setObjServicio(clsServicio objServicio) {
        this.objServicio = objServicio;
    }

    public void setObjSucursal(clsSucursal objSucursal) {
        this.objSucursal = objSucursal;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public Date getUpdate() {
        return update;
    }

    public void setUpdate(Date update) {
        this.update = update;
    }
    
}
