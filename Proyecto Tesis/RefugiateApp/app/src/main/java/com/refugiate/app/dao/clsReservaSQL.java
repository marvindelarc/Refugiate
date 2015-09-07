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
import com.refugiate.app.entidades.clsEmpresa;
import com.refugiate.app.entidades.clsHabitacion;
import com.refugiate.app.entidades.clsReserva;
import com.refugiate.app.entidades.clsSucursal;
import com.refugiate.app.entidades.clsTipoHabitacion;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class clsReservaSQL {

    private static String NOMBRE_TABLA="RESERVA";

    public static void AgregarServicio(Context context,JSONArray listReservaJSON)
    {

        SQLite admin=new SQLite(context, null);
        SQLiteDatabase bd=admin.getWritableDatabase();
        try {
            for(int i=0;i<listReservaJSON.length();i++){
                JSONObject json_data = listReservaJSON.getJSONObject(i);
                bd.delete(NOMBRE_TABLA, "idReserva=" + json_data.getInt("idReserva"), null);
                ContentValues registro = new ContentValues();
                registro.put("idReserva",json_data.getInt("idReserva"));
                registro.put("fechaResgistro", json_data.getLong("fechaResgistro"));
                registro.put("fechaIngreso",json_data.getLong("fechaIngreso"));
                registro.put("fechaEgreso", json_data.getLong("fechaEgreso"));
                registro.put("estado", json_data.getInt("estado"));
                registro.put("costo",json_data.getDouble("costo"));
                registro.put("dias", json_data.getInt("dias"));
                registro.put("servicio", json_data.getInt("servicio"));
                registro.put("comodidad", json_data.getInt("comodidad"));
                registro.put("limpieza", json_data.getInt("limpieza"));
                registro.put("comentario",json_data.getString("comentario"));
                registro.put("idCostoTipoHabitacion", json_data.getInt("idCostoTipoHabitacion"));
                registro.put("idHabitacion", json_data.getInt("idHabitacion"));
                registro.put("vista", (json_data.getBoolean("vista"))? 1 : 0);
                registro.put("numero",json_data.getInt("numero"));
                registro.put("piso",json_data.getInt("piso"));
                bd.insert(NOMBRE_TABLA, null, registro);
            }
        } catch (JSONException e) {
        e.printStackTrace();
    }

        bd.close();

    }

    public static int Agregar(Context context,clsReserva entidad)
    {
        int id;
        SQLite admin=new SQLite(context, null);
        SQLiteDatabase bd=admin.getWritableDatabase();
        ContentValues registro = new ContentValues();
        registro.put("idReserva", entidad.getIdReserva());
        registro.put("fechaResgistro", new Date().getTime());
        registro.put("fechaIngreso", entidad.getFechaIngreso().getTime());
        registro.put("fechaEgreso", entidad.getFechaEgreso().getTime());
        registro.put("estado", entidad.getEstado());
        registro.put("costo", entidad.getCosto());
        registro.put("dias", entidad.getDias());

        registro.put("idCostoTipoHabitacion", entidad.getObjHabitacion().getObjCostoTipoHabitacion().getIdCostoTipoHabitacion());
        registro.put("idHabitacion", entidad.getObjHabitacion().getIdHabitacion());

        registro.put("vista", (entidad.getObjHabitacion().isVista())?1:0);
        registro.put("numero",entidad.getObjHabitacion().getNumero());
        registro.put("piso",entidad.getObjHabitacion().getPiso());
        id = (int) bd.insert(NOMBRE_TABLA, null, registro);


        bd.close();
        return id;

    }

    public static List<clsReserva> ListarAcivas(Context context)
    {
        List<clsReserva> list=new ArrayList<clsReserva>();
        SQLite admin=new SQLite(context, null);
        SQLiteDatabase bd=admin.getWritableDatabase();
        if(bd!=null)
        {
            Date fecha=new Date();
            fecha.setSeconds(0);
            String query="select res.idReserva,res.fechaResgistro,res.fechaIngreso,res.fechaEgreso," +
                    "res.estado,res.costo,res.dias,res.idHabitacion,res.vista,res.numero,res.piso," +
                    "res.idCostoTipoHabitacion,cos.costo,cos.idTipoHabitacion,tip.nombreComercial,suc.idSucursal," +
                    "suc.nivel,emp.idEmpresa,emp.nombreComercial,emp.logo from "+NOMBRE_TABLA+" as res inner join COSTOTIPOHABITACION " +
                    "as cos on cos.idCostoTipoHabitacion=res.idCostoTipoHabitacion inner join TIPOHABITACION " +
                    "as tip on cos.idTipoHabitacion=tip.idTipoHabitacion inner join SUCURSAL as suc on " +
                    "suc.idSucursal=cos.idSucursal inner join EMPRESA as emp on suc.idEmpresa=emp.idEmpresa  " +
                    "where res.fechaIngreso>="+fecha.getTime()+" and res.estado=1 order by res.fechaIngreso asc";

            Cursor fila=bd.rawQuery(query,null);
            int numRows = fila.getCount();
            fila.moveToFirst();
            for (int i = 0; i < numRows; ++i)
            {
                clsEmpresa objEmpresa = new clsEmpresa();
                objEmpresa.setIdEmpresa(fila.getInt(17));
                objEmpresa.setNombreComercial(fila.getString(18));
                objEmpresa.setLogo(fila.getBlob(19));

                clsSucursal objSucursal = new clsSucursal();
                objSucursal.setIdSucursal(fila.getInt(15));
                objSucursal.setNivel(fila.getInt(16));
                objSucursal.setObjEmpresa(objEmpresa);

                clsTipoHabitacion objTipohabitacion =new clsTipoHabitacion();
                objTipohabitacion.setIdTipoHabitacion(fila.getInt(13));
                objTipohabitacion.setNombreComercial(fila.getString(14));

                clsCostoTipoHabitacion objCostoTipoHabitacion = new clsCostoTipoHabitacion();
                objCostoTipoHabitacion.setIdCostoTipoHabitacion(fila.getInt(11));
                objCostoTipoHabitacion.setCosto(fila.getDouble(12));
                objCostoTipoHabitacion.setObjTipohabitacion(objTipohabitacion);
                objCostoTipoHabitacion.setObjSucursal(objSucursal);

                clsHabitacion objHabitacion = new clsHabitacion();
                objHabitacion.setIdHabitacion(fila.getInt(7));
                objHabitacion.setVista((fila.getInt(8) == 1) ? true : false);
                objHabitacion.setNumero(fila.getInt(9));
                objHabitacion.setPiso(fila.getInt(10));
                objHabitacion.setObjCostoTipoHabitacion(objCostoTipoHabitacion);

                clsReserva entidad= new clsReserva();
                entidad.setIdReserva(fila.getInt(0));
                entidad.setFechaResgistro(new Date(fila.getLong(1)));
                entidad.setFechaIngreso(new Date(fila.getLong(2)));
                entidad.setFechaEgreso(new Date(fila.getLong(3)));
                entidad.setEstado(fila.getInt(4));
                entidad.setCosto(fila.getDouble(5));
                entidad.setDias(fila.getInt(6));
                entidad.setObjHabitacion(objHabitacion);
                list.add(entidad);

                fila.moveToNext();
            }
        }
        bd.close();
        return list;
    }

    public static List<clsReserva> ListarHistorial(Context context)
    {
        List<clsReserva> list=new ArrayList<clsReserva>();
        SQLite admin=new SQLite(context, null);
        SQLiteDatabase bd=admin.getWritableDatabase();
        if(bd!=null)
        {
            Date fecha=new Date();
            fecha.setSeconds(0);
            String query="select res.idReserva,res.fechaResgistro,res.fechaIngreso,res.fechaEgreso," +
                    "res.estado,res.costo,res.dias,res.idHabitacion,res.vista,res.numero,res.piso," +
                    "res.idCostoTipoHabitacion,cos.costo,cos.idTipoHabitacion,tip.nombreComercial,suc.idSucursal," +
                    "suc.nivel,emp.idEmpresa,emp.nombreComercial,emp.logo,res.servicio,res.comodidad," +
                    "res.limpieza,res.comentario from "+NOMBRE_TABLA+" as res inner join COSTOTIPOHABITACION " +
                    "as cos on cos.idCostoTipoHabitacion=res.idCostoTipoHabitacion inner join TIPOHABITACION " +
                    "as tip on cos.idTipoHabitacion=tip.idTipoHabitacion inner join SUCURSAL as suc on " +
                    "suc.idSucursal=cos.idSucursal inner join EMPRESA as emp on suc.idEmpresa=emp.idEmpresa  " +
                    "where res.fechaIngreso<="+fecha.getTime()+" or res.estado!=1 order by res.fechaIngreso asc";

            Cursor fila=bd.rawQuery(query,null);
            int numRows = fila.getCount();
            fila.moveToFirst();
            for (int i = 0; i < numRows; ++i)
            {
                clsEmpresa objEmpresa = new clsEmpresa();
                objEmpresa.setIdEmpresa(fila.getInt(17));
                objEmpresa.setNombreComercial(fila.getString(18));
                objEmpresa.setLogo(fila.getBlob(19));

                clsSucursal objSucursal = new clsSucursal();
                objSucursal.setIdSucursal(fila.getInt(15));
                objSucursal.setNivel(fila.getInt(16));
                objSucursal.setObjEmpresa(objEmpresa);

                clsTipoHabitacion objTipohabitacion =new clsTipoHabitacion();
                objTipohabitacion.setIdTipoHabitacion(fila.getInt(13));
                objTipohabitacion.setNombreComercial(fila.getString(14));

                clsCostoTipoHabitacion objCostoTipoHabitacion = new clsCostoTipoHabitacion();
                objCostoTipoHabitacion.setIdCostoTipoHabitacion(fila.getInt(11));
                objCostoTipoHabitacion.setCosto(fila.getDouble(12));
                objCostoTipoHabitacion.setObjTipohabitacion(objTipohabitacion);
                objCostoTipoHabitacion.setObjSucursal(objSucursal);

                clsHabitacion objHabitacion = new clsHabitacion();
                objHabitacion.setIdHabitacion(fila.getInt(7));
                objHabitacion.setVista((fila.getInt(8) == 1) ? true : false);
                objHabitacion.setNumero(fila.getInt(9));
                objHabitacion.setPiso(fila.getInt(10));
                objHabitacion.setObjCostoTipoHabitacion(objCostoTipoHabitacion);

                clsReserva entidad= new clsReserva();
                entidad.setIdReserva(fila.getInt(0));
                entidad.setFechaResgistro(new Date(fila.getLong(1)));
                entidad.setFechaIngreso(new Date(fila.getLong(2)));
                entidad.setFechaEgreso(new Date(fila.getLong(3)));
                entidad.setEstado(fila.getInt(4));
                entidad.setCosto(fila.getDouble(5));
                entidad.setDias(fila.getInt(6));

                entidad.setServicio(fila.getInt(20));
                entidad.setComodidad(fila.getInt(21));
                entidad.setLimpieza(fila.getInt(22));
                entidad.setComentario(fila.getString(23));
                entidad.setObjHabitacion(objHabitacion);
                list.add(entidad);

                fila.moveToNext();
            }
        }
        bd.close();
        return list;
    }
    public  static boolean setCancelar(Context context,int Id) {

        SQLite admin = new SQLite(context, null);
        SQLiteDatabase bd = admin.getWritableDatabase();
        ContentValues registro = new ContentValues();
        registro = new ContentValues();
        registro.put("estado", 2);
        int cant = bd.update(NOMBRE_TABLA, registro, "idReserva=" + Id, null);

        bd.close();
        if (cant == 1)
            return true;
        else
            return false;
    }
    public  static boolean setCometario(Context context,clsReserva entidad)
    {

        SQLite admin=new SQLite(context, null);
        SQLiteDatabase bd = admin.getWritableDatabase();
        ContentValues registro = new ContentValues();
        registro = new ContentValues();
        registro.put("estado", 3);
        registro.put("servicio", entidad.getServicio());
        registro.put("comodidad", entidad.getComodidad());
        registro.put("limpieza", entidad.getLimpieza());
        registro.put("comentario", entidad.getComentario());
        int cant = bd.update(NOMBRE_TABLA, registro, "idReserva=" + entidad.getIdReserva(), null);

        bd.close();
        if(cant==1)
            return true;
        else
            return false;
    }
     public static void Borrar(Context context) {
         SQLite admin=new SQLite(context, null);
         SQLiteDatabase bd=admin.getWritableDatabase();
         bd.delete(NOMBRE_TABLA, null, null);
         bd.close();
    }
   
}
