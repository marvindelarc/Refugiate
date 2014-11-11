<%@page import="Entidades.clsProvincia"%>
<%@page import="COM.clsGestor"%>
<%@page import="java.util.*" %>
<%@page contentType="text/html" pageEncoding="UTF-8" language="java" %>
<html>
    <head>

    </head>
    <body>
        <%  
        int id_pro = 0;
        id_pro = Integer.parseInt(request.getParameter("id_pro"));
        clsGestor objUbicacionCOM = new clsGestor();
        List<clsProvincia> ListProvincia = objUbicacionCOM.listarProvinciaXDepartamento(id_pro);
            if(ListProvincia!=null){
                out.write("<select name='cbProvincia' id='Provincia' onchange='getDistrito(this.value)'>");
                for(clsProvincia objProvincia : ListProvincia ){
                    out.write("<option value=" + objProvincia.getInt_IdProvincia()+ ">" + objProvincia.getStr_Nombre()+ "</option>");
                }
                out.write("</select>");
            }else{
                out.write("<select name='cbProvincia' id='Provincia'></select>");
            }
        %>
    </body>
</html>