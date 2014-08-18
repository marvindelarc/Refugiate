/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.refujiate.ui;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import com.refujiate.entidades.clsDetalleReserva;
import com.refujiate.entidades.clsTipoHabitacion;
import com.refujiate.consumo.clsConexion;
import com.refujiate.entidades.clsHotel;
import com.refujiate.sqlite.clsDetalleReservaSQL;
import com.refujiate.sqlite.clsHotelSQL;
import com.refujiate.sqlite.clsPersonalSQL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Paulo
 */
public class ReservarActivity extends Activity {

    /**
     * Called when the activity is first created.
     */
        private ProgressDialog pd ;
    private List<clsDetalleReserva> listareserva=new ArrayList<clsDetalleReserva>();
    private  List<clsTipoHabitacion> itens;
    private ListView lstOpciones;
    private AdaptadorTitulares adaptador;
    private String listaHabitaciones="";
    private TextView lblFechaRserva; 
    private TextView lblHabitacionDisponibles; 
    private TextView lblCostoHabitacion;   
    private TextView lblNHabitacionesRserva; 
    private TextView lblTotal;
    private TextView lblHotel;    
    private Spinner ComboTipoServicio=null;
    private TextView lblNDiasRserva; 
    private clsTipoHabitacion tipoHabitacion=null;
    private clsHotel objHotel;
    private int dias=0;
    private int habitaciones=0;
    private int mYear1;    
    private int mMonth1;    
    private int mDay1;   
    private int idSucursal=0;
    private double Total=0;
      static final int DATE_DIALOG_ID1 = 1;
        private Calendar calendar1 = Calendar.getInstance();
        
