package DAO;



import Entidades.clsPersona;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class clsPersonaDAO {
    
   
    
   
     public static clsPersona login(String Usuario,String Pass) throws Exception
    {
        clsPersona objSucursal = null;
        Connection conn =null;
        CallableStatement stmt = null;
        ResultSet dr = null;
        try {
            String sql="exec LoginPersona_sp '"+Usuario+"','"+Pass+"'";

            conn = clsConexion.getConnection();
            stmt = conn.prepareCall(sql);
            dr = stmt.executeQuery();

            if(dr.next())
            {
                    
                    objSucursal = new clsPersona();
                    objSucursal.setInt_IdPersona(dr.getInt(1));
                    objSucursal.setStr_Nombre(dr.getString(2));
                    objSucursal.setStr_Apellido(dr.getString(3));
                    objSucursal.setStr_Telefono(dr.getString(4));
                    objSucursal.setStr_Email(dr.getString(5));
                    objSucursal.setStr_Usuario(dr.getString(6));
                    objSucursal.setStr_Password(dr.getString(7)); 
                    objSucursal.setStr_DNI(dr.getString(8)); 

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
        return objSucursal;
    }

          public static int insertar(clsPersona entidad) throws Exception
    {
        int rpta = 0;
        Connection conn =null;
        Statement stmt = null;
        try {

              String sql="exec InsertarPersona_sp 0 , '"+entidad.getStr_Nombre()+"', '"+entidad.getStr_Apellido()
                    +"', '"+entidad.getStr_Telefono()+"', '"+entidad.getStr_Email()+"', '"+entidad.getStr_Usuario()
                    +"', '"+entidad.getStr_Password()+"', '"+entidad.getStr_DNI()+"', '"+entidad.getInt_Informacion()+"'";
              
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
    
          
     public static int consultarUsuario (String Usuario) throws Exception
    {
         int IdUsuario = 0;
        Connection conn =null;
        CallableStatement stmt = null;
        ResultSet dr = null;
        try {
            String sql="exec VerificaUsuarioPersona_sp '"+Usuario+"'";

            conn = clsConexion.getConnection();
            stmt = conn.prepareCall(sql);
            dr = stmt.executeQuery();

            if(dr.next())
            {
                    IdUsuario=dr.getInt(1);
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
        return IdUsuario;
    }

         public static boolean actualizar(clsPersona entidad) throws Exception
    {
        boolean rpta = false;
        Connection conn =null;
        CallableStatement stmt = null;
        try {
            String sql="exec actualizarPersona_sp '"+entidad.getInt_IdPersona()+"','"+entidad.getStr_Nombre()+
                    "','"+entidad.getStr_Apellido()+"','"+entidad.getStr_Telefono()+"','"+entidad.getStr_Email()+
                    "','"+entidad.getStr_DNI()+"'";
            conn = clsConexion.getConnection();
            stmt = conn.prepareCall(sql);
            
           rpta = stmt.executeUpdate() == 1;
        } catch (Exception e) {
            throw new Exception("Actulizar Persona Reserva"+e.getMessage(), e);
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
         
          public static boolean actualizarClave(clsPersona entidad) throws Exception
    {
        boolean rpta = false;
        Connection conn =null;
        CallableStatement stmt = null;
        try {
            String sql="exec actualizarClavePersona_sp '"+entidad.getInt_IdPersona()+"','"+entidad.getStr_Password()+"'";
            conn = clsConexion.getConnection();
            stmt = conn.prepareCall(sql);
            
           rpta = stmt.executeUpdate() == 1;
        } catch (Exception e) {
            throw new Exception("Actulizar Persona Reserva"+e.getMessage(), e);
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
