import COM.clsGestor;
import DAO.clsCostoTipoHabitacionDAO;
import Entidades.*;
import java.time.Instant;
import java.util.Date;

public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        // TODO code application logic here
                
//        clsWebAdmin entidadWA = new clsWebAdmin();
//        entidadWA.setNombre("marivn");
//        entidadWA.setApellido("de la cruz");
//        entidadWA.setUsuario("mdlcr");
//        entidadWA.setPassword("m456");
//        entidadWA.setNivel(1);
//        entidadWA.setEmail("m@dj.ca");
//        entidadWA.setEstado(1);
//        entidadWA.setIdWebAdmin(1);
        System.out.println(clsGestor.loginEncargado("ederm", "123456").getApellido());
//        System.out.println(clsGestor.actualizarWebAdmin(entidadWA));
//        System.out.println(clsGestor.ListarWebAdmin(false).size());
        
//        clsTipoHabitacion entidad = new clsTipoHabitacion();
//        entidad.setNombreComercial("doble");
//        entidad.setEstado(1);
//        entidad.setIdTipoHabitacion(7);
//        System.out.print(clsGestor.insertarTipoHabitacion(entidad));
//        System.out.println(clsGestor.actualizarTipoHabitacion(entidad));
//        System.out.print(clsGestor.ListarTipoHabitacion(false).size());
        
//        clsSucursal entidad = new clsSucursal();
//        clsEmpresa objEmpresa = new clsEmpresa();
//        objEmpresa.setIdEmpresa(1);
//        entidad.setObjEmpresa(objEmpresa);
//        clsDistrito objDistrito = new clsDistrito();
//        objDistrito.setIdDistrito(1);
//        entidad.setObjDistrito(objDistrito);
//        entidad.setDireccion("av xxx");
//        entidad.setPisos(4);
//        entidad.setTelefono("444478457");
//        entidad.setLongitud(12.25466);
//        entidad.setLatitud(14.12545);
//        entidad.setLimpieza(4);
//        entidad.setServicio(4);
//        entidad.setComodidad(4);
//        entidad.setPuntuacion(4);
//        entidad.setNivel(4);
//        entidad.setEntrada("11.00 am.");
//        entidad.setSalida("10.00 am.");
//        entidad.setFecha(null);
//        entidad.setEstado(1);
//        entidad.setIdSucursal(1);
//        System.out.println(clsGestor.insertarSucursal(entidad));
//        System.out.println(clsGestor.actualizarSucursal(entidad));
//        System.out.println(clsGestor.listarSucursal(false).size());
        
//        clsServicio entidad = new clsServicio();
//        entidad.setNombre("sauna");
//        entidad.setEstado(1);
//        entidad.setIdServicio(1);
//        System.out.println(clsGestor.insertarServicio(entidad));
//        System.out.println(clsGestor.actualizarServicio(entidad));
//        System.out.println(clsGestor.ListarServicio(false).size());
        
//        clsReserva entidad = new clsReserva();
//        clsPersona objPersona = new clsPersona();
//        objPersona.setIdPersona(1);
//        entidad.setObjPersona(objPersona);
//        clsSucursal objSucursal = new clsSucursal();
//        objSucursal.setIdSucursal(1);
//        entidad.setObjSucursal(objSucursal);
//        entidad.setFechaResgistro(null);
//        entidad.setEstado(1);
//        entidad.setIdReserva(2);
//        System.out.println(clsGestor.insertarReserva(entidad));
//        System.out.println(clsGestor.actualizarReserva(entidad));
//        System.out.print(clsGestor.ListarReserva(false).size());        
        
//        clsPuntuacionUsuario entidad = new clsPuntuacionUsuario();
//        entidad.setPuntualidad(5);
//        entidad.setHonrrades(5);
//        entidad.setEducacion(5);
//        entidad.setFecha(null);
//        clsReserva objReserva = new clsReserva();
//        objReserva.setIdReserva(2);
//        entidad.setObjReserva(objReserva);
//        entidad.setIdPUntuacionUsuario(3);
//        System.out.println(clsGestor.insertarPuntuacionUsuario(entidad));
//        System.out.println(clsGestor.actualizarPuntuacionUsuario(entidad));
//        System.out.println(clsGestor.listarPuntuacionUsuario(false).size());
        
//        clsPuntuacionHotel entidad = new clsPuntuacionHotel();
//        clsReserva objReserva = new clsReserva();
//        objReserva.setIdReserva(2);
//        entidad.setObjReserva(objReserva);
//        entidad.setLimpieza(5);
//        entidad.setServicio(4);
//        entidad.setComodidad(5);
//        entidad.setFecha(null);
//        entidad.setIdPuntacionHotel(1);
//        System.out.println(clsGestor.insertarPuntuacionHotel(entidad));
//        System.out.println(clsGestor.actualizarPuntuacionHotel(entidad));
//        System.out.println(clsGestor.listarPuntuacionHotel(false).size());
 
