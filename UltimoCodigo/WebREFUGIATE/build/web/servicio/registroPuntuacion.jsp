
<%@page import="Entidades.clsReserva"%>
<%@page import="Entidades.clsPuntuacion"%>
<%@page import="COM.clsGestor"%>

<%
  if(request.getParameter("IdReserva") != null && request.getParameter("IdReserva") != "" && 
          request.getParameter("limpieza") != null && request.getParameter("limpieza") != ""&& 
          request.getParameter("servicio") != null && request.getParameter("servicio") != ""&& 
          request.getParameter("comodidad") != null && request.getParameter("comodidad") != "" )
   {
        clsGestor objGestor= new clsGestor();
        
        clsReserva objReserva = new clsReserva();
        objReserva.setInt_IdReserva(Integer.parseInt(request.getParameter("IdReserva")));  
        
        clsPuntuacion objPuntuacion= new clsPuntuacion();
        objPuntuacion.setInt_Limpieza(Integer.parseInt(request.getParameter("limpieza")));  
        objPuntuacion.setInt_Servicio(Integer.parseInt(request.getParameter("servicio")));  
        objPuntuacion.setInt_Comodidad(Integer.parseInt(request.getParameter("comodidad")));  
        objPuntuacion.setObjReserva(objReserva);
        out.print(objGestor.insertarPuntuacion(objPuntuacion));
   }else
       out.print("0");
%>

