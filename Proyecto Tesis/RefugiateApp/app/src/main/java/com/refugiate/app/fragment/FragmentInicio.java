package com.refugiate.app.fragment;


import android.app.AlertDialog;
import android.app.Dialog;
import android.support.v4.app.Fragment;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import com.refugiate.app.conexion.PostHTTP;
import com.refugiate.app.dao.gipHechoPublicoDAO;
import com.refugiate.app.dao.gipInmuebleDAO;
import com.refugiate.app.dao.gipPersonaDAO;
import com.refugiate.app.dao.gipUsuarioDAO;
import com.refugiate.app.dao.gipVehiculoDAO;
import com.refugiate.app.entidades.gipHechoPublico;
import com.refugiate.app.entidades.gipInmueble;
import com.refugiate.app.entidades.gipPersona;
import com.refugiate.app.entidades.gipVehiculo;
import com.refugiate.app.ui.R;
import com.refugiate.app.utilidades.ToSpeech;
import com.refugiate.app.utilidades.Utilidades;
import com.refugiate.app.ui.MapaActivity;
import com.refugiate.app.ui.FotoActivity;
import java.util.concurrent.ExecutionException;

public class FragmentInicio extends Fragment {

private Button btnGPS;
private Button btnFoto;
private Button btnPersona;
private Button btnInmueble;
private Button btnVehiculo;
private Button btnEnviarHecho;
private static int tiempoListener=300;

private Spinner ComboTipoHecho;
private EditText txtDetalleHecho;
private gipPersona objPersona;
private gipVehiculo objVehiculo;
private gipInmueble objInmueble;
private gipHechoPublico objHechoPublico;
private ProgressDialog pd;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_inicio, container,false);
        
        
        
        ComboTipoHecho  = (Spinner)view.findViewById(R.id.ComboHecho);



        String[] listTipoHecho=getResources().getStringArray(R.array.array_tipo_hecho);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this.getActivity(),android.R.layout.simple_spinner_dropdown_item,listTipoHecho);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ComboTipoHecho.setAdapter(adapter); 
        ComboTipoHecho.setSelection(0);

        
        btnEnviarHecho = (Button) view.findViewById(R.id.btnEnviarHecho);
        btnEnviarHecho.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnEnviarHecho();
            }
        });
        txtDetalleHecho = (EditText) view.findViewById(R.id.txtDetalleHecho);
        
        btnGPS = (Button) view.findViewById(R.id.btnGPS);
        View.OnTouchListener btnGPSListener = new View.OnTouchListener() {
            public boolean  onTouch  (View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_UP && event.getEventTime() - event.getDownTime() >= tiempoListener){
                    new ToSpeech(FragmentInicio.this.getActivity(), FragmentInicio.this.getString(R.string.mapa_activity));
                    Intent i=new Intent(FragmentInicio.this.getActivity(),MapaActivity.class);
                    startActivity(i);
                    FragmentInicio.this.getActivity().finish();
                }
                return false;
            }
        };
        btnGPS.setOnTouchListener(btnGPSListener);

        btnFoto = (Button) view.findViewById(R.id.btnFoto);
        View.OnTouchListener btnFotoListener = new View.OnTouchListener() {
            public boolean  onTouch  (View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_UP && event.getEventTime() - event.getDownTime() >= tiempoListener){
                    new ToSpeech(FragmentInicio.this.getActivity(), FragmentInicio.this.getString(R.string.foto_activity));
                  Intent i=new Intent(FragmentInicio.this.getActivity(),FotoActivity.class);
                    startActivity(i);
                    FragmentInicio.this.getActivity().finish();
                }
                return false;
            }
        };
        btnFoto.setOnTouchListener(btnFotoListener);
        
        btnPersona = (Button) view.findViewById(R.id.btnPersona);
        View.OnTouchListener btnPersonaListener = new View.OnTouchListener() {
            public boolean  onTouch  (View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_UP && event.getEventTime() - event.getDownTime() >= tiempoListener){

                  dialogPersona();                        }
                return false;
            }
        };
        btnPersona.setOnTouchListener(btnPersonaListener);


        btnInmueble = (Button) view.findViewById(R.id.btnInmueble);
        View.OnTouchListener btnInmuebleListener = new View.OnTouchListener() {
            public boolean  onTouch  (View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_UP && event.getEventTime() - event.getDownTime() >= tiempoListener){
//
                  dialogInmueble();
                }
                return false;
            }
        };
        btnInmueble.setOnTouchListener(btnInmuebleListener);


        btnVehiculo = (Button) view.findViewById(R.id.btnVehiculo);
        View.OnTouchListener btnVehiculoListener = new View.OnTouchListener() {
            public boolean  onTouch  (View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_UP && event.getEventTime() - event.getDownTime() >= tiempoListener){

                    dialogVehiculo();
                }
                return false;
            }
        };
        btnVehiculo.setOnTouchListener(btnVehiculoListener);


          cargarDatos();

        ComboTipoHecho.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
                objHechoPublico.setTipoHechoPublico(pos);
                gipHechoPublicoDAO.Actualizar(FragmentInicio.this.getActivity(), objHechoPublico);
            }

            public void onNothingSelected(AdapterView<?> parent) {
                //User selected same item. Nothing to do.
            }
        });
        txtDetalleHecho.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                objHechoPublico.setDetalle(txtDetalleHecho.getText().toString());
                gipHechoPublicoDAO.Actualizar(FragmentInicio.this.getActivity(), objHechoPublico);
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });


        return view;
    }
    public void dialogPersona()
    {
        new ToSpeech(this.getActivity(), this.getString(R.string.str_lblPersonas));

        final Dialog dialog = new Dialog(this.getActivity());
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.dialog_persona);
//

        final EditText txtNombresPersona = (EditText)dialog.findViewById(R.id.txtNombresPersona);
        txtNombresPersona.setText("");

        final EditText txtApellidosPersona = (EditText)dialog.findViewById(R.id.txtApellidosPersona);
        txtApellidosPersona.setText("");

        final EditText txtApelativoPersona = (EditText)dialog.findViewById(R.id.txtApelativoPersona);
        txtApelativoPersona.setText("");

        final EditText txtDetallePersona = (EditText)dialog.findViewById(R.id.txtDetallePersona);
        txtDetallePersona.setText("");

        Button btnAgregarPersona = (Button) dialog.findViewById(R.id.btnAgregarPersona);
        Button btnCancelarPersona = (Button) dialog.findViewById(R.id.btnCancelarPersona);
        if(objPersona !=null)
        {
            txtNombresPersona.setText(objPersona.getNombres());
            txtApellidosPersona.setText(objPersona.getApellidos());
            txtApelativoPersona.setText(objPersona.getApelativos());
            txtDetallePersona.setText(objPersona.getDetalle());
            btnCancelarPersona.setText(R.string.str_btnBorrar);
        }else
            btnCancelarPersona.setText(R.string.str_btnCancelar);


        btnAgregarPersona.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!txtNombresPersona.getText().toString().equals("") ||
                        !txtApellidosPersona.getText().toString().equals("") ||
                        !txtApelativoPersona.getText().toString().equals("")) {
                    objPersona = new gipPersona();
                    objPersona.setApelativos(txtApellidosPersona.getText().toString());
                    objPersona.setNombres(txtNombresPersona.getText().toString());
                    objPersona.setApellidos(txtApelativoPersona.getText().toString());
                    objPersona.setDetalle(txtDetallePersona.getText().toString());
                    objPersona.setPk_id(1);
                    gipPersonaDAO.BorrarXId(FragmentInicio.this.getActivity(), 1);
                    gipPersonaDAO.Agregar(FragmentInicio.this.getActivity(), objPersona);
                    dialog.dismiss();
                  cargarDatos();
                } else {
                    Utilidades.alert(FragmentInicio.this.getActivity(), FragmentInicio.this.getString(R.string.alert_Personas), true);
                }
            }
        });

        btnCancelarPersona.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        gipPersonaDAO.BorrarXId(FragmentInicio.this.getActivity(), 1);
       cargarDatos();
        dialog.show();
    }

    public void dialogVehiculo()
    {
        new ToSpeech(this.getActivity(), this.getString(R.string.str_lblVehiculos_tts));

        final Dialog dialog = new Dialog(this.getActivity());
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.dialog_vehiculo);

        final Spinner ComboTipoVehiculo  = (Spinner)dialog.findViewById(R.id.ComboTipoVehiculo);

        String[] listTipoVehiculo=getResources().getStringArray(R.array.array_tipo_vehiculo);
        ArrayAdapter<String> adapterSexo = new ArrayAdapter<String>(this.getActivity(),android.R.layout.simple_spinner_dropdown_item,listTipoVehiculo);
        adapterSexo.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ComboTipoVehiculo.setAdapter(adapterSexo);
        ComboTipoVehiculo.setSelection(0);
