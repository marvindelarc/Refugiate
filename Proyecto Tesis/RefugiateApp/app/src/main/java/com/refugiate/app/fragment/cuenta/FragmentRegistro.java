package com.refugiate.app.fragment.cuenta;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.refugiate.app.conexion.RegistroHTTP;
import com.refugiate.app.dao.clsPersonaSQL;
import com.refugiate.app.entidades.clsPersona;
import com.refugiate.app.fragment.hoteles.FragmentTab3;
import com.refugiate.app.ui.MainActivity;
import com.refugiate.app.ui.R;
import com.refugiate.app.utilidades.Utilidades;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.ExecutionException;


public class FragmentRegistro extends Fragment {
    private View view;
    private TextView lblFecNac;
    private int mYear;
    private int mMonth;
    private int mDay;
    private Calendar calendar;
    private Calendar calendarMax;
    private RadioGroup radioSexGroup;
    private clsPersona entidad;
    private boolean selectSexo=false;
    private Button btnAceptar;

    private EditText txtNombres;
    private EditText txApellidos;
    private EditText txtTelefono;
    private EditText txtEmail;
    private EditText txtDNI;
    private EditText txtUsuario;
    private EditText txtClave;
    private EditText txtRClave;
    private int fragment;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_registro, container, false);
        fragment = getArguments().getInt("fragment");
        entidad =new clsPersona();
        btnAceptar = (Button)view.findViewById(R.id.btnAceptar);
        btnAceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnAceptar();
            }
        });
        txtNombres = (EditText)view.findViewById(R.id.txtNombres);
        txtNombres.setText("");

        txApellidos = (EditText)view.findViewById(R.id.txApellidos);
        txApellidos.setText("");

        txtTelefono = (EditText)view.findViewById(R.id.txtTelefono);
        txtTelefono.setText("");

        txtEmail = (EditText)view.findViewById(R.id.txtEmail);
        txtEmail.setText(Utilidades.getMail(this.getActivity()));

        txtDNI = (EditText)view.findViewById(R.id.txtDNI);
        txtDNI.setText("");

        txtUsuario = (EditText)view.findViewById(R.id.txtUsuario);
        txtUsuario.setText("");

        txtClave = (EditText)view.findViewById(R.id.txtClave);
        txtClave.setText("");

        txtRClave = (EditText)view.findViewById(R.id.txtRClave);
        txtRClave.setText("");

        lblFecNac = (TextView)view.findViewById(R.id.lblFecNac);
        lblFecNac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lblFecNac();
            }
        });

        radioSexGroup = (RadioGroup) view.findViewById(R.id.radioSex);

        radioSexGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch(i) {
                    case R.id.radioMale:
                        entidad.setSexo(true);
                        break;
                    case R.id.radioFemale:
                        entidad.setSexo(false);
                        break;
                }
                selectSexo=true;
            }
        });

        calendar = Calendar.getInstance();
        calendar.add(Calendar.YEAR, -18);
        calendarMax=calendar;
        mYear = calendar.get(Calendar.YEAR);
        mMonth = calendar.get(Calendar.MONTH);
        mDay = calendar.get(Calendar.DAY_OF_MONTH);
        updateDisplay();

        ((MainActivity)  getActivity()).getSupportActionBar().setTitle(getString(R.string.lbl_tituloregistro));
        return view;
    }


    public void lblFecNac ()
    {
        DialogFragment newFragment = new SelectDateFragment();
        newFragment.show(getFragmentManager(), "DatePicker");
    }



    public class SelectDateFragment extends DialogFragment implements DatePickerDialog.OnDateSetListener {
        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            int yy = calendar.get(Calendar.YEAR);
            int mm = calendar.get(Calendar.MONTH);
            int dd = calendar.get(Calendar.DAY_OF_MONTH);
            DatePickerDialog DatePicker =new DatePickerDialog(getActivity(), AlertDialog.THEME_HOLO_LIGHT, this, yy, mm, dd);
            DatePicker.getDatePicker().setMaxDate(calendarMax.getTimeInMillis());
            return DatePicker;
        }

        public void onDateSet(DatePicker view, int yy, int mm, int dd) {
            mYear = yy;
            mMonth = mm;
            mDay = dd;
            updateDisplay();
        }
    }



    private void updateDisplay() {

        calendar.set(mYear, mMonth, mDay);
        lblFecNac.setText(new StringBuilder().append(mDay).append("/").append(mMonth + 1).append("/").append(mYear));
        entidad.setFecnac(calendar.getTime());


    }

    public void btnAceptar()
    {
        if(!txtNombres.getText().toString().equals("") )
        {
            if(!txApellidos.getText().toString().equals("") )
            {
                if(txtTelefono.getText().toString().length()==9)
                {
                    if(Utilidades.isValidEmail(txtEmail.getText().toString()))
                    {
                        if(txtDNI.getText().toString().length()==8 )
                        {
                            if(selectSexo)
                            {
                                if(!txtUsuario.getText().toString().equals("") )
                                {
                                    if(!txtClave.getText().toString().equals("") )
                                    {
                                        if(txtRClave.getText().toString().equals(txtClave.getText().toString()) )
                                        {
                                            entidad.setNombre(txtNombres.getText().toString());
                                            entidad.setApellido(txApellidos.getText().toString());
                                            entidad.setTelefono(txtTelefono.getText().toString());
                                            entidad.setEmail(txtEmail.getText().toString());
                                            entidad.setEmail(txtDNI.getText().toString());
                                            entidad.setUsuario(txtUsuario.getText().toString());
                                            entidad.setPassword(txtClave.getText().toString());

                                            RegistroHTTP registro = new RegistroHTTP();

                                            registro.execute(entidad);

                                            try {
                                                JSONObject objeto = new JSONObject(registro.get());
                                                int idPersona=objeto.getInt("idPersona");

                                                if(idPersona>0)
                                                {
                                                    entidad.setIdPersona(idPersona);
                                                    clsPersonaSQL.Agregar(this.getActivity(), entidad);
                                                    ((MainActivity)  getActivity()).mOptionsMenu.getItem(1).setVisible(true);
                                                    Utilidades.alert(this.getActivity(), "Se Registro Correctamente", false);
                                                    if(fragment==0)
                                                    {
                                                        ((MainActivity)getActivity()).setFragment(new FragmentPerfil());
                                                    }
                                                    else if(fragment==1)
                                                    {
                                                        ((MainActivity)getActivity()).setFragment(new FragmentReservas());
                                                    }
                                                    else if(fragment==2)
                                                    {
                                                        ((MainActivity)getActivity()).setFragment(new FragmentHistorial());
                                                    }
                                                    else if(fragment==3)
                                                    {
                                                        ((MainActivity)getActivity()).setFragment(new FragmentTab3());
                                                    }
                                                }

                                            } catch (JSONException e) {
                                                e.printStackTrace();
                                            } catch (InterruptedException e) {
                                                e.printStackTrace();
                                            } catch (ExecutionException e) {
                                                e.printStackTrace();
                                            }




                                        }
                                        else
                                        {
                                            Utilidades.alert(this.getActivity(), getString(R.string.lbl_reclave_registro), false);
                                        }
                                    }
                                    else
                                    {
                                        Utilidades.alert(this.getActivity(),getString(R.string.lbl_clave_registro),false);
                                    }
                                }
                                else
                                {
                                    Utilidades.alert(this.getActivity(),getString(R.string.lbl_usuario_registro),false);
                                }
                            }
                            else
                            {
                                Utilidades.alert(this.getActivity(),getString(R.string.lbl_sexo_registro),false);
                            }
                        }
                        else
                        {
                            Utilidades.alert(this.getActivity(),getString(R.string.lbl_dni_registro),false);
                        }
                    }
                    else
                    {
                        Utilidades.alert(this.getActivity(),getString(R.string.lbl_email_registro),false);
                    }
                }
                else
                {
                    Utilidades.alert(this.getActivity(),getString(R.string.lbl_telefono_registro),false);
                }

            }
            else
            {
                Utilidades.alert(this.getActivity(),getString(R.string.lbl_apellidos_registro),false);
            }
        }
        else
        {
            Utilidades.alert(this.getActivity(),getString(R.string.lbl_nombres_registro),false);
        }
    }

}

