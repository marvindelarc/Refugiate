
<%@page import="Entidades.clsCostoTipoHabitacion"%>
<%@page import="Entidades.clsReserva"%>
<%@page import="java.util.Date"%>
<%@page import="Entidades.clsDetalleReserva"%>
<%@page import="COM.clsGestor"%>

<%
  if(request.getParameter("fecha") != null && request.getParameter("fecha") != "" &&
          request.getParameter("IdCostoTipo") != null && request.getParameter("IdCostoTipo") != "" &&
          request.getParameter("IdReserva") != null && request.getParameter("IdReserva") != "" &&
          request.getParameter("nHabitaciones") != null && request.getParameter("nHabitaciones") != "" &&
          request.getParameter("dias") != null && request.getParameter("dias") != "" &&
      request.getParameter("total") != null && request.getParameter("total") != "" )
   {
        clsGestor objGestor= new clsGestor();
        
        clsReserva objReserva = new clsReserva();
        objReserva.setInt_IdReserva(Integer.parseInt(request.getParameter("IdReserva")));
        
        clsCostoTipoHabitacion objCosto=new clsCostoTipoHabitacion();
        objCosto.setInt_IdCostoTipoHabitacion(Integer.parseInt(request.getParameter("IdCostoTipo")));
        
        
        clsDetalleReserva objDetalle=new clsDetalleReserva();
        objDetalle.setObjCostoTipoHabitacion(objCosto);
        objDetalle.setObjReserva(objReserva);
        objDetalle.setInt_NHabitaciones(Integer.parseInt(request.getParameter("nHabitaciones")));
        objDetalle.setInt_Dias(Integer.parseInt(request.getParameter("dias")));
        objDetalle.setDou_Total(Double.parseDouble(request.getParameter("total")));
        objDetalle.setDat_FechaIngreso(new Date(Long.parseLong(request.getParameter("fecha"))));
        
 
        out.print(objGestor.insertarDetalleReserva(objDetalle));
   }else
       out.print("0");
%>

