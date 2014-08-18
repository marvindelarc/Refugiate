package com.refujiate.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class clsSQLite extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "REFUGIATE"; 
    private static final int DATABASE_VERSION = 1;       
    private static final String CREATE_USUARIO = "CREATE TABLE usuario (int_IdPersona integer NOT NULL PRIMARY KEY,"
                        + "str_Nombre text NOT NULL,"
                        + "str_Apellido text NOT NULL,"
                        + "str_Telefono text NOT NULL,"
                        + "str_Email text NOT NULL,"
                        + "str_Usuario text NOT NULL,"
                        + "str_Password text NOT NULL,"
                        + "str_DNI text NOT NULL);";
    
    private static final String CREATE_HOTEL = "CREATE TABLE hotel (int_IdHotel integer NOT NULL PRIMARY KEY,"
                        + "int_Estrellas integer NOT NULL,"
                        + "str_Nombre text NOT NULL,"
                        + "dou_Longitud numeric NOT NULL,"
                        + "dou_Latitud numeric NOT NULL,"
                        + "int_Tipo integer NOT NULL,"
                        + "int_Puntos integer NOT NULL);";
    
    private static final String CREATE_INSTALACION = "CREATE TABLE instalacion (int_IdIntalacion integer NOT NULL PRIMARY KEY,"
                        + "int_IdServicio integer NOT NULL,"
                        + "int_IdSucursal text NOT NULL,"
                        + "str_Nombre numeric NOT NULL,"
                        + "str_Descripcion integer NOT NULL);";
       
    private static final String CREATE_TIPO_HABITACION = "CREATE TABLE tipo_habitacion (int_idTipoHabitacion integer NOT NULL PRIMARY KEY,"
                        + "int_idHabitacion integer NOT NULL,"
                        + "str_Nombre text NOT NULL,"
                        + "int_idSucursal integer NOT NULL);";
    
    private static final String CREATE_CONFIGURACION = "CREATE TABLE configuracion (int_IdConfiguracion integer NOT NULL PRIMARY KEY,"
                        + "int_tiempo_actulizacion integer NOT NULL,"
                        + "dat_tiempo_actualizacion numeric NOT NULL,"
                        + "int_tiempo_previo_reserva integer NOT NULL,"
                        + "int_repetir integer NOT NULL,"
                        + "int_repetir_tiempo integer NOT NULL,"
                        + "int_tipo_propagandas integer NOT NULL);";
    
     private static final String CREATE_DETALLE_RESERVA = "CREATE TABLE detalle_reserva (int_IdDetalleReserva integer NOT NULL PRIMARY KEY,"
                        + "int_IdReserva integer NOT NULL,"
                        + "dat_Fecha numeric NOT NULL,"
                        + "int_IdCostoTipoHabitacion integer NOT NULL,"
                        + "int_NHabitaciones integer NOT NULL,"
                        + "int_Dias integer NOT NULL,"
                        + "dou_Total numeric NOT NULL,"
                        + "TipoHabitacion text NOT NULL,"
                        + "NombreHotel text NOT NULL,"
                        + "int_IdComentario integer NOT NULL,"
                        + "int_IdPuntuacion integer NOT NULL);";


      private static final String CREATE_COMENTARIO = "CREATE TABLE comentario (int_IdComentario integer NOT NULL PRIMARY KEY,"
                        + "int_IdReserva integer NOT NULL,"
                        + "str_Descripcion text NOT NULL,"
                        + "str_Usuario text NOT NULL,"
                        + "dat_Fecha numeric NOT NULL);";

	public clsSQLite(Context context, CursorFactory factory) {
		super(context, DATABASE_NAME, factory, DATABASE_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
                db.execSQL(CREATE_USUARIO);
                db.execSQL(CREATE_HOTEL);
                db.execSQL(CREATE_CONFIGURACION);
                db.execSQL(CREATE_TIPO_HABITACION);
                db.execSQL(CREATE_INSTALACION);
                db.execSQL(CREATE_DETALLE_RESERVA);
                db.execSQL(CREATE_COMENTARIO);

        }   
        
        
	@Override
	public void onUpgrade(SQLiteDatabase db, int versionAnte, int versionNue) {
   
                db.execSQL("drop table if exists usuario");
                db.execSQL(CREATE_USUARIO);
                
                db.execSQL("drop table if exists hotel");
                db.execSQL(CREATE_HOTEL);
                
                db.execSQL("drop table if exists configuracion");
                db.execSQL(CREATE_CONFIGURACION);
                
                db.execSQL("drop table if exists tipo_habitacion");
                db.execSQL(CREATE_TIPO_HABITACION);
                
                db.execSQL("drop table if exists instalacion");
                db.execSQL(CREATE_INSTALACION);
                
                db.execSQL("drop table if exists detalle_reserva");
                db.execSQL(CREATE_DETALLE_RESERVA);
                
                db.execSQL("drop table if exists comentario");
                db.execSQL(CREATE_COMENTARIO);
            
	}	
        
}