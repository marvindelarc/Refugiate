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
class clsCostoTipoHabitacion {
    private int idCostoTipoHabitacion;
    private float costo;
    private int totalHabitaciones;
    private int habitacionesOcupadas;
    private int estado;
    private clsTipoHabitacion objTipohabitacion;

    public clsCostoTipoHabitacion() {
    }

    public int getIdCostoTipoHabitacion() {
        return idCostoTipoHabitacion;
    }

    public float getCosto() {
        return costo;
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

    public void setIdCostoTipoHabitacion(int idCostoTipoHabitacion) {
        this.idCostoTipoHabitacion = idCostoTipoHabitacion;
    }

    public void setCosto(float costo) {
        this.costo = costo;
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
}
