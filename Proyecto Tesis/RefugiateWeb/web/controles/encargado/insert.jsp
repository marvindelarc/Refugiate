<%@page import="Entidades.clsSucursal"%>
<%@page import="Entidades.clsEncargado"%>
<%@page import="COM.clsGestor"%>
<%  
if(request.getParameter("cbDistrito") != null && request.getParameter("cbDistrito") != "" &&
request.getParameter("txtNombre") != null && request.getParameter("txtNombre") != "" &&
request.getParameter("txtApellidos") != null && request.getParameter("txtApellidos") != "" &&
request.getParameter("txtEmail") != null && request.getParameter("txtEmail") != "" &&
request.getParameter("txtTelefono") != null && request.getParameter("txtTelefono") != "" &&
request.getParameter("txtUsuario") != null && request.getParameter("txtUsuario") != "" &&
request.getParameter("txtPassword") != null && request.getParameter("txtPassword") != "" &&
request.getParameter("rEstado") != null && request.getParameter("rEstado") != "" )
{
    clsSucursal objSucursal = new clsSucursal();
    objSucursal.setIdSucursal(Integer.parseInt(request.getParameter("cbDistrito")));
    clsEncargado entidad = new clsEncargado();
    entidad.setObjSucursal(objSucursal);
    entidad.setNombre(request.getParameter("txtNombre"));
    entidad.setApellido(request.getParameter("txtApellidos"));
    entidad.setEmail(request.getParameter("txtEmail"));
    entidad.setCelular(request.getParameter("txtTelefono"));
    entidad.setUsuario(request.getParameter("txtUsuario"));
    entidad.setPassword(request.getParameter("txtPassword"));
    entidad.setEstado(0);
    if(request.getParameter("rEstado").equals("1"))
     entidad.setEstado(1);


    if(!request.getParameter("Id").equals("") && request.getParameter("Id") != null)
    {
        entidad.setIdEncargado(Integer.parseInt(request.getParameter("Id")));
        if(clsGestor.actualizarEncargado(entidad))
            out.print(0);
        else
            out.print(-1);
    }
    else
    {
     int id=clsGestor.insertarEncargado(entidad);
        if(id>0)
            out.print(id);
        else
            out.print(-1);
    }
}
%>