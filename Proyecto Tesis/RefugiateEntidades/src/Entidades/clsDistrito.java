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
public class clsDistrito {
    private int idDistrito;
    private String nombre;
    private clsProvincia objProvincia;

    public clsDistrito() {
    }

    public clsDistrito(int idDistrito) {
        this.idDistrito = idDistrito;
    }

    public int getIdDistrito() {
        return idDistrito;
    }

    public String getNombre() {
        return nombre;
    }

    public clsProvincia getObjProvincia() {
        return objProvincia;
    }

    public void setIdDistrito(int idDistrito) {
        this.idDistrito = idDistrito;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setObjProvincia(clsProvincia objProvincia) {
        this.objProvincia = objProvincia;
    }
}
