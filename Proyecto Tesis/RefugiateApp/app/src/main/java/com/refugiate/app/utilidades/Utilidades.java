/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.refugiate.app.utilidades;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.location.Location;
import android.os.Environment;
import android.util.Base64;
import android.util.Log;
import android.view.Gravity;
import android.widget.Toast;

import com.refugiate.app.dao.clsSucursalSQL;
import com.refugiate.app.entidades.clsSucursal;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author EdHam
 */
public class Utilidades {
    public static String url="http://192.168.1.5:8084/servicio";//servidor




    public static void alert(Context context, String message,boolean voz)
	{
                if(voz)
		{
			ToSpeech a=new ToSpeech(context, message);
		}
		CharSequence text = message;

        int duration = Toast.LENGTH_LONG;

		CustomToast miToast = new CustomToast(context,duration);
		miToast.setGravity(Gravity.CENTER_VERTICAL| Gravity.CENTER_HORIZONTAL, 0,100);
		miToast.show(text);
		
	}






    public static String getMail(Context context) {
        String possibleEmail=null;

        try{
            Account[] accounts = AccountManager.get(context).getAccountsByType("com.google");

            for (Account account : accounts) {

                possibleEmail =account.name;

            }
        }
        catch(Exception e)
        {
            Log.i("Exception", "Exception:" + e) ;
        }
        return possibleEmail;
    }

    public static boolean isValidEmail(String email)
    {

        String emailExpression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
        CharSequence inputStr = email;

        Pattern pattern = Pattern.compile(emailExpression, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(inputStr);
        if (matcher.matches())
            return true;
        else
            return false;
    }


    public static List<clsSucursal> getDistanciaMapa(Location location,int tipo,List<clsSucursal> lista)
    {
        int Radius = 6371000; //Radio de la tierra
        List<clsSucursal> getLista=new ArrayList<clsSucursal>();
        int distancia=0;
        if(tipo==0 || location==null)
            return lista;
        if(tipo==1)
            distancia=1000;
        else if(tipo==2)
            distancia=5000;
        else if(tipo==3)
            distancia=10000;


        for(clsSucursal entidad:lista)
        {
            double dLat = Math.toRadians(entidad.getLatitud()-location.getLatitude());
            double dLon = Math.toRadians(entidad.getLongitud()-location.getLongitude());
            double a = Math.sin(dLat / 2) * Math.sin(dLat / 2) + Math.cos(Math.toRadians(location.getLatitude())) * Math.cos(Math.toRadians(entidad.getLongitud())) * Math.sin(dLon /2) * Math.sin(dLon/2);
            double c = 2 * Math.asin(Math.sqrt(a));
            int metros= (int) (Radius * c);
            if(distancia>=metros)
                getLista.add(entidad);
        }
        return getLista;
    }

    public static String pad(int c) {
        if (c >= 10)
            return String.valueOf(c);
        else
            return "0" + String.valueOf(c);
    }

    public static int getDiferenciaEnDias(Date fechaInicial, Date fechaFinal) {

        long fechaInicialMs = fechaInicial.getTime();
        long fechaFinalMs = fechaFinal.getTime();
        long diferencia = fechaFinalMs - fechaInicialMs;
        double dias = Math.floor(diferencia / (1000 * 60 * 60 * 24));
        return ( (int) dias);
    }

    public static int getDiferenciaEnHoras(Date fechaInicial, Date fechaFinal) {

        long fechaInicialMs = fechaInicial.getTime();
        long fechaFinalMs = fechaFinal.getTime();
        long diferencia = fechaFinalMs - fechaInicialMs;
        double dias = Math.floor(diferencia / (1000 * 60 * 60));
        return ( (int) dias);
    }
    public static String getFecha(Date fecha)
    {
        SimpleDateFormat e=new SimpleDateFormat("dd/MM/yyyy");
        return e.format(fecha);
    }
    public static String getHora(Date fecha)
    {
        SimpleDateFormat e=new SimpleDateFormat("HH:mm");
        return e.format(fecha);
    }

    public static int getEdad(Date  pNacio){

        try
        {

            Calendar fecha = new GregorianCalendar();
            fecha.setTime(pNacio);
            int diaNacio = fecha.get(Calendar.DATE);
            int mesNacio = fecha.get(Calendar.MONTH)+1;
            int anoNacio = fecha.get(Calendar.YEAR);
            fecha.setTime(new Date());

            int anoFecha = fecha.get(Calendar.YEAR);
            int mesFecha = fecha.get(Calendar.MONTH)+1;
            int diaFecha = fecha.get(Calendar.DATE);

            int difAno = anoFecha - anoNacio;
            int difMes = mesFecha - mesNacio;
            int difDia = diaFecha - diaNacio;

            if(difMes <0){

                difAno-=1;

            }else if(difMes == 0){

                if(difDia < 0){
                    difAno-=1;
                }

            }
            return difAno;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;

    }
}
