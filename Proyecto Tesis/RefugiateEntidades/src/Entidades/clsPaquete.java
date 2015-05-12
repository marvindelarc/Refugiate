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
public class clsPaquete {
    private int idPaquete;
    private double monto;
    private int meses;
    private int estado;

    public clsPaquete() {
    }

    public int getIdPaquete() {
        return idPaquete;
    }

    public double getMonto() {
        return monto;
    }

    public int getMeses() {
        return meses;
    }

    public int getEstado() {
        return estado;
    }

    public void setIdPaquete(int idPaquete) {
        this.idPaquete = idPaquete;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public void setMeses(int meses) {
        this.meses = meses;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
}
