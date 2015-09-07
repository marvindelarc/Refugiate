package com.refugiate.app.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class SQLite extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "RefugiateBD";
    private static final int DATABASE_VERSION = 1;

    private static final String CREATE_CONFIGURACION = "CREATE TABLE CONFIGURACION ("
            + "idConfiguracion integer NOT NULL PRIMARY KEY,"
            + "tiempo_actulizacion,"
            + "tiempo_actualizacion,"
            + "tiempo_previo_reserva,"
            + "repetir integer,"
            + "repetir_tiempo integer,"
            + "tipo_propagandas integer)";

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
                                 + "paquete integer ,"
                                  + "puntuacion integer ,"
                                  + "nivel integer ,"
                                  + "entrada text ,"
                                  + "estado integer ,"
                                  + "int_id_distrito integer ,"
                                  + "idEmpresa integer)";

    private static final String CREATE_SERVICIO = "CREATE TABLE SERVICIO ("
                                + "idServicio integer NOT NULL PRIMARY KEY,"
                                + "nombre text)";

    private static final String CREATE_INSTALACION = "CREATE TABLE INSTALACION ("
                            + "idInstalacion integer NOT NULL PRIMARY KEY,"
                            + "descripcion text ,"
                            + "idServicio integer ,"
                            + "idSucursal integer)";

    private static final String CREATE_COSTOTIPOHABITACION = "CREATE TABLE COSTOTIPOHABITACION ("
                            + "idCostoTipoHabitacion integer NOT NULL PRIMARY KEY,"
                            + "costo numeric ,"
                            + "numeroPersonas integer ,"
                            + "totalHabitaciones integer ,"
                            + "habitacionesOcupadas integer ,"
                            + "estado integer ,"
                            + "idTipoHabitacion integer ,"
                            + "idSucursal integer)";

    private static final String CREATE_TIPOHABITACION = "CREATE TABLE TIPOHABITACION ("
            + "idTipoHabitacion integer NOT NULL PRIMARY KEY,"
            + "nombreComercial text)";

    private static final String CREATE_DEPARTAMENTO = "CREATE TABLE DEPARTAMENTO ("
            + "int_id_depatamento integer NOT NULL PRIMARY KEY,"
            + "str_nombre text)";

    private static final String CREATE_PROVINCIA = "CREATE TABLE PROVINCIA ("
            + "int_id_provincia integer NOT NULL PRIMARY KEY,"
            + "int_id_depatamento integer ,"
            + "str_nombre text)";

    private static final String CREATE_DISTRITO = "CREATE TABLE DISTRITO ("
            + "int_id_distrito integer NOT NULL PRIMARY KEY,"
            + "int_id_provincia integer ,"
            + "str_nombre text)";

    private static final String CREATE_PERSONA = "CREATE TABLE PERSONA ("
            + "IdPersona integer NOT NULL PRIMARY KEY,"
            + "nombre text ,"
            + "apellido text ,"
            + "telefono text ,"
            + "email text ,"
            + "DNI text ,"
            + "fecnac numeric ,"
            + "sexo integer ,"
            + "usuario text ,"
            + "password text)";

    private static final String CREATE_HABITACION = "CREATE TABLE HABITACION ("
            + "idHabitacion integer NOT NULL PRIMARY KEY,"
            + "numero integer ,"
            + "piso integer ,"
            + "estado integer ,"
            + "vista integer ,"
            + "idCostoTipoHabitacion integer)";

    private static final String CREATE_RESERVA = "CREATE TABLE RESERVA ("
            + "idReserva integer NOT NULL PRIMARY KEY,"
            + "fechaResgistro numeric ,"
            + "fechaIngreso numeric ,"
            + "fechaEgreso numeric ,"
            + "estado integer ,"
            + "dias integer ,"
            + "costo numeric ,"
            + "servicio integer ,"
            + "comodidad integer ,"
            + "limpieza integer ,"
            + "comentario text ,"
            + "vista integer ,"
            + "numero integer ,"
            + "piso integer ,"
            + "idHabitacion integer ,"
            + "idCostoTipoHabitacion integer)";

	public SQLite(Context context, CursorFactory factory) {
		super(context, DATABASE_NAME, factory, DATABASE_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
                db.execSQL(CREATE_CONFIGURACION);
                db.execSQL(CREATE_EMPRESA);
                db.execSQL(CREATE_SUCURSAL);
                db.execSQL(CREATE_SERVICIO);
                db.execSQL(CREATE_INSTALACION);
                db.execSQL(CREATE_COSTOTIPOHABITACION);
                db.execSQL(CREATE_TIPOHABITACION);
                db.execSQL(CREATE_PERSONA);
                db.execSQL(CREATE_DEPARTAMENTO);
                db.execSQL(CREATE_PROVINCIA);
                db.execSQL(CREATE_DISTRITO);
                db.execSQL(CREATE_HABITACION);
                db.execSQL(CREATE_RESERVA);

        }
         
	@Override
	public void onUpgrade(SQLiteDatabase db, int versionAnte, int versionNue) {
                db.execSQL("drop table if exists CONFIGURACION");
                db.execSQL(CREATE_CONFIGURACION);
                db.execSQL("drop table if exists EMPRESA");
                db.execSQL(CREATE_EMPRESA);
                db.execSQL("drop table if exists SUCURSAL");
                db.execSQL(CREATE_SUCURSAL);
                db.execSQL("drop table if exists SERVICIO");
                db.execSQL(CREATE_SERVICIO);
                db.execSQL("drop table if exists COSTOTIPOHABITACION");
                db.execSQL(CREATE_COSTOTIPOHABITACION);
                db.execSQL("drop table if exists TIPOHABITACION");
                db.execSQL(CREATE_TIPOHABITACION);
                db.execSQL("drop table if exists PERSONA");
                db.execSQL(CREATE_PERSONA);
                db.execSQL("drop table if exists DEPARTAMENTO");
                db.execSQL(CREATE_DEPARTAMENTO);
                db.execSQL("drop table if exists PROVINCIA");
                db.execSQL(CREATE_PROVINCIA);
                db.execSQL("drop table if exists DISTRITO");
                db.execSQL(CREATE_DISTRITO);
                db.execSQL("drop table if exists HABITACION");
                db.execSQL(CREATE_HABITACION);
                db.execSQL("drop table if exists RESERVA");
                db.execSQL(CREATE_RESERVA);
	}
        
}