/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.util.Date;

/**
 *
 * @author Paulo
 */
public class clsReserva {
    private int idReserva;
    private Date fechaResgistro;
     private Date fechaUpdate;
    private Date fechaIngreso;
    private Date fechaEgreso;
    
    private int servicio;
    private int comodidad;
    private int limpieza;
    private String comentario;
    private int estado;
    private int dias;
    private double costo;
    private clsHabitacion objHabitacion;
    private clsPersona objPersona;

    public clsReserva() {
    }

    public int getIdReserva() {
        return idReserva;
    }

    public Date getFechaResgistro() {
        return fechaResgistro;
    }

    public int getEstado() {
        return estado;
    }

    public clsPersona getObjPersona() {
        return objPersona;
    }

    public void setIdReserva(int idReserva) {
        this.idReserva = idReserva;
    }

    public void setFechaResgistro(Date fechaResgistro) {
        this.fechaResgistro = fechaResgistro;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public void setObjPersona(clsPersona objPersona) {
        this.objPersona = objPersona;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public Date getFechaEgreso() {
        return fechaEgreso;
    }

    public void setFechaEgreso(Date fechaEgreso) {
        this.fechaEgreso = fechaEgreso;
    }

    public int getDias() {
        return dias;
    }

    public void setDias(int dias) {
        this.dias = dias;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public clsHabitacion getObjHabitacion() {
        return objHabitacion;
    }

    public void setObjHabitacion(clsHabitacion objHabitacion) {
        this.objHabitacion = objHabitacion;
    }

    public int getServicio() {
        return servicio;
    }

    public void setServicio(int servicio) {
        this.servicio = servicio;
    }

    public int getComodidad() {
        return comodidad;
    }

    public void setComodidad(int comodidad) {
        this.comodidad = comodidad;
    }

    public int getLimpieza() {
        return limpieza;
    }

    public void setLimpieza(int limpieza) {
        this.limpieza = limpieza;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Date getFechaUpdate() {
        return fechaUpdate;
    }

    public void setFechaUpdate(Date fechaUpdate) {
        this.fechaUpdate = fechaUpdate;
    }
    
}
