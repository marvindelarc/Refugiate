<%@page import="Entidades.clsPersona"%>
<%@page import="COM.clsGestor"%>

<%
   clsGestor objGestor= new clsGestor();   
   
  if(request.getParameter("usuario") != null && request.getParameter("usuario") != "" )
   {
       out.print(objGestor.consultarUsuarioPersona(request.getParameter("usuario")));
       
   }else
       out.print("0");
%>