package com.refugiate.app.fragment.cuenta;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.refugiate.app.dao.clsPersonaSQL;
import com.refugiate.app.entidades.clsPersona;
import com.refugiate.app.ui.MainActivity;
import com.refugiate.app.ui.R;
import com.refugiate.app.utilidades.Utilidades;


public class FragmentPerfil extends Fragment {

    private TextView lblNombres;
    private TextView lblTelefono;
    private TextView lblEmail;
    private TextView lblDNI;
    private TextView lblSexo;
    private TextView lblUsuario;
    private TextView lblFecNac;
    private TextView lblEdad;


    private clsPersona entidad;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_perfil, container, false);
        lblNombres = (TextView)view.findViewById(R.id.lblNombres);
        lblTelefono = (TextView)view.findViewById(R.id.lblTelefono);
        lblEmail = (TextView)view.findViewById(R.id.lblEmail);
        lblDNI = (TextView)view.findViewById(R.id.lblDNI);
        lblSexo = (TextView)view.findViewById(R.id.lblSexo);
        lblUsuario = (TextView)view.findViewById(R.id.lblUsuario);
        lblFecNac = (TextView)view.findViewById(R.id.lblFecNac);
        lblEdad = (TextView)view.findViewById(R.id.lblEdad);
        entidad= clsPersonaSQL.getSeleccionado(this.getActivity());
        lblNombres.setText(entidad.getApellido()+" "+entidad.getNombre());
        lblTelefono.setText(entidad.getTelefono());
        lblEmail.setText(entidad.getEmail());
        lblDNI.setText(entidad.getDNI());
        lblFecNac.setText(Utilidades.getFecha(entidad.getFecnac()));
        lblEdad.setText(""+Utilidades.getEdad(entidad.getFecnac())+" años");

        lblSexo.setText((entidad.isSexo())?"HOMBRE":"MUJER");
        lblUsuario.setText(entidad.getUsuario());
        ((MainActivity)  getActivity()).getSupportActionBar().setTitle(getString(R.string.lbl_item_dw_2_1));
        return view;
    }




}

