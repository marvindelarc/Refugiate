/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entidades.clsDistrito;
import Entidades.clsEmpresa;
import Entidades.clsSucursal;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
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
public class clsSucursalDAO {
    public static List<clsSucursal> Listar(boolean activo) throws Exception
    {
        List<clsSucursal> lista = null;
        Connection conn =null;
        CallableStatement stmt = null;
        ResultSet dr = null;
        try {
            String sql="SELECT idSucursal,idEmpresa,idDistrito,direccion,pisos,telefono,longitud,latitud,limpieza,servicio,comodidad,puntuacion,nivel,entrada,salida,fecha,estado FROM sucursal";
            if(activo)
                    sql+=" where estado=1"; 
            conn = clsConexion.getConnection();
            stmt = conn.prepareCall(sql);
            dr = stmt.executeQuery();

            while(dr.next())
            {
                if(lista==null){
                    lista= new ArrayList<clsSucursal>();
                    
                    clsEmpresa objEmpresa = new clsEmpresa();
                    objEmpresa.setIdEmpresa(dr.getInt(2));
                    
                    clsDistrito objDistrito = new clsDistrito();
                    objDistrito.setIdDistrito(dr.getInt(3));
                    
                    clsSucursal entidad = new clsSucursal();
                    entidad.setIdSucursal(dr.getInt(1));
                    entidad.setObjEmpresa(objEmpresa);
                    entidad.setObjDistrito(objDistrito);
                    entidad.setDireccion(dr.getString(4)); 
                    entidad.setPisos(dr.getInt(5));
                    entidad.setTelefono(dr.getString(6)); 
                    entidad.setLongitud(dr.getDouble(7));
                    entidad.setLongitud(dr.getDouble(8));
                    entidad.setLimpieza(dr.getInt(9));
                    entidad.setServicio(dr.getInt(10));
                    entidad.setComodidad(dr.getInt(11));
                    entidad.setPuntuacion(dr.getInt(12));
                    entidad.setNivel(dr.getInt(13));
                    entidad.setEntrada(dr.getString(14)); 
                    entidad.setSalida(dr.getString(15)); 
                    entidad.setFecha(dr.getDate(16));
                    entidad.setEstado(dr.getInt(17));  
                    lista.add(entidad);
                }
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
    
    public  static int insertar(clsSucursal entidad) throws Exception
    {
        int rpta = 0;
        Connection conn = null;
        PreparedStatement  stmt = null;
        try {
            
           String sql= "INSERT INTO sucursal(idEmpresa,idDistrito,direccion,pisos,telefono,longitud,latitud,limpieza,servicio,comodidad,puntuacion,nivel,entrada,salida,fecha,estado)"
                   + " VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
           
            conn = clsConexion.getConnection();
            stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setInt(1, entidad.getObjEmpresa().getIdEmpresa());
            stmt.setInt(2, entidad.getObjDistrito().getIdDistrito());
            stmt.setString(3, entidad.getDireccion());
            stmt.setInt(4, entidad.getPisos());
            stmt.setString(5, entidad.getTelefono());
            stmt.setDouble(6, entidad.getLongitud());
            stmt.setDouble(7, entidad.getLatitud());
            stmt.setInt(8, entidad.getLimpieza());
            stmt.setInt(9, entidad.getServicio());
            stmt.setInt(10, entidad.getComodidad());
            stmt.setInt(11, entidad.getPuntuacion());
            stmt.setInt(12, entidad.getNivel());
            stmt.setString(13, entidad.getEntrada());
            stmt.setString(14, entidad.getSalida());
            stmt.setDate(15, (Date) entidad.getFecha());
            stmt.setInt(16, entidad.getEstado());
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
    
    public static boolean actualizar(clsSucursal entidad) throws Exception
    {
        boolean rpta = false;
        Connection conn =null;
        CallableStatement stmt = null;
        try {
             String sql="UPDATE sucursal SET idEmpresa = ?,idDistrito= ?,direccion = ?,pisos = ?,telefono = ?,longitud = ?,latitud = ?,limpieza = ?,servicio = ?,comodidad = ?,puntuacion = ?,nivel = ?,entrada = ?,salida = ?,fecha = ?,estado = ? WHERE idSucursal = ?;";
             
            conn = clsConexion.getConnection();
            stmt = conn.prepareCall(sql);             
            stmt.setInt(1, entidad.getObjEmpresa().getIdEmpresa());
            stmt.setInt(2, entidad.getObjDistrito().getIdDistrito());
            stmt.setString(3, entidad.getDireccion());
            stmt.setInt(4, entidad.getPisos());
            stmt.setString(5, entidad.getTelefono());
            stmt.setDouble(6, entidad.getLongitud());
            stmt.setDouble(7, entidad.getLatitud());
            stmt.setInt(8, entidad.getLimpieza());
            stmt.setInt(9, entidad.getServicio());
            stmt.setInt(10, entidad.getComodidad());
            stmt.setInt(11, entidad.getPuntuacion());
            stmt.setInt(12, entidad.getNivel());
            stmt.setString(13, entidad.getEntrada());
            stmt.setString(14, entidad.getSalida());
            stmt.setDate(15, (Date) entidad.getFecha());
            stmt.setInt(16, entidad.getEstado());
            stmt.setInt(17, entidad.getIdSucursal());
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

