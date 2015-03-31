/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.refujiate.extra;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.location.Location;
import android.os.Environment;
import com.refujiate.consumo.clsConexion;
import com.refujiate.entidades.clsHotel;
import com.refujiate.sqlite.clsHotelSQL;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class clsUtilidades {
      
       public static List<clsHotel> getBusquedaMapa(Location location,int tipo,Context context)
       {
        int Radius = 6371000; //Radio de la tierra
        List<clsHotel> getLista=new ArrayList<clsHotel>();
        int distancia=0;
        if(tipo==0 || location==null)
            return clsHotelSQL.ListarTodos(context);
        if(tipo==1)
            distancia=1000;
        else if(tipo==2)
            distancia=5000;
        else if(tipo==3)
            distancia=10000;
            
            
        for(clsHotel entidad:clsHotelSQL.ListarTodos(context))
        {
            double dLat = Math.toRadians(entidad.getDou_Latitud()-location.getLatitude());
            double dLon = Math.toRadians(entidad.getDou_Longitud()-location.getLongitude());
            double a = Math.sin(dLat / 2) * Math.sin(dLat / 2) + Math.cos(Math.toRadians(location.getLatitude())) * Math.cos(Math.toRadians(entidad.getDou_Longitud())) * Math.sin(dLon /2) * Math.sin(dLon/2);
            double c = 2 * Math.asin(Math.sqrt(a));
            int metros= (int) (Radius * c);  
            if(distancia>=metros)            
            getLista.add(entidad);
        } 
        return getLista;
        }     
      
}
