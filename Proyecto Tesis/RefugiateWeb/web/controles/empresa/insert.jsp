<%@page import="Entidades.clsEmpresa"%>
<%@page import="COM.clsGestor"%>
<%  
if(request.getParameter("txtEmpresaNombreComercial") != null && request.getParameter("txtEmpresaNombreComercial") != "" &&
request.getParameter("txtEmpresaNombre") != null && request.getParameter("txtEmpresaNombre") != "" &&
request.getParameter("txtSlogan") != null && request.getParameter("txtSlogan") != "" &&
request.getParameter("txtRuc") != null && request.getParameter("txtRuc") != "" &&
request.getParameter("txtPuntos") != null && request.getParameter("txtPuntos") != "" &&
request.getParameter("rEstado") != null && request.getParameter("rEstado") != "" )
{                       
    clsEmpresa entidad = new clsEmpresa();
    entidad.setNombreComercial(request.getParameter("txtEmpresaNombreComercial"));
    entidad.setNombre(request.getParameter("txtEmpresaNombre"));
    entidad.setSlogan(request.getParameter("txtSlogan"));
    entidad.setRuc(request.getParameter("txtRuc"));
    entidad.setPuntos(Integer.parseInt(request.getParameter("txtPuntos")));
    entidad.setEstado(0);
    if(request.getParameter("rEstado").equals("1"))
     entidad.setEstado(1);

    if(!request.getParameter("Id").equals("") && request.getParameter("Id") != null)
    {
        entidad.setIdEmpresa(Integer.parseInt(request.getParameter("Id")));
        if(clsGestor.actualizarEmpresa(entidad))
            out.print(0);
        else
            out.print(-1);
    }
    else
    {
     int id=clsGestor.insertarEmpresa(entidad);
        if(id>0)
            out.print(id);
        else
            out.print(-1);
    }
}
%>