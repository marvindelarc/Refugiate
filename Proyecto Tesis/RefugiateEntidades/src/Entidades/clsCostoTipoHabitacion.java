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
public class clsCostoTipoHabitacion {
    private int idCostoTipoHabitacion;
    private double costo;
    private int numeroPersonas;
    private int totalHabitaciones;
    private int habitacionesOcupadas;
    private int estado;
    private clsTipoHabitacion objTipohabitacion;
    private clsSucursal objSucursal;
    private Date fechaUpdate;

    public clsCostoTipoHabitacion() {
    }

    public clsCostoTipoHabitacion(int idCostoTipoHabitacion) {
        this.idCostoTipoHabitacion = idCostoTipoHabitacion;
    }

    public clsSucursal getObjSucursal() {
        return objSucursal;
    }

    public int getIdCostoTipoHabitacion() {
        return idCostoTipoHabitacion;
    }

    public double getCosto() {
        return costo;
    }
    
    public int getNumeroPersonas() {
        return numeroPersonas;
    }

    public int getTotalHabitaciones() {
        return totalHabitaciones;
    }

    public int getHabitacionesOcupadas() {
        return habitacionesOcupadas;
    }

    public int getEstado() {
        return estado;
    }

    public clsTipoHabitacion getObjTipohabitacion() {
        return objTipohabitacion;
    }

    public void setObjSucursal(clsSucursal objSucursal) {
        this.objSucursal = objSucursal;
    }

    public void setIdCostoTipoHabitacion(int idCostoTipoHabitacion) {
        this.idCostoTipoHabitacion = idCostoTipoHabitacion;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public void setNumeroPersonas(int numeroPersonas) {
        this.numeroPersonas = numeroPersonas;
    }

    public void setTotalHabitaciones(int totalHabitaciones) {
        this.totalHabitaciones = totalHabitaciones;
    }

    public void setHabitacionesOcupadas(int habitacionesOcupadas) {
        this.habitacionesOcupadas = habitacionesOcupadas;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public void setObjTipohabitacion(clsTipoHabitacion objTipohabitacion) {
        this.objTipohabitacion = objTipohabitacion;
    }

    public Date getFechaUpdate() {
        return fechaUpdate;
    }

    public void setFechaUpdate(Date fechaUpdate) {
        this.fechaUpdate = fechaUpdate;
    }

}
