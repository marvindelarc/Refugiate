package com.refugiate.app.ui;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;

import com.refugiate.app.dao.clsConfiguracionSQL;
import com.refugiate.app.entidades.clsConfiguracion;
import com.refugiate.app.fragment.hoteles.FragmentListNombre;
import com.refugiate.app.fragment.hoteles.FragmentMapa;
import com.refugiate.app.fragment.cuenta.FragmentPerfil;
import com.refugiate.app.fragment.cuenta.FragmentRegistro;
import com.refugiate.app.fragment.cuenta.FragmentReservas;
import com.refugiate.app.utilidades.RecyclerView.Adapters.DrawerAdapter;
import com.refugiate.app.utilidades.RecyclerView.Classes.DrawerItem;
import com.refugiate.app.utilidades.RecyclerView.Utils.ItemClickSupport;


import java.util.ArrayList;


public class MainActivity extends  AppCompatActivity {

    FragmentManager fragmentManager;
    Toolbar toolbar;
    ActionBarDrawerToggle drawerToggle;
    DrawerLayout drawerLayout;
    View ViewSettingsIcon,ViewHelpIcon;
    TextView textViewName;
    FrameLayout  frameLayoutSetting1;
    RelativeLayout relativeLayoutScrollViewChild;
    ScrollView scrollViewNavigationDrawerContent;
    ViewTreeObserver viewTreeObserverNavigationDrawerScrollView;
    ViewTreeObserver.OnScrollChangedListener onScrollChangedListener;
    RecyclerView recyclerViewDrawer1, recyclerViewDrawer2, recyclerViewDrawerSettings;
    RecyclerView.Adapter drawerAdapter1, drawerAdapter2, drawerAdapterSettings;
    ArrayList<DrawerItem> drawerItems1, drawerItems2,  drawerItemsSettings;
    float drawerHeight, scrollViewHeight;
    LinearLayoutManager linearLayoutManager, linearLayoutManager2, linearLayoutManagerSettings;
    ItemClickSupport itemClickSupport1, itemClickSupport2,  itemClickSupportSettings;
    TypedValue typedValueColorPrimary, typedValueTextColorPrimary, typedValueTextColorControlHighlight, typedValueColorBackground;
    int colorPrimary, textColorPrimary, colorControlHighlight, colorBackground;
    public Menu mOptionsMenu=null;
    private int mapa=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setupNavigationDrawer();

        fragmentManager = this.getSupportFragmentManager();

