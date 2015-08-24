/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.refugiate.app.dao;



import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.refugiate.app.entidades.clsDepartamento;
import com.refugiate.app.entidades.clsDistrito;
import com.refugiate.app.entidades.clsEmpresa;
import com.refugiate.app.entidades.clsProvincia;
import com.refugiate.app.entidades.clsSucursal;

import java.util.ArrayList;
import java.util.List;


public class clsSucursalSQL {

    private static String NOMBRE_TABLA="SUCURSAL";

     public static int Agregar(Context context,clsSucursal entidad)
    {
        int id;
        SQLite admin=new SQLite(context, null);
        SQLiteDatabase bd=admin.getWritableDatabase();
        bd.delete(NOMBRE_TABLA, "idSucursal=" + entidad.getIdSucursal(), null);
            ContentValues registro = new ContentValues();
            registro.put("idSucursal", entidad.getIdSucursal());
            registro.put("direccion", entidad.getDireccion());
            registro.put("pisos", entidad.getPisos());
            registro.put("telefono", entidad.getTelefono());
            registro.put("longitud", entidad.getLongitud());
            registro.put("latitud", entidad.getLatitud());
            registro.put("limpieza", entidad.getLimpieza());
            registro.put("servicio", entidad.getServicio());
            registro.put("comodidad", entidad.getComodidad());
            registro.put("puntuacion", entidad.getComodidad());
            registro.put("nivel", entidad.getNivel());
            registro.put("entrada", entidad.getEntrada());
            registro.put("estado", entidad.getEstado());
            registro.put("int_id_distrito", entidad.getObjDistrito().getInt_id_distrito());
            registro.put("idEmpresa", entidad.getObjEmpresa().getIdEmpresa());
            id = (int) bd.insert(NOMBRE_TABLA, null, registro);

        bd.close();
        return id;
    }

    public static  clsSucursal getSeleccionado(Context context)
    {
        clsSucursal  entidad=null;
        SQLite admin=new SQLite(context, null);
        SQLiteDatabase bd=admin.getWritableDatabase();
        if(bd!=null)
        {
            String query="select suc.idSucursal,suc.direccion,suc.pisos,suc.telefono,suc.longitud," +
                    "suc.latitud,suc.limpieza,suc.servicio,suc.comodidad,suc.puntuacion,suc.nivel," +
                    "suc.entrada,suc.estado,suc.int_id_distrito,suc.idEmpresa,emp.nombreComercial," +
                    "emp.nombre,emp.slogan,emp.ruc,emp.puntos,emp.estado,emp.logo,emp.banner,dist.str_nombre," +
                    "pro.int_id_provincia,pro.str_nombre,dep.int_id_depatamento,dep.str_nombre from "+NOMBRE_TABLA +
                    " as suc inner join EMPRESA as emp on suc.idEmpresa=emp.idEmpresa inner join DISTRITO as dist " +
                    "on dist.int_id_distrito=suc.int_id_distrito inner join PROVINCIA as pro on " +
                    "pro.int_id_provincia=dist.int_id_provincia  inner join DEPARTAMENTO as dep on " +
                    "dep.int_id_depatamento=pro.int_id_depatamento where suc.estado=2";

            Cursor fila=bd.rawQuery(query,null);
            if (fila.moveToFirst())
            {
                clsDepartamento ObjDepartamento = new clsDepartamento();
                ObjDepartamento.setInt_id_depatamento(fila.getInt(26));
                ObjDepartamento.setStr_nombre(fila.getString(27));

                clsProvincia objProvincia = new clsProvincia();
                objProvincia.setInt_id_provincia(fila.getInt(24));
                objProvincia.setStr_nombre(fila.getString(25));
                objProvincia.setObjDepartamento(ObjDepartamento);

                clsDistrito objDistrito = new clsDistrito();
                objDistrito.setInt_id_distrito(fila.getInt(13));
                objDistrito.setStr_nombre(fila.getString(23));
                objDistrito.setObjProvincia(objProvincia);

                clsEmpresa objEmpresa=new clsEmpresa();
                objEmpresa.setIdEmpresa(fila.getInt(14));
                objEmpresa.setNombreComercial(fila.getString(15));
                objEmpresa.setNombre(fila.getString(16));
                objEmpresa.setSlogan(fila.getString(17));
                objEmpresa.setRuc(fila.getString(18));
                objEmpresa.setPuntos(fila.getInt(19));
                objEmpresa.setEstado(fila.getInt(20));
                objEmpresa.setLogo(fila.getBlob(21));
                objEmpresa.setBanner(fila.getBlob(22));

                entidad= new clsSucursal();
                entidad.setIdSucursal(fila.getInt(0));
                entidad.setDireccion(fila.getString(1));
                entidad.setPisos(fila.getInt(2));
                entidad.setTelefono(fila.getString(3));
                entidad.setLongitud(fila.getDouble(4));
                entidad.setLatitud(fila.getDouble(5));
                entidad.setLimpieza(fila.getInt(6));
                entidad.setServicio(fila.getInt(7));
                entidad.setComodidad(fila.getInt(8));
                entidad.setPuntuacion(fila.getInt(9));
                entidad.setNivel(fila.getInt(10));
                entidad.setEntrada(fila.getString(11));
                entidad.setEstado(fila.getInt(12));
                entidad.setObjDistrito(objDistrito);
                entidad.setObjEmpresa(objEmpresa);

            }
        }
        bd.close();
        return entidad;
    }

