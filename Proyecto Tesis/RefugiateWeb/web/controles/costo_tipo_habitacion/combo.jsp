
<%@page import="Entidades.clsTipoHabitacion"%>
<%@page import="COM.clsGestor"%>
<%@page import="java.util.List"%>
<select id="cbTipoHabitacion" name="cbTipoHabitacion" title="Por favor selecione Tipo Habitacion!" required>
    <option value="">Selecione una Opci�n</option>

<%  
    List<clsTipoHabitacion> lista=clsGestor.ListarTipoHabitacion(true);
    if(lista!=null)
        for(clsTipoHabitacion entidad : lista)
            out.print("<option value='"+entidad.getIdTipoHabitacion()+"'>"+entidad.getNombreComercial()+"</option>");
 %>
</select>