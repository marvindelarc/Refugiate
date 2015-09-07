package com.refugiate.app.fragment.cuenta;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.refugiate.app.conexion.CancelarHTTP;
import com.refugiate.app.conexion.ReservaHTTP;
import com.refugiate.app.dao.clsPersonaSQL;
import com.refugiate.app.dao.clsReservaSQL;
import com.refugiate.app.dao.clsSucursalSQL;
import com.refugiate.app.entidades.clsReserva;
import com.refugiate.app.fragment.hoteles.FragmentTab1;
import com.refugiate.app.ui.MainActivity;
import com.refugiate.app.ui.R;
import com.refugiate.app.utilidades.Utilidades;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutionException;


public class FragmentReservas extends Fragment {
    View view;
    private List<clsReserva> itens;
    private ListView listReservas;
    private AdaptadorTitulares adaptador;
    private ProgressDialog pdCargar;
    private int IdReserva=0;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_reservas, container, false);
        listReservas = (ListView)view.findViewById(R.id.listReservas);

        getLista();
        ((MainActivity)  getActivity()).getSupportActionBar().setTitle(getString(R.string.lbl_titulo_reservas));
        return view;
    }

    class AdaptadorTitulares extends ArrayAdapter {

        Activity context;
        AdaptadorTitulares(Activity context) {
            super(context, R.layout.lista_reservas, itens);
            this.context = context;
        }


        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = context.getLayoutInflater();
            final int pos=position;
            View item = inflater.inflate(R.layout.lista_reservas, null);
            TextView lblUbigeo = (TextView)item.findViewById(R.id.lblUbigeo);
            lblUbigeo.setText(getString(R.string.lbl_nombre_tab3) + " " + itens.get(position).getObjHabitacion().getObjCostoTipoHabitacion().getObjTipohabitacion().getNombreComercial());


            TextView lblNombre = (TextView)item.findViewById(R.id.lblNombre);
            lblNombre.setText(itens.get(position).getObjHabitacion().getObjCostoTipoHabitacion().getObjSucursal().getObjEmpresa().getNombreComercial());

            RatingBar ratingEstrellas = (RatingBar) item.findViewById(R.id.ratingEstrellas);
            ratingEstrellas.setRating(itens.get(position).getObjHabitacion().getObjCostoTipoHabitacion().getObjSucursal().getNivel());

            ImageView image = (ImageView)item.findViewById(R.id.image);
            if(itens.get(position).getObjHabitacion().getObjCostoTipoHabitacion().getObjSucursal().getObjEmpresa().getLogo()!=null)
                image.setImageDrawable( new BitmapDrawable(BitmapFactory.decodeByteArray(itens.get(position).getObjHabitacion().getObjCostoTipoHabitacion().getObjSucursal().getObjEmpresa().getLogo(), 0, itens.get(position).getObjHabitacion().getObjCostoTipoHabitacion().getObjSucursal().getObjEmpresa().getLogo().length)));
            image.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    getReserva(pos);
                }
            });

            TextView lblFecInicio = (TextView)item.findViewById(R.id.lblFecInicio);
            lblFecInicio.setText(Utilidades.getFecha(itens.get(position).getFechaIngreso()));

            TextView lblFecFin = (TextView)item.findViewById(R.id.lblFecFin);
            lblFecFin.setText(Utilidades.getFecha(itens.get(position).getFechaEgreso()));

            TextView lblHora = (TextView)item.findViewById(R.id.lblHora);
            lblHora.setText(Utilidades.getHora(itens.get(position).getFechaIngreso()));

            TextView lblTotal = (TextView)item.findViewById(R.id.lblTotal);
            lblTotal.setText(""+itens.get(position).getCosto());

            int horas=Utilidades.getDiferenciaEnHoras(new Date(),itens.get(position).getFechaIngreso());
            TextView lblNumero = (TextView)item.findViewById(R.id.lblNumero);
            lblNumero.setText(getString(R.string.lbl_numero_reservas) + " " + itens.get(position).getObjHabitacion().getNumero());

            Button btnCerrar = (Button)item.findViewById(R.id.btnCerrar);
            if(horas<=12)
                btnCerrar.setVisibility(View.INVISIBLE);
            btnCerrar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    IdReserva=itens.get(pos).getIdReserva();
                    getCerrar();
                }
            });

            TextView lblVista = (TextView)item.findViewById(R.id.lblVista);
            if(itens.get(position).getObjHabitacion().isVista())
                lblVista.setText(getString(R.string.lbl_vista_interior_reserva));
            else
                lblVista.setText(getString(R.string.lbl_vista_exteriot_reserva));

            return(item);
        }
    }


    public void getLista()
    {

        itens= clsReservaSQL.ListarAcivas(this.getActivity());



        adaptador = new AdaptadorTitulares(this.getActivity());

        listReservas.setAdapter(adaptador);
        /*
        listReservas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                setReserva(position);

            }
        });*/
    }

    public void getReserva(int pos)
    {
        clsSucursalSQL.setSeleccionado(this.getActivity(), itens.get(pos).getObjHabitacion().getObjCostoTipoHabitacion().getObjSucursal().getIdSucursal());

        ((MainActivity)getActivity()).mapa=2;
        ((MainActivity)getActivity()).setFragment(new FragmentTab1());
    }

    public void getCerrar()
    {
        AlertDialog.Builder alert = new AlertDialog.Builder(this.getActivity());
        alert.setTitle(getString(R.string.lbl_cancelar_reservas));
        alert.setPositiveButton(getString(R.string.str_btnAceptar), new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                pdCargar = new ProgressDialog(FragmentReservas.this.getActivity());
                pdCargar.setTitle(getString(R.string.alert_reservas));
                pdCargar.setMessage(getString(R.string.lbl_espere_momento));
                pdCargar.setCancelable(false);
                pdCargar.show();

                new Thread() {
                    public void run() {
                        //clsDatos.setListaHoteles(ConfiguracionActivity.this);
                        try {
                            Message message = handlerCargar.obtainMessage();
                            Bundle bundle = new Bundle();
                            CancelarHTTP cancelar = new CancelarHTTP();
                            cancelar.execute(IdReserva);
                            bundle.putString("data", cancelar.get());
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
                //objeto.getInt("id");
                if(objeto.getBoolean("estado")) {
                    pdCargar.dismiss();
                    Utilidades.alert(FragmentReservas.this.getActivity(), getString(R.string.lbl_conf_cancelar_reservas), false);
                    clsReservaSQL.setCancelar(FragmentReservas.this.getActivity(),IdReserva);
                    getLista();
                } else {
                    Utilidades.alert(FragmentReservas.this.getActivity(), getString(R.string.alert_error), false);

                }


            } catch (JSONException e) {
                // pdCargar.dismiss();
                e.printStackTrace();
            }

            pdCargar.dismiss();
        }
    };

}

