<%@page import="Entidades.clsSucursal"%>
<%@page import="Entidades.clsEncargado"%>
<%@page import="Entidades.clsReserva"%>
<%@page import="Entidades.clsInstalacion"%>
<%@page import="java.util.List"%>
<%@page import="COM.clsGestor"%>
<%
      clsGestor objGestor=new clsGestor();
     clsEncargado admin=(clsEncargado) request.getSession(true).getAttribute("SessionEncargado");
  if(admin==null)
   {
           response.sendRedirect("/index.jsp"); 
   }
 
  clsSucursal objSucursal=objGestor.buscarIdSucursal(admin.getObjSucursal().getInt_IdSucursal());
    if(request.getParameter("IdReserva") != null && request.getParameter("IdReserva") != "")
    {
        objGestor.activar(Integer.parseInt(request.getParameter("IdReserva")));
    }
  List<clsReserva> lista=objGestor.listarXIdSucursal(admin.getObjSucursal().getInt_IdSucursal());  
    if(lista!=null)                                    
    {    
       %>
        <table>
            <thead>
                <tr>
                    <th scope="col">ID</th>
                    <th scope="col">Nombre</th>
                     <th scope="col">Apellido</th>
                      <th scope="col">Email</th>
                      <th scope="col">Telefono</th>
                    <th scope="col">Usuario</th>

                    <th scope="col"></th>
                </tr>
            </thead>

            <tbody>

                    <%
                    for(clsReserva entidad : lista) {
                    %>
                    <tr>
                    <td class="align-center"><%=entidad.getInt_IdReserva()%></td>
                    <td ><%=entidad.getObjPersona().getStr_Nombre()%></td>
                    <td ><%=entidad.getObjPersona().getStr_Apellido()%></td>
                    <td ><%=entidad.getObjPersona().getStr_Email()%></td>
                    <td ><%=entidad.getObjPersona().getStr_Telefono()%></td>
                    <td ><%=entidad.getObjPersona().getStr_Usuario()%></td>
                    <td>
                        <a href="#"  onclick="Confirmar(<%=entidad.getInt_IdReserva()%>,'<%=entidad.getObjPersona().getStr_Apellido()%>, <%=entidad.getObjPersona().getStr_Nombre()%>')" class="table-icon edit" title="Edit"></a>
                    </td>
                  </tr>
                  <%}%>
            </tbody>
        </table>
     <%}else{%>
     <center>  <h2>No hay nuevos registros</h2> </center>
     <%}%>
             
                