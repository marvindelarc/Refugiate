<%@page import="COM.clsGestor"%>
<%@page import="Entidades.clsCostoTipoHabitacion"%>
<%@page import="java.util.List"%>
<select id="cbTipoHabitacion" name="cbTipoHabitacion" title="Por favor selecione opcion!" required>
   <option value="">Selecione una Opción</option>

    <%  
        List<clsCostoTipoHabitacion> lista=clsGestor.ListarCostoTipoHabitacion(true);
        if(lista!=null)
            for(clsCostoTipoHabitacion entidad : lista)
                out.print("<option value='"+entidad.getIdCostoTipoHabitacion()+"'>"+entidad.getCosto()+"("+entidad.getTotalHabitaciones()+")</option>");
    %>
</select>