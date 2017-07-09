package com.refugiate.app.fragment.hoteles;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import com.refugiate.app.conexion.DisponibilidadHTTP;
import com.refugiate.app.dao.clsCostoTipoHabitacionSQL;
import com.refugiate.app.dao.clsHabitacionSQL;
import com.refugiate.app.dao.clsPersonaSQL;
import com.refugiate.app.dao.clsSucursalSQL;
import com.refugiate.app.dao.clsTipoHabitacionSQL;
import com.refugiate.app.entidades.clsCostoTipoHabitacion;
import com.refugiate.app.entidades.clsSucursal;
import com.refugiate.app.entidades.clsTipoHabitacion;
import com.refugiate.app.fragment.cuenta.FragmentLogin;
import com.refugiate.app.ui.MainActivity;
import com.refugiate.app.ui.R;
import com.refugiate.app.utilidades.Utilidades;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;


public class FragmentTab3 extends Fragment {

    private clsSucursal entidad;
    private List<clsTipoHabitacion> itensHabitacion;
    private List<clsCostoTipoHabitacion> itens;
    private AdaptadorTitulares adaptador;
    private ListView listHabitaciones;
    private Spinner Combo;
    private ProgressDialog pdCargar;

    View Tab4 ;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.tabs_3, container, false);
        entidad= clsSucursalSQL.getSeleccionado(this.getActivity());
        Tab4=  (View) view.findViewById(R.id.Tab4);
        Tab4.setVisibility(View.GONE);
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
        ((MainActivity)  getActivity()).getSupportActionBar().setTitle(entidad.getObjEmpresa().getNombreComercial());
        ((MainActivity)  getActivity()).registro=3;
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
        listHabitaciones.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                if(clsPersonaSQL.getSeleccionado(FragmentTab3.this.getActivity())==null) {
                    FragmentLogin fragment = new FragmentLogin();
                    Bundle bundle = new Bundle();
                    bundle.putInt("fragment",3); // use as per your need
                    fragment.setArguments(bundle);
                    ((MainActivity) getActivity()).setFragment(fragment);
                }
                else
                getDisponibilidad(itens.get(position).getIdCostoTipoHabitacion());

            }
        });
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

    public void getDisponibilidad(int id)
    {
        final int idCostoTipoHabitacion=id;
        AlertDialog.Builder alert = new AlertDialog.Builder(FragmentTab3.this.getActivity());
        alert.setTitle(getString(R.string.lbl_disponibilidad_tab3));
        alert.setPositiveButton(getString(R.string.str_btnAceptar), new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                pdCargar = new ProgressDialog(FragmentTab3.this.getActivity());
                pdCargar.setTitle(getString(R.string.lbl_verificando_tab3));
                pdCargar.setMessage(getString(R.string.lbl_espere_momento));
                pdCargar.setCancelable(false);
                pdCargar.show();

                new Thread() {
                    public void run() {
                        //clsDatos.setListaHoteles(ConfiguracionActivity.this);
                        try {
                            Message message = handlerCargar.obtainMessage();
                            Bundle bundle = new Bundle();
                            DisponibilidadHTTP disponibilidad = new DisponibilidadHTTP();
                            disponibilidad.execute(idCostoTipoHabitacion);
                            bundle.putString("data", disponibilidad.get());
                            message.setData(bundle);
                            handlerCargar.sendMessage(message);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        } catch (ExecutionException e) {
                            e.printStackTrace();
                        }
                    }
                }.start();
            }
        });

        alert.setNegativeButton(getString(R.string.str_btnCancelar), new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {

            }
        });
        alert.show();


    }


    final Handler handlerCargar=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            Bundle bundle = msg.getData();

            try {
                JSONObject objeto = new JSONObject(bundle.getString("data"));
                JSONArray listEmpresaJSON = new JSONArray(objeto.getString("listaHabitacionJSON"));
                    if(listEmpresaJSON.length()>0) {
                        clsHabitacionSQL.Agregar(FragmentTab3.this.getActivity(), listEmpresaJSON);
                        ((MainActivity) getActivity()).setFragment(new FragmentReserva());
                        pdCargar.dismiss();
                    }
                    else
                    {
                        pdCargar.dismiss();
                        Utilidades.alert(FragmentTab3.this.getActivity(),getString(R.string.lbl_sin_disponibilidad_tab3), false);
                    }


            } catch (JSONException e) {
                // pdCargar.dismiss();
                e.printStackTrace();
            }

            pdCargar.dismiss();
        }
    };
}