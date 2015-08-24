/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.refugiate.app.dao;



import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.refugiate.app.entidades.clsDepartamento;
import com.refugiate.app.entidades.clsDistrito;
import com.refugiate.app.entidades.clsPersona;
import com.refugiate.app.entidades.clsProvincia;
import com.refugiate.app.utilidades.clsUbigeo;

import java.util.Date;


public class clsUbigeoSQL {


     public static void AgregarDepartamento(Context context)
    {
        SQLite admin=new SQLite(context, null);
        SQLiteDatabase bd=admin.getWritableDatabase();
        bd.delete("DEPARTAMENTO", null, null);
        for(clsDepartamento entidad: clsUbigeo.getListDepartamento()) {
            ContentValues registro = new ContentValues();
            registro.put("int_id_depatamento", entidad.getInt_id_depatamento());
            registro.put("str_nombre", entidad.getStr_nombre());
            bd.insert("DEPARTAMENTO", null, registro);
        }

        bd.close();
    }


    public static void AgregarDistrito(Context context)
    {
        SQLite admin=new SQLite(context, null);
        SQLiteDatabase bd=admin.getWritableDatabase();
        bd.delete("DISTRITO", null, null);
        for(clsDistrito entidad: clsUbigeo.getListDistrito()) {
            ContentValues registro = new ContentValues();
            registro.put("int_id_distrito", entidad.getInt_id_distrito());
            registro.put("int_id_provincia", entidad.getObjProvincia().getInt_id_provincia());
            registro.put("str_nombre", entidad.getStr_nombre());
            bd.insert("DISTRITO", null, registro);
        }

        bd.close();
    }

    public static void AgregarProvincia(Context context)
    {
        SQLite admin=new SQLite(context, null);
        SQLiteDatabase bd=admin.getWritableDatabase();
        bd.delete("PROVINCIA", null, null);
        for(clsProvincia entidad: clsUbigeo.getListProvincia()) {
            ContentValues registro = new ContentValues();
            registro.put("int_id_provincia", entidad.getInt_id_provincia());
            registro.put("int_id_depatamento", entidad.getObjDepartamento().getInt_id_depatamento());
            registro.put("str_nombre", entidad.getStr_nombre());
            bd.insert("PROVINCIA", null, registro);
        }

        bd.close();
    }


}
