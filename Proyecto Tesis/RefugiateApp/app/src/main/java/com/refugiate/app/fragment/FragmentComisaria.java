package com.refugiate.app.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

import com.refugiate.app.ui.R;
import com.refugiate.app.utilidades.Utilidades;

/**
 * Created by RFERNANDEZ on 08/06/2015.
 */
public class FragmentComisaria extends Fragment {

    WebView url;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.fragment_comisarias, container, false);
        url=(WebView)view.findViewById(R.id.wvmap);
        url.setWebViewClient(new WebViewClient());
        WebSettings webSettings = url.getSettings();
        webSettings.setJavaScriptEnabled(true);
        url.loadUrl("https://mapsengine.google.com/map/embed?mid=zVIEgrx0IUV4.k5LLflG7ucOQ");
        url.setWebViewClient(new WebViewClient());


        return view;
    }
}
