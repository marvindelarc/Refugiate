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
public class clsPagoEmpresa {
    private int idPagoEmpresa;
    private clsEmpresa objEmpresa;
    private clsPaquete objPaquete;
    private double monto;
    private byte[] baucher;
    private Date fechaRegistro;
    private Date fechaInicio;
    private Date fechaFin;
    private int estado;

    public clsPagoEmpresa() {
    }

    public int getIdPagoEmpresa() {
        return idPagoEmpresa;
    }

    public clsEmpresa getObjEmpresa() {
        return objEmpresa;
    }

    public clsPaquete getObjPaquete() {
        return objPaquete;
    }

    public double getMonto() {
        return monto;
    }

    public byte[] getBaucher() {
        return baucher;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
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

    public void setIdPagoEmpresa(int idPagoEmpresa) {
        this.idPagoEmpresa = idPagoEmpresa;
    }

    public void setObjEmpresa(clsEmpresa objEmpresa) {
        this.objEmpresa = objEmpresa;
    }

    public void setObjPaquete(clsPaquete objPaquete) {
        this.objPaquete = objPaquete;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public void setBaucher(byte[] baucher) {
        this.baucher = baucher;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
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
}
