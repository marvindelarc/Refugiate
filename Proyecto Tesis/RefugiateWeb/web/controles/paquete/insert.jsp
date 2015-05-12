
<%@page import="Entidades.clsPaquete"%>
<%@page import="COM.clsGestor"%>
<%  
if(request.getParameter("txtMonto") != null && request.getParameter("txtMonto") != "" &&
request.getParameter("txtMeses") != null && request.getParameter("txtMeses") != "" &&
request.getParameter("rEstado") != null && request.getParameter("rEstado") != "" )
{                       
    clsPaquete entidad = new clsPaquete();
    entidad.setMonto(Double.parseDouble(request.getParameter("txtMonto")));
    entidad.setMeses(Integer.parseInt(request.getParameter("txtMeses")));
    entidad.setEstado(0);
    if(request.getParameter("rEstado").equals("1"))
     entidad.setEstado(1);


    if(!request.getParameter("Id").equals("") && request.getParameter("Id") != null)
    {
        entidad.setIdPaquete(Integer.parseInt(request.getParameter("Id")));
        if(clsGestor.actualizarPaquete(entidad))
            out.print(0);
        else
            out.print(-1);
    }
    else
    {
     int id=clsGestor.insertarPaquete(entidad);
        if(id>0)
            out.print(id);
        else
            out.print(-1);
    }

}

 %>
