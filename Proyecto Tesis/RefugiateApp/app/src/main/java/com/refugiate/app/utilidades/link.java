/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.refugiate.app.utilidades;

import android.graphics.Bitmap;

/**
 *
 * @author EdHam
 */
public class link {
    private String titulo;
    private String detalle;
    private String url;
    private Bitmap logo;

    public link()
    {

    }

    public link(String titulo, String detalle,String url, Bitmap logo) {
        this.titulo = titulo;
        this.detalle = detalle;
        this.url=url;
        this.logo = logo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public Bitmap getLogo() {
        return logo;
    }

    public void setLogo(Bitmap logo) {
        this.logo = logo;
    }


    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
