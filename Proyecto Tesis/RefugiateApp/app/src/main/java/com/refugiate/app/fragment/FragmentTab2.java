package com.refugiate.app.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.refugiate.app.ui.R;


/**
 * Created by Roller on 04/06/2015.
 */
public class FragmentTab2 extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.tabs_2, container, false);

        Button btnTab1 = (Button) view.findViewById(R.id.btnTab1);

        btnTab1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnTabs(1);
            }
        });

        Button btnTab3 = (Button) view.findViewById(R.id.btnTab3);

        btnTab3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnTabs(3);
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
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        Fragment fragment;
        switch (position)
        {
            case 1:

                fragment = new FragmentTab1();
                transaction.replace(R.id.content_frame, fragment);
                transaction.addToBackStack(null);
                transaction.commit();
                break;
            case 3:
                fragment = new FragmentTab3();
                transaction.replace(R.id.content_frame, fragment);
                transaction.addToBackStack(null);
                transaction.commit();
                break;
            case 4:

                fragment = new FragmentTab4();
                transaction.replace(R.id.content_frame, fragment);
                transaction.addToBackStack(null);
                transaction.commit();
                break;
            case 5:
                fragment = new FragmentTab5();
                transaction.replace(R.id.content_frame, fragment);
                transaction.addToBackStack(null);
                transaction.commit();
                break;
            default:

                break;
        }
    }



}