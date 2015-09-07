package COM;

import DAO.*;
import Entidades.*;
import java.util.List;

/**
 *
 * @author Paulo
 */
public class clsGestor {
    
    //<editor-fold defaultstate="collapsed" desc="clsBajaEmpresaPersona">
    public static List<clsBajaEmpresaPersona> ListarBajaEmpresaPersonas (boolean activo) throws Exception
    {
        return clsBajaEmpresaPersonaDAO.Listar(activo);
    }
    public static int InsertarBajaEmpresaPersona(clsBajaEmpresaPersona entidad) throws Exception
    {
        return clsBajaEmpresaPersonaDAO.insertar(entidad);
    }
    public static boolean ActualizarBajaEmpresaPersona(clsBajaEmpresaPersona entidad) throws Exception
    {
        return clsBajaEmpresaPersonaDAO.actualizar(entidad);
    }
    // </editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="clsCostoTipoHabitacion">
    
    public static List<clsCostoTipoHabitacion> ListarCostoTipoHabitacion(boolean activo) throws Exception
    {
        return clsCostoTipoHabitacionDAO.Listar(activo);
    }
    public static List<clsCostoTipoHabitacion> ListarCostoTipoHabitacionServicio(Long actualizacion) throws Exception
    {
        return clsCostoTipoHabitacionDAO.ListarServicio(actualizacion);
    }
    public static int insertarCostoTipoHabitacion(clsCostoTipoHabitacion entidad) throws Exception
    {
        return clsCostoTipoHabitacionDAO.insertar(entidad);
    }
    public static boolean actualizarCostoTipoHabitacion(clsCostoTipoHabitacion entidad) throws Exception
    {
        return clsCostoTipoHabitacionDAO.actualizar(entidad);
    }
    // </editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="clsDepartamento">
    public static List<clsDepartamento> ListarDepartamento(boolean activo) throws Exception{
        return clsDepartamentoDAO.Listar(activo);
    }
    // </editor-fold>
  
    //<editor-fold defaultstate="collapsed" desc="clsDistrito">
    public static List<clsDistrito> listarDistrito(int idProvincia) throws Exception
    {
        return clsDistritoDAO.Listar(idProvincia);
    }
    // </editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="clsEmpresa">
    public static List<clsEmpresa> ListarEmpresa(boolean activo) throws Exception
    {
        return clsEmpresaDAO.Listar(activo);
    }
    public static List<clsEmpresa> ListarEmpresaServicio(Long actualizacion) throws Exception
    {
        return clsEmpresaDAO.ListarServicio(actualizacion);
    }
    
    public  static int insertarEmpresa(clsEmpresa entidad) throws Exception
    {
        return clsEmpresaDAO.insertar(entidad);
    }
    
    public static boolean actualizarEmpresa(clsEmpresa entidad) throws Exception
    {
        return clsEmpresaDAO.actualizar(entidad);
    }    
    // </editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="clsEncargado">
    public static List<clsEncargado> ListarEncargado(boolean activo) throws Exception
    {
        return clsEncargadoDAO.Listar(activo);
    }
    
    public  static int insertarEncargado(clsEncargado entidad) throws Exception
    {
        return clsEncargadoDAO.insertarRegistro(entidad);
    }
    
    public static boolean actualizarEncargado(clsEncargado entidad) throws Exception
    {
        return clsEncargadoDAO.actualizar(entidad);
    }    
    public static clsEncargado loginEncargado(String usuario,String password) throws Exception
    {
        return clsEncargadoDAO.login(usuario, password);
    }  
    
    // </editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="clsHabitacion">
    public static List<clsHabitacion> ListarHabitacion(boolean activo) throws Exception
    {
        return clsHabitacionDAO.Listar(activo);
    }
    
    public  static int insertarHabitacion(clsHabitacion entidad) throws Exception
    {
        return clsHabitacionDAO.insertar(entidad);
    }
    
