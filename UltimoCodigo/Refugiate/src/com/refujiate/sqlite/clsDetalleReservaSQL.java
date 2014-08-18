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
import com.refujiate.entidades.clsDetalleReserva;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



/**
 *
 * @author Toditos
 */
public class clsDetalleReservaSQL {
    
    
     public static void Agregar(Context context,clsDetalleReserva entidad)
    {
        clsSQLite admin=new clsSQLite(context,null);
        SQLiteDatabase bd=admin.getWritableDatabase();
        ContentValues registro=new ContentValues();
        registro.put("int_IdDetalleReserva",entidad.getInt_IdDetalleReserva());
        registro.put("int_IdReserva",entidad.getInt_IdReserva());
        registro.put("dat_Fecha",entidad.getDat_Fecha().getTime());
        registro.put("int_IdCostoTipoHabitacion",entidad.getInt_IdCostoTipoHabitacion());
        registro.put("int_NHabitaciones",entidad.getInt_NHabitaciones());
        registro.put("int_Dias",entidad.getInt_Dias());
        registro.put("dou_Total",entidad.getDou_Total());
        registro.put("TipoHabitacion",entidad.getTipoHabitacion());
        registro.put("NombreHotel",entidad.getNombreHotel());
        registro.put("int_IdComentario",entidad.getInt_IdComentario());
        registro.put("int_IdPuntuacion",entidad.getInt_IdPuntuacion());
        bd.insert("detalle_reserva", null, registro);
        bd.close();

    }   
      public  static boolean ActualizarPuntuacion(Context context,int int_IdReserva,int IdPuntacion) {
        clsSQLite admin=new clsSQLite(context,null);
        SQLiteDatabase bd = admin.getWritableDatabase();
        ContentValues registro = new ContentValues();
        registro.put("int_IdPuntuacion", IdPuntacion);
        int cant = bd.update("detalle_reserva", registro, "int_IdReserva=" + int_IdReserva, null);
        bd.close();
        if (cant == 1)
            return true;
        
         return false;
    }
      
       public  static boolean ActualizarComentario(Context context,int int_IdReserva,int IdComentario) {
        clsSQLite admin=new clsSQLite(context,null);
        SQLiteDatabase bd = admin.getWritableDatabase();
        ContentValues registro = new ContentValues();
        registro.put("int_IdComentario", IdComentario);
        int cant = bd.update("detalle_reserva", registro, "int_IdReserva=" + int_IdReserva, null);
        bd.close();
        if (cant == 1)
            return true;
        
         return false;
    }

      public static  List<clsDetalleReserva> ListarTodos(Context context)
     {
        List<clsDetalleReserva> list=new ArrayList<clsDetalleReserva>();
         clsSQLite admin=new clsSQLite(context,null); 
        SQLiteDatabase bd=admin.getWritableDatabase();
        Date fecha=new Date();
        fecha.setHours(0);
        fecha.setMinutes(0);
        fecha.setSeconds(0);
        String query="select int_IdDetalleReserva,int_IdReserva,dat_Fecha,int_IdCostoTipoHabitacion,int_NHabitaciones,"
                + "int_Dias,dou_Total,TipoHabitacion,NombreHotel,int_IdComentario,int_IdPuntuacion from detalle_reserva where dat_Fecha>="+fecha.getTime();      
        query+=" order by int_IdDetalleReserva desc";
        
        Cursor fila=bd.rawQuery(query,null);

       int numRows = fila.getCount();   
        fila.moveToFirst();   
                for (int i = 0; i < numRows; ++i) 
                {   
                    clsDetalleReserva entidad = new clsDetalleReserva();
                    entidad.setInt_IdDetalleReserva(fila.getInt(0));
                    entidad.setInt_IdReserva(fila.getInt(1));
                    entidad.setDat_Fecha(new Date(fila.getLong(2)));
                    entidad.setInt_IdCostoTipoHabitacion(fila.getInt(3));
                    entidad.setInt_NHabitaciones(fila.getInt(4));
                    entidad.setInt_Dias(fila.getInt(5));
                    entidad.setDou_Total(fila.getDouble(6));
                    entidad.setTipoHabitacion(fila.getString(7));
                    entidad.setNombreHotel(fila.getString(8));
                    entidad.setInt_IdComentario(fila.getInt(9));
                    entidad.setInt_IdPuntuacion(fila.getInt(10));
                    list.add(entidad);
                       
                    fila.moveToNext();   
                }   

        bd.close();   
        return list;
     }
     
