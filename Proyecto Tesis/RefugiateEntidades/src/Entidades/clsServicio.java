/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

/**
 *
 * @author Paulo
 */
public class clsServicio {
    private int isServicio;
    private String nombre;
    private int estado;

    public clsServicio() {
    }

    public int getIsServicio() {
        return isServicio;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEstado() {
        return estado;
    }

    public void setIsServicio(int isServicio) {
        this.isServicio = isServicio;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
}
