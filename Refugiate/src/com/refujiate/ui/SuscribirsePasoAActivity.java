/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.refujiate.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import com.refujiate.consumo.clsConexion;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Paulo
 */
public class SuscribirsePasoAActivity extends Activity {

    private EditText txtCorreoRegistroPasoA;
    private EditText txtCorreoConfirmarRegistroPasoA;
    private EditText txtNombreConfirmarRegistroPasoA;
    private EditText txtApellidoConfirmarRegistroPasoA;
    private EditText txtUsuarioConfirmarRegistroPasoA;
    private EditText txtDNIConfirmarRegistroPasoA;
    private EditText txtTelefonoConfirmarRegistroPasoA;

    
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suscribirse_paso_a);
        
         txtCorreoRegistroPasoA = (EditText)findViewById(R.id.txtCorreoRegistroPasoA);
         
         txtCorreoConfirmarRegistroPasoA = (EditText)findViewById(R.id.txtCorreoConfirmarRegistroPasoA);
         
         txtNombreConfirmarRegistroPasoA = (EditText)findViewById(R.id.txtNombreConfirmarRegistroPasoA);
         
         txtApellidoConfirmarRegistroPasoA = (EditText)findViewById(R.id.txtApellidoConfirmarRegistroPasoA);
         
         txtUsuarioConfirmarRegistroPasoA = (EditText)findViewById(R.id.txtUsuarioConfirmarRegistroPasoA);
         
         txtDNIConfirmarRegistroPasoA = (EditText)findViewById(R.id.txtDNIConfirmarRegistroPasoA);
         
         txtTelefonoConfirmarRegistroPasoA = (EditText)findViewById(R.id.txtTelefonoConfirmarRegistroPasoA);        
    }
    
    public boolean isValidEmail(String email)
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
    
    public static boolean isDni(String dni){
 
	Pattern dniPattern = Pattern.compile("(\\d{1,8})");
	Matcher m = dniPattern.matcher(dni);
	if(m.matches()){
		return true;
	}
	else
		return false;
    }
    public static boolean isTelefono(String tele){
 
	Pattern dniPattern = Pattern.compile("(\\d{1,9})");
	Matcher m = dniPattern.matcher(tele);
	if(m.matches()){
		return true;
	}
	else
		return false;
    }
    public void btnPasoDos(View e)
    {

        if(txtCorreoRegistroPasoA.getText().toString().equals(txtCorreoConfirmarRegistroPasoA.getText().toString()))
        {
          if(isValidEmail(txtCorreoRegistroPasoA.getText().toString())) 
          {  
            if(!txtNombreConfirmarRegistroPasoA.getText().toString().equals("") &&  txtNombreConfirmarRegistroPasoA.getText().toString()!=null )
            {
                if(!txtApellidoConfirmarRegistroPasoA.getText().toString().equals("")&&  txtApellidoConfirmarRegistroPasoA.getText().toString()!=null)
                {
                    if(!txtUsuarioConfirmarRegistroPasoA.getText().toString().equals("") && txtUsuarioConfirmarRegistroPasoA.getText().toString()!=null)
                    {
                        String IdUsuario =clsConexion.readTexto("servicio/verificarUsuario.jsp?usuario="+txtUsuarioConfirmarRegistroPasoA.getText().toString());
                        if(IdUsuario.trim().equals("0") )
                        {
                             if(isDni(txtDNIConfirmarRegistroPasoA.getText().toString())) 
                             {
                                 if(isTelefono(txtTelefonoConfirmarRegistroPasoA.getText().toString())) 
                                {
                                    Intent i=new Intent(this,SuscribirsePasoBActivity.class);
                                    i.putExtra("CORREO",txtCorreoRegistroPasoA.getText().toString());
                                    i.putExtra("NOMBRE",txtNombreConfirmarRegistroPasoA.getText().toString());
                                    i.putExtra("APELLIDO",txtApellidoConfirmarRegistroPasoA.getText().toString());
                                    i.putExtra("USUARIO",txtUsuarioConfirmarRegistroPasoA.getText().toString());
                                    i.putExtra("DNI",txtDNIConfirmarRegistroPasoA.getText().toString());
                                    i.putExtra("TELEFONO",txtTelefonoConfirmarRegistroPasoA.getText().toString());        
                                    startActivity(i);
                                }
                                else
                                    Toast.makeText(this,"Ingrese un Telefono valido de 9 digitos", Toast.LENGTH_SHORT).show();  
                             }
                            else
                                Toast.makeText(this,"Ingrese un DNI valido", Toast.LENGTH_SHORT).show();  
                        }
                        else
                            Toast.makeText(this,"Usuario Repetido, seleccione otro usuario", Toast.LENGTH_SHORT).show();  
                    }
                    else
                        Toast.makeText(this,"Ingrese un Usuario", Toast.LENGTH_SHORT).show();
               }
                else
                    Toast.makeText(this,"Ingrese un Apellido", Toast.LENGTH_SHORT).show();  
            }
            else
                Toast.makeText(this,"Ingrese un Nombre", Toast.LENGTH_SHORT).show();  
          }
            else
              Toast.makeText(this,"Ingrese un Email Valido", Toast.LENGTH_SHORT).show(); 
        }
        else 
             Toast.makeText(this,"Los Email no coinciden", Toast.LENGTH_SHORT).show(); 

    }
}