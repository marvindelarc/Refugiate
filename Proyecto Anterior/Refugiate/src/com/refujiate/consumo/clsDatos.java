package com.refujiate.consumo;

import android.content.Context;
import com.refujiate.entidades.clsHotel;
import com.refujiate.entidades.clsInstalacion;
import com.refujiate.entidades.clsTipoHabitacion;
import com.refujiate.sqlite.clsHotelSQL;
import com.refujiate.sqlite.clsInstalacionSQL;
import com.refujiate.sqlite.clsTipoHabitacionSQL;

public class clsDatos {
     
    public static boolean setListaHoteles(Context context)
    {
         String data= clsConexion.readTexto("servicio/listarHoteles.jsp");
          if(!data.trim().equals("0"))
          {
           clsHotelSQL.Borrar(context);
           String [] lista = data.split("\\<+cls+>");   
           for(int i=0;i<lista.length;i++)
           {
                clsHotel entidad = new clsHotel(lista[i].trim());
                clsHotelSQL.Agregar(context,entidad);
           }          
          }
          else
              return false;
          return true;
    }
    
    public static boolean setListaTipoHabitacion(Context context)
    {
         String data= clsConexion.readTexto("servicio/listarTipoHabitaciones.jsp");
          if(!data.trim().equals("0"))
          {
           clsTipoHabitacionSQL.Borrar(context);
           String [] lista = data.split("\\<+cls+>");   
           for(int i=0;i<lista.length;i++)
           {
                clsTipoHabitacion entidad = new clsTipoHabitacion(lista[i].trim());                
                clsTipoHabitacionSQL.Agregar(context,entidad);   
           }          
          }
          else
              return false;
          return true;
    }
      
    public static boolean setListaInstalacion(Context context)
    {
         String data= clsConexion.readTexto("servicio/listarInstalacion.jsp");
          if(!data.trim().equals("0"))
          {
           clsInstalacionSQL.Borrar(context);
           String [] lista = data.split("\\<+cls+>");   
           for(int i=0;i<lista.length;i++)
           {
                clsInstalacion entidad = new clsInstalacion(lista[i].trim());                
                clsInstalacionSQL.Agregar(context,entidad);
           }          
          }
          else
              return false;
          return true;
    }
}