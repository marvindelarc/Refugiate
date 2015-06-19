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
public class gipHechoPublico {
    private int pk_id;
    private int TipoHechoPublico;
    private String detalle;
    private Double longitud;
    private Double latitud;
    private byte[] imagen;


    private String email;

    public gipHechoPublico() {
        this.longitud=0D;
        this.latitud=0D;
        this.email=null;
        this.imagen=null;
    }

    public int getPk_id() {
        return pk_id;
    }

    public void setPk_id(int pk_id) {
        this.pk_id = pk_id;
    }

    public int getTipoHechoPublico() {
        return TipoHechoPublico;
    }

    public void setTipoHechoPublico(int TipoHechoPublico) {
        this.TipoHechoPublico = TipoHechoPublico;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public Double getLongitud() {
        return longitud;
    }

    public void setLongitud(Double longitud) {
        this.longitud = longitud;
    }

    public Double getLatitud() {
        return latitud;
    }

    public void setLatitud(Double latitud) {
        this.latitud = latitud;
    }

    public byte[] getImagen() {
        return imagen;
    }

    public void setImagen(byte[] imagen) {
        this.imagen = imagen;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
