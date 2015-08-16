package com.refugiate.app.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.refugiate.app.ui.MainActivity;
import com.refugiate.app.ui.R;


public class FragmentTab3 extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.tabs_3, container, false);

        Button btnTab1 = (Button) view.findViewById(R.id.btnTab1);

        btnTab1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnTabs(1);
            }
        });

        Button btnTab2 = (Button) view.findViewById(R.id.btnTab2);

        btnTab2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnTabs(2);
            }
        });

        Button btnTab4 = (Button) view.findViewById(R.id.btnTab4);

        btnTab4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnTabs(4);
            }
        });

        Button btnTab5 = (Button) view.findViewById(R.id.btnTab5);

        btnTab5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnTabs(5);
            }
        });
        return view;
    }


    private void btnTabs(int position)
    {
        Fragment fragment=null;
        switch (position)
        {
            case 1:

                fragment = new FragmentTab1();
                break;
            case 2:
                fragment = new FragmentTab2();
                break;
            case 4:

                fragment = new FragmentTab4();
                break;
            case 5:
                fragment = new FragmentTab5();
                break;
            default:

                break;
        }
        ((MainActivity)getActivity()).setFragment(fragment);
    }



}