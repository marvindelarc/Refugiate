<%@page import="Entidades.clsDepartamento"%>
<%@page import="java.util.List"%>
<%@page import="COM.clsGestor"%>
 <select id="cbDepartamento" name="cbDepartamento" onchange="getProvincia(this.value)" title="Por favor selecione un departamento!" required>
        <option value="">Selecione un Departamento</option>
        <%  List<clsDepartamento> ListDepartamento = clsGestor.ListarDepartamento(true);
          if(ListDepartamento!=null) 
            for(clsDepartamento objDepartamento : ListDepartamento ) {%>

            <option value="<%=objDepartamento.getIdDepartamento()%>"><%=objDepartamento.getNombre()%></option>
         <%  }%>
</select>