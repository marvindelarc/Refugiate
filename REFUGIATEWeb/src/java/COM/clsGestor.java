/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package COM;

import DAO.clsComentarioDAO;
import DAO.clsCostoTipoHabitacionDAO;
import DAO.clsDepartamentoDAO;
import DAO.clsDistritoDAO;
import DAO.clsEmpresaDAO;
import DAO.clsEncargadoDAO;
import DAO.clsInstalacionDAO;
import DAO.clsPersonaDAO;
import DAO.clsProvinciaDAO;
import DAO.clsPuntuacionDAO;
import DAO.clsReservaDAO;
import DAO.clsServicioDAO;
import DAO.clsSucursalDAO;
import DAO.clsTipoHabitacionDAO;
import DAO.clsWebAdminDAO;
import Entidades.clsComentario;
import Entidades.clsCostoTipoHabitacion;
import Entidades.clsDepartamento;
import Entidades.clsDetalleReserva;
import Entidades.clsDistrito;
import Entidades.clsEmpresa;
import Entidades.clsEncargado;
import Entidades.clsInstalacion;
import Entidades.clsPersona;
import Entidades.clsProvincia;
import Entidades.clsPuntuacion;
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

//<editor-fold defaultstate="collapsed" desc=" clsReserva ">
public  int insertarReserva(clsReserva entidad) throws Exception
{
return clsReservaDAO.insertar(entidad);
}
public int insertarDetalleReserva(clsDetalleReserva entidad) throws Exception
{
return clsReservaDAO.insertarDetalle(entidad);
}
public  List<clsReserva> listarXIdSucursal(int IdSucursal) throws Exception
{
return clsReservaDAO.listarXIdSucursal(IdSucursal);
}
public  boolean activar(int IdReserva) throws Exception
{
return clsReservaDAO.activar(IdReserva);
}
public  List<clsDetalleReserva> listarXIdPersona(int IdPersona) throws Exception
{
return clsReservaDAO.listarXIdPersona(IdPersona); 
}
// </editor-fold>    

//<editor-fold defaultstate="collapsed" desc=" clsEmpresa ">
public int insertarEmpresa(clsEmpresa entidad) throws Exception
{
return clsEmpresaDAO.insertar(entidad);
}
public  int insertarSucursal(clsSucursal entidad) throws Exception
{
return  clsSucursalDAO.insertar(entidad);
}
// </editor-fold>    

//<editor-fold defaultstate="collapsed" desc=" clsEncargado ">

public  int insertarEncargado(clsEncargado entidad) throws Exception
{
return clsEncargadoDAO.insertar(entidad);
}
public  clsEncargado loginEncargado(String Usuario,String Pass) throws Exception
{
return clsEncargadoDAO.login(Usuario, Pass);
}
// </editor-fold>    

//<editor-fold defaultstate="collapsed" desc=" clsSucursal ">
public List<clsSucursal> listarXIdEmpresaSucursal(int IdEmpresa) throws Exception
{
return clsSucursalDAO.listarXIdEmpresa(IdEmpresa);
}
public List<clsSucursal> listarServicioEmpresa() throws Exception
{
return clsSucursalDAO.listarServicio();
}
public clsSucursal buscarIdSucursal(int Id) throws Exception
{
return clsSucursalDAO.buscarId(Id);
}
public  List<clsSucursal> ListarXEstadoSucursal(int Estado) throws Exception
{
return clsSucursalDAO.ListarXEstado(Estado);
}
public static boolean cambiarEstadoSucursal(int IdSucursal,int Estado) throws Exception
{
return clsSucursalDAO.cambiarEstado(IdSucursal, Estado);
}
// </editor-fold>  

//<editor-fold defaultstate="collapsed" desc=" clsPersona ">
public  clsPersona loginPersona(String Usuario,String Pass) throws Exception
{
return clsPersonaDAO.login(Usuario, Pass);
}
public  int insertarPersona(clsPersona entidad) throws Exception
{
return clsPersonaDAO.insertar(entidad);
}
public static int consultarUsuarioPersona (String Usuario) throws Exception
{
return clsPersonaDAO.consultarUsuario(Usuario);
}
public static boolean actualizarPersona(clsPersona entidad) throws Exception
{
return clsPersonaDAO.actualizar(entidad);
}
public static boolean actualizarClavePersona(clsPersona entidad) throws Exception
{
return clsPersonaDAO.actualizarClave(entidad);
}

