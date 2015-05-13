/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;


import Entidades.clsComentario;
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
public class clsComentarioDAO {
    public static List<clsComentario> Listar(boolean activo) throws Exception
    {
        List<clsComentario> lista = null;
        Connection conn = null;
        CallableStatement stmt = null;
        ResultSet dr = null;
        try {
            String sql = "SELECT idComentario,idReserva,descripcion,fecha,estado FROM comentario";
            if(activo)
                sql+=" where estado=1";
            conn = clsConexion.getConnection();
            stmt = conn.prepareCall(sql);
            dr = stmt.executeQuery();
            
            while (dr.next()) 
            {
                if (lista==null)
                {
                    lista = new ArrayList<clsComentario>();
                }
                clsReserva objReserva = new clsReserva();
                objReserva.setIdReserva(dr.getInt(2));

                clsComentario entidad = new clsComentario();
                entidad.setIdComentario(dr.getInt(1));
                entidad.setDescripcion(dr.getString(3));
                entidad.setFecha(dr.getTimestamp(4));
                entidad.setEstado(dr.getInt(5));
                entidad.setObjReserva(objReserva);
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
    
    public static int insertar(clsComentario entidad) throws Exception
    {
        int rpta = 0;
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            String sql = "INSERT INTO comentario (idReserva,descripcion,fecha,estado) "
                    + "VALUES(?,?,?,?)";
            conn = clsConexion.getConnection();
            stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setInt(1, entidad.getObjReserva().getIdReserva());
            stmt.setString(2, entidad.getDescripcion());
            stmt.setDate(3, (Date) entidad.getFecha());
            stmt.setInt(4, entidad.getEstado());
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                rpta = rs.getInt(1);
            }
            rs.close();
        } catch (Exception e) {
            throw new Exception("Insertar"+e.getMessage(), e);
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
    
    public static boolean actualizar(clsComentario entidad) throws Exception
    {
        boolean rpta = false;
        Connection conn = null;
        CallableStatement stmt = null;
        try {
            String sql="UPDATE comentario SET idReserva = ?,descripcion = ?,fecha = ?,estado= ? WHERE idComentario = ?;";            
            conn = clsConexion.getConnection();
            stmt = conn.prepareCall(sql);                  
            stmt.setInt(1, entidad.getObjReserva().getIdReserva());
            stmt.setString(2, entidad.getDescripcion());
            stmt.setDate(3, (Date) entidad.getFecha());
            stmt.setInt(4, entidad.getEstado());
            stmt.setInt(5, entidad.getIdComentario());
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