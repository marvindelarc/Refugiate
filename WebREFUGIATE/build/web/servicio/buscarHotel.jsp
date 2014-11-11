
<%@page import="Entidades.clsComentario"%>
<%@page import="Entidades.clsCostoTipoHabitacion"%>
<%@page import="Entidades.clsSucursal"%>
<%@page import="java.util.List"%>
<%@page import="COM.clsGestor"%>

<%
    
if(request.getParameter("IdEmpresa") != null && request.getParameter("IdEmpresa") != "" )
{          
   clsGestor objGestor= new clsGestor();      
   clsSucursal entidad=objGestor.buscarIdSucursal(Integer.parseInt(request.getParameter("IdEmpresa")));
   if(entidad!=null)
   {
       String Datos="";
       
          Datos+=entidad.getInt_IdSucursal()+"<col>"+
                  entidad.getStr_Telefono()+"<col>"+
                  entidad.getStr_Direccion()+"<col>"+
                  entidad.getDou_Longitud()+"<col>"+
                  entidad.getDou_Latitud()+"<col>"+
                  entidad.getInt_Pisos()+"<col>"+
                  entidad.getInt_Limpieza()+"<col>"+
                  entidad.getInt_Servicio()+"<col>"+
                  entidad.getInt_Comodidad()+"<col>"+
                  entidad.getInt_Puntos()+"<col>"+
                  entidad.getInt_Nivel()+"<col>"+
                  entidad.getInt_Estado()+"<col>"+
                  entidad.getStr_Entrada()+"<col>"+
                  entidad.getStr_Salida()+"<col>"+
                  entidad.getObjEmpresa().getStr_Nombre()+"<col>"+
                  entidad.getObjDistrito().getStr_Nombre()+"<col>";
         
          List<clsCostoTipoHabitacion>  listaTipoHavitacion=objGestor.listarCostoTipoHabitacionXIdSucursales(Integer.parseInt(request.getParameter("IdEmpresa"))); 
          if(listaTipoHavitacion!=null)
            {      
                for(clsCostoTipoHabitacion tipo : listaTipoHavitacion)               
                   Datos+=tipo.getInt_IdCostoTipoHabitacion()+"<cls>"+
                           tipo.getObjTipoHabitacion().getNombreComercial()+"<cls>"+
                           tipo.getDou_Costo()+"<cls>"+
                          (tipo.getInt_TotalHabitaciones()-tipo.getInt_HabitacionesOcupadas())+"<cls><obj>";
                
                   Datos+="<col>";
             
                 
            }else
                Datos+="0<col>";
         
          
          List<clsComentario>listaComentario=objGestor.ListarXSucursalComentario(Integer.parseInt(request.getParameter("IdEmpresa"))); 
          if(listaComentario!=null)
            {      
                for(clsComentario tipo : listaComentario)               
                   Datos+=tipo.getInt_IdComentario()+"<cls>"+
                           tipo.getInt_IdReserva()+"<cls>"+
                           tipo.getStr_Descripcion()+"<cls>"+
                           tipo.getStr_Usuario()+"<cls><obj>";
                
                   Datos+="<col>";
             
                 
            }else
                Datos+="0<col>";
          
         out.print(Datos);
   }else
       out.print("0");
 }else
       out.print("0");
%>