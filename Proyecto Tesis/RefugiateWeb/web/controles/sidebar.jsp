<%@page import="sun.misc.BASE64Encoder"%>
<%@page import="Entidades.clsEncargado"%>
<%
    clsEncargado objEncargado = (clsEncargado) request.getSession().getAttribute("SessionEncargado");
    if (objEncargado != null) {
        BASE64Encoder e = new BASE64Encoder();
%>
<!-- BEGIN CONTAINER -->
<div id="sidebar">
    <div class="page-sidebar" id="main-menu">
        <!-- BEGIN MINI-PROFILE -->
        <div class="user-info-wrapper">
            <div class="profile-wrapper"> 

                <%if (objEncargado.getAdmin() == 0) {%>
                <img src="data:image/png;base64,<%=e.encodeBuffer(objEncargado.getObjSucursal().getObjEmpresa().getLogo())%>" width="69" height="69" />
                <%} else {%>
                <img src="../assets/img/logo.png" width="69" height="69" />    
                <%}%>


            </div>
            <div class="user-info">
                <div class="greeting">Bienvenido</div>
                <div class="username">
                    <%=objEncargado.getApellido()%> <span class="semi-bold">
                    <%=objEncargado.getNombre()%></span>
                </div>
                <div class="status">Estado<a href="#">
                        <div class="status-icon green"></div>
                        Linea</a>
                </div>
            </div>
        </div>
        <!-- END MINI-PROFILE -->  
        <br>
        <!-- BEGIN SIDEBAR MENU -->
        <%if (objEncargado.getAdmin() == 0) {%>
        <ul>
            <li class="start active "> 
                <a href="../intranet.jsp"> 
                    <i class="icon-bar-chart"></i> <span class="title">Dashboard</span> <span class="selected"></span>
                </a>
            </li>
            <li class="start active "> 
                <a href="../crud_empresa.jsp">
                    <i class="icon-th-large"></i> <span class="title">Empresa</span> <span class="selected"></span> 
                </a>
            </li>
            <li class="start active "> 
                <a href="../crud_encargado.jsp">
                    <i class="icon-group"></i> <span class="title">Encargados</span> <span class="selected"></span> 
                </a>
            </li>
            <li class="start active "> 
                <a href="../crud_costo_tipo_habitacion.jsp">
                    <i class="icon-money"></i> <span class="title">Costo Habitaciones</span> <span class="selected"></span> 
                </a>
            </li>
            <li class="start active "> 
                <a href="../crud_habitacion.jsp">
                    <i class="icon-inbox"></i> <span class="title">Habitaciones</span> <span class="selected"></span> 
                </a>
            </li>
            <li class="start active "> 
                <a href="../crud_paquete.jsp">
                    <i class="icon-archive"></i> <span class="title">Paquetes</span> <span class="selected"></span> 
                </a>
            </li>      
        </ul>
        <%} else {%>
        <ul>
            <li class="start active "> 
                <a href="../intranet.jsp"> 
                    <i class="icon-bar-chart"></i> <span class="title">Dashboard</span> <span class="selected"></span>
                </a>
            </li>
            <li class="start active "> 
                <a href="../crud_empresa.jsp">
                    <i class="icon-th-large"></i> <span class="title">Empresa</span> <span class="selected"></span> 
                </a>
            </li>
            <li class="start active "> 
                <a href="../crud_encargado.jsp">
                    <i class="icon-group"></i> <span class="title">Encargados</span> <span class="selected"></span>
                </a>
            </li>
            <li class="start active "> 
                <a href="../crud_servicio.jsp">
                    <i class="icon-gears"></i> <span class="title">Servicios</span> <span class="selected"></span> 
                </a>
            </li>
            <li class="start active "> 
                <a href="../crud_instalacion.jsp">
                    <i class="icon-glass"></i> <span class="title">Instalaciones</span> <span class="selected"></span>
                </a>
            </li>
           <li class="start active "> 
                <a href="../crud_tipo_habitacion.jsp">
                    <i class="icon-inbox"></i> <span class="title">Tipos Habitacións</span> <span class="selected"></span> 
                </a>
            </li>
        </ul>
        <%}%>

        <!-- END SIDEBAR MENU -->
    </div>
</div>
<!-- END PAGE -->
<%}%>   