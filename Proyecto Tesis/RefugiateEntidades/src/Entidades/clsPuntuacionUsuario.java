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
public class clsPuntuacionUsuario {
    private int idPUntuacionUsuario;
    private int puntualidad;
    private int honrrades;
    private int educacion;
    private Date fecha;
    private clsReserva objReserva;

    public clsPuntuacionUsuario() {
    }

    public int getIdPUntuacionUsuario() {
        return idPUntuacionUsuario;
    }

    public int getPuntualidad() {
        return puntualidad;
    }

    public int getHonrrades() {
        return honrrades;
    }

    public int getEducacion() {
        return educacion;
    }

    public Date getFecha() {
        return fecha;
    }

    public clsReserva getObjReserva() {
        return objReserva;
    }

    public void setIdPUntuacionUsuario(int idPUntuacionUsuario) {
        this.idPUntuacionUsuario = idPUntuacionUsuario;
    }

    public void setPuntualidad(int puntualidad) {
        this.puntualidad = puntualidad;
    }

    public void setHonrrades(int honrrades) {
        this.honrrades = honrrades;
    }

    public void setEducacion(int educacion) {
        this.educacion = educacion;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public void setObjReserva(clsReserva objReserva) {
        this.objReserva = objReserva;
    }
}
