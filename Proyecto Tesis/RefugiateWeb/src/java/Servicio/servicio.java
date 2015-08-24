/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Servicio;

import COM.clsGestor;
import Entidades.clsCostoTipoHabitacion;
import Entidades.clsEmpresa;
import Entidades.clsInstalacion;
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
