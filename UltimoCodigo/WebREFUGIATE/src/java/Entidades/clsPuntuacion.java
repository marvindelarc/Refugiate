/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Entidades;

/**
 *
 * @author Toditos
 */
public class clsPuntuacion {
    private int int_IdPuntacion;
    private int int_Limpieza;
    private int int_Servicio;
    private int int_Comodidad;
    private clsReserva objReserva;

    public clsPuntuacion() {
    }

    public int getInt_IdPuntacion() {
        return int_IdPuntacion;
    }

    public void setInt_IdPuntacion(int int_IdPuntacion) {
        this.int_IdPuntacion = int_IdPuntacion;
    }

    public int getInt_Limpieza() {
        return int_Limpieza;
    }

    public void setInt_Limpieza(int int_Limpieza) {
        this.int_Limpieza = int_Limpieza;
    }

    public int getInt_Servicio() {
        return int_Servicio;
    }

    public void setInt_Servicio(int int_Servicio) {
        this.int_Servicio = int_Servicio;
    }

    public int getInt_Comodidad() {
        return int_Comodidad;
    }

    public void setInt_Comodidad(int int_Comodidad) {
        this.int_Comodidad = int_Comodidad;
    }

    public clsReserva getObjReserva() {
        return objReserva;
    }

    public void setObjReserva(clsReserva objReserva) {
        this.objReserva = objReserva;
    }
    
    
    
}
