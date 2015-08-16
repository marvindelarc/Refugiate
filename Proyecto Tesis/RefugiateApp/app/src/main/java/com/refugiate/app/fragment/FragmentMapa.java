package com.refugiate.app.fragment;


import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;
import static android.content.Context.LOCATION_SERVICE;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;
import com.refugiate.app.dao.clsSucursalSQL;
import com.refugiate.app.entidades.clsSucursal;
import com.refugiate.app.ui.MainActivity;
import com.refugiate.app.ui.R;
import com.refugiate.app.utilidades.route.Routing;
import com.refugiate.app.utilidades.route.RoutingListener;

import java.util.List;

public class FragmentMapa extends Fragment implements LocationListener,GoogleMap.OnMarkerClickListener,RoutingListener {
    MapView mapView;
    private GoogleMap googleMap;
    private int color = Color.RED;
    private ProgressDialog pd;
    private LatLng puntosGPS;
    private LatLng puntosSeleccion;
    // flag for GPS status
    boolean isGPSEnabled = false;

    // flag for network status
    boolean isNetworkEnabled = false;

    // flag for GPS status
    boolean canGetLocation = false;
    private boolean zoon=true;
    Location location; // location

    private static final long MIN_DISTANCE_CHANGE_FOR_UPDATES = 0; // 10 meters

    // The minimum time between updates in milliseconds
    private static final long MIN_TIME_BW_UPDATES = 1000 * 20; // 1 minute

    // Declaring a Location Manager
    protected LocationManager locationManager;
    
    private List<clsSucursal> itens;

    private Button btnClear;

