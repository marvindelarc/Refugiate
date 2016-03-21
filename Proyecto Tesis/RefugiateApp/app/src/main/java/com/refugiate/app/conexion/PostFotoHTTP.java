package com.refugiate.app.conexion;


import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class PostFotoHTTP extends AsyncTask<String, Void, Bitmap>{
    @Override
    protected Bitmap doInBackground(String... params) {
        // TODO Auto-generated method stub
        Log.i("doInBackground" , "Entra en doInBackground");
        String cip = params[0];

        try{
            String url=params[0];
            URL imageUrl = new URL(url);
            HttpURLConnection conn = (HttpURLConnection) imageUrl.openConnection();
            conn.connect();
            return BitmapFactory.decodeStream(conn.getInputStream());
        }catch(IOException ex){
            ex.printStackTrace();
        }

        return null;
    }

    @Override
    protected void onPostExecute(Bitmap result) {
        // TODO Auto-generated method stub
        super.onPostExecute(result);
    }

}
