/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.refugiate.app.entidades;

/**
 *
 * @author Paulo
 */
public class clsTipoHabitacion {
    private int idTipoHabitacion;
    private String nombreComercial;
    private int estado;

    public clsTipoHabitacion() {
    }

    public clsTipoHabitacion(int idTipoHabitacion, String nombreComercial) {
        this.idTipoHabitacion = idTipoHabitacion;
        this.nombreComercial = nombreComercial;
    }

    public clsTipoHabitacion(int idTipoHabitacion) {
        this.idTipoHabitacion = idTipoHabitacion;
    }

    public int getIdTipoHabitacion() {
        return idTipoHabitacion;
    }

    public String getNombreComercial() {
        return nombreComercial;
    }

    public int getEstado() {
        return estado;
    }

    public void setIdTipoHabitacion(int idTipoHabitacion) {
        this.idTipoHabitacion = idTipoHabitacion;
    }

    public void setNombreComercial(String nombreComercial) {
        this.nombreComercial = nombreComercial;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
}
