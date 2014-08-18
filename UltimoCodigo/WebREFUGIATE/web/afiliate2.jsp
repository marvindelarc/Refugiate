<%-- 
    Document   : afiliate
    Created on : 12/06/2013, 03:09:46 PM
    Author     : Paulo
--%>

<%@page import="Entidades.clsEmpresa"%>
<%@page import="Entidades.clsSucursal"%>
<%@page import="Entidades.clsDistrito"%>
<%@page import="Entidades.clsDepartamento"%>
<%@page import="java.util.List"%>
<%@page import="COM.clsGestor"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1, user-scalable=0" />
        <title>Ref&uacute;giate</title>
        <link rel="shortcut icon" type="img/x-icon" href="new/img/favicon.ico" />
        
        <link href='http://fonts.googleapis.com/css?family=Coda' rel='stylesheet' type='text/css' />
        <link href='http://fonts.googleapis.com/css?family=Jura:400,500,600,300' rel='stylesheet' type='text/css' />
        
        <link rel="stylesheet" href="new/css/formulario.css" type="text/css"/>	
        <link rel="stylesheet" href="new/css/table.css" type="text/css"/>	
        <link rel="stylesheet" href="new/css/style.css" type="text/css" media="all" />
        
        <script src="new/js/jquery-1.8.0.min.js" type="text/javascript"></script>
        <script src="new/js/jquery.touchwipe.1.1.1.js" type="text/javascript"></script>
        <script src="new/js/jquery.carouFredSel-5.5.0-packed.js" type="text/javascript"></script>
        <!--[if lt IE 9]><script src="new/js/modernizr.custom.js"></script><![endif]-->
        <script src="new/js/functions.js" type="text/javascript"></script>
        
        <script type="text/javascript" src="new/js/jquery.ketchup.js"></script>
        <script type="text/javascript" src="new/js/jquery.ketchup.helpers.js"></script>
        <script type="text/javascript" src="new/js/jquery.ketchup.validations.js"></script>
        <link rel="stylesheet" href="new/css/jquery.ketchup.css" type="text/css" media="screen">
        <script type="text/javascript">
		jQuery(document).ready(function()
		{	
          $('#default-behavior').ketchup();

		});

	</script>   
       
<%  
 clsGestor objGestor=new clsGestor(); 
clsDistrito objDistrito=null;
String ubicacion = "";
if(request.getParameter("nombreComercial") != null && request.getParameter("nombreComercial") != "" &&
        request.getParameter("nombre") != null && request.getParameter("nombre") != "" &&
        request.getParameter("slogan") != null && request.getParameter("slogan") != "" &&
        request.getParameter("ruc") != null && request.getParameter("ruc") != "" && 
        request.getParameter("cbDistrito") != null && request.getParameter("cbDistrito") != "")
{
objDistrito=objGestor.buscarIdProvincia(Integer.parseInt(request.getParameter("cbDistrito")));

clsEmpresa objEmpresa = new clsEmpresa();
objEmpresa.setStr_Nombre(request.getParameter("nombre"));
objEmpresa.setStr_NombreComercial(request.getParameter("nombreComercial"));
objEmpresa.setStr_Slogan(request.getParameter("slogan"));
objEmpresa.setStr_Ruc(request.getParameter("ruc"));
clsSucursal objSucursal = new clsSucursal();

objSucursal.setObjEmpresa(objEmpresa);
objSucursal.setObjDistrito(objDistrito);

               
 if(objDistrito!=null)
    ubicacion=objDistrito.getStr_Nombre()+
             ", "+objDistrito.getObjProvincia().getStr_Nombre()+
             ", "+objDistrito.getObjProvincia().getObjDepartamento().getStr_Nombre()+", Peru";
 
 
 HttpSession sesion = request.getSession(true);
               sesion.setAttribute("SessionSucursal",objSucursal); 
}
%>
           <script src="http://maps.google.com/maps?file=api&amp&v=2&amp&key=AIzaSyBQmgv58WhbBti5fRGe6kwF-LERQgCjFyo"
        type="text/javascript">
