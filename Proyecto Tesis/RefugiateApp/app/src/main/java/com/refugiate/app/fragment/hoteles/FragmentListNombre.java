package com.refugiate.app.fragment.hoteles;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.refugiate.app.dao.clsCostoTipoHabitacionSQL;
import com.refugiate.app.dao.clsServicioSQL;
import com.refugiate.app.dao.clsSucursalSQL;
import com.refugiate.app.entidades.clsServicio;
import com.refugiate.app.entidades.clsSucursal;
import com.refugiate.app.fragment.hoteles.FragmentTab1;
import com.refugiate.app.ui.MainActivity;
import com.refugiate.app.ui.R;
import com.refugiate.app.utilidades.Utilidades;
import com.yahoo.mobile.client.android.util.rangeseekbar.RangeSeekBar;

import java.util.ArrayList;
import java.util.List;


public class FragmentListNombre extends Fragment {

    private List<clsServicio> listServicios;
    private boolean[] booleanSelectArray;
    private List<clsSucursal> itens;
    private AdaptadorTitulares adaptador;
    private ListView listHoteles;
    private EditText txtFiltro;
    private RangeSeekBar rangebarEstrellas;
    private int iniEstrellas=1;
    private int finEstrellas=5;

    private RangeSeekBar rangebarPuntos;
    private int iniPuntos=1;
    private int finPuntos=5;

    private RangeSeekBar rangebarComodidad;
    private int iniComodidad=1;
    private int finComodidad=5;

    private RangeSeekBar rangebarLimpieza;
    private int iniLimpieza=1;
    private int finLimpieza=5;

    private RangeSeekBar rangebarServicio;
    private int iniServicio=1;
    private int finServicio=5;

    private RangeSeekBar rangebarPrecios;
    private int iniPrecios;
    private int finPrecios;
    private int minCosto;
    private int maxCosto;

