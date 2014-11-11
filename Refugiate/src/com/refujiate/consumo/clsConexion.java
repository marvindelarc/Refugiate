package com.refujiate.consumo;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.refujiate.entidades.clsComentario;
import com.refujiate.entidades.clsDetalleReserva;
import com.refujiate.entidades.clsPersona;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

public class clsConexion {
    public static String urlEstatica="http://refugiate.no-ip.biz:8084/";
    public static String readTexto(String urlStr) {
        try {
            HttpClient client = new DefaultHttpClient();
            HttpGet get = new HttpGet(urlEstatica+urlStr);
            HttpResponse responseGet = client.execute(get);
            HttpEntity resEntityGet = responseGet.getEntity();

            if (resEntityGet != null) {
                return  EntityUtils.toString(resEntityGet).trim();
            } else {
                return "-1";
            }
        } catch (Exception e) {
             return "-1";
        }
    }

    public static Bitmap getImage(String urlStr) {
           Bitmap loadedImage=null; 
        try {
            HttpClient client = new DefaultHttpClient();
            HttpGet get = new HttpGet(urlEstatica+urlStr);
            HttpResponse responseGet = client.execute(get);
            HttpEntity resEntityGet = responseGet.getEntity();
            
            if (resEntityGet != null) {
                 loadedImage = BitmapFactory.decodeStream(resEntityGet.getContent());
            }
        } catch (Exception e) {   
        }
        return loadedImage;
    }
     
    public static boolean TestConectividad(Context contex) {
        ConnectivityManager cm = (ConnectivityManager) contex.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        if (netInfo != null && netInfo.isConnectedOrConnecting()) {
            return true;
        }
        return false;
    }
       
    public static String postResgitrarPersona(clsPersona entidad) {
        // Create a new HttpClient and Post Header
        HttpClient client = new DefaultHttpClient();
        HttpPost httppost = new HttpPost(urlEstatica+"servicio/registroPersona.jsp");

        try {
            // Add your data
            List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(8);
            nameValuePairs.add(new BasicNameValuePair("nombre", entidad.getStr_Nombre()));
            nameValuePairs.add(new BasicNameValuePair("apellido", entidad.getStr_Apellido()));        
            nameValuePairs.add(new BasicNameValuePair("dni",entidad.getStr_DNI()));        
            nameValuePairs.add(new BasicNameValuePair("email",entidad.getStr_Email()));
            nameValuePairs.add(new BasicNameValuePair("telefono", entidad.getStr_Telefono()));        
            nameValuePairs.add(new BasicNameValuePair("info", ""+entidad.getInt_Informacion()));
            nameValuePairs.add(new BasicNameValuePair("pass", entidad.getStr_Password()));
            nameValuePairs.add(new BasicNameValuePair("usuario", entidad.getStr_Usuario()));
            httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));

            // Execute HTTP Post Request
            HttpResponse responseGet = client.execute(httppost);
            HttpEntity resEntityGet = responseGet.getEntity();
                if (resEntityGet != null) {
                        return  EntityUtils.toString(resEntityGet).trim();
                }
            } catch (ClientProtocolException e) {
                return "-1";
            } catch (IOException e) {
                return "-1";
            }
        return "-1";
    } 
   
     public static String postActualizaPersona(clsPersona entidad) {
        // Create a new HttpClient and Post Header
        HttpClient client = new DefaultHttpClient();
        HttpPost httppost = new HttpPost(urlEstatica+"servicio/actualizarPersona.jsp");

        try {
            // Add your data
            List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(5);
             nameValuePairs.add(new BasicNameValuePair("IdPersona", ""+entidad.getInt_IdPersona()));
            nameValuePairs.add(new BasicNameValuePair("nombre", entidad.getStr_Nombre()));
            nameValuePairs.add(new BasicNameValuePair("apellido", entidad.getStr_Apellido()));        
            nameValuePairs.add(new BasicNameValuePair("dni",entidad.getStr_DNI()));        
            nameValuePairs.add(new BasicNameValuePair("email",entidad.getStr_Email()));
            nameValuePairs.add(new BasicNameValuePair("telefono", entidad.getStr_Telefono()));  
            httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));

            // Execute HTTP Post Request
            HttpResponse responseGet = client.execute(httppost);
            HttpEntity resEntityGet = responseGet.getEntity();
                if (resEntityGet != null) {
                        return  EntityUtils.toString(resEntityGet).trim();
                }
            } catch (ClientProtocolException e) {
                return "-1";
            } catch (IOException e) {
                return "-1";
            }
        return "-1";
    } 
   
    public static String postRegistraDetalle(clsDetalleReserva entidad) {
        // Create a new HttpClient and Post Header
        HttpClient client = new DefaultHttpClient();
        HttpPost httppost = new HttpPost(urlEstatica+"servicio/registroDetalleReserva.jsp");

        try {
            // Add your data
            List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(6);
            nameValuePairs.add(new BasicNameValuePair("fecha", ""+entidad.getDat_Fecha().getTime()));
            nameValuePairs.add(new BasicNameValuePair("IdCostoTipo",""+entidad.getInt_IdCostoTipoHabitacion()));        
            nameValuePairs.add(new BasicNameValuePair("IdReserva",""+entidad.getInt_IdReserva()));        
            nameValuePairs.add(new BasicNameValuePair("nHabitaciones",""+entidad.getInt_NHabitaciones()));
            nameValuePairs.add(new BasicNameValuePair("dias", ""+entidad.getInt_Dias()));        
            nameValuePairs.add(new BasicNameValuePair("total", ""+entidad.getDou_Total()));
            httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));

            // Execute HTTP Post Request
            HttpResponse responseGet = client.execute(httppost);
            HttpEntity resEntityGet = responseGet.getEntity();
                if (resEntityGet != null) {
                        return  EntityUtils.toString(resEntityGet).trim();
                }        
            } catch (ClientProtocolException e) {
                return "-1";
            } catch (IOException e) {
                return "-1";
            }
         return "-1";
    } 
    
     public static String postRegistraComentario(clsComentario entidad) {
        // Create a new HttpClient and Post Header
        HttpClient client = new DefaultHttpClient();
        HttpPost httppost = new HttpPost(urlEstatica+"servicio/registroComentario.jsp");

        try {
            // Add your data
            List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(2);
            nameValuePairs.add(new BasicNameValuePair("IdReserva", ""+entidad.getInt_IdReserva()));
            nameValuePairs.add(new BasicNameValuePair("comentario",""+entidad.getStr_Descripcion()));   
            httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));

            // Execute HTTP Post Request
            HttpResponse responseGet = client.execute(httppost);
            HttpEntity resEntityGet = responseGet.getEntity();
                if (resEntityGet != null) {
                        return  EntityUtils.toString(resEntityGet).trim();
                }        
            } catch (ClientProtocolException e) {
                return "-1";
            } catch (IOException e) {
                return "-1";
            }
         return "-1";
    } 
}
