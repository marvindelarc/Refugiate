package COM;

import DAO.clsBajaEmpresaPersonaDAO;
import DAO.clsComentarioDAO;
import DAO.clsCostoTipoHabitacionDAO;
import DAO.clsDepartamentoDAO;
import DAO.clsDetalleReservaDAO;
import DAO.clsDistritoDAO;
import DAO.clsEmpresaDAO;
import DAO.clsEncargadoDAO;
import DAO.clsHabitacionDAO;
import DAO.clsIntalacionDAO;
import DAO.clsPagoEmpresaDAO;
import DAO.clsPaqueteDAO;
import DAO.clsPersonaDAO;
import DAO.clsPromocionesDAO;
import DAO.clsProvinciaDAO;
import DAO.clsPuntuacionHotelDAO;
import DAO.clsPuntuacionUsuarioDAO;
import DAO.clsReservaDAO;
import DAO.clsServicioDAO;
import DAO.clsSucursalDAO;
import DAO.clsTipoHabitacionDAO;
import DAO.clsWebAdminDAO;
import Entidades.clsBajaEmpresaPersona;
import Entidades.clsComentario;
import Entidades.clsCostoTipoHabitacion;
import Entidades.clsDepartamento;
import Entidades.clsDetalleReserva;
import Entidades.clsDistrito;
import Entidades.clsEmpresa;
import Entidades.clsEncargado;
import Entidades.clsHabitacion;
import Entidades.clsIntalacion;
import Entidades.clsPagoEmpresa;
import Entidades.clsPaquete;
import Entidades.clsPersona;
import Entidades.clsPromociones;
import Entidades.clsProvincia;
import Entidades.clsPuntuacionHotel;
import Entidades.clsPuntuacionUsuario;
import Entidades.clsReserva;
import Entidades.clsServicio;
import Entidades.clsSucursal;
import Entidades.clsTipoHabitacion;
import Entidades.clsWebAdmin;
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
    
    //<editor-fold defaultstate="collapsed" desc="clsComentario">
    public static List<clsComentario> ListarComentario(boolean activo) throws Exception
    {
        return clsComentarioDAO.Listar(activo);
    }
    public static int insertarComentario(clsComentario entidad) throws Exception
    {
        return clsComentarioDAO.insertar(entidad);
    }
    public static boolean actualizarComentario(clsComentario entidad) throws Exception
    {
        return clsComentarioDAO.actualizar(entidad);
    }
    // </editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="clsCostoTipoHabitacion">
    public static List<clsCostoTipoHabitacion> ListarCostoTipoHabitacion(boolean activo) throws Exception
    {
        return clsCostoTipoHabitacionDAO.Listar(activo);
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
    
    //<editor-fold defaultstate="collapsed" desc="clsDetalleReserva">
    public static List<clsDetalleReserva> ListarDetalleReservas(boolean ectivo) throws Exception
    {
        return clsDetalleReservaDAO.Listar(ectivo);
    }
    public static int insertarDetalleReserva(clsDetalleReserva entidad) throws Exception
    {
        return clsDetalleReservaDAO.insertar(entidad);
    }
    public static boolean actualizarDetalleReserva(clsDetalleReserva entidad) throws Exception
    {
        return clsDetalleReservaDAO.actualizar(entidad);
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
        return clsEncargadoDAO.insertar(entidad);
    }
    
    public static boolean actualizarEncargado(clsEncargado entidad) throws Exception
    {
        return clsEncargadoDAO.actualizar(entidad);
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
    // </editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="clsIntalacion">
    public static List<clsIntalacion> ListarIntalacion(boolean activo) throws Exception
    {
        return clsIntalacionDAO.Listar(activo);
    }
    
    public  static int insertarIntalacion(clsIntalacion entidad) throws Exception
    {
        return clsIntalacionDAO.insertar(entidad);
    }
    
    public static boolean actualizarIntalacion(clsIntalacion entidad) throws Exception
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
    
    //<editor-fold defaultstate="collapsed" desc="clsPuntuacionHotel">
    public static List<clsPuntuacionHotel> listarPuntuacionHotel(boolean activo) throws Exception
    {
        return clsPuntuacionHotelDAO.Listar(activo);
    }
    
    public  static int insertarPuntuacionHotel(clsPuntuacionHotel entidad) throws Exception
    {
        return clsPuntuacionHotelDAO.insertar(entidad);
    }
    
    public static boolean actualizarPuntuacionHotel(clsPuntuacionHotel entidad) throws Exception
    {
        return clsPuntuacionHotelDAO.actualizar(entidad);
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
    // </editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="clsServicio">
    public static List<clsServicio> ListarServicio(boolean activo) throws Exception
    {
        return clsServicioDAO.Listar(activo);
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