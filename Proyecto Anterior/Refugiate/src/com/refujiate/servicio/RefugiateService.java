package com.refujiate.servicio;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import java.util.Timer;
import java.util.TimerTask;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.refujiate.consumo.clsDatos;
import com.refujiate.entidades.clsConfiguracion;
import com.refujiate.entidades.clsDetalleReserva;
import com.refujiate.sqlite.clsConfiguracionSQL;
import com.refujiate.sqlite.clsDetalleReservaSQL;
import com.refujiate.ui.MainMapaActivity;
import com.refujiate.ui.PropagandaActivity;
import com.refujiate.ui.R;
import com.refujiate.ui.ReservasPendientesActivity;
import java.util.Date;

public class RefugiateService extends Service {

	private Timer timer = new Timer();
	private static final long UPDATE_INTERVAL = 1000*60;// timer avanza cada hora
	
	private int count = 0;
	private boolean repetir=true;
        private clsConfiguracion objConfiguracion=null;
	
        private clsDetalleReserva objRserva;
	@Override
	public IBinder onBind(Intent arg0) {
		return null;
	}
	
	@Override
	public void onCreate() {
            super.onCreate();         
            objConfiguracion=clsConfiguracionSQL.Buscar(this.getApplicationContext());            
            if(objConfiguracion!=null)
            {
                   _startService();
            }
                      else
                onDestroy();
	}

	@Override
	public void onDestroy() {
		super.onDestroy();               
		_shutdownService();           
	}
	
	private void _startService() {
           
		timer.scheduleAtFixedRate(
			new TimerTask() {
				public void run() {
					
                                      if(count%objConfiguracion.getInt_tiempo_actulizacion()==0)
                                      {
                                           Actualizar();
                                           Notificacion("Refugiate Informa","Quieres saber has click aqui!!!",2);
                                           
                                      }
                                      
                                      objRserva = clsDetalleReservaSQL.getReservaXFecha(RefugiateService.this.getApplicationContext());
                                      if(objRserva!=null)
                                      if(GetTiempo()<=objConfiguracion.getInt_tiempo_previo_reserva())
                                      {
                                         
                                          if(repetir)
                                          {
                                              Notificacion("Reserva pendiente","Tiene una reseva pendiente \n en el hotel: "+objRserva.getNombreHotel(),1);
                                           
                                              repetir=false;
                                          }
                                          if(objConfiguracion.getInt_repetir()==1)
                                          {
                                              if(count%objConfiguracion.getInt_repetir_tiempo()==0)
                                              {
                                                  Notificacion("Reserva pendiente","Tiene una reseva pendiente \n en el hotel: "+objRserva.getNombreHotel(),1);
                                           
                                              }
                                              
                                          }
                                      }
                                      else
                                          borrarNotificacion();
                                      
                                      count++;
				}
			},
			0,
			UPDATE_INTERVAL);         
                

	}
	
	private void _shutdownService() {            
		if (timer != null) timer.cancel();
                borrarNotificacion();
	}
	
public void borrarNotificacion()
 {
     String ns = Context.NOTIFICATION_SERVICE;
				NotificationManager notManager = 
				(NotificationManager) getSystemService(ns);
                                notManager.cancelAll();
 }

public void Notificacion(String Titulo,String Motivo,int Id)
{
    String ns = Context.NOTIFICATION_SERVICE;
    NotificationManager notManager = 
        (NotificationManager) getSystemService(ns);

    int icono = R.drawable.icono_servicio;
    CharSequence textoEstado = Titulo;
    long hora = System.currentTimeMillis();

    Notification notif = 
        new Notification(icono, textoEstado, hora);

    Context contexto = getApplicationContext();
    CharSequence titulo = Titulo;
    CharSequence descripcion = Motivo;

    Intent notIntent = new Intent(contexto, 
                PropagandaActivity.class);

    if(Id==1)
    notIntent = new Intent(contexto, ReservasPendientesActivity.class);
    else if(Id==3)
    notIntent = new Intent(contexto, MainMapaActivity.class);
    
    
    PendingIntent contIntent = PendingIntent.getActivity(
                contexto, 0, notIntent, 0);

    notif.setLatestEventInfo(
                contexto, titulo, descripcion, contIntent);

    notif.flags |= Notification.FLAG_AUTO_CANCEL;
    notif.flags |= Notification.FLAG_ONGOING_EVENT;
    notif.defaults |= Notification.DEFAULT_SOUND;


    notManager.notify(Id, notif);
//                                        
}


         public void Actualizar()
        {
         
                    clsDatos.setListaHoteles(this.getApplicationContext());
                     clsDatos.setListaTipoHabitacion(this.getApplicationContext());
                     clsDatos.setListaInstalacion(this.getApplicationContext());
                      Notificacion("Sincronización","Datos sincronizados!!!",3);
                                          
        }
         
         
  public int GetTiempo()
  {
      
      
      long milisC = objRserva.getDat_Fecha().getTime(); 
      long milisA = new Date().getTime(); 
      
       long diff = milisA - milisC;
       

//       long diffHours = diff / (60 * 60 * 1000);
    
           
       long diffDays = diff / (24 * 60 * 60 * 1000);
       
     
       return (int)diffDays;

  }
        
}