//        System.out.println(clsGestor.listarProvincia(1).size());
        
//        clsPromociones entidad = new clsPromociones();
//        entidad.setDato("15% descuento habitaciones dobles");
//        entidad.setFechaInicio(null);
//        entidad.setFechaFin(null);
//        entidad.setEstado(1);
//        clsSucursal objSucursal = new clsSucursal();
//        objSucursal.setIdSucursal(1);
//        entidad.setObjSucursal(objSucursal);
//        entidad.setIdPromociones(1);
//        System.out.println(clsGestor.insertarPromociones(entidad));
//        System.out.println(clsGestor.actualizarPromociones(entidad));
//        System.out.println(clsGestor.ListarPromociones(false).size());
        
//        clsPersona entidad =new clsPersona();
//        entidad.setNombre("eder");
//        entidad.setApellido("chupa pigas");
//        entidad.setTelefono("745845412");
//        entidad.setEmail("asa@gmil.com");
//        entidad.setDNI("22554455");
//        entidad.setUsuario("marica");
//        entidad.setPassword("soygay");
//        entidad.setInformacion(2);
//        entidad.setPuntualidad(5);
//        entidad.setHonrrades(5);
//        entidad.setEducacion(2);
//        entidad.setCalificacion(4);
//        entidad.setIdPersona(1);
//        System.out.println(clsGestor.ListarPersona(false).size());
//        System.out.println(clsGestor.insertarPersona(entidad));
//        System.out.println(clsGestor.actualizarPersona(entidad));        
        
//        clsPaquete entidad = new clsPaquete();
//        entidad.setMonto(50.22);
//        entidad.setMeses(2);
//        entidad.setEstado(1);
//        System.out.println(clsGestor.ListarPaquete(false).size());
//        System.out.println(clsGestor.insertarPaquete(entidad));
//        System.out.println(clsGestor.actualizarPaquete(entidad));
        
//        clsPagoEmpresa entidad = new clsPagoEmpresa();
//        clsEmpresa objEmpresa = new clsEmpresa();
//        objEmpresa.setIdEmpresa(1);
//        entidad.setObjEmpresa(objEmpresa);
//        clsPaquete objPaquete = new clsPaquete();
//        objPaquete.setIdPaquete(2);
//        entidad.setObjPaquete(objPaquete);
//        entidad.setMonto(140.02);
//        entidad.setBaucher(null);
//        entidad.setFechaRegistro(null);
//        entidad.setFechaInicio(null);
//        entidad.setFechaFin(null);
//        entidad.setEstado(1);
//        entidad.setIdPagoEmpresa(1);
//        System.out.println(clsGestor.insertarPagoEmpresa(entidad));
//        System.out.println(clsGestor.actualizarPagoEmpresa(entidad));
//        System.out.println(clsGestor.ListarPagoEmpresa(false).size());
        
//        clsIntalacion entidad = new clsIntalacion();
//        clsServicio objServicio = new clsServicio();
//        objServicio.setIdServicio(2);
//        entidad.setObjServicio(objServicio);
//        clsSucursal objSucursal = new clsSucursal();
//        objSucursal.setIdSucursal(1);
//        entidad.setObjSucursal(objSucursal);
//        entidad.setDescripcion("cancha futbol grande");
//        entidad.setIdInstalacion(1);
//        System.out.println(clsGestor.insertarIntalacion(entidad));
//        System.out.println(clsGestor.actualizarIntalacion(entidad));
//        System.out.println(clsGestor.ListarIntalacion(false).size());
        
//        clsHabitacion entidad = new clsHabitacion();
//        clsCostoTipoHabitacion objCostoTipoHabitacion = new clsCostoTipoHabitacion();
//        objCostoTipoHabitacion.setIdCostoTipoHabitacion(1);
//        entidad.setObjCostoTipoHabitacion(objCostoTipoHabitacion);
//        entidad.setNumero(2);
//        entidad.setPiso(1);
//        entidad.setNumeroPersonas(1);
//        entidad.setEstado(1);
//        entidad.setVista(0);
//        entidad.setIdHabitacion(1);
//        System.out.println(clsGestor.insertarHabitacion(entidad));
//        System.out.println(clsGestor.actualizarHabitacion(entidad));
//        System.out.println(clsGestor.ListarHabitacion(false).size());
        
