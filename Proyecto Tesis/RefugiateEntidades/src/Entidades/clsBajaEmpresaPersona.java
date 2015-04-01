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
public class clsBajaEmpresaPersona {
    private int idBajaEmpresaPersona;
    private String comentario;
    private Date fechaRegistro;
    private Date fechaFinal;
    private int estado;
    private clsPersona objPersona;

    public clsBajaEmpresaPersona() {
    }

    public int getIdBajaEmpresaPersona() {
        return idBajaEmpresaPersona;
    }

    public String getComentario() {
        return comentario;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public Date getFechaFinal() {
        return fechaFinal;
    }

    public int getEstado() {
        return estado;
    }

    public clsPersona getObjPersona() {
        return objPersona;
    }

    public void setIdBajaEmpresaPersona(int idBajaEmpresaPersona) {
        this.idBajaEmpresaPersona = idBajaEmpresaPersona;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public void setFechaFinal(Date fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public void setObjPersona(clsPersona objPersona) {
        this.objPersona = objPersona;
    }
}
