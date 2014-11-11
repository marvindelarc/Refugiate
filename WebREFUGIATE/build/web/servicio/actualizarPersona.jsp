
<%@page import="Entidades.clsPersona"%>
<%@page import="COM.clsGestor"%>

<%
  if(request.getParameter("nombre") != null && request.getParameter("nombre") != "" &&
          request.getParameter("apellido") != null && request.getParameter("apellido") != "" &&
          request.getParameter("dni") != null && request.getParameter("dni") != "" &&
          request.getParameter("email") != null && request.getParameter("email") != "" &&
          request.getParameter("telefono") != null && request.getParameter("telefono") != "" &&
          request.getParameter("IdPersona") != null && request.getParameter("IdPersona") != "")
   {
        clsGestor objGestor= new clsGestor();
        clsPersona objPersona=new clsPersona();
         
        objPersona.setStr_Nombre(request.getParameter("nombre"));
        objPersona.setStr_Apellido(request.getParameter("apellido"));
        objPersona.setStr_DNI(request.getParameter("dni"));
        objPersona.setStr_Email(request.getParameter("email"));
        objPersona.setStr_Telefono(request.getParameter("telefono"));
        objPersona.setInt_IdPersona(Integer.parseInt(request.getParameter("IdPersona")));
        
        if(objGestor.actualizarPersona(objPersona))
            out.print("1");
        else
            out.print("0");
   }else
       out.print("0");
%>

