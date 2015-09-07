/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entidades.clsCostoTipoHabitacion;
import Entidades.clsHabitacion;
import Entidades.clsPersona;
import Entidades.clsReserva;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Paulo
 */
public class clsReservaDAO {
    
    
     public static List<clsReserva> ListarServicio(Long actualizacion,int idPersona) throws Exception
    {
        List<clsReserva> lista = null;
        Connection conn =null;
        CallableStatement stmt = null;
        ResultSet dr = null;
        try {
            String sql="SELECT res.idReserva,res.fechaIngreso,res.fechaEgreso,res.costo,res.dias,res.limpieza,"
                    + "res.comodidad,res.servicio,res.comentario,res.fechaRegistro,res.fechaUpdate,res.estado,"
                    + "res.idHabitacion,hab.numero,hab.estado,hab.vista,hab.idCostoTipoHabitacion "
                    + "FROM reserva as res inner join habitacion as hab on hab.idHabitacion=res.idHabitacion "
                    + "where res.idPersona="+idPersona;     
            if(actualizacion!=null)
            {
                SimpleDateFormat format = new SimpleDateFormat("yyyy-M-dd hh:mm:ss");
                sql+=" and res.fechaUpdate<'"+format.format(new Date(actualizacion))+"'"; 
            }
            
            conn = clsConexion.getConnection();
            stmt = conn.prepareCall(sql);
            dr = stmt.executeQuery();

            while(dr.next())
            {
                if(lista==null)
                {
                    lista= new ArrayList<clsReserva>();                
                }
                clsCostoTipoHabitacion objCostoTipoHabitacion = new clsCostoTipoHabitacion();
                objCostoTipoHabitacion.setIdCostoTipoHabitacion(dr.getInt(17));
                
                clsHabitacion objHabitacion = new clsHabitacion();
                objHabitacion.setIdHabitacion(dr.getInt(13));
                objHabitacion.setNumero(dr.getInt(14));
                objHabitacion.setEstado(dr.getInt(15));
                objHabitacion.setVista(dr.getBoolean(16));
                objHabitacion.setObjCostoTipoHabitacion(objCostoTipoHabitacion);
                
                
                clsReserva entidad = new clsReserva();
                entidad.setIdReserva(dr.getInt(1));             
                entidad.setFechaIngreso(dr.getTimestamp(2));
                entidad.setFechaEgreso(dr.getTimestamp(3));
                entidad.setCosto(dr.getDouble(4));
                entidad.setDias(dr.getInt(5));         
                entidad.setLimpieza(dr.getInt(6));         
                entidad.setComodidad(dr.getInt(7));         
                entidad.setServicio(dr.getInt(8));         
                entidad.setComentario(dr.getString(9));         
                entidad.setFechaResgistro(dr.getTimestamp(10));
                entidad.setFechaUpdate(dr.getTimestamp(11));    
                entidad.setEstado(dr.getInt(12));   
                entidad.setObjHabitacion(objHabitacion);
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
                if(lista==null)
                {
                    lista= new ArrayList<clsReserva>();                
                }
                clsPersona objPersona = new clsPersona();
                objPersona.setIdPersona(dr.getInt(2));

                clsReserva entidad = new clsReserva();
                entidad.setIdReserva(dr.getInt(1));
                entidad.setObjPersona(objPersona);
                entidad.setFechaResgistro(dr.getTimestamp(4));
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
    
    public  static int insertar(clsReserva entidad) throws Exception
    {
        int rpta = 0;
        Connection conn = null;
        PreparedStatement  stmt = null;
        try {
            
           String sql= "INSERT INTO reserva(idPersona,idHabitacion,fechaIngreso,fechaEgreso,"
                   + "costo,dias,fechaRegistro,fechaUpdate,estado)VALUES(?,?,?,?,?,?,now(),now(),1);";
           
            conn = clsConexion.getConnection();
            conn.setAutoCommit(false);
            stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setInt(1, entidad.getObjPersona().getIdPersona());
            stmt.setInt(2, entidad.getObjHabitacion().getIdHabitacion());
            stmt.setDate(3, new Date(entidad.getFechaIngreso().getTime()));
            stmt.setDate(4, new Date(entidad.getFechaEgreso().getTime()));
            stmt.setDouble(5, entidad.getCosto());
            stmt.setInt(6, entidad.getDias());
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            
            if (rs.next()){
                rpta=rs.getInt(1);
            }
            
        rs.close();
        conn.commit();
        } catch (SQLException e) {
            if (conn != null) {
                conn.rollback();
            }
        } finally {
            if (conn != null && !conn.isClosed()) {
                conn.close();
                stmt.close();
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
             String sql="UPDATE reserva SET idPersona = ?,idSucursal= ?,fechaRegistro = ?,fechaUpdate=now(),estado= ? WHERE idReserva = ?;";
             
            conn = clsConexion.getConnection();
            stmt = conn.prepareCall(sql);             
            stmt.setInt(1, entidad.getObjPersona().getIdPersona());
            stmt.setDate(3, (Date) entidad.getFechaResgistro());
            stmt.setInt(4, entidad.getEstado());
            stmt.setInt(5, entidad.getIdReserva());
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
    
    
     public static boolean actualizarEstado(int idReserva, int Estado) throws Exception
    {
        boolean rpta = false;
        Connection conn =null;
        CallableStatement stmt = null;
        try {
             String sql="UPDATE reserva SET estado= ?,fechaUpdate=now() WHERE idReserva = ?;";
             
            conn = clsConexion.getConnection();
            stmt = conn.prepareCall(sql);             
            stmt.setInt(1, Estado);
            stmt.setInt(2, idReserva);
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
     
     
      public static boolean actualizarPuntacion(clsReserva entidad) throws Exception
    {
        boolean rpta = false;
        Connection conn =null;
        CallableStatement stmt = null;
        try {
             String sql="UPDATE reserva SET limpieza=?,servicio=?,comodidad=?,comentario=?,fechaUpdate=now(), estado=3  WHERE idReserva = ?;";
             
            conn = clsConexion.getConnection();
            stmt = conn.prepareCall(sql);             
            stmt.setInt(1, entidad.getLimpieza());
            stmt.setInt(2, entidad.getServicio());
            stmt.setInt(3, entidad.getComodidad());
            stmt.setString(4, entidad.getComentario());
            stmt.setInt(5, entidad.getIdReserva());
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
