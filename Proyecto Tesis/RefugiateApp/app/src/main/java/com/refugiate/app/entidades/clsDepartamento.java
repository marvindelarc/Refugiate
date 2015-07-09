/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.refugiate.app.entidades;

/**
 *
 * @author Babsy Gamboa
 */
public class clsDepartamento {
    private int int_id_depatamento;
    private String str_nombre;

    public clsDepartamento() {
    }

    public clsDepartamento(int int_id_depatamento, String str_nombre) {
        this.int_id_depatamento = int_id_depatamento;
        this.str_nombre = str_nombre;
    }

    public clsDepartamento(int int_id_depatamento) {
        this.int_id_depatamento = int_id_depatamento;
    }

    public int getInt_id_depatamento() {
        return int_id_depatamento;
    }

    public void setInt_id_depatamento(int int_id_depatamento) {
        this.int_id_depatamento = int_id_depatamento;
    }

    public String getStr_nombre() {
        return str_nombre;
    }

    public void setStr_nombre(String str_nombre) {
        this.str_nombre = str_nombre;
    }
    
     @Override
    public String toString()
    {
        return str_nombre;
    }
}
