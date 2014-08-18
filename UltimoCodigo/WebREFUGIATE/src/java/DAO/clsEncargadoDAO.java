/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entidades.clsEncargado;
import Entidades.clsSucursal;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Paulo
 */
public class clsEncargadoDAO {
    

      
         public static int insertar(clsEncargado entidad) throws Exception
    {
        int rpta = 0;
        Connection conn =null;
        Statement stmt = null;
        try {

            String sql="exec InsertarEncargado_sp 0,'"+entidad.getStr_Nombre()+
                    "', '"+entidad.getStr_Apellido()+"', '"+entidad.getStr_Usuario()
                    +"', '"+entidad.getStr_Password()+"', '"+entidad.getStr_Email()
                    +"', '"+entidad.getStr_Celular()+"', '"+entidad.getObjSucursal().getInt_IdSucursal()+"'";
            conn = clsConexion.getConnection();
            stmt = (Statement) conn.createStatement();
            stmt.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);            
            ResultSet resulset = stmt.getGeneratedKeys();
            if (resulset.next()) {
                rpta = resulset.getInt(1);
            }
        } catch (Exception e) {
            throw new Exception("Registrar "+e.getMessage(), e);
        }
        finally{
            try {
                stmt.close();
                conn.close();
            } catch (Exception e) {
            }
        }
        return rpta;
    }
         
    public static clsEncargado login(String Usuario,String Pass) throws Exception
    {
        clsEncargado entidad = null;
        Connection conn =null;
        CallableStatement stmt = null;
        ResultSet dr = null;
        try {
            String sql="exec LoginEncargado_sp '"+Usuario+"','"+Pass+"'";

            conn = clsConexion.getConnection();
            stmt = conn.prepareCall(sql);
            dr = stmt.executeQuery();

            if(dr.next())
            {                
                    clsSucursal sucursal = new clsSucursal();
                    sucursal.setInt_IdSucursal(dr.getInt(8));
                    
                    entidad = new clsEncargado();
                    entidad.setInt_IdEncargado(dr.getInt(1));
                    entidad.setStr_Nombre(dr.getString(2));
                    entidad.setStr_Apellido(dr.getString(3));
                    entidad.setStr_Usuario(dr.getString(4));
                    entidad.setStr_Password(dr.getString(5));
                    entidad.setInt_Estado(dr.getInt(6));
                    entidad.setStr_Email(dr.getString(7)); 
                    entidad.setStr_Celular(dr.getString(9)); 
                    entidad.setObjSucursal(sucursal);
            }

        } catch (Exception e) {
            throw new Exception("Listar Sucursal "+e.getMessage(), e);
        }
        finally{
            try {
                dr.close();
                stmt.close();
                conn.close();
            } catch (Exception e) {
            }
        }
        return entidad;
    }          
}

