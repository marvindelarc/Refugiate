package com.refugiate.app.fragment.cuenta;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.refugiate.app.ui.MainActivity;
import com.refugiate.app.ui.R;


public class FragmentLogin extends Fragment {
    View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.dialog_login, container, false);

        ((MainActivity)  getActivity()).getSupportActionBar().setTitle(getString(R.string.lbl_iniciar_sesion));
        return view;
    }




}

