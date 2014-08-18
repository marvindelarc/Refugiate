package com.refujiate.ui;

import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import com.refujiate.entidades.clsHotel;
import com.refujiate.entidades.clsPersona;
import com.refujiate.consumo.clsConexion;
import com.refujiate.entidades.clsComentario;
import com.refujiate.entidades.clsDetalleReserva;
import com.refujiate.extra.LazyList.LazyAdapter;
import com.refujiate.sqlite.clsComentarioSQL;
import com.refujiate.sqlite.clsDetalleReservaSQL;
import com.refujiate.sqlite.clsPersonalSQL;
import com.refujiate.sqlite.clsHotelSQL;
import java.util.List;

public class MainActivity extends Activity
{
    private  List<clsHotel> listaHoteles;
    private EditText txtBusqueda;
    private ListView lstViewHoteles;
    private LazyAdapter adapter;
    private ProgressDialog pd ;
    private int idTipoHotel=0;
    private int idServicio=0;
    private int puntaje=0;
    private int estrellas=0;
    
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
       
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);  
        Bundle bundle=getIntent().getExtras();
        idTipoHotel=Integer.valueOf(bundle.getString("idTipoHotel"));
        idServicio=Integer.valueOf(bundle.getString("idServicio"));
        puntaje=Integer.valueOf(bundle.getString("puntaje"));
        estrellas=Integer.valueOf(bundle.getString("estrellas"));
        
        lstViewHoteles = (ListView)findViewById(R.id.listHoteles);  
        txtBusqueda = (EditText) findViewById(R.id.txtBusqueda);        
	txtBusqueda.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before,int count) {                                
                filtro(s.toString().trim()); 
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count,int after) {
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
                
          filtro("");
                
//        pd = new ProgressDialog(this);
//        pd.setTitle("Cargando ...");
//        pd.setMessage("Espere un momento");     
//        pd.show();        
//
//        new Thread() { 
//            public void run() { 
//                data = new ListaHotelCom();
//                  handler.sendEmptyMessage(0);                
//            } 
//       }.start(); 
          
          
    }
 @Override
    public void onDestroy()
    {
        lstViewHoteles.setAdapter(null);
        super.onDestroy();
    }
    final Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            //update UI here depending on what message is received.
            super.handleMessage(msg);
            pd.dismiss();                   
            filtro("");
        }
    };

    public void filtro(String filtro)
    {    
            listaHoteles=clsHotelSQL.ListarXFiltro(this, filtro,idTipoHotel,idServicio,puntaje,estrellas);

            adapter=new LazyAdapter(this, listaHoteles);     
            lstViewHoteles.setAdapter(adapter);
            lstViewHoteles.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int posicion, long id) {
                enviaPosicion(posicion);
            }
        });
    }

    public void enviaPosicion(int id)
    {
        Intent i=new Intent(this,TabsActivity.class);
        i.putExtra("IDHOTEL",""+listaHoteles.get(id).getInt_IdHotel());
        startActivity(i); 
    }
    
    public void btnBuscarFil(View e)
    {
        Intent i=new Intent(this,BusquedaActivity.class);
        startActivity(i); 
        
        
        
    }
    
    public void btnVerMapa(View e)
    { 
        Intent i=new Intent(this,MainMapaActivity.class);
        startActivity(i);         
    }
     
     public void btnRes(View e)
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
            Intent i=new Intent(this,HistorialActivity.class);
                startActivity(i);   
                 Toast.makeText(this,objPersona.getStr_Apellido()+" ,"+objPersona.getStr_Nombre(), Toast.LENGTH_SHORT).show();
        }
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
      
       public void Registrar()
    {
        Intent i=new Intent(this,SuscribirsePasoAActivity.class);
        startActivity(i); 
    }
    

    
}