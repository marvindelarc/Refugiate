/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

/**
 *
 * @author Paulo
 */
public class clsCostoTipoHabitacion {
   private int int_IdCostoTipoHabitacion;
   private double dou_Costo;
   private int int_TotalHabitaciones;
   private int int_HabitacionesOcupadas;
   private int int_Estado;
   private clsTipoHabitacion objTipoHabitacion;
   private clsSucursal objSucursal;

    public clsCostoTipoHabitacion() {
    }

    public int getInt_IdCostoTipoHabitacion() {
        return int_IdCostoTipoHabitacion;
    }

    public void setInt_IdCostoTipoHabitacion(int int_IdCostoTipoHabitacion) {
        this.int_IdCostoTipoHabitacion = int_IdCostoTipoHabitacion;
    }

    public double getDou_Costo() {
        return dou_Costo;
    }

    public void setDou_Costo(double dou_Costo) {
        this.dou_Costo = dou_Costo;
    }

    public int getInt_TotalHabitaciones() {
        return int_TotalHabitaciones;
    }

    public void setInt_TotalHabitaciones(int int_TotalHabitaciones) {
        this.int_TotalHabitaciones = int_TotalHabitaciones;
    }

    public int getInt_HabitacionesOcupadas() {
        return int_HabitacionesOcupadas;
    }

    public void setInt_HabitacionesOcupadas(int int_HabitacionesOcupadas) {
        this.int_HabitacionesOcupadas = int_HabitacionesOcupadas;
    }

    public int getInt_Estado() {
        return int_Estado;
    }

    public void setInt_Estado(int int_Estado) {
        this.int_Estado = int_Estado;
    }
    
    public clsTipoHabitacion getObjTipoHabitacion() {
        return objTipoHabitacion;
    }

    public void setObjTipoHabitacion(clsTipoHabitacion objTipoHabitacion) {
        this.objTipoHabitacion = objTipoHabitacion;
    }

    public clsSucursal getObjSucursal() {
        return objSucursal;
    }

    public void setObjSucursal(clsSucursal objSucursal) {
        this.objSucursal = objSucursal;
    }

}
