/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.refujiate.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.RatingBar;
import android.widget.Spinner;
import com.refujiate.entidades.clsInstalacion;
import com.refujiate.entidades.clsTipoHabitacion;
import com.refujiate.sqlite.clsInstalacionSQL;
import com.refujiate.sqlite.clsTipoHabitacionSQL;
import java.util.List;

/**
 *
 * @author Paulo
 */
public class BusquedaActivity extends Activity {
    private Spinner ComboTipoHabitacion;
     private Spinner ComboInstalacion;
    private List<clsTipoHabitacion> listTipoHabitacion=null;
    private List<clsInstalacion> listInstalacion=null;
    private RatingBar rtbEstrellas;
     private RatingBar rtbPuntos;
    
    private int idTipoHotel=0;
    private int idServicio=0;
    private int puntaje=0;
    private int estrellas=0;
    
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_busqueda);
        
        ComboTipoHabitacion = (Spinner)findViewById(R.id.ComboTipoHabitacion);
        ComboInstalacion = (Spinner)findViewById(R.id.ComboInstalacion);
        rtbEstrellas = (RatingBar) findViewById(R.id.rtbEstrellas);
        rtbPuntos = (RatingBar) findViewById(R.id.rtbPuntos);
        
        setTipoHabitacion();
        setInstalacion();
    }
    
   
     private void setTipoHabitacion()
    {
            listTipoHabitacion=clsTipoHabitacionSQL.ListarTodos(this);      

            ArrayAdapter<clsTipoHabitacion> adapter = new ArrayAdapter<clsTipoHabitacion>(this,android.R.layout.simple_spinner_item,listTipoHabitacion);       
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
            ComboTipoHabitacion.setAdapter(adapter);     
            ComboTipoHabitacion.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {          
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
               idTipoHotel=listTipoHabitacion.get(position).getInt_idHabitacion();
//
            }
            public void onNothingSelected(AdapterView<?> parent) {
                //User selected same item. Nothing to do.
            }
        });
    }
     
     
       private void setInstalacion()
    {
            listInstalacion=clsInstalacionSQL.ListarTodos(this);      

            ArrayAdapter<clsInstalacion> adapter = new ArrayAdapter<clsInstalacion>(this,android.R.layout.simple_spinner_item,listInstalacion);       
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
            ComboInstalacion.setAdapter(adapter);     
            ComboInstalacion.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {          
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
               idServicio=listInstalacion.get(position).getInt_IdServicio();
//
            }
            public void onNothingSelected(AdapterView<?> parent) {
                //User selected same item. Nothing to do.
            }
        });
    }
      
         public void btnBuscar(View e)
    {
        estrellas=(int)rtbEstrellas.getRating();
        puntaje=(int)rtbPuntos.getRating();
        
        Intent i=new Intent(this,MainActivity.class);
         i.putExtra("idTipoHotel",""+idTipoHotel);
         i.putExtra("idServicio",""+idServicio);
         i.putExtra("puntaje",""+puntaje);
         i.putExtra("estrellas",""+estrellas);
        startActivity(i); 
        
        
        
    }
}
