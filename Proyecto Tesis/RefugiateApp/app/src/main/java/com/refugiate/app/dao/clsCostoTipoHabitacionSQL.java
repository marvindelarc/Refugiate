/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.refugiate.app.dao;



import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.refugiate.app.entidades.clsCostoTipoHabitacion;
import com.refugiate.app.entidades.clsTipoHabitacion;

import java.util.ArrayList;
import java.util.List;


public class clsCostoTipoHabitacionSQL {

    private static String NOMBRE_TABLA="COSTOTIPOHABITACION";

     public static int Agregar(Context context,clsCostoTipoHabitacion entidad)
    {
        int id;
        SQLite admin=new SQLite(context, null);
        SQLiteDatabase bd=admin.getWritableDatabase();
        bd.delete(NOMBRE_TABLA, "idCostoTipoHabitacion=" + entidad.getIdCostoTipoHabitacion(), null);

            ContentValues registro = new ContentValues();
            registro.put("idCostoTipoHabitacion", entidad.getIdCostoTipoHabitacion());
            registro.put("costo", entidad.getCosto());
            registro.put("numeroPersonas", entidad.getNumeroPersonas());
            registro.put("totalHabitaciones", entidad.getTotalHabitaciones());
            registro.put("habitacionesOcupadas", entidad.getHabitacionesOcupadas());
            registro.put("estado", entidad.getEstado());
            registro.put("idTipoHabitacion", entidad.getObjTipohabitacion().getIdTipoHabitacion());
            registro.put("idSucursal", entidad.getObjSucursal().getIdSucursal());
            id = (int) bd.insert(NOMBRE_TABLA, null, registro);
        bd.close();
        return id;

    }
    public static int getMimCosto(Context context)
    {
        int rpta=0;
        SQLite admin=new SQLite(context, null);
        SQLiteDatabase bd=admin.getWritableDatabase();
        if(bd!=null)
        {
            String query="select min(costo) from "+NOMBRE_TABLA;

            Cursor fila=bd.rawQuery(query,null);
            if (fila.moveToFirst())
            {
                rpta=(int)fila.getDouble(0)-1;
            }
        }
        bd.close();
        return rpta;
    }

    public static int getMaxCosto(Context context)
    {
        int rpta=0;
        SQLite admin=new SQLite(context, null);
        SQLiteDatabase bd=admin.getWritableDatabase();
        if(bd!=null)
        {
            String query="select max(costo) from "+NOMBRE_TABLA;

            Cursor fila=bd.rawQuery(query,null);
            if (fila.moveToFirst())
            {
                rpta=(int)fila.getDouble(0)+1;
            }
        }
        bd.close();
        return rpta;
    }
    public static List<clsCostoTipoHabitacion> Listar(Context context,int idSucursal,int idTipoHabitacion)
    {
        List<clsCostoTipoHabitacion> list=new ArrayList<clsCostoTipoHabitacion>();
        SQLite admin=new SQLite(context, null);
        SQLiteDatabase bd=admin.getWritableDatabase();
        if(bd!=null)
        {
            String query="select cos.idCostoTipoHabitacion,cos.costo,cos.numeroPersonas," +
                    "cos.totalHabitaciones,cos.idTipoHabitacion,tip.nombreComercial from "+NOMBRE_TABLA+
                    " as cos inner join TIPOHABITACION as tip on cos.idTipoHabitacion=tip.idTipoHabitacion " +
                    "where cos.idSucursal="+idSucursal;
            if(idTipoHabitacion>0)
                query=query+" and tip.idTipoHabitacion="+idTipoHabitacion;
            Cursor fila=bd.rawQuery(query,null);
            int numRows = fila.getCount();
            fila.moveToFirst();
            for (int i = 0; i < numRows; ++i)
            {
                clsTipoHabitacion objTipoHabitacion = new clsTipoHabitacion();
                objTipoHabitacion.setIdTipoHabitacion(fila.getInt(4));
                objTipoHabitacion.setNombreComercial(fila.getString(5));

                clsCostoTipoHabitacion entidad= new clsCostoTipoHabitacion();
                entidad.setIdCostoTipoHabitacion(fila.getInt(0));
                entidad.setCosto(fila.getDouble(1));
                entidad.setNumeroPersonas(fila.getInt(2));
                entidad.setTotalHabitaciones(fila.getInt(3));
                entidad.setObjTipohabitacion(objTipoHabitacion);

                list.add(entidad);

                fila.moveToNext();
            }
        }
        bd.close();
        return list;
    }

     public static void Borrar(Context context) {
         SQLite admin=new SQLite(context, null);
         SQLiteDatabase bd=admin.getWritableDatabase();
         bd.delete(NOMBRE_TABLA, null, null);
         bd.close();
    }
   
}
