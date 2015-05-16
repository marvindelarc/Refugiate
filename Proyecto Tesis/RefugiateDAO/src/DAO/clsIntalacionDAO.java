/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entidades.clsIntalacion;
import Entidades.clsServicio;
import Entidades.clsSucursal;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Paulo
 */
public class clsIntalacionDAO {
    public static List<clsIntalacion> Listar(boolean activo) throws Exception
    {
        List<clsIntalacion> lista = null;
        Connection conn =null;
        CallableStatement stmt = null;
        ResultSet dr = null;
        try {
            String sql="SELECT idInstalacion,idServicio,idSucursal,descripcion,estado FROM instalacion;";             
            conn = clsConexion.getConnection();
            stmt = conn.prepareCall(sql);
            dr = stmt.executeQuery();

            while(dr.next())
            {
                if(lista==null)
                {
                    lista= new ArrayList<clsIntalacion>();                
                }
                clsServicio objServicio = new clsServicio();
                objServicio.setIdServicio(dr.getInt(2));

                clsSucursal objSucursal = new clsSucursal();
                objSucursal.setIdSucursal(dr.getInt(3));

                clsIntalacion entidad = new clsIntalacion();
                entidad.setIdInstalacion(dr.getInt(1));
                entidad.setObjServicio(objServicio); 
                entidad.setObjSucursal(objSucursal);  
                entidad.setDescripcion(dr.getString(4));
                entidad.setEstado(dr.getInt(5));
                lista.add(entidad);                
            }
        } catch (Exception e) {
            throw new Exception("Listar "+e.getMessage(), e);
        }
        finally{
            try {
                dr.close();
                stmt.close();
                conn.close();
            } catch (SQLException e) {
            }
        }
        return lista;
    }
    
    public  static int insertar(clsIntalacion entidad) throws Exception
    {
        int rpta = 0;
        Connection conn = null;
        PreparedStatement  stmt = null;
        try {
            
           String sql= "INSERT INTO instalacion(idServicio,idSucursal,descripcion,estado)"
                   + " VALUES(?,?,?,?);";
           
            conn = clsConexion.getConnection();
            stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setInt(1, entidad.getObjServicio().getIdServicio());
            stmt.setInt(2, entidad.getObjSucursal().getIdSucursal());
            stmt.setString(3, entidad.getDescripcion());
            stmt.setInt(4, entidad.getEstado());
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            
            if (rs.next()){
                rpta=rs.getInt(1);
            }
            rs.close();
        } catch (Exception e) {
            throw new Exception("Insertar"+e.getMessage(), e);
        }
        finally{
            try {
                stmt.close();
                conn.close();
            } catch (SQLException e) {
            }
        }
        return rpta;
    } 
    
    public static boolean actualizar(clsIntalacion entidad) throws Exception{
        boolean rpta = false;
        Connection conn = null;
        CallableStatement stmt = null;
        try {
            String sql = "UPDATE instalacion SET idServicio = ?,idSucursal = ?,descripcion = ?,estado = ? WHERE idInstalacion = ?;";
            conn = clsConexion.getConnection();
            stmt = conn.prepareCall(sql);
            stmt.setInt(1, entidad.getObjServicio().getIdServicio());
            stmt.setInt(2, entidad.getObjSucursal().getIdSucursal());
            stmt.setString(3, entidad.getDescripcion());
            stmt.setInt(4, entidad.getEstado());
            stmt.setInt(5, entidad.getIdInstalacion());
            rpta = stmt.executeUpdate() == 1;
        } catch (Exception e) {
            throw new Exception("Error Actualizar"+e.getMessage(), e);
        }
        finally
        {
            try {
                stmt.close();
                conn.close();
            } catch (Exception e) {
            }
        }
        return rpta;
    }
}
