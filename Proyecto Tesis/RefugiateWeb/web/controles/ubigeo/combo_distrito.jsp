<%@page import="Entidades.clsDistrito"%>
<%@page import="java.util.List"%>
<%@page import="COM.clsGestor"%>
<select id="cbDistrito" name="cbDistrito" title="Por favor selecione una provincia!" onchange="getMapa()" required>
   <option value="">Selecione un Distrito</option>
<%
    if(request.getParameter("id") != null && request.getParameter("id") != "")
    {
        List<clsDistrito> list =clsGestor.listarDistrito(Integer.parseInt(request.getParameter("id") ));
        if(list!=null)
     
            for(clsDistrito entidad : list)
                out.print("<option value='"+entidad.getIdDistrito()+"'>"+entidad.getNombre()+"</option>"); 
    }
 %>
</select>