    public static  clsSucursal Buscar(Context context,int id)
    {
        clsSucursal  entidad=null;
        SQLite admin=new SQLite(context, null);
        SQLiteDatabase bd=admin.getWritableDatabase();
        if(bd!=null)
        {
            String query="select suc.idSucursal,suc.direccion,suc.pisos,suc.telefono,suc.longitud," +
                    "suc.latitud,suc.limpieza,suc.servicio,suc.comodidad,suc.puntuacion,suc.nivel," +
                    "suc.entrada,suc.estado,suc.int_id_distrito,suc.idEmpresa,emp.nombreComercial," +
                    "emp.nombre,emp.slogan,emp.ruc,emp.puntos,emp.estado,emp.logo,emp.banner,dist.str_nombre," +
                    "pro.int_id_provincia,pro.str_nombre,dep.int_id_depatamento,dep.str_nombre from "+NOMBRE_TABLA +
                    " as suc inner join EMPRESA as emp on suc.idEmpresa=emp.idEmpresa inner join DISTRITO as dist " +
                    "on dist.int_id_distrito=suc.int_id_distrito inner join PROVINCIA as pro on " +
                    "pro.int_id_provincia=dist.int_id_provincia  inner join DEPARTAMENTO as dep on " +
                    "dep.int_id_depatamento=pro.int_id_depatamento  where suc.idSucursal="+id;

            Cursor fila=bd.rawQuery(query,null);
            if (fila.moveToFirst())
            {

                clsDepartamento ObjDepartamento = new clsDepartamento();
                ObjDepartamento.setInt_id_depatamento(fila.getInt(26));
                ObjDepartamento.setStr_nombre(fila.getString(27));

                clsProvincia objProvincia = new clsProvincia();
                objProvincia.setInt_id_provincia(fila.getInt(24));
                objProvincia.setStr_nombre(fila.getString(25));
                objProvincia.setObjDepartamento(ObjDepartamento);

                clsDistrito objDistrito = new clsDistrito();
                objDistrito.setInt_id_distrito(fila.getInt(13));
                objDistrito.setStr_nombre(fila.getString(23));
                objDistrito.setObjProvincia(objProvincia);

                clsEmpresa objEmpresa=new clsEmpresa();
                objEmpresa.setIdEmpresa(fila.getInt(14));
                objEmpresa.setNombreComercial(fila.getString(15));
                objEmpresa.setNombre(fila.getString(16));
                objEmpresa.setSlogan(fila.getString(17));
                objEmpresa.setRuc(fila.getString(18));
                objEmpresa.setPuntos(fila.getInt(19));
                objEmpresa.setEstado(fila.getInt(20));
                objEmpresa.setLogo(fila.getBlob(21));
                objEmpresa.setBanner(fila.getBlob(22));

                entidad= new clsSucursal();
                entidad.setIdSucursal(fila.getInt(0));
                entidad.setDireccion(fila.getString(1));
                entidad.setPisos(fila.getInt(2));
                entidad.setTelefono(fila.getString(3));
                entidad.setLongitud(fila.getDouble(4));
                entidad.setLatitud(fila.getDouble(5));
                entidad.setLimpieza(fila.getInt(6));
                entidad.setServicio(fila.getInt(7));
                entidad.setComodidad(fila.getInt(8));
                entidad.setPuntuacion(fila.getInt(9));
                entidad.setNivel(fila.getInt(10));
                entidad.setEntrada(fila.getString(11));
                entidad.setEstado(fila.getInt(12));
                entidad.setObjDistrito(objDistrito);
                entidad.setObjEmpresa(objEmpresa);

            }
        }
        bd.close();
        return entidad;
    }

