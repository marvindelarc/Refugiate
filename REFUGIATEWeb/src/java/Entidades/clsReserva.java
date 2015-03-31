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
public class clsReserva {
    private int int_IdReserva;
    private  Date dat_FechaResgistro;
    private int int_Estado;
    private int int_IdSucursal;
    private clsPersona objPersona;

    public clsReserva() {
    }
    
    

    public int getInt_IdReserva() {
        return int_IdReserva;
    }

    public int getInt_IdSucursal() {
        return int_IdSucursal;
    }

    public void setInt_IdSucursal(int int_IdSucursal) {
        this.int_IdSucursal = int_IdSucursal;
    }

    
    public void setInt_IdReserva(int int_IdReserva) {
        this.int_IdReserva = int_IdReserva;
    }

    public Date getDat_FechaResgistro() {
        return dat_FechaResgistro;
    }

    public void setDat_FechaResgistro(Date dat_FechaResgistro) {
        this.dat_FechaResgistro = dat_FechaResgistro;
    }

    public int getInt_Estado() {
        return int_Estado;
    }

    public void setInt_Estado(int int_Estado) {
        this.int_Estado = int_Estado;
    }

    public clsPersona getObjPersona() {
        return objPersona;
    }

    public void setObjPersona(clsPersona objPersona) {
        this.objPersona = objPersona;
    }
    
}
