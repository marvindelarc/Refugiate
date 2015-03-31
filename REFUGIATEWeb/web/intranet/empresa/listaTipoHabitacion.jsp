<%-- 
    Document   : index
    Created on : 25/06/2013, 12:15:58 AM
    Author     : Paulo
--%>

<%@page import="Entidades.clsEncargado"%>
<%@page import="Entidades.clsCostoTipoHabitacion"%>
<%@page import="Entidades.clsTipoHabitacion"%>
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
      clsGestor objGestor=new clsGestor();
 clsEncargado admin=(clsEncargado) request.getSession(true).getAttribute("SessionEncargado");
  if(admin==null)
   {
           response.sendRedirect("/index.jsp"); 
   }  
  clsSucursal objSucursal=objGestor.buscarIdSucursal(admin.getObjSucursal().getInt_IdSucursal());
   
  List<clsTipoHabitacion> lista=null;  
  int id=0;
  List<clsCostoTipoHabitacion> listacosto=null;  
    if(request.getParameter("IdSucursal") != null && request.getParameter("IdSucursal") != "" && 
       request.getParameter("IdTipo") != null && request.getParameter("IdTipo") != "" && 
       request.getParameter("Costo") != null && request.getParameter("Costo") != "" && 
       request.getParameter("Total") != null && request.getParameter("Total") != "" )
{  
    clsSucursal objSucursal1 = new clsSucursal();
    objSucursal1.setInt_IdSucursal(Integer.parseInt( request.getParameter("IdSucursal")));
    clsTipoHabitacion objTipoHabitacion = new clsTipoHabitacion();
     objTipoHabitacion.setInt_IdTipoHabitacion(Integer.parseInt( request.getParameter("IdTipo")));
    
   clsCostoTipoHabitacion objCostoTipoHabitacion = new clsCostoTipoHabitacion(); 
    objCostoTipoHabitacion.setDou_Costo(Double.parseDouble(request.getParameter("Costo")));
    objCostoTipoHabitacion.setInt_TotalHabitaciones(Integer.parseInt( request.getParameter("Total")));
    objCostoTipoHabitacion.setObjSucursal(objSucursal1);
    objCostoTipoHabitacion.setObjTipoHabitacion(objTipoHabitacion);
    id=objGestor.insertarTipoHabitacion(objCostoTipoHabitacion);
 

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
    var texto=$("#TipoHabitacion option:selected").text();
    var value=$("#TipoHabitacion option:selected").val();
    var regex  = /^\d+(?:\.\d{0,1})$/;
    
 
     
         var login = function(){
            var costo = $(this).children('form').children('input[type="costo"]').val();
            var total = $(this).children('form').children('input[type="total"]').val();
            if(costo.length < 1 || total.length < 1){
                
                alert('Error!\n Ingrese un todos los datos');
            } else {
                 if(parseInt(total) != parseFloat(total))
                 {
                    alert('El campo total de habitaciones debe ser un numero entero');     
                 }
                 else if ( !regex.test(costo))
                 {
                    alert('El campo costo de habitaciones debe ser un numero con unvalor decimal');        
                 }
                 else
                {
                 window.location ="listaTipoHabitacion.jsp?IdSucursal="+<%=objSucursal.getInt_IdSucursal()%>+"&IdTipo="+value+"&Costo="+costo+"&Total="+total;
                $.fallr('hide');
                }
            }
        }

        $.fallr('show', {
            icon        : 'secure',
            width       : '320px',
            content     : '<h4> Habitacion: '+texto+'</h4>'
                        + '<form>'
                        +     'Costo Habitación:<br> <input width="254 px" height="44 px" placeholder="costo habitación" type="costo"/'+'>'
                        +     '<br>Total Habitaciones:<br><input width="254 px" height="44 px" placeholder="total habitaciones" type="total"/'+'>'
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
			<p>Bienvenido, <strong><%=admin.getStr_Apellido()%>, <%=admin.getStr_Nombre()%>.</strong> [<a href="#" onclick="cerrar()">Salir</a> ]</p>
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
                        <div class="h_title">&#8250; Gestion de habitación</div>
                        <ul>
                            <li class="b1"><a class="icon page" href="">Mostrar habitación</a></li>
                            <li class="b2"><a class="icon add_page" href="listaInstalacion.jsp">Agregar habitación</a></li>
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
				<div class="h_title">Agregar Tipo de Habitaciones</div>
                                <center>
					<div class="element">
                         
                                <label for="category"> <span class="red">Tipos de Habitaciones</span> </label>
                        
                                <select name="TipoHabitacion" id="TipoHabitacion" class="err">
                            <% lista=objGestor.ListarDiferenteTipoHabitacion(objSucursal.getInt_IdSucursal()); 
                                if(lista!=null){ 
                                for(clsTipoHabitacion entidad : lista) { %>
                                    <option value="<%=entidad.getInt_IdTipoHabitacion()%>">
                                        <%=entidad.getNombreComercial()%></option>
                                    <%  }
                               }else{%>
                                <option value="0">-- No hay Datos</option>
                            <% }%>
						</select>
                          <a href="#" onclick="Registrar()" class="table-icon add" title="Agregar"></a>
					</div>                    
                        	
			   </center>

			</div>
                        
            <div class="clear"></div>
            
               <div class="full_w">
				<div class="h_title">Tipo de habitaciones</div>				
			  <%
            listacosto=objGestor.listarCostoTipoHabitacionXIdSucursales(objSucursal.getInt_IdSucursal());  
            if(listacosto!=null)                                    
            {    
               %>
				<table>
					<thead>
						<tr>
							<th scope="col">ID</th>
							<th scope="col">Tipo Habitacion</th>
                            <th scope="col">Costo</th>
							<th scope="col">T. Habitaciones</th>
                            <th scope="col">H. Ocupadas</th>
                            <th scope="col">H. Disponibles</th>
							<th scope="col"></th>
						</tr>
					</thead>
						
					<tbody>
						
                            <%
                      
                                    
                            for(clsCostoTipoHabitacion entidad : listacosto)                               
                             {
                            %>
                            <tr>
                            <td class="align-center"><%=entidad.getInt_IdCostoTipoHabitacion()%></td>                            
							<td  class="align-center"><%=entidad.getObjTipoHabitacion().getNombreComercial()%></td>
							<td  class="align-center"><%=entidad.getDou_Costo()%></td>
							<td  class="align-center"><%=entidad.getInt_TotalHabitaciones()%></td>
                            <td  class="align-center"><%=entidad.getInt_HabitacionesOcupadas()%></td>
                            <td  class="align-center"><%=(entidad.getInt_TotalHabitaciones()+entidad.getInt_HabitacionesOcupadas())%></td>		
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
