package com.refugiate.app.entidades;

import java.util.Date;

/**
 * Created by EdHam on 28/07/2015.
 */
public class clsSesion {
    private Date fecha;
    private int minutos;

    public clsSesion() {
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getMinutos() {
        return minutos;
    }

    public void setMinutos(int minutos) {
        this.minutos = minutos;
    }
}
