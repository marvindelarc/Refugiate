/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

/**
 *
 * @author Paulo
 */
public class clsInstalacion {
    private int int_IdInstalacion;
    private clsServicio objServicio;
    private String str_Descrpcion;
    private clsSucursal objSucursal;

    public clsInstalacion() {
    }

    public int getInt_IdInstalacion() {
        return int_IdInstalacion;
    }

    public void setInt_IdInstalacion(int int_IdInstalacion) {
        this.int_IdInstalacion = int_IdInstalacion;
    }

    public clsServicio getObjServicio() {
        return objServicio;
    }

    public void setObjServicio(clsServicio objServicio) {
        this.objServicio = objServicio;
    }

    
    public String getStr_Descrpcion() {
        return str_Descrpcion;
    }

    public void setStr_Descrpcion(String str_Descrpcion) {
        this.str_Descrpcion = str_Descrpcion;
    }

    public clsSucursal getObjSucursal() {
        return objSucursal;
    }

    public void setObjSucursal(clsSucursal objSucursal) {
        this.objSucursal = objSucursal;
    }
    
    
}
