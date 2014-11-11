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
import com.refujiate.entidades.clsTipoHabitacion;
import java.util.ArrayList;
import java.util.List;



/**
 *
 * @author Toditos
 */
public class clsTipoHabitacionSQL {
    
    
     public static void Agregar(Context context,clsTipoHabitacion entidad)
    {
        clsSQLite admin=new clsSQLite(context,null);
        SQLiteDatabase bd=admin.getWritableDatabase();
        ContentValues registro=new ContentValues();
        registro.put("int_idTipoHabitacion",entidad.getInt_idTipoHabitacion());
        registro.put("int_idHabitacion",entidad.getInt_idHabitacion());
        registro.put("str_Nombre",entidad.getStr_Nombre());
        registro.put("int_idSucursal",entidad.getInt_idSucursal());
        bd.insert("tipo_habitacion", null, registro);
        bd.close();


    }   
     
      public static  List<clsTipoHabitacion> ListarTodos(Context context)
     {
        List<clsTipoHabitacion> list=new ArrayList<clsTipoHabitacion>();
        list.add(new clsTipoHabitacion(0,"Todos"));
         clsSQLite admin=new clsSQLite(context,null); 
        SQLiteDatabase bd=admin.getWritableDatabase();
        Cursor fila=bd.rawQuery("select int_idHabitacion,str_Nombre from tipo_habitacion group by int_idHabitacion order by str_Nombre",null);

       int numRows = fila.getCount();   
        fila.moveToFirst();   
                for (int i = 0; i < numRows; ++i) 
                {   
                    clsTipoHabitacion entidad = new clsTipoHabitacion();
                    entidad.setInt_idHabitacion(fila.getInt(0));
                    entidad.setStr_Nombre(fila.getString(1));
                    
                    list.add(entidad);
                       
                    fila.moveToNext();   
                }   

        bd.close();   
        return list;
     }
     
  
     public static void Borrar(Context context) {
     clsSQLite admin=new clsSQLite(context,null);
     SQLiteDatabase bd=admin.getWritableDatabase();
     bd.delete("tipo_habitacion", null, null);
     bd.close();
    }
   
}