//        clsEncargado entidad = new clsEncargado();
//        clsSucursal objSucursal = new clsSucursal();
//        objSucursal.setIdSucursal(1);
//        entidad.setObjSucursal(objSucursal);
//        entidad.setNombre("carlos");
//        entidad.setApellido("sanchez");
//        entidad.setEmail("saca@g.com");
//        entidad.setCelular("957486456");
//        entidad.setUsuario("carsan");
//        entidad.setPassword("carsen");
//        entidad.setEstado(1);
//        entidad.setIdEncargado(1);
//        System.out.println(clsGestor.insertarEncargado(entidad));
//        System.out.println(clsGestor.actualizarEncargado(entidad));
//        System.out.println(clsGestor.ListarEncargado(false).size());        
        
//        clsEmpresa entidad = new clsEmpresa();
//        entidad.setNombreComercial("la escuela SA");
//        entidad.setNombre("escuela ");
//        entidad.setSlogan("aprende dia a dia");
//        entidad.setRuc("41254545214");
//        entidad.setPuntos(14);
//        entidad.setFechaRegistro(null);
//        entidad.setLogo(null);
//        entidad.setBanner(null);
//        entidad.setEstado(1);
//        entidad.setIdEmpresa(1);
//        System.out.println(clsGestor.insertarEmpresa(entidad));
//        System.out.println(clsGestor.ListarEmpresa(false).size());
//        System.out.println(clsGestor.actualizarEmpresa(entidad));
        
//        System.out.println(clsGestor.listarDistrito(1).size());
        
//        clsDetalleReserva entidad = new clsDetalleReserva();
//        clsReserva objReserva = new clsReserva();
//        objReserva.setIdReserva(2);
//        entidad.setObjReserva(objReserva);
//        entidad.setNroHabitaciones(2);
//        entidad.setFechaIngreso(null);
//        entidad.setDias(3);
//        entidad.setTotal(350.00);
//        entidad.setEstado(1);
//        clsHabitacion objHabitacion = new clsHabitacion();
//        objHabitacion.setIdHabitacion(1);
//        entidad.setObjHabitacion(objHabitacion);
//        entidad.setIdDetalleReserva(1);
//        System.out.println(clsGestor.insertarDetalleReserva(entidad));
//        System.out.println(clsGestor.actualizarDetalleReserva(entidad));
//        System.out.println(clsGestor.ListarDetalleReservas(false).size());
        
//        System.out.println(clsGestor.ListarDepartamento(false).size());
        
//        clsCostoTipoHabitacion entidad = new clsCostoTipoHabitacion();
//        clsTipoHabitacion objTipoHabitacion = new clsTipoHabitacion();
//        objTipoHabitacion.setIdTipoHabitacion(4);
//        entidad.setObjTipohabitacion(objTipoHabitacion);
//        clsSucursal objSucursal = new clsSucursal();
//        objSucursal.setIdSucursal(1);
//        entidad.setObjSucursal(objSucursal);
//        entidad.setCosto(102.5);
//        entidad.setTotalHabitaciones(5);
//        entidad.setHabitacionesOcupadas(2);
//        entidad.setEstado(1);
//        entidad.setIdCostoTipoHabitacion(1);
//        System.out.println(clsGestor.insertarCostoTipoHabitacion(entidad));
//        System.out.println(clsGestor.actualizarCostoTipoHabitacion(entidad));
//        System.out.println(clsGestor.ListarCostoTipoHabitacion(false).size());
        
//        clsComentario entidad =  new clsComentario();
//        clsReserva objReserva = new clsReserva();
//        objReserva.setIdReserva(2);
//        entidad.setObjReserva(objReserva);
//        entidad.setDescripcion("gorgorgorgor");
//        entidad.setFecha(null);
//        entidad.setEstado(1);
//        entidad.setIdComentario(1);
//        System.out.println(clsGestor.insertarComentario(entidad));
//        System.out.println(clsGestor.actualizarComentario(entidad));
//        System.out.println(clsGestor.ListarComentario(false).size());
        
//        clsBajaEmpresaPersona entidad = new clsBajaEmpresaPersona();
//        clsEmpresa objEmpresa = new clsEmpresa();
//        objEmpresa.setIdEmpresa(1);
//        entidad.setObjEmpresa(objEmpresa);
//        clsPersona objPersona = new clsPersona();
//        objPersona.setIdPersona(1);
//        entidad.setObjPersona(objPersona);
//        entidad.setComentario("654789");
//        entidad.setFechaRegistro(null);
//        entidad.setFechaFinal(null);
//        entidad.setEstado(1);
//        entidad.setIdBajaEmpresaPersona(2);
//        System.out.println(clsGestor.InsertarBajaEmpresaPersona(entidad));
//        System.out.println(clsGestor.ActualizarBajaEmpresaPersona(entidad));
//        System.out.println(clsGestor.ListarBajaEmpresaPersonas(false).size());
    }    
}