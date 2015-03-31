
package DAO;



import Entidades.clsPuntuacion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;


public class clsPuntuacionDAO {
    
       public static int insertar(clsPuntuacion entidad) throws Exception
    {
        int rpta = 0;
        Connection conn =null;
        Statement stmt = null;
        try {

             String sql="exec InsertarPuntacion_sp 0,"+entidad.getInt_Limpieza()+","+entidad.getInt_Servicio()
                     +","+entidad.getInt_Comodidad()+","+entidad.getObjReserva().getInt_IdReserva();
             
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
