/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.refugiate.app.dao;




import com.refugiate.app.entidades.gipPersona;
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
public class gipPersonaDAO {
    
    private static String TABLA="GIP_Persona";
    
     public static int Agregar(Context context,gipPersona entidad)
    {
        int id = 0;
        SQLite admin=new SQLite(context,null);
        SQLiteDatabase bd=admin.getWritableDatabase();
        ContentValues registro=new ContentValues();
        registro.put("pk_id",entidad.getPk_id());
        registro.put("nombres",entidad.getNombres());
        registro.put("apellidos",entidad.getApellidos());
        registro.put("apelativos",entidad.getApelativos());
        registro.put("detalle",entidad.getDetalle());
//        if(entidad.getImagen()!=null)
//        registro.put("imagen",entidad.getImagen());
    
        id = (int) bd.insert(TABLA, null, registro);
        bd.close();    
        return id;
    }   

     
     public  static boolean Actualizar(Context context,gipPersona entidad) 
     {
        SQLite admin=new SQLite(context,null);
        SQLiteDatabase bd = admin.getWritableDatabase();
        ContentValues registro = new ContentValues();
        registro.put("nombres",entidad.getNombres());
        registro.put("apellidos",entidad.getApellidos());
        registro.put("apelativos",entidad.getApelativos());
        registro.put("detalle",entidad.getDetalle());
        
        int cant = bd.update(TABLA, registro, "pk_id="+entidad.getPk_id(), null);
        bd.close();
        if(cant==1)
            return true;
        else
            return false;
       
    }  
     
     public static  gipPersona Buscar(Context context,int id)
     {
        gipPersona  entidad=null;
        SQLite admin=new SQLite(context,null); 
        SQLiteDatabase bd=admin.getWritableDatabase();
         if(bd!=null)
         {
            String query="select pk_id,nombres,apellidos,apelativos,detalle from "+TABLA+" where pk_id="+id;

            Cursor fila=bd.rawQuery(query,null);
            if (fila.moveToFirst())
            {                    
                entidad= new gipPersona();            
                entidad.setPk_id(fila.getInt(0));
                entidad.setNombres(fila.getString(1));
                entidad.setApellidos(fila.getString(2));
                entidad.setApelativos(fila.getString(3));
                entidad.setDetalle(fila.getString(4));
            }
        }
        bd.close();   
        return entidad;
     }

     public static  List<gipPersona> Listar(Context context)
     {
        List<gipPersona> list=new ArrayList<gipPersona>();
        SQLite admin=new SQLite(context,null); 
        SQLiteDatabase bd=admin.getWritableDatabase();
         if(bd!=null)
         {
            String query="select pk_id,nombres,apellidos,apelativos,detalle from "+TABLA;

            Cursor fila=bd.rawQuery(query,null);
            int numRows = fila.getCount();   
            fila.moveToFirst();   
                for (int i = 0; i < numRows; ++i) 
                {   
			gipPersona entidad= new gipPersona();            
                        entidad.setPk_id(fila.getInt(0));
                        entidad.setNombres(fila.getString(1));
                        entidad.setApellidos(fila.getString(2));
                        entidad.setApelativos(fila.getString(3));
                        entidad.setDetalle(fila.getString(4));
                     
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
