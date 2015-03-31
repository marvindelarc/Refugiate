
<%@page import="Entidades.clsPersona"%>
<%@page import="COM.clsGestor"%>

<%
  if(request.getParameter("nombre") != null && request.getParameter("nombre") != "" &&
          request.getParameter("apellido") != null && request.getParameter("apellido") != "" &&
          request.getParameter("dni") != null && request.getParameter("dni") != "" &&
          request.getParameter("email") != null && request.getParameter("email") != "" &&
          request.getParameter("telefono") != null && request.getParameter("telefono") != "" &&
          request.getParameter("info") != null && request.getParameter("info") != "" &&
          request.getParameter("pass") != null && request.getParameter("pass") != "" &&
      request.getParameter("usuario") != null && request.getParameter("usuario") != "" )
   {
        clsGestor objGestor= new clsGestor();
        clsPersona objPersona=new clsPersona();
         
        objPersona.setStr_Nombre(request.getParameter("nombre"));
        objPersona.setStr_Apellido(request.getParameter("apellido"));
        objPersona.setStr_DNI(request.getParameter("dni"));
        objPersona.setStr_Email(request.getParameter("email"));
        objPersona.setStr_Telefono(request.getParameter("telefono"));
        objPersona.setStr_Usuario(request.getParameter("usuario"));
        objPersona.setStr_Password(request.getParameter("pass"));
        objPersona.setInt_Informacion(Integer.parseInt(request.getParameter("info")));
        
        out.print(objGestor.insertarPersona(objPersona));
   }else
       out.print("0");
%>

