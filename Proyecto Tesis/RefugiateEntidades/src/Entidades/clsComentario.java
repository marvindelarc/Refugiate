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
public class clsComentario {
    private int idComentario;
    private String descripcion;
    private Date fecha;
    private int estado;
    private clsReserva objReserva;

    public clsComentario() {
    }

    public int getIdComentario() {
        return idComentario;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Date getFecha() {
        return fecha;
    }

    public clsReserva getObjReserva() {
        return objReserva;
    }

    public int getEstado() {
        return estado;
    }

    public void setIdComentario(int idComentario) {
        this.idComentario = idComentario;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public void setObjReserva(clsReserva objReserva) {
        this.objReserva = objReserva;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
}
