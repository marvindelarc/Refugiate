/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entidades.clsServicio;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Paulo
 */
public class clsServicioDAO {
    public static List<clsServicio> Listar(boolean activo) throws Exception
    {
        List<clsServicio> lista = null;
        Connection conn =null;
        CallableStatement stmt = null;
        ResultSet dr = null;
        try {
            String sql="SELECT idServicio,nombre,estado FROM servicio";
            if(activo)
                    sql+=" where estado=1"; 
            conn = clsConexion.getConnection();
            stmt = conn.prepareCall(sql);
            dr = stmt.executeQuery();

            while(dr.next())
            {
                if(lista==null)
                {
                    lista= new ArrayList<clsServicio>();
                } 
                clsServicio entidad = new clsServicio();
                entidad.setIdServicio(dr.getInt(1));
                entidad.setNombre(dr.getString(2)); 
                entidad.setEstado(dr.getInt(3));  
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
    
      public static List<clsServicio> ListarServicio(Long actualizacion) throws Exception
    {
        List<clsServicio> lista = null;
        Connection conn =null;
        CallableStatement stmt = null;
        ResultSet dr = null;
        try {
            String sql="SELECT idServicio,nombre,estado,fechaUpdate FROM servicio";
            if(actualizacion!=null)
            {
                SimpleDateFormat format = new SimpleDateFormat("yyyy-M-dd hh:mm:ss");
                sql+=" where fechaUpdate<'"+format.format(new Date(actualizacion))+"'"; 
            }
            
            conn = clsConexion.getConnection();
            stmt = conn.prepareCall(sql);
            dr = stmt.executeQuery();

            while(dr.next())
            {
                if(lista==null)
                {
                    lista= new ArrayList<clsServicio>();
                } 
                clsServicio entidad = new clsServicio();
                entidad.setIdServicio(dr.getInt(1));
                entidad.setNombre(dr.getString(2)); 
                entidad.setEstado(dr.getInt(3));  
                entidad.setUpdate(dr.getTimestamp(4));
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
    
    public  static int insertar(clsServicio entidad) throws Exception
    {
        int rpta = 0;
        Connection conn = null;
        PreparedStatement  stmt = null;
        try {
            
           String sql= "INSERT INTO servicio(nombre,estado,fechaUpdate)"
                   + " VALUES(?,?,now());";
           
            conn = clsConexion.getConnection();
            stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, entidad.getNombre());
            stmt.setInt(2, entidad.getEstado());
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
    
    public static boolean actualizar(clsServicio entidad) throws Exception
    {
        boolean rpta = false;
        Connection conn =null;
        CallableStatement stmt = null;
        try {
             String sql="UPDATE servicio SET nombre = ?,estado= ?,fechaUpdate=now() WHERE idServicio = ?;";
             
            conn = clsConexion.getConnection();
            stmt = conn.prepareCall(sql);             
            stmt.setString(1, entidad.getNombre());
            stmt.setInt(2,entidad.getEstado());
            stmt.setInt(3,entidad.getIdServicio());
            rpta = stmt.executeUpdate() == 1;
        } catch (Exception e) {
            throw new Exception("Error Actualizar "+e.getMessage(), e);
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
}
