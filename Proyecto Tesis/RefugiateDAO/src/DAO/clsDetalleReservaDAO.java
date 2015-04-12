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
import java.sql.ResultSet;
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
                if (lista == null) {
                    lista = new ArrayList<clsDetalleReserva>();
                    
                    clsReserva objReserva = new clsReserva();
                    objReserva.setIdReserva(dr.getInt(2));
                    
                    clsHabitacion objHabitacion = new clsHabitacion();
                    objHabitacion.setIdHabitacion(dr.getInt(8));
                    
                    clsDetalleReserva entidad = new clsDetalleReserva();
                    entidad.setInt_IdDetalleReserva(dr.getInt(1));
                    entidad.setObjReserva(objReserva);
                    entidad.setNroHabitaciones(dr.getInt(3));
                    entidad.setFechaIngreso(dr.getTimestamp(4));
                    entidad.setDias(dr.getInt(5));
                    entidad.setTotal(dr.getFloat(6));
                    entidad.setEstado(dr.getInt(7));
                    entidad.setObjHabitacion(objHabitacion);
                    lista.add(entidad);
                }
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
}