</script>
     
        <script type="text/javascript">
    //<![CDATA[

	// Inicialización de variables.
    var map      = null;
    var geocoder = null;
    function load() {                                      // Abre LLAVE 1.
      if (GBrowserIsCompatible()) {						   // Abre LLAVE 2.
       map = new GMap2(document.getElementById("map"));
       geocoder = new GClientGeocoder();
       geocoder.getLatLng("<%=ubicacion%>",
          		function(point) {
            		if (!point) {
            			alert("<%=ubicacion%>"+ " not found");
            		} else {
            			map.setCenter(point, 14);
               		}
               	}
        	);
       
       
       
       
        map.addControl(new GSmallMapControl());
	   	map.addControl(new GMapTypeControl());

       

        //---------------------------------//
        //   MARCADOR AL HACER CLICK
		//---------------------------------//
		GEvent.addListener(map, "click",
			function(marker, point) {
 		 		if (marker) {
               		null;
              		} else {
          			map.clearOverlays();
					var marcador = new GMarker(point);
					map.addOverlay(marcador);
                                        marcador.openInfoWindowHtml("<form id='default-behavior' action='afiliate3.jsp' method='post' >\n\
                                                        <h3>Cordenadas Seleccionadas</h3> \n\
                                                        <input type='hidden' name='longitud' value='"+point.lng()+"'/> \n\
                                                        <input type='hidden' name='latitud' value='"+point.lat()+"'/>\n\
                                                        Direcion: <input name='direcion' type='text' placeholder='ingrese dirección' autofocus required><br> \n\
                                                        <center><input type='submit' value='Grabar Ubicacion' /></center> </form>  ");
					
					}
  			}
			);
        //---------------------------------//
        //   FIN MARCADOR AL HACER CLICK
		//---------------------------------//

      } // Cierra LLAVE 1.
    }   // Cierra LLAVE 2.

    //---------------------------------//
    //           GEOCODER
	//---------------------------------//
   function showAddress(address) {
    address=address+"<%=ubicacion%>";
    	if (geocoder) {
        	geocoder.getLatLng(address,
          		function(point) {
            		if (!point) {
            			alert(address + " not found");
            		} else {
            			map.setCenter(point, 14);
            			var marker = new GMarker(point);
            			map.addOverlay(marker);
            			marker.openInfoWindowHtml("<b>Coordenadas:</b> "+point.y+","+point.x);
               		}
               	}
        	);
      	}}
    //---------------------------------//
    //     FIN DE GEOCODER
	//---------------------------------//

    //]]>
     </script>

    </head>
    <body  onLoad="load();"  onunload="GUnload();">
        <!-- wrapper -->
    <div class="wrapper">
        <!-- header -->
        <header class="header">
            <div class="shell">
                <div class="header-top">
                    <h1 id="logo"><img src="new/img/logo_refugiate.png" width="130" height="75"/></h1>
                    <nav id="navigation">
                        <ul>
                            <li><a href="index.jsp">Inicio</a></li>
                            <li class="active home"><a href="afiliate1.jsp">Afiliate</a></li>
                            <li><a href="conocenos.jsp">Conocenos</a></li>
                            <li><a href="servicios.jsp">Servicios</a></li>
                            <li><a href="InciarSesion.jsp">Iniciar Sesion</a></li>																					
                        </ul>
                    </nav>
                    <div class="cl">&nbsp;</div>
                </div>
                <div class="slider" align="center">
                    <div id="bg"></div>
                    <div id="map" style="width: 910px; height: 540px; margin: 4px 0px 4px 0px;" ></div>   
                </div>
                </div>
            </header>
        <!-- end of header -->
        <!-- shell -->
            <div class="shell">
                <!-- main -->
                <div class="main">
                    <section class="partners">					
                        <div id="partners-slider">
                            <div class="slider-holder2">
                                <img src="new/img/Hoteles/Sheraton-Hotel-Resorts-logo.jpg" width="140" height="52" />
                                <img src="new/img/Hoteles/hotel_haciendajpg.jpg" width="170" height="52" />
                                <img src="new/img/Hoteles/logo_libertadores.jpg" width="170" height="52" />
                                <img src="new/img/Hoteles/logo_pullman.jpg" width="180" height="52" />
                                <img src="new/img/Hoteles/omac_logo_bravo.png" width="150" height="52" />
                                <img src="new/img/Hoteles/belle-sand.logo.jpg" width="172" height="52" />
                                <img src="new/img/Hoteles/kunturwasi.png" width="215" height="52" />
                                <img src="new/img/Hoteles/posadadelobo.png" width="210" height="52" />						    
                            </div>
                        </div>
                        <div class="slider-arr">
                            <a class="prev-arr arr-btn" href="#"></a>
                            <a class="next-arr arr-btn" href="#"></a>
                        </div>
                    </section>
                    <div class="socials">
                        <p>Estamos a su disposición. Póngase en contacto con nosotros atraves de:</p>
                        <ul>
                            <li><a href="https://www.facebook.com/Refugiateapp" class="facebook-ico">facebook-ico</a></li>
                            <li><a href="https://twitter.com/RefugiateApp" class="twitter-ico">twitter-ico</a></li>
                            <li><a href="http://www.youtube.com/channel/UCe14ECuDFqcSS4VjvSLsHuw?feature=watch" class="skype-ico">Youtube</a></li>
                            <li><a href="https://plus.google.com/u/1/" class="rss-ico">+Google</a></li>
                        </ul>
                    </div>
                </div>
                <!-- end of main -->
            </div>
            <!-- end of shell -->                         
                                       
        
         <!-- footer -->
            <div id="footer">
                <!-- shell -->
                <div class="shell">
                    <!-- footer-cols -->
                    <div class="footer-cols">
                        <div class="col">
                            <h2>SERVICES</h2>
                            <ul>
                                <li><a href="#">Publicidad de establecimiento</a></li>
                                <li><a href="#">Reservas via movil</a></li>
                                <li><a href="#">Web de administracion de resrevas</a></li>							
                            </ul>
                        </div>
                        <div class="col">
                            <h2>SOLUTIONS</h2>
                            <ul>
                                <li><a href="#">Manejo de informacion</a></li>
                                <li><a href="#">Control de las reservas</a></li>                            
                            </ul>
                        </div>
                        <div class="col">
                            <h2>CONTACT us</h2>
                            <p>Email: <a href="#">refugiate.app.h@gmail.com</a></p>
                            <p>Phone: 655-606-605</p>
                            <p>Address: Av. Peru 1099, </p>
                            <p>Trujillo - Peru</p>
                        </div>
                        <div class="cl">&nbsp;</div>
                    </div>
                    <!-- end of footer-cols -->
                    <div class="footer-bottom">					
                        <p class="copy">Copyright &copy; 2013<span>|</span>Design by: 
                            <a href="#" target="_blank">M&T</a>
                        </p>
                        <div class="cl">&nbsp;</div>
                    </div>
                </div>
                <!-- end of shell -->
            </div>
            <!-- footer -->
        </div>
    <!-- end of wrapper -->
    </body>
</html>    
                    
