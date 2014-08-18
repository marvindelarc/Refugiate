/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.refujiate.entidades;

/**
 *
 * @author Toditos
 */
public class clsInstalacion {
    private int int_IdIntalacion;
    private int int_IdServicio;
    private int int_IdSucursal;
    private String str_Nombre;
    private String str_Descripcion;

    public clsInstalacion() {
    }

    public clsInstalacion(String Entidad) {
        String [] parametro = Entidad.split("\\<+col+>");   
        this.int_IdIntalacion = Integer.parseInt(parametro[0].trim());
        this.int_IdServicio = Integer.parseInt(parametro[1].trim());        
        this.int_IdSucursal = Integer.parseInt(parametro[2].trim());
        this.str_Nombre = parametro[3].trim();
        this.str_Descripcion = parametro[4].trim();

    }

    public clsInstalacion(int int_IdServicio, String str_Nombre) {
        this.int_IdServicio = int_IdServicio;
        this.str_Nombre = str_Nombre;
    }
    
    
    public int getInt_IdIntalacion() {
        return int_IdIntalacion;
    }

    public void setInt_IdIntalacion(int int_IdIntalacion) {
        this.int_IdIntalacion = int_IdIntalacion;
    }

    public int getInt_IdServicio() {
        return int_IdServicio;
    }

    public void setInt_IdServicio(int int_IdServicio) {
        this.int_IdServicio = int_IdServicio;
    }

    public int getInt_IdSucursal() {
        return int_IdSucursal;
    }

    public void setInt_IdSucursal(int int_IdSucursal) {
        this.int_IdSucursal = int_IdSucursal;
    }

    public String getStr_Nombre() {
        return str_Nombre;
    }

    public void setStr_Nombre(String str_Nombre) {
        this.str_Nombre = str_Nombre;
    }

    public String getStr_Descripcion() {
        return str_Descripcion;
    }

    public void setStr_Descripcion(String str_Descripcion) {
        this.str_Descripcion = str_Descripcion;
    }

    @Override
    public String toString() {
        return str_Nombre;
    }
    
    
    
}