        getitemClickSupport1(0);

    }




    public void setupNavigationDrawer() {

        // Setup Navigation drawer
        drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);

        // Setup Drawer Icon
        drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.drawer_open, R.string.drawer_close);
        drawerLayout.setDrawerListener(drawerToggle);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        drawerToggle.syncState();

        TypedValue typedValue = new TypedValue();
        MainActivity.this.getTheme().resolveAttribute(R.attr.colorPrimaryDark, typedValue, true);
        final int color = typedValue.data;
        drawerLayout.setStatusBarBackgroundColor(color);

        textViewName = (TextView ) findViewById(R.id.textViewName);

       // textViewName.setText("sss");


        ViewSettingsIcon = (View) findViewById(R.id.ViewSettingsIcon);
        ViewSettingsIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getItemClickSupportSettings(0);
            }
        });

        ViewHelpIcon = (View) findViewById(R.id.ViewHelpIcon);
        ViewHelpIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getItemClickSupportSettings(1);
            }
        });

            // Hide Settings and Feedback buttons when navigation drawer is scrolled
            hideNavigationDrawerSettingsAndFeedbackOnScroll();

            // Setup RecyclerViews inside drawer
            setupNavigationDrawerRecyclerViews();


        }



    private void hideNavigationDrawerSettingsAndFeedbackOnScroll() {

        scrollViewNavigationDrawerContent = (ScrollView) findViewById(R.id.scrollViewNavigationDrawerContent);
        relativeLayoutScrollViewChild = (RelativeLayout) findViewById(R.id.relativeLayoutScrollViewChild);
        frameLayoutSetting1 = (FrameLayout) findViewById(R.id.frameLayoutSettings1);

        viewTreeObserverNavigationDrawerScrollView = relativeLayoutScrollViewChild.getViewTreeObserver();

        if (viewTreeObserverNavigationDrawerScrollView.isAlive()) {
            viewTreeObserverNavigationDrawerScrollView.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
                @Override
                public void onGlobalLayout() {

                    if (Build.VERSION.SDK_INT > 16) {
                        relativeLayoutScrollViewChild.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                    } else {
                        relativeLayoutScrollViewChild.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    }

                    drawerHeight = relativeLayoutScrollViewChild.getHeight();
                    scrollViewHeight = scrollViewNavigationDrawerContent.getHeight();

                    if (drawerHeight > scrollViewHeight) {
                        frameLayoutSetting1.setVisibility(View.VISIBLE);
                    }

                    if (drawerHeight < scrollViewHeight) {
                        frameLayoutSetting1.setVisibility(View.GONE);
                    }
                }
            });
        }

        onScrollChangedListener = new ViewTreeObserver.OnScrollChangedListener() {
            @Override
            public void onScrollChanged() {

                scrollViewNavigationDrawerContent.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {

                        switch (event.getAction()) {
                            case MotionEvent.ACTION_MOVE:
                                if (scrollViewNavigationDrawerContent.getScrollY() != 0) {
                                    frameLayoutSetting1.animate().translationY(frameLayoutSetting1
                                            .getHeight()).setInterpolator(new AccelerateInterpolator(5f)).setDuration(400);
                                }
                                break;

                            case MotionEvent.ACTION_UP:
                                if (scrollViewNavigationDrawerContent.getScrollY() != 0) {
                                    frameLayoutSetting1.animate().translationY(frameLayoutSetting1
                                            .getHeight()).setInterpolator(new AccelerateInterpolator(5f)).setDuration(400);
                                }
                                break;
                        }
                        return false;
                    }
                });

                if (scrollViewNavigationDrawerContent.getScrollY() == 0) {
                    frameLayoutSetting1.animate().translationY(0)
                            .setInterpolator(new DecelerateInterpolator(5f)).setDuration(600);
                }
            }
        };

        scrollViewNavigationDrawerContent.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                ViewTreeObserver observer;
                switch (event.getAction()) {
                    case MotionEvent.ACTION_MOVE:
                        observer = scrollViewNavigationDrawerContent.getViewTreeObserver();
                        observer.addOnScrollChangedListener(onScrollChangedListener);
                        break;

                    case MotionEvent.ACTION_UP:
                        observer = scrollViewNavigationDrawerContent.getViewTreeObserver();
                        observer.addOnScrollChangedListener(onScrollChangedListener);
                        break;
                }

                return false;
            }
        });
    }

    private void setupNavigationDrawerRecyclerViews() {

        // RecyclerView 1
        recyclerViewDrawer1 = (RecyclerView) findViewById(R.id.recyclerViewDrawer1);
        linearLayoutManager = new LinearLayoutManager(MainActivity.this);
        recyclerViewDrawer1.setLayoutManager(linearLayoutManager);

        drawerItems1 = new ArrayList<>();
        drawerItems1.add(new DrawerItem(getResources().getDrawable(R.drawable.ic_action_nombre),this.getString(R.string.lbl_item_dw_1_1)));
        drawerItems1.add(new DrawerItem(getResources().getDrawable(R.drawable.ic_action_ubigeo), this.getString(R.string.lbl_item_dw_1_2)));
        drawerItems1.add(new DrawerItem(getResources().getDrawable(R.drawable.ic_action_mapa), this.getString(R.string.lbl_item_dw_1_3)));


        drawerAdapter1 = new DrawerAdapter(drawerItems1);
        recyclerViewDrawer1.setAdapter(drawerAdapter1);

        recyclerViewDrawer1.setMinimumHeight(convertDpToPx(144));
        recyclerViewDrawer1.setHasFixedSize(true);


        // RecyclerView 2
        recyclerViewDrawer2 = (RecyclerView) findViewById(R.id.recyclerViewDrawer2);
        linearLayoutManager2 = new LinearLayoutManager(MainActivity.this);
        recyclerViewDrawer2.setLayoutManager(linearLayoutManager2);

        drawerItems2 = new ArrayList<>();
        drawerItems2.add(new DrawerItem(getResources().getDrawable(R.drawable.ic_action_perfil), this.getString(R.string.lbl_item_dw_2_1)));
        drawerItems2.add(new DrawerItem(getResources().getDrawable(R.drawable.ic_action_reservas), this.getString(R.string.lbl_item_dw_2_2)));
        drawerItems2.add(new DrawerItem(getResources().getDrawable(R.drawable.ic_action_historial), this.getString(R.string.lbl_item_dw_2_3)));

        drawerAdapter2 = new DrawerAdapter(drawerItems2);
        recyclerViewDrawer2.setAdapter(drawerAdapter2);

        recyclerViewDrawer2.setMinimumHeight(convertDpToPx(144));
        recyclerViewDrawer2.setHasFixedSize(true);



        // RecyclerView Settings
        recyclerViewDrawerSettings = (RecyclerView) findViewById(R.id.recyclerViewDrawerSettings);
        linearLayoutManagerSettings = new LinearLayoutManager(MainActivity.this);
        recyclerViewDrawerSettings.setLayoutManager(linearLayoutManagerSettings);

        drawerItemsSettings = new ArrayList<>();
        drawerItemsSettings.add(new DrawerItem(getResources().getDrawable(R.drawable.ic_action_action_settings),this.getString(R.string.action_settings)));
        drawerItemsSettings.add(new DrawerItem(getResources().getDrawable(R.drawable.ic_action_action_help),this.getString(R.string.action_about)));

        drawerAdapterSettings = new DrawerAdapter(drawerItemsSettings);
        recyclerViewDrawerSettings.setAdapter(drawerAdapterSettings);






        recyclerViewDrawerSettings.setMinimumHeight(convertDpToPx(96));
        recyclerViewDrawerSettings.setHasFixedSize(true);

        // Why have I to calc recyclerView height?
        // Because recyclerView at this moment doesn't support wrap_content, this cause an height of 0 px

        // Get colorPrimary, textColorPrimary, colorControlHighlight and background to apply to selected items
        typedValueColorPrimary = new TypedValue();
        getTheme().resolveAttribute(R.attr.colorPrimary, typedValueColorPrimary, true);
        colorPrimary = typedValueColorPrimary.data;

        typedValueTextColorPrimary = new TypedValue();
        getTheme().resolveAttribute(android.R.attr.textColorPrimary, typedValueTextColorPrimary, true);
        textColorPrimary = typedValueTextColorPrimary.data;

        typedValueTextColorControlHighlight = new TypedValue();
        getTheme().resolveAttribute(R.attr.colorControlHighlight, typedValueTextColorControlHighlight, true);
        colorControlHighlight = typedValueTextColorControlHighlight.data;

        typedValueColorBackground = new TypedValue();
        getTheme().resolveAttribute(android.R.attr.colorBackground, typedValueColorBackground, true);
        colorBackground = typedValueColorBackground.data;

        // Set icons alpha at start
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                // Do something after some time
                for (int i = 0; i < recyclerViewDrawer1.getChildCount(); i++) {
                    ImageView imageViewDrawerItemIcon = (ImageView) recyclerViewDrawer1.getChildAt(i).findViewById(R.id.imageViewDrawerItemIcon);
                    TextView textViewDrawerItemTitle = (TextView) recyclerViewDrawer1.getChildAt(i).findViewById(R.id.textViewDrawerItemTitle);
                    LinearLayout linearLayoutItem = (LinearLayout) recyclerViewDrawer1.getChildAt(i).findViewById(R.id.linearLayoutItem);
                    if (i == 0) {
                        imageViewDrawerItemIcon.setColorFilter(colorPrimary);
                        if (Build.VERSION.SDK_INT > 15) {
                            imageViewDrawerItemIcon.setImageAlpha(255);
                        } else {
                            imageViewDrawerItemIcon.setAlpha(255);
                        }
                        textViewDrawerItemTitle.setTextColor(colorPrimary);
                        linearLayoutItem.setBackgroundColor(colorControlHighlight);
                    } else {
                        imageViewDrawerItemIcon.setColorFilter(textColorPrimary);
                        if (Build.VERSION.SDK_INT > 15) {
                            imageViewDrawerItemIcon.setImageAlpha(138);
                        } else {
                            imageViewDrawerItemIcon.setAlpha(138);
                        }
                        textViewDrawerItemTitle.setTextColor(textColorPrimary);
                        linearLayoutItem.setBackgroundColor(colorBackground);
                    }
                }
                for (int i = 0; i < recyclerViewDrawer2.getChildCount(); i++) {
                    ImageView imageViewDrawerItemIcon = (ImageView) recyclerViewDrawer2.getChildAt(i).findViewById(R.id.imageViewDrawerItemIcon);
                    TextView textViewDrawerItemTitle = (TextView) recyclerViewDrawer2.getChildAt(i).findViewById(R.id.textViewDrawerItemTitle);
                    LinearLayout linearLayoutItem = (LinearLayout) recyclerViewDrawer2.getChildAt(i).findViewById(R.id.linearLayoutItem);
                    imageViewDrawerItemIcon.setColorFilter(textColorPrimary);
                    if (Build.VERSION.SDK_INT > 15) {
                        imageViewDrawerItemIcon.setImageAlpha(138);
                    } else {
                        imageViewDrawerItemIcon.setAlpha(138);
                    }
                    textViewDrawerItemTitle.setTextColor(textColorPrimary);
                    linearLayoutItem.setBackgroundColor(colorBackground);
                }

                for (int i = 0; i < recyclerViewDrawerSettings.getChildCount(); i++) {
                    ImageView imageViewDrawerItemIcon = (ImageView) recyclerViewDrawerSettings.getChildAt(i).findViewById(R.id.imageViewDrawerItemIcon);
                    TextView textViewDrawerItemTitle = (TextView) recyclerViewDrawerSettings.getChildAt(i).findViewById(R.id.textViewDrawerItemTitle);
                    LinearLayout linearLayoutItem = (LinearLayout) recyclerViewDrawerSettings.getChildAt(i).findViewById(R.id.linearLayoutItem);
                    imageViewDrawerItemIcon.setColorFilter(textColorPrimary);
                    if (Build.VERSION.SDK_INT > 15) {
                        imageViewDrawerItemIcon.setImageAlpha(138);
                    } else {
                        imageViewDrawerItemIcon.setAlpha(138);
                    }
                    textViewDrawerItemTitle.setTextColor(textColorPrimary);
                    linearLayoutItem.setBackgroundColor(colorBackground);
                }

                ImageView imageViewSettingsIcon = (ImageView) findViewById(R.id.imageViewSettingsIcon);
                TextView textViewSettingsTitle = (TextView) findViewById(R.id.textViewSettingsTitle);
                imageViewSettingsIcon.setColorFilter(textColorPrimary);
                if (Build.VERSION.SDK_INT > 15) {
                    imageViewSettingsIcon.setImageAlpha(138);
                } else {
                    imageViewSettingsIcon.setAlpha(138);
                }
                textViewSettingsTitle.setTextColor(textColorPrimary);
                ImageView imageViewHelpIcon = (ImageView) findViewById(R.id.imageViewHelpIcon);
                TextView textViewHelpTitle = (TextView) findViewById(R.id.textViewHelpTitle);
                imageViewHelpIcon.setColorFilter(textColorPrimary);
                if (Build.VERSION.SDK_INT > 15) {
                    imageViewHelpIcon.setImageAlpha(138);
                } else {
                    imageViewHelpIcon.setAlpha(138);
                }
                textViewHelpTitle.setTextColor(textColorPrimary);
            }
        }, 250);

        itemClickSupport1 = ItemClickSupport.addTo(recyclerViewDrawer1);
        itemClickSupport1.setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
            @Override
            public void onItemClick(RecyclerView parent, View view, int position, long id) {
                for (int i = 0; i < recyclerViewDrawer1.getChildCount(); i++) {
                    ImageView imageViewDrawerItemIcon = (ImageView) recyclerViewDrawer1.getChildAt(i).findViewById(R.id.imageViewDrawerItemIcon);
                    TextView textViewDrawerItemTitle = (TextView) recyclerViewDrawer1.getChildAt(i).findViewById(R.id.textViewDrawerItemTitle);
                    LinearLayout linearLayoutItem = (LinearLayout) recyclerViewDrawer1.getChildAt(i).findViewById(R.id.linearLayoutItem);
                    if (i == position) {
                        imageViewDrawerItemIcon.setColorFilter(colorPrimary);
                        if (Build.VERSION.SDK_INT > 15) {
                            imageViewDrawerItemIcon.setImageAlpha(255);
                        } else {
                            imageViewDrawerItemIcon.setAlpha(255);
                        }
                        textViewDrawerItemTitle.setTextColor(colorPrimary);
                        linearLayoutItem.setBackgroundColor(colorControlHighlight);
                    } else {
                        imageViewDrawerItemIcon.setColorFilter(textColorPrimary);
                        if (Build.VERSION.SDK_INT > 15) {
                            imageViewDrawerItemIcon.setImageAlpha(138);
                        } else {
                            imageViewDrawerItemIcon.setAlpha(138);
                        }
                        textViewDrawerItemTitle.setTextColor(textColorPrimary);
                        linearLayoutItem.setBackgroundColor(colorBackground);
                    }
                }
                for (int i = 0; i < recyclerViewDrawer2.getChildCount(); i++) {
                    ImageView imageViewDrawerItemIcon = (ImageView) recyclerViewDrawer2.getChildAt(i).findViewById(R.id.imageViewDrawerItemIcon);
                    TextView textViewDrawerItemTitle = (TextView) recyclerViewDrawer2.getChildAt(i).findViewById(R.id.textViewDrawerItemTitle);
                    LinearLayout linearLayoutItem = (LinearLayout) recyclerViewDrawer2.getChildAt(i).findViewById(R.id.linearLayoutItem);
                    imageViewDrawerItemIcon.setColorFilter(textColorPrimary);
                    if (Build.VERSION.SDK_INT > 15) {
                        imageViewDrawerItemIcon.setImageAlpha(138);
                    } else {
                        imageViewDrawerItemIcon.setAlpha(138);
                    }
                    textViewDrawerItemTitle.setTextColor(textColorPrimary);
                    linearLayoutItem.setBackgroundColor(colorBackground);
                }

                getitemClickSupport1(position);
            }
        });

        itemClickSupport2 = ItemClickSupport.addTo(recyclerViewDrawer2);
        itemClickSupport2.setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
            @Override
            public void onItemClick(RecyclerView parent, View view, int position, long id) {
                for (int i = 0; i < recyclerViewDrawer2.getChildCount(); i++) {
                    ImageView imageViewDrawerItemIcon = (ImageView) recyclerViewDrawer2.getChildAt(i).findViewById(R.id.imageViewDrawerItemIcon);
                    TextView textViewDrawerItemTitle = (TextView) recyclerViewDrawer2.getChildAt(i).findViewById(R.id.textViewDrawerItemTitle);
                    LinearLayout linearLayoutItem = (LinearLayout) recyclerViewDrawer2.getChildAt(i).findViewById(R.id.linearLayoutItem);
                    if (i == position) {
                        imageViewDrawerItemIcon.setColorFilter(colorPrimary);
                        if (Build.VERSION.SDK_INT > 15) {
                            imageViewDrawerItemIcon.setImageAlpha(255);
                        } else {
                            imageViewDrawerItemIcon.setAlpha(255);
                        }
                        textViewDrawerItemTitle.setTextColor(colorPrimary);
                        linearLayoutItem.setBackgroundColor(colorControlHighlight);
                    } else {
                        imageViewDrawerItemIcon.setColorFilter(textColorPrimary);
                        if (Build.VERSION.SDK_INT > 15) {
                            imageViewDrawerItemIcon.setImageAlpha(138);
                        } else {
                            imageViewDrawerItemIcon.setAlpha(138);
                        }
                        textViewDrawerItemTitle.setTextColor(textColorPrimary);
                        linearLayoutItem.setBackgroundColor(colorBackground);
                    }
                }
                for (int i = 0; i < recyclerViewDrawer1.getChildCount(); i++) {
                    ImageView imageViewDrawerItemIcon = (ImageView) recyclerViewDrawer1.getChildAt(i).findViewById(R.id.imageViewDrawerItemIcon);
                    TextView textViewDrawerItemTitle = (TextView) recyclerViewDrawer1.getChildAt(i).findViewById(R.id.textViewDrawerItemTitle);
                    LinearLayout linearLayoutItem = (LinearLayout) recyclerViewDrawer1.getChildAt(i).findViewById(R.id.linearLayoutItem);
                    imageViewDrawerItemIcon.setColorFilter(textColorPrimary);
                    if (Build.VERSION.SDK_INT > 15) {
                        imageViewDrawerItemIcon.setImageAlpha(138);
                    } else {
                        imageViewDrawerItemIcon.setAlpha(138);
                    }
                    textViewDrawerItemTitle.setTextColor(textColorPrimary);
                    linearLayoutItem.setBackgroundColor(colorBackground);
                }

                getitemClickSupport2(position);
            }
        });

        itemClickSupportSettings = ItemClickSupport.addTo(recyclerViewDrawerSettings);
        itemClickSupportSettings.setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
            @Override
            public void onItemClick(RecyclerView parent, View view, int position, long id) {
                getItemClickSupportSettings(position);
            }
        });
    }



    public int convertDpToPx(int dp) {
        // Get the screen's density scale
        final float scale = getResources().getDisplayMetrics().density;
        // Convert the dps to pixels, based on density scale
        return (int) (dp * scale + 0.5f);
    }


    public void setFragment(Fragment fragment)    {



        fragmentManager.beginTransaction()
                .replace(R.id.content_frame, fragment)
                .commit();
        drawerLayout.closeDrawers();
    }

    public void getItemClickSupportSettings(int pos)
    {
        final Dialog dialog;
        drawerLayout.closeDrawers();
        switch (pos)
        {
            case 0:
               dialog = new Dialog(this);
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setContentView(R.layout.dialog_configuracion);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
                final Spinner ComboTiempoActulizacion = (Spinner)dialog.findViewById(R.id.ComboTiempoActulizacion);
                final Spinner ComboTiempoPrevioReserva = (Spinner)dialog.findViewById(R.id.ComboTiempoPrevioReserva);
                final Spinner ComboTipoPropagandas = (Spinner)dialog.findViewById(R.id.ComboTipoPropagandas);
                final Spinner ComboRepetirTiempo = (Spinner)dialog.findViewById(R.id.ComboRepetirTiempo);
                final View ViewChbRepetir = (View)dialog.findViewById(R.id.ViewChbRepetir);
                final CheckBox chbRepetir = (CheckBox)dialog.findViewById(R.id.chbRepetir);
                final clsConfiguracion objConfiguracion= clsConfiguracionSQL.Buscar(this);

                String[] itensActulizacion=getResources().getStringArray(R.array.array_configuracion_tiempo_actulizacion);
                ArrayAdapter<String> adapterActulizacion = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,itensActulizacion);
                adapterActulizacion.setDropDownViewResource(android.R.layout.simple_list_item_checked);
                ComboTiempoActulizacion.setAdapter(adapterActulizacion);
                ComboTiempoActulizacion.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//               tipoHabitacion=itens.get(position);
                        if (position == 0)
                            objConfiguracion.setTiempo_actulizacion(1);
                        else if (position == 1)
                            objConfiguracion.setTiempo_actulizacion(3);
                        else if (position == 2)
                            objConfiguracion.setTiempo_actulizacion(6);
                        else if (position == 3)
                            objConfiguracion.setTiempo_actulizacion(12);
                        else if (position == 4)
                            objConfiguracion.setTiempo_actulizacion(24);
                    }

                    public void onNothingSelected(AdapterView<?> parent) {
                        //User selected same item. Nothing to do.
                    }
                });
                if(objConfiguracion.getTiempo_actulizacion()==1)
                    ComboTiempoActulizacion.setSelection(0);
                else if(objConfiguracion.getTiempo_actulizacion()==3)
                    ComboTiempoActulizacion.setSelection(1);
                else if(objConfiguracion.getTiempo_actulizacion()==6)
                    ComboTiempoActulizacion.setSelection(2);
                else if(objConfiguracion.getTiempo_actulizacion()==12)
                    ComboTiempoActulizacion.setSelection(3);
                else if(objConfiguracion.getTiempo_actulizacion()==24)
                    ComboTiempoActulizacion.setSelection(4);


                String[] itensTiempoPrevioReserva=getResources().getStringArray(R.array.array_configuracion_tiempo_reserva);
                ArrayAdapter<String> adapterTiempoPrevioReserva = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,itensTiempoPrevioReserva);
                adapterTiempoPrevioReserva.setDropDownViewResource(android.R.layout.simple_list_item_checked);
                ComboTiempoPrevioReserva.setAdapter(adapterTiempoPrevioReserva);
                ComboTiempoPrevioReserva.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        objConfiguracion.setTiempo_previo_reserva(position + 1);
                    }

                    public void onNothingSelected(AdapterView<?> parent) {
                        //User selected same item. Nothing to do.
                    }
                });

                ComboTiempoPrevioReserva.setSelection(objConfiguracion.getTiempo_previo_reserva() - 1);


                String[] itensTipoPropagandas=getResources().getStringArray(R.array.array_configuracion_tipo_propaganda);
                ArrayAdapter<String> adapterTipoPropagandas = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,itensTipoPropagandas);
                adapterTipoPropagandas.setDropDownViewResource(android.R.layout.simple_list_item_checked);
                ComboTipoPropagandas.setAdapter(adapterTipoPropagandas);
                ComboTipoPropagandas.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        objConfiguracion.setTipo_propagandas(position + 1);
                    }

                    public void onNothingSelected(AdapterView<?> parent) {
                        //User selected same item. Nothing to do.
                    }
                });
                ComboTipoPropagandas.setSelection(objConfiguracion.getTipo_propagandas()-1);


                String[] itensRepetirTiempo=getResources().getStringArray(R.array.array_configuracion_tiempo_repetir);
                ArrayAdapter<String> adapterRepetirTiempo = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,itensRepetirTiempo);
                adapterRepetirTiempo.setDropDownViewResource(android.R.layout.simple_list_item_checked);
                ComboRepetirTiempo.setAdapter(adapterRepetirTiempo);
                ComboRepetirTiempo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        objConfiguracion.setRepetir_tiempo(position + 1);

                    }

                    public void onNothingSelected(AdapterView<?> parent) {
                        //User selected same item. Nothing to do.
                    }
                });

                ComboRepetirTiempo.setSelection(objConfiguracion.getRepetir_tiempo() - 1);

                chbRepetir.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (chbRepetir.isChecked()) {
                            ComboRepetirTiempo.setEnabled(true);
                            ViewChbRepetir.setVisibility(View.VISIBLE);
                            objConfiguracion.setRepetir(1);
                        } else {
                            ComboRepetirTiempo.setEnabled(false);
                            ViewChbRepetir.setVisibility(View.GONE);
                            objConfiguracion.setRepetir(2);
                        }
                    }
                });
                if( objConfiguracion.getRepetir()==1) {
                    ComboRepetirTiempo.setEnabled(true);
                    ViewChbRepetir.setVisibility(View.VISIBLE);
                    chbRepetir.setChecked(true);
                }
                else if( objConfiguracion.getRepetir()==2) {
                    chbRepetir.setChecked(false);
                    ComboRepetirTiempo.setEnabled(false);
                    ViewChbRepetir.setVisibility(View.GONE);
                }



                Button btnAceptar = (Button) dialog.findViewById(R.id.btnAceptar);
                btnAceptar.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                        clsConfiguracionSQL.Agregar(MainActivity.this, objConfiguracion);
                    }
                });


                dialog.show();
                break;
            case 1:


                dialog = new Dialog(this);
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
                //dialog.setCancelable(false);
                dialog.setContentView(R.layout.dialog_calificacion);
                /*Button btnCancelarAbaut = (Button) dialog.findViewById(R.id.btnCancelarAbaut);
                btnCancelarAbaut.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });*/
                dialog.show();

                break;
            default:
                break;
        }
    }

    public void getitemClickSupport1(int position)
    {
        if(mOptionsMenu!=null)
            mOptionsMenu.getItem(0).setVisible(false);
        switch (position) {
            case 0:
                mapa=1;
                setFragment(new FragmentListNombre());
                //setFragment(new FragmentTab1());

                break;
            case 1:
                mapa=0;
                setFragment(new FragmentMapa());

                break;
            case 2:
                //setFragment(new FragmentTelefono());

                break;
            default:
                break;
        }
    }

    public void getitemClickSupport2(int position)
    {
        if(mOptionsMenu!=null)
            mOptionsMenu.getItem(0).setVisible(false);
        switch (position)
        {
            case 0:
                setFragment(new FragmentPerfil());
                break;
            case 1:
                setFragment(new FragmentReservas());
                break;
            case 2:
                setFragment(new FragmentRegistro());
                //setFragment(new FragmentHistorial());
                break;
            default:
                break;
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event)
    {
        if (keyCode == KeyEvent.KEYCODE_BACK)
        {

            Fragment currentFrag =  getSupportFragmentManager().findFragmentById(R.id.content_frame);
            if (currentFrag!=null) {
                switch (currentFrag.getClass().getSimpleName())
                {
                    case "FragmentMapa":
                    case "FragmentListNombre":
                        this.finish();
                        break;
                    case "FragmentTab1":
                    case "FragmentTab2":
                    case "FragmentTab3":
                    case "FragmentTab4":
                    case "FragmentTab5":
                        if(mapa==0)
                        setFragment(new FragmentMapa());
                        else
                        setFragment(new FragmentListNombre());
                        mOptionsMenu.getItem(0).setVisible(false);
                        break;
                    default:
                        break;
                }
            }
           // this.finish();
                return false;
        }

        return super.onKeyDown(keyCode, event);
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        mOptionsMenu=menu;
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.telefono:
                /*
                clsSucursal objSucural= clsSucursalSQL.getSeleccionado(this);
                if(objSucural!=null)
                    if(!objSucural.getTelefono().equals("") && !objSucural.getTelefono().equals(null)) {
                        Intent intent = new Intent(Intent.ACTION_CALL);
                        intent.setData(Uri.parse("tel:" + objSucural.getTelefono()));
                        startActivity(intent);
                    }*/
                return true;
            case R.id.compartir:
                Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
                sharingIntent.setType("text/plain");
                sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, getString(R.string.compartir_sms));
                startActivity(Intent.createChooser(sharingIntent,getString(R.string.compartir_via)));

                return true;
            default:
                return super.onOptionsItemSelected(item);

        }
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        // TODO Auto-generated method stub
            menu.getItem(0).setVisible(false);
        return super.onPrepareOptionsMenu(menu);
    }

}


