/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entidades.clsWebAdmin;
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
public class clsWebAdminDAO 
{
    public static List<clsWebAdmin> Listar(boolean activo) throws Exception
    {
        List<clsWebAdmin> lista = null;
        Connection conn =null;
        CallableStatement stmt = null;
        ResultSet dr = null;
        try 
        {
            String sql="SELECT idWebAdmin,nombre,apellido,usuario,password,nivel,email,estado FROM webadmin";
            if(activo)
                    sql+=" where estado=1"; 
            conn = clsConexion.getConnection();
            stmt = conn.prepareCall(sql);
            dr = stmt.executeQuery();

            while(dr.next())
            {
                if(lista==null)
                    { 
                        lista= new ArrayList<clsWebAdmin>(); 
                    }              
                clsWebAdmin entidad = new clsWebAdmin();
                entidad.setIdWebAdmin(dr.getInt(1));
                entidad.setNombre(dr.getString(2)); 
                entidad.setApellido(dr.getString(3)); 
                entidad.setUsuario(dr.getString(4)); 
                entidad.setPassword(dr.getString(5)); 
                entidad.setNivel(dr.getInt(6));
                entidad.setEmail(dr.getString(7));
                entidad.setEstado(dr.getInt(8));
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
    
    public  static int insertar(clsWebAdmin entidad) throws Exception
    {
        int rpta = 0;
        Connection conn = null;
        PreparedStatement  stmt = null;
        try {
            
           String sql= "INSERT INTO webadmin(nombre,apellido,usuario,password,nivel,email,estado)"
                   + " VALUES(?,?,?,?,?,?,?);";
           
            conn = clsConexion.getConnection();
            stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, entidad.getNombre());
            stmt.setString(2, entidad.getApellido());
            stmt.setString(3, entidad.getUsuario());
            stmt.setString(4, entidad.getPassword());
            stmt.setInt(5, entidad.getNivel());
            stmt.setString(6, entidad.getEmail());
            stmt.setInt(7, entidad.getEstado());
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
    
    public static boolean actualizar(clsWebAdmin entidad) throws Exception
    {
        boolean rpta = false;
        Connection conn =null;
        CallableStatement stmt = null;
        try {
             String sql="UPDATE webadmin SET nombre = ?,apellido = ?,usuario = ?,password = ?,nivel = ?,email = ?,estado= ? WHERE idWebAdmin = ?;";
             
            conn = clsConexion.getConnection();
            stmt = conn.prepareCall(sql);             
            stmt.setString(1, entidad.getNombre());
            stmt.setString(2, entidad.getApellido());
            stmt.setString(3, entidad.getUsuario());
            stmt.setString(4, entidad.getPassword());
            stmt.setInt(5, entidad.getNivel());
            stmt.setString(6, entidad.getEmail());
            stmt.setInt(7, entidad.getEstado());
            stmt.setInt(8, entidad.getIdWebAdmin());
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
