package com.refugiate.app.fragment;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.refugiate.app.ui.R;

/**
 * Created by RFERNANDEZ on 08/06/2015.
 */
public class FragmentReniec extends Fragment {

    WebView url;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.fragment_reniec, container, false);
        url=(WebView)view.findViewById(R.id.wvmap);
        url.setWebViewClient(new WebViewClient());
        WebSettings webSettings = url.getSettings();
        webSettings.setJavaScriptEnabled(true);
        url.loadUrl("https://cel.reniec.gob.pe/valreg/valreg.do?accion=ini");
        url.setWebViewClient(new WebViewClient());
        return view;
    }
}
