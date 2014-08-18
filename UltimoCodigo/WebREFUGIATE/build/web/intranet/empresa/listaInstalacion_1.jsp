<%-- 
    Document   : index
    Created on : 25/06/2013, 12:15:58 AM
    Author     : Paulo
--%>

<%@page import="Entidades.clsServicio"%>
<%@page import="Entidades.clsEncargado"%>
<%@page import="Entidades.clsInstalacion"%>
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
     clsEncargado admin=(clsEncargado) request.getSession(true).getAttribute("SessionEncargado");
  if(admin==null)
   {
           response.sendRedirect("/index.jsp"); 
   }

  clsGestor objGestor=new clsGestor();  
  clsSucursal objSucursal=objGestor.buscarIdSucursal(admin.getObjSucursal().getInt_IdSucursal());
  int id=0;
  List<clsServicio> listaServicio=null;
  List<clsInstalacion> lista=null;
    if(request.getParameter("IdSucursal") != null && request.getParameter("IdSucursal") != "" && 
       request.getParameter("Nombre") != null && request.getParameter("Nombre") != "" && 
       request.getParameter("Descripcion") != null && request.getParameter("Descripcion") != "" )
{  
    clsSucursal objSucursal1 = new clsSucursal();
    objSucursal1.setInt_IdSucursal(Integer.parseInt( request.getParameter("IdSucursal")));

    clsInstalacion objInstalacion = new clsInstalacion();
    objInstalacion.setObjSucursal(objSucursal1);
    //objInstalacion.setStr_Nombre(request.getParameter("Nombre"));
    objInstalacion.setStr_Descrpcion(request.getParameter("Descripcion"));
    id=objGestor.insertarInstalacion(objInstalacion);
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
function Registrar()
 {
         var login = function(){
            var nombre = $(this).children('form').children('input[type="nombre"]').val();
            var descripcion = $(this).children('form').children('input[type="descripcion"]').val();
            if(nombre.length < 1 || descripcion.length < 1){

                alert('Error!\n Ingrese un todos los datos');
            } else {
                
                 window.location ="listaInstalacion.jsp?IdSucursal="+<%=objSucursal.getInt_IdSucursal()%>+"&Nombre="+nombre+"&Descripcion="+descripcion;
                $.fallr('hide');
            }
        }

        $.fallr('show', {
            icon        : 'secure',
            width       : '320px',
            content     : '<h4> Agregar Instalacion</h4>'
                        + '<form>'
                        +     'Nombre Intalación:<br> <input width="254 px" height="44 px" placeholder="nombre instalación" type="nombre"/'+'>'
                        +     '<br>Descripción:<br><input width="254 px" height="44 px" placeholder="descripción" type="descripcion"/'+'>'
                        + '</form>',
            buttons : {
                button1 : {text: 'Agregar', onclick: login},
                button4 : {text: 'Cancel'}
	      }
	  });
}
  function cerrar()
                {
                       var clicked1 = function(){
	                   window.location ="../cerrarSesion.jsp?";
	                };
                   
	                $.fallr('show', {
	                    buttons : {
	                        button1 : {text: 'Aceptar',  onclick: clicked1},
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
              <div class="full_w">
                <center></center><div class="h_title"> <h1>Hotel <%=objSucursal.getObjEmpresa().getStr_Nombre() %></h1></div></center>
			</div>
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
                        <div class="h_title">&#8250; Control Pricipal</div>
                        <ul id="home">
                            <li class="b1"><a class="icon view_page" href="index.jsp">Panel Reservas</a></li>
                            <li class="b2"><a class="icon report" href="listaTipoHabitacion.jsp">Tipo de Habitaciones</a></li>
                            <li class="b2"><a class="icon config" href="">Configuracion</a></li>
                        </ul>
                    </div>

                    <div class="box">
                        <div class="h_title">&#8250; Gestion de Instalaciones</div>
                        <ul>
                            <li class="b1"><a class="icon page" href="">Mostrar Instalaciones</a></li>
                            <li class="b2"><a class="icon add_page" href="listaInstalacion.jsp">Agregar Instalaciones</a></li>
                            <li class="b1"><a class="icon photo" href="">Ingresar Fotos</a></li>                            
                        </ul>
                    </div>			
                    <div class="box">
                        <div class="h_title">&#8250; Opciones</div>
                        <ul>
                            <li class="b1"><a class="icon config" href="">Configuracion sitio</a></li>
                            <li class="b2"><a class="icon contact" href="">Datos Genearales</a></li>
                        </ul>
                    </div>
		</div>
		<div id="main">
			<div class="full_w">
				<div class="h_title">Agregar Instalaciones</div>

                <center>
					<div class="element">
                         
                        <label for="category"> <span class="red">Agregar Intalacion</span> </label>
                        
                        
                        
                        
                        
                        
                        
                        <label for="category"> <span class="red">Tipos de Habitaciones</span> </label>
                        
                                <select name="TipoHabitacion" id="TipoHabitacion" class="err">
                            <% listaServicio=objGestor.ListarDiferenteServicio(objSucursal.getInt_IdSucursal()); 
                                if(listaServicio!=null){ 
                                for(clsServicio entidad : listaServicio) { %>
                                    <option value="<%=entidad.getInt_IdServicio()%>">
                                        <%=entidad.getStr_Nombre()%></option>
                                    <%  }
                               }else{%>
                                <option value="0">-- No hay Datos</option>
                            <% }%>
                        
                        
                        
                        
                        
                        
                        
                          <a href="#" onclick="Registrar()" class="table-icon add" title="Agregar"></a>
					</div>
                       
                        	
			   </center>

			</div>
                        
            <div class="clear"></div>
            
               <div class="full_w">
				<div class="h_title">Lista de Instalaciones</div>				
			  <%
            lista=objGestor.listardSucursalesInstalacion(objSucursal.getInt_IdSucursal());  
            if(lista!=null)                                    
            {    
               %>
				<table>
					<thead>
						<tr>
							<th scope="col">ID</th>
							<th scope="col">Nombre</th>
                            <th scope="col">Descripcion</th>

							<th scope="col"></th>
						</tr>
					</thead>
						
					<tbody>
						
                            <%
                      
                                    
                            for(clsInstalacion entidad : lista)                               
                             {
                            %>
                            <tr>
                            <td class="align-center"><%=entidad.getInt_IdInstalacion()%></td>                            
                            <td ><%=entidad.getObjServicio().getStr_Nombre()%></td>
                            <td > <%=entidad.getStr_Descrpcion()%></td>	
							<td>
								<a href="#" onclick="" class="table-icon edit" title="Edit"></a>
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

  <% if(id>0){%>    
  <script type="text/javascript"> alert("Se Registro Correctamente");</script>
   <% }%>    
  
</body>
</html>
