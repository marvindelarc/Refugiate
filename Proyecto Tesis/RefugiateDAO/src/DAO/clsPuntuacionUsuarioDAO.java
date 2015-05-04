/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entidades.clsPuntuacionUsuario;
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
public class clsPuntuacionUsuarioDAO {
    public static List<clsPuntuacionUsuario> Listar(boolean activo) throws Exception
    {
        List<clsPuntuacionUsuario> lista = null;
        Connection conn =null;
        CallableStatement stmt = null;
        ResultSet dr = null;
        try {
            String sql="SELECT idPuntuacionUsuario,puntualidad,honrades,educacion,fecha,idReserva FROM puntuacionusuario;";
            conn = clsConexion.getConnection();
            stmt = conn.prepareCall(sql);
            dr = stmt.executeQuery();

            while(dr.next())
            {
                if(lista==null){
                    lista= new ArrayList<clsPuntuacionUsuario>();                
                    
                    clsReserva objReserva = new clsReserva();
                    objReserva.setIdReserva(dr.getInt(5));
                    
                    clsPuntuacionUsuario entidad = new clsPuntuacionUsuario();
                    entidad.setIdPUntuacionUsuario(dr.getInt(1));
                    entidad.setPuntualidad(dr.getInt(2));  
                    entidad.setHonrrades(dr.getInt(3));  
                    entidad.setEducacion(dr.getInt(4));  
                    entidad.setObjReserva(objReserva);  
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
    
    public  static int insertar(clsPuntuacionUsuario entidad) throws Exception
    {
        int rpta = 0;
        Connection conn = null;
        PreparedStatement  stmt = null;
        try {
            
           String sql= "INSERT INTO puntuacionusuario(idPuntuacionUsuario,puntualidad,honrades,educacion,fecha,idReserva)"
                   + " VALUES(?,?,?,?,?);";
           
            conn = clsConexion.getConnection();
            stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setInt(1, entidad.getPuntualidad());
            stmt.setInt(2, entidad.getHonrrades());
            stmt.setInt(3, entidad.getEducacion());
            stmt.setDate(4, (Date) entidad.getFecha());
            stmt.setInt(5, entidad.getObjReserva().getIdReserva());
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
    
    public static boolean actualizar(clsPuntuacionUsuario entidad) throws Exception
    {
        boolean rpta = false;
        Connection conn =null;
        CallableStatement stmt = null;
        try {
             String sql="UPDATE puntuacionusuario SET puntualidad = ?,honrades= ?,educacion = ?,fecha= ?,idReserva = ? WHERE idPuntuacionUsuario = ?";
             
            conn = clsConexion.getConnection();
            stmt = conn.prepareCall(sql);             
            stmt.setInt(1, entidad.getPuntualidad());
            stmt.setInt(2, entidad.getHonrrades());
            stmt.setInt(3, entidad.getEducacion());
            stmt.setDate(4, (Date) entidad.getFecha());
            stmt.setInt(5, entidad.getObjReserva().getIdReserva());
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