    public static boolean actualizarHabitacion(clsHabitacion entidad) throws Exception
    {
        return clsHabitacionDAO.actualizar(entidad);
    }  
    public static List<clsHabitacion> ListarDisponibilidadHabitacion(int idCostoTipoHabitacion) throws Exception
    {
        return clsHabitacionDAO.ListarDisponibilidad(idCostoTipoHabitacion);
    }
    // </editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="clsInstalacion">
    public static List<clsInstalacion> ListarIntalacion(boolean activo) throws Exception
    {
        return clsIntalacionDAO.Listar(activo);
    }
    public static List<clsInstalacion> ListarIntalacionServicio(Long actualizacion) throws Exception
    {
        return clsIntalacionDAO.ListarServicio(actualizacion);
    }
    
    public  static int insertarIntalacion(clsInstalacion entidad) throws Exception
    {
        return clsIntalacionDAO.insertar(entidad);
    }
    
    public static boolean actualizarIntalacion(clsInstalacion entidad) throws Exception
    {
        return clsIntalacionDAO.actualizar(entidad);
    }    
    // </editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="clsPagoEmpresa">
    public static List<clsPagoEmpresa> ListarPagoEmpresa(boolean activo) throws Exception
    {
        return clsPagoEmpresaDAO.Listar(activo);
    }
    
    public  static int insertarPagoEmpresa(clsPagoEmpresa entidad) throws Exception
    {
        return clsPagoEmpresaDAO.insertar(entidad);
    }
    
    public static boolean actualizarPagoEmpresa(clsPagoEmpresa entidad) throws Exception
    {
        return clsPagoEmpresaDAO.actualizar(entidad);
    }    
    // </editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="clsPaquete">
    public static List<clsPaquete> ListarPaquete(boolean activo) throws Exception
    {
        return clsPaqueteDAO.Listar(activo);
    }
    
    public  static int insertarPaquete(clsPaquete entidad) throws Exception
    {
        return clsPaqueteDAO.insertar(entidad);
    }
    
    public static boolean actualizarPaquete(clsPaquete entidad) throws Exception
    {
        return clsPaqueteDAO.actualizar(entidad);
    }    
    // </editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="clsPersona">
    public static List<clsPersona> ListarPersona(boolean activo) throws Exception
    {
        return clsPersonaDAO.Listar(activo);
    }
    
    public  static int insertarPersona(clsPersona entidad) throws Exception
    {
        return clsPersonaDAO.insertar(entidad);
    }
    
    public static boolean actualizarPersona(clsPersona entidad) throws Exception
    {
        return clsPersonaDAO.actualizar(entidad);
    }    
    
    public static clsPersona loginPersona(String usuario,String password) throws Exception
    {
        return clsPersonaDAO.login(usuario, password);
    } 
    // </editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="clsPromociones">
    public static List<clsPromociones> ListarPromociones(boolean activo) throws Exception
    {
        return clsPromocionesDAO.Listar(activo);
    }
    
    public  static int insertarPromociones(clsPromociones entidad) throws Exception
    {
        return clsPromocionesDAO.insertar(entidad);
    }
    
    public static boolean actualizarPromociones(clsPromociones entidad) throws Exception
    {
        return clsPromocionesDAO.actualizar(entidad);
    }    
    // </editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="clsProvincia">
    public static List<clsProvincia> listarProvincia(int IdDepartamento) throws Exception
    {
        return clsProvinciaDAO.Listar(IdDepartamento);
    }
    // </editor-fold>
   
    //<editor-fold defaultstate="collapsed" desc="clsPuntuacionUsuario">
    public static List<clsPuntuacionUsuario> listarPuntuacionUsuario(boolean activo) throws Exception
    {
        return clsPuntuacionUsuarioDAO.Listar(activo);
    }
    
    public  static int insertarPuntuacionUsuario(clsPuntuacionUsuario entidad) throws Exception
    {
        return clsPuntuacionUsuarioDAO.insertar(entidad);
    }
    
