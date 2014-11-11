/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.refujiate.sqlite;



import android.app.Activity;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.refujiate.entidades.clsConfiguracion;
import java.util.Date;




public class clsConfiguracionSQL {
    
     public static void Agregar(Context context,clsConfiguracion entidad)
    {
        Borrar(context);
        clsSQLite admin=new clsSQLite(context, null);    
        SQLiteDatabase bd=admin.getWritableDatabase();
        ContentValues registro=new ContentValues();
        registro.put("int_IdConfiguracion",1);
        registro.put("int_tiempo_actulizacion",entidad.getInt_tiempo_actulizacion());
        registro.put("dat_tiempo_actualizacion",new Date().getTime());
        registro.put("int_tiempo_previo_reserva",entidad.getInt_tiempo_previo_reserva());
        registro.put("int_repetir",entidad.getInt_repetir());
        registro.put("int_repetir_tiempo",entidad.getInt_repetir_tiempo());
        registro.put("int_tipo_propagandas",entidad.getInt_tipo_propagandas());
        bd.insert("configuracion", null, registro);
        bd.close();



    }   
     
   
     public static  clsConfiguracion Buscar(Context context)
     {
        clsConfiguracion  entidad=null;
        clsSQLite admin=new clsSQLite(context, null);
        SQLiteDatabase bd=admin.getWritableDatabase();

        Cursor fila=bd.rawQuery("select int_tiempo_actulizacion,dat_tiempo_actualizacion,int_tiempo_previo_reserva,"
                + "int_repetir,int_repetir_tiempo,int_tipo_propagandas from configuracion",null);

        if (fila.moveToFirst())
        {                    
            
            entidad= new clsConfiguracion();            
            entidad.setInt_tiempo_actulizacion(fila.getInt(0));
            entidad.setDat_tiempo_actualizacion(new Date(fila.getLong(1)));
            entidad.setInt_tiempo_previo_reserva(fila.getInt(2));
            entidad.setInt_repetir(fila.getInt(3));
            entidad.setInt_repetir_tiempo(fila.getInt(4));
            entidad.setInt_tipo_propagandas(fila.getInt(5));
        }
        bd.close();   
        return entidad;
     }
     
     
     
     public static void Borrar(Context context) {
      clsSQLite admin=new clsSQLite(context, null);
     SQLiteDatabase bd=admin.getWritableDatabase();
     bd.delete("configuracion", null, null);
     bd.close();
    }
   
}
