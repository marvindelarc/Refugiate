/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.refujiate.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.refujiate.consumo.clsConexion;
import com.refujiate.entidades.clsPersona;
import com.refujiate.sqlite.clsPersonalSQL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Paulo
 */
public class PerfilActivity extends Activity {

    private EditText txtCorreoRegistroPasoA;
    private EditText txtCorreoConfirmarRegistroPasoA;
    private EditText txtNombreConfirmarRegistroPasoA;
    private EditText txtApellidoConfirmarRegistroPasoA;
    private EditText txtDNIConfirmarRegistroPasoA;
    private EditText txtTelefonoConfirmarRegistroPasoA;
    private clsPersona objPersona;
    
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);
        
         txtCorreoRegistroPasoA = (EditText)findViewById(R.id.txtCorreoRegistroPasoA);
         
         txtCorreoConfirmarRegistroPasoA = (EditText)findViewById(R.id.txtCorreoConfirmarRegistroPasoA);
         
         txtNombreConfirmarRegistroPasoA = (EditText)findViewById(R.id.txtNombreConfirmarRegistroPasoA);
         
         txtApellidoConfirmarRegistroPasoA = (EditText)findViewById(R.id.txtApellidoConfirmarRegistroPasoA);
         
         txtDNIConfirmarRegistroPasoA = (EditText)findViewById(R.id.txtDNIConfirmarRegistroPasoA);
         
         txtTelefonoConfirmarRegistroPasoA = (EditText)findViewById(R.id.txtTelefonoConfirmarRegistroPasoA);        
    
         objPersona=clsPersonalSQL.Buscar(this);
         if(objPersona!=null)
         {
             txtCorreoRegistroPasoA.setText(objPersona.getStr_Email());
             txtCorreoConfirmarRegistroPasoA.setText(objPersona.getStr_Email());
             txtNombreConfirmarRegistroPasoA.setText(objPersona.getStr_Nombre());
             txtApellidoConfirmarRegistroPasoA.setText(objPersona.getStr_Apellido());
             txtDNIConfirmarRegistroPasoA.setText(objPersona.getStr_DNI());
             txtTelefonoConfirmarRegistroPasoA.setText(objPersona.getStr_Telefono());             
         }
             
         
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

                     if(isDni(txtDNIConfirmarRegistroPasoA.getText().toString())) 
                     {
                         if(isTelefono(txtTelefonoConfirmarRegistroPasoA.getText().toString())) 
                        {

                            objPersona.setStr_Email(txtCorreoRegistroPasoA.getText().toString());
                            objPersona.setStr_Apellido(txtApellidoConfirmarRegistroPasoA.getText().toString());
                            objPersona.setStr_Nombre(txtNombreConfirmarRegistroPasoA.getText().toString());
                            objPersona.setStr_DNI(txtDNIConfirmarRegistroPasoA.getText().toString());
                            objPersona.setStr_Telefono(txtTelefonoConfirmarRegistroPasoA.getText().toString());

                            String IdPersona=clsConexion.postActualizaPersona(objPersona);

                            if(!IdPersona.trim().equals("0"))
                            {
                                clsPersonalSQL.Borrar(this);
                                clsPersonalSQL.Agregar(this, objPersona);
                                Toast.makeText(this,"Se Actulizo Correctamente", Toast.LENGTH_SHORT).show(); 

                                Intent i=new Intent(this,MenuActivity.class);
                                startActivity(i);
                            }

                        }
                        else
                            Toast.makeText(this,"Ingrese un Telefono valido de 9 digitos", Toast.LENGTH_SHORT).show();  
                     }
                    else
                        Toast.makeText(this,"Ingrese un DNI valido", Toast.LENGTH_SHORT).show();  

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
    
    
     @Override
    public boolean onCreateOptionsMenu(Menu menu) {
      
            MenuInflater inflater = getMenuInflater();
            inflater.inflate(R.menu.menu_perfil, menu);   
            return true;
       
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
        case R.id.MnuOpc1:                        
                    final Dialog dialog = new Dialog(this);
                    dialog.setContentView(R.layout.activity_cambiar_clave);
                    dialog.setTitle("Cambiar de Clave");
                    final EditText  txtClaveAnterior = (EditText)dialog.findViewById(R.id.txtClaveAnterior);        
                    final EditText  txtNuevaClave = (EditText)dialog.findViewById(R.id.txtNuevaClave);
                    final EditText  txtReClave = (EditText)dialog.findViewById(R.id.txtReClave);
                    Button btnAceptar = (Button) dialog.findViewById(R.id.btnAceptar);
                    btnAceptar.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                
                                if(txtClaveAnterior.getText().toString().equals(objPersona.getStr_Password()))
                                {
                                    if(!txtNuevaClave.getText().toString().equals("") && !txtNuevaClave.getText().toString().equals(null))
                                    {
                                        if(txtNuevaClave.getText().toString().equals(txtReClave.getText().toString()) )
                                        {
                                  
                                                String data= clsConexion.readTexto("servicio/actualizarClavePersona.jsp?IdPersona="+objPersona.getInt_IdPersona()+"&clave="+txtNuevaClave.getText().toString());
                                                if(!data.trim().equals("0"))
                                                {
                                                    Toast.makeText(PerfilActivity.this,"Su Clave se Actulizo Correctamente", Toast.LENGTH_SHORT).show(); 
                                                   clsPersonalSQL.Borrar(PerfilActivity.this);
                                                    clsPersonalSQL.Agregar(PerfilActivity.this, objPersona);
                                                  dialog.dismiss();
                                                }
                                                 else  
                                                     Toast.makeText(PerfilActivity.this,"Error ", Toast.LENGTH_SHORT).show(); 
                //                                    Login(txtUsuario.getText().toString(),txtClave.getText().toString());
                                          }
                                          else  
                                             Toast.makeText(PerfilActivity.this,"La clave repetida no coincide ", Toast.LENGTH_SHORT).show(); 
        //                                 
                                        }
                                          else  
                                             Toast.makeText(PerfilActivity.this,"Ingrese una Nueva Clave ", Toast.LENGTH_SHORT).show(); 
        //                                  
                                    }
                                    else  
                                        Toast.makeText(PerfilActivity.this,"La Clave anterior no coincide ", Toast.LENGTH_SHORT).show(); 
        //                                  
                                }
                    });
                  
                    dialog.show();
            
            return true;
       
            
       
        default:
            return super.onOptionsItemSelected(item);
        }
    }
  

}