           private DatePickerDialog.OnDateSetListener mDateSetListener =            
    	new DatePickerDialog.OnDateSetListener() {     
            
            
    	public void onDateSet(DatePicker view, int year,                                       
    			int monthOfYear, int dayOfMonth) {     
                        
                        mYear1 = year;                    
                        mMonth1 = monthOfYear;                    
                        mDay1 = dayOfMonth;   
                     
                            
    		updateDisplay();                
    		}            
    	};
           
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reserva_habitacion);
        Bundle bundle=getIntent().getExtras();
        listaHabitaciones=bundle.getString("listaHabitaciones");
        idSucursal=Integer.parseInt(bundle.getString("ID"));
        objHotel=clsHotelSQL.Buscar(this, idSucursal);
        lblFechaRserva = (TextView) findViewById(R.id.lblFechaRserva);  
        lblNDiasRserva = (TextView) findViewById(R.id.lblNDiasRserva);  
        lblHotel = (TextView) findViewById(R.id.lblHotel); 
        lblCostoHabitacion = (TextView) findViewById(R.id.lblCostoHabitacion);  
        lblNHabitacionesRserva = (TextView) findViewById(R.id.lblNHabitacionesRserva);  
        lblTotal = (TextView) findViewById(R.id.lblTotal);  
        ComboTipoServicio = (Spinner)findViewById(R.id.ComboTipoServicio);
        lblHabitacionDisponibles = (TextView) findViewById(R.id.lblHabitacionDisponibles); 
        
         lstOpciones = (ListView)findViewById(R.id.listReserva);  
        if(objHotel!=null)
            lblHotel.setText(objHotel.getStr_Nombre());
        Fecha();   
        
        if(!listaHabitaciones.equals("0"))
         addDLL();
    }
    
    public void Fecha()
    {
         final Calendar c = Calendar.getInstance();        
    	mYear1 = c.get(Calendar.YEAR);        
    	mMonth1 = c.get(Calendar.MONTH);        
    	mDay1 = c.get(Calendar.DAY_OF_MONTH);  
        updateDisplay();   
    }
      private void addDLL()
    {
        itens=new  ArrayList<clsTipoHabitacion>();      
        String [] entidad = listaHabitaciones.split("\\<+obj+>"); 
        
        for(int i=0; entidad.length>i; i++)
        {
            String [] atributo = entidad[i].split("\\<+cls+>"); 
            int diponible=Integer.parseInt(atributo[3]);
            if(diponible>0)
            itens.add(new clsTipoHabitacion(Integer.parseInt(atributo[0]),atributo[1],Double.parseDouble(atributo[2]),diponible));            
        }
        
            ArrayAdapter<clsTipoHabitacion> adapter = new ArrayAdapter<clsTipoHabitacion>(this,android.R.layout.simple_spinner_item,itens);       
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
            ComboTipoServicio.setAdapter(adapter);     
            ComboTipoServicio.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {          
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
               tipoHabitacion=itens.get(position);
               lblCostoHabitacion.setText("Costo de Habitación: S/."+tipoHabitacion.getDou_Costo());
               lblHabitacionDisponibles.setText("Habitaciones Disponibles: "+tipoHabitacion.getInt_Disponibles());
               habitaciones=0;
               lblNHabitacionesRserva.setText(""+habitaciones);
            }
            public void onNothingSelected(AdapterView<?> parent) {
                //User selected same item. Nothing to do.
            }
        });

        ComboTipoServicio.setSelection(0);
    }
      

      
      private void updateDisplay() {   
        


          calendar1.set(mYear1, mMonth1, mDay1);
    	 lblFechaRserva.setText(new StringBuilder().append(mDay1).append("-") .append(mMonth1+ 1).append("-").append(mYear1).append(" "));


    }  
      
         @Override
    protected Dialog onCreateDialog(int id) {    
    	switch (id) {   
    		case DATE_DIALOG_ID1:        
    			return new DatePickerDialog(this,                    
    					mDateSetListener,                    
    					mYear1, mMonth1, mDay1);      
                
    			}    
    	return null;
    	}
    
         
         public void btn_Calendairio(View v)
         {
             showDialog(DATE_DIALOG_ID1);       
         }
         
          public void btn_MansHabitaciones(View v)
         {
                if(habitaciones<tipoHabitacion.getInt_Disponibles())
               habitaciones++;
                  lblNHabitacionesRserva.setText(""+habitaciones);
             
         }
          
           public void btn_MenosHabitaciones(View v)
         {
             if(habitaciones>0)
                 habitaciones--;
               lblNHabitacionesRserva.setText(""+habitaciones);
               
         }
           
            public void btn_MasDias(View v)
         {
           
              dias++;
              lblNDiasRserva.setText(""+dias);
      
         }
             public void btn_MenosDias(View v)
         {
              if(dias>0)
                 dias--;
               lblNDiasRserva.setText(""+dias);
             
         }

    
     
     
    class AdaptadorTitulares extends ArrayAdapter {

        Activity context;
        AdaptadorTitulares(Activity context) {
            super(context, R.layout.lista_habitaciones, listareserva);
            this.context = context;
        }
    	
        
    	public View getView(int position, View convertView, ViewGroup parent) {
			LayoutInflater inflater = context.getLayoutInflater();
			View item = inflater.inflate(R.layout.lista_habitaciones, null);
            
             SimpleDateFormat  fecha=new SimpleDateFormat("dd/MM/yyyy");
             
             
            TextView lblCostoTabCama = (TextView)item.findViewById(R.id.lblCostoTabCama);
            lblCostoTabCama.setText("Total: "+listareserva.get(position).getDou_Total()+"\nFecha:"+fecha.format(listareserva.get(position).getDat_Fecha()));
            
            TextView lblDescripcionTabCama = (TextView)item.findViewById(R.id.lblDescripcionTabCama);
            lblDescripcionTabCama.setText("N. Habitaciones: "+listareserva.get(position).getInt_NHabitaciones()+"\nT. Dias: "+listareserva.get(position).getInt_Dias());

            TextView lblNombreTipoTabCamas = (TextView)item.findViewById(R.id.lblNombreTipoTabCamas);
            lblNombreTipoTabCamas.setText("Tipo: "+listareserva.get(position).getTipoHabitacion());
            
			return(item);
		}
    }
    
    public void btnCancelar(View v )
    {
        final Context context=this;
                AlertDialog.Builder alert = new AlertDialog.Builder(this);
                alert.setTitle("Desea Cancelar Reserva?");
                alert.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {  
                        Intent i=new Intent(context,MainMapaActivity.class);
                        
                        startActivity(i);   
                        finish();
                        }});
                           alert.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {  
                               public void onClick(DialogInterface dialog, int whichButton) {    
                            }});
                       alert.show();
             
        
    }
    
    public void btnReservar(View v )
    {
            if(listareserva.size()>0)
        {
        
        pd = new ProgressDialog(this);
        pd.setTitle("Cargando ...");
        pd.setMessage("Espere un momento");     
        pd.show();        
        final Context context=this;
        new Thread() { 
            public void run() { 
         String IdRegistro= clsConexion.readTexto("servicio/registroReserva.jsp?IdPersona="+clsPersonalSQL.Buscar(context).getInt_IdPersona()+"&IdSucursal="+idSucursal);
            if(!IdRegistro.trim().equals("0"))
            {
               int idRegistro=Integer.parseInt(IdRegistro);
               for(clsDetalleReserva entidad: listareserva)
               {
                   entidad.setInt_IdReserva(idRegistro);
                   String idDetalle=clsConexion.postRegistraDetalle(entidad);
                   if(!idDetalle.trim().equals("0"))
                   {    
                   entidad.setInt_IdDetalleReserva(Integer.parseInt(idDetalle));
                   entidad.setNombreHotel(objHotel.getStr_Nombre());
                   entidad.setInt_IdPuntuacion(0);
                   entidad.setInt_IdComentario(0);
                   clsDetalleReservaSQL.Agregar(context, entidad);
                   }
               }
                  handler.sendEmptyMessage(0);      
              }
            } 
            
       }.start(); 


               

       }
        else
             Toast.makeText(this,"Agregue al menos una reserva", Toast.LENGTH_SHORT).show(); 
         
    }
        final Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            //update UI here depending on what message is received.
            super.handleMessage(msg);
            pd.dismiss();                   
            Inicio();
        }
    };

        public void Inicio()
    {
         Intent i=new Intent(this,MainMapaActivity.class);
              startActivity(i);   
              finish();
    }
    public void btnAddHabitaciones(View v )
    {
        if(habitaciones>0 && dias>0)
        {
        
        boolean estado=true;
        Date fecha=calendar1.getTime();
        fecha.setHours(0);
        fecha.setMinutes(0);
        fecha.setSeconds(0);
        clsDetalleReserva reserva = new clsDetalleReserva();
        reserva.setInt_IdCostoTipoHabitacion(tipoHabitacion.getInt_idTipoHabitacion());
        reserva.setInt_Dias(dias);
        reserva.setDat_Fecha(fecha);
        reserva.setInt_NHabitaciones(habitaciones);
        reserva.setDou_Total(dias*tipoHabitacion.getDou_Costo()*habitaciones);   
        reserva.setTipoHabitacion(tipoHabitacion.getStr_Nombre());
        
        for(int i=0; i<listareserva.size();i++)
        {
            if(listareserva.get(i).getInt_IdCostoTipoHabitacion()==reserva.getInt_IdCostoTipoHabitacion() && 
                    listareserva.get(i).getDat_Fecha().getTime()==reserva.getDat_Fecha().getTime())
            {
              Total+=-listareserva.get(i).getDou_Total();
              estado=false;  
              listareserva.remove(i);
               Total+=reserva.getDou_Total();
              listareserva.add(reserva);
            }
        } 
            
        if(estado)
        {
        listareserva.add(reserva);
        Total+=reserva.getDou_Total();
        }
        lblTotal.setText("Total Reserva: S/."+Total);
        adaptador = new AdaptadorTitulares(this);
        lstOpciones.setAdapter(adaptador);
        
        
         habitaciones=0;
         lblNHabitacionesRserva.setText(""+0);
         
           dias=0;
          lblNDiasRserva.setText(""+0);
          Fecha();
      
        }
        else
             Toast.makeText(this,"Indique el Numero de Díaz y Numero de Habitaciones", Toast.LENGTH_SHORT).show(); 
        
    }
    
     @Override
    public boolean onKeyDown(int keyCode, KeyEvent event)
    {
   
    
    return false;

    } 
    
}
