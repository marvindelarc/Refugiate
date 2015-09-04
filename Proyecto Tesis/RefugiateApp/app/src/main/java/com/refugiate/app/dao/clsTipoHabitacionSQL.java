/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.refugiate.app.dao;



import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.refugiate.app.entidades.clsTipoHabitacion;

import java.util.ArrayList;
import java.util.List;


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

    public static List<clsTipoHabitacion> Listar(Context context,int idSucursal)
    {
        List<clsTipoHabitacion> list=new ArrayList<clsTipoHabitacion>();
        SQLite admin=new SQLite(context, null);
        SQLiteDatabase bd=admin.getWritableDatabase();
        if(bd!=null)
        {
            String query="select distinct cos.idTipoHabitacion,tip.nombreComercial from COSTOTIPOHABITACION" +
                    " as cos inner join "+NOMBRE_TABLA+" as tip on cos.idTipoHabitacion=tip.idTipoHabitacion " +
                    "where cos.idSucursal="+idSucursal;

            Cursor fila=bd.rawQuery(query,null);
            int numRows = fila.getCount();
            fila.moveToFirst();
            for (int i = 0; i < numRows; ++i)
            {
                clsTipoHabitacion entidad = new clsTipoHabitacion();
                entidad.setIdTipoHabitacion(fila.getInt(0));
                entidad.setNombreComercial(fila.getString(1));
                list.add(entidad);

                fila.moveToNext();
            }
        }
        bd.close();
        return list;
    }

     public static void Borrar(Context context) {
         SQLite admin=new SQLite(context, null);
         SQLiteDatabase bd=admin.getWritableDatabase();
         bd.delete(NOMBRE_TABLA, null, null);
         bd.close();
    }
   
}
