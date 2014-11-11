
<%@page import="Entidades.clsReserva"%>
<%@page import="Entidades.clsPersona"%>
<%@page import="COM.clsGestor"%>

<%
  if(request.getParameter("IdPersona") != null && request.getParameter("IdPersona") != "" && 
          request.getParameter("IdSucursal") != null && request.getParameter("IdSucursal") != "" )
   {
        clsGestor objGestor= new clsGestor();
        clsPersona objPersona=new clsPersona();        
        objPersona.setInt_IdPersona(Integer.parseInt(request.getParameter("IdPersona")));
        
        
        clsReserva objReserva= new clsReserva();
        objReserva.setObjPersona(objPersona);
        objReserva.setInt_IdSucursal(Integer.parseInt(request.getParameter("IdSucursal")));
        out.print(objGestor.insertarReserva(objReserva));
   }else
       out.print("0");
%>

