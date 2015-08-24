package com.refugiate.app.fragment.hoteles;


import android.app.Dialog;
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
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;
import com.refugiate.app.dao.clsSucursalSQL;
import com.refugiate.app.entidades.clsSucursal;
import com.refugiate.app.ui.MainActivity;
import com.refugiate.app.ui.R;
import com.refugiate.app.utilidades.route.Routing;
import com.refugiate.app.utilidades.route.RoutingListener;

public class FragmentTab2 extends Fragment implements LocationListener,GoogleMap.OnMarkerClickListener,RoutingListener {
    View Tab3 ;
    View Tab4 ;
    MapView mapView;
    private GoogleMap googleMap;
    private int color = Color.RED;
    private LatLng puntosGPS;
    private LatLng puntosSeleccion;
    // flag for GPS status
    boolean isGPSEnabled = false;

    // flag for network status
    boolean isNetworkEnabled = false;

    // flag for GPS status
    boolean canGetLocation = false;
    private boolean recorrido=false;
    Location location; // location

    private static final long MIN_DISTANCE_CHANGE_FOR_UPDATES = 0; // 10 meters

    // The minimum time between updates in milliseconds
    private static final long MIN_TIME_BW_UPDATES = 1000 * 20; // 1 minute

    // Declaring a Location Manager
    protected LocationManager locationManager;

