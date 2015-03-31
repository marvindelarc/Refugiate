/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.refujiate.entidades;

import android.graphics.drawable.Drawable;


public class clsHotel {
    private int int_IdHotel;
    private int int_Estrellas;
    private String str_Nombre;
    private double dou_Longitud;
    private double dou_Latitud;
    private int int_Tipo;
    private int int_Puntos;
    private Drawable ing_Logo;

    public clsHotel() {
    }


   public clsHotel(String Entidad) {
        String [] parametro = Entidad.split("\\<+col+>");   
        this.int_IdHotel = Integer.parseInt(parametro[0].trim());
        this.int_Estrellas = Integer.parseInt(parametro[1].trim());        
        this.dou_Longitud = Double.parseDouble(parametro[2].trim());
        this.dou_Latitud = Double.parseDouble(parametro[3].trim());
        this.str_Nombre = parametro[4].trim();
        this.int_Tipo = Integer.parseInt(parametro[5].trim()); 
        this.int_Puntos = Integer.parseInt(parametro[6].trim()); 
    }

    public int getInt_IdHotel() {
        return int_IdHotel;
    }

    public void setInt_IdHotel(int int_IdHotel) {
        this.int_IdHotel = int_IdHotel;
    }

    public int getInt_Estrellas() {
        return int_Estrellas;
    }

    public void setInt_Estrellas(int int_Estrellas) {
        this.int_Estrellas = int_Estrellas;
    }

    public String getStr_Nombre() {
        return str_Nombre;
    }

    public void setStr_Nombre(String str_Nombre) {
        this.str_Nombre = str_Nombre;
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

    public int getInt_Tipo() {
        return int_Tipo;
    }

    public void setInt_Tipo(int int_Tipo) {
        this.int_Tipo = int_Tipo;
    }

    public Drawable getIng_Logo() {
        return ing_Logo;
    }

    public void setIng_Logo(Drawable ing_Logo) {
        this.ing_Logo = ing_Logo;
    }

    public int getInt_Puntos() {
        return int_Puntos;
    }

    public void setInt_Puntos(int int_Puntos) {
        this.int_Puntos = int_Puntos;
    }

   
    

    
}
