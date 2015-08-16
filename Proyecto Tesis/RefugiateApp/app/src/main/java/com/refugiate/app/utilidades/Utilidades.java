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
import android.os.Environment;
import android.util.Base64;
import android.util.Log;
import android.view.Gravity;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 *
 * @author EdHam
 */
public class Utilidades {
    public static String url="http://192.168.1.15:8088/servicio";//servidor


    public static String fileImage="Temp";
    public static String nombreImage="Imagen";

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

    public static File SetImage(){
    	  File imagesFolder = new File(Environment.getExternalStorageDirectory(), fileImage);
            if(!imagesFolder.exists())
    		        imagesFolder.mkdirs();   
    		       return new File(imagesFolder, nombreImage+".jpg");
    }

    public static void  setMoveImagen(Bitmap avatar) {
        if(avatar!=null)
        {
            File imagesFolder = new File(Environment.getExternalStorageDirectory(), fileImage);
            if(!imagesFolder.exists())
                imagesFolder.mkdirs();
                FileOutputStream out;
            try {
                 out = new FileOutputStream(Environment.getExternalStorageDirectory()+"/"+fileImage+"/"+nombreImage+".jpg");
                 avatar.compress(Bitmap.CompressFormat.JPEG, 90, out);
                 out.close();
            } catch (IOException ex) {
            }
        }
     }

    public static Bitmap getImagen() {
           
        Bitmap imagen=null;
        
         File imageFile = new File(Environment.getExternalStorageDirectory(),fileImage+"/"+nombreImage+".jpg");
         if(imageFile.exists())
         {
             imagen = BitmapFactory.decodeFile(imageFile.getAbsolutePath());
         }
         
         return imagen;
       
    }
    
    public static boolean getImagenDelete( ) {
        
         File imageFile = new File(Environment.getExternalStorageDirectory(),fileImage+"/"+nombreImage+".jpg");
         if(imageFile.exists())
         {
        	 if(imageFile.delete())
        		 return true;
        	 else
        		 return false; 
         }
         return false;
       
    }

    public static String getBase64(int iniHeight, int iniWidth) {
        int newHeight=iniHeight;
        int newWidth=iniWidth ;

        String filePath = Environment.getExternalStorageDirectory()+"/"+fileImage+"/"+nombreImage+".jpg";
        File file = new File(Environment.getExternalStorageDirectory(),fileImage+"/"+nombreImage+".jpg");
        if(file.exists()) {
            final BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(filePath, options);

            if(options.outHeight<options.outWidth) {
                newHeight = iniWidth;
                newWidth= iniHeight;
            }

            options.inSampleSize = calculateInSampleSize(options, newWidth, newHeight);
            options.inJustDecodeBounds = false;

            Bitmap compressedImage = BitmapFactory.decodeFile(filePath, options);

            int width,height;
            float scaleWidth,scaleHeight;
            width = compressedImage.getWidth();
            height = compressedImage.getHeight();
            scaleWidth = ((float) newWidth) / width;
            scaleHeight = ((float) newHeight) / height;


            Matrix matrix = new Matrix();
            matrix.postScale(scaleWidth, scaleHeight);

            Bitmap resizedBitmap = Bitmap.createBitmap(compressedImage, 0, 0, width, height, matrix, false);

            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            resizedBitmap.compress(Bitmap.CompressFormat.PNG, 0, stream);

            byte[] Imagen= stream.toByteArray();
            return Base64.encodeToString(Imagen, Base64.NO_WRAP);
        }
        return null;
    }

    public static int calculateInSampleSize(BitmapFactory.Options options, int reqWidth, int reqHeight) {
// Raw height and width of image
        final int height = options.outHeight;
        final int width = options.outWidth;
        int inSampleSize = 1;

        if (height > reqHeight || width > reqWidth) {

            final int halfHeight = height / 2;
            final int halfWidth = width / 2;

            // Calculate the largest inSampleSize value that is a power of 2 and keeps both
            // height and width larger than the requested height and width.
            while ((halfHeight / inSampleSize) > reqHeight
                    && (halfWidth / inSampleSize) > reqWidth) {
                inSampleSize *= 2;
            }
        }

        return inSampleSize;
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

    public static boolean isNumeric(String cadena){
        try {
            Integer.parseInt(cadena);
            return true;
        } catch (NumberFormatException nfe){
            return false;
        }
    }
}
