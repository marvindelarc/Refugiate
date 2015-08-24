package com.refugiate.app.fragment.cuenta;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.TextView;

import com.refugiate.app.ui.MainActivity;
import com.refugiate.app.ui.R;

import java.util.Calendar;
import java.util.Date;


public class FragmentRegistro extends Fragment {
    View view;
    TextView lblFecNac;
    private int mYear;
    private int mMonth;
    private int mDay;
    private Calendar calendar;
    private Calendar calendarMax;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_registro, container, false);
        lblFecNac = (TextView)view.findViewById(R.id.lblFecNac);
        lblFecNac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lblFecNac();
            }
        });

        calendar = Calendar.getInstance();
        calendar.add(Calendar.YEAR, -18);
        calendarMax=calendar;
        mYear = calendar.get(Calendar.YEAR);
        mMonth = calendar.get(Calendar.MONTH);
        mDay = calendar.get(Calendar.DAY_OF_MONTH);
        updateDisplay();

        ((MainActivity)  getActivity()).getSupportActionBar().setTitle(getString(R.string.lbl_tituloregistro));
        return view;
    }


    public void lblFecNac ()
    {
        DialogFragment newFragment = new SelectDateFragment();
        newFragment.show(getFragmentManager(), "DatePicker");
    }



    public class SelectDateFragment extends DialogFragment implements DatePickerDialog.OnDateSetListener {
        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            int yy = calendar.get(Calendar.YEAR);
            int mm = calendar.get(Calendar.MONTH);
            int dd = calendar.get(Calendar.DAY_OF_MONTH);
            DatePickerDialog DatePicker =new DatePickerDialog(getActivity(), AlertDialog.THEME_HOLO_LIGHT, this, yy, mm, dd);
            DatePicker.getDatePicker().setMaxDate(calendarMax.getTimeInMillis());
            return DatePicker;
        }

        public void onDateSet(DatePicker view, int yy, int mm, int dd) {
            mYear = yy;
            mMonth = mm;
            mDay = dd;
            updateDisplay();
        }
    }



    private void updateDisplay() {

        calendar.set(mYear, mMonth, mDay);
        lblFecNac.setText(new StringBuilder().append(mDay).append("/") .append(mMonth+ 1).append("/").append(mYear));


    }


}