    private int ordenar=0;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_list_nombre, container, false);
        iniPrecios=minCosto=clsCostoTipoHabitacionSQL.getMimCosto(this.getActivity());
        finPrecios=maxCosto=clsCostoTipoHabitacionSQL.getMaxCosto(this.getActivity());
        listServicios= clsServicioSQL.Listar(this.getActivity());
        booleanSelectArray = new boolean[listServicios.size()];
        ((MainActivity)  getActivity()).getSupportActionBar().setTitle(this.getString(R.string.lbl_item_dw_1_1));
        Button btnRangoFiltro = (Button) view.findViewById(R.id.btnRangoFiltro);
        btnRangoFiltro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnRangoFiltro();
            }
        });

        Button btnOrdenar = (Button) view.findViewById(R.id.btnOrdenar);
        btnOrdenar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnOrdenar();
            }
        });

        Button btnServicios = (Button) view.findViewById(R.id.btnServicios);
        btnServicios.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnServicios();
            }
        });

        listHoteles = (ListView)view.findViewById(R.id.listHoteles);
        txtFiltro = (EditText)view.findViewById(R.id.txtFiltro);
        txtFiltro.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence s, int start, int before,int count) {
                getLista(s.toString().trim());
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count,int after) {
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
        getLista("");

        return view;
    }

    public void getLista(String filtro)
    {
        List<clsServicio> lista=new ArrayList<clsServicio>();
        for(int i=0;i<booleanSelectArray.length;i++)
        {
            if(booleanSelectArray[i])
                lista.add(listServicios.get(i));
        }


        itens= clsSucursalSQL.Filtrar(this.getActivity(),filtro,iniEstrellas,finEstrellas
                ,iniPuntos,finPuntos,iniComodidad,finComodidad,iniLimpieza,finLimpieza
                ,iniServicio,finServicio,iniPrecios,finPrecios,ordenar,lista);


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

            TextView lblUbigeo = (TextView)item.findViewById(R.id.lblUbigeo);
            lblUbigeo.setText(itens.get(position).getObjDistrito().getObjProvincia().getObjDepartamento().getStr_nombre()
                            +" - "+itens.get(position).getObjDistrito().getObjProvincia().getStr_nombre()
                            +" - "+itens.get(position).getObjDistrito().getStr_nombre());


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
    public void btnRangoFiltro()
    {
        final Dialog dialog = new Dialog(this.getActivity());
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        //dialog.setCancelable(false);
        dialog.setContentView(R.layout.dialog_filtro_rango);
        
        final TextView lblrangebarPrecios = (TextView)dialog.findViewById(R.id.lblrangebarPrecios);
        lblrangebarPrecios.setText("" + iniPrecios + " a " + finPrecios);
        rangebarPrecios = (RangeSeekBar)dialog.findViewById(R.id.rangebarPrecios);
        rangebarPrecios.setRangeValues(minCosto, maxCosto);
        rangebarPrecios.setSelectedMinValue(iniPrecios);
        rangebarPrecios.setSelectedMaxValue(finPrecios);
        rangebarPrecios.setOnRangeSeekBarChangeListener(new RangeSeekBar.OnRangeSeekBarChangeListener<Integer>() {
            @Override
            public void onRangeSeekBarValuesChanged(RangeSeekBar<?> bar, Integer minValue, Integer maxValue) {
                // handle changed range values
                iniPrecios = minValue;
                finPrecios = maxValue;
                lblrangebarPrecios.setText("" + iniPrecios + " a " + finPrecios);
            }
        });


        final TextView lblrangebarEstrellas = (TextView)dialog.findViewById(R.id.lblrangebarEstrellas);
        lblrangebarEstrellas.setText("1 a 5");
        rangebarEstrellas = (RangeSeekBar)dialog.findViewById(R.id.rangebarEstrellas);
        //rangeSeekBar.setRangeValues(15, 90);
        rangebarEstrellas.setSelectedMinValue(iniEstrellas);
        rangebarEstrellas.setSelectedMaxValue(finEstrellas);
        rangebarEstrellas.setOnRangeSeekBarChangeListener(new RangeSeekBar.OnRangeSeekBarChangeListener<Integer>() {
            @Override
            public void onRangeSeekBarValuesChanged(RangeSeekBar<?> bar, Integer minValue, Integer maxValue) {
                // handle changed range values

                iniEstrellas = minValue;
                finEstrellas = maxValue;
                lblrangebarEstrellas.setText("" + iniEstrellas + " a " + finEstrellas);
            }
        });


        final TextView lblrangebarPuntos = (TextView)dialog.findViewById(R.id.lblrangebarPuntos);
        lblrangebarPuntos.setText("1 a 5");

        rangebarPuntos = (RangeSeekBar)dialog.findViewById(R.id.rangebarPuntos);
        //rangeSeekBar.setRangeValues(15, 90);
        rangebarPuntos.setSelectedMinValue(iniPuntos);
        rangebarPuntos.setSelectedMaxValue(finPuntos);
        rangebarPuntos.setOnRangeSeekBarChangeListener(new RangeSeekBar.OnRangeSeekBarChangeListener<Integer>() {
            @Override
            public void onRangeSeekBarValuesChanged(RangeSeekBar<?> bar, Integer minValue, Integer maxValue) {
                // handle changed range values
                iniPuntos = minValue;
                finPuntos = maxValue;
                lblrangebarPuntos.setText("" + iniPuntos + " a " + finPuntos);
            }
        });


        final TextView lblrangebarComodidad = (TextView)dialog.findViewById(R.id.lblrangebarComodidad);
        lblrangebarComodidad.setText("1 a 5");
        rangebarComodidad = (RangeSeekBar)dialog.findViewById(R.id.rangebarComodidad);
        //rangebarComodidad.setRangeValues(15, 90);
        rangebarComodidad.setSelectedMinValue(iniComodidad);
        rangebarComodidad.setSelectedMaxValue(finComodidad);
        rangebarComodidad.setOnRangeSeekBarChangeListener(new RangeSeekBar.OnRangeSeekBarChangeListener<Integer>() {
            @Override
            public void onRangeSeekBarValuesChanged(RangeSeekBar<?> bar, Integer minValue, Integer maxValue) {
                // handle changed range values
                iniComodidad = minValue;
                finComodidad = maxValue;
                lblrangebarComodidad.setText("" + iniComodidad + " a " + finComodidad);
            }
        });


        final TextView lblrangebarLimpieza = (TextView)dialog.findViewById(R.id.lblrangebarLimpieza);
        lblrangebarLimpieza.setText("1 a 5");
        rangebarLimpieza = (RangeSeekBar)dialog.findViewById(R.id.rangebarLimpieza);
        //rangebarComodidad.setRangeValues(15, 90);
        rangebarLimpieza.setSelectedMinValue(iniLimpieza);
        rangebarLimpieza.setSelectedMaxValue(finLimpieza);
        rangebarLimpieza.setOnRangeSeekBarChangeListener(new RangeSeekBar.OnRangeSeekBarChangeListener<Integer>() {
            @Override
            public void onRangeSeekBarValuesChanged(RangeSeekBar<?> bar, Integer minValue, Integer maxValue) {
                // handle changed range values
                iniLimpieza = minValue;
                finLimpieza = maxValue;
                lblrangebarLimpieza.setText("" + iniLimpieza + " a " + finLimpieza);
            }
        });


        final TextView lblrangebarServicio = (TextView)dialog.findViewById(R.id.lblrangebarServicio);
        lblrangebarServicio.setText("1 a 5");
        rangebarServicio = (RangeSeekBar)dialog.findViewById(R.id.rangebarServicio);
        //rangebarComodidad.setRangeValues(15, 90);
        rangebarServicio.setSelectedMinValue(iniServicio);
        rangebarServicio.setSelectedMaxValue(finServicio);
        rangebarServicio.setOnRangeSeekBarChangeListener(new RangeSeekBar.OnRangeSeekBarChangeListener<Integer>() {
            @Override
            public void onRangeSeekBarValuesChanged(RangeSeekBar<?> bar, Integer minValue, Integer maxValue) {
                // handle changed range values
                iniServicio = minValue;
                finServicio = maxValue;
                lblrangebarServicio.setText("" + iniServicio + " a " + finServicio);
            }
        });



        Button btnAceptar = (Button) dialog.findViewById(R.id.btnAceptar);
        btnAceptar.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {
                  getLista(txtFiltro.getText().toString());
                  dialog.dismiss();
            }
        });
        dialog.show();
    }

    public void btnOrdenar()
    {
        CharSequence[] items = getResources().getStringArray(R.array.array_ordenar);
        AlertDialog.Builder alert = new AlertDialog.Builder(this.getActivity());
        alert.setTitle(getString(R.string.str_ordenar));

        alert.setItems(items, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int item) {
                ordenar = item;
                getLista(txtFiltro.getText().toString());
            }});
        alert.show();
    }

    public void btnServicios()
    {
        final CharSequence[] items = new String[listServicios.size()];;
        for(int i=0;i<listServicios.size();i++)
        {
            items[i]=listServicios.get(i).getNombre();
        }


        AlertDialog.Builder builder=new AlertDialog.Builder(this.getActivity());
        builder.setTitle(getString(R.string.str_instalacion));
        builder.setPositiveButton(R.string.str_btnAceptar, new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                getLista(txtFiltro.getText().toString());
            }
        });

//setMultiChoiceItems will allow use to select multiple items from list by clicking on checkbox
        builder.setMultiChoiceItems(items, booleanSelectArray , new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {

            }
        });
        builder.show();
    }

}