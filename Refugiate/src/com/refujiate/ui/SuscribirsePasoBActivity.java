/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.refujiate.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;
import com.refujiate.entidades.clsPersona;
import com.refujiate.consumo.clsConexion;
import com.refujiate.sqlite.clsPersonalSQL;

/**
 *
 * @author Paulo
 */
public class SuscribirsePasoBActivity extends Activity {

      private EditText txtContraseniaRegistroPasoB;
      private EditText txtContraseniaConfirmarRegistroPasoB;
      private CheckBox chbCodiciones;
      private CheckBox chbInformacion;
      private clsPersona objPersona;
      
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suscribirse_paso_b);
        txtContraseniaRegistroPasoB = (EditText)findViewById(R.id.txtContraseniaRegistroPasoB);  
        txtContraseniaConfirmarRegistroPasoB = (EditText)findViewById(R.id.txtContraseniaConfirmarRegistroPasoB);  
        
        chbCodiciones = (CheckBox)findViewById(R.id.chbCodiciones);  
        chbInformacion = (CheckBox)findViewById(R.id.chbInformacion);  
         Bundle bundle=getIntent().getExtras();
         objPersona = new clsPersona();
         objPersona.setStr_Nombre(bundle.getString("NOMBRE"));
         objPersona.setStr_Apellido(bundle.getString("APELLIDO"));
         objPersona.setStr_DNI(bundle.getString("DNI"));
         objPersona.setStr_Email(bundle.getString("CORREO"));
         objPersona.setStr_Telefono(bundle.getString("TELEFONO"));
         objPersona.setStr_Usuario(bundle.getString("USUARIO"));
         objPersona.setInt_Informacion(0);
    }
    
    public void btnEnviarRegistroPasoB(View e)
    {
        if(!txtContraseniaRegistroPasoB.getText().toString().equals("") &&  txtContraseniaRegistroPasoB.getText().toString()!=null )
        {
            if(txtContraseniaRegistroPasoB.getText().toString().equals(txtContraseniaConfirmarRegistroPasoB.getText().toString()))
            {
                if(chbCodiciones.isChecked())
                {
                    if(chbInformacion.isChecked())
                        objPersona.setInt_Informacion(1);
                    objPersona.setStr_Password(txtContraseniaRegistroPasoB.getText().toString());
                    
                    String IdPersona=clsConexion.postResgitrarPersona(objPersona);
                    
                    if(!IdPersona.trim().equals("0"))
                    {
                      objPersona.setInt_IdPersona(Integer.parseInt(IdPersona.trim()));
                      clsPersonalSQL.Agregar(this, objPersona);
                      Intent i=new Intent(this,MainActivity.class);     
                      startActivity(i);
                      Toast.makeText(this,"Se Registro Correctamente", Toast.LENGTH_SHORT).show(); 
                    }
                    
                   

                }
                else 
                     Toast.makeText(this,"Bebe aceptar los terminos y condiciones", Toast.LENGTH_SHORT).show(); 
             }
            else 
                 Toast.makeText(this,"Las contraseñas no coinciden", Toast.LENGTH_SHORT).show(); 
         }
        else 
             Toast.makeText(this,"Ingrese una contraseña", Toast.LENGTH_SHORT).show(); 
        
    }
}