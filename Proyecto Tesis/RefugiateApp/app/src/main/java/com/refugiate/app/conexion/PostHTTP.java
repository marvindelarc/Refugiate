package com.refugiate.app.conexion;


import android.os.AsyncTask;
import android.util.Log;

import com.refugiate.app.entidades.gipHechoPublico;
import com.refugiate.app.entidades.gipInmueble;
import com.refugiate.app.entidades.gipPersona;
import com.refugiate.app.entidades.gipVehiculo;
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

public class PostHTTP extends AsyncTask<Object, Integer, String>
{
    private static HttpClient client;
    private static HttpResponse responseGet;
    private static HttpEntity resEntityGet;

	@Override
	protected String doInBackground(Object... params)
	{
        gipHechoPublico objHechoPublico = (gipHechoPublico)params[0];
        gipPersona objPersona = (gipPersona)params[1];
        gipVehiculo objVehiculo = (gipVehiculo)params[2];
        gipInmueble objInmueble = (gipInmueble)params[3];
        String result = null;
        String image64= Utilidades.getBase64(720, 480);
        client = new DefaultHttpClient();
        HttpPost httppost = new HttpPost(Utilidades.url);

        try {
            List<NameValuePair> Value = new ArrayList<NameValuePair>();
            Value.add(new BasicNameValuePair("tipoHechoPublico",""+objHechoPublico.getTipoHechoPublico()));
            Value.add(new BasicNameValuePair("detalle",""+objHechoPublico.getDetalle()));
            Value.add(new BasicNameValuePair("latitud",""+objHechoPublico.getLatitud()));
            Value.add(new BasicNameValuePair("longitud",""+objHechoPublico.getLongitud()));
            
            if(image64!=null)
                Value.add(new BasicNameValuePair("imagen", image64));

            if(objHechoPublico.getEmail()!=null)
                Value.add(new BasicNameValuePair("email", objHechoPublico.getEmail()));

            if(objPersona!=null) {
                if(objPersona.getNombres()!=null)
                    Value.add(new BasicNameValuePair("nombres", objPersona.getNombres()));
                if(objPersona.getApellidos()!=null)
                    Value.add(new BasicNameValuePair("apellidos", objPersona.getApellidos()));
                if(objPersona.getApelativos()!=null)
                    Value.add(new BasicNameValuePair("apelativos", objPersona.getApelativos()));
                if(objPersona.getDetalle()!=null)
                    Value.add(new BasicNameValuePair("detalle", objPersona.getDetalle()));
            }

            if(objVehiculo!=null) {

                Value.add(new BasicNameValuePair("tipoVehiculo", ""+objVehiculo.getTipoVehiculo()));
                Value.add(new BasicNameValuePair("placa", ""+objVehiculo.getPlaca()));

                if(objVehiculo.getColor()!=null)
                    Value.add(new BasicNameValuePair("color", objVehiculo.getColor()));
                if(objVehiculo.getMarca()!=null)
                    Value.add(new BasicNameValuePair("marca", objVehiculo.getMarca()));
                if(objVehiculo.getModelo()!=null)
                    Value.add(new BasicNameValuePair("modelo", objVehiculo.getModelo()));
                if(objVehiculo.getDetalle()!=null)
                    Value.add(new BasicNameValuePair("detalle", objVehiculo.getDetalle()));
            }

            if(objInmueble!=null) {

                Value.add(new BasicNameValuePair("direccion", "" + objInmueble.getDireccion()));
                if(objInmueble.getColor()!=null)
                    Value.add(new BasicNameValuePair("color", objInmueble.getColor()));
                if(objInmueble.getDetalle()!=null)
                    Value.add(new BasicNameValuePair("detalle", objInmueble.getDetalle()));
            }
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
