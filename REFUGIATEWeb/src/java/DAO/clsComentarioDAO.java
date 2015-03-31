
package DAO;



import Entidades.clsComentario;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;


import java.util.ArrayList;
import java.util.List;

public class clsComentarioDAO {
    
       public static int insertar(clsComentario entidad) throws Exception
    {
        int rpta = 0;
        Connection conn =null;
        Statement stmt = null;
        try {

             String sql="exec InsertarComentario_sp 0,"+entidad.getInt_IdReserva()+",'"+entidad.getStr_Descripcion()+"'";
             
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
       public static List<clsComentario> ListarXSucursal(int IdSucursal) throws Exception
    {
        List<clsComentario> list = null;
        Connection conn =null;
        CallableStatement stmt = null;
        ResultSet dr = null;
        try {
            String sql="exec ListarComentariosXIdSucursales_sp "+IdSucursal;
            conn = clsConexion.getConnection();
            stmt = conn.prepareCall(sql);
            dr = stmt.executeQuery();

            while(dr.next())
            {
                 if(list == null)
                    list = new ArrayList<clsComentario>();

                clsComentario objComentario = new clsComentario();
                objComentario.setInt_IdComentario(dr.getInt(1));
                objComentario.setInt_IdReserva(dr.getInt(2));
                objComentario.setStr_Descripcion(dr.getString(3));
                objComentario.setStr_Usuario(dr.getString(4));

                list.add(objComentario);
            }

        } catch (Exception e) {
            throw new Exception("Listar Tipo Habitacion "+e.getMessage(), e);
        }
        finally{
            try {
                dr.close();
                stmt.close();
                conn.close();
            } catch (Exception e) {
            }
        }
        return list;
    }
       
       
          public static List<clsComentario> ListarXIdPersona(int IdPersona) throws Exception
    {
        List<clsComentario> list = null;
        Connection conn =null;
        CallableStatement stmt = null;
        ResultSet dr = null;
        try {
            String sql="exec ListarComentarioXIdPersona_sp "+IdPersona;
            conn = clsConexion.getConnection();
            stmt = conn.prepareCall(sql);
            dr = stmt.executeQuery();

            while(dr.next())
            {
                 if(list == null)
                    list = new ArrayList<clsComentario>();

                clsComentario objComentario = new clsComentario();
                objComentario.setInt_IdComentario(dr.getInt(1));
                objComentario.setInt_IdReserva(dr.getInt(2));
                objComentario.setStr_Descripcion(dr.getString(3));
                objComentario.setDat_Fecha(dr.getTimestamp(4));
                objComentario.setStr_Usuario(dr.getString(5));

                list.add(objComentario);
            }

        } catch (Exception e) {
            throw new Exception("Listar Tipo Habitacion "+e.getMessage(), e);
        }
        finally{
            try {
                dr.close();
                stmt.close();
                conn.close();
            } catch (Exception e) {
            }
        }
        return list;
    }
 
}
