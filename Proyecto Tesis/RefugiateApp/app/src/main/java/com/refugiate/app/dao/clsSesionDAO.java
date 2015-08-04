/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.refugiate.app.dao;




import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.refugiate.app.entidades.clsSesion;
import java.util.Date;


public class clsSesionDAO {
    
    private static String TABLA="SESION";
    
     public static int Agregar(Context context,clsSesion entidad)
    {
        int id = 0;
        SQLite admin=new SQLite(context,null);
        SQLiteDatabase bd=admin.getWritableDatabase();
        ContentValues registro=new ContentValues();
        registro.put("pk_id",1);
        registro.put("fecha",entidad.getFecha().getTime());
        registro.put("minutos",entidad.getMinutos());
        id = (int) bd.insert(TABLA, null, registro);
        bd.close();    
        return id;
    }   

     

     public static  clsSesion Buscar(Context context,int id)
     {
        clsSesion  entidad=null;
        SQLite admin=new SQLite(context,null); 
        SQLiteDatabase bd=admin.getWritableDatabase();
         if(bd!=null)
         {
            String query="select fecha,minutos from "+TABLA+" where pk_id=1";

            Cursor fila=bd.rawQuery(query,null);
            if (fila.moveToFirst())
            {                    
                entidad= new clsSesion();            
                entidad.setFecha(new Date(fila.getLong(0)));
                entidad.setMinutos(fila.getInt(1));
            }
        }
        bd.close();   
        return entidad;
     }


     public static void Borrar(Context context) {
     SQLite admin=new SQLite(context,null);
     SQLiteDatabase bd=admin.getWritableDatabase();
     bd.delete(TABLA, null, null);
     bd.close();
    }
   
}
