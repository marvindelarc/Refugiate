/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entidades.clsEmpresa;
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
public class clsEmpresaDAO {
    public static List<clsEmpresa> Listar(boolean activo) throws Exception{
        List<clsEmpresa> lista = null;
        Connection conn =null;
        CallableStatement stmt = null;
        ResultSet dr = null;
        try {
            String sql = "SELECT idEmpresa,nombreComercial,nombre,slogan,ruc,puntos,fechaRegistro,fechaUpdate,logo,banner,estado FROM empresa";

                if (activo) 
                    sql+=" where estado=1"; 
         
            conn = clsConexion.getConnection();
            stmt = conn.prepareCall(sql);
            dr = stmt.executeQuery();
            while (dr.next()) 
            {
                if (lista == null) 
                {
                    lista = new ArrayList<clsEmpresa>();
                }
                clsEmpresa entidad =  new clsEmpresa();
                entidad.setIdEmpresa(dr.getInt(1));
                entidad.setNombreComercial(dr.getString(2));
                entidad.setNombre(dr.getString(3));
                entidad.setSlogan(dr.getString(4));
                entidad.setRuc(dr.getString(5));
                entidad.setPuntos(dr.getInt(6));
                entidad.setFechaRegistro(dr.getTimestamp(7));
                entidad.setFechaRegistro(dr.getTimestamp(8));
                entidad.setLogo(dr.getBytes(9));
                entidad.setBanner(dr.getBytes(10));
                entidad.setEstado(dr.getInt(11));
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
    
    public static List<clsEmpresa> ListarServicio(Long actualizacion) throws Exception
    {
        List<clsEmpresa> lista = null;
        Connection conn =null;
        CallableStatement stmt = null;
        ResultSet dr = null;
        try {
            String sql = "SELECT idEmpresa,nombreComercial,nombre,slogan,ruc,puntos,fechaRegistro,fechaUpdate,logo,banner,estado FROM empresa";

            if(actualizacion!=null)
            {
               SimpleDateFormat format = new SimpleDateFormat("yyyy-M-dd hh:mm:ss");
                sql+=" where fechaUpdate<'"+format.format(new Date(actualizacion))+"'"; 
            }
            else
                sql+=" where estado=1"; 
            conn = clsConexion.getConnection();
            stmt = conn.prepareCall(sql);
            dr = stmt.executeQuery();
            while (dr.next()) 
            {
                if (lista == null) 
                {
                    lista = new ArrayList<clsEmpresa>();
                }
                clsEmpresa entidad =  new clsEmpresa();
                entidad.setIdEmpresa(dr.getInt(1));
                entidad.setNombreComercial(dr.getString(2));
                entidad.setNombre(dr.getString(3));
                entidad.setSlogan(dr.getString(4));
                entidad.setRuc(dr.getString(5));
                entidad.setPuntos(dr.getInt(6));
                entidad.setFechaRegistro(dr.getTimestamp(7));
                entidad.setFechaRegistro(dr.getTimestamp(8));
                entidad.setLogo(dr.getBytes(9));
                entidad.setBanner(dr.getBytes(10));
                entidad.setEstado(dr.getInt(11));
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
    
    public  static int insertar(clsEmpresa entidad) throws Exception
    {
        int rpta = 0;
        Connection conn = null;
        PreparedStatement  stmt = null;
        try {
            
           String sql= "INSERT INTO empresa(nombreComercial,nombre,slogan,ruc,logo,banner,estado,puntos,fechaRegistro,fechaUpdate)"
                   + " VALUES(?,?,?,?,?,?,1,0,now(),now());";
//            String sql= "INSERT INTO empresa(nombreComercial,nombre,slogan,ruc,puntos,estado)"
//                   + " VALUES(?,?,?,?,?,?);";
            conn = clsConexion.getConnection();
            stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, entidad.getNombreComercial());
            stmt.setString(2, entidad.getNombre());
            stmt.setString(3, entidad.getSlogan());
            stmt.setString(4, entidad.getRuc());
            stmt.setBytes(5, entidad.getLogo());
            stmt.setBytes(6, entidad.getBanner());
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
    
    public static boolean actualizar(clsEmpresa entidad) throws Exception
    {
        boolean rpta = false;
        Connection conn =null;
        CallableStatement stmt = null;
        try {
             String sql="UPDATE empresa SET nombreComercial = ?,nombre= ?,slogan = ?,ruc= ?,puntos = ?,fechaRegistro= NULL,logo = NULL,banner= NULL,estado= ? WHERE idEmpresa = ?;";
             
            conn = clsConexion.getConnection();
            stmt = conn.prepareCall(sql);             
            stmt.setString(1, entidad.getNombreComercial());
            stmt.setString(2, entidad.getNombre());
            stmt.setString(3, entidad.getSlogan());
            stmt.setString(4, entidad.getRuc());
            stmt.setInt(5, entidad.getPuntos());
//            stmt.setDate(6, (Date) entidad.getFechaRegistro());
//            stmt.setBytes(7, entidad.getLogo());
//            stmt.setBytes(8, entidad.getBanner());
            stmt.setInt(6, entidad.getEstado());
            stmt.setInt(7, entidad.getIdEmpresa());
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