// </editor-fold>  

//<editor-fold defaultstate="collapsed" desc=" clsCostoTipoHabitacion ">
public  List<clsCostoTipoHabitacion> listarCostoTipoHabitacionXIdSucursales(int IdSucursal) throws Exception
{
return clsCostoTipoHabitacionDAO.listarCostoTipoHabitacionXIdSucursales(IdSucursal);
}
public  List<clsCostoTipoHabitacion> listarCostoTipoHabitacion() throws Exception
{
return clsCostoTipoHabitacionDAO.listarCostoTipoHabitacion();
}
public  int insertarTipoHabitacion(clsCostoTipoHabitacion entidad) throws Exception
{
return clsCostoTipoHabitacionDAO.insertar(entidad);
}
// </editor-fold>  

//<editor-fold defaultstate="collapsed" desc=" clsTipoHabitacion ">
public List<clsTipoHabitacion> ListarDiferenteTipoHabitacion(int IdSucursal) throws Exception
{
return  clsTipoHabitacionDAO.ListarDiferente(IdSucursal);
}
// </editor-fold>  

//<editor-fold defaultstate="collapsed" desc=" clsWebAdmin ">
public  clsWebAdmin loginWebAdmin(String Usuario,String Pass) throws Exception
{
return clsWebAdminDAO.login(Usuario, Pass);
}
// </editor-fold>  

//<editor-fold defaultstate="collapsed" desc=" clsInstalacion ">
public  List<clsInstalacion> listardSucursalesInstalacion(int IdSucursal) throws Exception
{
return clsInstalacionDAO.listarIdSucursales(IdSucursal);
}
public  List<clsInstalacion> listardTodosInstalacion( ) throws Exception
{
return clsInstalacionDAO.listarTodos();
}
public  int insertarInstalacion(clsInstalacion entidad) throws Exception
{
return clsInstalacionDAO.insertar(entidad);
}
// </editor-fold>     

//<editor-fold defaultstate="collapsed" desc=" clsComentario ">
public  int insertarComententario(clsComentario entidad) throws Exception
{
return clsComentarioDAO.insertar(entidad);
}
public  List<clsComentario> ListarXSucursalComentario(int IdSucursal) throws Exception
{
return clsComentarioDAO.ListarXSucursal(IdSucursal);
}
public List<clsComentario> ListarXIdPersona(int IdPersona) throws Exception
{
return clsComentarioDAO.ListarXIdPersona(IdPersona);
}
// </editor-fold>  

//<editor-fold defaultstate="collapsed" desc=" clsServicio ">
public  List<clsServicio> ListarDiferenteServicio(int IdSucursal) throws Exception
{
return clsServicioDAO.ListarDiferente(IdSucursal);
}
// </editor-fold>  

//<editor-fold defaultstate="collapsed" desc=" clsPuntacion ">
public  int insertarPuntuacion(clsPuntuacion entidad) throws Exception
{
return clsPuntuacionDAO.insertar(entidad);
}
// </editor-fold>  


//<editor-fold defaultstate="collapsed" desc="Localidad">
public List<clsDepartamento> listarDepartamento() throws Exception
{
return clsDepartamentoDAO.listarDepartamento();
}
public List<clsDistrito> listarDistritoXProvincia(int IdProvincia) throws Exception
{
return clsDistritoDAO.listarDistritoXProvincia(IdProvincia);
}
public List<clsProvincia> listarProvinciaXDepartamento(int IdDepartamento) throws Exception
{
return clsProvinciaDAO.listarProvinciaXDepartamento(IdDepartamento);
}
public  clsDistrito buscarIdProvincia (int idDistrito) throws Exception
{
return clsDistritoDAO.buscarId(idDistrito);
}
// </editor-fold>

}
