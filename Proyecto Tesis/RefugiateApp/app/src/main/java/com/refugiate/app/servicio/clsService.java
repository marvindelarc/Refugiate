package com.refugiate.app.servicio;

/**
 * Created by Edham on 25/04/2017.
 */

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.util.Base64;

import com.refugiate.app.conexion.ServicioHTTP;
import com.refugiate.app.dao.clsCostoTipoHabitacionSQL;
import com.refugiate.app.dao.clsEmpresaSQL;
import com.refugiate.app.dao.clsInstalacionSQL;
import com.refugiate.app.dao.clsServicioSQL;
import com.refugiate.app.dao.clsSucursalSQL;
import com.refugiate.app.dao.clsTipoHabitacionSQL;
import com.refugiate.app.dao.clsUbigeoSQL;
import com.refugiate.app.entidades.clsCostoTipoHabitacion;
import com.refugiate.app.entidades.clsDistrito;
import com.refugiate.app.entidades.clsEmpresa;
import com.refugiate.app.entidades.clsInstalacion;
import com.refugiate.app.entidades.clsServicio;
import com.refugiate.app.entidades.clsSucursal;
import com.refugiate.app.entidades.clsTipoHabitacion;
import com.refugiate.app.ui.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutionException;

public class clsService extends Service{

    private Timer timer;
    private TimerTask timerTask;
    final Handler handler = new Handler();


    // The minimum time between updates in milliseconds
    private static final long MIN_TIME_BW_UPDATES = 1000*60; // 1 minute




    @Override
    public void onCreate() {
        super.onCreate();

        startTimer();

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        stoptimertask();

    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }


    public void startTimer() {
        //set a new Timer
        timer = new Timer();

        //initialize the TimerTask's job
        initializeTimerTask();

        //schedule the timer, after the first 5000ms the TimerTask will run every 10000ms
        timer.schedule(timerTask, 0,MIN_TIME_BW_UPDATES ); //
    }

    public void stoptimertask() {
        //stop the timer, if it's not already null
        if (timer != null) {
            timer.cancel();
            timer = null;
        }
    }


