/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.refugiate.app.dao;



import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.refugiate.app.entidades.clsServicio;

import java.util.ArrayList;
import java.util.List;


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

    public static List<clsServicio> Listar(Context context)
    {
        List<clsServicio> list=new ArrayList<clsServicio>();
        SQLite admin=new SQLite(context, null);
        SQLiteDatabase bd=admin.getWritableDatabase();
        if(bd!=null)
        {
            String query="select distinct ser.idServicio,ser.nombre from "+NOMBRE_TABLA+" as ser inner join " +
                    "INSTALACION as ins on ins.idServicio=ser.idServicio";

            Cursor fila=bd.rawQuery(query,null);
            int numRows = fila.getCount();
            fila.moveToFirst();
            for (int i = 0; i < numRows; ++i)
            {
                clsServicio entidad= new clsServicio();
                entidad.setIdServicio(fila.getInt(0));
                entidad.setNombre(fila.getString(1));
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
