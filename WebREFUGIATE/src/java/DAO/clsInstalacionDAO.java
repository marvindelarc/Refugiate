/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entidades.clsInstalacion;
import Entidades.clsServicio;
import Entidades.clsSucursal;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Paulo
 */
public class clsInstalacionDAO {
     
       public static List<clsInstalacion> listarIdSucursales(int IdSucursal) throws Exception
    {
        List<clsInstalacion> list = null;
        Connection conn =null;
        CallableStatement stmt = null;
        ResultSet dr = null;
        try {
            String sql="exec ListarInstalacionXIdSucursales_sp "+IdSucursal;
            conn = clsConexion.getConnection();
            stmt = conn.prepareCall(sql);
            dr = stmt.executeQuery();

            while(dr.next())
            {
                 if(list == null)
                    list = new ArrayList<clsInstalacion>();
                
                clsServicio objServivio= new clsServicio();
                objServivio.setInt_IdServicio(dr.getInt(2));
                objServivio.setStr_Nombre(dr.getString(4));
                
                clsInstalacion objCostoTipoHabitacion = new clsInstalacion();
                objCostoTipoHabitacion.setInt_IdInstalacion(dr.getInt(1));
                objCostoTipoHabitacion.setStr_Descrpcion(dr.getString(3));
                objCostoTipoHabitacion.setObjServicio(objServivio);
                list.add(objCostoTipoHabitacion);
            }

        } catch (Exception e) {
            throw new Exception("Listar Provincia "+e.getMessage(), e);
        }
        finally{
            try {
                dr.close();
                stmt.close();
                conn.close();
            } catch (Exception e) {
            }
        }
        return list;
    }
 
      public static List<clsInstalacion> listarTodos() throws Exception
    {
        List<clsInstalacion> list = null;
        Connection conn =null;
        CallableStatement stmt = null;
        ResultSet dr = null;
        try {
            String sql="exec ListarInstalacion_sp";
            conn = clsConexion.getConnection();
            stmt = conn.prepareCall(sql);
            dr = stmt.executeQuery();

            while(dr.next())
            {
                 if(list == null)
                    list = new ArrayList<clsInstalacion>();
                
                clsServicio objServivio= new clsServicio();
                objServivio.setInt_IdServicio(dr.getInt(2));
                objServivio.setStr_Nombre(dr.getString(5));
                
                clsSucursal objSucursal = new clsSucursal();
                objSucursal.setInt_IdSucursal(dr.getInt(3));
                
                clsInstalacion objInstalacion = new clsInstalacion();
                objInstalacion.setInt_IdInstalacion(dr.getInt(1));
                objInstalacion.setStr_Descrpcion(dr.getString(4));
                objInstalacion.setObjServicio(objServivio);
                objInstalacion.setObjSucursal(objSucursal);
                
                list.add(objInstalacion);
            }

        } catch (Exception e) {
            throw new Exception("Listar Provincia "+e.getMessage(), e);
        }
        finally{
            try {
                dr.close();
                stmt.close();
                conn.close();
            } catch (Exception e) {
            }
        }
        return list;
    } 
       
      public static int insertar(clsInstalacion entidad) throws Exception
    {
        int rpta = 0;
        Connection conn =null;
        Statement stmt = null;
        try {

              String sql="exec InsertarInstalacion_sp 0 , '"+entidad.getObjServicio().getInt_IdServicio()
                    +"', '"+entidad.getObjSucursal().getInt_IdSucursal()+"', '"+entidad.getStr_Descrpcion()+"'";
              
            conn = clsConexion.getConnection();
            stmt = (Statement) conn.createStatement();
            stmt.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);            
            ResultSet resulset = stmt.getGeneratedKeys();
            if (resulset.next()) {
                rpta = resulset.getInt(1);
            }
        } catch (Exception e) {
            throw new Exception("Registrar "+e.getMessage(), e);
        }
        finally{
            try {
                stmt.close();
                conn.close();
            } catch (Exception e) {
            }
        }
        return rpta;
    }
           
}
