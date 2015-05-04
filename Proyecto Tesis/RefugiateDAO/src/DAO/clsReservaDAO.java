/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entidades.clsPersona;
import Entidades.clsReserva;
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
public class clsReservaDAO {
    public static List<clsReserva> Listar(boolean activo) throws Exception
    {
        List<clsReserva> lista = null;
        Connection conn =null;
        CallableStatement stmt = null;
        ResultSet dr = null;
        try {
            String sql="SELECT idReserva,idPersona,idSucursal,fechaRegistro,estado FROM reserva";            
            if(activo)
                sql+=" where estado=1";
            conn = clsConexion.getConnection();
            stmt = conn.prepareCall(sql);
            dr = stmt.executeQuery();

            while(dr.next())
            {
                if(lista==null){
                    lista= new ArrayList<clsReserva>();                
                    
                    clsPersona objPersona = new clsPersona();
                    objPersona.setIdPersona(dr.getInt(2));
                    
                    clsSucursal objSucursal = new clsSucursal();
                    objSucursal.setIdSucursal(dr.getInt(3));
                    
                    clsReserva entidad = new clsReserva();
                    entidad.setIdReserva(dr.getInt(1));
                    entidad.setObjPersona(objPersona);
                    entidad.setObjSucursal(objSucursal);
                    entidad.setFechaResgistro(dr.getTimestamp(4));
                    entidad.setEstado(dr.getInt(5));  
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
    
    public  static int insertar(clsReserva entidad) throws Exception
    {
        int rpta = 0;
        Connection conn = null;
        PreparedStatement  stmt = null;
        try {
            
           String sql= "INSERT INTO reserva(idPersona,idSucursal,fechaRegistro,estado)"
                   + " VALUES(?,?,?,?);";
           
            conn = clsConexion.getConnection();
            stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setInt(1, entidad.getObjPersona().getIdPersona());
            stmt.setInt(2, entidad.getObjSucursal().getIdSucursal());
            stmt.setDate(3, (Date) entidad.getFechaResgistro());
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
    
    public static boolean actualizar(clsReserva entidad) throws Exception
    {
        boolean rpta = false;
        Connection conn =null;
        CallableStatement stmt = null;
        try {
             String sql="UPDATE reserva SET idPersona = ?,idSucursal= ?,fechaRegistro = ?,estado= ? WHERE idReserva = ?;";
             
            conn = clsConexion.getConnection();
            stmt = conn.prepareCall(sql);             
            stmt.setInt(1, entidad.getObjPersona().getIdPersona());
            stmt.setInt(2, entidad.getObjSucursal().getIdSucursal());
            stmt.setDate(3, (Date) entidad.getFechaResgistro());
            stmt.setInt(4, entidad.getEstado());
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
