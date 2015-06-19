/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.refugiate.app.dao;




import com.refugiate.app.entidades.gipVehiculo;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Toditos
 */
public class gipVehiculoDAO {
    
    private static String TABLA="GIP_Vehiculo";
    
     public static int Agregar(Context context,gipVehiculo entidad)
    {
        int id = 0;
        SQLite admin=new SQLite(context,null);
        SQLiteDatabase bd=admin.getWritableDatabase();
        ContentValues registro=new ContentValues();
        registro.put("pk_id",entidad.getPk_id());
        registro.put("TipoVehiculo",entidad.getTipoVehiculo());
        registro.put("modelo",entidad.getModelo());
        registro.put("marca",entidad.getMarca());
        registro.put("placa",entidad.getPlaca());
        registro.put("color",entidad.getColor());
        registro.put("detalle",entidad.getDetalle());
//        if(entidad.getImagen()!=null)
//        registro.put("imagen",entidad.getImagen());
	 
        id = (int) bd.insert(TABLA, null, registro);
        bd.close();    
        return id;
    }   

     
     public  static boolean Actualizar(Context context,gipVehiculo entidad) 
     {
        SQLite admin=new SQLite(context,null);
        SQLiteDatabase bd = admin.getWritableDatabase();
        ContentValues registro = new ContentValues();
       registro.put("TipoVehiculo",entidad.getTipoVehiculo());
        registro.put("modelo",entidad.getModelo());
        registro.put("marca",entidad.getMarca());
        registro.put("placa",entidad.getPlaca());
        registro.put("color",entidad.getColor());
        registro.put("detalle",entidad.getDetalle());
        
        int cant = bd.update(TABLA, registro, "pk_id="+entidad.getPk_id(), null);
        bd.close();
        if(cant==1)
            return true;
        else
            return false;
       
    }  
     
     public static  gipVehiculo Buscar(Context context,int id)
     {
        gipVehiculo  entidad=null;
        SQLite admin=new SQLite(context,null); 
        SQLiteDatabase bd=admin.getWritableDatabase();
         if(bd!=null)
         {
            String query="select pk_id,TipoVehiculo,modelo,marca,placa,color,detalle from "+TABLA+" where pk_id="+id;

            Cursor fila=bd.rawQuery(query,null);
            if (fila.moveToFirst())
            {                    
                entidad= new gipVehiculo();            
                entidad.setPk_id(fila.getInt(0));
                entidad.setTipoVehiculo(fila.getInt(1));
                entidad.setModelo(fila.getString(2));
                entidad.setMarca(fila.getString(3));
                entidad.setPlaca(fila.getString(4));
                entidad.setColor(fila.getString(5));
                entidad.setDetalle(fila.getString(6));
            }
        }
        bd.close();   
        return entidad;
     }

     public static  List<gipVehiculo> Listar(Context context)
     {
        List<gipVehiculo> list=new ArrayList<gipVehiculo>();
        SQLite admin=new SQLite(context,null); 
        SQLiteDatabase bd=admin.getWritableDatabase();
         if(bd!=null)
         {
            String query="select pk_id,TipoVehiculo,modelo,marca,placa,color,detalle from "+TABLA;

            Cursor fila=bd.rawQuery(query,null);
            int numRows = fila.getCount();   
            fila.moveToFirst();   
                for (int i = 0; i < numRows; ++i) 
                {   
			gipVehiculo entidad= new gipVehiculo();            
                        entidad.setPk_id(fila.getInt(0));
                        entidad.setTipoVehiculo(fila.getInt(1));
                        entidad.setModelo(fila.getString(2));
                        entidad.setMarca(fila.getString(3));
                        entidad.setPlaca(fila.getString(4));
                        entidad.setColor(fila.getString(5));
                        entidad.setDetalle(fila.getString(6));
                     
			list.add(entidad);
                       
                     fila.moveToNext();   
                }   
         }
        bd.close();   
        return list;
     }
//       
     public static void BorrarXId(Context context, int id) {
     SQLite admin=new SQLite(context,null);
     SQLiteDatabase bd=admin.getWritableDatabase();
     bd.delete(TABLA, "pk_id="+id, null);
     bd.close();
    }  
     public static void Borrar(Context context) {
     SQLite admin=new SQLite(context,null);
     SQLiteDatabase bd=admin.getWritableDatabase();
     bd.delete(TABLA, null, null);
     bd.close();
    }
   
}
