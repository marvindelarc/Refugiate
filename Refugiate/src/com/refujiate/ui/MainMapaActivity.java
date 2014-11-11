/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.refujiate.ui;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.refujiate.consumo.clsConexion;
import com.refujiate.entidades.clsComentario;
import com.refujiate.entidades.clsDetalleReserva;
import com.refujiate.entidades.clsHotel;
import com.refujiate.entidades.clsPersona;
import com.refujiate.extra.clsUtilidades;
import com.refujiate.servicio.RefugiateService;
import com.refujiate.sqlite.clsComentarioSQL;
import com.refujiate.sqlite.clsDetalleReservaSQL;
import com.refujiate.sqlite.clsPersonalSQL;
import java.util.List;

/**
 *
 * @author Toditos
 */
public class MainMapaActivity extends FragmentActivity implements LocationListener {
 
    private GoogleMap googleMap;
    private  List<clsHotel> itens;
    private Location Localizacion=null;
 
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tab_ubicacion);
        // Getting Google Play availability status
        int status = GooglePlayServicesUtil.isGooglePlayServicesAvailable(getBaseContext());
 
        // Showing status
        if(status!=ConnectionResult.SUCCESS){ // Google Play Services are not available
 
            int requestCode = 10;
            Dialog dialog = GooglePlayServicesUtil.getErrorDialog(status, this, requestCode);
            dialog.show();
 
        }else { // Google Play Services are available
 
            // Getting reference to the SupportMapFragment of activity_main.xml
            SupportMapFragment fm = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
 
            // Getting GoogleMap object from the fragment
            googleMap = fm.getMap();
 
            // Enabling MyLocation Layer of Google Map
            googleMap.setMyLocationEnabled(true);

            googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(-8.105972881341886,-79.028778076171880), 12));
 
            // Getting LocationManager object from System Service LOCATION_SERVICE
            LocationManager locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
 
            // Creating a criteria object to retrieve provider
            Criteria criteria = new Criteria();
 
            // Getting the name of the best provider
            String provider = locationManager.getBestProvider(criteria, true);
 
            // Getting Current Location
            Location location = locationManager.getLastKnownLocation(provider);
 
            if(location!=null){
                onLocationChanged(location);
            }
            locationManager.requestLocationUpdates(provider, 20000, 0, this);
        }
        addMaker(0);
          Intent svc = new Intent(this, RefugiateService.class);
                    startService(svc);
    }
    @Override
    public void onLocationChanged(Location location) {
 
        Localizacion=location;
        // Getting latitude of the current location
        double latitude = location.getLatitude();
 
        // Getting longitude of the current location
        double longitude = location.getLongitude();
 
        // Creating a LatLng object for the current location
        LatLng latLng = new LatLng(latitude, longitude);
        
        // Showing the current location in Google Map
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
 
        // Zoom in the Google Map
        googleMap.animateCamera(CameraUpdateFactory.zoomTo(12)); 
    }
 
 @Override
    public void onProviderDisabled(String provider) 
    {
        // TODO Auto-generated method stub
        Toast.makeText(this, "provider disabled", Toast.LENGTH_SHORT).show();
    }
 
    @Override
    public void onProviderEnabled(String provider) 
    {
        // TODO Auto-generated method stub
        Toast.makeText(this, "provider enabled", Toast.LENGTH_SHORT).show();
    }
 
    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) 
    {
        // TODO Auto-generated method stub
        Toast.makeText(this, "status changed", Toast.LENGTH_SHORT).show();
    }
 
