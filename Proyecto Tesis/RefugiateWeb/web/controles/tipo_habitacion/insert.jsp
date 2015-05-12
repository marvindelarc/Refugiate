
<%@page import="Entidades.clsTipoHabitacion"%>
<%@page import="COM.clsGestor"%>
<%  
if(request.getParameter("txtNombre") != null && request.getParameter("txtNombre") != "" &&
request.getParameter("rEstado") != null && request.getParameter("rEstado") != "" )
{                       
    clsTipoHabitacion entidad = new clsTipoHabitacion();
    entidad.setNombreComercial(request.getParameter("txtNombre"));
    
    entidad.setEstado(0);
    if(request.getParameter("rEstado").equals("1"))
     entidad.setEstado(1);


    if(!request.getParameter("Id").equals("") && request.getParameter("Id") != null)
    {
        entidad.setIdTipoHabitacion(Integer.parseInt(request.getParameter("Id")));
        if(clsGestor.actualizarTipoHabitacion(entidad))
            out.print(0);
        else
            out.print(-1);
    }
    else
    {
     int id=clsGestor.insertarTipoHabitacion(entidad);
        if(id>0)
            out.print(id);
        else
            out.print(-1);
    }

}

 %>
