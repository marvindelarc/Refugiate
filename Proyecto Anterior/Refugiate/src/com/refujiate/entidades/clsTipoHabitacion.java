/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.refujiate.entidades;

/**
 *
 * @author Paulo
 */
public class clsTipoHabitacion {
    private int int_idTipoHabitacion;
    private int int_idHabitacion;
    private int int_idSucursal;
    private String str_Nombre;
    private double dou_Costo;
    private int int_Disponibles;

    public clsTipoHabitacion() {
    }

    public clsTipoHabitacion(String Entidad) {
        String [] parametro = Entidad.split("\\<+col+>");   
        this.int_idTipoHabitacion = Integer.parseInt(parametro[0].trim());
        this.int_idHabitacion = Integer.parseInt(parametro[1].trim());        
        this.str_Nombre = parametro[2].trim();
        this.int_idSucursal = Integer.parseInt(parametro[3].trim());

    }

    public clsTipoHabitacion(int int_idHabitacion, String str_Nombre) {
        this.int_idHabitacion = int_idHabitacion;
        this.str_Nombre = str_Nombre;
    }

    
    public clsTipoHabitacion(int int_idTipoHabitacion, String str_Nombre, double dou_Costo) {
        this.int_idTipoHabitacion = int_idTipoHabitacion;
        this.str_Nombre = str_Nombre;
        this.dou_Costo = dou_Costo;
    }



    public clsTipoHabitacion(int int_idTipoHabitacion, String str_Nombre, double dou_Costo, int int_Disponibles) {
        this.int_idTipoHabitacion = int_idTipoHabitacion;
        this.str_Nombre = str_Nombre;
        this.dou_Costo = dou_Costo;
        this.int_Disponibles = int_Disponibles;
    }

    public int getInt_idTipoHabitacion() {
        return int_idTipoHabitacion;
    }

    public void setInt_idTipoHabitacion(int int_idTipoHabitacion) {
        this.int_idTipoHabitacion = int_idTipoHabitacion;
    }

    public int getInt_idHabitacion() {
        return int_idHabitacion;
    }

    public void setInt_idHabitacion(int int_idHabitacion) {
        this.int_idHabitacion = int_idHabitacion;
    }

    public int getInt_idSucursal() {
        return int_idSucursal;
    }

    public void setInt_idSucursal(int int_idSucursal) {
        this.int_idSucursal = int_idSucursal;
    }

    public String getStr_Nombre() {
        return str_Nombre;
    }

    public void setStr_Nombre(String str_Nombre) {
        this.str_Nombre = str_Nombre;
    }

    public double getDou_Costo() {
        return dou_Costo;
    }

    public void setDou_Costo(double dou_Costo) {
        this.dou_Costo = dou_Costo;
    }

    public int getInt_Disponibles() {
        return int_Disponibles;
    }

    public void setInt_Disponibles(int int_Disponibles) {
        this.int_Disponibles = int_Disponibles;
    }

    

         @Override
    public String toString()
    {
        return str_Nombre;
    }
}
