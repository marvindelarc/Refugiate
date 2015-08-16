package com.refugiate.app.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;

import com.refugiate.app.dao.clsConfiguracionSQL;
import com.refugiate.app.entidades.clsConfiguracion;

public class CargandoActivity extends Activity {

    public boolean configuracion=true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cargando);
        clsConfiguracion entidad=clsConfiguracionSQL.Buscar(this);
        if(entidad!=null)
            configuracion=false;
        AsyncTaskCargaDatos ATCargaDatos = new AsyncTaskCargaDatos(this);
        ATCargaDatos.execute();
    }
    public class AsyncTaskCargaDatos extends AsyncTask<Void, Integer, Void> {

        Context mContext;
        AsyncTaskCargaDatos(Context context) {
            mContext = context;
        }

        @Override
        protected Void doInBackground(Void... params) {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            return null;
        }



        @Override
        protected void onPostExecute(Void result) {
            Intent i;
            if(configuracion)
                i = new Intent(mContext, ConfiguracionActivity.class);
            else
                i = new Intent(mContext, MainActivity.class);

            startActivity(i);
            finish();
        }

    }
}
