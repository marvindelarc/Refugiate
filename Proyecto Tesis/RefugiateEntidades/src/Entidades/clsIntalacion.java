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
public class clsIntalacion {
    private int idInstalacion;
    private String descripcion;
    private clsServicio objServicio;
    private clsSucursal objSucursal;

    public clsIntalacion() {
    }

    public int getIdInstalacion() {
        return idInstalacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public clsServicio getObjServicio() {
        return objServicio;
    }

    public clsSucursal getObjSucursal() {
        return objSucursal;
    }

    public void setIdInstalacion(int idInstalacion) {
        this.idInstalacion = idInstalacion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setObjServicio(clsServicio objServicio) {
        this.objServicio = objServicio;
    }

    public void setObjSucursal(clsSucursal objSucursal) {
        this.objSucursal = objSucursal;
    }
}