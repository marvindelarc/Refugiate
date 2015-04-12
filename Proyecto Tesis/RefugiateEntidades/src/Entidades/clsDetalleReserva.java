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
public class clsDetalleReserva {
    private int int_IdDetalleReserva;
    private int nroHabitaciones;
    private Date fechaIngreso;
    private int dias;
    private double total;
    private int estado;
    private clsReserva objReserva;
    private clsHabitacion objHabitacion;

    public clsDetalleReserva() {
    }

    public int getInt_IdDetalleReserva() {
        return int_IdDetalleReserva;
    }

    public int getNroHabitaciones() {
        return nroHabitaciones;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public int getDias() {
        return dias;
    }

    public double getTotal() {
        return total;
    }

    public int getEstado() {
        return estado;
    }

    public clsReserva getObjReserva() {
        return objReserva;
    }

    public clsHabitacion getObjHabitacion() {
        return objHabitacion;
    }

    public void setInt_IdDetalleReserva(int int_IdDetalleReserva) {
        this.int_IdDetalleReserva = int_IdDetalleReserva;
    }

    public void setNroHabitaciones(int nroHabitaciones) {
        this.nroHabitaciones = nroHabitaciones;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public void setDias(int dias) {
        this.dias = dias;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public void setObjReserva(clsReserva objReserva) {
        this.objReserva = objReserva;
    }

    public void setObjHabitacion(clsHabitacion objHabitacion) {
        this.objHabitacion = objHabitacion;
    }
}
