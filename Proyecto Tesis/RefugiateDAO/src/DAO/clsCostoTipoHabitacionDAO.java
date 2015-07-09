package DAO;

import Entidades.clsCostoTipoHabitacion;
import Entidades.clsSucursal;
import Entidades.clsTipoHabitacion;
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
public class clsCostoTipoHabitacionDAO {
     public static List<clsCostoTipoHabitacion> Listar(boolean activo) throws Exception
    {
        List<clsCostoTipoHabitacion> lista = null;
        Connection conn =null;
        CallableStatement stmt = null;
        ResultSet dr = null;
        try {
            String sql="SELECT idCostoTipoHabitacion,idTipoHabitacion,idSucursal,costo,numeroPersonas,totalHabitaicones,habitacionesOcupadas,estado,updae FROM costotipohabitacion";
            if(activo)
                    sql+=" where estado=1"; 
            conn = clsConexion.getConnection();
            stmt = conn.prepareCall(sql);
            dr = stmt.executeQuery();

            while(dr.next())
            {
                if(lista==null)
                {
                    lista= new ArrayList<clsCostoTipoHabitacion>(); 
                }  
                clsTipoHabitacion objTipoHabitacion = new clsTipoHabitacion();
                objTipoHabitacion.setIdTipoHabitacion(dr.getInt(2));
                
                clsSucursal objSucursal = new clsSucursal();
                objSucursal.setIdSucursal(dr.getInt(3));
                
                clsCostoTipoHabitacion entidad = new clsCostoTipoHabitacion();
                entidad.setIdCostoTipoHabitacion(dr.getInt(1));
                entidad.setObjTipohabitacion(objTipoHabitacion);
                entidad.setObjSucursal(objSucursal);
                entidad.setCosto(dr.getDouble(4));
                entidad.setNumeroPersonas(dr.getInt(5));
                entidad.setTotalHabitaciones(dr.getInt(6));
                entidad.setHabitacionesOcupadas(dr.getInt(7));                
                entidad.setEstado(dr.getInt(8));  
                entidad.setUpdate(dr.getTimestamp(9));  
                lista.add(entidad);                
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
    
    public  static int insertar(clsCostoTipoHabitacion entidad) throws Exception
    {
        int rpta = 0;
        Connection conn = null;
        PreparedStatement  stmt = null;
        try {
            
            String sql= "INSERT INTO costotipohabitacion(idTipoHabitacion,idSucursal,costo,numeroPersonas,totalHabitaicones,estado)"
                    + " VALUES(?,?,?,?,?,?);";
           
            conn = clsConexion.getConnection();
            stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setInt(1, entidad.getObjTipohabitacion().getIdTipoHabitacion());
            stmt.setInt(2, entidad.getObjSucursal().getIdSucursal());
            stmt.setDouble(3, entidad.getCosto());
            stmt.setInt(4, entidad.getNumeroPersonas());
            stmt.setInt(5, entidad.getTotalHabitaciones());                       
            stmt.setInt(6, entidad.getEstado());
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
    
    public static boolean actualizar(clsCostoTipoHabitacion entidad) throws Exception
    {
        boolean rpta = false;
        Connection conn =null;
        CallableStatement stmt = null;
        try {
             String sql="UPDATE costotipohabitacion SET idTipoHabitacion = ?,idSucursal = 1,costo = ?,numeroPersonas = ?,totalHabitaicones = ?,estado = ? WHERE idCostoTipoHabitacion = ?";
             
            conn = clsConexion.getConnection();
            stmt = conn.prepareCall(sql);             
            stmt.setInt(1, entidad.getObjTipohabitacion().getIdTipoHabitacion());
            //stmt.setInt(2, entidad.getObjSucursal().getIdSucursal());
            stmt.setDouble(2, entidad.getCosto());
            stmt.setInt(3, entidad.getNumeroPersonas());
            stmt.setInt(4, entidad.getTotalHabitaciones());            
            stmt.setInt(5, entidad.getEstado());
            stmt.setInt(6, entidad.getIdCostoTipoHabitacion());
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