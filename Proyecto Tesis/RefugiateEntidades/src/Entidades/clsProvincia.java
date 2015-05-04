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
public class clsProvincia {
    private int idProvincia;
    private String nombre;
    private clsDepartamento objDepartamento;

    public clsProvincia() {
    }

    public int getIdProvincia() {
        return idProvincia;
    }

    public String getNombre() {
        return nombre;
    }

    public clsDepartamento getObjDepartamento() {
        return objDepartamento;
    }

    public void setIdProvincia(int idProvincia) {
        this.idProvincia = idProvincia;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setObjDepartamento(clsDepartamento objDepartamento) {
        this.objDepartamento = objDepartamento;
    }
}