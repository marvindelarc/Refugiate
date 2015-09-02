/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.refugiate.app.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Base64;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Spinner;
import com.refugiate.app.conexion.ServicioHTTP;
import com.refugiate.app.dao.clsConfiguracionSQL;
import com.refugiate.app.dao.clsCostoTipoHabitacionSQL;
import com.refugiate.app.dao.clsEmpresaSQL;
import com.refugiate.app.dao.clsInstalacionSQL;
import com.refugiate.app.dao.clsServicioSQL;
import com.refugiate.app.dao.clsSucursalSQL;
import com.refugiate.app.dao.clsTipoHabitacionSQL;
import com.refugiate.app.dao.clsUbigeoSQL;
import com.refugiate.app.entidades.clsConfiguracion;
import com.refugiate.app.entidades.clsCostoTipoHabitacion;
import com.refugiate.app.entidades.clsDistrito;
import com.refugiate.app.entidades.clsEmpresa;
import com.refugiate.app.entidades.clsInstalacion;
import com.refugiate.app.entidades.clsServicio;
import com.refugiate.app.entidades.clsSucursal;
import com.refugiate.app.entidades.clsTipoHabitacion;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.concurrent.ExecutionException;

public class ConfiguracionActivity extends Activity {

    private Spinner ComboTiempoActulizacion=null;
    private Spinner ComboTiempoPrevioReserva=null;
    private Spinner ComboTipoPropagandas=null;
    private Spinner ComboRepetirTiempo=null;
    private View ViewChbRepetir;
    private CheckBox chbRepetir;
    private clsConfiguracion objConfiguracion;
    private ProgressDialog pdCargar;
    
    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.dialog_configuracion);
          ComboTiempoActulizacion = (Spinner)findViewById(R.id.ComboTiempoActulizacion);
          ComboTiempoPrevioReserva = (Spinner)findViewById(R.id.ComboTiempoPrevioReserva);
          ComboTipoPropagandas = (Spinner)findViewById(R.id.ComboTipoPropagandas);
          ComboRepetirTiempo = (Spinner)findViewById(R.id.ComboRepetirTiempo);
          chbRepetir = (CheckBox)findViewById(R.id.chbRepetir);  
          ViewChbRepetir = (View)findViewById(R.id.ViewChbRepetir);
          objConfiguracion = new clsConfiguracion();
          getComboTiempoActulizacion();
          getComboTiempoPrevioReserva();
          getComboTipoPropagandas();
          getComboComboRepetirTiempo();
          chbRepetir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chbRepetir();
            }
            });
          chbRepetir.setChecked(true);
          Button btnAceptar = (Button) findViewById(R.id.btnAceptar);


        btnAceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnAceptar();
            }

        });
        // Intent svc = new Intent(this, RefugiateService.class);
        // stopService(svc);
    }
    
      private void getComboTiempoActulizacion()
    {
            String[] itens=getResources().getStringArray(R.array.array_configuracion_tiempo_actulizacion);
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,itens);
            adapter.setDropDownViewResource(android.R.layout.simple_list_item_checked);
            ComboTiempoActulizacion.setAdapter(adapter);     
            ComboTiempoActulizacion.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {          
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//               tipoHabitacion=itens.get(position);
                if(position==0)
                    objConfiguracion.setTiempo_actulizacion(1);
                else if(position==1)
                    objConfiguracion.setTiempo_actulizacion(3);
                else if(position==2)
                    objConfiguracion.setTiempo_actulizacion(6);
                else if(position==3)
                    objConfiguracion.setTiempo_actulizacion(12);
                else if(position==4)
                    objConfiguracion.setTiempo_actulizacion(24);
            }
            public void onNothingSelected(AdapterView<?> parent) {
                //User selected same item. Nothing to do.
            }
        });

        ComboTiempoActulizacion.setSelection(2);
    }
      
        private void getComboTiempoPrevioReserva()
    {
            
            String[] itens=getResources().getStringArray(R.array.array_configuracion_tiempo_reserva);
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,itens);       
            adapter.setDropDownViewResource(android.R.layout.simple_list_item_checked);
            ComboTiempoPrevioReserva.setAdapter(adapter);     
            ComboTiempoPrevioReserva.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {          
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    objConfiguracion.setTiempo_previo_reserva(position+1);
            }
            public void onNothingSelected(AdapterView<?> parent) {
                //User selected same item. Nothing to do.
            }
        });

        ComboTiempoPrevioReserva.setSelection(2);
    }
      
          private void getComboTipoPropagandas()
    {
            
            String[] itens=getResources().getStringArray(R.array.array_configuracion_tipo_propaganda);
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,itens);
            adapter.setDropDownViewResource(android.R.layout.simple_list_item_checked);
            ComboTipoPropagandas.setAdapter(adapter);     
            ComboTipoPropagandas.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {          
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    objConfiguracion.setTipo_propagandas(position+1);
            }
            public void onNothingSelected(AdapterView<?> parent) {
                //User selected same item. Nothing to do.
            }
        });

        ComboTipoPropagandas.setSelection(0);
    }
      
        private void getComboComboRepetirTiempo()
    {
            
            String[] itens=getResources().getStringArray(R.array.array_configuracion_tiempo_repetir);
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,itens);       
            adapter.setDropDownViewResource(android.R.layout.simple_list_item_checked);
            ComboRepetirTiempo.setAdapter(adapter);     
            ComboRepetirTiempo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {          
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    objConfiguracion.setRepetir_tiempo(position+1);

            }
            public void onNothingSelected(AdapterView<?> parent) {
                //User selected same item. Nothing to do.
            }
        });

        ComboRepetirTiempo.setSelection(1);
    }
        
        public void chbRepetir()
        {
            
           if(chbRepetir.isChecked())
           {
            ComboRepetirTiempo.setEnabled(true);
            ViewChbRepetir.setVisibility(View.VISIBLE);
               objConfiguracion.setRepetir(1);
           }

           else
           {
            ComboRepetirTiempo.setEnabled(false);
            ViewChbRepetir.setVisibility(View.GONE);
               objConfiguracion.setRepetir(2);
           }
        }
        
         public void btnAceptar()
        {
            pdCargar = new ProgressDialog(this);
            pdCargar.setTitle(getString(R.string.lbl_cargando_datos));
            pdCargar.setMessage(getString(R.string.lbl_espere_momento));
            pdCargar.setCancelable(false);
            pdCargar.show();

                new Thread() { 
                    public void run() { 
                    //clsDatos.setListaHoteles(ConfiguracionActivity.this);
                        try {
                            Message message = handlerCargar.obtainMessage();
                            Bundle bundle = new Bundle();
                            ServicioHTTP servicioHTTP=new ServicioHTTP();
                            servicioHTTP.execute("null");
                            bundle.putString("data",servicioHTTP.get());
                            message.setData(bundle);
                            handlerCargar.sendMessage(message);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        } catch (ExecutionException e) {
                            e.printStackTrace();
                        }
                    } 
               }.start();
        }
         
         


  
        final Handler handlerCargar=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            Bundle bundle = msg.getData();

            try {
                JSONObject objeto = new JSONObject(bundle.getString("data"));

                pdCargar.setTitle(getString(R.string.lbl_cargando_hoteles));

                JSONArray listEmpresaJSON = new JSONArray(objeto.getString("listEmpresaJSON"));
                    for(int i=0;i<listEmpresaJSON.length();i++){
                        JSONObject json_data = listEmpresaJSON.getJSONObject(i);
                        clsEmpresa entidad= new clsEmpresa();
                        entidad.setIdEmpresa(json_data.getInt("idEmpresa"));
                        entidad.setNombreComercial(json_data.getString("nombreComercial"));
                        entidad.setNombre(json_data.getString("nombre"));
                        entidad.setSlogan(json_data.getString("slogan"));
                        entidad.setRuc(json_data.getString("ruc"));
                        entidad.setPuntos(json_data.getInt("puntos"));
                        entidad.setEstado(json_data.getInt("estado"));
                        String Logo=json_data.getString("logo");
                        if(Logo!=null)
                        {
                            entidad.setLogo(Base64.decode(Logo, Base64.NO_WRAP | Base64.URL_SAFE));
                        }
                        clsEmpresaSQL.Agregar(ConfiguracionActivity.this,entidad);
                    }

                pdCargar.setTitle(getString(R.string.lbl_cargando_sucursales));

                JSONArray listSucursalJSON = new JSONArray(objeto.getString("listSucursalJSON"));
                for(int i=0;i<listSucursalJSON.length();i++){
                    JSONObject json_data = listSucursalJSON.getJSONObject(i);
                    clsSucursal entidad= new clsSucursal();
                    entidad.setIdSucursal(json_data.getInt("idSucursal"));
                    entidad.setDireccion(json_data.getString("direccion"));
                    entidad.setPisos(json_data.getInt("pisos"));
                    entidad.setTelefono(json_data.getString("telefono"));
                    entidad.setLongitud(json_data.getDouble("longitud"));
                    entidad.setLatitud(json_data.getDouble("latitud"));
                    entidad.setLimpieza(json_data.getInt("limpieza"));
                    entidad.setServicio(json_data.getInt("servicio"));
                    entidad.setComodidad(json_data.getInt("comodidad"));
                    entidad.setPuntuacion(json_data.getInt("puntuacion"));
                    entidad.setNivel(json_data.getInt("nivel"));
                    entidad.setEntrada(json_data.getString("entrada"));
                    entidad.setPaquete(json_data.getBoolean("paquete"));
                    entidad.setEstado(json_data.getInt("estado"));
                    entidad.setObjDistrito(new clsDistrito(json_data.getInt("idDistrito")));
                    entidad.setObjEmpresa(new clsEmpresa(json_data.getInt("idEmpresa")));
                    clsSucursalSQL.Agregar(ConfiguracionActivity.this, entidad);

                }
                pdCargar.setTitle(getString(R.string.lbl_cargando_servicios));
                JSONArray listServicioJSON = new JSONArray(objeto.getString("listServicioJSON"));
                for(int i=0;i<listServicioJSON.length();i++){
                    JSONObject json_data = listServicioJSON.getJSONObject(i);
                    clsServicio entidad= new clsServicio();
                    entidad.setIdServicio(json_data.getInt("idServicio"));
                    entidad.setNombre(json_data.getString("nombre"));
                    clsServicioSQL.Agregar(ConfiguracionActivity.this, entidad);
                }
                pdCargar.setTitle(getString(R.string.lbl_cargando_instalaciones));
                JSONArray listInstalacionJSON = new JSONArray(objeto.getString("listInstalacionJSON"));
                for(int i=0;i<listInstalacionJSON.length();i++){
                    JSONObject json_data = listInstalacionJSON.getJSONObject(i);
                    clsInstalacion entidad= new clsInstalacion();
                    entidad.setIdInstalacion(json_data.getInt("idInstalacion"));
                    entidad.setDescripcion(json_data.getString("descripcion"));
                    entidad.setObjServicio(new clsServicio(json_data.getInt("idServicio")));
                    entidad.setObjSucursal(new clsSucursal(json_data.getInt("idSucursal")));
                    clsInstalacionSQL.Agregar(ConfiguracionActivity.this, entidad);
                }
                pdCargar.setTitle(getString(R.string.lbl_cargando_costo_tipo_habitacion));
                JSONArray listCostoTipoHabitacionJSON = new JSONArray(objeto.getString("listCostoTipoHabitacionJSON"));
                for(int i=0;i<listCostoTipoHabitacionJSON.length();i++){
                    JSONObject json_data = listCostoTipoHabitacionJSON.getJSONObject(i);
                    clsCostoTipoHabitacion entidad= new clsCostoTipoHabitacion();
                    entidad.setIdCostoTipoHabitacion(json_data.getInt("idCostoTipoHabitacion"));
                    entidad.setCosto(json_data.getDouble("costo"));
                    entidad.setNumeroPersonas(json_data.getInt("numeroPersonas"));
                    entidad.setTotalHabitaciones(json_data.getInt("totalHabitaciones"));
                    entidad.setHabitacionesOcupadas(json_data.getInt("habitacionesOcupadas"));
                    entidad.setEstado(json_data.getInt("estado"));
                    entidad.setObjTipohabitacion(new clsTipoHabitacion(json_data.getInt("idTipoHabitacion")));
                    entidad.setObjSucursal(new clsSucursal(json_data.getInt("idSucursal")));
                    clsCostoTipoHabitacionSQL.Agregar(ConfiguracionActivity.this, entidad);
                }
                pdCargar.setTitle(getString(R.string.lbl_cargando_tipo_habitacion));
                JSONArray listTipoHabitacionJSON = new JSONArray(objeto.getString("listTipoHabitacionJSON"));
                for(int i=0;i<listTipoHabitacionJSON.length();i++){
                    JSONObject json_data = listTipoHabitacionJSON.getJSONObject(i);
                    clsTipoHabitacion entidad= new clsTipoHabitacion();
                    entidad.setIdTipoHabitacion(json_data.getInt("idTipoHabitacion"));
                    entidad.setNombreComercial(json_data.getString("nombreComercial"));
                    clsTipoHabitacionSQL.Agregar(ConfiguracionActivity.this, entidad);
                }
                clsUbigeoSQL.AgregarDepartamento(ConfiguracionActivity.this);
                clsUbigeoSQL.AgregarProvincia(ConfiguracionActivity.this);
                clsUbigeoSQL.AgregarDistrito(ConfiguracionActivity.this);

                clsConfiguracionSQL.Agregar(ConfiguracionActivity.this, objConfiguracion);
                pdCargar.dismiss();
                Intent i=new Intent(ConfiguracionActivity.this,MainActivity.class);
                startActivity(i);
                finish();
            } catch (JSONException e) {
               // pdCargar.dismiss();
                e.printStackTrace();
            }


        }
    };
        
        

  

        
        
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event)
    {
           return true;
    }
}
