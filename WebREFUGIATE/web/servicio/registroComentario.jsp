
<%@page import="Entidades.clsComentario"%>
<%@page import="Entidades.clsPersona"%>
<%@page import="COM.clsGestor"%>

<%
  if(request.getParameter("IdReserva") != null && request.getParameter("IdReserva") != "" && 
          request.getParameter("comentario") != null && request.getParameter("comentario") != "" )
   {
        clsGestor objGestor= new clsGestor();
        
        clsComentario objComentario= new clsComentario();
        objComentario.setInt_IdReserva(Integer.parseInt(request.getParameter("IdReserva")));
        objComentario.setStr_Descripcion(request.getParameter("comentario"));        
        out.print(objGestor.insertarComententario(objComentario));
   }else
       out.print("0");
%>