    public  static boolean setSeleccionado(Context context,int Id)
    {

        SQLite admin=new SQLite(context, null);
        SQLiteDatabase bd = admin.getWritableDatabase();
        ContentValues registro = new ContentValues();
        registro.put("estado",1);
        bd.update(NOMBRE_TABLA, registro,"estado=2", null);

        registro = new ContentValues();
        registro.put("estado", 2);
        int cant = bd.update(NOMBRE_TABLA, registro, "idSucursal=" + Id, null);

        bd.close();
        if(cant==1)
            return true;
        else
            return false;

    }
    public static List<clsSucursal> Listar(Context context)
    {
        List<clsSucursal> list=new ArrayList<clsSucursal>();
        SQLite admin=new SQLite(context, null);
        SQLiteDatabase bd=admin.getWritableDatabase();
        if(bd!=null)
        {
            String query="select suc.idSucursal,suc.direccion,suc.pisos,suc.telefono,suc.longitud," +
                    "suc.latitud,suc.limpieza,suc.servicio,suc.comodidad,suc.puntuacion,suc.nivel," +
                    "suc.entrada,suc.estado,suc.int_id_distrito,suc.idEmpresa,emp.nombreComercial," +
                    "emp.nombre,emp.slogan,emp.ruc,emp.puntos,emp.estado,emp.logo,emp.banner,dist.str_nombre," +
                    "pro.int_id_provincia,pro.str_nombre,dep.int_id_depatamento,dep.str_nombre from "+NOMBRE_TABLA +
                    " as suc inner join EMPRESA as emp on suc.idEmpresa=emp.idEmpresa inner join DISTRITO as dist " +
                    "on dist.int_id_distrito=suc.int_id_distrito inner join PROVINCIA as pro on " +
                    "pro.int_id_provincia=dist.int_id_provincia  inner join DEPARTAMENTO as dep on " +
                    "dep.int_id_depatamento=pro.int_id_depatamento";

            Cursor fila=bd.rawQuery(query,null);
            int numRows = fila.getCount();
            fila.moveToFirst();
            for (int i = 0; i < numRows; ++i)
            {

                clsDepartamento ObjDepartamento = new clsDepartamento();
                ObjDepartamento.setInt_id_depatamento(fila.getInt(26));
                ObjDepartamento.setStr_nombre(fila.getString(27));

                clsProvincia objProvincia = new clsProvincia();
                objProvincia.setInt_id_provincia(fila.getInt(24));
                objProvincia.setStr_nombre(fila.getString(25));
                objProvincia.setObjDepartamento(ObjDepartamento);

                clsDistrito objDistrito = new clsDistrito();
                objDistrito.setInt_id_distrito(fila.getInt(13));
                objDistrito.setStr_nombre(fila.getString(23));
                objDistrito.setObjProvincia(objProvincia);

                clsEmpresa objEmpresa=new clsEmpresa();
                objEmpresa.setIdEmpresa(fila.getInt(14));
                objEmpresa.setNombreComercial(fila.getString(15));
                objEmpresa.setNombre(fila.getString(16));
                objEmpresa.setSlogan(fila.getString(17));
                objEmpresa.setRuc(fila.getString(18));
                objEmpresa.setPuntos(fila.getInt(19));
                objEmpresa.setEstado(fila.getInt(20));
                objEmpresa.setLogo(fila.getBlob(21));
                objEmpresa.setBanner(fila.getBlob(22));

                clsSucursal entidad= new clsSucursal();
                entidad.setIdSucursal(fila.getInt(0));
                entidad.setDireccion(fila.getString(1));
                entidad.setPisos(fila.getInt(2));
                entidad.setTelefono(fila.getString(3));
                entidad.setLongitud(fila.getDouble(4));
                entidad.setLatitud(fila.getDouble(5));
                entidad.setLimpieza(fila.getInt(6));
                entidad.setServicio(fila.getInt(7));
                entidad.setComodidad(fila.getInt(8));
                entidad.setPuntuacion(fila.getInt(9));
                entidad.setNivel(fila.getInt(10));
                entidad.setEntrada(fila.getString(11));
                entidad.setEstado(fila.getInt(12));
                entidad.setObjDistrito(objDistrito);
                entidad.setObjEmpresa(objEmpresa);
                list.add(entidad);

                fila.moveToNext();
            }
        }
        bd.close();
        return list;
    }
    public static void Borrar(Context context) {
         SQLite admin=new SQLite(context, null);
         SQLiteDatabase bd=admin.getWritableDatabase();
         bd.delete(NOMBRE_TABLA, null, null);
         bd.close();
    }
   
}
