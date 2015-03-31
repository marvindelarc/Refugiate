
<%@page import="Entidades.clsCostoTipoHabitacion"%>
<%@page import="java.util.List"%>
<%@page import="COM.clsGestor"%>

<%
  

 clsGestor objGestor= new clsGestor(); 
   List<clsCostoTipoHabitacion>  lista=objGestor.listarCostoTipoHabitacion();
   if(lista!=null)
   {
       String Datos="";       
       for(clsCostoTipoHabitacion entidad: lista)
            Datos+=entidad.getInt_IdCostoTipoHabitacion()+"<col>"+
            entidad.getObjTipoHabitacion().getInt_IdTipoHabitacion()+"<col>"+
            entidad.getObjTipoHabitacion().getNombreComercial()+"<col>"+
            entidad.getObjSucursal().getInt_IdSucursal()+"<col><cls>";
            out.print(Datos);
   }else
       out.print("0");

%>