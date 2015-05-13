/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entidades.clsPuntuacionHotel;
import Entidades.clsReserva;
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
public class clsPuntuacionHotelDAO {
    public static List<clsPuntuacionHotel> Listar(boolean activo) throws Exception
    {
        List<clsPuntuacionHotel> lista = null;
        Connection conn =null;
        CallableStatement stmt = null;
        ResultSet dr = null;
        try {
            String sql="SELECT idPuntuacionHotel,idReserva,limpieza,servicio,comodidad,fecha FROM puntuacionhotel;";
            conn = clsConexion.getConnection();
            stmt = conn.prepareCall(sql);
            dr = stmt.executeQuery();

            while(dr.next())
            {
                if(lista==null)
                {
                    lista= new ArrayList<clsPuntuacionHotel>();                
                }
                clsReserva objReserva = new clsReserva();
                objReserva.setIdReserva(dr.getInt(2));

                clsPuntuacionHotel entidad = new clsPuntuacionHotel();
                entidad.setIdPuntacionHotel(dr.getInt(1));
                entidad.setObjReserva(objReserva);
                entidad.setLimpieza(dr.getInt(3));
                entidad.setServicio(dr.getInt(4));
                entidad.setComodidad(dr.getInt(5));
                entidad.setFecha(dr.getTimestamp(6));
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
    
    public  static int insertar(clsPuntuacionHotel entidad) throws Exception
    {
        int rpta = 0;
        Connection conn = null;
        PreparedStatement  stmt = null;
        try {            
            String sql= "INSERT INTO puntuacionhotel(idReserva,limpieza,servicio,comodidad,fecha)"
                   + " VALUES(?,?,?,?,?)";
           
            conn = clsConexion.getConnection();
            stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setInt(1, entidad.getObjReserva().getIdReserva());
            stmt.setInt(2, entidad.getLimpieza());
            stmt.setInt(3, entidad.getServicio());
            stmt.setInt(4, entidad.getComodidad());
            stmt.setDate(5, (Date) entidad.getFecha());
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
    
    public static boolean actualizar(clsPuntuacionHotel entidad) throws Exception
    {
        boolean rpta = false;
        Connection conn =null;
        CallableStatement stmt = null;
        try {
             String sql="UPDATE puntuacionhotel SET idReserva = ?,limpieza= ?,servicio = ?,comodidad = ?,fecha = ? WHERE idPuntuacionHotel = ?;";
             
            conn = clsConexion.getConnection();
            stmt = conn.prepareCall(sql);             
            stmt.setInt(1, entidad.getObjReserva().getIdReserva());
            stmt.setInt(2, entidad.getLimpieza());
            stmt.setInt(3, entidad.getServicio());
            stmt.setInt(4, entidad.getComodidad());
            stmt.setDate(5, (Date) entidad.getFecha());
            stmt.setInt(6, entidad.getIdPuntacionHotel());
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
