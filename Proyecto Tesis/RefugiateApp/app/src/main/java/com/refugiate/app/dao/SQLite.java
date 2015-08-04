package com.refugiate.app.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class SQLite extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "RefugiateBD";
    private static final int DATABASE_VERSION = 1;

    private static final String CREATE_SESION = "CREATE TABLE SESION ("
            + "idSesion integer NOT NULL PRIMARY KEY,"
            + "fecha numeric ,"
            + "minutos integer )";

    private static final String CREATE_EMPRESA = "CREATE TABLE EMPRESA ("
                                + "idEmpresa integer NOT NULL PRIMARY KEY,"
                                + "nombreComercial text ,"
                                + "nombre text ,"
                                + "slogan text ,"
                                + "ruc text ,"
                                + "puntos integer ,"
                                + "estado integer ,"
                                + "logo blob ,"
                                + "banner blob)";


	private static final String CREATE_SUCURSAL = "CREATE TABLE SUCURSAL ("
                                + "idSucursal integer NOT NULL PRIMARY KEY,"
                                + "direccion text ,"
                                + "pisos numeric ,"
                                + "telefono text ,"
                                + "longitud numeric ,"
				                + "latitud numeric ,"
                                  + "limpieza integer ,"
                                  + "servicio integer ,"
                                  + "comodidad integer ,"
                                  + "puntuacion integer ,"
                                  + "nivel integer ,"
                                  + "entrada text ,"
                                  + "estado integer ,"
                                  + "int_id_distrito integer ,"
                                  + "idEmpresa integer)";

	public SQLite(Context context, CursorFactory factory) {
		super(context, DATABASE_NAME, factory, DATABASE_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
                db.execSQL(CREATE_SESION);
                db.execSQL(CREATE_EMPRESA);
                db.execSQL(CREATE_SUCURSAL);
        }   
         
	@Override
	public void onUpgrade(SQLiteDatabase db, int versionAnte, int versionNue) {
                db.execSQL("drop table if exists SESION");
                db.execSQL(CREATE_SESION);
                db.execSQL("drop table if exists EMPRESA");
                db.execSQL(CREATE_EMPRESA);
                db.execSQL("drop table if exists SUCURSAL");
                db.execSQL(CREATE_SUCURSAL);
	}	
        
}