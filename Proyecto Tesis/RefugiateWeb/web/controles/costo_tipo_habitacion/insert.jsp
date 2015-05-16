<%@page import="Entidades.clsSucursal"%>
<%@page import="Entidades.clsTipoHabitacion"%>
<%@page import="Entidades.clsCostoTipoHabitacion"%>
<%@page import="COM.clsGestor"%>
<%  
if(request.getParameter("cbTipoHabitacion") != null && request.getParameter("cbTipoHabitacion") != "" &&
request.getParameter("txtCosto") != null && request.getParameter("txtCosto") != "" &&
request.getParameter("txtNroPersonas") != null && request.getParameter("txtNroPersonas") != "" &&
request.getParameter("txtNroHabitaciones") != null && request.getParameter("txtNroHabitaciones") != "" &&
request.getParameter("rEstado") != null && request.getParameter("rEstado") != "" )
{   
    clsTipoHabitacion objTipoHabitacion = new clsTipoHabitacion();
    objTipoHabitacion.setIdTipoHabitacion(Integer.parseInt(request.getParameter("cbTipoHabitacion")));
    
    clsSucursal objSucursal = new clsSucursal();
    objSucursal.setIdSucursal(Integer.parseInt(request.getParameter("IdSucursal")));
    
    clsCostoTipoHabitacion entidad = new clsCostoTipoHabitacion();
    entidad.setObjTipohabitacion(objTipoHabitacion);
    entidad.setObjSucursal(objSucursal);
    entidad.setCosto(Double.parseDouble(request.getParameter("txtCosto")));
    entidad.setNumeroPersonas(Integer.parseInt(request.getParameter("txtNroPersonas")));
    entidad.setTotalHabitaciones(Integer.parseInt(request.getParameter("txtNroHabitaciones")));
    entidad.setEstado(0);
    if(request.getParameter("rEstado").equals("1"))
     entidad.setEstado(1);

    if(!request.getParameter("Id").equals("") && request.getParameter("Id") != null)
    {
        entidad.setIdCostoTipoHabitacion(Integer.parseInt(request.getParameter("Id")));
        if(clsGestor.actualizarCostoTipoHabitacion(entidad))
            out.print(0);
        else
            out.print(-1);
    }
    else
    {
     int id=clsGestor.insertarCostoTipoHabitacion(entidad);
        if(id>0)
            out.print(id);
        else
            out.print(-1);
    }
}
 %>
