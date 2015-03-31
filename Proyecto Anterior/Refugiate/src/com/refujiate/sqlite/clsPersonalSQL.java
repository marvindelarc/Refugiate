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
import com.refujiate.entidades.clsPersona;




public class clsPersonalSQL {
    
     public static void Agregar(Context context,clsPersona entidad)
    {
        clsSQLite admin=new clsSQLite(context, null);
        
        SQLiteDatabase bd=admin.getWritableDatabase();
        ContentValues registro=new ContentValues();
        registro.put("int_IdPersona",entidad.getInt_IdPersona());
        registro.put("str_Nombre",entidad.getStr_Nombre());
        registro.put("str_Apellido",entidad.getStr_Apellido());
        registro.put("str_Telefono",entidad.getStr_Telefono());
        registro.put("str_Email",entidad.getStr_Email());
        registro.put("str_Usuario",entidad.getStr_Usuario());
        registro.put("str_Password",entidad.getStr_Password());
        registro.put("str_DNI",entidad.getStr_DNI());
        bd.insert("usuario", null, registro);
        bd.close();



    }   
     
   
     public static  clsPersona Buscar(Context context)
     {
        clsPersona  entidad=null;
        clsSQLite admin=new clsSQLite(context, null);
        SQLiteDatabase bd=admin.getWritableDatabase();

        Cursor fila=bd.rawQuery("select int_IdPersona,str_Nombre,str_Apellido,str_Telefono,str_Email,str_Usuario,str_Password,str_DNI from usuario",null);

        if (fila.moveToFirst())
        {                    
            
            entidad= new clsPersona();            
            entidad.setInt_IdPersona(fila.getInt(0));
            entidad.setStr_Nombre(fila.getString(1));
            entidad.setStr_Apellido(fila.getString(2));
            entidad.setStr_Telefono(fila.getString(3));
            entidad.setStr_Email(fila.getString(4));
            entidad.setStr_Usuario(fila.getString(5));
            entidad.setStr_Password(fila.getString(6));
            entidad.setStr_DNI(fila.getString(7));
        }
        bd.close();   
        return entidad;
     }
     
     
     
     public static void Borrar(Context context) {
      clsSQLite admin=new clsSQLite(context, null);
     SQLiteDatabase bd=admin.getWritableDatabase();
     bd.delete("usuario", null, null);
     bd.close();
    }
   
}
