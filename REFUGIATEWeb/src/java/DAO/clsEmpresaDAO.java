/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entidades.clsEmpresa;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class clsEmpresaDAO {
    
     
         public static int insertar(clsEmpresa entidad) throws Exception
    {
        int rpta = 0;
        Connection conn =null;
        Statement stmt = null;
        try {

              String sql="exec InsertarEmpresa_sp 0 , '"+entidad.getStr_NombreComercial()+"', '"+entidad.getStr_Nombre()
                    +"', '"+entidad.getStr_Slogan()+"', '"+entidad.getStr_Ruc()+"'";
              
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
           
  
}