    public static boolean actualizarPuntuacionUsuario(clsPuntuacionUsuario entidad) throws Exception
    {
        return clsPuntuacionUsuarioDAO.actualizar(entidad);
    }    
    // </editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="clsReserva">
    public static List<clsReserva> ListarReserva(boolean activo) throws Exception
    {
        return clsReservaDAO.Listar(activo);
    }
    
    public  static int insertarReserva(clsReserva entidad) throws Exception
    {
        return clsReservaDAO.insertar(entidad);
    }
    
    public static boolean actualizarReserva(clsReserva entidad) throws Exception
    {
        return clsReservaDAO.actualizar(entidad);
    }   
    public static boolean actualizarPuntacionReserva(clsReserva entidad) throws Exception
    {
        return clsReservaDAO.actualizarPuntacion(entidad);
    }   
    
     public static boolean actualizarEstadoReserva(int idReserva, int Estado) throws Exception
    {
        return clsReservaDAO.actualizarEstado(idReserva,Estado);
    }   
     public static List<clsReserva> ListarServicioReserva(Long actualizacion,int idPersona) throws Exception
    {
        return clsReservaDAO.ListarServicio(actualizacion, idPersona);
    }   
    // </editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="clsServicio">
    public static List<clsServicio> ListarServicio(boolean activo) throws Exception
    {
        return clsServicioDAO.Listar(activo);
    }
    
    public static List<clsServicio> ListarServicioServicio(Long actualizacion) throws Exception
    {
        return clsServicioDAO.ListarServicio(actualizacion);
    }
    
    public  static int insertarServicio(clsServicio entidad) throws Exception
    {
        return clsServicioDAO.insertar(entidad);
    }
    
    public static boolean actualizarServicio(clsServicio entidad) throws Exception
    {
        return clsServicioDAO.actualizar(entidad);
    }    
    // </editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="clsSucursal">
    public static List<clsSucursal> listarSucursal(boolean activo) throws Exception
    {
        return clsSucursalDAO.Listar(activo);
    }
    public static List<clsSucursal> listarServicioSucursal(Long actualizacion) throws Exception
    {
        return clsSucursalDAO.ListarServicio(actualizacion);
    }
    public static List<clsSucursal> listarSucursalPorDistrito(int idEmpresa) throws Exception
    {
        return clsSucursalDAO.ListarPorDistrito(idEmpresa);
    }
    public  static int insertarSucursal(clsSucursal entidad) throws Exception
    {
        return clsSucursalDAO.insertar(entidad);
    }
    
    public static boolean actualizarSucursal(clsSucursal entidad) throws Exception
    {
        return clsSucursalDAO.actualizar(entidad);
    }    
    // </editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="clsTipoHabitacion">
    public static List<clsTipoHabitacion> ListarTipoHabitacion(boolean activo) throws Exception
    {
        return clsTipoHabitacionDAO.Listar(activo);
    }
    
    public  static int insertarTipoHabitacion(clsTipoHabitacion entidad) throws Exception
    {
        return clsTipoHabitacionDAO.insertar(entidad);
    }
    
    public static boolean actualizarTipoHabitacion(clsTipoHabitacion entidad) throws Exception
    {
        return clsTipoHabitacionDAO.actualizar(entidad);
    }    
    // </editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="clsWebAdmin">
    public static List<clsWebAdmin> ListarWebAdmin(boolean activo) throws Exception
    {
        return clsWebAdminDAO.Listar(activo);
    }
    
    public  static int insertarWebAdmin(clsWebAdmin entidad) throws Exception
    {
        return clsWebAdminDAO.insertar(entidad);
    }
    
    public static boolean actualizarWebAdmin(clsWebAdmin entidad) throws Exception
    {
        return clsWebAdminDAO.actualizar(entidad);
    }    
    // </editor-fold>
}