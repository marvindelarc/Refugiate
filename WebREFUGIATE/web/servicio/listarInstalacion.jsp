
<%@page import="Entidades.clsInstalacion"%>
<%@page import="java.util.List"%>
<%@page import="COM.clsGestor"%>

<%
  

 clsGestor objGestor= new clsGestor(); 
   List<clsInstalacion>  lista=objGestor.listardTodosInstalacion();
   if(lista!=null)
   {
       String Datos="";       
       for(clsInstalacion entidad: lista)
            Datos+=entidad.getInt_IdInstalacion()+"<col>"+
            entidad.getObjServicio().getInt_IdServicio()+"<col>"+
            entidad.getObjSucursal().getInt_IdSucursal()+"<col>"+
            entidad.getObjServicio().getStr_Nombre()+"<col>"+
            entidad.getStr_Descrpcion()+"<col><cls>";
            out.print(Datos);
   }else
       out.print("0");

%>