/*
 * To change this template, choose Tools | Templates
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
    private Date dat_FechaIngreso;
    private clsCostoTipoHabitacion objCostoTipoHabitacion;
    private clsReserva objReserva;
    private int int_NHabitaciones;
    private int int_Dias;
    private double dou_Total;
    private int int_IdComentario;
    private int int_IdPuntuacion;
    

    public clsDetalleReserva() {
    }

    public int getInt_IdDetalleReserva() {
        return int_IdDetalleReserva;
    }

    public void setInt_IdDetalleReserva(int int_IdDetalleReserva) {
        this.int_IdDetalleReserva = int_IdDetalleReserva;
    }

    public Date getDat_FechaIngreso() {
        return dat_FechaIngreso;
    }

    public void setDat_FechaIngreso(Date dat_FechaIngreso) {
        this.dat_FechaIngreso = dat_FechaIngreso;
    }

    public clsCostoTipoHabitacion getObjCostoTipoHabitacion() {
        return objCostoTipoHabitacion;
    }

    public void setObjCostoTipoHabitacion(clsCostoTipoHabitacion objCostoTipoHabitacion) {
        this.objCostoTipoHabitacion = objCostoTipoHabitacion;
    }

    public clsReserva getObjReserva() {
        return objReserva;
    }

    public void setObjReserva(clsReserva objReserva) {
        this.objReserva = objReserva;
    }

    public int getInt_NHabitaciones() {
        return int_NHabitaciones;
    }

    public void setInt_NHabitaciones(int int_NHabitaciones) {
        this.int_NHabitaciones = int_NHabitaciones;
    }

    public int getInt_Dias() {
        return int_Dias;
    }

    public void setInt_Dias(int int_Dias) {
        this.int_Dias = int_Dias;
    }

    public double getDou_Total() {
        return dou_Total;
    }

    public void setDou_Total(double dou_Total) {
        this.dou_Total = dou_Total;
    }

    public int getInt_IdComentario() {
        return int_IdComentario;
    }

    public void setInt_IdComentario(int int_IdComentario) {
        this.int_IdComentario = int_IdComentario;
    }

    public int getInt_IdPuntuacion() {
        return int_IdPuntuacion;
    }

    public void setInt_IdPuntuacion(int int_IdPuntuacion) {
        this.int_IdPuntuacion = int_IdPuntuacion;
    }

    
    
}
