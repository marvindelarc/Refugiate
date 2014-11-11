
package DAO;



import Entidades.clsCostoTipoHabitacion;
import Entidades.clsSucursal;
import Entidades.clsTipoHabitacion;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;


import java.util.ArrayList;
import java.util.List;

public class clsCostoTipoHabitacionDAO {
    
    
       public static List<clsCostoTipoHabitacion> listarCostoTipoHabitacionXIdSucursales(int IdSucursal) throws Exception
    {
        List<clsCostoTipoHabitacion> list = null;
        Connection conn =null;
        CallableStatement stmt = null;
        ResultSet dr = null;
        try {
            String sql="exec ListarCostoTipoHabitacionXIdSucursales_sp "+IdSucursal;
            conn = clsConexion.getConnection();
            stmt = conn.prepareCall(sql);
            dr = stmt.executeQuery();

            while(dr.next())
            {
                 if(list == null)
                    list = new ArrayList<clsCostoTipoHabitacion>();
                
                clsTipoHabitacion objTipoHabitacion = new clsTipoHabitacion();
                objTipoHabitacion.setInt_IdTipoHabitacion(dr.getInt(2));
                objTipoHabitacion.setNombreComercial(dr.getString(7));
                
                clsCostoTipoHabitacion objCostoTipoHabitacion = new clsCostoTipoHabitacion();
                objCostoTipoHabitacion.setInt_IdCostoTipoHabitacion(dr.getInt(1));
                objCostoTipoHabitacion.setDou_Costo(dr.getDouble(3));
                objCostoTipoHabitacion.setInt_TotalHabitaciones(dr.getInt(4));
                objCostoTipoHabitacion.setInt_HabitacionesOcupadas(dr.getInt(5));
                objCostoTipoHabitacion.setInt_Estado(dr.getInt(6));
                
                objCostoTipoHabitacion.setObjTipoHabitacion(objTipoHabitacion);

                list.add(objCostoTipoHabitacion);
            }

        } catch (Exception e) {
            throw new Exception("Listar Provincia "+e.getMessage(), e);
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
       
       
     public static List<clsCostoTipoHabitacion> listarCostoTipoHabitacion() throws Exception
    {
        List<clsCostoTipoHabitacion> list = null;
        Connection conn =null;
        CallableStatement stmt = null;
        ResultSet dr = null;
        try {
            String sql="exec ListarCostoTipoHabitacion_sp";
            conn = clsConexion.getConnection();
            stmt = conn.prepareCall(sql);
            dr = stmt.executeQuery();

            while(dr.next())
            {
                 if(list == null)
                    list = new ArrayList<clsCostoTipoHabitacion>();
                
                clsTipoHabitacion objTipoHabitacion = new clsTipoHabitacion();
                objTipoHabitacion.setInt_IdTipoHabitacion(dr.getInt(2));
                objTipoHabitacion.setNombreComercial(dr.getString(4));
                
                clsSucursal objSucursal = new clsSucursal();
                objSucursal.setInt_IdSucursal(dr.getInt(5));
                clsCostoTipoHabitacion objCostoTipoHabitacion = new clsCostoTipoHabitacion();
                objCostoTipoHabitacion.setInt_IdCostoTipoHabitacion(dr.getInt(1));
                objCostoTipoHabitacion.setDou_Costo(dr.getDouble(3));
                objCostoTipoHabitacion.setObjSucursal(objSucursal);
                objCostoTipoHabitacion.setObjTipoHabitacion(objTipoHabitacion);

                list.add(objCostoTipoHabitacion);
            }

        } catch (Exception e) {
            throw new Exception("Listar Provincia "+e.getMessage(), e);
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
       
          public static int insertar(clsCostoTipoHabitacion entidad) throws Exception
    {
        int rpta = 0;
        Connection conn =null;
        Statement stmt = null;
        try {

              String sql="exec InsertarCostoTipoHabitacion_sp 0 , '"+entidad.getObjTipoHabitacion().getInt_IdTipoHabitacion()
                    +"', '"+entidad.getObjSucursal().getInt_IdSucursal()+"', '"+entidad.getDou_Costo()+"', '"+entidad.getInt_TotalHabitaciones()+"'";
              
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
