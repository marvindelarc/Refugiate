<%-- 
    Document   : index
    Created on : 25/06/2013, 12:15:58 AM
    Author     : Paulo
--%>

<%@page import="Entidades.clsWebAdmin"%>
<%@page import="Entidades.clsSucursal"%>
<%@page import="COM.clsGestor"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<meta name="author" content="PaweÅ‚ 'kilab' Balicki - kilab.pl" />
<title>SimpleAdmin</title>
<%
    clsWebAdmin admin=(clsWebAdmin) request.getSession(true).getAttribute("SessionAdmin");
  if(admin==null)
   {
           response.sendRedirect("/index.jsp"); 
   }
  clsGestor objGestor=new clsGestor();
  List<clsSucursal> lista=null;  
  
  if(request.getParameter("IdSucursal") != null && request.getParameter("IdSucursal") != "" && request.getParameter("Estado") != null && request.getParameter("Estado") != "" )
{  
    
    clsGestor.cambiarEstadoSucursal(Integer.parseInt(request.getParameter("IdSucursal")), Integer.parseInt(request.getParameter("Estado")));
}
  
  
%>
<link rel="stylesheet" type="text/css" href="../css/style.css" media="screen" />
<link rel="stylesheet" type="text/css" href="../css/navi.css" media="screen" />
  <script type="text/javascript" src="../js/jquery-1.6.3.min.js"></script>
  	<link rel="stylesheet" type="text/css" media="screen,projection" href="../css/jquery-fallr-1.3.css" />
	<script type="text/javascript" src="../js/jquery.easing.1.3.js"></script>
	<script type="text/javascript" src="../js/highlight.pack.js"></script>	
	<script type="text/javascript" src="../js/jquery-fallr-1.3.pack.js"></script>
    
    
<script type="text/javascript">
$(function(){
	$(".box .h_title").not(this).next("ul").hide("normal");
	$(".box .h_title").not(this).next("#home").show("normal");
	$(".box").children(".h_title").click( function() { $(this).next("ul").slideToggle(); });
});
</script>
<script type="text/javascript" language="javascript">
$(window).load(function(){

 $(function() {
  $('#file-input').change(function(e) {
      addImage(e); 
     });

     function addImage(e){
      var file = e.target.files[0],
      imageType = /image.*/;
    
      if (!file.type.match(imageType))
       return;
  
      var reader = new FileReader();
      reader.onload = fileOnload;
      reader.readAsDataURL(file);
     }
  
     function fileOnload(e) {
      var result=e.target.result;
      $('#imgSalida').attr("src",result);
     }
    });
  });
</script>
<script type="text/javascript">
	     //<![CDATA[
	       function Confirmar(id,nombre,estado)
                {
                     var clicked1 = function(){
	                    window.location ="listaEmpresas.jsp?IdSucursal="+id+"&Estado=1";

	                };
                     var clicked2 = function(){
	                    window.location ="listaEmpresas.jsp?IdSucursal="+id+"&Estado=2";
	                };
                      var clicked3 = function(){
	                    window.location ="listaEmpresas.jsp?IdSucursal="+id+"&Estado=0";
	                };
                    
                    if(estado==0)
                    {
	                $.fallr('show', {
	                    buttons : {
	                        button1 : {text: 'Activar Free',  onclick: clicked1},
                            button2 : {text: 'Activar Primiun',  onclick: clicked2},
	                        button3 : {text: 'Cancel'}
	                    },
	                    content : '<p>Esta Seguro que desea activar a la sigueinte Hotel : </br>'+nombre+' </p>',
                        position: 'center'
	                });
                   }else  if(estado==1)
                    {
	                $.fallr('show', {
	                    buttons : {
	                        button1 : {text: 'Activar Primiun',  onclick: clicked2},
                            button2 : {text: 'Desactivar',  onclick: clicked3},
	                        button3 : {text: 'Cancel'}
	                    },
	                    content : '<p>Esta Seguro que desea activar a la sigueinte Hotel : </br>'+nombre+' </p>',
                        position: 'center'
	                });
                   }else  if(estado==2)
                    {
	                $.fallr('show', {
	                    buttons : {
	                        button1 : {text: 'Activar Free',  onclick: clicked1},
                            button2 : {text: 'Desactivar',  onclick: clicked3},
	                        button3 : {text: 'Cancel'}
	                    },
	                    content : '<p>Esta Seguro que desea activar a la sigueinte Hotel : </br>'+nombre+' </p>',
                        position: 'center'
	                });
                   }
                }
           
           
             function cerrar()
                {
                       var clicked1 = function(){
	                   window.location ="../cerrarSesion.jsp?";
	                };
                   
	                $.fallr('show', {
	                    buttons : {
	                        button1 : {text: 'Activar Free',  onclick: clicked1},
	                        button3 : {text: 'Cancel'}
	                    },
	                    content : '<p>Esta Seguro que desea cerrar sessión  </p>',
                        position: 'center'
	                });
                }

	    
	    //]]>
	</script>
