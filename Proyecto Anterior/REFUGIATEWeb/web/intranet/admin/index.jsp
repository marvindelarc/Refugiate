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
<html>
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1, user-scalable=0" />
        <title>Admin Ref&uacute;giate</title>
        <link rel="shortcut icon" type="img/x-icon" href="../../new/img/favicon.ico" />
        
        <%
            clsWebAdmin admin=(clsWebAdmin) request.getSession(true).getAttribute("SessionAdmin");
            if(admin==null){ response.sendRedirect("/index.jsp"); }
            clsGestor objGestor=new clsGestor();
            List<clsSucursal> lista=null;  
            
            if(request.getParameter("IdSucursal") != null && request.getParameter("IdSucursal") != "" && request.getParameter("Estado") != null && request.getParameter("Estado") != "" )
            { clsGestor.cambiarEstadoSucursal(Integer.parseInt(request.getParameter("IdSucursal")), Integer.parseInt(request.getParameter("Estado"))); }
        %>
        <link rel="stylesheet" type="text/css" href="../css/style.css" media="screen" />
        <link rel="stylesheet" type="text/css" href="../css/navi.css" media="screen" />
        <link rel="stylesheet" type="text/css" media="screen,projection" href="../css/jquery-fallr-1.3.css" />
        
        <script type="text/javascript" src="../js/highlight.pack.js"></script>	
        <script type="text/javascript" src="../js/jquery-1.6.3.min.js"></script>
        <script type="text/javascript" src="../js/jquery.easing.1.3.js"></script>
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
                    $('#file-input').change(function(e) { addImage(e); });
                    function addImage(e){
                        var file = e.target.files[0],
                        imageType = /image.*/;
                        if (!file.type.match(imageType))return;
                        var reader = new FileReader();
                        reader.onload = fileOnload;
                        reader.readAsDataURL(file);
                    }

                    function fileOnload(e){
                        var result=e.target.result;
                        $('#imgSalida').attr("src",result);
                    }
                });
            });
        </script>
     
        <script type="text/javascript">
            jQuery(document).ready(function(){	
                $(function() {
                    var chart;
                    $(document).ready(function() {
                        Highcharts.setOptions({colors: ['#32353A']});
                        chart = new Highcharts.Chart({
                            chart: { renderTo: 'container',type: 'column',margin: [ 30, 10, 70, 60]},
                            title: {text: 'Registro de Empresas por Mes'},
                            xAxis: {
                                categories: [
                                    'Julio 2012','Agosto 2012','Setiembre 2012','Octubre 2012','Noviembre 2012',
                                    'Diciembre 2012','Enero 2013','Febrero 2013','Marzo 2013','Abril 2013',
                                    'Mayo 2013','Junio 2013','Julio 2013'
                                ],
                                labels: {
                                    rotation: -45, align: 'right',
                                    style: {fontSize: '9px',fontFamily: 'Tahoma, Verdana, sans-serif'}
                                }
                            },
                            yAxis: {
                                min: 0, title: { text: 'Empresas' }
                            },
                            legend: {enabled: false},
                            tooltip: {
                                formatter: function() {
                                    return '<b>'+ this.x +'</b><br/>'+
                                    'Empresas: '+ Highcharts.numberFormat(this.y, 0);
                                }
                            },
                            series: [{
                                name: 'Empresas',
                                data: [25, 35, 42,51, 62, 67, 74, 81, 93, 112, 125, 142],
                                dataLabels: {
                                    enabled: false,
                                    rotation: 0,
                                    color: '#F07E01',
                                    align: 'right',
                                    x: -3, y: 20,
                                    formatter: function() { return this.y; },
                                    style: { fontSize: '11px', fontFamily: 'Verdana, sans-serif' }
                                }, 
                                pointWidth: 55
                            }]
                        });
                    });
                });
            });
        </script> 
    
        <script type="text/javascript">
            function Confirmar(id,nombre){
                var clicked1 = function(){ window.location ="index.jsp?IdSucursal="+id+"&Estado=1";};
                var clicked2 = function(){ window.location ="index.jsp?IdSucursal="+id+"&Estado=2";};
                $.fallr('show', {
                    buttons : {
                        button1 : {text: 'Activar Free',  onclick: clicked1},
                        button2 : {text: 'Activar Premiun',  onclick: clicked2},
                        button3 : {text: 'Cancel'}
                    },
                    content : '<p>Esta Seguro que desea activar al sigueinte Hotel : </br>'+nombre+' </p>',
                    position: 'center'
                });
            }

            function cerrar(){
                var clicked1 = function(){ window.location ="../cerrarSesion.jsp?";};
                $.fallr('show', {
                    buttons : {
                        button1 : {text: 'Aceptar',  onclick: clicked1},
                        button3 : {text: 'Cancel'}
                    },
                    content : '<p>Esta Seguro que desea cerrar sessión  </p>',
                    position: 'center'
                });
            }
        </script>
    </head>
    <body>
        <div class="wrap">
            <div id="header">
                <div id="top">
                    <div class="left">
                        <p>Bienvenido, <strong><%=admin.getStr_Apellido()%>, <%=admin.getStr_Nombre()%>.</strong> [ <a href="#" onclick="cerrar()" >Salir</a> ]</p>
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
                    <div class="h_title">Empresas Afiliadas</div>
                    <div id="container"  style="min-width: 300px; height: 200px; margin: 0 auto"></div>
                    <script src="../js/highcharts.js"></script>
                </div>			
                <div class="clear"></div>
                <div class="full_w">
                    <div class="h_title">Nuevas Empresas Afiliadas</div>				
                        <%
                            lista=objGestor.ListarXEstadoSucursal(0);  
                            if(lista!=null){    
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
                                    <th scope="col"></th>
                                </tr>
                            </thead>
						
                            <tbody>
                                <%      
                                    for(clsSucursal entidad : lista){
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
                                    <td>
                                        <a href="#" onclick="Confirmar(<%=entidad.getInt_IdSucursal()%>,'<%=entidad.getObjEmpresa().getStr_Nombre()%>')" class="table-icon edit" title="Edit"></a>
                                    </td>
                                </tr>
                                <%}%>
                            </tbody>
                        </table>
                        <%}else{%>
                            <center><h2>No hay nuevos registros</h2> </center>
                        <%}%>                
                    </div>
                </div>
                <div class="clear"></div>
            </div>

            <div id="footer">
                <div class="left">
                    <p>Copyright &copy; 2013<span>|</span>Design by: <a href="#">M&T</a> </p>
                </div>
            </div>
        </div>
    </body>
</html>
