/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.refujiate.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.refujiate.entidades.clsTipoHabitacion;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Paulo
 */
public class HistorialActivity extends Activity {

private ListView lstOpciones;
private AdaptadorTitulares adaptador;
private  List<clsTipoHabitacion> itens;
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tab_comentarios);
        
        lstOpciones = (ListView)findViewById(R.id.listComentarios);  
        itens=new  ArrayList<clsTipoHabitacion>();     
        itens.add(new clsTipoHabitacion(1,"Reserva 01: De La Cruz \n Total S/.520\n Hotel> Libertador",7) );
        itens.add(new clsTipoHabitacion(1,"Reserva 02: De La Cruz \n Total S/.320\n Hotel> Libertador",7) );
        itens.add(new clsTipoHabitacion(1,"Reserva 03: De La Cruz \n Total S/.240\n Hotel> Libertador",7) );
        itens.add(new clsTipoHabitacion(1,"Reserva 04: De La Cruz \n Total S/.170\n Hotel> Libertador",7) );
        itens.add(new clsTipoHabitacion(1,"Reserva 05: De La Cruz \n Total S/.460\n Hotel> Libertador",7) );
        itens.add(new clsTipoHabitacion(1,"Reserva 06: De La Cruz \n Total S/.520\n Hotel> Libertador",7) );
        itens.add(new clsTipoHabitacion(1,"Reserva 07: De La Cruz \n Total S/.450\n Hotel> Libertador",7) );
        itens.add(new clsTipoHabitacion(1,"Reserva 08: De La Cruz \n Total S/.710\n Hotel> Libertador",7) );
        itens.add(new clsTipoHabitacion(1,"Reserva 09: De La Cruz \n Total S/.130\n Hotel> Libertador",7) );
        itens.add(new clsTipoHabitacion(1,"Reserva 10: De La Cruz \n Total S/.340\n Hotel> Libertador",7) );
        itens.add(new clsTipoHabitacion(1,"Reserva 11: De La Cruz \n Total S/.980\n Hotel> Libertador",7) );
        itens.add(new clsTipoHabitacion(1,"Reserva 12: De La Cruz \n Total S/.570\n Hotel> Libertador",7) );
        adaptador = new AdaptadorTitulares(this);
        lstOpciones.setAdapter(adaptador);
         
        
    }
    
    
    class AdaptadorTitulares extends ArrayAdapter {

        Activity context;
        AdaptadorTitulares(Activity context) {
            super(context, R.layout.lista_comentarios, itens);
            this.context = context;
        }
    	
        
    	public View getView(int position, View convertView, ViewGroup parent) {
			LayoutInflater inflater = context.getLayoutInflater();
			View item = inflater.inflate(R.layout.lista_comentarios, null);
            

           
//            TextView lblUsuarioTabComentario = (TextView)item.findViewById(R.id.lblUsuarioTabComentario);
//            lblUsuarioTabComentario.setText("Descripcion: "+itens.get(position).getDescrpcion());
            
            TextView lblComentarioTabComentario = (TextView)item.findViewById(R.id.lblComentarioTabComentario);
            lblComentarioTabComentario.setText("Tipo :"+itens.get(position).getStr_Nombre());
            
			return(item);
		}
    }
    
}
