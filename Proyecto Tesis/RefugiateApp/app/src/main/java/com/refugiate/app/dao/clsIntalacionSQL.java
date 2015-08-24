/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.refugiate.app.dao;



import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.refugiate.app.entidades.clsInstalacion;


public class clsIntalacionSQL {

    private static String NOMBRE_TABLA="INSTALACION";

     public static int Agregar(Context context,clsInstalacion entidad)
    {
        int id;
        SQLite admin=new SQLite(context, null);
        SQLiteDatabase bd=admin.getWritableDatabase();
        bd.delete(NOMBRE_TABLA, "idInstalacion=" + entidad.getIdInstalacion(), null);

        ContentValues registro = new ContentValues();
            registro.put("idInstalacion", entidad.getIdInstalacion());
            registro.put("descripcion", entidad.getDescripcion());
            registro.put("idServicio", entidad.getObjServicio().getIdServicio());
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
