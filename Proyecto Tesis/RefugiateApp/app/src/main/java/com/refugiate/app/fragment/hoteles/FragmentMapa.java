package com.refugiate.app.fragment.hoteles;


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
import android.support.v7.app.AlertDialog;
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
import com.refugiate.app.dao.clsCostoTipoHabitacionSQL;
import com.refugiate.app.dao.clsServicioSQL;
import com.refugiate.app.dao.clsSucursalSQL;
import com.refugiate.app.entidades.clsServicio;
import com.refugiate.app.entidades.clsSucursal;
import com.refugiate.app.ui.MainActivity;
import com.refugiate.app.ui.R;
import com.refugiate.app.utilidades.Utilidades;
import com.refugiate.app.utilidades.route.Routing;
import com.refugiate.app.utilidades.route.RoutingListener;
import com.yahoo.mobile.client.android.util.rangeseekbar.RangeSeekBar;

import java.util.ArrayList;
import java.util.List;

public class FragmentMapa extends Fragment implements LocationListener,GoogleMap.OnMarkerClickListener,RoutingListener {
    private  int distancia=0;
    private List<clsServicio> listServicios;
    private boolean[] booleanSelectArray;
    private RangeSeekBar rangebarEstrellas;
    private int iniEstrellas=1;
    private int finEstrellas=5;

    private RangeSeekBar rangebarPuntos;
    private int iniPuntos=1;
    private int finPuntos=5;

    private RangeSeekBar rangebarComodidad;
    private int iniComodidad=1;
    private int finComodidad=5;

    private RangeSeekBar rangebarLimpieza;
    private int iniLimpieza=1;
    private int finLimpieza=5;

    private RangeSeekBar rangebarServicio;
    private int iniServicio=1;
    private int finServicio=5;

