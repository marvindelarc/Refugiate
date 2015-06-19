package com.refugiate.app.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class SQLite extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "GipBD"; 
    private static final int DATABASE_VERSION = 1;        

          private static final String CREATE_GIP_Usuario = "CREATE TABLE GIP_Usuario ("
                                + "pk_id integer NOT NULL PRIMARY KEY,"
                                + "voz integer ,"
                                + "mail integer)";
	 
	  private static final String CREATE_GIP_HechoPublico = "CREATE TABLE GIP_HechoPublico ("
                                + "pk_id integer NOT NULL PRIMARY KEY,"
                                + "TipoHechoPublico integer ,"
                                + "detalle text ,"
                                + "longitud numeric ,"
				+ "latitud numeric ,"
                                + "imagen blob)";

          private static final String CREATE_GIP_Inmueble = "CREATE TABLE GIP_Inmueble ("
                                + "pk_id integer NOT NULL PRIMARY KEY,"
                                + "direccion text ,"
                                + "color text ,"
                                + "detalle text )";
          
          private static final String CREATE_GIP_Persona = "CREATE TABLE GIP_Persona ("
                                + "pk_id integer NOT NULL PRIMARY KEY,"
                                + "nombres text ,"
                                + "apellidos text ,"
                                + "apelativos text ,"
                                + "detalle text )";
          private static final String CREATE_GIP_Vehiculo = "CREATE TABLE GIP_Vehiculo ("
                                + "pk_id integer NOT NULL PRIMARY KEY,"
                                + "TipoVehiculo integer ,"
                                + "modelo text ,"
                                + "marca text ,"
                                + "placa text ,"
                                + "color text ,"
                                + "detalle text )";
         
	public SQLite(Context context, CursorFactory factory) {
		super(context, DATABASE_NAME, factory, DATABASE_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
                db.execSQL(CREATE_GIP_Usuario);  
                db.execSQL(CREATE_GIP_HechoPublico);  
                db.execSQL(CREATE_GIP_Inmueble);        
                db.execSQL(CREATE_GIP_Persona);        
                db.execSQL(CREATE_GIP_Vehiculo);        
        }   
         
	@Override
	public void onUpgrade(SQLiteDatabase db, int versionAnte, int versionNue) {
                db.execSQL("drop table if exists GIP_Usuario");
                db.execSQL(CREATE_GIP_Usuario);
                db.execSQL("drop table if exists GIP_HechoPublico");
                db.execSQL(CREATE_GIP_HechoPublico);
                db.execSQL("drop table if exists GIP_Inmueble");
                db.execSQL(CREATE_GIP_Inmueble);
                db.execSQL("drop table if exists GIP_Persona");
                db.execSQL(CREATE_GIP_Persona);
                db.execSQL("drop table if exists GIP_Vehiculo");
                db.execSQL(CREATE_GIP_Vehiculo);    
	}	
        
}