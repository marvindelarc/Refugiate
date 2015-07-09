/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entidades.clsDistrito;
import Entidades.clsEmpresa;
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
    
    public static clsEncargado login(String usuario,String password) throws Exception
    {
        clsEncargado entidad = null;
        Connection conn =null;
        CallableStatement stmt = null;
        ResultSet dr = null;
        try {
            String sql="SELECT e.idEncargado,e.nombre,e.apellido,e.email,e.celularPersonal,e.usuario,e.password,e.estado,e.idSucursal,\n" +
                        "s.idDistrito,s.direccion,s.pisos,s.telefono,s.longitud,s.latitud,s.limpieza,s.servicio,s.comodidad,s.puntuacion,\n" +
                        "s.nivel,s.entrada,s.estado,s.idEmpresa,em.nombreComercial,em.nombre,em.slogan,em.ruc,em.puntos,em.logo,em.banner,\n" +
                        "em.estado FROM encargado e inner join sucursal s on e.idSucursal=s.idSucursal inner join empresa em \n" +
                        "on s.idEmpresa=em.idEmpresa where e.usuario='"+usuario+"' and e.password='"+password+"';";
      
            conn = clsConexion.getConnection();
            stmt = conn.prepareCall(sql);
            dr = stmt.executeQuery();

            if(dr.next())
            {
                clsEmpresa objEmpresa = new clsEmpresa();
                objEmpresa.setIdEmpresa(dr.getInt(23));
                objEmpresa.setNombreComercial(dr.getString(24));
                objEmpresa.setNombre(dr.getString(25));
                objEmpresa.setSlogan(dr.getString(26));
                objEmpresa.setRuc(dr.getString(27));
                objEmpresa.setPuntos(dr.getInt(28));
                objEmpresa.setLogo(dr.getBytes(29));
                objEmpresa.setBanner(dr.getBytes(30));
                objEmpresa.setEstado(dr.getInt(23));
                
                clsSucursal objSucursal = new clsSucursal();
                objSucursal.setObjEmpresa(objEmpresa);
                objSucursal.setIdSucursal(dr.getInt(9));
                objSucursal.setObjDistrito(new clsDistrito(dr.getInt(10)));
                objSucursal.setDireccion(dr.getString(11));
                objSucursal.setPisos(dr.getInt(12));
                objSucursal.setTelefono(dr.getString(13));
                objSucursal.setLongitud(dr.getDouble(14));
                objSucursal.setLatitud(dr.getDouble(15));
                objSucursal.setLimpieza(dr.getInt(16));
                objSucursal.setServicio(dr.getInt(17));
                objSucursal.setComodidad(dr.getInt(18));
                objSucursal.setPuntuacion(dr.getInt(19));
                objSucursal.setNivel(dr.getInt(20));
                objSucursal.setEntrada(dr.getString(21));
                objSucursal.setEstado(dr.getInt(22));
                
                entidad = new clsEncargado();                
                entidad.setObjSucursal(objSucursal);
                entidad.setIdEncargado(dr.getInt(1));
                entidad.setNombre(dr.getString(2));
                entidad.setApellido(dr.getString(3));
                entidad.setEmail(dr.getString(4));
                entidad.setCelular(dr.getString(5));
                entidad.setUsuario(dr.getString(6));
                entidad.setPassword(dr.getString(7));
                entidad.setEstado(dr.getInt(8));    
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
        return entidad;
    }
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
            
           String sql= "INSERT INTO empresa(nombreComercial,nombre,slogan,ruc,puntos,logo,banner,fechaRegistro,fechaUpdate,estado)"
                   + " VALUES(?,?,?,?,0,?,?,now(),now(),1);";
           
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
