/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entidades.clsEncargado;
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
public class clsEncargadoDAO {
    public static List<clsEncargado> Listar(boolean activo) throws Exception
    {
        List<clsEncargado> lista = null;
        Connection conn =null;
        CallableStatement stmt = null;
        ResultSet dr = null;
        try {
            String sql="SELECT idEncargado,idSucursal,nombre,apellido,email,celularPersonal,usuario,password,estado FROM encargado";
            if(activo)
                    sql+=" where estado=1"; 
            conn = clsConexion.getConnection();
            stmt = conn.prepareCall(sql);
            dr = stmt.executeQuery();

            while(dr.next())
            {
                if(lista==null)
                {
                    lista= new ArrayList<clsEncargado>();
                }
                clsSucursal objSucursal = new clsSucursal();
                objSucursal.setIdSucursal(dr.getInt(2));

                clsEncargado entidad = new clsEncargado();
                entidad.setIdEncargado(dr.getInt(1));
                entidad.setObjSucursal(objSucursal);
                entidad.setNombre(dr.getString(3));
                entidad.setApellido(dr.getString(4));
                entidad.setEmail(dr.getString(5));
                entidad.setCelular(dr.getString(6));
                entidad.setUsuario(dr.getString(7));
                entidad.setPassword(dr.getString(8));
                entidad.setEstado(dr.getInt(9));
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
    
    public  static int insertar(clsEncargado entidad) throws Exception
    {
        int rpta = 0;
        Connection conn = null;
        PreparedStatement  stmt = null;
        try {
            
           String sql= "INSERT INTO encargado (idSucursal,nombre,apellido,email,celularPersonal,usuario,password,estado)"
                   + " VALUES(?,?,?,?,?,?,?,?);";
           
            conn = clsConexion.getConnection();
            stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setInt(1, entidad.getObjSucursal().getIdSucursal());
            stmt.setString(2, entidad.getNombre());
            stmt.setString(3, entidad.getApellido());
            stmt.setString(4, entidad.getEmail());
            stmt.setString(5, entidad.getCelular());
            stmt.setString(6, entidad.getUsuario());
            stmt.setString(7, entidad.getPassword());
            stmt.setInt(8, entidad.getEstado());
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
    
    
      public  static int insertarRegistro(clsEncargado entidad) throws Exception
    {
        int rpta = 0;
        Connection conn = null;
        try {
            
           String sql= "INSERT INTO empresa(nombreComercial,nombre,slogan,ruc,puntos,logo,banner,fechaRegistro,estado)"
                   + " VALUES(?,?,?,?,0,?,?,now(),1);";
           
            conn = clsConexion.getConnection();
            conn.setAutoCommit(false);
            PreparedStatement  stmtEmpresa = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmtEmpresa.setString(1, entidad.getObjSucursal().getObjEmpresa().getNombreComercial());
            stmtEmpresa.setString(2, entidad.getObjSucursal().getObjEmpresa().getNombre());
            stmtEmpresa.setString(3, entidad.getObjSucursal().getObjEmpresa().getSlogan());
            stmtEmpresa.setString(4, entidad.getObjSucursal().getObjEmpresa().getRuc());
            stmtEmpresa.setBytes(5, entidad.getObjSucursal().getObjEmpresa().getLogo());
            stmtEmpresa.setBytes(6, entidad.getObjSucursal().getObjEmpresa().getBanner());
            stmtEmpresa.executeUpdate();
            ResultSet rsEmpresa = stmtEmpresa.getGeneratedKeys();
            
            if (rsEmpresa.next()){
                rpta=rsEmpresa.getInt(1);
                sql= "INSERT INTO sucursal(idEmpresa,idDistrito,direccion,pisos,telefono,longitud,latitud,limpieza,servicio,comodidad,puntuacion,nivel,entrada,fecha,estado)"
                   + " VALUES(?,?,?,?,?,?,?,0,0,0,0,?,?,now(),1);";
                PreparedStatement  stmtSucursal = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                stmtSucursal.setInt(1, rpta);
                stmtSucursal.setInt(2, entidad.getObjSucursal().getObjDistrito().getIdDistrito());
                stmtSucursal.setString(3, entidad.getObjSucursal().getDireccion());
                stmtSucursal.setInt(4, entidad.getObjSucursal().getPisos());
                stmtSucursal.setString(5, entidad.getObjSucursal().getTelefono());
                stmtSucursal.setDouble(6, entidad.getObjSucursal().getLongitud());
                stmtSucursal.setDouble(7, entidad.getObjSucursal().getLatitud());
                stmtSucursal.setInt(8, entidad.getObjSucursal().getNivel());
                stmtSucursal.setString(9, entidad.getObjSucursal().getEntrada());
                stmtSucursal.executeUpdate();
                ResultSet rsSucursal = stmtSucursal.getGeneratedKeys();            
                if (rsSucursal.next()){
                    rpta=rsSucursal.getInt(1);
                    sql= "INSERT INTO encargado (idSucursal,nombre,apellido,email,celularPersonal,usuario,password,estado)"
                        + " VALUES(?,?,?,?,?,?,?,0);";
                     PreparedStatement  stmtEncargado = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                     stmtEncargado.setInt(1, rpta);
                     stmtEncargado.setString(2, entidad.getNombre());
                     stmtEncargado.setString(3, entidad.getApellido());
                     stmtEncargado.setString(4, entidad.getEmail());
                     stmtEncargado.setString(5, entidad.getCelular());
                     stmtEncargado.setString(6, entidad.getUsuario());
                     stmtEncargado.setString(7, entidad.getPassword());
                     stmtEncargado.executeUpdate();
                     ResultSet rsEncargado = stmtEncargado.getGeneratedKeys();            
                     if (rsEncargado.next()){
                         rpta=rsEncargado.getInt(1);

                     }else
                         conn.rollback();
                    rsEncargado.close();
                }else
                    conn.rollback();
                
                rsSucursal.close();     
            }
            rsEmpresa.close();
          conn.commit();
        } catch (Exception e) {
             if (conn != null) {
                    conn.rollback();
                }
            throw new Exception("Insertar"+e.getMessage(), e);
        }
        finally{
            try {
                conn.close();
            } catch (SQLException e) {
            }
        }
        return rpta;
    }
    public static boolean actualizar(clsEncargado entidad) throws Exception
    {
        boolean rpta = false;
        Connection conn =null;
        CallableStatement stmt = null;
        try {
             String sql="UPDATE encargado SET idSucursal = ?,nombre = ?,apellido = ?,email = ?,celularPersonal = ?,usuario = ?,password = ?,estado = ? WHERE idEncargado = ?;";
             
            conn = clsConexion.getConnection();
            stmt = conn.prepareCall(sql);             
            stmt.setInt(1, entidad.getObjSucursal().getIdSucursal());
            stmt.setString(2, entidad.getNombre());
            stmt.setString(3, entidad.getApellido());
            stmt.setString(4, entidad.getEmail());
            stmt.setString(5, entidad.getCelular());
            stmt.setString(6, entidad.getUsuario());
            stmt.setString(7, entidad.getPassword());
            stmt.setInt(8, entidad.getEstado());
            stmt.setInt(9, entidad.getIdEncargado());
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
