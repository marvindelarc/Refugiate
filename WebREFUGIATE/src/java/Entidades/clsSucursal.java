/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.util.Date;

/**
 *
 * @author Babsy Gamboa
 */
public class clsSucursal {
    private int int_IdSucursal;
    private clsEmpresa objEmpresa;
    private clsDistrito objDistrito;
    private String str_Telefono;
    private String str_Direccion;
    private double dou_Longitud;
    private double dou_Latitud;
    private int int_Pisos;
    private int int_Limpieza;
    private int int_Servicio;
    private int int_Puntos;
    private int int_Nivel;
    private int int_Estado;
    private int int_Comodidad;
    private String str_Entrada;
    private String str_Salida;
    private Date dat_FechaRegistro;

    public clsSucursal() {
    }

    public int getInt_Comodidad() {
        return int_Comodidad;
    }

    public void setInt_Comodidad(int int_Comodidad) {
        this.int_Comodidad = int_Comodidad;
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

    public String getStr_Entrada() {
        return str_Entrada;
    }

    public void setStr_Entrada(String str_Entrada) {
        this.str_Entrada = str_Entrada;
    }

    public String getStr_Salida() {
        return str_Salida;
    }

    public void setStr_Salida(String str_Salida) {
        this.str_Salida = str_Salida;
    }

    
    public int getInt_IdSucursal() {
        return int_IdSucursal;
    }

    public void setInt_IdSucursal(int int_IdSucursal) {
        this.int_IdSucursal = int_IdSucursal;
    }

    public clsEmpresa getObjEmpresa() {
        return objEmpresa;
    }

    public void setObjEmpresa(clsEmpresa objEmpresa) {
        this.objEmpresa = objEmpresa;
    }

    public clsDistrito getObjDistrito() {
        return objDistrito;
    }

    public void setObjDistrito(clsDistrito objDistrito) {
        this.objDistrito = objDistrito;
    }

    public String getStr_Telefono() {
        return str_Telefono;
    }

    public void setStr_Telefono(String str_Telefono) {
        this.str_Telefono = str_Telefono;
    }

    public String getStr_Direccion() {
        return str_Direccion;
    }

    public void setStr_Direccion(String str_Direccion) {
        this.str_Direccion = str_Direccion;
    }

    public double getDou_Longitud() {
        return dou_Longitud;
    }

    public void setDou_Longitud(double dou_Longitud) {
        this.dou_Longitud = dou_Longitud;
    }

    public double getDou_Latitud() {
        return dou_Latitud;
    }

    public void setDou_Latitud(double dou_Latitud) {
        this.dou_Latitud = dou_Latitud;
    }

    public int getInt_Pisos() {
        return int_Pisos;
    }

    public void setInt_Pisos(int int_Pisos) {
        this.int_Pisos = int_Pisos;
    }

    public int getInt_Puntos() {
        return int_Puntos;
    }

    public void setInt_Puntos(int int_Puntos) {
        this.int_Puntos = int_Puntos;
    }

    public int getInt_Nivel() {
        return int_Nivel;
    }

    public void setInt_Nivel(int int_Nivel) {
        this.int_Nivel = int_Nivel;
    }

    public int getInt_Estado() {
        return int_Estado;
    }

    public void setInt_Estado(int int_Estado) {
        this.int_Estado = int_Estado;
    }

    public Date getDat_FechaRegistro() {
        return dat_FechaRegistro;
    }

    public void setDat_FechaRegistro(Date dat_FechaRegistro) {
        this.dat_FechaRegistro = dat_FechaRegistro;
    }
    
    
}
