/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.refujiate.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RatingBar;
import android.widget.TextView;
import com.refujiate.entidades.clsInstalacion;
import com.refujiate.sqlite.clsInstalacionSQL;
import java.util.List;

/**
 *
 * @author Paulo
 */
public class DatosTab extends Activity {
private int IdHotel=0;
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tab_datos);
        Bundle bundle=getIntent().getExtras();
        IdHotel=Integer.valueOf(bundle.getString("IDHOTEL"));
        
        TextView lblDireccionTabDatos=(TextView)findViewById(R.id.lblDireccionTabDatos);  
        lblDireccionTabDatos.setText(bundle.getString("lblDireccionTabDatos")+"\n");        
        
        TextView lblServiciosTabDatos=(TextView)findViewById(R.id.lblServiciosTabDatos);  
        lblServiciosTabDatos.setText(bundle.getString("lblServiciosTabDatos"));
        
        TextView lblEntradaTabDatos=(TextView)findViewById(R.id.lblEntradaTabDatos);  
        lblEntradaTabDatos.setText("Entrada: "+bundle.getString("lblEntradaTabDatos"));        
        
        TextView lblSalidaTabDatos=(TextView)findViewById(R.id.lblSalidaTabDatos);  
        lblSalidaTabDatos.setText("Salalida: "+bundle.getString("lblSalidaTabDatos"));        
        
        TextView lblCalificacionTabDatos=(TextView)findViewById(R.id.lblCalificacionTabDatos);  
        lblCalificacionTabDatos.setText("Calificación Global: "+bundle.getString("lblCalificacionTabDatos"));
        
        TextView lblCiudadTabDatos=(TextView)findViewById(R.id.lblCiudadTabDatos);  
        lblCiudadTabDatos.setText("Ciudad: "+bundle.getString("lblCiudadTabDatos"));  
        
        TextView lblPisosTabDatos=(TextView)findViewById(R.id.lblPisosTabDatos);  
        lblPisosTabDatos.setText("Pisos: "+bundle.getString("lblPisosTabDatos")+"\n");  
        
        TextView lblComodidadTabDatos=(TextView)findViewById(R.id.lblComodidadTabDatos);  
        lblComodidadTabDatos.setText("Comodidad: "+bundle.getString("lblComodidadTabDatos"));  
        
        TextView lblLimpiezaTabDatos=(TextView)findViewById(R.id.lblLimpiezaTabDatos);  
        lblLimpiezaTabDatos.setText("Limpieza: "+bundle.getString("lblLimpiezaTabDatos"));  
        
        TextView lblServicioTabDatos=(TextView)findViewById(R.id.lblServicioTabDatos);  
        lblServicioTabDatos.setText("Servicio: "+bundle.getString("lblServicioTabDatos"));  
        
        TextView lblNombreTabDatos=(TextView)findViewById(R.id.lblNombreTabDatos);  
        lblNombreTabDatos.setText(bundle.getString("lblNombreTabDatos"));  
     
        RatingBar ratinEstrellasTabDatos = (RatingBar) findViewById(R.id.ratinEstrellasTabDatos);
        ratinEstrellasTabDatos.setRating(Integer.parseInt(bundle.getString("ratinEstrellasTabDatos")));  
        
        
        String servicio="";
        List<clsInstalacion> lista=clsInstalacionSQL.ListarXSucursal(this, IdHotel);
        if(lista!=null)
        for(clsInstalacion entidad:lista)
        servicio+=" - "+entidad.getStr_Nombre()+": "+entidad.getStr_Descripcion()+"\n";
        else
            servicio="- Este establecimiento no cuenta con servicios. \n";

         lblServiciosTabDatos.setText(servicio);  

    }
    
    public void btnReservarHabitacion(View e)
    {
        Intent i=new Intent(this,ReservarActivity.class);
        startActivity(i); 
    }
}