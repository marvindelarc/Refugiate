/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.refugiate.app.dao;



import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.refugiate.app.entidades.clsTipoHabitacion;


public class clsTipoHabitacionSQL {

    private static String NOMBRE_TABLA="TIPOHABITACION";

     public static int Agregar(Context context,clsTipoHabitacion entidad)
    {
        int id;
        SQLite admin=new SQLite(context, null);
        SQLiteDatabase bd=admin.getWritableDatabase();
        bd.delete(NOMBRE_TABLA, "idTipoHabitacion=" + entidad.getIdTipoHabitacion(), null);

            ContentValues registro = new ContentValues();
            registro.put("idTipoHabitacion", entidad.getIdTipoHabitacion());
            registro.put("nombreComercial", entidad.getNombreComercial());
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
