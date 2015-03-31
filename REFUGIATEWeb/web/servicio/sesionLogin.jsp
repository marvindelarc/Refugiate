
<%@page import="Entidades.clsComentario"%>
<%@page import="Entidades.clsDetalleReserva"%>
<%@page import="java.util.List"%>
<%@page import="Entidades.clsPersona"%>
<%@page import="COM.clsGestor"%>

<%
   clsGestor objGestor= new clsGestor();   
   
  
  if(request.getParameter("pass") != null && request.getParameter("pass") != "" &&
      request.getParameter("usuario") != null && request.getParameter("usuario") != "" )
   {
       String data="";
       clsPersona entidad=objGestor.loginPersona(request.getParameter("usuario"),request.getParameter("pass"));
          if(entidad!=null)
          {
          data=""+entidad.getInt_IdPersona()+"<col>"+
                  entidad.getStr_Nombre()+"<col>"+
                  entidad.getStr_Apellido()+"<col>"+
                  entidad.getStr_Telefono()+"<col>"+
                  entidad.getStr_Email()+"<col>"+
                  entidad.getStr_DNI()+"<col>";
          
          List<clsDetalleReserva> listaDetalleReserva = objGestor.listarXIdPersona(entidad.getInt_IdPersona());
           if(listaDetalleReserva!=null)
            {   
                for(clsDetalleReserva detalle:listaDetalleReserva)
                data+=""+detalle.getInt_IdDetalleReserva()+"<cls>"+
                        detalle.getObjReserva().getInt_IdReserva()+"<cls>"+
                        detalle.getDat_FechaIngreso().getTime()+"<cls>"+
                        detalle.getObjCostoTipoHabitacion().getInt_IdCostoTipoHabitacion()+"<cls>"+
                        detalle.getInt_NHabitaciones()+"<cls>"+
                        detalle.getInt_Dias()+"<cls>"+
                        detalle.getDou_Total()+"<cls>"+
                        detalle.getObjCostoTipoHabitacion().getObjTipoHabitacion().getNombreComercial()+"<cls>"+
                        detalle.getObjCostoTipoHabitacion().getObjSucursal().getObjEmpresa().getStr_NombreComercial()+"<cls>"+ 
                        detalle.getInt_IdComentario()+"<cls>"+ 
                        detalle.getInt_IdPuntuacion()+"<cls><obj>"; 
                 
                data+="<col>";
            }
            else
               data+="0<col>";
           
           List<clsComentario> listaComentario = objGestor.ListarXIdPersona(entidad.getInt_IdPersona());
           if(listaComentario!=null)
            {   
                for(clsComentario comentario:listaComentario)
                data+=""+comentario.getInt_IdComentario()+"<cls>"+
                        comentario.getInt_IdReserva()+"<cls>"+
                        comentario.getStr_Descripcion()+"<cls>"+
                        comentario.getDat_Fecha().getTime()+"<cls>"+
                        comentario.getStr_Usuario()+"<cls><obj>"; 
                 
                data+="<col>";
            }
            else
               data+="0<col>";
           
            out.print(data);
    
          }
          else
               out.print("0");
   }else
       out.print("0");
%>
