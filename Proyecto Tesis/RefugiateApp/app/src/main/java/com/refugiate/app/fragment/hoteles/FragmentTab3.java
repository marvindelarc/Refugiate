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
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.TextView;

import com.refugiate.app.dao.clsCostoTipoHabitacionSQL;
import com.refugiate.app.dao.clsSucursalSQL;
import com.refugiate.app.dao.clsTipoHabitacionSQL;
import com.refugiate.app.entidades.clsCostoTipoHabitacion;
import com.refugiate.app.entidades.clsSucursal;
import com.refugiate.app.entidades.clsTipoHabitacion;
import com.refugiate.app.ui.MainActivity;
import com.refugiate.app.ui.R;

import java.util.ArrayList;
import java.util.List;


public class FragmentTab3 extends Fragment {

    private clsSucursal entidad;
    private List<clsTipoHabitacion> itensHabitacion;
    private List<clsCostoTipoHabitacion> itens;
    private AdaptadorTitulares adaptador;
    private ListView listHabitaciones;
    private Spinner Combo;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.tabs_3, container, false);
        entidad= clsSucursalSQL.getSeleccionado(this.getActivity());

        listHabitaciones = (ListView)view.findViewById(R.id.listHabitaciones);
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

        Combo = (Spinner)view.findViewById(R.id.Combo);
        Combo();

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

            default:

                break;
        }
        ((MainActivity)getActivity()).setFragment(fragment);
    }

    class AdaptadorTitulares extends ArrayAdapter {

        Activity context;
        AdaptadorTitulares(Activity context) {
            super(context, R.layout.lista_habitacion, itens);
            this.context = context;
        }


        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = context.getLayoutInflater();
            View item = inflater.inflate(R.layout.lista_habitacion, null);

            TextView lblNombre = (TextView)item.findViewById(R.id.lblNombre);
            lblNombre.setText(getString(R.string.lbl_nombre_tab3)+" "+ itens.get(position).getObjTipohabitacion().getNombreComercial());

            TextView lblTotal = (TextView)item.findViewById(R.id.lblTotal);
            lblTotal.setText(getString(R.string.lbl_total_tab3)+" "+ itens.get(position).getTotalHabitaciones());

            TextView lblPersonas = (TextView)item.findViewById(R.id.lblPersonas);
            lblPersonas.setText(getString(R.string.lbl_capacidad_tab3)+" "+ itens.get(position).getNumeroPersonas());

            TextView lblCosto = (TextView)item.findViewById(R.id.lblCosto);
            lblCosto.setText(getString(R.string.lbl_costo_tab3)+" "+ itens.get(position).getCosto());


            return(item);
        }
    }

    public void getLista(int idTipoHabitacion)
    {

        itens= clsCostoTipoHabitacionSQL.Listar(this.getActivity(),entidad.getIdSucursal(),idTipoHabitacion);
        adaptador = new AdaptadorTitulares(this.getActivity());

        listHabitaciones.setAdapter(adaptador);
      /*  listHoteles.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                btnDetalle(position);

            }
        });*/
    }


    public void Combo (){
        itensHabitacion= clsTipoHabitacionSQL.Listar(this.getActivity(),entidad.getIdSucursal());
        itensHabitacion.add(0,new clsTipoHabitacion(0,"Todos"));
        List<String> listString = new ArrayList<String>();
        for(clsTipoHabitacion objTipoHabitacion:itensHabitacion)
            listString.add(objTipoHabitacion.getNombreComercial());

        ArrayAdapter<String> adapterConbo = new ArrayAdapter<String>(this.getActivity(),R.layout.spinner,listString);

        adapterConbo.setDropDownViewResource(android.R.layout.simple_spinner_item);
        Combo.setAdapter(adapterConbo);
        Combo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                getLista(itensHabitacion.get(position).getIdTipoHabitacion());
            }
            public void onNothingSelected(AdapterView<?> parent) {
                //User selected same item. Nothing to do.
            }
        });
        Combo.setSelection(0);
    }
}