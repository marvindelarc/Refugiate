package com.refugiate.app.fragment;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.refugiate.app.ui.R;
import com.refugiate.app.utilidades.link;

import java.util.ArrayList;
import java.util.List;

public class FragmentLinks extends Fragment{

    private Adaptador adaptador;
    private ListView lista;
    private List<link> itens;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_links, container,false);

        lista = (ListView)view.findViewById(R.id.lista);

        setAdapter();


        return view;
    }

    public void setAdapter()
    {
        itens= new ArrayList<link>();
        itens.add(new link(this.getString(R.string.lbl_link1),this.getString(R.string.lbl_dpnp),this.getString(R.string.str_lblPersonas), BitmapFactory.decodeResource(getResources(), R.drawable.pnplog)));
        itens.add(new link(this.getString(R.string.lbl_link2),this.getString(R.string.lbl_ddirandro), this.getString(R.string.str_lblPersonas),BitmapFactory.decodeResource(getResources(), R.drawable.ic_launcherd)));
        itens.add(new link(this.getString(R.string.lbl_link3),this.getString(R.string.lbl_dreniec), this.getString(R.string.str_lblPersonas),BitmapFactory.decodeResource(getResources(), R.drawable.reniec)));
        itens.add(new link(this.getString(R.string.lbl_link4),this.getString(R.string.lbl_dsunat), this.getString(R.string.str_lblPersonas),BitmapFactory.decodeResource(getResources(), R.drawable.sunat)));
        itens.add(new link(this.getString(R.string.lbl_link6),this.getString(R.string.lbl_dcomisarias),this.getString(R.string.str_lblPersonas), BitmapFactory.decodeResource(getResources(), R.drawable.policiarrestando)));
        itens.add(new link(this.getString(R.string.lbl_link7),this.getString(R.string.lbl_facebook),this.getString(R.string.str_lblPersonas), BitmapFactory.decodeResource(getResources(), R.drawable.facebook)));


        adaptador = new Adaptador(this.getActivity());
        lista.setAdapter(adaptador);
    }
    class Adaptador extends ArrayAdapter {

        Activity context;

        Adaptador(Activity context) {
            super(context, R.layout.lista, itens);
            this.context = context;
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = context.getLayoutInflater();
            View item = inflater.inflate(R.layout.lista, null);

            final int pos=position;

            TextView lblTituloLista = (TextView)item.findViewById(R.id.lblTituloLista);
            lblTituloLista.setText(itens.get(position).getTitulo());

            TextView lblDetalleLista = (TextView)item.findViewById(R.id.lblDetalleLista);
            lblDetalleLista.setText(itens.get(position).getDetalle());

            ImageView imgLogo = (ImageView)item.findViewById(R.id.imgLogo);
            imgLogo.setImageBitmap(itens.get(position).getLogo());

            Button btnLink = (Button)item.findViewById(R.id.btnLink);
            btnLink.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    btnLink(pos);
                }
            });


            return(item);
        }
    }

    private void btnLink(int position)
    {
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        Fragment fragment;
        Intent intent = new Intent(Intent.ACTION_VIEW);
        switch (position)
        {
            case 0:
                intent.setData(Uri.parse("https://www.pnp.gob.pe/"));
                getActivity().startActivity(intent);
                break;
            case 1:
                intent.setData(Uri.parse("http://www.dirandro.pnp.gob.pe/"));
                getActivity().startActivity(intent);
                break;
            case 2:
                fragment = new FragmentReniec();
                transaction.replace(R.id.content_frame, fragment);
                transaction.addToBackStack(null);
                transaction.commit();
                break;
            case 3:

                fragment = new FragmentSunat();
                transaction.replace(R.id.content_frame, fragment);
                transaction.addToBackStack(null);
                transaction.commit();
                break;
            case 4:
                fragment = new FragmentComisaria();
                transaction.replace(R.id.content_frame, fragment);
                transaction.addToBackStack(null);
                transaction.commit();
                break;
            case 5:
                intent.setData(Uri.parse("https://www.facebook.com/pnp.dirandro"));
                getActivity().startActivity(intent);
                break;
            default:

                break;
        }
    }
}
