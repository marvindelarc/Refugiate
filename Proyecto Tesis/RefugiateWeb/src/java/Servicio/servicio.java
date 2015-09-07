/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Servicio;

import COM.clsGestor;
import Entidades.clsCostoTipoHabitacion;
import Entidades.clsEmpresa;
import Entidades.clsHabitacion;
import Entidades.clsInstalacion;
import Entidades.clsPersona;
import Entidades.clsReserva;
import Entidades.clsServicio;
import Entidades.clsSucursal;
import Entidades.clsTipoHabitacion;
import Entidades.clsUsuario;
import UTILIDADES.Base64;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 *
 * @author EdHam
 */
@WebServlet(name = "servicio", urlPatterns = {"/servicio"})
public class servicio extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
             JSONObject obj=new JSONObject();
        if(request.getParameter("idServicio") != null && request.getParameter("idServicio") != "" )
        {
            int idServicio=Integer.parseInt(request.getParameter("idServicio"));
            if(idServicio==1 && request.getParameter("fecha") != null && request.getParameter("fecha") != "" )
            {
                Long fecha;
                if(request.getParameter("fecha").equals("null"))
                    fecha=null;
                else
                     fecha=Long.parseLong(request.getParameter("fecha"));
                
                JSONArray listEmpresaJSON = new JSONArray();
                List<clsEmpresa> listaEmpresa=clsGestor.ListarEmpresaServicio(fecha);
                if(listaEmpresa!=null)
                {               
                   for(clsEmpresa entidad : listaEmpresa)
                    {
                        JSONObject entidadJSON=new JSONObject();
                        entidadJSON.put("idEmpresa",entidad.getIdEmpresa());
                        entidadJSON.put("nombreComercial",entidad.getNombreComercial());
                        entidadJSON.put("nombre",entidad.getNombre());
                        entidadJSON.put("slogan",entidad.getSlogan());
                        entidadJSON.put("ruc",entidad.getRuc());
                        entidadJSON.put("puntos",entidad.getPuntos());
                        entidadJSON.put("estado",entidad.getEstado());
                        entidadJSON.put("logo",Base64.encodeToString(entidad.getLogo(),Base64.NO_WRAP|Base64.URL_SAFE));
                        listEmpresaJSON.add(entidadJSON);
                    }
                }
                obj.put("listEmpresaJSON",listEmpresaJSON);

                JSONArray listSucursalJSON = new JSONArray();
                List<clsSucursal> listaSucursal=clsGestor.listarServicioSucursal(fecha);
                if(listaSucursal!=null)
                {               
                   for(clsSucursal entidad : listaSucursal)
                    {
                        JSONObject entidadJSON=new JSONObject();
                        entidadJSON.put("idSucursal",entidad.getIdSucursal());
                        entidadJSON.put("direccion",entidad.getDireccion());
                        entidadJSON.put("pisos",entidad.getPisos());
                        entidadJSON.put("telefono",entidad.getTelefono());
                        entidadJSON.put("longitud",entidad.getLongitud());
                        entidadJSON.put("latitud",entidad.getLatitud());
                        entidadJSON.put("limpieza",entidad.getLimpieza());
                        entidadJSON.put("servicio",entidad.getServicio());
                        entidadJSON.put("comodidad",entidad.getComodidad());
                        entidadJSON.put("puntuacion",entidad.getPuntuacion());
                        entidadJSON.put("nivel",entidad.getNivel());
                        entidadJSON.put("entrada",entidad.getEntrada());
                        entidadJSON.put("estado",entidad.getEstado());
                        entidadJSON.put("paquete",entidad.isPaquete());                        
                        entidadJSON.put("idDistrito",entidad.getObjDistrito().getIdDistrito());
                        entidadJSON.put("idEmpresa",entidad.getObjEmpresa().getIdEmpresa());

                        listSucursalJSON.add(entidadJSON);
                    }
                }
                obj.put("listSucursalJSON",listSucursalJSON);


                JSONArray listServicioJSON = new JSONArray();
                List<clsServicio> listaServicio=clsGestor.ListarServicioServicio(fecha);
                if(listaServicio!=null)
                {               
                   for(clsServicio entidad : listaServicio)
                    {
                        JSONObject entidadJSON=new JSONObject();
                         entidadJSON.put("idServicio",entidad.getIdServicio());
                        entidadJSON.put("nombre",entidad.getNombre());

                        listServicioJSON.add(entidadJSON);
                    }
                }
                obj.put("listServicioJSON",listServicioJSON);

                JSONArray listInstalacionJSON = new JSONArray();
                List<clsInstalacion> listaInstalacion=clsGestor.ListarIntalacionServicio(fecha);
                if(listaInstalacion!=null)
                {      
                   for(clsInstalacion entidad : listaInstalacion)
                    {
                        JSONObject entidadJSON=new JSONObject();
                        entidadJSON.put("idInstalacion",entidad.getIdInstalacion());
                        entidadJSON.put("descripcion",entidad.getDescripcion());
                        entidadJSON.put("idServicio",entidad.getObjServicio().getIdServicio());
                        entidadJSON.put("idSucursal",entidad.getObjSucursal().getIdSucursal());

                        listInstalacionJSON.add(entidadJSON);
                    }
                }
                obj.put("listInstalacionJSON",listInstalacionJSON);

                JSONArray listCostoTipoHabitacionJSON = new JSONArray();
                List<clsCostoTipoHabitacion> listaCostoTipoHabitacion=clsGestor.ListarCostoTipoHabitacionServicio(fecha);
                if(listaCostoTipoHabitacion!=null)
                {      
                   for(clsCostoTipoHabitacion entidad : listaCostoTipoHabitacion)
                    {  
                        JSONObject entidadJSON=new JSONObject();
                        entidadJSON.put("idCostoTipoHabitacion",entidad.getIdCostoTipoHabitacion());
                        entidadJSON.put("costo",entidad.getCosto());
                        entidadJSON.put("numeroPersonas",entidad.getNumeroPersonas());
                        entidadJSON.put("totalHabitaciones",entidad.getTotalHabitaciones());
                        entidadJSON.put("habitacionesOcupadas",entidad.getHabitacionesOcupadas());
                        entidadJSON.put("estado",entidad.getEstado());
                        entidadJSON.put("idTipoHabitacion",entidad.getObjTipohabitacion().getIdTipoHabitacion());
                        entidadJSON.put("idSucursal",entidad.getObjSucursal().getIdSucursal());

                        listCostoTipoHabitacionJSON.add(entidadJSON);
                    }
                }
                obj.put("listCostoTipoHabitacionJSON",listCostoTipoHabitacionJSON);
                
                
                JSONArray listTipoHabitacionJSON = new JSONArray();
                List<clsTipoHabitacion> listaTipoHabitacion=clsGestor.ListarTipoHabitacion(false);
                if(listaTipoHabitacion!=null)
                {      
                   for(clsTipoHabitacion entidad : listaTipoHabitacion)
                    {  
                        JSONObject entidadJSON=new JSONObject();
                        entidadJSON.put("idTipoHabitacion",entidad.getIdTipoHabitacion());
                        entidadJSON.put("nombreComercial",entidad.getNombreComercial());

                        listTipoHabitacionJSON.add(entidadJSON);
                    }
                }
                obj.put("listTipoHabitacionJSON",listTipoHabitacionJSON);
            }
            else  if(idServicio==2 && request.getParameter("nombre") != null && request.getParameter("nombre") != "" 
                    && request.getParameter("apellido") != null && request.getParameter("apellido") != ""
                    && request.getParameter("telefono") != null && request.getParameter("telefono") != ""
                    && request.getParameter("email") != null && request.getParameter("email") != ""
                    && request.getParameter("dni") != null && request.getParameter("dni") != ""
                    && request.getParameter("usuario") != null && request.getParameter("usuario") != ""
                    && request.getParameter("password") != null && request.getParameter("password") != ""
                    && request.getParameter("sexo") != null && request.getParameter("sexo") != ""
                    && request.getParameter("fecnac") != null && request.getParameter("fecnac") != "")
            {
                    clsPersona entidad = new clsPersona();
                    entidad.setNombre(request.getParameter("nombre"));
                    entidad.setApellido(request.getParameter("apellido"));
                    entidad.setTelefono(request.getParameter("telefono"));
                    entidad.setEmail(request.getParameter("email"));
                    entidad.setDNI(request.getParameter("dni"));
                    entidad.setUsuario(request.getParameter("usuario"));
                    entidad.setPassword(request.getParameter("password"));                    
                    entidad.setSexo(Boolean.parseBoolean(request.getParameter("sexo")));                    
                    entidad.setFecnac(new Date(Long.parseLong(request.getParameter("fecnac"))));
                    
                    obj.put("idPersona",clsGestor.insertarPersona(entidad));
                   
                
            }
            else  if(idServicio==3 && request.getParameter("usuario") != null && request.getParameter("usuario") != "" 
                    && request.getParameter("password") != null && request.getParameter("password") != "")
            {
                clsPersona entidad=clsGestor.loginPersona(request.getParameter("usuario"), request.getParameter("password"));
                if(entidad!=null)
                {
                    obj.put("idPersona",entidad.getIdPersona());
                    obj.put("nombre",entidad.getNombre());
                    obj.put("apellido",entidad.getApellido());
                    obj.put("telefono",entidad.getTelefono());
                    obj.put("email",entidad.getEmail());
                    obj.put("dni",entidad.getDNI());
                    obj.put("sexo",entidad.isSexo());
                    obj.put("fecnac",entidad.getFecnac().getTime());
                    
                    
                    
                    JSONArray listReservaJSON = new JSONArray();
                    List<clsReserva> listaReserva=clsGestor.ListarServicioReserva(null,entidad.getIdPersona());
                    if(listaReserva!=null)
                    {      
                        for(clsReserva objReserva : listaReserva)
                        {  
                            JSONObject entidadJSON=new JSONObject();
                            entidadJSON.put("idReserva",objReserva.getIdReserva());
                            entidadJSON.put("fechaResgistro",objReserva.getFechaResgistro().getTime());
                            entidadJSON.put("fechaIngreso",objReserva.getFechaIngreso().getTime());
                            entidadJSON.put("fechaEgreso",objReserva.getFechaEgreso().getTime());
                            entidadJSON.put("estado",objReserva.getEstado());
                            entidadJSON.put("dias",objReserva.getDias());
                            entidadJSON.put("costo",objReserva.getCosto());
                            entidadJSON.put("servicio",objReserva.getServicio());
                            entidadJSON.put("comodidad",objReserva.getComodidad());
                            entidadJSON.put("limpieza",objReserva.getLimpieza());
                            entidadJSON.put("comentario",objReserva.getComentario());
                            entidadJSON.put("vista",objReserva.getObjHabitacion().isVista());
                            entidadJSON.put("numero",objReserva.getObjHabitacion().getNumero());
                            entidadJSON.put("piso",objReserva.getObjHabitacion().getPiso());
                            entidadJSON.put("idHabitacion",objReserva.getObjHabitacion().getIdHabitacion());
                            entidadJSON.put("idCostoTipoHabitacion",objReserva.getObjHabitacion().getObjCostoTipoHabitacion().getIdCostoTipoHabitacion());

                            listReservaJSON.add(entidadJSON);
                        }
                    }
                    obj.put("listReservaJSON",listReservaJSON);
                    
                }
            }
            else  if(idServicio==4 && request.getParameter("idCostoTipoHabitacion") != null 
                    && request.getParameter("idCostoTipoHabitacion") != "")
            {
                 JSONArray listaHabitacionJSON = new JSONArray();
                List<clsHabitacion> listaHabitacion=clsGestor.ListarDisponibilidadHabitacion(Integer.parseInt(request.getParameter("idCostoTipoHabitacion")));
                if(listaHabitacion!=null)
                {      
                   for(clsHabitacion entidad : listaHabitacion)
                    {
                        JSONObject entidadJSON=new JSONObject();
                        entidadJSON.put("idHabitacion",entidad.getIdHabitacion());
                        entidadJSON.put("idCostoTipoHabitacion",entidad.getObjCostoTipoHabitacion().getIdCostoTipoHabitacion());
                        entidadJSON.put("numero",entidad.getNumero());
                        entidadJSON.put("piso",entidad.getPiso());
                        entidadJSON.put("vista",entidad.isVista());
                        entidadJSON.put("estado",entidad.getEstado());
                        listaHabitacionJSON.add(entidadJSON);
                    }
                }
                obj.put("listaHabitacionJSON",listaHabitacionJSON);

              
            }
            else  if(idServicio==5 && request.getParameter("idPersona") != null && request.getParameter("idPersona") != ""
                    && request.getParameter("idHabitacion") != null && request.getParameter("idHabitacion") != ""
                    && request.getParameter("fechaIngreso") != null && request.getParameter("fechaIngreso") != ""
                    && request.getParameter("fechaEgreso") != null && request.getParameter("fechaEgreso") != ""
                    && request.getParameter("costo") != null && request.getParameter("costo") != ""
                    && request.getParameter("dias") != null && request.getParameter("dias") != "")
            {
                clsReserva entidad = new clsReserva();
                entidad.setObjPersona(new clsPersona(Integer.parseInt(request.getParameter("idPersona"))));
                entidad.setObjHabitacion(new clsHabitacion(Integer.parseInt(request.getParameter("idHabitacion"))));
                entidad.setFechaIngreso(new Date(Long.parseLong(request.getParameter("fechaIngreso"))));
                entidad.setFechaEgreso(new Date(Long.parseLong(request.getParameter("fechaEgreso"))));
                entidad.setCosto(Double.parseDouble(request.getParameter("costo")));
                entidad.setDias(Integer.parseInt(request.getParameter("dias")));
                obj.put("id",clsGestor.insertarReserva(entidad));              
            }
            else  if(idServicio==6 && request.getParameter("idReserva") != null && request.getParameter("idReserva") != ""
                    && request.getParameter("estado") != null && request.getParameter("estado") != "")
            {
                obj.put("estado",clsGestor.actualizarEstadoReserva(Integer.parseInt(request.getParameter("idReserva")),Integer.parseInt(request.getParameter("estado"))));              
            }
            else  if(idServicio==7 && request.getParameter("limpieza") != null && request.getParameter("limpieza") != ""
                    && request.getParameter("servicio") != null && request.getParameter("servicio") != ""
                    && request.getParameter("comodidad") != null && request.getParameter("comodidad") != ""
                    && request.getParameter("comentario") != null && request.getParameter("comentario") != ""
                    && request.getParameter("idReserva") != null && request.getParameter("idReserva") != "")
            {
                 clsReserva entidad = new clsReserva();
                entidad.setIdReserva(Integer.parseInt(request.getParameter("idReserva")));
                entidad.setLimpieza(Integer.parseInt(request.getParameter("limpieza")));
                entidad.setComodidad(Integer.parseInt(request.getParameter("comodidad")));
                entidad.setServicio(Integer.parseInt(request.getParameter("servicio")));
                entidad.setComentario(request.getParameter("comentario"));
                obj.put("estado",clsGestor.actualizarPuntacionReserva(entidad));           
            }
            
        }
        out.println(obj);
        } catch (Exception ex) {
            Logger.getLogger(servicio.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
