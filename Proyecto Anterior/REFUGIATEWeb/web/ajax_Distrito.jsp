
<%@page import="Entidades.clsDistrito"%>
<%@page import="COM.clsGestor"%>
<%@page import="java.util.*" %>
<%@page contentType="text/html" pageEncoding="UTF-8" language="java" %>
<html>
    <head>

    </head>
    <body>
        <%  
            int id_pro = 0;
            id_pro =Integer.parseInt(request.getParameter("id_pro"));
            clsGestor objUbicacionCOM = new clsGestor();
            List<clsDistrito> ListDistrito = objUbicacionCOM.listarDistritoXProvincia(id_pro);
                if(ListDistrito!=null){
                    out.write("<select name='cbDistrito' data-validate='validate(required)' >");
                    for(clsDistrito objDistrito : ListDistrito ){
                        out.write("<option value=" + objDistrito.getInt_IdDistrito()+ ">" + objDistrito.getStr_Nombre()+ "</option>");
                    }
                    out.write("</select>");
                }else{
                    out.write("<select name='cbDistrito'></select>");
                }
        %>
    </body>
</html>