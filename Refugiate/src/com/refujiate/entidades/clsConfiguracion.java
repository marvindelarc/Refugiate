/*


 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.refujiate.entidades;

import java.util.Date;


/**
 *
 * @author Babsy Gamboa
 */
public class clsConfiguracion {
    private int int_tiempo_actulizacion;
    private Date dat_tiempo_actualizacion;
    private int int_tiempo_previo_reserva;
    private int int_repetir;
    private int int_repetir_tiempo;
    private int int_tipo_propagandas;

    public clsConfiguracion() {
    }

    
    public int getInt_tiempo_actulizacion() {
        return int_tiempo_actulizacion;
    }

    public void setInt_tiempo_actulizacion(int int_tiempo_actulizacion) {
        this.int_tiempo_actulizacion = int_tiempo_actulizacion;
    }

    public Date getDat_tiempo_actualizacion() {
        return dat_tiempo_actualizacion;
    }

    public void setDat_tiempo_actualizacion(Date dat_tiempo_actualizacion) {
        this.dat_tiempo_actualizacion = dat_tiempo_actualizacion;
    }

    public int getInt_tiempo_previo_reserva() {
        return int_tiempo_previo_reserva;
    }

    public void setInt_tiempo_previo_reserva(int int_tiempo_previo_reserva) {
        this.int_tiempo_previo_reserva = int_tiempo_previo_reserva;
    }

    public int getInt_repetir() {
        return int_repetir;
    }

    public void setInt_repetir(int int_repetir) {
        this.int_repetir = int_repetir;
    }

    public int getInt_repetir_tiempo() {
        return int_repetir_tiempo;
    }

    public void setInt_repetir_tiempo(int int_repetir_tiempo) {
        this.int_repetir_tiempo = int_repetir_tiempo;
    }

    public int getInt_tipo_propagandas() {
        return int_tipo_propagandas;
    }

    public void setInt_tipo_propagandas(int int_tipo_propagandas) {
        this.int_tipo_propagandas = int_tipo_propagandas;
    }

 
    
}
