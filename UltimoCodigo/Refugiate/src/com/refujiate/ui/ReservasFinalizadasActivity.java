/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.refujiate.ui;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.TextView;
import com.refujiate.consumo.clsConexion;
import com.refujiate.entidades.clsComentario;
import com.refujiate.entidades.clsDetalleReserva;
import com.refujiate.sqlite.clsComentarioSQL;
import com.refujiate.sqlite.clsDetalleReservaSQL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Toditos
 */
public class ReservasFinalizadasActivity extends Activity {

    /**
     * Called when the activity is first created.
     */
    private List<clsDetalleReserva> listareserva;
     private AdaptadorTitulares adaptador;
     private ListView lstOpciones;
      private ProgressDialog pd ;
    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        // ToDo add your GUI initialization code here    
         setContentView(R.layout.activity_reservas);
          lstOpciones = (ListView)findViewById(R.id.listReservas);  
          TextView lblTitulo = (TextView)findViewById(R.id.lblTitulo);
          lblTitulo.setText("Reservas Finalizadas");
          getLista();
    }
    
    public void getLista()
   {    
      listareserva=clsDetalleReservaSQL.ListarFinalizadas(this);
      if(listareserva!=null && listareserva.size()>0)
      {
      adaptador = new AdaptadorTitulares(this);   
      
      lstOpciones.setAdapter(adaptador);
              lstOpciones.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int posicion, long id) {
                    getSeleccion(posicion);
                 
                
            }
        });
     
      }
  }
    public void getSeleccion(int posicion)
    {
         final int pos = posicion;
        if(listareserva.get(posicion).getInt_IdComentario()==0 && listareserva.get(posicion).getInt_IdPuntuacion()==0)
        {
                final CharSequence[] items = {"Comentario", "Calificación", "Cancelar"};     
                AlertDialog.Builder alert = new AlertDialog.Builder(this);
                alert.setTitle("Agregar ");
                alert.setItems(items, new DialogInterface.OnClickListener() {  
                public void onClick(DialogInterface dialog, int item) { 
                    if(item==0)
                        setComenta(pos);
                    else if(item==1)
                        setCalifcar(pos);
                }});
                alert.show();
                }
        else  if(listareserva.get(posicion).getInt_IdComentario()==0 )
        {
               
                final CharSequence[] items = {"Comentario", "Cancelar"};     
                AlertDialog.Builder alert = new AlertDialog.Builder(this);
                alert.setTitle("Agregar");
                alert.setItems(items, new DialogInterface.OnClickListener() {  
                public void onClick(DialogInterface dialog, int item) { 
                     if(item==0)
                        setComenta(pos);
                }});
                alert.show();
        }
        else if(listareserva.get(posicion).getInt_IdPuntuacion()==0)
        {
                final CharSequence[] items = {"Calificación", "Cancelar"};    
                AlertDialog.Builder alert = new AlertDialog.Builder(this);
                alert.setTitle("Agregar");
                alert.setItems(items, new DialogInterface.OnClickListener() {  
                public void onClick(DialogInterface dialog, int item) { 
                    if(item==0)
                        setCalifcar(pos);
                }});
                alert.show();
        }
    }
    
    
    
    public void setCalifcar(int posicion)
    {
         final int pos = posicion;
         final Dialog dialog = new Dialog(this);
                    dialog.setContentView(R.layout.califica_servicio);
                    dialog.setTitle("Calificar Servicio al Hotel "+listareserva.get(posicion).getNombreHotel());
                    final RatingBar ratingBarLimpieza = (RatingBar) dialog.findViewById(R.id.ratingBarLimpieza);  
                    final RatingBar ratingBarServicio = (RatingBar) dialog.findViewById(R.id.ratingBarServicio);  
                    final RatingBar ratingBarComodidad = (RatingBar) dialog.findViewById(R.id.ratingBarComodidad);                     
                    
//
                    Button btnAceptar = (Button) dialog.findViewById(R.id.btnAceptar);
                    btnAceptar.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                    dialog.dismiss();
                                    RegistraCalificacion(pos,(int)ratingBarLimpieza.getRating(),(int)ratingBarServicio.getRating(),(int)ratingBarComodidad.getRating());
                            }
                    });
                    Button btnCancelar = (Button) dialog.findViewById(R.id.btnCancelar);
                    btnCancelar.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                    dialog.dismiss();                              
                            }
                    });
                    dialog.show();
    }
        public void setComenta(int posicion)
    {
         final int pos = posicion;
         final Dialog dialog = new Dialog(this);
                    dialog.setContentView(R.layout.agregar_comentario);
                    dialog.setTitle("Agregar Comentario al Hotel "+listareserva.get(posicion).getNombreHotel());
                    final EditText txtComentario = (EditText) dialog.findViewById(R.id.txtComentario);                
                    
//
                    Button btnAceptar = (Button) dialog.findViewById(R.id.btnAceptar);
                    btnAceptar.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                    dialog.dismiss();
                                    RegistraComentario(pos,txtComentario.getText().toString());
                            }
                    });
                    Button btnCancelar = (Button) dialog.findViewById(R.id.btnCancelar);
                    btnCancelar.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                    dialog.dismiss();                              
                            }
                    });
                    dialog.show();
    }
    
     final Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            //update UI here depending on what message is received.
            super.handleMessage(msg);
            pd.dismiss();                   
            getLista();
        }
    };    
        
      public void RegistraComentario(int posicion,String comentario)
      {
        pd = new ProgressDialog(this);
        pd.setTitle("Resgitrando Comentario ...");
        pd.setMessage("Espere un momento");     
        pd.show();  
        final int pos = posicion;
        final String coment=comentario;
        final Context context=this;
        new Thread() { 
            public void run() { 
            
                clsComentario entidad=new clsComentario();
                entidad.setInt_IdReserva(listareserva.get(pos).getInt_IdReserva());
                entidad.setStr_Descripcion(coment);
                entidad.setDat_Fecha(new Date());
                entidad.setStr_Usuario(listareserva.get(pos).getNombreHotel());
                String IdComentario= clsConexion.postRegistraComentario(entidad);
                if(!IdComentario.trim().equals("0"))
            {
                  int idComentario=Integer.parseInt(IdComentario);
                  
                  entidad.setInt_IdComentario(idComentario);
                  clsComentarioSQL.Agregar(context, entidad);
                  clsDetalleReservaSQL.ActualizarComentario(context, listareserva.get(pos).getInt_IdReserva(), idComentario);
                  handler.sendEmptyMessage(0);      
              }

            } 
            
       }.start(); 
      }   
      
       public void RegistraCalificacion(int posicion,int limpieza,int servicio,int comodidad)
      {
        pd = new ProgressDialog(this);
        pd.setTitle("Registrando Calificación ...");
        pd.setMessage("Espere un momento");     
        pd.show();  
        final int pos = posicion;
        final int limp = limpieza;
        final int serv = servicio;
        final int comod = comodidad;
        final Context context=this;
        new Thread() { 
            public void run() { 
            

                String IdCalificacion= clsConexion.readTexto("servicio/registroPuntuacion.jsp?IdReserva="+listareserva.get(pos).getInt_IdReserva()+"&limpieza="+limp+"&servicio="+serv+"&comodidad="+comod);
                if(!IdCalificacion.trim().equals("0"))
            {
                  int idCalificacion=Integer.parseInt(IdCalificacion);
                  
                  clsDetalleReservaSQL.ActualizarPuntuacion(context, listareserva.get(pos).getInt_IdReserva(), idCalificacion);
                  handler.sendEmptyMessage(0);      
              }

            } 
            
       }.start(); 
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

                View vista =(View)item.findViewById(R.id.Vista);

                TextView lblHotel = (TextView)item.findViewById(R.id.lblHotel);
                lblHotel.setText(listareserva.get(position).getNombreHotel());

                TextView lblDetalle = (TextView)item.findViewById(R.id.lblDetalle);
                lblDetalle.setText("N. Habitaciones: "+listareserva.get(position).getInt_NHabitaciones()+"\nFecha:"+fecha.format(listareserva.get(position).getDat_Fecha()));

                TextView lblTipoHabitacion = (TextView)item.findViewById(R.id.lblTipoHabitacion);
                lblTipoHabitacion.setText("Costo: "+listareserva.get(position).getDou_Total());
                if(listareserva.get(position).getInt_IdComentario()==0 || listareserva.get(position).getInt_IdPuntuacion()==0)
                vista.setBackgroundColor(Color.CYAN);

                return(item);
		}
    }
}
