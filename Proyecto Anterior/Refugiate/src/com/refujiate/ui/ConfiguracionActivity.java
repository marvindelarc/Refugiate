/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.refujiate.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.Spinner;
import com.refujiate.consumo.clsDatos;
import com.refujiate.entidades.clsConfiguracion;
import com.refujiate.servicio.RefugiateService;
import com.refujiate.sqlite.clsConfiguracionSQL;
/**
 *
 * @author Babsy Gamboa
 */
public class ConfiguracionActivity extends Activity {

    /**
     * Called when the activity is first created.
     */
    
    private Spinner ComboTiempoActulizacion=null;
    private Spinner ComboTiempoPrevioReserva=null;
    private Spinner ComboTipoPropagandas=null;
    private Spinner ComboRepetirTiempo=null;
    private View ViewChbRepetir;
    private CheckBox chbRepetir;
    private clsConfiguracion configuracion;
    private boolean frame=true;
    
    private ProgressDialog pdTipoHabitacion;
    private ProgressDialog pdInstalacion;
    
    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.activity_configuracion);   
          Bundle bundle=getIntent().getExtras();
          frame=Boolean.valueOf(bundle.getString("Frame"));
          ComboTiempoActulizacion = (Spinner)findViewById(R.id.ComboTiempoActulizacion);
          ComboTiempoPrevioReserva = (Spinner)findViewById(R.id.ComboTiempoPrevioReserva);
          ComboTipoPropagandas = (Spinner)findViewById(R.id.ComboTipoPropagandas);
          ComboRepetirTiempo = (Spinner)findViewById(R.id.ComboRepetirTiempo);
          chbRepetir = (CheckBox)findViewById(R.id.chbRepetir);  
          ViewChbRepetir = (View)findViewById(R.id.ViewChbRepetir);  
          configuracion = new clsConfiguracion();
          getComboTiempoActulizacion();
          getComboTiempoPrevioReserva();
          getComboTipoPropagandas();
          getComboComboRepetirTiempo();
          chbRepetir.setChecked(true);
           Intent svc = new Intent(this, RefugiateService.class);
            stopService(svc); 
    }
    
      private void getComboTiempoActulizacion()
    {
            
            String[] itens= {"1 hora","3 horas","6 horas","12 horas","24 horas"};
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,itens);       
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
            ComboTiempoActulizacion.setAdapter(adapter);     
            ComboTiempoActulizacion.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {          
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//               tipoHabitacion=itens.get(position);
                if(position==0)
                    configuracion.setInt_tiempo_actulizacion(1);
                else if(position==1)
                    configuracion.setInt_tiempo_actulizacion(3);
                else if(position==2)
                    configuracion.setInt_tiempo_actulizacion(6);
                else if(position==3)
                    configuracion.setInt_tiempo_actulizacion(12);
                else if(position==4)
                    configuracion.setInt_tiempo_actulizacion(24);
            }
            public void onNothingSelected(AdapterView<?> parent) {
                //User selected same item. Nothing to do.
            }
        });

        ComboTiempoActulizacion.setSelection(2);
    }
      
        private void getComboTiempoPrevioReserva()
    {
            
            String[] itens= {"1 día antes","2 días antes","3 días antes"};
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,itens);       
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
            ComboTiempoPrevioReserva.setAdapter(adapter);     
            ComboTiempoPrevioReserva.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {          
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position==0)
                    configuracion.setInt_tiempo_previo_reserva(1);
                else if(position==1)
                    configuracion.setInt_tiempo_previo_reserva(2);
                else if(position==2)
                    configuracion.setInt_tiempo_previo_reserva(3);
            }
            public void onNothingSelected(AdapterView<?> parent) {
                //User selected same item. Nothing to do.
            }
        });

        ComboTiempoPrevioReserva.setSelection(2);
    }
      
          private void getComboTipoPropagandas()
    {
            
            String[] itens= {"Hoteles de 1 estrellas a mas","Hoteles de 2 estrellas a mas","Hoteles de 3 estrellas a mas","Hoteles de 4 estrellas a mas","Hoteles de 5 estrellas"};
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,itens);       
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
            ComboTipoPropagandas.setAdapter(adapter);     
            ComboTipoPropagandas.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {          
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position==0)
                    configuracion.setInt_tipo_propagandas(1);
                else if(position==1)
                    configuracion.setInt_tipo_propagandas(2);
                else if(position==2)
                    configuracion.setInt_tipo_propagandas(3);
                else if(position==3)
                    configuracion.setInt_tipo_propagandas(4);
                else if(position==4)
                    configuracion.setInt_tipo_propagandas(5);
            }
            public void onNothingSelected(AdapterView<?> parent) {
                //User selected same item. Nothing to do.
            }
        });

        ComboTipoPropagandas.setSelection(0);
    }
      
        private void getComboComboRepetirTiempo()
    {
            
            String[] itens= {"Cada Hora","Cada 2 Horas","Cada 3 Horas"};
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,itens);       
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
            ComboRepetirTiempo.setAdapter(adapter);     
            ComboRepetirTiempo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {          
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position==0)
                    configuracion.setInt_repetir_tiempo(1);
                else if(position==1)
                    configuracion.setInt_repetir_tiempo(2);
                else if(position==2)
                    configuracion.setInt_repetir_tiempo(3);
            }
            public void onNothingSelected(AdapterView<?> parent) {
                //User selected same item. Nothing to do.
            }
        });

        ComboRepetirTiempo.setSelection(1);
    }
        
        public void chbRepetir(View v)
        {
            
           if(chbRepetir.isChecked())
           {
            ComboRepetirTiempo.setEnabled(true);
            ViewChbRepetir.setVisibility(View.VISIBLE);
            configuracion.setInt_repetir(1);
           }

           else
           {
            ComboRepetirTiempo.setEnabled(false);
            ViewChbRepetir.setVisibility(View.GONE);
            configuracion.setInt_repetir(2);
           }
        }
        
         public void btnAceptar(View v)
        {
            clsConfiguracionSQL.Agregar(this, configuracion);

            pdHoteles = new ProgressDialog(this);
            pdHoteles.setTitle("Cargando Lista de Hoteles");
            pdHoteles.setMessage("Espere un momento");     
            pdHoteles.show();        

                new Thread() { 
                    public void run() { 
                    clsDatos.setListaHoteles(ConfiguracionActivity.this);
                          handlerHoteles.sendEmptyMessage(0);                
                    } 
               }.start(); 
        }
         
         
         
        final Handler handlerHoteles=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            //update UI here depending on what message is received.
            super.handleMessage(msg);
            pdHoteles.dismiss();             
           CargarTipoHabitacion(); 
       
        }
    };
        
        
        
        
     public void CargarTipoHabitacion()
    {                
        pdTipoHabitacion = new ProgressDialog(this);
        pdTipoHabitacion.setTitle("Cargando Tipo de Habitaciones");
        pdTipoHabitacion.setMessage("Espere un momento");     
        pdTipoHabitacion.show();   
          new Thread() { 
            public void run() { 
            clsDatos.setListaTipoHabitacion(ConfiguracionActivity.this);
                  handlerTipoHabitacion.sendEmptyMessage(0);                
            } 
       }.start(); 
    }
    
  
        final Handler handlerTipoHabitacion=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            //update UI here depending on what message is received.
            super.handleMessage(msg);
            pdTipoHabitacion.dismiss();             
           CargarInstalacion();
       
        }
    };
        
        
          public void CargarInstalacion()
    {                
        pdInstalacion = new ProgressDialog(this);
        pdInstalacion.setTitle("Cargando Instalaciones");
        pdInstalacion.setMessage("Espere un momento");     
        pdInstalacion.show();   
          new Thread() { 
            public void run() { 
            clsDatos.setListaInstalacion(ConfiguracionActivity.this);
                  handlerInstalacion.sendEmptyMessage(0);                
            } 
       }.start(); 
    }
    
  
        final Handler handlerInstalacion=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            //update UI here depending on what message is received.
            super.handleMessage(msg);
            pdInstalacion.dismiss();             
            Intent i=new Intent(ConfiguracionActivity.this,MainMapaActivity.class);
            startActivity(i);   
       
        }
    };
        
        
        
        
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event)
    {
        
     if (keyCode == KeyEvent.KEYCODE_BACK) {
     
//          Intent i=new Intent(this,MenuActivity.class);
//                startActivity(i);
//                finish();
       return true;
    }
    return super.onKeyDown(keyCode, event);
    }
}
