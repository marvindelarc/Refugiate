/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.refujiate.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.refujiate.entidades.clsPersona;
import com.refujiate.sqlite.clsPersonalSQL;

/**
 *
 * @author Paulo
 */
public class MenuActivity extends Activity {

    /**
     * Called when the activity is first created.
     */
    
    private TextView lblBienvenida;  
    private clsPersona objPersona;
    
    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        // ToDo add your GUI initialization code here     
        setContentView(R.layout.activity_menu);
        lblBienvenida=(TextView)findViewById(R.id.lblBienvenida);  
        objPersona=clsPersonalSQL.Buscar(this);
        if(objPersona!=null)
        {
           lblBienvenida.setText("Bienvenido(a) "+objPersona.getStr_Apellido()+" "+objPersona.getStr_Nombre());
        }
        
    }
    
    public void btn_Pendientes(View v)
    {
         Intent i=new Intent(this,ReservasPendientesActivity.class);
           startActivity(i); 
    }
     public void btn_Finalizados(View v)
    {
         Intent i=new Intent(this,ReservasFinalizadasActivity.class);
           startActivity(i); 
    }
      public void btn_Comentarios(View v)
    {
           Intent i=new Intent(this,ComentariosActivity.class);
           startActivity(i); 
    }
       public void btn_Perfil(View v)
    {
        Intent i=new Intent(this,PerfilActivity.class);
           startActivity(i); 
    }
}
