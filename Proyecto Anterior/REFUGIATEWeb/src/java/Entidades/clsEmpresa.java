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
public class clsEmpresa {
    private int int_IdEmpresa;
    private String str_NombreComercial;
    private String str_Nombre;
    private String str_Slogan;
    private String str_Ruc;
    private int int_Estado;
    private int int_Puntos;
    private Date dat_FechaRegistro;

    public clsEmpresa() {
    }

    public int getInt_IdEmpresa() {
        return int_IdEmpresa;
    }

    public void setInt_IdEmpresa(int int_IdEmpresa) {
        this.int_IdEmpresa = int_IdEmpresa;
    }

    public String getStr_NombreComercial() {
        return str_NombreComercial;
    }

    public void setStr_NombreComercial(String str_NombreComercial) {
        this.str_NombreComercial = str_NombreComercial;
    }

    public String getStr_Nombre() {
        return str_Nombre;
    }

    public void setStr_Nombre(String str_Nombre) {
        this.str_Nombre = str_Nombre;
    }

    public String getStr_Slogan() {
        return str_Slogan;
    }

    public void setStr_Slogan(String str_Slogan) {
        this.str_Slogan = str_Slogan;
    }

    public String getStr_Ruc() {
        return str_Ruc;
    }

    public void setStr_Ruc(String str_Ruc) {
        this.str_Ruc = str_Ruc;
    }

    public int getInt_Estado() {
        return int_Estado;
    }

    public void setInt_Estado(int int_Estado) {
        this.int_Estado = int_Estado;
    }

    public int getInt_Puntos() {
        return int_Puntos;
    }

    public void setInt_Puntos(int int_Puntos) {
        this.int_Puntos = int_Puntos;
    }

    public Date getDat_FechaRegistro() {
        return dat_FechaRegistro;
    }

    public void setDat_FechaRegistro(Date dat_FechaRegistro) {
        this.dat_FechaRegistro = dat_FechaRegistro;
    }
    
    
    
}
