
<%@page import="Entidades.clsSucursal"%>
<%@page import="COM.clsGestor"%>
<%@page import="java.util.List"%>
<select id="cbDistrito" name="cbDistrito" title="Por favor selecione sucursal!" required>
    <option value="">Selecione una Opción</option>

<%  
    List<clsSucursal> lista=clsGestor.listarSucursalPorDistrito(1);
    if(lista!=null)
        for(clsSucursal entidad : lista)
            out.print("<option value='"+entidad.getIdSucursal()+"'>"+entidad.getObjDistrito().getNombre()+"</option>");
 %>
</select>