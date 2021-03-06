/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entidades.clsCostoTipoHabitacion;
import Entidades.clsHabitacion;
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
public class clsHabitacionDAO {
    public static List<clsHabitacion> Listar(boolean activo) throws Exception
    {
        List<clsHabitacion> lista = null;
        Connection conn =null;
        CallableStatement stmt = null;
        ResultSet dr = null;
        try {
            String sql="SELECT idHabitacion,idCostoTipoHabitacion,numero,piso,estado,vista FROM habitacion";
            if(activo)
                        sql+=" where estado=1"; 
            conn = clsConexion.getConnection();
            stmt = conn.prepareCall(sql);
            dr = stmt.executeQuery();

            while(dr.next())
            {
                if(lista==null)
                {
                    lista= new ArrayList<clsHabitacion>();                
                }
               
                clsHabitacion entidad = new clsHabitacion();
                entidad.setIdHabitacion(dr.getInt(1));
                entidad.setObjCostoTipoHabitacion(new clsCostoTipoHabitacion(dr.getInt(2)));  
                entidad.setNumero(dr.getInt(3));  
                entidad.setPiso(dr.getInt(4));                   
                entidad.setEstado(dr.getInt(5));  
                entidad.setVista(dr.getBoolean(6));  
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
    
    public static List<clsHabitacion> ListarDisponibilidad(int idCostoTipoHabitacion) throws Exception
    {
        List<clsHabitacion> lista = null;
        Connection conn =null;
        CallableStatement stmt = null;
        ResultSet dr = null;
        try {
            String sql="SELECT hab.idHabitacion,hab.idCostoTipoHabitacion,hab.numero,hab.piso,"
                    + "hab.estado,hab.vista FROM habitacion as hab inner join reserva as res on "
                    + "hab.idHabitacion=res.idHabitacion where (res.fechaEgreso<now() or res.estado!=1) and hab.estado=1 and "
                    + "hab.idCostoTipoHabitacion="+idCostoTipoHabitacion+" union SELECT hab.idHabitacion,"
                    + "hab.idCostoTipoHabitacion,hab.numero,hab.piso,hab.estado,hab.vista FROM habitacion "
                    + "as hab left join reserva as res on hab.idHabitacion=res.idHabitacion where "
                    + "res.idReserva is null and hab.estado=1 and hab.idCostoTipoHabitacion="+idCostoTipoHabitacion;
     
            conn = clsConexion.getConnection();
            stmt = conn.prepareCall(sql);
            dr = stmt.executeQuery();

            while(dr.next())
            {
                if(lista==null)
                    lista= new ArrayList<clsHabitacion>();    
                
                clsHabitacion entidad = new clsHabitacion();
                entidad.setIdHabitacion(dr.getInt(1));
                entidad.setObjCostoTipoHabitacion(new clsCostoTipoHabitacion(dr.getInt(2))); 
                entidad.setNumero(dr.getInt(3));  
                entidad.setPiso(dr.getInt(4));                   
                entidad.setEstado(dr.getInt(5));  
                entidad.setVista(dr.getBoolean(6));  
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
    public  static int insertar(clsHabitacion entidad) throws Exception
    {
        int rpta = 0;
        Connection conn = null;
        PreparedStatement  stmt = null;
        try {
            
            String sql= "INSERT INTO habitacion(idCostoTipoHabitacion,numero,piso,estado,vista)"
                        + " VALUES(?,?,?,?,?)";
           
            conn = clsConexion.getConnection();
            stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setInt(1, entidad.getObjCostoTipoHabitacion().getIdCostoTipoHabitacion());
            stmt.setInt(2, entidad.getNumero());
            stmt.setInt(3, entidad.getPiso());
            stmt.setInt(4, entidad.getEstado());
            stmt.setBoolean(5, entidad.isVista());
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
    
    public static boolean actualizar(clsHabitacion entidad) throws Exception
    {
        boolean rpta = false;
        Connection conn = null;
        CallableStatement stmt = null;
        try {
            String sql = "UPDATE habitacion SET idCostoTipoHabitacion = ?,numero = ?,piso = ?,estado = ?,vista = ? WHERE idHabitacion = ?;";
            conn = clsConexion.getConnection();
            stmt = conn.prepareCall(sql);
            stmt.setInt(1, entidad.getObjCostoTipoHabitacion().getIdCostoTipoHabitacion());
            stmt.setInt(2, entidad.getNumero());
            stmt.setInt(3, entidad.getPiso());            
            stmt.setInt(4, entidad.getEstado());
            stmt.setBoolean(5, entidad.isVista());
            stmt.setInt(6, entidad.getIdHabitacion());
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