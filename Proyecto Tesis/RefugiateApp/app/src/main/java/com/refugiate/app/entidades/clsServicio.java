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
public class clsServicio {
    private int idServicio;
    private String nombre;
    private int estado;
    private Date update;

    public clsServicio() {
    }

    public clsServicio(int idServicio) {
        this.idServicio = idServicio;
    }

    public Date getUpdate() {
        return update;
    }

    public void setUpdate(Date update) {
        this.update = update;
    }

    public int getIdServicio() {
        return idServicio;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEstado() {
        return estado;
    }

    public void setIdServicio(int idServicio) {
        this.idServicio = idServicio;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
}
