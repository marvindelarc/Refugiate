package com.refugiate.app.fragment.cuenta;

import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.refugiate.app.conexion.CancelarHTTP;
import com.refugiate.app.conexion.ComentarHTTP;
import com.refugiate.app.dao.clsReservaSQL;
import com.refugiate.app.dao.clsSucursalSQL;
import com.refugiate.app.entidades.clsReserva;
import com.refugiate.app.fragment.hoteles.FragmentTab1;
import com.refugiate.app.ui.MainActivity;
import com.refugiate.app.ui.R;
import com.refugiate.app.utilidades.Utilidades;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class FragmentHistorial extends Fragment {
    View view;
    private List<clsReserva> itens;
    private ListView listReservas;
    private AdaptadorTitulares adaptador;
    private ProgressDialog pdCargar;
    clsReserva entidad;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_historial, container, false);
        listReservas = (ListView)view.findViewById(R.id.listReservas);

        getLista();
        ((MainActivity)  getActivity()).getSupportActionBar().setTitle(getString(R.string.lbl_titulo_historial));
        return view;
    }

    class AdaptadorTitulares extends ArrayAdapter {

        Activity context;
        AdaptadorTitulares(Activity context) {
            super(context, R.layout.lista_historial, itens);
            this.context = context;
        }


        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = context.getLayoutInflater();
            final int pos=position;
            View item = inflater.inflate(R.layout.lista_historial, null);

            TextView lblEstado = (TextView)item.findViewById(R.id.lblEstado);


            if(itens.get(position).getEstado()==0) {
                lblEstado.setText(getString(R.string.lbl_estado0_historial));
            }
            else if(itens.get(position).getEstado()==1 || itens.get(position).getEstado()==3) {
                lblEstado.setText(getString(R.string.lbl_estado1_historial));
            }
            else if(itens.get(position).getEstado()==2) {
                lblEstado.setText(getString(R.string.lbl_estado2_historial));
            }
            Button btnCerrar = (Button)item.findViewById(R.id.btnCerrar);

            View viewComentario = (View)item.findViewById(R.id.viewComentario);
            if(itens.get(position).getEstado()==3 ) {
                btnCerrar.setVisibility(View.INVISIBLE);
                viewComentario.setVisibility(View.VISIBLE);
                RatingBar ratingComodidad = (RatingBar) item.findViewById(R.id.ratingComodidad);
                ratingComodidad.setRating(itens.get(position).getComodidad());

                RatingBar ratingLimpieza = (RatingBar) item.findViewById(R.id.ratingLimpieza);
                ratingLimpieza.setRating(itens.get(position).getLimpieza());

                RatingBar ratingServicio = (RatingBar) item.findViewById(R.id.ratingServicio);
                ratingServicio.setRating(itens.get(position).getServicio());

                TextView lblComentario = (TextView)item.findViewById(R.id.lblComentario);
                lblComentario.setText(itens.get(position).getComentario());


            }

            if(itens.get(position).getEstado()==0 || itens.get(position).getEstado()==2  ) {
                btnCerrar.setVisibility(View.INVISIBLE);
            }
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

            TextView lblNumero = (TextView)item.findViewById(R.id.lblNumero);
            lblNumero.setText(getString(R.string.lbl_numero_reservas) + " " + itens.get(position).getObjHabitacion().getNumero());


            btnCerrar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                   getCalificar(pos);
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

    public void getCalificar(int position)
    {
        final int pos=position;
        final Dialog dialog = new Dialog(this.getActivity());
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        //dialog.setCancelable(false);
        dialog.setContentView(R.layout.dialog_calificacion);

        final RatingBar ratingComodidad = (RatingBar) dialog.findViewById(R.id.ratingComodidad);
        final RatingBar ratingLimpieza = (RatingBar) dialog.findViewById(R.id.ratingLimpieza);
        final RatingBar ratingServicio = (RatingBar) dialog.findViewById(R.id.ratingServicio);
        final EditText txtComentario = (EditText) dialog.findViewById(R.id.txtComentario);
        txtComentario.setText("");
//
        Button btnAceptar = (Button) dialog.findViewById(R.id.btnAceptar);
        btnAceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ratingComodidad.getRating() > 0) {
                    if (ratingLimpieza.getRating() > 0) {
                        if (ratingServicio.getRating() > 0) {
                            if (txtComentario.length() > 0) {
                                pdCargar = new ProgressDialog(FragmentHistorial.this.getActivity());
                                pdCargar.setTitle(getString(R.string.lbl_agregar_cometario_historial));
                                pdCargar.setMessage(getString(R.string.lbl_espere_momento));
                                pdCargar.setCancelable(false);
                                pdCargar.show();

                                new Thread() {
                                    public void run() {
                                        //clsDatos.setListaHoteles(ConfiguracionActivity.this);
                                        try {
                                            entidad=itens.get(pos);
                                            entidad.setComodidad((int)ratingComodidad.getRating());
                                            entidad.setLimpieza((int) ratingLimpieza.getRating());
                                            entidad.setServicio((int) ratingServicio.getRating());
                                            entidad.setComentario(txtComentario.getText().toString());

                                            Message message = handlerCargar.obtainMessage();
                                            Bundle bundle = new Bundle();
                                            ComentarHTTP comentar = new ComentarHTTP();
                                            comentar.execute(entidad);
                                            bundle.putString("data", comentar.get());
                                            message.setData(bundle);
                                            handlerCargar.sendMessage(message);
                                        } catch (InterruptedException e) {
                                            e.printStackTrace();
                                        } catch (ExecutionException e) {
                                            e.printStackTrace();
                                        }
                                    }
                                }.start();




                                dialog.dismiss();
                            }
                            else
                                Utilidades.alert(FragmentHistorial.this.getActivity(),getString(R.string.lbl_agregar_comentario_historial),false);
                        }
                        else
                            Utilidades.alert(FragmentHistorial.this.getActivity(),getString(R.string.lbl_cal_servicio_historial),false);
                    }
                    else
                        Utilidades.alert(FragmentHistorial.this.getActivity(),getString(R.string.lbl_cal_limpieza_historial),false);
                }
                else
                    Utilidades.alert(FragmentHistorial.this.getActivity(),getString(R.string.lbl_cal_comodidad_historial),false);
            }
        });



        dialog.show();
    }
    public void getLista()
    {

        itens= clsReservaSQL.ListarHistorial(this.getActivity());



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

        ((MainActivity)getActivity()).mapa=3;
        ((MainActivity)getActivity()).setFragment(new FragmentTab1());
    }


    final Handler handlerCargar=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            Bundle bundle = msg.getData();

            try {
                JSONObject objeto = new JSONObject(bundle.getString("data"));
                //objeto.getInt("id");
                if(objeto.getBoolean("estado")) {
                    clsReservaSQL.setCometario(FragmentHistorial.this.getActivity(), entidad);
                    pdCargar.dismiss();
                    Utilidades.alert(FragmentHistorial.this.getActivity(), getString(R.string.lbl_sms_cometario_historial), false);
                    getLista();
                } else {
                    Utilidades.alert(FragmentHistorial.this.getActivity(), getString(R.string.alert_error), false);

                }


            } catch (JSONException e) {
                // pdCargar.dismiss();
                e.printStackTrace();
            }

            pdCargar.dismiss();
        }
    };
}

