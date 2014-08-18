/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.refujiate.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.refujiate.entidades.clsDetalleReserva;
import com.refujiate.sqlite.clsDetalleReservaSQL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Toditos
 */
public class ReservasPendientesActivity extends Activity {

    /**
     * Called when the activity is first created.
     */
    private List<clsDetalleReserva> listareserva;
     private AdaptadorTitulares adaptador;
     private ListView lstOpciones;
    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        // ToDo add your GUI initialization code here    
         setContentView(R.layout.activity_reservas);
          lstOpciones = (ListView)findViewById(R.id.listReservas);  
          TextView lblTitulo = (TextView)findViewById(R.id.lblTitulo);
          lblTitulo.setText("Reservas Pendientes");
          getLista();
    }
    
    public void getLista()
   {    
      listareserva=clsDetalleReservaSQL.ListarTodos(this);
      if(listareserva!=null && listareserva.size()>0)
      {
      adaptador = new AdaptadorTitulares(this);   
      
      lstOpciones.setAdapter(adaptador);
              lstOpciones.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int posicion, long id) {
//                    selecion(posicion);
                 
                
            }
        });
     
      }
  }
    
      class AdaptadorTitulares extends ArrayAdapter {

        Activity context;
        AdaptadorTitulares(Activity context) {
            super(context, R.layout.lista_reservas, listareserva);
            this.context = context;
        }
    	
        
    	public View getView(int position, View convertView, ViewGroup parent) {
			LayoutInflater inflater = context.getLayoutInflater();
			View item = inflater.inflate(R.layout.lista_reservas, null);
            
             SimpleDateFormat  fecha=new SimpleDateFormat("dd/MM/yyyy");
             
             
            TextView lblHotel = (TextView)item.findViewById(R.id.lblHotel);
            lblHotel.setText(listareserva.get(position).getNombreHotel());
            
            TextView lblDetalle = (TextView)item.findViewById(R.id.lblDetalle);
            lblDetalle.setText("N. Habitaciones: "+listareserva.get(position).getInt_NHabitaciones()+"\nT. Dias: "+listareserva.get(position).getInt_Dias()+"\nTotal: "+listareserva.get(position).getDou_Total()+"\nFecha:"+fecha.format(listareserva.get(position).getDat_Fecha()));

            TextView lblTipoHabitacion = (TextView)item.findViewById(R.id.lblTipoHabitacion);
            lblTipoHabitacion.setText("Tipo: "+listareserva.get(position).getTipoHabitacion());
            
			return(item);
		}
    }
}
