package DAO;



import Entidades.clsCostoTipoHabitacion;
import Entidades.clsDetalleReserva;
import Entidades.clsEmpresa;
import Entidades.clsPersona;
import Entidades.clsReserva;
import Entidades.clsSucursal;
import Entidades.clsTipoHabitacion;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;


public class clsReservaDAO {
    
   
        public static int insertar(clsReserva entidad) throws Exception
    {
        int rpta = 0;
        Connection conn =null;
        Statement stmt = null;
        try {

             String sql="exec InsertarReserva_sp 0,"+entidad.getObjPersona().getInt_IdPersona()+","+entidad.getInt_IdSucursal();
             
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
    
        public static int insertarDetalle(clsDetalleReserva entidad) throws Exception
    {
        int rpta = 0;
        Connection conn =null;
        Statement stmt = null;
        try {
             SimpleDateFormat  dato=new SimpleDateFormat("dd-MM-yyyy");
             String fecha=dato.format(entidad.getDat_FechaIngreso());
             String sql="exec InsertarDetalleReserva_sp 0,'"+fecha+"',"+entidad.getObjCostoTipoHabitacion().getInt_IdCostoTipoHabitacion()
                     +","+entidad.getObjReserva().getInt_IdReserva()+","+entidad.getInt_NHabitaciones()+","+entidad.getInt_Dias()
                     +",'"+entidad.getDou_Total()+"'";
             
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
        
    
        
           public static List<clsReserva> listarXIdSucursal(int IdSucursal) throws Exception
    {
        List<clsReserva> list = null;
        Connection conn =null;
        CallableStatement stmt = null;
        ResultSet dr = null;
        try {
            String sql="exec ListarReservasXIdSucursales_sp "+IdSucursal;

            conn = clsConexion.getConnection();
            stmt = conn.prepareCall(sql);
            dr = stmt.executeQuery();

            while(dr.next())
            {
                 if(list == null)
                    list = new ArrayList<clsReserva>();
                 
                clsPersona objPersona = new clsPersona();
                objPersona.setInt_IdPersona(dr.getInt(4));
                objPersona.setStr_Apellido(dr.getString(5));
                objPersona.setStr_DNI(dr.getString(6));
                objPersona.setStr_Email(dr.getString(7));
                objPersona.setStr_Nombre(dr.getString(8));
                objPersona.setStr_Telefono(dr.getString(9));
                objPersona.setStr_Usuario(dr.getString(10));
                
                 
                 
                clsReserva objDistrito = new clsReserva();
                objDistrito.setInt_IdReserva(dr.getInt(1));
                objDistrito.setDat_FechaResgistro(dr.getTimestamp(2));
                objDistrito.setInt_Estado(dr.getInt(3));
                objDistrito.setObjPersona(objPersona);
                

                list.add(objDistrito);
            }

        } catch (Exception e) {
            throw new Exception("Listar Distrito "+e.getMessage(), e);
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
      
        public static List<clsDetalleReserva> listarXIdPersona(int IdPersona) throws Exception
    {
        List<clsDetalleReserva> list = null;
        Connection conn =null;
        CallableStatement stmt = null;
        ResultSet dr = null;
        try {
            String sql="exec ListarReservasXIdPersona_sp "+IdPersona;

            conn = clsConexion.getConnection();
            stmt = conn.prepareCall(sql);
            dr = stmt.executeQuery();

            while(dr.next())
            {
                 if(list == null)
                    list = new ArrayList<clsDetalleReserva>();
               
                    clsEmpresa objEmpresa= new clsEmpresa();
                    objEmpresa.setStr_NombreComercial(dr.getString(9));
                    
                    clsSucursal objSucursal=new clsSucursal();
                    objSucursal.setObjEmpresa(objEmpresa);

                    clsTipoHabitacion objTipoHabitacion = new clsTipoHabitacion();
                    objTipoHabitacion.setNombreComercial(dr.getString(8));


                    clsCostoTipoHabitacion objCostoTipoHabitacion=new clsCostoTipoHabitacion();
                    objCostoTipoHabitacion.setInt_IdCostoTipoHabitacion(dr.getInt(3));
                    objCostoTipoHabitacion.setObjSucursal(objSucursal);
                    objCostoTipoHabitacion.setObjTipoHabitacion(objTipoHabitacion);
                    
                    clsReserva objReserva=new clsReserva();
                    objReserva.setInt_IdReserva(dr.getInt(4));
                    

                    clsDetalleReserva objDetalleReserva = new clsDetalleReserva();
                    objDetalleReserva.setInt_IdDetalleReserva(dr.getInt(1));
                    objDetalleReserva.setDat_FechaIngreso(dr.getTimestamp(2));
                    objDetalleReserva.setInt_NHabitaciones(dr.getInt(5));
                    objDetalleReserva.setInt_Dias(dr.getInt(6));
                    objDetalleReserva.setDou_Total(dr.getDouble(7));
                    objDetalleReserva.setObjCostoTipoHabitacion(objCostoTipoHabitacion);
                    objDetalleReserva.setObjReserva(objReserva);
                    objDetalleReserva.setInt_IdComentario(dr.getInt(10));
                    objDetalleReserva.setInt_IdPuntuacion(dr.getInt(11));
                list.add(objDetalleReserva);
            }

        } catch (Exception e) {
            throw new Exception("Listar Detalle Reserva "+e.getMessage(), e);
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
            
           
                   
    public static boolean activar(int IdReserva) throws Exception
    {
        boolean rpta = false;
        Connection conn = null;
        CallableStatement stmt = null;
        try {
              String sql="exec ActivarReserva_sp "+IdReserva;

            conn = clsConexion.getConnection();
            stmt = conn.prepareCall(sql);
            rpta = stmt.executeUpdate() == 1;

        } catch (Exception e) {
            throw new Exception("Cambiar Estado "+e.getMessage(), e);
        }finally{
            try {
                stmt.close();
                conn.close();
            } catch (Exception e) {
            }
        }
        return rpta;
    }    

}
