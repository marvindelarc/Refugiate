<%@page import="sun.misc.BASE64Encoder"%>
<%@page import="Entidades.clsEncargado"%>
<%
    clsEncargado objEncargado = (clsEncargado) request.getSession().getAttribute("SessionEncargado");
    if (objEncargado != null) {
        BASE64Encoder e = new BASE64Encoder();
%>

<div  id="header" class="pull-right"> 
    <div class="chat-toggler">
        <div class="user-details"> 
            <div class="username">
                <img alt="" src="data:image/png;base64,<%=e.encodeBuffer(objEncargado.getObjSucursal().getObjEmpresa().getBanner())%>" width="55" height="35" /> 
            </div>						
        </div>
    </div>
    <ul class="nav quick-section ">
        <li class="quicklinks">
            <a data-toggle="dropdown" class="dropdown-toggle  pull-right" href="#">						
                <div class="iconset top-settings-dark "></div> 	
            </a>
            <ul class="dropdown-menu  pull-right" role="menu" aria-labelledby="dropdownMenu">
                <li><a href="user-profile.html"> Mi Perfil</a></li>
                <li class="divider"></li>
                <li><a href="login.html"><i class="icon-off"></i>&nbsp;&nbsp;Cerrar Sesión</a></li>
            </ul>
        </li> 
        <li class="quicklinks"> <span class="h-seperate"></span></li>
    </ul>
    <div id="myModal" class="modal hide fade" tabindex="-2" style="width:200px; height:70; display: block; margin-top: auto;  margin-left: auto;margin-right: auto;"  role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" data-backdrop="static" data-keyboard="false">
        <div class="modal-body">
            <div class="row-fluid">
                <center><h4><img width="60" height="60" src="assets/img/cargando.gif" alt=""/>Espere <span class="semi-bold">...</span></h4></center>
            </div>
        </div>
    </div>  
</div>
<%}%>   