    private RangeSeekBar rangebarPrecios;
    private int iniPrecios;
    private int finPrecios;
    private int minCosto;
    private int maxCosto;

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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_mapa, container, false);
        iniPrecios=minCosto= clsCostoTipoHabitacionSQL.getMimCosto(this.getActivity());
        finPrecios=maxCosto=clsCostoTipoHabitacionSQL.getMaxCosto(this.getActivity());
        listServicios= clsServicioSQL.Listar(this.getActivity());
        booleanSelectArray = new boolean[listServicios.size()];
        ((MainActivity)  getActivity()).getSupportActionBar().setTitle(this.getString(R.string.lbl_item_dw_1_1));
        Button btnRangoFiltro = (Button) v.findViewById(R.id.btnRangoFiltro);
        btnRangoFiltro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnRangoFiltro();
            }
        });

        Button btnOrdenar = (Button) v.findViewById(R.id.btnOrdenar);
        btnOrdenar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnOrdenar();
            }
        });

        Button btnServicios = (Button) v.findViewById(R.id.btnServicios);
        btnServicios.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnServicios();
            }
        });


        btnClear = (Button) v.findViewById(R.id.btnClear);
        btnClear.setVisibility(View.INVISIBLE);
        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                addMaker();
                googleMap.moveCamera(CameraUpdateFactory.zoomTo(18));
                googleMap.animateCamera(CameraUpdateFactory.newLatLng(puntosGPS));

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
        List<clsServicio> lista=new ArrayList<clsServicio>();
        for(int i=0;i<booleanSelectArray.length;i++)
        {
            if(booleanSelectArray[i])
                lista.add(listServicios.get(i));
        }
        googleMap.clear();
        itens= clsSucursalSQL.Listar(this.getActivity(),iniEstrellas,finEstrellas
                ,iniPuntos,finPuntos,iniComodidad,finComodidad,iniLimpieza,finLimpieza
                ,iniServicio,finServicio,iniPrecios,finPrecios,lista);
        itens=Utilidades.getDistanciaMapa(location,distancia,itens);

        if(itens!=null) {
            for (int i = 0; i < itens.size(); i++) {

                BitmapDescriptor bitmapDescriptor=BitmapDescriptorFactory.fromResource(R.drawable.ic_action_ubigeo);

                if(itens.get(i).getNivel()==1)
                    bitmapDescriptor=BitmapDescriptorFactory.fromResource(R.drawable.estrella1);
                else if(itens.get(i).getNivel()==2)
                    bitmapDescriptor=BitmapDescriptorFactory.fromResource(R.drawable.estrella2);
                else if(itens.get(i).getNivel()==3)
                    bitmapDescriptor=BitmapDescriptorFactory.fromResource(R.drawable.estrella3);
                else if(itens.get(i).getNivel()==4)
                    bitmapDescriptor=BitmapDescriptorFactory.fromResource(R.drawable.estrella4);
                else if(itens.get(i).getNivel()==5)
                    bitmapDescriptor=BitmapDescriptorFactory.fromResource(R.drawable.estrella5);
                googleMap.addMarker(new MarkerOptions().icon(bitmapDescriptor).snippet("" + i).position(new LatLng(itens.get(i).getLatitud(), itens.get(i).getLongitud())));
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
        googleMap.addPolyline(polyoptions);
        pd.dismiss();
        btnClear.setVisibility(View.VISIBLE);

    }

    public void getRuta(int Posicion,boolean travelMode) {
        googleMap.clear();
        addMaker();
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
        ((MainActivity)getActivity()).mapa=0;
        ((MainActivity)getActivity()).setFragment(new FragmentTab1());

    }

    public void btnRangoFiltro()
    {
        final Dialog dialog = new Dialog(this.getActivity());
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        //dialog.setCancelable(false);
        dialog.setContentView(R.layout.dialog_filtro_rango);

        final TextView lblrangebarPrecios = (TextView)dialog.findViewById(R.id.lblrangebarPrecios);
        lblrangebarPrecios.setText("" + iniPrecios + " a " + finPrecios);
        rangebarPrecios = (RangeSeekBar)dialog.findViewById(R.id.rangebarPrecios);
        rangebarPrecios.setRangeValues(minCosto, maxCosto);
        rangebarPrecios.setSelectedMinValue(iniPrecios);
        rangebarPrecios.setSelectedMaxValue(finPrecios);
        rangebarPrecios.setOnRangeSeekBarChangeListener(new RangeSeekBar.OnRangeSeekBarChangeListener<Integer>() {
            @Override
            public void onRangeSeekBarValuesChanged(RangeSeekBar<?> bar, Integer minValue, Integer maxValue) {
                // handle changed range values
                iniPrecios = minValue;
                finPrecios = maxValue;
                lblrangebarPrecios.setText("" + iniPrecios + " a " + finPrecios);
            }
        });


        final TextView lblrangebarEstrellas = (TextView)dialog.findViewById(R.id.lblrangebarEstrellas);
        lblrangebarEstrellas.setText("1 a 5");
        rangebarEstrellas = (RangeSeekBar)dialog.findViewById(R.id.rangebarEstrellas);
        //rangeSeekBar.setRangeValues(15, 90);
        rangebarEstrellas.setSelectedMinValue(iniEstrellas);
        rangebarEstrellas.setSelectedMaxValue(finEstrellas);
        rangebarEstrellas.setOnRangeSeekBarChangeListener(new RangeSeekBar.OnRangeSeekBarChangeListener<Integer>() {
            @Override
            public void onRangeSeekBarValuesChanged(RangeSeekBar<?> bar, Integer minValue, Integer maxValue) {
                // handle changed range values

                iniEstrellas = minValue;
                finEstrellas = maxValue;
                lblrangebarEstrellas.setText("" + iniEstrellas + " a " + finEstrellas);
            }
        });


        final TextView lblrangebarPuntos = (TextView)dialog.findViewById(R.id.lblrangebarPuntos);
        lblrangebarPuntos.setText("1 a 5");

        rangebarPuntos = (RangeSeekBar)dialog.findViewById(R.id.rangebarPuntos);
        //rangeSeekBar.setRangeValues(15, 90);
        rangebarPuntos.setSelectedMinValue(iniPuntos);
        rangebarPuntos.setSelectedMaxValue(finPuntos);
        rangebarPuntos.setOnRangeSeekBarChangeListener(new RangeSeekBar.OnRangeSeekBarChangeListener<Integer>() {
            @Override
            public void onRangeSeekBarValuesChanged(RangeSeekBar<?> bar, Integer minValue, Integer maxValue) {
                // handle changed range values
                iniPuntos = minValue;
                finPuntos = maxValue;
                lblrangebarPuntos.setText("" + iniPuntos + " a " + finPuntos);
            }
        });


        final TextView lblrangebarComodidad = (TextView)dialog.findViewById(R.id.lblrangebarComodidad);
        lblrangebarComodidad.setText("1 a 5");
        rangebarComodidad = (RangeSeekBar)dialog.findViewById(R.id.rangebarComodidad);
        //rangebarComodidad.setRangeValues(15, 90);
        rangebarComodidad.setSelectedMinValue(iniComodidad);
        rangebarComodidad.setSelectedMaxValue(finComodidad);
        rangebarComodidad.setOnRangeSeekBarChangeListener(new RangeSeekBar.OnRangeSeekBarChangeListener<Integer>() {
            @Override
            public void onRangeSeekBarValuesChanged(RangeSeekBar<?> bar, Integer minValue, Integer maxValue) {
                // handle changed range values
                iniComodidad = minValue;
                finComodidad = maxValue;
                lblrangebarComodidad.setText("" + iniComodidad + " a " + finComodidad);
            }
        });


        final TextView lblrangebarLimpieza = (TextView)dialog.findViewById(R.id.lblrangebarLimpieza);
        lblrangebarLimpieza.setText("1 a 5");
        rangebarLimpieza = (RangeSeekBar)dialog.findViewById(R.id.rangebarLimpieza);
        //rangebarComodidad.setRangeValues(15, 90);
        rangebarLimpieza.setSelectedMinValue(iniLimpieza);
        rangebarLimpieza.setSelectedMaxValue(finLimpieza);
        rangebarLimpieza.setOnRangeSeekBarChangeListener(new RangeSeekBar.OnRangeSeekBarChangeListener<Integer>() {
            @Override
            public void onRangeSeekBarValuesChanged(RangeSeekBar<?> bar, Integer minValue, Integer maxValue) {
                // handle changed range values
                iniLimpieza = minValue;
                finLimpieza = maxValue;
                lblrangebarLimpieza.setText("" + iniLimpieza + " a " + finLimpieza);
            }
        });


        final TextView lblrangebarServicio = (TextView)dialog.findViewById(R.id.lblrangebarServicio);
        lblrangebarServicio.setText("1 a 5");
        rangebarServicio = (RangeSeekBar)dialog.findViewById(R.id.rangebarServicio);
        //rangebarComodidad.setRangeValues(15, 90);
        rangebarServicio.setSelectedMinValue(iniServicio);
        rangebarServicio.setSelectedMaxValue(finServicio);
        rangebarServicio.setOnRangeSeekBarChangeListener(new RangeSeekBar.OnRangeSeekBarChangeListener<Integer>() {
            @Override
            public void onRangeSeekBarValuesChanged(RangeSeekBar<?> bar, Integer minValue, Integer maxValue) {
                // handle changed range values
                iniServicio = minValue;
                finServicio = maxValue;
                lblrangebarServicio.setText("" + iniServicio + " a " + finServicio);
            }
        });



        Button btnAceptar = (Button) dialog.findViewById(R.id.btnAceptar);
        btnAceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addMaker();
                dialog.dismiss();
            }
        });
        dialog.show();
    }

    public void btnOrdenar()
    {
        final CharSequence[] items = getResources().getStringArray(R.array.array_distancia);
        AlertDialog.Builder alert = new AlertDialog.Builder(this.getActivity());
        alert.setTitle(getString(R.string.str_instalacion));
        alert.setItems(items, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int item) {
                distancia=item;
                addMaker();
            }});
        alert.show();
    }

    public void btnServicios()
    {
        final CharSequence[] items = new String[listServicios.size()];;
        for(int i=0;i<listServicios.size();i++)
        {
            items[i]=listServicios.get(i).getNombre();
        }


        AlertDialog.Builder builder=new AlertDialog.Builder(this.getActivity());
        builder.setTitle(getString(R.string.str_instalacion));
        builder.setPositiveButton(R.string.str_btnAceptar, new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                addMaker();
            }
        });

//setMultiChoiceItems will allow use to select multiple items from list by clicking on checkbox
        builder.setMultiChoiceItems(items, booleanSelectArray, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {

            }
        });
        builder.show();
    }
}