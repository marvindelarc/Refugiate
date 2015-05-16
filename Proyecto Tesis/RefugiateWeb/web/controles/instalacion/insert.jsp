<%@page import="Entidades.clsServicio"%>
<%@page import="Entidades.clsSucursal"%>
<%@page import="Entidades.clsIntalacion"%>
<%@page import="COM.clsGestor"%>
<%  
if(request.getParameter("cbServicio") != null && request.getParameter("cbServicio") != "" &&
request.getParameter("IdSucursal") != null && request.getParameter("IdSucursal") != "" &&
request.getParameter("txtDetalle") != null && request.getParameter("txtDetalle") != "" &&
request.getParameter("rEstado") != null && request.getParameter("rEstado") != "" )
{   
    clsSucursal objSucursal = new clsSucursal();
    objSucursal.setIdSucursal(Integer.parseInt(request.getParameter("IdSucursal")));
    
    clsServicio objServicio = new clsServicio();
    objServicio.setIdServicio(Integer.parseInt(request.getParameter("cbServicio")));
    
    clsIntalacion entidad = new clsIntalacion();    
    entidad.setObjSucursal(objSucursal);
    entidad.setObjServicio(objServicio);
    entidad.setDescripcion(request.getParameter("txtDetalle"));
    
    entidad.setEstado(0);
    if(request.getParameter("rEstado").equals("1"))
     entidad.setEstado(1);


    if(!request.getParameter("Id").equals("") && request.getParameter("Id") != null)
    {
        entidad.setIdInstalacion(Integer.parseInt(request.getParameter("Id")));
        if(clsGestor.actualizarIntalacion(entidad))
            out.print(0);
        else
            out.print(-1);
    }
    else
    {
     int id=clsGestor.insertarIntalacion(entidad);
        if(id>0)
            out.print(id);
        else
            out.print(-1);
    }

}

 %>
