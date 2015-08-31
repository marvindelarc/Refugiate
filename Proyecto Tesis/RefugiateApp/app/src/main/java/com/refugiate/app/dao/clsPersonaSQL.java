/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.refugiate.app.dao;



import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.refugiate.app.entidades.clsPersona;

import java.util.Date;


public class clsPersonaSQL {

    private static String NOMBRE_TABLA="PERSONA";

     public static int Agregar(Context context,clsPersona entidad)
    {
        int id;
        SQLite admin=new SQLite(context, null);
        SQLiteDatabase bd=admin.getWritableDatabase();
        bd.delete(NOMBRE_TABLA, null, null);
            ContentValues registro = new ContentValues();
            registro.put("IdPersona", entidad.getIdPersona());
            registro.put("nombre", entidad.getNombre());
            registro.put("apellido", entidad.getApellido());
            registro.put("telefono", entidad.getTelefono());
            registro.put("email", entidad.getEmail());
            registro.put("DNI", entidad.getEmail());
            registro.put("fecnac", entidad.getFecnac().getTime());
            registro.put("usuario", entidad.getUsuario());
            registro.put("password", entidad.getPassword());
            registro.put("sexo",(entidad.isSexo()) ? 1 : 0);
            id = (int) bd.insert(NOMBRE_TABLA, null, registro);

        bd.close();
        return id;
    }

    public static  clsPersona getSeleccionado(Context context)
    {
        clsPersona  entidad=null;
        SQLite admin=new SQLite(context, null);
        SQLiteDatabase bd=admin.getWritableDatabase();
        if(bd!=null)
        {
            String query="select IdPersona,nombre,apellido,telefono,email,DNI,fecnac,usuario,password,sexo from "+NOMBRE_TABLA;

            Cursor fila=bd.rawQuery(query,null);
            if (fila.moveToFirst())
            {
                entidad= new clsPersona();
                entidad.setIdPersona(fila.getInt(0));
                entidad.setNombre(fila.getString(1));
                entidad.setApellido(fila.getString(2));
                entidad.setTelefono(fila.getString(3));
                entidad.setEmail(fila.getString(4));
                entidad.setDNI(fila.getString(5));
                entidad.setFecnac(new Date(fila.getLong(6)));
                entidad.setUsuario(fila.getString(7));
                entidad.setPassword(fila.getString(8));
                entidad.setSexo((fila.getInt(9)==1)?true:false);

            }
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
