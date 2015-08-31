package com.refugiate.app.fragment.cuenta;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.refugiate.app.conexion.LoginHTTP;
import com.refugiate.app.dao.clsPersonaSQL;
import com.refugiate.app.entidades.clsPersona;
import com.refugiate.app.ui.MainActivity;
import com.refugiate.app.ui.R;
import com.refugiate.app.utilidades.Utilidades;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Date;
import java.util.concurrent.ExecutionException;


public class FragmentLogin extends Fragment {
    private View view;
    private TextView lblRegistro;
    private Button btnAceptar;
    private EditText txtUsuario;
    private EditText txtClave;
    private ProgressDialog pdCargar;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.dialog_login, container, false);

        txtUsuario = (EditText)view.findViewById(R.id.txtUsuario);
        txtUsuario.setText("");

        txtClave = (EditText)view.findViewById(R.id.txtClave);
        txtClave.setText("");

        btnAceptar = (Button)view.findViewById(R.id.btnAceptar);
        btnAceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnAceptar();
            }
        });

        lblRegistro = (TextView)view.findViewById(R.id.lblRegistro);
        lblRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lblRegistro();
            }
        });

        ((MainActivity)  getActivity()).getSupportActionBar().setTitle(getString(R.string.lbl_iniciar_sesion));
        return view;
    }

    public void lblRegistro()
    {
        ((MainActivity)getActivity()).setFragment(new FragmentRegistro());
    }
    public void btnAceptar()
    {
        if(!txtUsuario.getText().toString().equals("") && !txtClave.getText().toString().equals(""))
        {
            pdCargar = new ProgressDialog(this.getActivity());
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
                        LoginHTTP login = new LoginHTTP();
                        login.execute(txtUsuario.getText().toString(), txtClave.getText().toString());
                        bundle.putString("data", login.get());
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
        else
        {

           Utilidades.alert(this.getActivity(), getString(R.string.lbl_error_credenciales), false);

        }
    }

    final Handler handlerCargar=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            Bundle bundle = msg.getData();

           try {
                JSONObject objeto = new JSONObject(bundle.getString("data"));
               if(objeto.length()>0) {
                   clsPersona entidad = new clsPersona();
                   entidad.setIdPersona(objeto.getInt("idPersona"));
                   entidad.setNombre(objeto.getString("nombre"));
                   entidad.setApellido(objeto.getString("apellido"));
                   entidad.setTelefono(objeto.getString("telefono"));
                   entidad.setEmail(objeto.getString("email"));
                   entidad.setDNI(objeto.getString("dni"));
                   entidad.setSexo(objeto.getBoolean("sexo"));
                   entidad.setFecnac(new Date(objeto.getLong("fecnac")));
                   entidad.setUsuario(txtUsuario.getText().toString());
                   entidad.setPassword(txtClave.getText().toString());
                   clsPersonaSQL.Agregar(FragmentLogin.this.getActivity(), entidad);
                   ((MainActivity)  getActivity()).mOptionsMenu.getItem(1).setVisible(true);
               }
               else
                   Utilidades.alert(FragmentLogin.this.getActivity(), getString(R.string.lbl_error_credenciales), false);

            } catch (JSONException e) {
                // pdCargar.dismiss();
                e.printStackTrace();
            }

            pdCargar.dismiss();
        }
    };

}

