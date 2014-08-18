/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.refujiate.ui;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

/**
 *
 * @author Paulo
 */
public class UbicacionTab  extends FragmentActivity {


  private GoogleMap gMap;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.tab_ubicacion);  
     Bundle bundle=getIntent().getExtras();
       double lon=Double.parseDouble(bundle.getString("LONGITUD"));
       double lat=Double.parseDouble(bundle.getString("LATITUD"));
      LatLng pos= new LatLng(lon,lat);
        
     gMap = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map)).getMap();
     gMap.addMarker(new MarkerOptions().title(bundle.getString("lblNombreTabUbicacion")).position(pos));
     gMap.moveCamera(CameraUpdateFactory.newLatLngZoom(pos, 15));
  }   
}
