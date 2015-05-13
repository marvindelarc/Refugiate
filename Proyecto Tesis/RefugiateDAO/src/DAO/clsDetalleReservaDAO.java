/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entidades.clsDetalleReserva;
import Entidades.clsHabitacion;
import Entidades.clsReserva;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Paulo
 */
public class clsDetalleReservaDAO {
    public static List<clsDetalleReserva> Listar(boolean activo) throws Exception
    {
        List<clsDetalleReserva> lista = null;
        Connection conn =null;
        CallableStatement stmt = null;
        ResultSet dr = null;
        try {
            String sql = "SELECT idDetalleReserva,idReserva,numeroHabitaciones,fechaIngresp,dias,total,estado,idHabitacion FROM detallereserva";
            if(activo)
                sql+=" where estado=1"; 
            conn = clsConexion.getConnection();
            stmt = conn.prepareCall(sql);
            dr = stmt.executeQuery();
            while (dr.next()) {
                if (lista == null) 
                {
                    lista = new ArrayList<clsDetalleReserva>();
                }
                clsReserva objReserva = new clsReserva();
                objReserva.setIdReserva(dr.getInt(2));

                clsHabitacion objHabitacion = new clsHabitacion();
                objHabitacion.setIdHabitacion(dr.getInt(8));

                clsDetalleReserva entidad = new clsDetalleReserva();
                entidad.setIdDetalleReserva(dr.getInt(1));
                entidad.setObjReserva(objReserva);
                entidad.setNroHabitaciones(dr.getInt(3));
                entidad.setFechaIngreso(dr.getTimestamp(4));
                entidad.setDias(dr.getInt(5));
                entidad.setTotal(dr.getFloat(6));
                entidad.setEstado(dr.getInt(7));
                entidad.setObjHabitacion(objHabitacion);
                lista.add(entidad);                
            }
        } catch (Exception e) {
            throw new Exception("Listar"+e.getMessage(), e);
        }
        finally
        {
            try {
                dr.close();
                stmt.close();
                conn.close();
            } catch (Exception e) {
            }
        }
        return lista;
    }
    
    public static int insertar(clsDetalleReserva entidad) throws Exception
    {
        int rpta = 0;
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            String sql = "INSERT INTO detallereserva(idReserva,numeroHabitaciones,fechaIngresp,dias,total,estado,idHabitacion)"
                        + " VALUES(?,?,?,?,?,?,?)";
            conn = clsConexion.getConnection();
            stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setInt(1, entidad.getObjReserva().getIdReserva());
            stmt.setInt(2, entidad.getNroHabitaciones());
            stmt.setDate(3, (Date) entidad.getFechaIngreso());
            stmt.setInt(4, entidad.getDias());
            stmt.setDouble(5, entidad.getTotal());
            stmt.setInt(6, entidad.getEstado());
            stmt.setInt(7, entidad.getObjHabitacion().getIdHabitacion());
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                rpta = rs.getInt(1);
            }
            rs.close();
        } catch (Exception e) {
            throw new Exception("Insertar"+e.getMessage());
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
    
    public static boolean actualizar(clsDetalleReserva entidad) throws Exception{
        boolean rpta = false;
        Connection conn = null;
        CallableStatement stmt = null;
        try {
            String sql = "UPDATE detallereserva SET idReserva = ?,numeroHabitaciones = ?,fechaIngresp = ?,dias = ?,total = ?,estado = ?,idHabitacion = ? WHERE idDetalleReserva = ?;";
            conn = clsConexion.getConnection();
            stmt = conn.prepareCall(sql);
            stmt.setInt(1, entidad.getObjReserva().getIdReserva());
            stmt.setInt(2, entidad.getNroHabitaciones());
            stmt.setDate(3, (Date) entidad.getFechaIngreso());
            stmt.setInt(4, entidad.getDias());
            stmt.setDouble(5, entidad.getTotal());
            stmt.setInt(6, entidad.getEstado());
            stmt.setInt(7, entidad.getObjHabitacion().getIdHabitacion());
            stmt.setInt(8, entidad.getInt_IdDetalleReserva());
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