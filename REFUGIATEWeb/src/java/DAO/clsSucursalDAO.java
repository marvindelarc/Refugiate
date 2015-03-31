package DAO;


import Entidades.clsDepartamento;
import Entidades.clsDistrito;
import Entidades.clsEmpresa;
import Entidades.clsProvincia;
import Entidades.clsSucursal;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;


import java.util.ArrayList;
import java.util.List;

public class clsSucursalDAO {
    
   
        public static int insertar(clsSucursal entidad) throws Exception
    {
        int rpta = 0;
        Connection conn =null;
        Statement stmt = null;
        try {

             String sql="exec InsertarSucursal_sp 0,'"+entidad.getObjEmpresa().getInt_IdEmpresa()+
                    "', '"+entidad.getObjDistrito().getInt_IdDistrito()+"', '"+entidad.getStr_Telefono()
                    +"', '"+entidad.getStr_Direccion()+"', '"+entidad.getDou_Longitud()
                    +"', '"+entidad.getDou_Latitud()+"', '"+entidad.getInt_Pisos()
                    +"', '"+entidad.getInt_Nivel()+"', '"+entidad.getStr_Entrada()+"', '"+entidad.getStr_Salida()+"'";
             
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
        
        
        
    public static boolean cambiarEstado(int IdSucursal,int Estado) throws Exception
    {
        boolean rpta = false;
        Connection conn = null;
        CallableStatement stmt = null;
        try {
              String sql="exec CambiarEstadoSucursal_sp "+IdSucursal+","+Estado;

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
      
    public static List<clsSucursal> listarXIdEmpresa(int IdEmpresa) throws Exception
    {
        List<clsSucursal> list = null;
        Connection conn =null;
        CallableStatement stmt = null;
        ResultSet dr = null;
        try {
            String sql="exec ListarSucursalXIdEmpresa_sp "+IdEmpresa;

            conn = clsConexion.getConnection();
            stmt = conn.prepareCall(sql);
            dr = stmt.executeQuery();

            while(dr.next())
            {
                 if(list == null)
                    list = new ArrayList<clsSucursal>();

                    clsDepartamento objDepartamento = new clsDepartamento();
                    objDepartamento.setInt_IdDepartamento(dr.getInt(23));
                    objDepartamento.setStr_Nombre(dr.getString(24));

                    clsProvincia objProvincia = new clsProvincia();
                    objProvincia.setInt_IdProvincia(dr.getInt(21));
                    objProvincia.setStr_Nombre(dr.getString(22));
                    objProvincia.setObjDepartamento(objDepartamento);

                    clsDistrito objDistrito=new clsDistrito();
                    objDistrito.setInt_IdDistrito(dr.getInt(3));
                    objDistrito.setStr_Nombre(dr.getString(20));
                    objDistrito.setObjProvincia(objProvincia);                

                    clsEmpresa objEmpresa=new clsEmpresa(); 
                    objEmpresa.setInt_IdEmpresa(dr.getInt(2));
                    objEmpresa.setStr_NombreComercial(dr.getString(13));
                    objEmpresa.setStr_Nombre(dr.getString(14));
                    objEmpresa.setStr_Slogan(dr.getString(15));
                    objEmpresa.setStr_Ruc(dr.getString(16));
                    objEmpresa.setInt_Estado(dr.getInt(17));
                    objEmpresa.setInt_Puntos(dr.getInt(18));
                    objEmpresa.setDat_FechaRegistro(dr.getTimestamp(19));

                    clsSucursal objSucursal = new clsSucursal();
                    objSucursal.setInt_IdSucursal(dr.getInt(1));
                    objSucursal.setStr_Telefono(dr.getString(4));
                    objSucursal.setStr_Direccion(dr.getString(5));
                    objSucursal.setDou_Longitud(dr.getDouble(6));
                    objSucursal.setDou_Latitud(dr.getDouble(7));
                    objSucursal.setInt_Pisos(dr.getInt(8));
                    objSucursal.setInt_Puntos(dr.getInt(9));
                    objSucursal.setInt_Nivel(dr.getInt(10));
                    objSucursal.setInt_Estado(dr.getInt(11));
                    objSucursal.setDat_FechaRegistro(dr.getTimestamp(12));
                    objSucursal.setObjEmpresa(objEmpresa);
                    objSucursal.setObjDistrito(objDistrito);

                    list.add(objSucursal);
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
        return list;
    }
    
    
    
    
    public static List<clsSucursal> listarServicio() throws Exception
    {
        List<clsSucursal> list = null;
        Connection conn =null;
        CallableStatement stmt = null;
        ResultSet dr = null;
        try {
            String sql="exec ListarSucursalServicio_sp";

            conn = clsConexion.getConnection();
            stmt = conn.prepareCall(sql);
            dr = stmt.executeQuery();

            while(dr.next())
            {
                 if(list == null)
                    list = new ArrayList<clsSucursal>();

                    clsEmpresa objEmpresa=new clsEmpresa(); 
                    objEmpresa.setStr_NombreComercial(dr.getString(6));                    
                    clsSucursal objSucursal = new clsSucursal();
                    objSucursal.setInt_IdSucursal(dr.getInt(1));
                    objSucursal.setInt_Nivel(dr.getInt(2));
                    objSucursal.setDou_Longitud(dr.getDouble(3));
                    objSucursal.setDou_Latitud(dr.getDouble(4));
                    objSucursal.setInt_Estado(dr.getInt(5));
                    objSucursal.setInt_Puntos(dr.getInt(7));
                    
                    objSucursal.setObjEmpresa(objEmpresa);

                    list.add(objSucursal);
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
        return list;
    }
    
     public static clsSucursal buscarId(int Id) throws Exception
    {
        clsSucursal objSucursal = null;
        Connection conn =null;
        CallableStatement stmt = null;
        ResultSet dr = null;
        try {
            String sql="exec SucursalXId_sp "+Id;

            conn = clsConexion.getConnection();
            stmt = conn.prepareCall(sql);
            dr = stmt.executeQuery();

            if(dr.next())
            {

                
                    clsEmpresa objEmpresa=new clsEmpresa(); 
                    objEmpresa.setStr_Nombre(dr.getString(15));   
                    
                    clsDistrito objDistrito=new clsDistrito();
                    objDistrito.setStr_Nombre(dr.getString(16));
                    
                    objSucursal = new clsSucursal();
                    objSucursal.setInt_IdSucursal(dr.getInt(1));
                    objSucursal.setStr_Telefono(dr.getString(2));
                    objSucursal.setStr_Direccion(dr.getString(3));
                    objSucursal.setDou_Longitud(dr.getDouble(4));
                    objSucursal.setDou_Latitud(dr.getDouble(5));
                    objSucursal.setInt_Pisos(dr.getInt(6));
                    objSucursal.setInt_Limpieza(dr.getInt(7));                    
                    objSucursal.setInt_Servicio(dr.getInt(8));
                    objSucursal.setInt_Comodidad(dr.getInt(9));
                    objSucursal.setInt_Puntos(dr.getInt(10));
                    objSucursal.setInt_Nivel(dr.getInt(11));
                    objSucursal.setInt_Estado(dr.getInt(12));
                    objSucursal.setStr_Entrada(dr.getString(13));
                    objSucursal.setStr_Salida(dr.getString(14));                        
                    objSucursal.setObjEmpresa(objEmpresa);
                    objSucursal.setObjDistrito(objDistrito);

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
// 

   public static List<clsSucursal> ListarXEstado(int Estado) throws Exception
    {
        List<clsSucursal> lista = null;
        Connection conn =null;
        CallableStatement stmt = null;
        ResultSet dr = null;
        try {
            String sql="exec ListarSucursalesXEstado_sp "+Estado;

            conn = clsConexion.getConnection();
            stmt = conn.prepareCall(sql);
            dr = stmt.executeQuery();

            while(dr.next())
            {
                if(lista==null)
                    lista = new ArrayList<clsSucursal>();
                
                   clsDepartamento objDepartamento = new clsDepartamento();
                  objDepartamento.setStr_Nombre(dr.getString(18));
                  
                    clsProvincia objProvincia = new clsProvincia();
                    objProvincia.setStr_Nombre(dr.getString(17));
                    objProvincia.setObjDepartamento(objDepartamento);
                
                    clsEmpresa objEmpresa=new clsEmpresa(); 
                    objEmpresa.setStr_Nombre(dr.getString(15));   
                    
                    clsDistrito objDistrito=new clsDistrito();
                    objDistrito.setStr_Nombre(dr.getString(16));
                    objDistrito.setObjProvincia(objProvincia);
                    
                    clsSucursal objSucursal = new clsSucursal();
                    objSucursal.setInt_IdSucursal(dr.getInt(1));
                    objSucursal.setStr_Telefono(dr.getString(2));
                    objSucursal.setStr_Direccion(dr.getString(3));
                    objSucursal.setDou_Longitud(dr.getDouble(4));
                    objSucursal.setDou_Latitud(dr.getDouble(5));
                    objSucursal.setInt_Pisos(dr.getInt(6));
                    objSucursal.setInt_Limpieza(dr.getInt(7));                    
                    objSucursal.setInt_Servicio(dr.getInt(8));
                    objSucursal.setInt_Comodidad(dr.getInt(9));
                    objSucursal.setInt_Puntos(dr.getInt(10));
                    objSucursal.setInt_Nivel(dr.getInt(11));
                    objSucursal.setInt_Estado(dr.getInt(12));
                    objSucursal.setStr_Entrada(dr.getString(13));
                    objSucursal.setStr_Salida(dr.getString(14));                        
                    objSucursal.setObjEmpresa(objEmpresa);
                    objSucursal.setObjDistrito(objDistrito);
                    
                    lista.add(objSucursal);

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
        return lista;
    }

}
