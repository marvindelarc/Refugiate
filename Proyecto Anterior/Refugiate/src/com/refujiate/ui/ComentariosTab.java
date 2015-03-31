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
import com.refujiate.entidades.clsComentario;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Paulo
 */
public class ComentariosTab extends Activity {
private int IdHotel=0;
private ListView lstOpciones;
private AdaptadorTitulares adaptador;
private  List<clsComentario> itens;
private String listaComentario="";

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
        listaComentario=bundle.getString("listaComentario");
        
        lstOpciones = (ListView)findViewById(R.id.listHabitaciones);  
        if(!listaComentario.equals("0"))
         addLista();
//         Toast.makeText(this,listaHabitaciones, Toast.LENGTH_SHORT).show();  
    }
    
    
    private void addLista()
    {
        itens=new  ArrayList<clsComentario>();      
        String [] entidad = listaComentario.split("\\<+obj+>"); 
        
        for(int i=0; entidad.length>i; i++)
        {
            String [] atributo = entidad[i].split("\\<+cls+>"); 
            itens.add(new clsComentario(atributo[2],atributo[3]));
            
        }
          
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
            
            TextView lblUsuarioTabComentario = (TextView)item.findViewById(R.id.lblUsuarioTabComentario);
            lblUsuarioTabComentario.setText(itens.get(position).getStr_Usuario());
            
            TextView lblComentarioTabComentario = (TextView)item.findViewById(R.id.lblComentarioTabComentario);
            lblComentarioTabComentario.setText(itens.get(position).getStr_Descripcion());
            
			return(item);
		}
    }
    
}
