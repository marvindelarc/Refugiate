
<%@page import="Entidades.clsCostoTipoHabitacion"%>
<%@page import="Entidades.clsHabitacion"%>
<%@page import="COM.clsGestor"%>
<%  
if(request.getParameter("cbTipoHabitacion") != null && request.getParameter("cbTipoHabitacion") != "" &&
request.getParameter("txtPiso") != null && request.getParameter("txtPiso") != "" &&
request.getParameter("txtNumero") != null && request.getParameter("txtNumero") != "" &&
request.getParameter("rVista") != null && request.getParameter("rVista") != "" &&
request.getParameter("rEstado") != null && request.getParameter("rEstado") != "" )
{                       
    clsCostoTipoHabitacion objCostoTipoHabitacion = new clsCostoTipoHabitacion();
    objCostoTipoHabitacion.setIdCostoTipoHabitacion(Integer.parseInt(request.getParameter("cbTipoHabitacion")));
    
    clsHabitacion entidad = new clsHabitacion();
    entidad.setObjCostoTipoHabitacion(objCostoTipoHabitacion);
    entidad.setPiso(Integer.parseInt(request.getParameter("txtPiso")));
    entidad.setNumero(Integer.parseInt(request.getParameter("txtNumero")));
    
    entidad.setVista(Byte.parseByte("0"));
    if(request.getParameter("rVista").equals("1"))
    entidad.setVista(Byte.parseByte("1"));
    
    entidad.setEstado(0);
    if(request.getParameter("rEstado").equals("1"))
     entidad.setEstado(1);


    if(!request.getParameter("Id").equals("") && request.getParameter("Id") != null)
    {
        entidad.setIdHabitacion(Integer.parseInt(request.getParameter("Id")));
        if(clsGestor.actualizarHabitacion(entidad))
            out.print(0);
        else
            out.print(-1);
    }
    else
    {
     int id=clsGestor.insertarHabitacion(entidad);
        if(id>0)
            out.print(id);
        else
            out.print(-1);
    }
}
 %>
