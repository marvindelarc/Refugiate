/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.refugiate.app.dao;



import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.refugiate.app.entidades.clsCostoTipoHabitacion;


public class clsCostoTipoHabitacionSQL {

    private static String NOMBRE_TABLA="COSTOTIPOHABITACION";

     public static int Agregar(Context context,clsCostoTipoHabitacion entidad)
    {
        int id;
        SQLite admin=new SQLite(context, null);
        SQLiteDatabase bd=admin.getWritableDatabase();
        bd.delete(NOMBRE_TABLA, "idCostoTipoHabitacion=" + entidad.getIdCostoTipoHabitacion(), null);

            ContentValues registro = new ContentValues();
            registro.put("idCostoTipoHabitacion", entidad.getIdCostoTipoHabitacion());
            registro.put("costo", entidad.getCosto());
            registro.put("numeroPersonas", entidad.getNumeroPersonas());
            registro.put("totalHabitaciones", entidad.getTotalHabitaciones());
            registro.put("habitacionesOcupadas", entidad.getHabitacionesOcupadas());
            registro.put("estado", entidad.getEstado());
            registro.put("idTipoHabitacion", entidad.getObjTipohabitacion().getIdTipoHabitacion());
            registro.put("idSucursal", entidad.getObjSucursal().getIdSucursal());
            id = (int) bd.insert(NOMBRE_TABLA, null, registro);
        bd.close();
        return id;

    }


     public static void Borrar(Context context) {
         SQLite admin=new SQLite(context, null);
         SQLiteDatabase bd=admin.getWritableDatabase();
         bd.delete(NOMBRE_TABLA, null, null);
         bd.close();
    }
   
}
