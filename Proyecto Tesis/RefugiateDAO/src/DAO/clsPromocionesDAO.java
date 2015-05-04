/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entidades.clsPromociones;
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
public class clsPromocionesDAO {
    public static List<clsPromociones> Listar(boolean activo) throws Exception
    {
        List<clsPromociones> lista = null;
        Connection conn =null;
        CallableStatement stmt = null;
        ResultSet dr = null;
        try {
            String sql="SELECT idPromociones,dato,fechaInicio,fechaFin,estado,idSucursal FROM promociones";
            if(activo)
                    sql+=" where estado=1"; 
            conn = clsConexion.getConnection();
            stmt = conn.prepareCall(sql);
            dr = stmt.executeQuery();

            while(dr.next())
            {
                if(lista==null){
                    lista= new ArrayList<clsPromociones>();
                    
                    clsSucursal objSucursal = new clsSucursal();
                    objSucursal.setIdSucursal(dr.getInt(6));
                            
                    clsPromociones entidad = new clsPromociones();
                    entidad.setIdPromociones(dr.getInt(1));
                    entidad.setDato(dr.getString(2));
                    entidad.setFechaInicio(dr.getTimestamp(3));
                    entidad.setFechaFin(dr.getTimestamp(4));
                    entidad.setEstado(dr.getInt(5));
                    entidad.setObjSucursal(objSucursal);
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
    
    public  static int insertar(clsPromociones entidad) throws Exception
    {
        int rpta = 0;
        Connection conn = null;
        PreparedStatement  stmt = null;
        try {
            
           String sql= "INSERT INTO promociones(dato,fechaInicio,fechaFin,estado,idSucursal)"
                   + " VALUES(?,?);";
           
            conn = clsConexion.getConnection();
            stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, entidad.getDato());
            stmt.setDate(2, (Date) entidad.getFechaInicio());
            stmt.setDate(3, (Date) entidad.getFechaFin());
            stmt.setInt(4, entidad.getEstado());
            stmt.setInt(5, entidad.getObjSucursal().getIdSucursal());
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
    
    public static boolean actualizar(clsPromociones entidad) throws Exception
    {
        boolean rpta = false;
        Connection conn =null;
        CallableStatement stmt = null;
        try {
             String sql="UPDATE promociones SET dato = ?,fechaInicio = ?,fechaFin = ?,estado = ?,idSucursal = ? WHERE idTipoHabitacion = ?;";
             
            conn = clsConexion.getConnection();
            stmt = conn.prepareCall(sql);             
            stmt.setString(1, entidad.getDato());
            stmt.setDate(2, (Date) entidad.getFechaInicio());
            stmt.setDate(3, (Date) entidad.getFechaFin());
            stmt.setInt(4, entidad.getEstado());
            stmt.setInt(5, entidad.getObjSucursal().getIdSucursal());
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
