/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.refugiate.app.dao;



import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.refugiate.app.entidades.clsServicio;


public class clsServicioSQL {

    private static String NOMBRE_TABLA="SERVICIO";

     public static int Agregar(Context context,clsServicio entidad)
    {
        int id;
        SQLite admin=new SQLite(context, null);
        SQLiteDatabase bd=admin.getWritableDatabase();
        bd.delete(NOMBRE_TABLA, "idServicio=" + entidad.getIdServicio(), null);

        ContentValues registro = new ContentValues();
            registro.put("idServicio", entidad.getIdServicio());
        registro.put("nombre", entidad.getNombre());
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
