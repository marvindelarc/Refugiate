package com.refugiate.app.fragment;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.refugiate.app.entidades.clsSucursal;
import com.refugiate.app.ui.R;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Roller on 04/06/2015.
 */
public class FragmentListNombre extends Fragment {

    private List<clsSucursal> itens;
    private AdaptadorTitulares adaptador;
    private ListView listHoteles;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_list_nombre, container, false);

        listHoteles = (ListView)view.findViewById(R.id.listHoteles);
        getLista();

        return view;
    }

    public void getLista()
    {
        /*
        itens=clsComentarioSQL.Listar(this);
        if(itens!=null && itens.size()>0)
        {
            adaptador = new AdaptadorTitulares(this);

            listHoteles.setAdapter(adaptador);
            listHoteles.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View v, int posicion, long id) {
//                    selecion(posicion);


                }
            });

        }
        */

        itens=new ArrayList<clsSucursal>();

        itens.add(new clsSucursal() );
        itens.add(new clsSucursal() );
        itens.add(new clsSucursal() );
        itens.add(new clsSucursal() );
        itens.add(new clsSucursal() );

        adaptador = new AdaptadorTitulares(this.getActivity());

        listHoteles.setAdapter(adaptador);
    }

    class AdaptadorTitulares extends ArrayAdapter {

        Activity context;
        AdaptadorTitulares(Activity context) {
            super(context, R.layout.lista_hoteles, itens);
            this.context = context;
        }


        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = context.getLayoutInflater();
            View item = inflater.inflate(R.layout.lista_hoteles, null);

           /**
            TextView lblUsuarioTabComentario = (TextView)item.findViewById(R.id.lblUsuarioTabComentario);
            lblUsuarioTabComentario.setText(hora.format(itens.get(position).getDat_Fecha())+" - "+fecha.format(itens.get(position).getDat_Fecha()));

            TextView lblComentarioTabComentario = (TextView)item.findViewById(R.id.lblComentarioTabComentario);
            lblComentarioTabComentario.setText("Hotel:"+itens.get(position).getStr_Usuario()+"\nComentario:"+itens.get(position).getStr_Descripcion());
        */
            return(item);
        }
    }

}