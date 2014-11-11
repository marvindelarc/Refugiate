package DAO;




import Entidades.clsWebAdmin;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class clsWebAdminDAO {
    
   
    
   
     public static clsWebAdmin login(String Usuario,String Pass) throws Exception
    {
        clsWebAdmin objWeb = null;
        Connection conn =null;
        CallableStatement stmt = null;
        ResultSet dr = null;
        try {
            String sql="exec LoginWebAdmin_sp '"+Usuario+"','"+Pass+"'";

            conn = clsConexion.getConnection();
            stmt = conn.prepareCall(sql);
            dr = stmt.executeQuery();

            if(dr.next())
            {                    
                    objWeb = new clsWebAdmin();
                    objWeb.setInt_IdWebAdmin(dr.getInt(1));
                    objWeb.setStr_Usuario(dr.getString(2));
                    objWeb.setStr_Password(dr.getString(3));
                    objWeb.setInt_Nivel(dr.getInt(4));
                    objWeb.setStr_Email(dr.getString(5));
                    objWeb.setStr_Nombre(dr.getString(6));
                    objWeb.setStr_Apellido(dr.getString(7)); 
                    objWeb.setInt_Estado(dr.getInt(8)); 
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
        return objWeb;
    }
}