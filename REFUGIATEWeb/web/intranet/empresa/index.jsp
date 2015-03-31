<%-- 
    Document   : index
    Created on : 25/06/2013, 12:15:58 AM
    Author     : Paulo
--%>

<%@page import="Entidades.clsEncargado"%>
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
   

%>
<link rel="stylesheet" type="text/css" href="../css/style.css" media="screen" />
<link rel="stylesheet" type="text/css" href="../css/navi.css" media="screen" />
  <script type="text/javascript" src="../js/jquery-1.6.3.min.js"></script>
  	<link rel="stylesheet" type="text/css" media="screen,projection" href="../css/jquery-fallr-1.3.css" />
	<script type="text/javascript" src="../js/jquery.easing.1.3.js"></script>
	<script type="text/javascript" src="../js/highlight.pack.js"></script>	
	<script type="text/javascript" src="../js/jquery-fallr-1.3.pack.js"></script>
    <script type="text/javascript" src="../js/exporting.js"></script>
    <script type="text/javascript" src="../js/highcharts1.js"></script>
    

    
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
    
    
    
            $('#container').highcharts({
            chart: {
                type: 'spline'
            },
            title: {
                text: 'Reservas Por Mes'
            },

            xAxis: {
                type: 'datetime',
                dateTimeLabelFormats: { // don't display the dummy year
                    month: '%e. %b',
                    year: '%b'
                }
            },
            yAxis: {
                title: {
                    text: 'Reservas(r)'
                },
                min: 0
            },
            tooltip: {
                formatter: function() {
                        return '<b>'+ this.series.name +'</b><br/>'+
                        Highcharts.dateFormat('%e. %b', this.x) +': '+ this.y +' r';
                }
            },
            
            series: [{
                name: 'Realizadas 2013-2014',

                data: [
                    [Date.UTC(1970,  0, 27), 20   ],
                    [Date.UTC(1970, 1, 10), 25 ],
                    [Date.UTC(1970, 1, 18), 30 ],
                    [Date.UTC(1970, 1,  22), 40 ],
                    [Date.UTC(1970, 1,  29), 60 ],
                    [Date.UTC(1970,  2,  1), 84],
                    [Date.UTC(1970,  3,  8), 90],
                    [Date.UTC(1970,  3, 12), 95],
                    [Date.UTC(1970,  3, 27), 100],
                    [Date.UTC(1970,  4, 10), 110],
                    [Date.UTC(1970,  4, 18), 100],
                    [Date.UTC(1970,  4, 24), 96],
                    [Date.UTC(1970,  5,  4), 112],
                    [Date.UTC(1970,  5, 11), 118],
                    [Date.UTC(1970,  6, 15), 125],
                    [Date.UTC(1970,  6, 25), 130]
                ]
            }, {
                name: 'Consumidas 2013-2014',
                data: [
                    [Date.UTC(1970,  0, 18), 20   ],
                    [Date.UTC(1970,  0, 26), 22 ],
                    [Date.UTC(1970, 1,  1), 22],
                    [Date.UTC(1970, 1, 11), 40],
                    [Date.UTC(1970, 1, 25),55],
                    [Date.UTC(1970,  2,  8), 62],
                    [Date.UTC(1970,  2, 15), 70],
                    [Date.UTC(1970,  3,  1), 75],
                    [Date.UTC(1970,  3,  8), 82],
                    [Date.UTC(1970,  3, 21), 90],
                    [Date.UTC(1970,  4, 12), 92],
                    [Date.UTC(1970,  4, 25), 100 ],
                    [Date.UTC(1970,  5,  4),120],
                    [Date.UTC(1970,  5,  9), 110],
                    [Date.UTC(1970,  6, 13), 99]
                ]
            }, {
                name: 'Canceladas 2013-2014',
                data: [
                    [Date.UTC(1970,  0,  9),10   ],
                    [Date.UTC(1970,  0, 14), 15],
                    [Date.UTC(1970, 1, 12), 20],
                    [Date.UTC(1970, 1, 28), 18],
                    [Date.UTC(1970,  2,  1),12],
                    [Date.UTC(1970,  2, 24), 18],
                    [Date.UTC(1970,  3,  1), 22],
                    [Date.UTC(1970,  3,  7), 10],
                    [Date.UTC(1970,  4, 23),25],
                    [Date.UTC(1970,  5,  8),15],
                    [Date.UTC(1970,  5, 14), 9],
                    [Date.UTC(1970,  6, 24), 12]
                ]
            }]
        });
         
    
    
    
  });
</script>


 
 <script type="text/javascript">   
var count_up_val = -1;
	function count_up() {
		count_up_val++;
                    if(count_up_val%10==0)
                    main('listaReservas.jsp');
               
		setTimeout(count_up, 1000);
	}
	function thread_start(callback) {
		setTimeout(callback, 1);
		return true;
	}
     
function funcionCallback()
{
	// Comprobamos si la peticion se ha completado (estado 4)
	if( ajax.readyState == 4 )
	{
		// Comprobamos si la respuesta ha sido correcta (resultado HTTP 200)
		if( ajax.status == 200 )
		{
                   
                    $('#get_main').html(ajax.responseText);
                
		}
	}
}
function main(url)
{    
	// Creamos el control XMLHttpRequest segun el navegador en el que estemos 
	if( window.XMLHttpRequest )
		ajax = new XMLHttpRequest(); // No Internet Explorer
	else
		ajax = new ActiveXObject("Microsoft.XMLHTTP"); // Internet Explorer

	// Almacenamos en el control al funcion que se invocara cuando la peticion
	// cambie de estado	
	ajax.onreadystatechange = funcionCallback;

	// Enviamos la peticion
	ajax.open( "GET",url, true );
	ajax.send( "" );
}


thread_start(count_up);

function Confirmar(id,nombre)
{
                         var clicked1 = function(){
                             main('listaReservas.jsp?IdReserva='+id);	                   
                          $.fallr('hide');
	                };

	                $.fallr('show', {
	                    buttons : {
	                        button1 : {text: 'Aceptar',  onclick: clicked1},
	                        button3 : {text: 'Cancel'}
	                    },
	                    content : '<p>Reserva de  : </br>'+nombre+' </p>',
                        position: 'center'
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


 </script>
</head>
<body>
<div class="wrap">
	<div id="header">
		<div id="top">
            <div class="full_w">
                <center><div class="h_title"> <h1>Hotel <%=objSucursal.getObjEmpresa().getStr_Nombre() %></h1></div></center>
			</div>
			<div class="left">
		<p>Bienvenido, <strong><%=admin.getStr_Apellido()%>, <%=admin.getStr_Nombre()%>.</strong> [  <a href="#" onclick="cerrar()">Salir</a> ]</p>
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
                            <div class="h_title">Reservas</div>
                            <div id="container"  style="min-width: 300px; height: 250px; margin: 0 auto"></div>	
			</div>
			<div class="clear"></div>
                	<div class="full_w">
                            <div class="h_title">Lista de reservas</div>				

                             <a id="get_main"></a> 
                            
                            
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
