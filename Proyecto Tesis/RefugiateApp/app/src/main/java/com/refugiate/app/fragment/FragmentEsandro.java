package com.refugiate.app.fragment;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.refugiate.app.ui.R;
import com.refugiate.app.utilidades.Utilidades;

/**
 * Created by RFERNANDEZ on 08/06/2015.
 */
public class FragmentEsandro extends Fragment {

    Button curso;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.fragment_esandro, container, false);
        curso=(Button)view.findViewById(R.id.btncurso);

        curso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Utilidades.alert(FragmentEsandro.this.getActivity(), FragmentEsandro.this.getString(R.string.lbl_mesandro),false);
            }
        });



        return view;
    }
}
