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
import com.refugiate.app.entidades.clsHabitacion;
import com.refugiate.app.entidades.clsTipoHabitacion;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


public class clsHabitacionSQL {

    private static String NOMBRE_TABLA="HABITACION";

     public static void Agregar(Context context,JSONArray listEmpresaJSON )
    {
        SQLite admin=new SQLite(context, null);
        SQLiteDatabase bd=admin.getWritableDatabase();
        bd.delete(NOMBRE_TABLA, null, null);
        try {

            for(int i=0;i<listEmpresaJSON.length();i++){
                JSONObject json_data = listEmpresaJSON.getJSONObject(i);
                ContentValues registro = new ContentValues();
                registro.put("idHabitacion", json_data.getInt("idHabitacion"));
                registro.put("numero",json_data.getInt("numero"));
                registro.put("piso",json_data.getInt("piso"));
                registro.put("estado",json_data.getInt("estado"));
                registro.put("idCostoTipoHabitacion", json_data.getInt("idCostoTipoHabitacion"));
                registro.put("vista", (json_data.getBoolean("vista"))?1:0);
                bd.insert(NOMBRE_TABLA, null, registro);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        bd.close();
    }

    public static List<clsHabitacion> Listar(Context context)
    {
        List<clsHabitacion> list=new ArrayList<clsHabitacion>();
        SQLite admin=new SQLite(context, null);
        SQLiteDatabase bd=admin.getWritableDatabase();
        if(bd!=null)
        {
            String query="select cos.idCostoTipoHabitacion,cos.costo,cos.numeroPersonas," +
                    "cos.totalHabitaciones,cos.idTipoHabitacion,tip.nombreComercial,hab.idHabitacion," +
                    "hab.numero,hab.piso,hab.estado,hab.vista from COSTOTIPOHABITACION" +
                    " as cos inner join TIPOHABITACION as tip on cos.idTipoHabitacion=tip.idTipoHabitacion" +
                    " inner join "+NOMBRE_TABLA+" as hab on hab.idCostoTipoHabitacion=cos.idCostoTipoHabitacion";

            Cursor fila=bd.rawQuery(query,null);
            int numRows = fila.getCount();
            fila.moveToFirst();
            for (int i = 0; i < numRows; ++i)
            {
                clsTipoHabitacion objTipoHabitacion = new clsTipoHabitacion();
                objTipoHabitacion.setIdTipoHabitacion(fila.getInt(4));
                objTipoHabitacion.setNombreComercial(fila.getString(5));

                clsCostoTipoHabitacion objCostoTipoHabitacion= new clsCostoTipoHabitacion();
                objCostoTipoHabitacion.setIdCostoTipoHabitacion(fila.getInt(0));
                objCostoTipoHabitacion.setCosto(fila.getDouble(1));
                objCostoTipoHabitacion.setNumeroPersonas(fila.getInt(2));
                objCostoTipoHabitacion.setTotalHabitaciones(fila.getInt(3));
                objCostoTipoHabitacion.setObjTipohabitacion(objTipoHabitacion);

                clsHabitacion entidad = new clsHabitacion();
                entidad.setIdHabitacion(fila.getInt(6));
                entidad.setNumero(fila.getInt(7));
                entidad.setPiso(fila.getInt(8));
                entidad.setEstado(fila.getInt(9));
                entidad.setVista((fila.getInt(10) == 1) ? true : false);
                entidad.setObjCostoTipoHabitacion(objCostoTipoHabitacion);
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
