package com.refugiate.app.conexion;


import android.os.AsyncTask;
import android.util.Log;

import com.refugiate.app.entidades.clsReserva;
import com.refugiate.app.utilidades.Utilidades;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.util.ArrayList;
import java.util.List;

public class ComentarHTTP extends AsyncTask<Object, Integer, String>
{
    private static HttpClient client;
    private static HttpResponse responseGet;
    private static HttpEntity resEntityGet;

    @Override
    protected String doInBackground(Object... params)
    {
        clsReserva entidad = (clsReserva)params[0];

        String result = null;
        client = new DefaultHttpClient();
        HttpPost httppost = new HttpPost(Utilidades.url);

        try {
            List<NameValuePair> Value = new ArrayList<NameValuePair>();
            Value.add(new BasicNameValuePair("idServicio","7"));
            Value.add(new BasicNameValuePair("idReserva",""+entidad.getIdReserva()));
            Value.add(new BasicNameValuePair("comentario",entidad.getComentario()));
            Value.add(new BasicNameValuePair("comodidad",""+entidad.getComodidad()));
            Value.add(new BasicNameValuePair("servicio",""+entidad.getServicio()));
            Value.add(new BasicNameValuePair("limpieza",""+entidad.getLimpieza()));
            httppost.setEntity(new UrlEncodedFormEntity(Value));
            responseGet = client.execute(httppost);
            resEntityGet = responseGet.getEntity();
            if (resEntityGet != null) {
                result= EntityUtils.toString(resEntityGet).trim();
            }
        }catch (Exception e)
        {
            Log.e(e.getClass().getName(), e.getMessage());
        }
        return result;
    }

    @Override
    protected void onPostExecute(String result)
    {
        super.onPostExecute(result);
    }


}
