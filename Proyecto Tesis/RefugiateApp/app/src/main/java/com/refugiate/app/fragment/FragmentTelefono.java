package com.refugiate.app.fragment;

import android.support.v4.app.Fragment;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.refugiate.app.ui.R;


/**
 * Created by Roller on 04/06/2015.
 */
public class FragmentTelefono extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_telefono, container, false);


        Button btnLlamarTelefono = (Button) view.findViewById(R.id.btnLlamarTelefono);

        btnLlamarTelefono.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnLlamarTelefono();
            }
        });

        return view;
    }


    public void btnLlamarTelefono() {
        Intent intent = new Intent(Intent.ACTION_CALL);
        intent.setData(Uri.parse("tel:" + this.getString(R.string.str_btnLlamar)));
        startActivity(intent);

    }
}