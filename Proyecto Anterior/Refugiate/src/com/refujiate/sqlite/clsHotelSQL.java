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
import com.refujiate.entidades.clsHotel;
import java.util.ArrayList;
import java.util.List;



/**
 *
 * @author Toditos
 */
public class clsHotelSQL {
    
    
     public static void Agregar(Context context,clsHotel entidad)
    {
        clsSQLite admin=new clsSQLite(context,null);
        SQLiteDatabase bd=admin.getWritableDatabase();
        ContentValues registro=new ContentValues();
        registro.put("int_IdHotel",entidad.getInt_IdHotel());
        registro.put("int_Estrellas",entidad.getInt_Estrellas());
        registro.put("str_Nombre",entidad.getStr_Nombre());
        registro.put("dou_Longitud",entidad.getDou_Longitud());
        registro.put("dou_Latitud",entidad.getDou_Latitud());
        registro.put("int_Tipo",entidad.getInt_Tipo());
        registro.put("int_Puntos",entidad.getInt_Puntos());
        bd.insert("hotel", null, registro);
        bd.close();


    }   
     
       public static  clsHotel Buscar(Context context,int Id)
     {
        clsHotel  entidad=null;
        clsSQLite admin=new clsSQLite(context,null); 
        SQLiteDatabase bd=admin.getWritableDatabase();

         Cursor fila=bd.rawQuery("select int_IdHotel,int_Estrellas,str_Nombre,dou_Longitud,dou_Latitud,int_Tipo from hotel where int_IdHotel="+Id,null);

        if (fila.moveToFirst())
        {                    
            entidad = new clsHotel();
            entidad.setInt_IdHotel(fila.getInt(0));
            entidad.setInt_Estrellas(fila.getInt(1));
            entidad.setStr_Nombre(fila.getString(2));
            entidad.setDou_Longitud(fila.getDouble(3));
            entidad.setDou_Latitud(fila.getDouble(4));
            entidad.setInt_Tipo(fila.getInt(5));    
           
        }
        bd.close();   
        return entidad;
     }
      public static  List<clsHotel> ListarTodos(Context context)
     {
        List<clsHotel> list=new ArrayList<clsHotel>();
         clsSQLite admin=new clsSQLite(context,null); 
        SQLiteDatabase bd=admin.getWritableDatabase();
        Cursor fila=bd.rawQuery("select int_IdHotel,int_Estrellas,str_Nombre,dou_Longitud,dou_Latitud,int_Tipo from hotel",null);

       int numRows = fila.getCount();   
        fila.moveToFirst();   
                for (int i = 0; i < numRows; ++i) 
                {   
                    clsHotel entidad = new clsHotel();
                    entidad.setInt_IdHotel(fila.getInt(0));
                    entidad.setInt_Estrellas(fila.getInt(1));
                    entidad.setStr_Nombre(fila.getString(2));
                    entidad.setDou_Longitud(fila.getDouble(3));
                    entidad.setDou_Latitud(fila.getDouble(4));
                    entidad.setInt_Tipo(fila.getInt(5));
                    
                    list.add(entidad);
                       
                    fila.moveToNext();   
                }   

        bd.close();   
        return list;
     }
     
       public static  List<clsHotel> ListarXFiltro(Context context, String filtro,int idTipoHotel,int idServicio,int puntaje,int estrellas)
      {
        List<clsHotel> list=new ArrayList<clsHotel>();
         clsSQLite admin=new clsSQLite(context,null); 
        SQLiteDatabase bd=admin.getWritableDatabase();
        String sql="select h.int_IdHotel,h.int_Estrellas,h.str_Nombre from hotel h LEFT join instalacion i on h.int_IdHotel=i.int_IdSucursal "
                + "LEFT join tipo_habitacion t on h.int_IdHotel=t.int_idSucursal where h.str_Nombre like '%"+filtro+"%'";
        if(idTipoHotel>0)
            sql+=" and t.int_idHabitacion="+idTipoHotel;
        if(idServicio>0)
            sql+=" and i.int_IdServicio="+idServicio;
        if(puntaje>0)
            sql+=" and h.int_Puntos>="+puntaje;
        if(estrellas>0)
            sql+=" and h.int_Estrellas>="+estrellas;
        
        sql+=" group by h.int_IdHotel order by h.int_Tipo desc";
        
        Cursor fila=bd.rawQuery(sql,null);

        int numRows = fila.getCount();   
        fila.moveToFirst();   
                for (int i = 0; i < numRows; ++i) 
                {   
                    clsHotel entidad = new clsHotel();
                    entidad.setInt_IdHotel(fila.getInt(0));
                    entidad.setInt_Estrellas(fila.getInt(1));
                    entidad.setStr_Nombre(fila.getString(2));
                    
                    list.add(entidad);
                       
                    fila.moveToNext();   
                }   

        bd.close();   
        return list;
     }
     
     public static void Borrar(Context context) {
     clsSQLite admin=new clsSQLite(context,null);
     SQLiteDatabase bd=admin.getWritableDatabase();
     bd.delete("hotel", null, null);
     bd.close();
    }
   
}
