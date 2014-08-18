/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.refujiate.entidades;

import java.util.Date;

/**
 *
 * @author Paulo
 */
public class clsDetalleReserva {
    private int int_IdDetalleReserva;
    private int int_IdReserva;    
    private Date dat_Fecha;
    private int int_IdCostoTipoHabitacion;
    private int int_NHabitaciones;
    private int int_Dias;
    private double dou_Total;
    private String TipoHabitacion;
    private String NombreHotel;
    private int int_IdComentario;
    private int int_IdPuntuacion;

    public clsDetalleReserva() {
    }

    public clsDetalleReserva(String Entidad) {
        String [] parametro = Entidad.split("\\<+cls+>");   
        this.int_IdDetalleReserva = Integer.parseInt(parametro[0].trim());
        this.int_IdReserva = Integer.parseInt(parametro[1].trim());        
        this.dat_Fecha = new Date(Long.parseLong(parametro[2].trim()));
        this.int_IdCostoTipoHabitacion = Integer.parseInt(parametro[3].trim());
        this.int_NHabitaciones = Integer.parseInt(parametro[4].trim());
        this.int_Dias = Integer.parseInt(parametro[5].trim());
        this.dou_Total = Double.parseDouble(parametro[6].trim());
        this.TipoHabitacion = parametro[7].trim();
        this.NombreHotel = parametro[8].trim();
        this.int_IdComentario = Integer.parseInt(parametro[9].trim());
        this.int_IdPuntuacion = Integer.parseInt(parametro[10].trim());
        

    }

    public int getInt_IdReserva() {
        return int_IdReserva;
    }

    public void setInt_IdReserva(int int_IdReserva) {
        this.int_IdReserva = int_IdReserva;
    }



    public int getInt_IdDetalleReserva() {
        return int_IdDetalleReserva;
    }

    public void setInt_IdDetalleReserva(int int_IdDetalleReserva) {
        this.int_IdDetalleReserva = int_IdDetalleReserva;
    }

    public Date getDat_Fecha() {
        return dat_Fecha;
    }

    public void setDat_Fecha(Date dat_Fecha) {
        this.dat_Fecha = dat_Fecha;
    }

    public int getInt_IdCostoTipoHabitacion() {
        return int_IdCostoTipoHabitacion;
    }

    public void setInt_IdCostoTipoHabitacion(int int_IdCostoTipoHabitacion) {
        this.int_IdCostoTipoHabitacion = int_IdCostoTipoHabitacion;
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

    public String getTipoHabitacion() {
        return TipoHabitacion;
    }

    public void setTipoHabitacion(String TipoHabitacion) {
        this.TipoHabitacion = TipoHabitacion;
    }

    public String getNombreHotel() {
        return NombreHotel;
    }

    public void setNombreHotel(String NombreHotel) {
        this.NombreHotel = NombreHotel;
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
