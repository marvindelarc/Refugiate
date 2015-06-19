/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.refugiate.app.entidades;

/**
 *
 * @author EdHam
 */
public class gipPersona {
    private int pk_id;
    private String nombres;
    private String apellidos;
    private String apelativos;
    private String detalle;

    public gipPersona() {
    }

    public gipPersona(int pk_id) {
        this.pk_id = pk_id;
    }

    public int getPk_id() {
        return pk_id;
    }

    public void setPk_id(int pk_id) {
        this.pk_id = pk_id;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getApelativos() {
        return apelativos;
    }

    public void setApelativos(String apelativos) {
        this.apelativos = apelativos;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    @Override
    public String toString() {
        return  apellidos + " "+nombres;
    }
    
}
