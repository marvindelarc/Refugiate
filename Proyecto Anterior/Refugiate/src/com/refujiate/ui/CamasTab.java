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
import android.widget.Toast;
import com.refujiate.entidades.clsTipoHabitacion;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Paulo
 */
public class CamasTab extends Activity {
private int IdHotel=0;
private ListView lstOpciones;
private AdaptadorTitulares adaptador;
private  List<clsTipoHabitacion> itens;
private String listaHabitaciones="";

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tab_camas);
        Bundle bundle=getIntent().getExtras();
        IdHotel=Integer.valueOf(bundle.getString("IDHOTEL"));
        listaHabitaciones=bundle.getString("listaHabitaciones");
        
        lstOpciones = (ListView)findViewById(R.id.listHabitaciones);  
        if(!listaHabitaciones.equals("0"))
         addLista();
//         Toast.makeText(this,listaHabitaciones, Toast.LENGTH_SHORT).show();  
    }
    
    
    private void addLista()
    {
        itens=new  ArrayList<clsTipoHabitacion>();      
        String [] entidad = listaHabitaciones.split("\\<+obj+>"); 
        
        for(int i=0; entidad.length>i; i++)
        {
            String [] atributo = entidad[i].split("\\<+cls+>"); 
            itens.add(new clsTipoHabitacion(Integer.parseInt(atributo[0]),atributo[1],Double.parseDouble(atributo[2]),Integer.parseInt(atributo[3])));
            
        }
          
        adaptador = new AdaptadorTitulares(this);
        lstOpciones.setAdapter(adaptador);
        
    }
    
    class AdaptadorTitulares extends ArrayAdapter {

        Activity context;
        AdaptadorTitulares(Activity context) {
            super(context, R.layout.lista_habitaciones, itens);
            this.context = context;
        }
    	
        
    	public View getView(int position, View convertView, ViewGroup parent) {
			LayoutInflater inflater = context.getLayoutInflater();
			View item = inflater.inflate(R.layout.lista_habitaciones, null);
            
            TextView lblCostoTabCama = (TextView)item.findViewById(R.id.lblCostoTabCama);
            lblCostoTabCama.setText("Costo: S/."+itens.get(position).getDou_Costo());
            
            TextView lblDescripcionTabCama = (TextView)item.findViewById(R.id.lblDescripcionTabCama);
            lblDescripcionTabCama.setText("Disponibles: "+itens.get(position).getInt_Disponibles());
            
            TextView lblNombreTipoTabCamas = (TextView)item.findViewById(R.id.lblNombreTipoTabCamas);
            lblNombreTipoTabCamas.setText("Tipo :"+itens.get(position).getStr_Nombre());
            
			return(item);
		}
    }
    
}
