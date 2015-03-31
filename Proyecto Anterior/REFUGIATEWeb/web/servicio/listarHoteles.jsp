
<%@page import="Entidades.clsSucursal"%>
<%@page import="java.util.List"%>
<%@page import="COM.clsGestor"%>

<%
   clsGestor objGestor= new clsGestor();   
   
   List<clsSucursal> lista=objGestor.listarServicioEmpresa();
   if(lista!=null)
   {
       String Datos="";
       
       for(clsSucursal entidad: lista)
          Datos+=entidad.getInt_IdSucursal()+"<col>"+
                  entidad.getInt_Nivel()+"<col>"+                
                  entidad.getDou_Latitud()+"<col>"+
                   entidad.getDou_Longitud()+"<col>"+
                  entidad.getObjEmpresa().getStr_NombreComercial()+"<col>"+
                  entidad.getInt_Estado()+"<col>"+
                  entidad.getInt_Puntos()+"<col><cls>";
         out.print(Datos);
   }else
       out.print("0");
%>