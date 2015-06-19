package com.refugiate.app.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

import com.refugiate.app.dao.gipUsuarioDAO;
import com.refugiate.app.entidades.gipUsuario;
import com.refugiate.app.utilidades.ToSpeech;

public class ConfiguracionActivity extends Activity {

    private CheckBox chkMail;
    private CheckBox chkVoz;
    private gipUsuario entidad;
    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        // ToDo add your GUI initialization code here
        setContentView(R.layout.activity_configuracion);
        
        chkVoz = (CheckBox) findViewById(R.id.chkVoz);
        chkMail = (CheckBox) findViewById(R.id.chkMail);

        entidad = new gipUsuario();
        gipUsuarioDAO.Agregar(this, entidad);

        chkVoz.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                entidad.setVoz(chkVoz.isChecked());
                new ToSpeech(ConfiguracionActivity.this,ConfiguracionActivity.this.getString(R.string.str_chkVozConfiguracion));
                if(chkVoz.isChecked())
                    new ToSpeech(ConfiguracionActivity.this,ConfiguracionActivity.this.getString(R.string.str_check_habilitado));
                else
                    new ToSpeech(ConfiguracionActivity.this,ConfiguracionActivity.this.getString(R.string.str_check_inhabilitado));
            }
        });

        chkMail.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                entidad.setMail(chkMail.isChecked());
                new ToSpeech(ConfiguracionActivity.this,ConfiguracionActivity.this.getString(R.string.str_chkMailConfiguracion));
                if(chkMail.isChecked())
                    new ToSpeech(ConfiguracionActivity.this,ConfiguracionActivity.this.getString(R.string.str_check_habilitado));
                else
                    new ToSpeech(ConfiguracionActivity.this,ConfiguracionActivity.this.getString(R.string.str_check_inhabilitado));
            }
        });

        Button btnAceptarConfiguracion = (Button) findViewById(R.id.btnAceptarConfiguracion);
        btnAceptarConfiguracion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnAceptarConfiguracion();
            }
        });

    }




    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event)
    {
        return false;
    }

    public void btnAceptarConfiguracion()
    {
        gipUsuarioDAO.Actualizar(this, entidad);
        Intent i=new Intent(this,MainActivity.class);
        startActivity(i);
        finish();
    }


}

