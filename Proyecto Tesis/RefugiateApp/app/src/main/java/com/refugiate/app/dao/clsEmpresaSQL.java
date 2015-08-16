/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.refugiate.app.dao;



import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.refugiate.app.entidades.clsEmpresa;

import java.util.Date;


public class clsEmpresaSQL {

    private static String NOMBRE_TABLA="EMPRESA";

     public static int Agregar(Context context,clsEmpresa entidad)
    {
        int id;
        SQLite admin=new SQLite(context, null);
        SQLiteDatabase bd=admin.getWritableDatabase();
        bd.delete(NOMBRE_TABLA, "idEmpresa=" + entidad.getIdEmpresa() , null);

            ContentValues registro = new ContentValues();
            registro.put("idEmpresa", entidad.getIdEmpresa());
            registro.put("nombreComercial", entidad.getNombreComercial());
            registro.put("nombre", entidad.getNombre());
            registro.put("slogan", entidad.getSlogan());
            registro.put("ruc", entidad.getRuc());
            registro.put("puntos", entidad.getPuntos());
            registro.put("estado", entidad.getEstado());
            registro.put("logo", entidad.getLogo());
            registro.put("banner", entidad.getBanner());
            id = (int) bd.insert(NOMBRE_TABLA, null, registro);

        bd.close();
        return id;

    }


     public static void Borrar(Context context) {
         SQLite admin=new SQLite(context, null);
         SQLiteDatabase bd=admin.getWritableDatabase();
         bd.delete(NOMBRE_TABLA, null, null);
         bd.close();
    }
   
}
