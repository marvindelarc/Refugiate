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
public class clsHabitacion {
    private int idHabitacion;
    private int numero;
    private int piso;
    private int estado;
    private boolean vista;
    private clsCostoTipoHabitacion objCostoTipoHabitacion;

    public clsHabitacion() {
    }

    public int getIdHabitacion() {
        return idHabitacion;
    }

    public int getNumero() {
        return numero;
    }

    public int getPiso() {
        return piso;
    }

    public int getEstado() {
        return estado;
    }

    public boolean isVista() {
        return vista;
    }

    public void setVista(boolean vista) {
        this.vista = vista;
    }


    public clsCostoTipoHabitacion getObjCostoTipoHabitacion() {
        return objCostoTipoHabitacion;
    }

    public void setIdHabitacion(int idHabitacion) {
        this.idHabitacion = idHabitacion;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setPiso(int piso) {
        this.piso = piso;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

 

    public void setObjCostoTipoHabitacion(clsCostoTipoHabitacion objCostoTipoHabitacion) {
        this.objCostoTipoHabitacion = objCostoTipoHabitacion;
    }
}
