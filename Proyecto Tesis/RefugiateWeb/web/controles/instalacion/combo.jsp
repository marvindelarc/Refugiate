
<%@page import="Entidades.clsServicio"%>
<%@page import="COM.clsGestor"%>
<%@page import="java.util.List"%>
<select id="cbServicio" name="cbServicio" title="Por favor selecione !" required>
    <option value="">Selecione una Opción</option>
    <%  
        List<clsServicio> lista=clsGestor.ListarServicio(true);
        if(lista!=null)
            for(clsServicio entidad : lista)
                out.print("<option value='"+entidad.getIdServicio()+"'>"+entidad.getNombre()+"</option>");
    %>
</select>