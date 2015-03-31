
<%@page import="Entidades.clsCostoTipoHabitacion"%>
<%@page import="java.util.List"%>
<%@page import="COM.clsGestor"%>

<%
  

if(request.getParameter("IdSucursal") != null && request.getParameter("IdSucursal") != "" )
{  clsGestor objGestor= new clsGestor(); 
   List<clsCostoTipoHabitacion>  lista=objGestor.listarCostoTipoHabitacionXIdSucursales(Integer.parseInt(request.getParameter("IdSucursal")));
   if(lista!=null)
   {
       String Datos="";       
       for(clsCostoTipoHabitacion entidad: lista)
          Datos+=entidad.getInt_IdCostoTipoHabitacion()+"<col>"+
                  entidad.getObjTipoHabitacion().getNombreComercial()+"<col>"+
                  entidad.getDou_Costo()+"<col>"+
                 (entidad.getInt_TotalHabitaciones()-entidad.getInt_HabitacionesOcupadas())+"<col><cls>";
         out.print(Datos);
   }else
       out.print("0");
}else
     out.print("0");
%>