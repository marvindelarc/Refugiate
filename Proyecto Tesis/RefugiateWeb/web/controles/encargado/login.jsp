
<%@page import="Entidades.clsEncargado"%>
<%@page import="COM.clsGestor"%>
<%  
    if( request.getParameter("txtUsername") != null && request.getParameter("txtUsername") != "" &&
            request.getParameter("txtPassword") != null && request.getParameter("txtPassword") != "")
    {
      clsEncargado objEncargado= clsGestor.loginEncargado(request.getParameter("txtUsername"), request.getParameter("txtPassword"));
        if(objEncargado!=null)
        {                 
                HttpSession sesion = request.getSession();
                sesion.setAttribute("SessionEncargado", objEncargado); 
                sesion.setMaxInactiveInterval(-1);
                out.print(1);         }  
        else
           out.print(0);
    }
    else
        out.print(-1);
 %>