//
        final EditText txtModeloVehiculo = (EditText)dialog.findViewById(R.id.txtModeloVehiculo);
        txtModeloVehiculo.setText("");

        final EditText txtMarcaVehiculo = (EditText)dialog.findViewById(R.id.txtMarcaVehiculo);
        txtMarcaVehiculo.setText("");

        final EditText txtPlacaVehiculo = (EditText)dialog.findViewById(R.id.txtPlacaVehiculo);
        txtPlacaVehiculo.setText("");

        final EditText txtColorVehiculo = (EditText)dialog.findViewById(R.id.txtColorVehiculo);
        txtColorVehiculo.setText("");

        final EditText txtDetalleVehiculo = (EditText)dialog.findViewById(R.id.txtDetalleVehiculo);
        txtDetalleVehiculo.setText("");


        Button btnAgregarVehiculo = (Button) dialog.findViewById(R.id.btnAgregarVehiculo);
        Button btnCancelarVehiculo = (Button) dialog.findViewById(R.id.btnCancelarVehiculo);

        if(objVehiculo != null)
        {
            txtModeloVehiculo.setText(objVehiculo.getModelo());
            txtMarcaVehiculo.setText(objVehiculo.getMarca());
            txtPlacaVehiculo.setText(objVehiculo.getPlaca());
            txtColorVehiculo.setText(objVehiculo.getColor());
            txtDetalleVehiculo.setText(objVehiculo.getDetalle());
            ComboTipoVehiculo.setSelection(objVehiculo.getTipoVehiculo());
            btnCancelarVehiculo.setText(R.string.str_btnBorrar);
        }else
            btnCancelarVehiculo.setText(R.string.str_btnCancelar);

        btnAgregarVehiculo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!txtPlacaVehiculo.getText().toString().equals("")) {
                    if (!txtPlacaVehiculo.getText().toString().equals("")) {
                        objVehiculo = new gipVehiculo();
                        objVehiculo.setTipoVehiculo(ComboTipoVehiculo.getSelectedItemPosition());
                        objVehiculo.setModelo(txtModeloVehiculo.getText().toString());
                        objVehiculo.setMarca(txtMarcaVehiculo.getText().toString());
                        objVehiculo.setPlaca(txtPlacaVehiculo.getText().toString());
                        objVehiculo.setColor(txtColorVehiculo.getText().toString());
                        objVehiculo.setDetalle(txtDetalleVehiculo.getText().toString());
                        objVehiculo.setPk_id(1);
                        gipVehiculoDAO.BorrarXId(FragmentInicio.this.getActivity(), 1);
                        gipVehiculoDAO.Agregar(FragmentInicio.this.getActivity(), objVehiculo);
                        dialog.dismiss();
                     cargarDatos();
                    } else {
                        Utilidades.alert(FragmentInicio.this.getActivity(), FragmentInicio.this.getString(R.string.alert_Vehiculos), true);
                    }
                }

            }
        });

        btnCancelarVehiculo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gipVehiculoDAO.BorrarXId(FragmentInicio.this.getActivity(), 1);
                cargarDatos();
                dialog.dismiss();
            }
        });