    private clsSucursal entidad;
    private Button btnClear;
    private boolean travelMode;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tabs_2, container, false);
        Tab3=  (View) view.findViewById(R.id.Tab3);
        Tab4=  (View) view.findViewById(R.id.Tab4);
        entidad= clsSucursalSQL.getSeleccionado(this.getActivity());

        if(entidad.getObjEmpresa().isPaquete()) {
            Tab3.setVisibility(View.VISIBLE);
            Tab4.setVisibility(View.VISIBLE);
        }
        else
        {
            Tab3.setVisibility(View.INVISIBLE);
            Tab4.setVisibility(View.INVISIBLE);
        }
        puntosSeleccion = new LatLng(entidad.getLatitud(), entidad.getLongitud());
        Button btnTab1 = (Button) view.findViewById(R.id.btnTab1);

        btnTab1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnTabs(1);
            }
        });

        Button btnTab3 = (Button) view.findViewById(R.id.btnTab3);

        btnTab3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnTabs(3);
            }
        });

        Button btnTab4 = (Button) view.findViewById(R.id.btnTab4);

        btnTab4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnTabs(4);
            }
        });


        btnClear = (Button) view.findViewById(R.id.btnClear);
        btnClear.setVisibility(View.INVISIBLE);
        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                recorrido=false;
                googleMap.clear();
                addMaker();
                btnClear.setVisibility(View.INVISIBLE);

            }
        });
        // Getting Google Play availability status
        int status = GooglePlayServicesUtil.isGooglePlayServicesAvailable(FragmentTab2.this.getActivity());

        // Showing status
        if(status!= ConnectionResult.SUCCESS){ // Google Play Services are not available

            int requestCode = 10;
            Dialog dialog = GooglePlayServicesUtil.getErrorDialog(status, FragmentTab2.this.getActivity(), requestCode);
            dialog.show();

        }else { // Google Play Services are available

            // Getting reference to the SupportMapFragment of activity_main.xml
            mapView = (MapView) view.findViewById(R.id.mapview);
            mapView.onCreate(savedInstanceState);

            // Getting GoogleMap object from the fragment
            googleMap = mapView.getMap();

            // Enabling MyLocation Layer of Google Map
            googleMap.setMyLocationEnabled(true);
            googleMap.setOnMarkerClickListener(this);
            getLocation();

        }
        addMaker();
        return view;
    }


    public void addMaker()
    {

        BitmapDescriptor bitmapDescriptor=BitmapDescriptorFactory.fromResource(R.drawable.ic_action_ubigeo);

        if(entidad.getNivel()==1)
            bitmapDescriptor=BitmapDescriptorFactory.fromResource(R.drawable.estrella1);
        else if(entidad.getNivel()==2)
            bitmapDescriptor=BitmapDescriptorFactory.fromResource(R.drawable.estrella2);
        else if(entidad.getNivel()==3)
            bitmapDescriptor=BitmapDescriptorFactory.fromResource(R.drawable.estrella3);
        else if(entidad.getNivel()==4)
            bitmapDescriptor=BitmapDescriptorFactory.fromResource(R.drawable.estrella4);
        else if(entidad.getNivel()==5)
            bitmapDescriptor=BitmapDescriptorFactory.fromResource(R.drawable.estrella5);
        googleMap.addMarker(new MarkerOptions().icon(bitmapDescriptor).position(new LatLng(entidad.getLatitud(), entidad.getLongitud())));
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
            locationManager = (LocationManager)FragmentTab2.this.getActivity().getSystemService(LOCATION_SERVICE);

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




            puntosGPS = new LatLng(location.getLatitude(), location.getLongitude());
            googleMap.animateCamera(CameraUpdateFactory.newLatLng(puntosGPS));

            LatLngBounds.Builder builder = new LatLngBounds.Builder();
            builder.include(puntosGPS);
            builder.include(puntosSeleccion);
            LatLngBounds bounds = builder.build();
            int padding = 100;

            googleMap.animateCamera(CameraUpdateFactory.newLatLngBounds(bounds, padding));
            getRuta();

    }

    @Override
    public void onProviderDisabled(String provider)
    {
        // TODO Auto-generated method stub
        Toast.makeText(FragmentTab2.this.getActivity(), "provider disabled", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onProviderEnabled(String provider)
    {
        // TODO Auto-generated method stub
        Toast.makeText(FragmentTab2.this.getActivity(), "provider enabled", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras)
    {

    }


    @Override
    public boolean onMarkerClick(Marker marker) {
        final Dialog dialog = new Dialog(this.getActivity());
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        //dialog.setCancelable(false);
        dialog.setContentView(R.layout.map_infowindow);
        TextView lblNombre = (TextView)dialog.findViewById(R.id.lblNombre);
        lblNombre.setText(entidad.getObjEmpresa().getNombreComercial());

        RatingBar ratingEstrellas = (RatingBar) dialog.findViewById(R.id.ratingEstrellas);
       ratingEstrellas.setRating(entidad.getNivel());

        ImageView image = (ImageView)dialog.findViewById(R.id.image);
        if(entidad.getObjEmpresa().getLogo()!=null)
            image.setImageDrawable( new BitmapDrawable(BitmapFactory.decodeByteArray(entidad.getObjEmpresa().getLogo(), 0, entidad.getObjEmpresa().getLogo().length)));


        final Button btnDetalle = (Button) dialog.findViewById(R.id.btnDetalle);
        btnDetalle.setVisibility(View.INVISIBLE);


        Button btnCaminando = (Button) dialog.findViewById(R.id.btnCaminando);
        btnCaminando.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recorrido=true;
                travelMode=true;
                getRuta();
                dialog.dismiss();
            }
        });
        Button btnVehiculo = (Button) dialog.findViewById(R.id.btnVehiculo);
        btnVehiculo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recorrido=true;
                travelMode=false;
                getRuta();
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
        googleMap.addPolyline(polyoptions);
        btnClear.setVisibility(View.VISIBLE);

    }

    public void getRuta() {
        if(recorrido) {

            Routing routing = new Routing(Routing.TravelMode.DRIVING);
            if (travelMode) {
                routing = new Routing(Routing.TravelMode.WALKING);
                color = getResources().getColor(R.color.md_light_green_800);
            } else
                color = getResources().getColor(R.color.md_light_blue_800);

            routing.registerListener(this);
            routing.execute(puntosGPS, puntosSeleccion);
        }

    }



    private void btnTabs(int position)
    {
        Fragment fragment=null;
        switch (position)
        {
            case 1:
                fragment = new FragmentTab1();
                break;
            case 3:
                fragment = new FragmentTab3();
                break;
            case 4:
                fragment = new FragmentTab4();
                break;
            default:

                break;
        }
        ((MainActivity)getActivity()).setFragment(fragment);
    }

}