public void addMaker(int tipo)
{
    googleMap.clear();
    itens=clsUtilidades.getBusquedaMapa(Localizacion, tipo, this);
    if(itens!=null)
    for(clsHotel hotel:itens)
    {
        if(hotel.getInt_Tipo()==2)
        googleMap.addMarker(new MarkerOptions().icon(BitmapDescriptorFactory.fromResource(R.drawable.verde)).title(""+hotel.getStr_Nombre()).snippet(""+hotel.getInt_IdHotel()).position(new LatLng(hotel.getDou_Latitud(),hotel.getDou_Longitud())));
        else 
        googleMap.addMarker(new MarkerOptions().icon(BitmapDescriptorFactory.fromResource(R.drawable.rojo)).title(""+hotel.getStr_Nombre()).snippet(""+hotel.getInt_IdHotel()).position(new LatLng(hotel.getDou_Latitud(),hotel.getDou_Longitud())));

    }
    
    
        googleMap.setOnInfoWindowClickListener(new GoogleMap.OnInfoWindowClickListener() {
                @Override
                public void onInfoWindowClick(Marker marker) {

                   Intent i=new Intent(MainMapaActivity.this,TabsActivity.class);
                   i.putExtra("IDHOTEL",""+marker.getSnippet());
                   startActivity(i); 
                }
            });
        }
   
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
      
            MenuInflater inflater = getMenuInflater();
            inflater.inflate(R.menu.menu_mapa, menu);   
            return true;
       
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
         Intent i;
        switch (item.getItemId()) {
        case R.id.MnuOpc1:                        
            final CharSequence[] items = {"1 Kilometro", "5 Kilometros", "10 Kilometros","Todos"};     
            AlertDialog.Builder alert = new AlertDialog.Builder(this);
            alert.setTitle("Busqueda por Distancia:");
            alert.setItems(items, new DialogInterface.OnClickListener() {  
                public void onClick(DialogInterface dialog, int item) { 
                   Mostrar(item);
             }});
            alert.show();
            
            return true;
        case R.id.MnuOpc2:  
           i=new Intent(this,MainActivity.class);
           i.putExtra("idTipoHotel","0");
           i.putExtra("idServicio","0");
           i.putExtra("puntaje","0");
           i.putExtra("estrellas","0");
           startActivity(i); 
            return true;
        case R.id.MnuOpc3:
                clsPersona objPersona=clsPersonalSQL.Buscar(this);
                if(objPersona==null)
                {    
                 final Dialog dialog = new Dialog(this);
                            dialog.setContentView(R.layout.activity_inicio_sesion);
                            dialog.setTitle("Login");
                            final EditText  txtUsuario = (EditText)dialog.findViewById(R.id.txtUsuario);        
                            final EditText  txtClave = (EditText)dialog.findViewById(R.id.txtClave);

                            Button btnAceptar = (Button) dialog.findViewById(R.id.btnAceptar);
                            btnAceptar.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                            dialog.dismiss();
                                            Login(txtUsuario.getText().toString(),txtClave.getText().toString());
                                    }
                            });
                            Button btnRegistrar = (Button) dialog.findViewById(R.id.btnRegistrar);
                            btnRegistrar.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                            dialog.dismiss();
                                           Registrar();                                
                                    }
                            });
                            dialog.show();
                }  
                else
                {
                    i=new Intent(this,MenuActivity.class);
                    startActivity(i);   
                    Toast.makeText(this,objPersona.getStr_Apellido()+" ,"+objPersona.getStr_Nombre(), Toast.LENGTH_SHORT).show();
                }           
                    return true;
            
        case R.id.MnuOpc4:            
           i=new Intent(this,ConfiguracionActivity.class);
           i.putExtra("Frame",""+false);
           startActivity(i); 
            return true;
            
        case R.id.MnuOpc5:
            AlertDialog.Builder alert1 = new AlertDialog.Builder(this);
                alert1.setTitle("Desea Cerrar Sesión?");
                alert1.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {  
                       clsPersonalSQL.Borrar(MainMapaActivity.this);
                       clsDetalleReservaSQL.Borrar(MainMapaActivity.this);
                       clsComentarioSQL.Borrar(MainMapaActivity.this);
                    
                        }});
                           alert1.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {  
                               public void onClick(DialogInterface dialog, int whichButton) {    
                            }});
                       alert1.show();
           return true;       
        default:
            return super.onOptionsItemSelected(item);
        }
    }
  

    public void Mostrar(int pos)
    {
        if(pos==0)
            addMaker(1);
        else if(pos==1)
            addMaker(2);
        else if(pos==2)
            addMaker(3);
        else if(pos==3)
            addMaker(0);
        
        
    }
    
        public void Registrar()
    {
        Intent i=new Intent(this,SuscribirsePasoAActivity.class);
        startActivity(i); 
    }
          public void Login(String Usuario,String Pass){
        String data= clsConexion.readTexto("servicio/sesionLogin.jsp?usuario="+Usuario+"&pass="+Pass);
        if(!data.trim().equals("0"))
        {
        String [] entidad = data.split("\\<+col+>"); 
        clsPersona objPersona = new clsPersona();
        objPersona.setInt_IdPersona(Integer.parseInt(entidad[0].trim()));
        objPersona.setStr_Nombre(entidad[1].trim());
        objPersona.setStr_Apellido(entidad[2].trim());
        objPersona.setStr_Telefono(entidad[3].trim());
        objPersona.setStr_Email(entidad[4].trim());
        objPersona.setStr_DNI(entidad[5].trim());
        objPersona.setStr_Usuario(Usuario);
        objPersona.setStr_Password(Pass);
         if(!entidad[6].equals("0"))
        {
        String [] lista=entidad[6].trim().split("\\<+obj+>");
         for(int i=0; lista.length>i; i++)
            clsDetalleReservaSQL.Agregar(this,new clsDetalleReserva(lista[i].trim()));
        }
        if(!entidad[7].equals("0"))
        {
        String [] lista=entidad[7].trim().split("\\<+obj+>");
         for(int i=0; lista.length>i; i++)
            clsComentarioSQL.Agregar(this,new clsComentario(lista[i].trim()));
        }
        clsPersonalSQL.Agregar(this, objPersona);
                Intent i=new Intent(this,MenuActivity.class);
                startActivity(i);   
                 Toast.makeText(this,"Bienvenido "+objPersona.getStr_Apellido()+" ,"+objPersona.getStr_Nombre(), Toast.LENGTH_SHORT).show(); 
        }
           else
            Toast.makeText(this,"Error de Credenciales", Toast.LENGTH_SHORT).show(); 
   }  
          
  
@Override
public boolean onPrepareOptionsMenu(Menu menu)
{
   clsPersona objPersona=clsPersonalSQL.Buscar(this);
   if(objPersona==null)
    menu.getItem(4).setVisible(false);
   else
      menu.getItem(4).setVisible(true); 
  return super.onPrepareOptionsMenu(menu);
}              
}