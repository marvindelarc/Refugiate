/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.refugiate.app.ui;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;

import com.refugiate.app.utilidades.Utilidades;

public class FotoActivity extends Activity {

    private  ImageView image;
    private static int tomarfoto=0;
    private static int cargarfoto=1;
    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        // ToDo add your GUI initialization code here
        setContentView(R.layout.activity_foto);
        image = (ImageView)findViewById(R.id.image);
        Bitmap bitmap=Utilidades.getImagen();
        if(bitmap!=null)
            image.setImageBitmap(bitmap);

    }


    public void btnSelecionar(View v)
    {
        Intent i=new Intent(this,MainActivity.class);
        startActivity(i);
        finish();
    }
    public void btnCancelar(View v)
    {
        Utilidades.getImagenDelete();
        Intent i=new Intent(this,MainActivity.class);
        startActivity(i);
        finish();
    }

    public void btnCargarFoto(View v)
    {
        Intent i = new Intent(
                Intent.ACTION_PICK,
                android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);

        startActivityForResult(i, cargarfoto);

    }

    public void btnTomarFoto(View v)
    {
        Intent i = new Intent(
                android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
        Uri uriSavedImage = Uri.fromFile(Utilidades.SetImage());
        i.putExtra(MediaStore.EXTRA_OUTPUT, uriSavedImage);
        startActivityForResult(i, tomarfoto);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == tomarfoto && resultCode == RESULT_OK) {

            image.setImageBitmap(Utilidades.getImagen());
        }
        else if (requestCode == cargarfoto && resultCode == RESULT_OK && null != data) {
            Uri selectedImage = data.getData();

            String[] filePathColumn = { MediaStore.Images.Media.DATA };
            Cursor cursor = getContentResolver().query(selectedImage,
                    filePathColumn, null, null, null);
            cursor.moveToFirst();

            int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
            String picturePath = cursor.getString(columnIndex);
            cursor.close();
            Bitmap bitmap=BitmapFactory.decodeFile(picturePath);
            if(bitmap!=null)
            {
                Utilidades.setMoveImagen(bitmap);
                image.setImageBitmap(bitmap);
            }


        }
    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event)
    {


        return false;

    }



}
