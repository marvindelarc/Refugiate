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
public class clsReserva {
    private int idReserva;
    private  Date fechaResgistro;
    private int estado;
    private clsSucursal objSucursal;
    private clsPersona objPersona;

    public clsReserva() {
    }

    public int getIdReserva() {
        return idReserva;
    }

    public Date getFechaResgistro() {
        return fechaResgistro;
    }

    public int getEstado() {
        return estado;
    }

    public clsSucursal getObjSucursal() {
        return objSucursal;
    }

    public clsPersona getObjPersona() {
        return objPersona;
    }

    public void setIdReserva(int idReserva) {
        this.idReserva = idReserva;
    }

    public void setFechaResgistro(Date fechaResgistro) {
        this.fechaResgistro = fechaResgistro;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public void setObjSucursal(clsSucursal objSucursal) {
        this.objSucursal = objSucursal;
    }

    public void setObjPersona(clsPersona objPersona) {
        this.objPersona = objPersona;
    }
}