    private Polyline line;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_mapa, container, false);
        ((MainActivity)  getActivity()).getSupportActionBar().setTitle(this.getString(R.string.lbl_item_dw_1_2));

        btnClear = (Button) v.findViewById(R.id.btnClear);
        btnClear.setVisibility(View.INVISIBLE);
        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                googleMap.moveCamera(CameraUpdateFactory.zoomTo(18));
                googleMap.animateCamera(CameraUpdateFactory.newLatLng(puntosGPS));
                line.remove();
                btnClear.setVisibility(View.INVISIBLE);

            }
        });
        // Getting Google Play availability status
        int status = GooglePlayServicesUtil.isGooglePlayServicesAvailable(FragmentMapa.this.getActivity());

        // Showing status
        if(status!= ConnectionResult.SUCCESS){ // Google Play Services are not available

            int requestCode = 10;
            Dialog dialog = GooglePlayServicesUtil.getErrorDialog(status, FragmentMapa.this.getActivity(), requestCode);
            dialog.show();

        }else { // Google Play Services are available

            // Getting reference to the SupportMapFragment of activity_main.xml
            mapView = (MapView) v.findViewById(R.id.mapview);
            mapView.onCreate(savedInstanceState);

            // Getting GoogleMap object from the fragment
            googleMap = mapView.getMap();

            // Enabling MyLocation Layer of Google Map
            googleMap.setMyLocationEnabled(true);
            googleMap.setOnMarkerClickListener(this);
            getLocation();
            addMaker();
            /**
            googleMap.setInfoWindowAdapter(new GoogleMap.InfoWindowAdapter() {

                public View getInfoWindow(Marker marker) {
                    View v = getActivity().getLayoutInflater().inflate(R.layout.map_infowindow, null);
                    final int position = Integer.parseInt(marker.getSnippet());
                    TextView lblNombre = (TextView)v.findViewById(R.id.lblNombre);
                    lblNombre.setText(itens.get(position).getObjEmpresa().getNombreComercial());

                    RatingBar ratingEstrellas = (RatingBar) v.findViewById(R.id.ratingEstrellas);
                    ratingEstrellas.setRating(itens.get(position).getNivel());

                    ImageView image = (ImageView)v.findViewById(R.id.image);
                    if(itens.get(position).getObjEmpresa().getLogo()!=null)
                        image.setImageDrawable( new BitmapDrawable(BitmapFactory.decodeByteArray(itens.get(position).getObjEmpresa().getLogo(), 0, itens.get(position).getObjEmpresa().getLogo().length)));

                    return v;
                }

                public View getInfoContents(Marker arg0) {


                    return null;

                }
            });

            googleMap.setOnInfoWindowClickListener(new GoogleMap.OnInfoWindowClickListener() {
                @Override
                public void onInfoWindowClick(Marker marker) {
                    final int posicion = Integer.parseInt(marker.getSnippet());

                    CharSequence[] items = {"Ver Detalle", "Llegar a Pie", "Llegar en Carro", "Cancelar"};
                    AlertDialog.Builder alert = new AlertDialog.Builder(FragmentMapa.this.getActivity());
                    alert.setTitle(listSucursal.get(posicion).getObjEmpresa().getNombre());

                    alert.setItems(items, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int item) {
                           // opccionesMapa(posicion, item);
                        }
                    });
                    alert.show();
                }
            });
            */
        }
        return v;
    }



    @Override
    public void onResume() {
        mapView.onResume();
        super.onResume();
    }

    @Override
    public void onDestroy() {
        if(locationManager!=null)
            locationManager.removeUpdates(this);
        super.onDestroy();
        mapView.onDestroy();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mapView.onLowMemory();
    }
    public void getLocation() {
        try {
            locationManager = (LocationManager)FragmentMapa.this.getActivity().getSystemService(LOCATION_SERVICE);

            // getting GPS status
            isGPSEnabled = locationManager
                    .isProviderEnabled(LocationManager.GPS_PROVIDER);

            // getting network status
            isNetworkEnabled = locationManager
                    .isProviderEnabled(LocationManager.NETWORK_PROVIDER);

            if (!isGPSEnabled && !isNetworkEnabled) {
                // no network provider is enabled
                Intent viewIntent = new Intent(android.provider.Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                startActivity(viewIntent);
            } else {
                this.canGetLocation = true;
                // First get location from Network Provider
                if (isNetworkEnabled) {
                    locationManager.requestLocationUpdates(
                            LocationManager.NETWORK_PROVIDER,
                            MIN_TIME_BW_UPDATES,
                            MIN_DISTANCE_CHANGE_FOR_UPDATES, this);
                    Log.d("Network", "Network");
                    if (locationManager != null) {
                        location = locationManager
                                .getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
                        if (location != null) {
                            onLocationChanged(location);
                        }
                    }
                }
                // if GPS Enabled get lat/long using GPS Services
                if (isGPSEnabled) {
                    if (location == null) {
                        locationManager.requestLocationUpdates(
                                LocationManager.GPS_PROVIDER,
                                MIN_TIME_BW_UPDATES,
                                MIN_DISTANCE_CHANGE_FOR_UPDATES, this);
                        Log.d("GPS Enabled", "GPS Enabled");
                        if (locationManager != null) {
                            location = locationManager
                                    .getLastKnownLocation(LocationManager.GPS_PROVIDER);
                            if (location != null) {
                                onLocationChanged(location);
                            }
                        }
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Override
    public void onLocationChanged(Location location) {




        if(zoon)
        {;

            puntosGPS = new LatLng(location.getLatitude(), location.getLongitude());
           /** if(entidad.getLatitud()!=0D  && entidad.getLongitud()!=0D)
            {
                latitude=entidad.getLatitud();
                longitude=entidad.getLongitud();
                latLng = new LatLng(latitude, longitude);
                googleMap.addMarker(new MarkerOptions().position(latLng).
                        icon(BitmapDescriptorFactory.fromResource(R.drawable.ubicacion)));
            }*/
            googleMap.moveCamera(CameraUpdateFactory.zoomTo(15));
            googleMap.animateCamera(CameraUpdateFactory.newLatLng(puntosGPS));


            zoon=false;

        }

    }

    @Override
    public void onProviderDisabled(String provider)
    {
        // TODO Auto-generated method stub
        Toast.makeText(FragmentMapa.this.getActivity(), "provider disabled", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onProviderEnabled(String provider)
    {
        // TODO Auto-generated method stub
        Toast.makeText(FragmentMapa.this.getActivity(), "provider enabled", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras)
    {

    }
    public void addMaker()
    {
        googleMap.clear();
        itens= clsSucursalSQL.Listar(this.getActivity());
        if(itens!=null) {
            for (int i = 0; i < itens.size(); i++) {
                googleMap.addMarker(new MarkerOptions().icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_action_ubigeo)).snippet("" + i).position(new LatLng(itens.get(i).getLatitud(), itens.get(i).getLongitud())));
            }
        }

    }

    @Override
    public boolean onMarkerClick(Marker marker) {
        final int posicion = Integer.parseInt(marker.getSnippet());
        final Dialog dialog = new Dialog(this.getActivity());
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        //dialog.setCancelable(false);
        dialog.setContentView(R.layout.map_infowindow);
        TextView lblNombre = (TextView)dialog.findViewById(R.id.lblNombre);
        lblNombre.setText(itens.get(posicion).getObjEmpresa().getNombreComercial());

        RatingBar ratingEstrellas = (RatingBar) dialog.findViewById(R.id.ratingEstrellas);
        ratingEstrellas.setRating(itens.get(posicion).getNivel());

        ImageView image = (ImageView)dialog.findViewById(R.id.image);
        if(itens.get(posicion).getObjEmpresa().getLogo()!=null)
            image.setImageDrawable( new BitmapDrawable(BitmapFactory.decodeByteArray(itens.get(posicion).getObjEmpresa().getLogo(), 0, itens.get(posicion).getObjEmpresa().getLogo().length)));


        final Button btnDetalle = (Button) dialog.findViewById(R.id.btnDetalle);
        btnDetalle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnDetalle(posicion);
                dialog.dismiss();
            }
        });

        Button btnCaminando = (Button) dialog.findViewById(R.id.btnCaminando);
        btnCaminando.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getRuta(posicion,true);
                dialog.dismiss();
            }
        });
        Button btnVehiculo = (Button) dialog.findViewById(R.id.btnVehiculo);
        btnVehiculo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getRuta(posicion,false);
                dialog.dismiss();
            }
        });
        dialog.show();
        return true;
    }

    @Override
    public void onRoutingFailure() {

    }

    @Override
    public void onRoutingStart() {

    }

    @Override
    public void onRoutingSuccess(PolylineOptions mPolyOptions) {
        PolylineOptions polyoptions = new PolylineOptions();
        polyoptions.color(color);
        polyoptions.width(5);
        polyoptions.addAll(mPolyOptions.getPoints());
        line =googleMap.addPolyline(polyoptions);
        pd.dismiss();
        btnClear.setVisibility(View.VISIBLE);

    }

    public void getRuta(int Posicion,boolean travelMode) {
        puntosSeleccion= new LatLng(itens.get(Posicion).getLatitud(),itens.get(Posicion).getLongitud());
        Routing routing = new Routing(Routing.TravelMode.DRIVING);
        if(travelMode)
        {
            routing = new Routing(Routing.TravelMode.WALKING);
            color = getResources().getColor(R.color.md_light_green_800);
        }
        else
            color =  getResources().getColor(R.color.md_light_blue_800);

        routing.registerListener(this);
        routing.execute(puntosGPS, puntosSeleccion);
        pd = new ProgressDialog(this.getActivity());
        pd.setMessage(getString(R.string.lbl_pd_cargando_ruta));
        pd.show();

        LatLngBounds.Builder builder = new LatLngBounds.Builder();
        builder.include(puntosGPS);
        builder.include(puntosSeleccion);
        LatLngBounds bounds = builder.build();
        int padding = 100;
        googleMap.animateCamera(CameraUpdateFactory.newLatLngBounds(bounds, padding));
    }
    public void btnDetalle(int posicion)
    {
        clsSucursalSQL.setSeleccionado(this.getActivity(),itens.get(posicion).getIdSucursal());
        ((MainActivity)getActivity()).setFragment(new FragmentTab1());

    }

}