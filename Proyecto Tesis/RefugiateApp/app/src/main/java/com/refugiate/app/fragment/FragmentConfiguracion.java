package com.refugiate.app.fragment;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;

import com.refugiate.app.dao.gipUsuarioDAO;
import com.refugiate.app.entidades.gipUsuario;
import com.refugiate.app.ui.R;
import com.refugiate.app.utilidades.ToSpeech;


/**
 * Created by Roller on 04/06/2015.
 */
public class FragmentConfiguracion extends Fragment {

    private CheckBox chkMail;
    private CheckBox chkVoz;
    private gipUsuario entidad;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.activity_configuracion, container, false);

        chkVoz = (CheckBox) view.findViewById(R.id.chkVoz);
        chkMail = (CheckBox) view.findViewById(R.id.chkMail);

        entidad = new gipUsuario();
        gipUsuarioDAO.Agregar(this.getActivity(), entidad);

        chkVoz.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                entidad.setVoz(chkVoz.isChecked());
                new ToSpeech(FragmentConfiguracion.this.getActivity(),FragmentConfiguracion.this.getString(R.string.str_chkVozConfiguracion));
                if(chkVoz.isChecked())
                    new ToSpeech(FragmentConfiguracion.this.getActivity(),FragmentConfiguracion.this.getString(R.string.str_check_habilitado));
                else
                    new ToSpeech(FragmentConfiguracion.this.getActivity(),FragmentConfiguracion.this.getString(R.string.str_check_inhabilitado));
            }
        });

        chkMail.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                entidad.setMail(chkMail.isChecked());
                new ToSpeech(FragmentConfiguracion.this.getActivity(),FragmentConfiguracion.this.getString(R.string.str_chkMailConfiguracion));
                if(chkMail.isChecked())
                    new ToSpeech(FragmentConfiguracion.this.getActivity(),FragmentConfiguracion.this.getString(R.string.str_check_habilitado));
                else
                    new ToSpeech(FragmentConfiguracion.this.getActivity(),FragmentConfiguracion.this.getString(R.string.str_check_inhabilitado));
            }
        });

        Button btnAceptarConfiguracion = (Button) view.findViewById(R.id.btnAceptarConfiguracion);
        btnAceptarConfiguracion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnAceptarConfiguracion();
            }
        });

        return view;
    }

    public void btnAceptarConfiguracion()
    {
        gipUsuarioDAO.Actualizar(this.getActivity(), entidad);
    }

}