        public static  clsDetalleReserva getReservaXFecha(Context context)
     {
        clsDetalleReserva entidad=null;
         clsSQLite admin=new clsSQLite(context,null); 
        SQLiteDatabase bd=admin.getWritableDatabase();
        Date fecha=new Date();
        fecha.setHours(0);
        fecha.setMinutes(0);
        fecha.setSeconds(0);
        String query="select int_IdDetalleReserva,int_IdReserva,dat_Fecha,int_IdCostoTipoHabitacion,int_NHabitaciones,"
                + "int_Dias,dou_Total,TipoHabitacion,NombreHotel,int_IdComentario,int_IdPuntuacion from detalle_reserva where dat_Fecha>="+fecha.getTime();      
        query+=" order by dat_Fecha asc limit 1";
        
        Cursor fila=bd.rawQuery(query,null);
        
                if (fila.moveToFirst())
                {     
                    entidad = new clsDetalleReserva();
                    entidad.setInt_IdDetalleReserva(fila.getInt(0));
                    entidad.setInt_IdReserva(fila.getInt(1));
                    entidad.setDat_Fecha(new Date(fila.getLong(2)));
                    entidad.setInt_IdCostoTipoHabitacion(fila.getInt(3));
                    entidad.setInt_NHabitaciones(fila.getInt(4));
                    entidad.setInt_Dias(fila.getInt(5));
                    entidad.setDou_Total(fila.getDouble(6));
                    entidad.setTipoHabitacion(fila.getString(7));
                    entidad.setNombreHotel(fila.getString(8));
                    entidad.setInt_IdComentario(fila.getInt(9));
                    entidad.setInt_IdPuntuacion(fila.getInt(10));
  
                }   

        bd.close();   
        return entidad;
     }
     
       public static  List<clsDetalleReserva> ListarFinalizadas(Context context)
     {
        List<clsDetalleReserva> list=new ArrayList<clsDetalleReserva>();
         clsSQLite admin=new clsSQLite(context,null); 
        SQLiteDatabase bd=admin.getWritableDatabase();
        Date fecha=new Date();
        fecha.setHours(0);
        fecha.setMinutes(0);
        fecha.setSeconds(0);
        String query="select int_IdReserva,max(dat_Fecha),sum(dou_Total),sum(int_NHabitaciones),NombreHotel,int_IdComentario,int_IdPuntuacion from detalle_reserva where dat_Fecha<"+fecha.getTime()
                +" group by int_IdReserva order by int_IdDetalleReserva desc";
        
        Cursor fila=bd.rawQuery(query,null);

       int numRows = fila.getCount();   
        fila.moveToFirst();   
                for (int i = 0; i < numRows; ++i) 
                {   
                    clsDetalleReserva entidad = new clsDetalleReserva();;
                    entidad.setInt_IdReserva(fila.getInt(0));
                    entidad.setDat_Fecha(new Date(fila.getLong(1)));
                    entidad.setDou_Total(fila.getDouble(2));
                    entidad.setInt_NHabitaciones(fila.getInt(3));
                    entidad.setNombreHotel(fila.getString(4));                    
                    entidad.setInt_IdComentario(fila.getInt(5));
                    entidad.setInt_IdPuntuacion(fila.getInt(6));
                    list.add(entidad);
                       
                    fila.moveToNext();   
                }   

        bd.close();   
        return list;
     }
     
     public static void BorrarXId(Context context,int id) {
     clsSQLite admin=new clsSQLite(context,null);
     SQLiteDatabase bd=admin.getWritableDatabase();
     bd.delete("detalle_reserva", "int_IdDetalleReserva="+id, null);
     bd.close();
    }
    
     public static void Borrar(Context context) {
     clsSQLite admin=new clsSQLite(context,null);
     SQLiteDatabase bd=admin.getWritableDatabase();
     bd.delete("detalle_reserva", null, null);
     bd.close();
    }
   
}
