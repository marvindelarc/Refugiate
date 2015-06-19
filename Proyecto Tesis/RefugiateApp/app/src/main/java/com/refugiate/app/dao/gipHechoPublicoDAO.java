/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.refugiate.app.dao;




import com.refugiate.app.entidades.gipHechoPublico;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
/**
 *
 * @author Toditos
 */
public class gipHechoPublicoDAO {
    
    private static String TABLA="GIP_HechoPublico";
    
     public static int Agregar(Context context,gipHechoPublico entidad)
    {
        int id = 0;
        SQLite admin=new SQLite(context,null);
        SQLiteDatabase bd=admin.getWritableDatabase();
        ContentValues registro=new ContentValues();
        registro.put("pk_id",entidad.getPk_id());
        registro.put("TipoHechoPublico",entidad.getTipoHechoPublico());
        registro.put("detalle",entidad.getDetalle());
        registro.put("longitud",entidad.getLongitud());
        registro.put("latitud",entidad.getLatitud());
        if(entidad.getImagen()!=null)
        registro.put("imagen",entidad.getImagen());

        id = (int) bd.insert(TABLA, null, registro);
        bd.close();    
        return id;
    }

    public  static boolean ActualizarDetalle(Context context,gipHechoPublico entidad)
    {
        SQLite admin=new SQLite(context,null);
        SQLiteDatabase bd = admin.getWritableDatabase();
        ContentValues registro = new ContentValues();
        registro.put("detalle",entidad.getDetalle());
        int cant = bd.update(TABLA, registro, "pk_id="+entidad.getPk_id(), null);
        bd.close();
        if(cant==1)
            return true;
        else
            return false;

    }
    public  static boolean ActualizarCombo (Context context,gipHechoPublico entidad)
    {
        SQLite admin=new SQLite(context,null);
        SQLiteDatabase bd = admin.getWritableDatabase();
        ContentValues registro = new ContentValues();
        registro.put("TipoHechoPublico",entidad.getTipoHechoPublico());
        int cant = bd.update(TABLA, registro, "pk_id="+entidad.getPk_id(), null);
        bd.close();
        if(cant==1)
            return true;
        else
            return false;

    }
    public  static boolean Actualizar(Context context,gipHechoPublico entidad)
     {
        SQLite admin=new SQLite(context,null);
        SQLiteDatabase bd = admin.getWritableDatabase();
        ContentValues registro = new ContentValues();
        registro.put("TipoHechoPublico",entidad.getTipoHechoPublico());
        registro.put("detalle",entidad.getDetalle());
        registro.put("longitud",entidad.getLongitud());
        registro.put("latitud",entidad.getLatitud());
        if(entidad.getImagen()!=null)
        registro.put("imagen",entidad.getImagen());
        
        int cant = bd.update(TABLA, registro, "pk_id="+entidad.getPk_id(), null);
        bd.close();
        if(cant==1)
            return true;
        else
            return false;
       
    }  
     
     public static  gipHechoPublico Buscar(Context context,int id)
     {
        gipHechoPublico  entidad=null;
        SQLite admin=new SQLite(context,null); 
        SQLiteDatabase bd=admin.getWritableDatabase();
         if(bd!=null)
         {
            String query="select pk_id,TipoHechoPublico,detalle,longitud,latitud,imagen from "+TABLA+" where pk_id="+id;

            Cursor fila=bd.rawQuery(query,null);
            if (fila.moveToFirst())
            {                    
                entidad= new gipHechoPublico();            
                entidad.setPk_id(fila.getInt(0));
                entidad.setTipoHechoPublico(fila.getInt(1));
                entidad.setDetalle(fila.getString(2));
                entidad.setLongitud(fila.getDouble(3));
                entidad.setLatitud(fila.getDouble(4));
                entidad.setImagen(fila.getBlob(5));
            }
        }
        bd.close();   
        return entidad;
     }

//     public static  List<gipHechoPublico> Listar(Context context)
//     {
//        List<gipHechoPublico> list=new ArrayList<gipHechoPublico>();
//        SQLite admin=new SQLite(context,null); 
//        SQLiteDatabase bd=admin.getWritableDatabase();
//         if(bd!=null)
//         {
//            String query="select pk_id,TipoHechoPublico,detalle,longitud,latitud,imagen from "+TABLA;
//
//            Cursor fila=bd.rawQuery(query,null);
//            int numRows = fila.getCount();   
//            fila.moveToFirst();   
//                for (int i = 0; i < numRows; ++i) 
//                {   
//			gipHechoPublico entidad= new gipHechoPublico();            
//                        entidad.setPk_id(fila.getInt(0));
//                        entidad.setTipoHechoPublico(fila.getInt(1));
//                        entidad.setDetalle(fila.getString(2));
//                        entidad.setLongitud(fila.getDouble(3));
//                        entidad.setLatitud(fila.getDouble(4));
//                        entidad.setImagen(fila.getBlob(5));
//                     
//			list.add(entidad);
//                       
//                     fila.moveToNext();   
//                }   
//         }
//        bd.close();   
//        return list;
//     }
////       
//     public static void BorrarXId(Context context, int id) {
//     SQLite admin=new SQLite(context,null);
//     SQLiteDatabase bd=admin.getWritableDatabase();
//     bd.delete(TABLA, "pk_id="+id, null);
//     bd.close();
//    }  
     public static void Borrar(Context context) {
     SQLite admin=new SQLite(context,null);
     SQLiteDatabase bd=admin.getWritableDatabase();
     bd.delete(TABLA, null, null);
     bd.close();
    }
   
}
