/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.refujiate.ui;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;

/**
 *
 * @author Paulo
 */
public class ImagenesTab extends Activity {
private int IdHotel=0;
  
  private int[] imageIDs = {R.drawable.ing1,R.drawable.ing2,R.drawable.ing3};

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tab_imagenes);

        Gallery gallery = (Gallery) findViewById(R.id.gallery1);

        gallery.setAdapter(new ImageAdapter(this));
        gallery.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView parent, View v, int position,
                    long id) {                         
            View imageView = (View) findViewById(R.id.imageview1);               
              imageView.setBackgroundResource(imageIDs[position]);

            }
        });


    }

    public class ImageAdapter extends BaseAdapter {
        private Context context;
        private int itemBackground;

        public ImageAdapter(Context c) {
            context = c;
            // ---setting the style---
             TypedArray a = obtainStyledAttributes(R.styleable.Gallery1);
            itemBackground = a.getResourceId(
             R.styleable.Gallery1_android_galleryItemBackground, 0);
             a.recycle();
        }

        public int getCount() {
            return imageIDs.length;
        }

        public Object getItem(int position) {
            return position;
        }

        public long getItemId(int position) {
            return position;
        }


        public View getView(int position, View convertView, ViewGroup parent) {
            ImageView imageView = new ImageView(context);
            // imageView.setImageResource(imageIDs[position]);
 
                imageView.setImageResource(imageIDs[position]);
                imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                imageView.setLayoutParams(new Gallery.LayoutParams(120, 80));
                imageView.setBackgroundResource(itemBackground);

       
            return imageView;
        }
    }

}