//
        dialog.show();
    }

    public void dialogInmueble()
    {
        new ToSpeech(this.getActivity(), this.getString(R.string.str_lblInmuebles));

        final Dialog dialog = new Dialog(this.getActivity());
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.dialog_inmueble);

        final EditText txtDireccionInmueble = (EditText)dialog.findViewById(R.id.txtDireccionInmueble);
        txtDireccionInmueble.setText("");

        final EditText txtColorInmueble = (EditText)dialog.findViewById(R.id.txtColorInmueble);
        txtColorInmueble.setText("");

        final EditText txtDetalleInmueble = (EditText)dialog.findViewById(R.id.txtDetalleInmueble);
        txtDetalleInmueble.setText("");

        Button btnAgregarInmueble = (Button) dialog.findViewById(R.id.btnAgregarInmueble);
        Button btnCancelarInmueble = (Button) dialog.findViewById(R.id.btnCancelarInmueble);

        if(objInmueble != null)
        {
            txtDireccionInmueble.setText(objInmueble.getDireccion());
            txtColorInmueble.setText(objInmueble.getColor());
            txtDetalleInmueble.setText(objInmueble.getDetalle());
            btnCancelarInmueble.setText(R.string.str_btnBorrar);
        }else
            btnCancelarInmueble.setText(R.string.str_btnCancelar);

        btnAgregarInmueble.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!txtDireccionInmueble.getText().toString().equals("")) {
                    objInmueble = new gipInmueble();
                    objInmueble.setDireccion(txtDireccionInmueble.getText().toString());
                    objInmueble.setColor(txtColorInmueble.getText().toString());
                    objInmueble.setDetalle(txtDetalleInmueble.getText().toString());
                    objInmueble.setPk_id(1);
                    gipInmuebleDAO.BorrarXId(FragmentInicio.this.getActivity(), 1);
                    gipInmuebleDAO.Agregar(FragmentInicio.this.getActivity(), objInmueble);
                    dialog.dismiss();
                   cargarDatos();
                }
                else
                {
                    Utilidades.alert(FragmentInicio.this.getActivity(), FragmentInicio.this.getString(R.string.alert_Inmuebles), true);
                }
            }
        });

        btnCancelarInmueble.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
