package com.refugiate.app.fragment;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.refugiate.app.ui.R;

/**
 * Created by RFERNANDEZ on 08/06/2015.
 */
public class FragmentNosotros extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_nosotros, container, false);


        return view;
    }
}
