/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.refugiate.app.dao;



import android.app.Activity;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.refugiate.app.entidades.clsConfiguracion;

import java.util.Date;




public class clsConfiguracionSQL {

    private static String NOMBRE_TABLA="CONFIGURACION";

    public static int  Agregar(Context context,clsConfiguracion entidad)
    {
        int id = 0;
        SQLite admin=new SQLite(context, null);
        SQLiteDatabase bd=admin.getWritableDatabase();
        bd.delete(NOMBRE_TABLA, null, null);
        ContentValues registro=new ContentValues();
        registro.put("idConfiguracion",1);
        registro.put("tiempo_actulizacion",entidad.getTiempo_actulizacion());
        registro.put("tiempo_actualizacion",new Date().getTime());
        registro.put("tiempo_previo_reserva",entidad.getTiempo_previo_reserva());
        registro.put("repetir",entidad.getRepetir());
        registro.put("repetir_tiempo",entidad.getRepetir_tiempo());
        registro.put("tipo_propagandas", entidad.getTipo_propagandas());
        id = (int) bd.insert(NOMBRE_TABLA, null, registro);
        bd.close();
        return id;

    }
    public static  clsConfiguracion Buscar(Context context)
     {
         clsConfiguracion  entidad=null;
         SQLite admin=new SQLite(context, null);
         SQLiteDatabase bd=admin.getWritableDatabase();

        Cursor fila=bd.rawQuery("select tiempo_actulizacion,tiempo_actualizacion,tiempo_previo_reserva,"
                + "repetir,repetir_tiempo,tipo_propagandas from "+NOMBRE_TABLA,null);

        if (fila.moveToFirst())
        {                    
            
            entidad= new clsConfiguracion();            
            entidad.setTiempo_actulizacion(fila.getInt(0));
            entidad.setTiempo_actualizacion(new Date(fila.getLong(1)));
            entidad.setTiempo_previo_reserva(fila.getInt(2));
            entidad.setRepetir(fila.getInt(3));
            entidad.setRepetir_tiempo(fila.getInt(4));
            entidad.setTipo_propagandas(fila.getInt(5));
        }
        bd.close();   
        return entidad;
     }
     
     public static void Borrar(Context context) {
         SQLite admin=new SQLite(context, null);
         SQLiteDatabase bd=admin.getWritableDatabase();
         bd.delete(NOMBRE_TABLA, null, null);
         bd.close();
    }
   
}