</head>
<body>
<div class="wrap">
	<div id="header">
		<div id="top">
			<div class="left">
					<p>Bienvenido, <strong><%=admin.getStr_Apellido()%>, <%=admin.getStr_Nombre()%>.</strong> [ <a href="#" onclick="cerrar()">Salir</a> ]</p>
			</div>
			<div class="right">
				<div class="align-right">
						<p>Usuario: <strong><%=admin.getStr_Usuario()%></strong></p>
				</div>
			</div>
		</div>
	</div>
	
	<div id="content">
		<div id="sidebar">
			<div class="box">
				<div class="h_title">&#8250; Control Principal</div>
				<ul id="home">
					<li class="b1"><a class="icon view_page" href="index.jsp">Inicio</a></li>
					<li class="b2"><a class="icon report" href="listaEmpresas.jsp">Tipo Empresas</a></li>
					<li class="b1"><a class="icon add_page" href="">Agregar Empresar</a></li>
					<li class="b2"><a class="icon config" href="">Configuracion</a></li>
				</ul>
			</div>
			
			<div class="box">
				<div class="h_title">&#8250; Gestion Empresas</div>
				<ul>
					<li class="b1"><a class="icon page" href="">Mostrar todas</a></li>
					<li class="b2"><a class="icon add_page" href="">Agregar</a></li>
					<li class="b2"><a class="icon category" href="">Categorias</a></li>
				</ul>
			</div>
			<div class="box">
				<div class="h_title">&#8250; Gestionar usuarios</div>
				<ul>
					<li class="b1"><a class="icon users" href="">Mostrar Usuarios</a></li>
					<li class="b2"><a class="icon add_user" href="">Agregar Usurios</a></li>
					<li class="b1"><a class="icon block_users" href="">Usuarios Bloquedos</a></li>
				</ul>
			</div>
			<div class="box">
				<div class="h_title">&#8250; Opciones</div>
				<ul>
					<li class="b1"><a class="icon config" href="">Configuracion sitio</a></li>
					<li class="b2"><a class="icon contact" href="">Datos de Usuario</a></li>
				</ul>
			</div>
		</div>
		<div id="main">
			<div class="full_w">
				<div class="h_title">Empresar Registradas</div>				
			  <%
            lista=objGestor.ListarXEstadoSucursal(-1);  
            if(lista!=null)                                    
            {    
               %>
				<table>
					<thead>
						<tr>
							<th scope="col">ID</th>
							<th scope="col">Nombre</th>
                            <th scope="col">Direccion</th>
							<th scope="col">Departamento</th>
                            <th scope="col">Provincia</th>
                            <th scope="col">Distrito</th>
							<th scope="col">Nivel</th>
                            <th scope="col">Estado</th>
							<th scope="col"></th>
						</tr>
					</thead>
						
					<tbody>
						
                            <%
                      
                                    
                            for(clsSucursal entidad : lista)                               
                             {
                            %>
                            <tr>
                                <td class="align-center"><%=entidad.getInt_IdSucursal()%></td>                            
							<td><%=entidad.getObjEmpresa().getStr_Nombre()%></td>
							<td><%=entidad.getStr_Direccion()%></td>
							<td><%=entidad.getObjDistrito().getObjProvincia().getObjDepartamento().getStr_Nombre()%></td>
                            <td><%=entidad.getObjDistrito().getObjProvincia().getStr_Nombre()%></td>
                            <td><%=entidad.getObjDistrito().getStr_Nombre()%></td>
							<td class="align-center" style="width: 120px;">
                                <% for(int i=0;i<entidad.getInt_Nivel();i++){%>
                                <a class="table-icon stars" ></a>
                                <%} %>
                            </td>
                            <td><% if(entidad.getInt_Estado()==0){%>
                                        Inactivo
                                <%}else if(entidad.getInt_Estado()==1){%>
                                        Free
                                <%}else if(entidad.getInt_Estado()==2){%>
                                        Primium
                                <%}%>
                                
                            </td>
                                        <td>
                                            <a href="#" onclick="Confirmar(<%=entidad.getInt_IdSucursal()%>,'<%=entidad.getObjEmpresa().getStr_Nombre()%>',<%=entidad.getInt_Estado()%>)" class="table-icon edit" title="Edit"></a>
                                        </td>
                                    </tr>
                                <%}%>
                                </tbody>
                            </table>
			 <%}else{%>
                    <center>  <h2>No hay nuevos registros</h2> </center>
                    <%}%>
                </div>
            </div>
            <div class="clear"></div>
            </div>

            <div id="footer">
                <div class="left">
                    <p>Design: REFUGIATE &copy; | </p>
                </div>
            </div>
        </div>
    </body>
</html>
