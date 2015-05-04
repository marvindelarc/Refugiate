/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entidades.clsPersona;
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
public class clsPersonaDAO {
    public static List<clsPersona> Listar(boolean activo) throws Exception
    {
        List<clsPersona> lista = null;
        Connection conn =null;
        CallableStatement stmt = null;
        ResultSet dr = null;
        try {
            String sql="SELECT idPersona,nombres,apellidos,telefono,email,dni,usuario,password,informacion,puntualidad,honrades,educacion,calificacion FROM persona;";
            conn = clsConexion.getConnection();
            stmt = conn.prepareCall(sql);
            dr = stmt.executeQuery();

            while(dr.next())
            {
                if(lista==null){
                    lista= new ArrayList<clsPersona>();                
                    clsPersona entidad = new clsPersona();
                    entidad.setIdPersona(dr.getInt(1));
                    entidad.setNombre(dr.getString(2)); 
                    entidad.setApellido(dr.getString(3)); 
                    entidad.setTelefono(dr.getString(4)); 
                    entidad.setEmail(dr.getString(5)); 
                    entidad.setDNI(dr.getString(6)); 
                    entidad.setUsuario(dr.getString(7)); 
                    entidad.setPassword(dr.getString(8)); 
                    entidad.setInformacion(dr.getInt(9));
                    entidad.setPuntualidad(dr.getInt(10));
                    entidad.setHonrrades(dr.getInt(11));
                    entidad.setEducacion(dr.getInt(12));
                    entidad.setCalificacion(dr.getInt(13));
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
    
    public  static int insertar(clsPersona entidad) throws Exception
    {
        int rpta = 0;
        Connection conn = null;
        PreparedStatement  stmt = null;
        try {            
            String sql= "INSERT INTO persona(nombres,apellidos,telefono,email,dni,usuario,password,informacion,puntualidad,honrades,educacion,calificacion)"
                   + " VALUES(?,?);";
           
            conn = clsConexion.getConnection();
            stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, entidad.getNombre());
            stmt.setString(2, entidad.getApellido());
            stmt.setString(3, entidad.getTelefono());
            stmt.setString(4, entidad.getEmail());
            stmt.setString(5, entidad.getDNI());
            stmt.setString(6, entidad.getUsuario());
            stmt.setString(7, entidad.getPassword());            
            stmt.setInt(8, entidad.getInformacion());
            stmt.setInt(9, entidad.getPuntualidad());
            stmt.setInt(10, entidad.getHonrrades());
            stmt.setInt(11, entidad.getEducacion());            
            stmt.setInt(12, entidad.getCalificacion());
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
    
    public static boolean actualizar(clsPersona entidad) throws Exception
    {
        boolean rpta = false;
        Connection conn =null;
        CallableStatement stmt = null;
        try {
            String sql="UPDATE persona SET nombres = ?,apellidos= ?,telefono = ?,email = ?,dni = ?,usuario = ?,password = ?,informacion = ?,puntualidad = ?,honrades = ?,educacion = ?,calificacion = ? WHERE idPersona = ?;";
             
            conn = clsConexion.getConnection();
            stmt = conn.prepareCall(sql);             
            stmt.setString(1, entidad.getNombre());
            stmt.setString(2, entidad.getApellido());
            stmt.setString(3, entidad.getTelefono());
            stmt.setString(4, entidad.getEmail());
            stmt.setString(5, entidad.getDNI());
            stmt.setString(6, entidad.getUsuario());
            stmt.setString(7, entidad.getPassword());            
            stmt.setInt(8, entidad.getInformacion());
            stmt.setInt(9, entidad.getPuntualidad());
            stmt.setInt(10, entidad.getHonrrades());
            stmt.setInt(11, entidad.getEducacion());            
            stmt.setInt(12, entidad.getCalificacion());
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
