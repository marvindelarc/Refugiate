/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Servicio;

import COM.clsGestor;
import Entidades.clsEmpresa;
import Entidades.clsSucursal;
import java.io.IOException;
import java.io.PrintWriter;
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
            
            JSONArray listEmpresaJSON = new JSONArray();
            List<clsEmpresa> listaEmpresa=clsGestor.ListarEmpresaServicio(null);
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
                    listEmpresaJSON.add(entidadJSON);
                }
               
            }
            obj.put("listEmpresaJSON",listEmpresaJSON);
            
            JSONArray listSucursalJSON = new JSONArray();
            List<clsSucursal> listaSucursal=clsGestor.listarServicioSucursal(null);
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
