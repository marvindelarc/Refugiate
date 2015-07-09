/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.refugiate.app.entidades;

/**
 *
 * @author EdHam
 */
public class clsDistrito {
  private int int_id_distrito;
  private String str_nombre;  
  private clsProvincia objProvincia;

    public clsDistrito() {
    }

    public clsDistrito(int int_id_distrito) {
        this.int_id_distrito = int_id_distrito;
    }

    public clsDistrito(int int_id_distrito, String str_nombre) {
        this.int_id_distrito = int_id_distrito;
        this.str_nombre = str_nombre;
    }

    public clsDistrito(int int_id_distrito, clsProvincia objProvincia, String str_nombre) {
        this.int_id_distrito = int_id_distrito;
        this.str_nombre = str_nombre;
        this.objProvincia = objProvincia;
    }

    public int getInt_id_distrito() {
        return int_id_distrito;
    }

    public void setInt_id_distrito(int int_id_distrito) {
        this.int_id_distrito = int_id_distrito;
    }

    public String getStr_nombre() {
        return str_nombre;
    }

    public void setStr_nombre(String str_nombre) {
        this.str_nombre = str_nombre;
    }

    public clsProvincia getObjProvincia() {
        return objProvincia;
    }

    public void setObjProvincia(clsProvincia objProvincia) {
        this.objProvincia = objProvincia;
    }
   
    @Override
    public String toString()
    {
        return str_nombre;
    }
  
}
