package com.refugiate.app.utilidades.LazyList;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.refugiate.app.entidades.clsEmpresa;

import java.util.List;

public class LazyAdapter extends BaseAdapter {
    
    private Activity activity;
    private List<clsEmpresa> Lista;
    private static LayoutInflater inflater=null;
    public ImageLoader imageLoader; 
    
    public LazyAdapter(Activity a, List<clsEmpresa> lista) {
        activity = a;
        Lista=lista;
        inflater = (LayoutInflater)activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        imageLoader=new ImageLoader(activity.getApplicationContext());
    }

    public int getCount() {
        return Lista.size();
    }

    public Object getItem(int position) {
        return position;
    }

    public long getItemId(int position) {
        return position;
    }
    
    public View getView(int position, View convertView, ViewGroup parent) {
        View vi=convertView;
     //   if(convertView==null)
        /*    vi = inflater.inflate(R.layout.lista_hoteles, null);

        TextView lblNombreHot = (TextView)vi.findViewById(R.id.lblNombre);
      // lblNombreHot.setText(Lista.get(position).getStr_Nombre());
        
        RatingBar ratingEstrellas = (RatingBar) vi.findViewById(R.id.ratingEstrellas);
        ratingEstrellas.setRating(Lista.get(position).getInt_Estrellas());
        
        ImageView image=(ImageView)vi.findViewById(R.id.image);
        imageLoader.DisplayImage("IMG/Hoteles/logo/"+Lista.get(position).getInt_IdHotel()+".jpg", image);
        */
        return vi;
    }
}