//
        gipInmuebleDAO.BorrarXId(FragmentInicio.this.getActivity(), 1);
       cargarDatos();
        dialog.show();
    }

    public void cargarDatos(){
        objPersona = gipPersonaDAO.Buscar(FragmentInicio.this.getActivity(), 1);
        objVehiculo = gipVehiculoDAO.Buscar(FragmentInicio.this.getActivity(), 1);
        objInmueble = gipInmuebleDAO.Buscar(FragmentInicio.this.getActivity(), 1);
        objHechoPublico= gipHechoPublicoDAO.Buscar(this.getActivity(), 1);
        if(objHechoPublico==null)
        {
            objHechoPublico = new gipHechoPublico();
            objHechoPublico.setPk_id(1);
            gipHechoPublicoDAO.Agregar(this.getActivity(), objHechoPublico);
        }
        else
        {
            ComboTipoHecho.setSelection(objHechoPublico.getTipoHechoPublico());
            txtDetalleHecho.setText(objHechoPublico.getDetalle());
        }

        if(objHechoPublico.getLatitud()==0D  && objHechoPublico.getLongitud()==0D)
            btnGPS.setBackgroundResource(R.drawable.location);
        else
            btnGPS.setBackgroundResource(R.drawable.locationon);

        if(Utilidades.getImagen()==null)
            btnFoto.setBackgroundResource(R.drawable.camera);
        else
            btnFoto.setBackgroundResource(R.drawable.cameraon);

        if(objPersona==null)
            btnPersona.setBackgroundResource(R.drawable.user);
        else
            btnPersona.setBackgroundResource(R.drawable.useron);

        if(objInmueble==null)
            btnInmueble.setBackgroundResource(R.drawable.house);
        else
            btnInmueble.setBackgroundResource(R.drawable.houseon);

        if(objVehiculo==null)
            btnVehiculo.setBackgroundResource(R.drawable.truck);
        else
            btnVehiculo.setBackgroundResource(R.drawable.truckon);

    }


    public void Enviar()
    {
        if(objHechoPublico!=null)
        {
            if(gipUsuarioDAO.Buscar(this.getActivity(), 1).isMail())
            {
                objHechoPublico.setEmail(Utilidades.getMail(this.getActivity()));
            }

            pd = new ProgressDialog(this.getActivity());
            pd.setMessage(this.getString(R.string.progres_dialog_envio));
            pd.setCancelable(false);
            pd.show();
            new Thread() {
                public void run() {
                    try {
                        Message message = handler.obtainMessage();
                        Bundle bundle = new Bundle();
                        PostHTTP http = new PostHTTP();
                        http.execute(objHechoPublico, objPersona, objVehiculo, objInmueble);
                        bundle.putString("data",http.get());

                        message.setData(bundle);
                        handler.sendMessage(message);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (ExecutionException e) {
                        e.printStackTrace();
                    }
                }
            }.start();
        }
    }

    public void btnEnviarHecho()
    {
        LocationManager  locationManager = (LocationManager) this.getActivity().getSystemService(this.getActivity().LOCATION_SERVICE);
        if(locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER)) {
            objHechoPublico = gipHechoPublicoDAO.Buscar(this.getActivity(), 1);
            if (!txtDetalleHecho.getText().toString().equals("")) {
                AlertDialog.Builder alert = new AlertDialog.Builder(this.getActivity());
                alert.setTitle(getString(R.string.str_alert_envio));
                alert.setPositiveButton(getString(R.string.str_btnAceptar), new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {

                        Enviar();
                    }
                });
                alert.setNegativeButton(getString(R.string.str_btnCancelar), new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                    }
                });
                alert.show();


            } else {
                Utilidades.alert(FragmentInicio.this.getActivity(), this.getString(R.string.alert_DetalleHecho), true);
            }

        }else
        {
            Intent in = new Intent(android.provider.Settings.ACTION_NETWORK_OPERATOR_SETTINGS );
        }

    }

    private final Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {

            Bundle bundle = msg.getData();

            if(Utilidades.isNumeric(bundle.getString("data")))
            {

                int id=Integer.parseInt(bundle.getString("data"));
                if(id>0)
                {

                    gipPersonaDAO.Borrar(FragmentInicio.this.getActivity());
                    gipVehiculoDAO.Borrar(FragmentInicio.this.getActivity());
                    gipInmuebleDAO.Borrar(FragmentInicio.this.getActivity());
                    gipHechoPublicoDAO.Borrar(FragmentInicio.this.getActivity());
                    Utilidades.getImagenDelete();
                    ComboTipoHecho.setSelection(0);
                    txtDetalleHecho.setText("");
                    cargarDatos();
                    Utilidades.alert(FragmentInicio.this.getActivity(), FragmentInicio.this.getString(R.string.alert_envio_completo), true);
                }
                else
                {
                    Utilidades.alert(FragmentInicio.this.getActivity(),FragmentInicio.this.getString(R.string.alert_error_conexion),true);
                }

            }
            else {
                Utilidades.alert(FragmentInicio.this.getActivity(),FragmentInicio.this.getString(R.string.alert_error_conexion), true);
            }
            pd.dismiss();

        }
    };
}
