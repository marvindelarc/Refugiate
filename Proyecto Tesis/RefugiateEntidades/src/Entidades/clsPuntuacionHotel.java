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
public class clsPuntuacionHotel {
    private int idPuntacionHotel;
    private int limpieza;
    private int servicio;
    private int comodidad;
    private clsReserva objReserva;
    private Date fecha;

    public clsPuntuacionHotel() {
    }

    public int getIdPuntacionHotel() {
        return idPuntacionHotel;
    }

    public int getLimpieza() {
        return limpieza;
    }

    public int getServicio() {
        return servicio;
    }

    public int getComodidad() {
        return comodidad;
    }

    public clsReserva getObjReserva() {
        return objReserva;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setIdPuntacionHotel(int idPuntacionHotel) {
        this.idPuntacionHotel = idPuntacionHotel;
    }

    public void setLimpieza(int limpieza) {
        this.limpieza = limpieza;
    }

    public void setServicio(int servicio) {
        this.servicio = servicio;
    }

    public void setComodidad(int comodidad) {
        this.comodidad = comodidad;
    }

    public void setObjReserva(clsReserva objReserva) {
        this.objReserva = objReserva;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
}
