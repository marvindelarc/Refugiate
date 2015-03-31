/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.refujiate.entidades;

import java.util.Date;

/**
 *
 * @author Toditos
 */
public class clsComentario {
  private int int_IdComentario;
  private int int_IdReserva;
  private String str_Descripcion;
  private String str_Usuario;
  private Date dat_Fecha;

    public clsComentario(int int_IdComentario, int int_IdReserva, String str_Descripcion, String str_Usuario) {
        this.int_IdComentario = int_IdComentario;
        this.int_IdReserva = int_IdReserva;
        this.str_Descripcion = str_Descripcion;
        this.str_Usuario = str_Usuario;
        
    }
    
     public clsComentario(String Entidad) {
         String [] parametro = Entidad.split("\\<+cls+>");   
        this.int_IdComentario = Integer.parseInt(parametro[0].trim());
        this.int_IdReserva = Integer.parseInt(parametro[1].trim());   
        this.str_Descripcion = parametro[2].trim();
        this.dat_Fecha = new Date(Long.parseLong(parametro[3].trim()));
        this.str_Usuario = parametro[4].trim();
        
    }

    public clsComentario(String str_Descripcion, String str_Usuario) {
        this.str_Descripcion = str_Descripcion;
        this.str_Usuario = str_Usuario;
    }

  
    public clsComentario() {
    }

    public int getInt_IdComentario() {
        return int_IdComentario;
    }

    public void setInt_IdComentario(int int_IdComentario) {
        this.int_IdComentario = int_IdComentario;
    }

    public int getInt_IdReserva() {
        return int_IdReserva;
    }

    public void setInt_IdReserva(int int_IdReserva) {
        this.int_IdReserva = int_IdReserva;
    }

    public String getStr_Descripcion() {
        return str_Descripcion;
    }

    public void setStr_Descripcion(String str_Descripcion) {
        this.str_Descripcion = str_Descripcion;
    }

    public String getStr_Usuario() {
        return str_Usuario;
    }

    public void setStr_Usuario(String str_Usuario) {
        this.str_Usuario = str_Usuario;
    }

    public Date getDat_Fecha() {
        return dat_Fecha;
    }

    public void setDat_Fecha(Date dat_Fecha) {
        this.dat_Fecha = dat_Fecha;
    }
  
  
}
