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
import com.refujiate.entidades.clsInstalacion;
import java.util.ArrayList;
import java.util.List;



/**
 *
 * @author Toditos
 */
public class clsInstalacionSQL {
    
    
     public static void Agregar(Context context,clsInstalacion entidad)
    {
        clsSQLite admin=new clsSQLite(context,null);
        SQLiteDatabase bd=admin.getWritableDatabase();
        ContentValues registro=new ContentValues();
        registro.put("int_IdIntalacion",entidad.getInt_IdIntalacion());
        registro.put("int_IdServicio",entidad.getInt_IdServicio());
        registro.put("int_IdSucursal",entidad.getInt_IdSucursal());
        registro.put("str_Nombre",entidad.getStr_Nombre());
        registro.put("str_Descripcion",entidad.getStr_Descripcion());
        bd.insert("instalacion", null, registro);
        bd.close();


    }   
     
      public static  List<clsInstalacion> ListarTodos(Context context)
     {
        List<clsInstalacion> list=new ArrayList<clsInstalacion>();
        list.add(new clsInstalacion(0,"Todos"));
         clsSQLite admin=new clsSQLite(context,null); 
        SQLiteDatabase bd=admin.getWritableDatabase();
        Cursor fila=bd.rawQuery("select int_IdServicio,str_Nombre from instalacion group by int_IdServicio order by str_Nombre",null);

        int numRows = fila.getCount();   
        fila.moveToFirst();   
                for (int i = 0; i < numRows; ++i) 
                {   
                    clsInstalacion entidad = new clsInstalacion();
                    entidad.setInt_IdServicio(fila.getInt(0));
                    entidad.setStr_Nombre(fila.getString(1));
                    
                    list.add(entidad);
                       
                    fila.moveToNext();   
                }   

        bd.close();   
        return list;
     }
     
  
      public static  List<clsInstalacion> ListarXSucursal(Context context,int IdSucursal)
     {
        List<clsInstalacion> list=null;
         clsSQLite admin=new clsSQLite(context,null); 
        SQLiteDatabase bd=admin.getWritableDatabase();
        Cursor fila=bd.rawQuery("select int_IdServicio,str_Nombre,str_Descripcion from instalacion where int_IdSucursal="+IdSucursal+" order by str_Nombre",null);

        int numRows = fila.getCount();   
        fila.moveToFirst();   
                for (int i = 0; i < numRows; ++i) 
                {   
                    if(list==null)
                        list=new ArrayList<clsInstalacion>();
                    clsInstalacion entidad = new clsInstalacion();
                    entidad.setInt_IdServicio(fila.getInt(0));
                    entidad.setStr_Nombre(fila.getString(1));
                    entidad.setStr_Descripcion(fila.getString(2));
                    
                    list.add(entidad);
                       
                    fila.moveToNext();   
                }   

        bd.close();   
        return list;
     }
     
     public static void Borrar(Context context) {
     clsSQLite admin=new clsSQLite(context,null);
     SQLiteDatabase bd=admin.getWritableDatabase();
     bd.delete("instalacion", null, null);
     bd.close();
    }
   
}
