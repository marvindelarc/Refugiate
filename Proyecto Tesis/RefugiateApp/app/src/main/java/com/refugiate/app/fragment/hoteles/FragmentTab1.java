package com.refugiate.app.fragment.hoteles;

import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.refugiate.app.dao.clsSucursalSQL;
import com.refugiate.app.entidades.clsSucursal;
import com.refugiate.app.ui.MainActivity;
import com.refugiate.app.ui.R;


public class FragmentTab1 extends Fragment {

private clsSucursal entidad;
    View Tab3 ;
    View Tab4 ;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.tabs_1, container, false);
        Tab3=  (View) view.findViewById(R.id.Tab3);
        Tab4=  (View) view.findViewById(R.id.Tab4);
        entidad= clsSucursalSQL.getSeleccionado(this.getActivity());

        Button btnTab2 = (Button) view.findViewById(R.id.btnTab2);

        btnTab2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnTabs(2);
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
        Tab4.setVisibility(View.GONE);
        if(entidad.isPaquete()) {
            Tab3.setVisibility(View.VISIBLE);
           // Tab4.setVisibility(View.VISIBLE);
        }
        else
        {
            Tab3.setVisibility(View.INVISIBLE);
            //Tab4.setVisibility(View.INVISIBLE);
        }
        TextView lblHotel = (TextView)view.findViewById(R.id.lblHotel);
        lblHotel.setText(entidad.getObjEmpresa().getNombreComercial());

        TextView lblSlogan = (TextView)view.findViewById(R.id.lblSlogan);
        lblSlogan.setText(entidad.getObjEmpresa().getSlogan());

        TextView lblDepartamento = (TextView)view.findViewById(R.id.lblDepartamento);
        lblDepartamento.setHint(entidad.getObjDistrito().getObjProvincia().getObjDepartamento().getStr_nombre());

        TextView lblProvincia = (TextView)view.findViewById(R.id.lblProvincia);
        lblProvincia.setHint(entidad.getObjDistrito().getObjProvincia().getStr_nombre());

        TextView lblDistrito = (TextView)view.findViewById(R.id.lblDistrito);
        lblDistrito.setHint(entidad.getObjDistrito().getStr_nombre());

        TextView lblDireccion = (TextView)view.findViewById(R.id.lblDireccion);
        lblDireccion.setHint(entidad.getDireccion());

        TextView lblPisos = (TextView)view.findViewById(R.id.lblPisos);
        lblPisos.setHint(""+entidad.getPisos());

        TextView lblHorario = (TextView)view.findViewById(R.id.lblHorario);
        lblHorario.setHint(entidad.getEntrada());



        RatingBar ratingEstrellas = (RatingBar) view.findViewById(R.id.ratingEstrellas);
        ratingEstrellas.setRating(entidad.getNivel());

        RatingBar ratingComodidad = (RatingBar) view.findViewById(R.id.ratingComodidad);
        ratingComodidad.setRating(entidad.getComodidad());

        RatingBar ratingLimpieza = (RatingBar) view.findViewById(R.id.ratingLimpieza);
        ratingLimpieza.setRating(entidad.getLimpieza());

        RatingBar ratingServicio = (RatingBar) view.findViewById(R.id.ratingServicio);
        ratingServicio.setRating(entidad.getServicio());

        RatingBar ratingPuntos = (RatingBar) view.findViewById(R.id.ratingPuntos);
        ratingPuntos.setRating(entidad.getPuntuacion());

        ImageView image = (ImageView)view.findViewById(R.id.image);
        if(entidad.getObjEmpresa().getLogo()!=null)
            image.setImageDrawable( new BitmapDrawable(BitmapFactory.decodeByteArray(entidad.getObjEmpresa().getLogo(), 0, entidad.getObjEmpresa().getLogo().length)));

        ((MainActivity)  getActivity()).mOptionsMenu.getItem(0).setVisible(true);
        ((MainActivity)  getActivity()).getSupportActionBar().setTitle(entidad.getObjEmpresa().getNombreComercial());
        return view;
    }


    private void btnTabs(int position)
    {
        Fragment fragment=null;
        switch (position)
        {
            case 2:
                fragment = new FragmentTab2();
                break;
            case 3:
                fragment = new FragmentTab3();
                break;
            case 4:
                fragment = new FragmentTab4();
            break;

        }
        ((MainActivity)getActivity()).setFragment(fragment);


    }


}

