package com.refugiate.app.fragment.hoteles;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.TimePicker;

import com.refugiate.app.conexion.ReservaHTTP;
import com.refugiate.app.dao.clsHabitacionSQL;
import com.refugiate.app.dao.clsPersonaSQL;
import com.refugiate.app.dao.clsReservaSQL;
import com.refugiate.app.entidades.clsHabitacion;
import com.refugiate.app.entidades.clsReserva;
import com.refugiate.app.ui.MainActivity;
import com.refugiate.app.ui.R;
import com.refugiate.app.utilidades.Utilidades;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Calendar;
import java.util.List;
import java.util.concurrent.ExecutionException;


public class FragmentReserva extends Fragment {
    private View view;
    private TextView lblTotalDias;
    private TextView lblFecFin;
    private int mYearFin;
    private int mMonthFin;
    private int mDayFin;
    private TextView lblFecInicio;
    private int mYearInicio;
    private int mMonthInicio;
    private int mDayInicio;

    private TextView lblHora;
    private TextView lblCosto;
    private TextView lblTotal;
    private int hour;
    private int minute;

    private Calendar calendarInicio;
    private Calendar calendarFin;
    private Calendar calendarMinInicio;
    private Calendar calendarMinFin;

    private Calendar calendarMaxInicio;
    private Calendar calendarMaxFin;

    private int TotalDias;

    private List<clsHabitacion> itens;
    private ListView listHabitaciones;
    private AdaptadorTitulares adaptador;
    private ProgressDialog pdCargar;

    private clsReserva objReserva;

