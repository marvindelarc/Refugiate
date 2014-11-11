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
import com.refujiate.entidades.clsComentario;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



/**
 *
 * @author Toditos
 */
public class clsComentarioSQL {
    
    
     public static void Agregar(Context context,clsComentario entidad)
    {
        clsSQLite admin=new clsSQLite(context,null);
        SQLiteDatabase bd=admin.getWritableDatabase();
        ContentValues registro=new ContentValues();
        registro.put("int_IdComentario",entidad.getInt_IdComentario());
        registro.put("int_IdReserva",entidad.getInt_IdReserva());
        registro.put("str_Descripcion",entidad.getStr_Descripcion());
        registro.put("dat_Fecha",entidad.getDat_Fecha().getTime());
        registro.put("str_Usuario",entidad.getStr_Usuario());   
        bd.insert("comentario", null, registro);
        bd.close();

    }   
     

      
       public static  List<clsComentario> Listar(Context context)
     {
        List<clsComentario> list=new ArrayList<clsComentario>();
         clsSQLite admin=new clsSQLite(context,null); 
        SQLiteDatabase bd=admin.getWritableDatabase();
        String query="select int_IdComentario,int_IdReserva,str_Descripcion,dat_Fecha,str_Usuario from comentario order by int_IdComentario desc";
        
        Cursor fila=bd.rawQuery(query,null);

       int numRows = fila.getCount();   
        fila.moveToFirst();   
                for (int i = 0; i < numRows; ++i) 
                {   
                    clsComentario entidad = new clsComentario();;
                    entidad.setInt_IdComentario(fila.getInt(0));
                    entidad.setInt_IdReserva(fila.getInt(1));
                    entidad.setStr_Descripcion(fila.getString(2));
                    entidad.setDat_Fecha(new Date(fila.getLong(3))); 
                    entidad.setStr_Usuario(fila.getString(4));
                    list.add(entidad);
                       
                    fila.moveToNext();   
                }   

        bd.close();   
        return list;
     }
     
      
     public static void BorrarXId(Context context,int Id) {
     clsSQLite admin=new clsSQLite(context,null);
     SQLiteDatabase bd=admin.getWritableDatabase();
     bd.delete("comentario", "int_IdComentario="+Id, null);
     bd.close();
    }
     public static void Borrar(Context context) {
     clsSQLite admin=new clsSQLite(context,null);
     SQLiteDatabase bd=admin.getWritableDatabase();
     bd.delete("comentario", null, null);
     bd.close();
    }
   
}
