/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.refugiate.app.dao;




import com.refugiate.app.entidades.gipUsuario;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
/**
 *
 * @author Toditos
 */
public class gipUsuarioDAO {
    
    private static String TABLA="GIP_Usuario";
    
     public static int Agregar(Context context,gipUsuario entidad)
    {
        int id = 0;
        SQLite admin=new SQLite(context,null);
        SQLiteDatabase bd=admin.getWritableDatabase();
        ContentValues registro=new ContentValues();
        registro.put("pk_id",entidad.getPk_id());

        if(entidad.isMail())
            registro.put("mail",1);
        else
            registro.put("mail",0);

        if(entidad.isVoz())
            registro.put("voz",1);
        else
            registro.put("voz",0);
        

        id = (int) bd.insert(TABLA, null, registro);
        bd.close();    
        return id;
    }   

     
     public  static boolean Actualizar(Context context,gipUsuario entidad) 
     {
        SQLite admin=new SQLite(context,null);
        SQLiteDatabase bd = admin.getWritableDatabase();
        ContentValues registro = new ContentValues();
         if(entidad.isMail())
             registro.put("mail",1);
         else
             registro.put("mail",0);

         if(entidad.isVoz())
             registro.put("voz",1);
         else
             registro.put("voz",0);
        
        int cant = bd.update(TABLA, registro, "pk_id="+entidad.getPk_id(), null);
        bd.close();
        if(cant==1)
            return true;
        else
            return false;
       
    }  
     
     public static  gipUsuario Buscar(Context context,int id)
     {
        gipUsuario  entidad=null;
        SQLite admin=new SQLite(context,null); 
        SQLiteDatabase bd=admin.getWritableDatabase();
         if(bd!=null)
         {
            String query="select pk_id,mail,voz from "+TABLA+" where pk_id="+id;

            Cursor fila=bd.rawQuery(query,null);
            if (fila.moveToFirst())
            {                    
                entidad= new gipUsuario();            
                entidad.setPk_id(fila.getInt(0));

                if(fila.getInt(1)==1)
                    entidad.setMail(true);
                else
                    entidad.setMail(false);

                if(fila.getInt(2)==1)
                entidad.setVoz(true);
                else
                    entidad.setVoz(false);
            }
        }
        bd.close();   
        return entidad;
     }


     public static void Borrar(Context context) {
     SQLite admin=new SQLite(context,null);
     SQLiteDatabase bd=admin.getWritableDatabase();
     bd.delete(TABLA, null, null);
     bd.close();
    }
   
}
