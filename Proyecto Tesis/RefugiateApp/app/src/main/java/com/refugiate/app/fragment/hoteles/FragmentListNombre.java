package com.refugiate.app.fragment.hoteles;

import android.app.Activity;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.refugiate.app.dao.clsSucursalSQL;
import com.refugiate.app.entidades.clsSucursal;
import com.refugiate.app.fragment.hoteles.FragmentTab1;
import com.refugiate.app.ui.MainActivity;
import com.refugiate.app.ui.R;

import java.util.List;


public class FragmentListNombre extends Fragment {

    private List<clsSucursal> itens;
    private AdaptadorTitulares adaptador;
    private ListView listHoteles;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_list_nombre, container, false);
        ((MainActivity)  getActivity()).getSupportActionBar().setTitle(this.getString(R.string.lbl_item_dw_1_1));
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

        itens= clsSucursalSQL.Listar(this.getActivity());


        adaptador = new AdaptadorTitulares(this.getActivity());

        listHoteles.setAdapter(adaptador);
        listHoteles.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                btnDetalle(position);

            }
        });
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


            TextView lblNombre = (TextView)item.findViewById(R.id.lblNombre);
            lblNombre.setText(itens.get(position).getObjEmpresa().getNombreComercial());

            RatingBar ratingEstrellas = (RatingBar) item.findViewById(R.id.ratingEstrellas);
            ratingEstrellas.setRating(itens.get(position).getNivel());

            ImageView image = (ImageView)item.findViewById(R.id.image);
            if(itens.get(position).getObjEmpresa().getLogo()!=null)
                image.setImageDrawable( new BitmapDrawable(BitmapFactory.decodeByteArray(itens.get(position).getObjEmpresa().getLogo(), 0, itens.get(position).getObjEmpresa().getLogo().length)));


            return(item);
        }
    }

    public void btnDetalle(int posicion)
    {
        clsSucursalSQL.setSeleccionado(this.getActivity(),itens.get(posicion).getIdSucursal());
        ((MainActivity)getActivity()).setFragment(new FragmentTab1());

    }

}