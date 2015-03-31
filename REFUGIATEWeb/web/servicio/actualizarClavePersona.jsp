
<%@page import="Entidades.clsPersona"%>
<%@page import="COM.clsGestor"%>

<%
  if(request.getParameter("clave") != null && request.getParameter("clave") != "" &&
          request.getParameter("IdPersona") != null && request.getParameter("IdPersona") != "")
   {
        clsGestor objGestor= new clsGestor();
        clsPersona objPersona=new clsPersona();
         
        objPersona.setStr_Password(request.getParameter("clave"));
        objPersona.setInt_IdPersona(Integer.parseInt(request.getParameter("IdPersona")));
        
        if(objGestor.actualizarClavePersona(objPersona))
            out.print("1");
        else
            out.print("0");
   }else
       out.print("0");
%>

