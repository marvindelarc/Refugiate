package com.refugiate.app.fragment.hoteles;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import com.refugiate.app.entidades.clsPersona;
import com.refugiate.app.ui.MainActivity;
import com.refugiate.app.ui.R;
import com.refugiate.app.utilidades.Utilidades;

import java.util.Calendar;


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
    private int hour;
    private int minute;

    private Calendar calendarInicio;
    private Calendar calendarFin;
    private Calendar calendarMinInicio;
    private Calendar calendarMinFin;

    private Calendar calendarMaxInicio;
    private Calendar calendarMaxFin;

    private clsPersona entidad;
    private Button btnAceptar;
    int TotalDias;




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_reserva, container, false);
        entidad =new clsPersona();
        btnAceptar = (Button)view.findViewById(R.id.btnAceptar);
        btnAceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnAceptar();
            }
        });

        lblTotalDias = (TextView)view.findViewById(R.id.lblTotalDias);


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

        updateDisplayInicio();
        ((MainActivity)  getActivity()).getSupportActionBar().setTitle(getString(R.string.lbl_titulo_reserva));
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
        if(TotalDias>=1 && TotalDias<=7)
        {
            calendarFin.set(mYearFin, mMonthFin, mDayFin);
        }
        else
        {


            calendarFin.set(mYearInicio, mMonthInicio, mDayInicio);
            calendarFin.add(Calendar.DATE, 1);

        }
        calendarMinFin.set(mYearInicio, mMonthInicio, mDayInicio);
        calendarMinFin.add(Calendar.DATE, 1);

        calendarMaxFin.set(mYearInicio, mMonthInicio, mDayInicio);
        calendarMaxFin.add(Calendar.DATE, 7);

        lblFecFin.setText(new StringBuilder().append(Utilidades.pad(calendarFin.get(Calendar.DATE))).append("/").append(Utilidades.pad(calendarFin.get(Calendar.MONTH) + 1)).append("/").append(calendarFin.get(Calendar.YEAR)));
        TotalDias =Utilidades.getDiferenciaEnDias(calendarInicio.getTime(),calendarFin.getTime());
        lblTotalDias.setText("Total: "+TotalDias);

    }
    public void btnAceptar()
    {
        
    }



}

