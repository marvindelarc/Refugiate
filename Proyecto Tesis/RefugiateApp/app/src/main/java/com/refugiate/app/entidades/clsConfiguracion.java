/*


 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.refugiate.app.entidades;

import java.util.Date;


public class clsConfiguracion {
    private int tiempo_actulizacion;
    private Date tiempo_actualizacion;
    private int tiempo_previo_reserva;
    private int repetir;
    private int repetir_tiempo;
    private int tipo_propagandas;

    public clsConfiguracion() {
    }


    public int getTiempo_actulizacion() {
        return tiempo_actulizacion;
    }

    public void setTiempo_actulizacion(int tiempo_actulizacion) {
        this.tiempo_actulizacion = tiempo_actulizacion;
    }

    public Date getTiempo_actualizacion() {
        return tiempo_actualizacion;
    }

    public void setTiempo_actualizacion(Date tiempo_actualizacion) {
        this.tiempo_actualizacion = tiempo_actualizacion;
    }

    public int getTiempo_previo_reserva() {
        return tiempo_previo_reserva;
    }

    public void setTiempo_previo_reserva(int tiempo_previo_reserva) {
        this.tiempo_previo_reserva = tiempo_previo_reserva;
    }

    public int getRepetir() {
        return repetir;
    }

    public void setRepetir(int repetir) {
        this.repetir = repetir;
    }

    public int getRepetir_tiempo() {
        return repetir_tiempo;
    }

    public void setRepetir_tiempo(int repetir_tiempo) {
        this.repetir_tiempo = repetir_tiempo;
    }

    public int getTipo_propagandas() {
        return tipo_propagandas;
    }

    public void setTipo_propagandas(int tipo_propagandas) {
        this.tipo_propagandas = tipo_propagandas;
    }
}
