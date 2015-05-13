
<%@page import="COM.clsGestor"%>
<%@page import="Entidades.clsPaquete"%>
<%@page import="java.util.List"%>
<select id="cbPaquete" name="cbPaquete" title="Por favor selecione un Vivero!" required>
   <option value="">Selecione una Opción</option>

<%
  
     List<clsPaquete> lista=clsGestor.ListarPaquete(true);
    if(lista!=null)
        for(clsPaquete entidad : lista)
            out.print("<option value='"+entidad.getIdPaquete()+"'>"+entidad.getMeses()+"("+entidad.getMonto()+")</option>");

 %>
</select>