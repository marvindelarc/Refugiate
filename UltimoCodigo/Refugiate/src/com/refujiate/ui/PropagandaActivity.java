/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.refujiate.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 *
 * @author Paulo
 */
public class PropagandaActivity extends Activity {

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
         setContentView(R.layout.activity_propaganda);
        
    }
    
    public void btnCerrar(View e)
    {
         Intent i=new Intent(this,MainMapaActivity.class);
        startActivity(i); 
        
    }
}
