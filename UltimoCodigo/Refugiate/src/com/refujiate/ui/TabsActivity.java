package com.refujiate.ui;

import android.app.Dialog;
import android.app.TabActivity;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;
import android.widget.Toast;
import com.refujiate.entidades.clsPersona;
import com.refujiate.consumo.clsConexion;
import com.refujiate.entidades.clsComentario;
import com.refujiate.entidades.clsDetalleReserva;
import com.refujiate.sqlite.clsComentarioSQL;
import com.refujiate.sqlite.clsDetalleReservaSQL;
import com.refujiate.sqlite.clsPersonalSQL;

public class TabsActivity extends TabActivity {

    private int IdHotel=0;
    private String number="";
    private String listaHabitaciones="";
     private String listaComentario="";
    View banner;
    
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tabs);
        banner = (View) findViewById(R.id.banner);
        
        Bundle bundle=getIntent().getExtras();
        IdHotel=Integer.valueOf(bundle.getString("IDHOTEL"));
        
        String data= clsConexion.readTexto("servicio/buscarHotel.jsp?IdEmpresa="+IdHotel);
 
          
        String [] entidad = data.split("\\<+col+>"); 
        
        number=entidad[1].trim();
        
        if(entidad[11].trim().equals("1"))
        banner.setVisibility(View.GONE);
        
        
        
        listaHabitaciones=entidad[16].trim();
        listaComentario=entidad[17].trim();
        
        
        Resources res= getResources();          
		TabHost tabHost = getTabHost(); 
		
        Intent intentDatos = new Intent().setClass(this, DatosTab.class);	
        intentDatos.putExtra("IDHOTEL",""+IdHotel);
        intentDatos.putExtra("ratinEstrellasTabDatos",entidad[10].trim());
        intentDatos.putExtra("lblDireccionTabDatos",entidad[2].trim());
//        intentDatos.putExtra("lblServiciosTabDatos","Recojo al Aeropuerto, Recojo Terrestre, Lavandariea, Telefono Publico , Internet Inhalambrico");
        intentDatos.putExtra("lblEntradaTabDatos",entidad[12].trim());
        intentDatos.putExtra("lblSalidaTabDatos",entidad[13].trim());
        intentDatos.putExtra("lblCiudadTabDatos",entidad[15].trim());        
        intentDatos.putExtra("lblCalificacionTabDatos",entidad[9].trim());
        
        intentDatos.putExtra("lblPisosTabDatos",entidad[5].trim());
        intentDatos.putExtra("lblComodidadTabDatos",entidad[8].trim());
        intentDatos.putExtra("lblLimpiezaTabDatos",entidad[6].trim());        
        intentDatos.putExtra("lblServicioTabDatos",entidad[7].trim());
        intentDatos.putExtra("lblNombreTabDatos",entidad[14].trim());
       
        TabSpec tabDatos = tabHost.newTabSpec("").setIndicator("", res.getDrawable(R.drawable.datos)).setContent(intentDatos);


        Intent intentCama = new Intent().setClass(this, CamasTab.class);
        intentCama.putExtra("IDHOTEL",""+IdHotel);
        intentCama.putExtra("listaHabitaciones",listaHabitaciones.trim());
        TabSpec tabCama = tabHost.newTabSpec("").setIndicator("", res.getDrawable(R.drawable.cama)).setContent(intentCama);


        Intent intentComentario= new Intent().setClass(this, ComentariosTab.class);
        intentComentario.putExtra("IDHOTEL",""+IdHotel);
        intentComentario.putExtra("listaComentario",listaComentario.trim());
        TabSpec tabComentario = tabHost.newTabSpec("").setIndicator("", res.getDrawable(R.drawable.comentario)).setContent(intentComentario);


        Intent intentFotos = new Intent().setClass(this, ImagenesTab.class);
        intentFotos.putExtra("IDHOTEL",""+IdHotel);
        TabSpec tabFotos = tabHost.newTabSpec("").setIndicator("", res.getDrawable(R.drawable.fotos)).setContent(intentFotos);

        
        Intent intentUbicacion = new Intent().setClass(this, UbicacionTab.class);
        intentUbicacion.putExtra("IDHOTEL",""+IdHotel);
        intentUbicacion.putExtra("lblNombreTabUbicacion",entidad[14].trim());
        intentUbicacion.putExtra("LONGITUD",entidad[3].trim());
        intentUbicacion.putExtra("LATITUD",entidad[4].trim());
        TabSpec tabUbicacion = tabHost.newTabSpec("").setIndicator("", res.getDrawable(R.drawable.ubicacion)).setContent(intentUbicacion);
        
		tabHost.addTab(tabDatos);
		tabHost.addTab(tabCama);
		tabHost.addTab(tabComentario);
                tabHost.addTab(tabFotos);
		tabHost.addTab(tabUbicacion);
		
		tabHost.setCurrentTab(0);
                
    }    
    
    public void btnLlamar(View e)
    {
        Intent intent = new Intent(Intent.ACTION_CALL);
        intent.setData(Uri.parse("tel:" +number));
        startActivity(intent);
    }
      
       public void btnReservarHabitacion(View e)
    {
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
            Intent i=new Intent(this,ReservarActivity.class);
            i.putExtra("listaHabitaciones",listaHabitaciones.trim());
             i.putExtra("ID",""+IdHotel);
                startActivity(i);   
                 Toast.makeText(this,objPersona.getStr_Apellido()+" ,"+objPersona.getStr_Nombre(), Toast.LENGTH_SHORT).show();
        }
            
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
                Intent i=new Intent(this,ReservarActivity.class);
                i.putExtra("listaHabitaciones",listaHabitaciones.trim());
                i.putExtra("ID",""+IdHotel);
                startActivity(i);   
                Toast.makeText(this,"Bienvenido "+objPersona.getStr_Apellido()+" ,"+objPersona.getStr_Nombre(), Toast.LENGTH_SHORT).show(); 
        }
           else
            Toast.makeText(this,"Error de Credenciales", Toast.LENGTH_SHORT).show(); 
   }    
}