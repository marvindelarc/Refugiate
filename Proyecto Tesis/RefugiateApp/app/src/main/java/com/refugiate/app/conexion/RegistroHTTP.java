package com.refugiate.app.conexion;


import android.os.AsyncTask;
import android.util.Log;

import com.refugiate.app.entidades.clsPersona;
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

public class RegistroHTTP extends AsyncTask<Object, Integer, String>
{
    private static HttpClient client;
    private static HttpResponse responseGet;
    private static HttpEntity resEntityGet;

    @Override
    protected String doInBackground(Object... params)
    {
        clsPersona entidad = (clsPersona)params[0];

        String result = null;
        client = new DefaultHttpClient();
        HttpPost httppost = new HttpPost(Utilidades.url);

        try {
            List<NameValuePair> Value = new ArrayList<NameValuePair>();
            Value.add(new BasicNameValuePair("idServicio","2"));
            Value.add(new BasicNameValuePair("nombre",entidad.getNombre()));
            Value.add(new BasicNameValuePair("apellido",entidad.getApellido()));
            Value.add(new BasicNameValuePair("telefono",entidad.getTelefono()));
            Value.add(new BasicNameValuePair("email",entidad.getEmail()));
            Value.add(new BasicNameValuePair("dni",entidad.getDNI()));
            Value.add(new BasicNameValuePair("usuario",entidad.getUsuario()));
            Value.add(new BasicNameValuePair("password",entidad.getPassword()));
            Value.add(new BasicNameValuePair("sexo",""+entidad.isSexo()));
            Value.add(new BasicNameValuePair("fecnac",""+entidad.getFecnac().getTime()));

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
