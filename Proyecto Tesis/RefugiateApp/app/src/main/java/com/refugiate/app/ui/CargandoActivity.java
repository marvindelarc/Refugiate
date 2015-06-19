package com.refugiate.app.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.refugiate.app.dao.gipUsuarioDAO;

public class CargandoActivity extends Activity {

    public boolean estado=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cargando);



        AsyncTaskCargaDatos ATCargaDatos = new AsyncTaskCargaDatos(this);
        ATCargaDatos.execute();

        if( gipUsuarioDAO.Buscar(this, 1)!=null)
            estado=true;
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

            if(estado)
            {
                Intent i=new Intent(mContext,MainActivity.class);
                startActivity(i);
                finish();
            }
            else
            {
                Intent i=new Intent(mContext,ConfiguracionActivity.class);
                startActivity(i);
                finish();
            }

        }

    }
}