    public void initializeTimerTask() {

        timerTask = new TimerTask() {
            public void run() {
                handler.post(new Runnable() {
                    public void run() {
                        try {

                            ServicioHTTP servicioHTTP=new ServicioHTTP();
                            servicioHTTP.execute("null");
                            JSONObject objeto = new JSONObject(servicioHTTP.get());

                            JSONArray listEmpresaJSON = new JSONArray(objeto.getString("listEmpresaJSON"));
                            for(int i=0;i<listEmpresaJSON.length();i++){
                                JSONObject json_data = listEmpresaJSON.getJSONObject(i);
                                clsEmpresa entidad= new clsEmpresa();
                                entidad.setIdEmpresa(json_data.getInt("idEmpresa"));
                                entidad.setNombreComercial(json_data.getString("nombreComercial"));
                                entidad.setNombre(json_data.getString("nombre"));
                                entidad.setSlogan(json_data.getString("slogan"));
                                entidad.setRuc(json_data.getString("ruc"));
                                entidad.setPuntos(json_data.getInt("puntos"));
                                entidad.setEstado(json_data.getInt("estado"));
                                String Logo=json_data.getString("logo");
                                if(Logo!=null)
                                {
                                    entidad.setLogo(Base64.decode(Logo, Base64.NO_WRAP | Base64.URL_SAFE));
                                }
                                clsEmpresaSQL.Agregar(clsService.this.getApplication(),entidad);
                            }

                            //pdCargar.setTitle(getString(R.string.lbl_cargando_sucursales));

                            JSONArray listSucursalJSON = new JSONArray(objeto.getString("listSucursalJSON"));
                            for(int i=0;i<listSucursalJSON.length();i++){
                                JSONObject json_data = listSucursalJSON.getJSONObject(i);
                                clsSucursal entidad= new clsSucursal();
                                entidad.setIdSucursal(json_data.getInt("idSucursal"));
                                entidad.setDireccion(json_data.getString("direccion"));
                                entidad.setPisos(json_data.getInt("pisos"));
                                entidad.setTelefono(json_data.getString("telefono"));
                                entidad.setLongitud(json_data.getDouble("longitud"));
                                entidad.setLatitud(json_data.getDouble("latitud"));
                                entidad.setLimpieza(json_data.getInt("limpieza"));
                                entidad.setServicio(json_data.getInt("servicio"));
                                entidad.setComodidad(json_data.getInt("comodidad"));
                                entidad.setPuntuacion(json_data.getInt("puntuacion"));
                                entidad.setNivel(json_data.getInt("nivel"));
                                entidad.setEntrada(json_data.getString("entrada"));
                                entidad.setPaquete(json_data.getBoolean("paquete"));
                                entidad.setEstado(json_data.getInt("estado"));
                                entidad.setObjDistrito(new clsDistrito(json_data.getInt("idDistrito")));
                                entidad.setObjEmpresa(new clsEmpresa(json_data.getInt("idEmpresa")));
                                clsSucursalSQL.Agregar(clsService.this.getApplication(), entidad);

                            }
                            //pdCargar.setTitle(getString(R.string.lbl_cargando_servicios));
                            JSONArray listServicioJSON = new JSONArray(objeto.getString("listServicioJSON"));
                            for(int i=0;i<listServicioJSON.length();i++){
                                JSONObject json_data = listServicioJSON.getJSONObject(i);
                                clsServicio entidad= new clsServicio();
                                entidad.setIdServicio(json_data.getInt("idServicio"));
                                entidad.setNombre(json_data.getString("nombre"));
                                clsServicioSQL.Agregar(clsService.this.getApplication(), entidad);
                            }
                            //pdCargar.setTitle(getString(R.string.lbl_cargando_instalaciones));
                            JSONArray listInstalacionJSON = new JSONArray(objeto.getString("listInstalacionJSON"));
                            for(int i=0;i<listInstalacionJSON.length();i++){
                                JSONObject json_data = listInstalacionJSON.getJSONObject(i);
                                clsInstalacion entidad= new clsInstalacion();
                                entidad.setIdInstalacion(json_data.getInt("idInstalacion"));
                                entidad.setDescripcion(json_data.getString("descripcion"));
                                entidad.setObjServicio(new clsServicio(json_data.getInt("idServicio")));
                                entidad.setObjSucursal(new clsSucursal(json_data.getInt("idSucursal")));
                                clsInstalacionSQL.Agregar(clsService.this.getApplication(), entidad);
                            }
                            //pdCargar.setTitle(getString(R.string.lbl_cargando_costo_tipo_habitacion));
                            JSONArray listCostoTipoHabitacionJSON = new JSONArray(objeto.getString("listCostoTipoHabitacionJSON"));
                            for(int i=0;i<listCostoTipoHabitacionJSON.length();i++){
                                JSONObject json_data = listCostoTipoHabitacionJSON.getJSONObject(i);
                                clsCostoTipoHabitacion entidad= new clsCostoTipoHabitacion();
                                entidad.setIdCostoTipoHabitacion(json_data.getInt("idCostoTipoHabitacion"));
                                entidad.setCosto(json_data.getDouble("costo"));
                                entidad.setNumeroPersonas(json_data.getInt("numeroPersonas"));
                                entidad.setTotalHabitaciones(json_data.getInt("totalHabitaciones"));
                                entidad.setHabitacionesOcupadas(json_data.getInt("habitacionesOcupadas"));
                                entidad.setEstado(json_data.getInt("estado"));
                                entidad.setObjTipohabitacion(new clsTipoHabitacion(json_data.getInt("idTipoHabitacion")));
                                entidad.setObjSucursal(new clsSucursal(json_data.getInt("idSucursal")));
                                clsCostoTipoHabitacionSQL.Agregar(clsService.this.getApplication(), entidad);
                            }
                            //pdCargar.setTitle(getString(R.string.lbl_cargando_tipo_habitacion));
                            JSONArray listTipoHabitacionJSON = new JSONArray(objeto.getString("listTipoHabitacionJSON"));
                            for(int i=0;i<listTipoHabitacionJSON.length();i++){
                                JSONObject json_data = listTipoHabitacionJSON.getJSONObject(i);
                                clsTipoHabitacion entidad= new clsTipoHabitacion();
                                entidad.setIdTipoHabitacion(json_data.getInt("idTipoHabitacion"));
                                entidad.setNombreComercial(json_data.getString("nombreComercial"));
                                clsTipoHabitacionSQL.Agregar(clsService.this.getApplication(), entidad);
                            }

                            Notificacion();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        } catch (ExecutionException e) {
                            e.printStackTrace();
                        }catch (JSONException e) {
                            e.printStackTrace();
                        }
                        
                    }
                });
            }
        };
    }


    public void Notificacion()
    {
        String ns = Context.NOTIFICATION_SERVICE;
        NotificationManager notManager = (NotificationManager) getSystemService(ns);
        int icono = R.drawable.ic_launcherd;
        CharSequence textoEstado = "DATOS ACTUALIZADOS";
        long hora = System.currentTimeMillis();
        Notification notif = new Notification(icono, textoEstado, hora);
        Context contexto = getApplicationContext();
        CharSequence titulo =  "DATOS ACTUALIZADOS";
        CharSequence descripcion =  "SE ACTUALIZO COREECTAMENTE";
        Intent notIntent = new Intent(android.provider.Settings.ACTION_LOCATION_SOURCE_SETTINGS);
        PendingIntent contIntent = PendingIntent.getActivity(contexto, 0, notIntent, 0);
        notif.setLatestEventInfo(contexto, titulo, descripcion, contIntent);
        notif.flags |= Notification.FLAG_AUTO_CANCEL;
        notif.flags |= Notification.FLAG_ONGOING_EVENT;
        notif.defaults |= Notification.DEFAULT_SOUND;
        notManager.notify(0,notif);
    }


    public void borrarNotificacionxId(int Id)
    {
        String ns = Context.NOTIFICATION_SERVICE;
        NotificationManager notManager = (NotificationManager) getSystemService(ns);
        notManager.cancel(Id);
    }


}