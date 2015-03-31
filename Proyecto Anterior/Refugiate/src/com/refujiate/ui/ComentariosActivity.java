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
import com.refujiate.entidades.clsComentario;
import com.refujiate.sqlite.clsComentarioSQL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Toditos
 */
public class ComentariosActivity extends Activity {

    /**
     * Called when the activity is first created.
     */
    private List<clsComentario> itens;
     private AdaptadorTitulares adaptador;
     private ListView lstOpciones;
    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        // ToDo add your GUI initialization code here    
         setContentView(R.layout.activity_reservas);
          lstOpciones = (ListView)findViewById(R.id.listReservas);  
          TextView lblTitulo = (TextView)findViewById(R.id.lblTitulo);
          lblTitulo.setText("Mis Comentarios");
          getLista();
    }
    
    public void getLista()
   {    
      itens=clsComentarioSQL.Listar(this);
      if(itens!=null && itens.size()>0)
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
            super(context, R.layout.lista_comentarios, itens);
            this.context = context;
        }
    	
        
    	public View getView(int position, View convertView, ViewGroup parent) {
                LayoutInflater inflater = context.getLayoutInflater();
                View item = inflater.inflate(R.layout.lista_comentarios, null);

                SimpleDateFormat  fecha=new SimpleDateFormat("dd/MM/yyyy");
                SimpleDateFormat hora=new SimpleDateFormat("h:mm a");
                TextView lblUsuarioTabComentario = (TextView)item.findViewById(R.id.lblUsuarioTabComentario);
                lblUsuarioTabComentario.setText(hora.format(itens.get(position).getDat_Fecha())+" - "+fecha.format(itens.get(position).getDat_Fecha()));

                TextView lblComentarioTabComentario = (TextView)item.findViewById(R.id.lblComentarioTabComentario);
                lblComentarioTabComentario.setText("Hotel:"+itens.get(position).getStr_Usuario()+"\nComentario:"+itens.get(position).getStr_Descripcion());

                return(item);
		}
    }
}
