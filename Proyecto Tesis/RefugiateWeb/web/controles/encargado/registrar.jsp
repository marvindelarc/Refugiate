<%@page import="sun.misc.BASE64Decoder"%>
<%@page import="Entidades.clsEmpresa"%>
<%@page import="Entidades.clsDistrito"%>
<%@page import="Entidades.clsSucursal"%>
<%@page import="Entidades.clsEncargado"%>
<%@page import="COM.clsGestor"%>
<%  
if(request.getParameter("cbDistrito") != null && request.getParameter("cbDistrito") != "" &&
request.getParameter("cbNivel") != null && request.getParameter("cbNivel") != "" &&  
request.getParameter("txtNombrePersona") != null && request.getParameter("txtNombrePersona") != "" &&
request.getParameter("txtApellidoPersona") != null && request.getParameter("txtApellidoPersona") != "" &&
request.getParameter("txtEmailPersoma") != null && request.getParameter("txtEmailPersoma") != "" &&
request.getParameter("txtCelularPersona") != null && request.getParameter("txtCelularPersona") != "" &&
request.getParameter("txtUsuario") != null && request.getParameter("txtUsuario") != "" &&
request.getParameter("txtContrasena") != null && request.getParameter("txtContrasena") != "" &&
request.getParameter("txtNombreEmpresa") != null && request.getParameter("txtNombreEmpresa") != "" &&
request.getParameter("txtNombreCEmpresa") != null && request.getParameter("txtNombreCEmpresa") != "" &&
request.getParameter("txtSloganEmpresa") != null && request.getParameter("txtSloganEmpresa") != "" &&
request.getParameter("txtRucEmpresa") != null && request.getParameter("txtRucEmpresa") != "" &&
request.getParameter("txtDireccionSucrusla") != null && request.getParameter("txtDireccionSucrusla") != "" &&
request.getParameter("txtHorarioSucursal") != null && request.getParameter("txtHorarioSucursal") != "" &&
request.getParameter("txtTelefonoSucursal") != null && request.getParameter("txtTelefonoSucursal") != "" &&
request.getParameter("txtPisosSucursal") != null && request.getParameter("txtPisosSucursal") != "" &&    
request.getParameter("txtLatiud") != null && request.getParameter("txtLatiud") != "" &&
request.getParameter("txtLongitud") != null && request.getParameter("txtLongitud") != "" &&
request.getParameter("txtFotoLogo") != null && request.getParameter("txtFotoLogo") != "" &&        
request.getParameter("txtFotoBanner") != null && request.getParameter("txtFotoBanner") != "" )
{
    clsEmpresa objEmpresa =new clsEmpresa();
    objEmpresa.setNombre(request.getParameter("txtNombreEmpresa"));
    objEmpresa.setNombreComercial(request.getParameter("txtNombreCEmpresa"));
    objEmpresa.setSlogan(request.getParameter("txtSloganEmpresa"));
    objEmpresa.setRuc(request.getParameter("txtRucEmpresa"));
    
    BASE64Decoder decoder = new BASE64Decoder();    
    
    String logo=request.getParameter("txtFotoLogo");
    logo=logo.replace("data:image/png;base64,", "");
    objEmpresa.setLogo(decoder.decodeBuffer(logo)); 
    
    String banner=request.getParameter("txtFotoBanner");
    banner=banner.replace("data:image/png;base64,", "");
    objEmpresa.setBanner(decoder.decodeBuffer(banner));
    
    
    
    clsSucursal objSucursal = new clsSucursal();
    objSucursal.setObjEmpresa(objEmpresa);
    objSucursal.setObjDistrito(new clsDistrito(Integer.parseInt(request.getParameter("cbDistrito"))));
    objSucursal.setNivel(Integer.parseInt(request.getParameter("cbNivel")));
    objSucursal.setDireccion(request.getParameter("xtDireccionSucrusla"));
    objSucursal.setEntrada(request.getParameter("txtHorarioSucursal"));
    objSucursal.setTelefono(request.getParameter("txtTelefonoSucursal"));
    objSucursal.setPisos(Integer.parseInt(request.getParameter("txtPisosSucursal")));
    objSucursal.setLatitud(Double.parseDouble(request.getParameter("txtLatiud")));
    objSucursal.setLongitud(Double.parseDouble(request.getParameter("txtLongitud")));

    clsEncargado entidad = new clsEncargado();
    entidad.setObjSucursal(objSucursal);
    entidad.setNombre(request.getParameter("txtNombrePersona"));
    entidad.setApellido(request.getParameter("txtApellidoPersona"));
    entidad.setEmail(request.getParameter("txtEmailPersoma"));
    entidad.setCelular(request.getParameter("txtCelularPersona"));
    entidad.setUsuario(request.getParameter("txtUsuario"));
    entidad.setPassword(request.getParameter("txtContrasena"));
    entidad.setEstado(0);


     int id=clsGestor.insertarEncargado(entidad);
        if(id>0)
            out.print(id);
        else
            out.print(0);
   
}
%>