    private double costoTotal;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_reserva, container, false);

        listHabitaciones = (ListView)view.findViewById(R.id.listHabitaciones);

        lblTotalDias = (TextView)view.findViewById(R.id.lblTotalDias);
        lblCosto = (TextView)view.findViewById(R.id.lblCosto);
        lblTotal = (TextView)view.findViewById(R.id.lblTotal);

        lblFecInicio = (TextView)view.findViewById(R.id.lblFecInicio);
        lblFecInicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lblFecNac();
            }
        });
        lblFecFin = (TextView)view.findViewById(R.id.lblFecFin);
        lblFecFin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lblFecFin();
            }
        });
        lblHora = (TextView)view.findViewById(R.id.lblHora);
        lblHora.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lblHora();
            }
        });

        calendarInicio=Calendar.getInstance();
        calendarInicio.add(Calendar.DATE, 1);

        calendarMinInicio =Calendar.getInstance();
        calendarMinInicio.add(Calendar.DATE, 1);

        calendarMaxInicio=Calendar.getInstance();
        calendarMaxInicio.add(Calendar.MONTH, 3);

        calendarFin=Calendar.getInstance();
        calendarFin.add(Calendar.DATE, 2);

        calendarMinFin=Calendar.getInstance();
        calendarMinFin.add(Calendar.DATE, 2);

        calendarMaxFin=Calendar.getInstance();
        calendarMaxFin.add(Calendar.DATE, 7);

        mYearInicio = calendarInicio.get(Calendar.YEAR);
        mMonthInicio = calendarInicio.get(Calendar.MONTH);
        mDayInicio = calendarInicio.get(Calendar.DATE);

        mYearFin = calendarFin.get(Calendar.YEAR);
        mMonthFin = calendarFin.get(Calendar.MONTH);
        mDayFin = calendarFin.get(Calendar.DATE);

        hour = calendarInicio.get(Calendar.HOUR_OF_DAY);
        minute = calendarInicio.get(Calendar.MINUTE);
        getLista();
        updateDisplayInicio();
        ((MainActivity)getActivity()).getSupportActionBar().setTitle(getString(R.string.lbl_titulo_reserva));
        return view;
    }


    public void lblFecNac ()
    {
        DialogFragment newFragment = new SelectDateInicioFragment();
        newFragment.show(getFragmentManager(), "DatePicker");
    }

    public void lblFecFin()
    {
        DialogFragment newFragment = new SelectDateFinFragment();
        newFragment.show(getFragmentManager(), "DatePicker");
    }

    public void lblHora()
    {
        DialogFragment newFragment = new SelecTimeFragment();
        newFragment.show(getFragmentManager(), "timePicker");
    }

    public class SelectDateInicioFragment extends DialogFragment implements DatePickerDialog.OnDateSetListener {
        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            int yy = calendarInicio.get(Calendar.YEAR);
            int mm = calendarInicio.get(Calendar.MONTH);
            int dd = calendarInicio.get(Calendar.DATE);
            DatePickerDialog DatePickerInicio =new DatePickerDialog(getActivity(), AlertDialog.THEME_HOLO_LIGHT, this, yy, mm, dd);
            DatePickerInicio.getDatePicker().setMinDate(calendarMinInicio.getTimeInMillis());
            DatePickerInicio.getDatePicker().setMaxDate(calendarMaxInicio.getTimeInMillis());
            return DatePickerInicio;
        }

        public void onDateSet(DatePicker view, int yy, int mm, int dd) {
            mYearInicio = yy;
            mMonthInicio = mm;
            mDayInicio = dd;
            updateDisplayInicio();
        }
    }

    public class SelecTimeFragment extends DialogFragment implements TimePickerDialog.OnTimeSetListener {

        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {

            int hh = calendarInicio.get(Calendar.HOUR_OF_DAY);
            int mm = calendarInicio.get(Calendar.MINUTE);
            // Create a new instance of TimePickerDialog and return it
            TimePickerDialog TimePicker = new TimePickerDialog(getActivity(),AlertDialog.THEME_HOLO_LIGHT, this, hh, mm,
                    DateFormat.is24HourFormat(getActivity()));

            return TimePicker;
        }
        public void onTimeSet(TimePicker timePicker,  int hh,int mm) {
            hour = hh;
            minute = mm;
            updateDisplayInicio();
        }
    }

    public class SelectDateFinFragment extends DialogFragment implements DatePickerDialog.OnDateSetListener {
        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            int yy = calendarFin.get(Calendar.YEAR);
            int mm = calendarFin.get(Calendar.MONTH);
            int dd = calendarFin.get(Calendar.DATE);
            DatePickerDialog DatePickerFin =new DatePickerDialog(getActivity(), AlertDialog.THEME_HOLO_LIGHT, this, yy, mm, dd);
            DatePickerFin.getDatePicker().setMaxDate(calendarMaxFin.getTimeInMillis());
            DatePickerFin.getDatePicker().setMinDate(calendarMinFin.getTimeInMillis());
            return DatePickerFin;
        }

        public void onDateSet(DatePicker view, int yy, int mm, int dd) {
            mYearFin = yy;
            mMonthFin = mm;
            mDayFin = dd;
            updateDisplayFin();
        }
    }

    private void updateDisplayInicio() {

        calendarInicio.set(mYearInicio, mMonthInicio, mDayInicio, hour, minute);
        lblFecInicio.setText(new StringBuilder().append(Utilidades.pad(mDayInicio)).append("/").append(Utilidades.pad(mMonthInicio + 1)).append("/").append(mYearInicio));
        lblHora.setText(new StringBuilder().append(Utilidades.pad(hour)).append(":").append(Utilidades.pad(minute)));
        updateDisplayFin();
    }
    private void updateDisplayFin() {


        TotalDias =Utilidades.getDiferenciaEnDias(calendarInicio.getTime(),calendarFin.getTime());

        calendarMinFin.set(mYearInicio, mMonthInicio, mDayInicio);
        calendarMinFin.add(Calendar.DATE, 1);


        if(TotalDias>=1 && TotalDias<=7)
        {
            calendarFin.set(mYearFin, mMonthFin, mDayFin);
        }
        else
        {
            calendarMaxFin.set(mYearInicio, mMonthInicio, mDayInicio);
            calendarMaxFin.add(Calendar.DATE, 7);

            calendarFin.set(mYearInicio, mMonthInicio, mDayInicio);
            calendarFin.add(Calendar.DATE, 1);
            mYearFin = calendarFin.get(Calendar.YEAR);
            mMonthFin = calendarFin.get(Calendar.MONTH);
            mDayFin = calendarFin.get(Calendar.DATE);
        }

        lblFecFin.setText(new StringBuilder().append(Utilidades.pad(calendarFin.get(Calendar.DATE))).append("/").append(Utilidades.pad(calendarFin.get(Calendar.MONTH) + 1)).append("/").append(calendarFin.get(Calendar.YEAR)));
        TotalDias =Utilidades.getDiferenciaEnDias(calendarInicio.getTime(), calendarFin.getTime());
       // lblTotal.setText(""+Double.parseDouble(lblCosto.getText().toString())*TotalDias);

        lblTotalDias.setText("Total: "+TotalDias);

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
            lblNombre.setText(getString(R.string.lbl_nombre_tab3)+" "+ itens.get(position).getObjCostoTipoHabitacion().getObjTipohabitacion().getNombreComercial());
            TextView lblCosto = (TextView)item.findViewById(R.id.lblCosto);
            lblCosto.setText(getString(R.string.lbl_numero_reserva)+" "+ itens.get(position).getNumero());


            TextView lblTotal = (TextView)item.findViewById(R.id.lblTotal);
            if(itens.get(position).isVista())
                lblTotal.setText(getString(R.string.lbl_vista_interior_reserva));
            else
                lblTotal.setText(getString(R.string.lbl_vista_exteriot_reserva));

            TextView lblPersonas = (TextView)item.findViewById(R.id.lblPersonas);
            lblPersonas.setText(getString(R.string.lbl_piso_reserva)+" "+ itens.get(position).getPiso());


            return(item);
        }
    }


    public void getLista()
    {

        itens= clsHabitacionSQL.Listar(this.getActivity());
        //lblCosto.setText(""+itens.get(0).getObjCostoTipoHabitacion().getCosto());
       // costoTotal=itens.get(0).getObjCostoTipoHabitacion().getCosto();



        adaptador = new AdaptadorTitulares(this.getActivity());

        listHabitaciones.setAdapter(adaptador);
        listHabitaciones.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                setReserva(position);

            }
        });
    }

    public void setReserva(int pos)
    {
        final int position=pos;
        AlertDialog.Builder alert = new AlertDialog.Builder(FragmentReserva.this.getActivity());
        alert.setTitle(getString(R.string.lbl_reserva));
        alert.setPositiveButton(getString(R.string.str_btnAceptar), new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                pdCargar = new ProgressDialog(FragmentReserva.this.getActivity());
                pdCargar.setTitle(getString(R.string.alert_reserva));
                pdCargar.setMessage(getString(R.string.lbl_espere_momento));
                pdCargar.setCancelable(false);
                pdCargar.show();

                new Thread() {
                    public void run() {
                        //clsDatos.setListaHoteles(ConfiguracionActivity.this);
                        try {
                            Message message = handlerCargar.obtainMessage();
                            Bundle bundle = new Bundle();
                            ReservaHTTP reserva = new ReservaHTTP();
                            objReserva =new clsReserva();
                            objReserva.setFechaEgreso(calendarFin.getTime());
                            objReserva.setFechaIngreso(calendarInicio.getTime());
                            objReserva.setDias(TotalDias);
                            objReserva.setCosto(costoTotal);
                            objReserva.setObjPersona(clsPersonaSQL.getSeleccionado(FragmentReserva.this.getActivity()));
                            objReserva.setObjHabitacion(itens.get(position));

                            reserva.execute(objReserva);
                            bundle.putString("data", reserva.get());
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
                if(objeto.getInt("id")>0) {
                    objReserva.setIdReserva(objeto.getInt("id"));
                    clsReservaSQL.Agregar(FragmentReserva.this.getActivity(), objReserva);
                    pdCargar.dismiss();
                    Utilidades.alert(FragmentReserva.this.getActivity(), getString(R.string.lbl_confirmacion_reserva), false);
                    ((MainActivity)getActivity()).setFragment(new FragmentTab3());
                }
                else {
                    Utilidades.alert(FragmentReserva.this.getActivity(), getString(R.string.alert_error), false);

                }


            } catch (JSONException e) {
                // pdCargar.dismiss();
                e.printStackTrace();
            }

            pdCargar.dismiss();
        }
    };
}

