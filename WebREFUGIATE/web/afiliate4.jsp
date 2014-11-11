<%-- 
    Document   : afiliate
    Created on : 12/06/2013, 03:09:46 PM
    Author     : Paulo
--%>

<%@page import="Entidades.clsEmpresa"%>
<%@page import="Entidades.clsEncargado"%>
<%@page import="Entidades.clsSucursal"%>
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
    
        <Script src="AJAX/ajax_Provincia.js"></Script>
        <Script src="AJAX/ajax_Distrito.js"></Script>
       
        <%  
            clsGestor objGestor=new clsGestor(); 
            clsEncargado encargado=null;
            clsSucursal objSucursal =(clsSucursal) request.getSession(true).getAttribute("SessionSucursal");
            if(request.getParameter("nombres") != null && request.getParameter("nombres") != "" &&
            request.getParameter("apellidos") != null && request.getParameter("apellidos") != "" &&
            request.getParameter("usuario") != null && request.getParameter("usuario") != "" &&
            request.getParameter("pass") != null && request.getParameter("pass") != "" && 
            request.getParameter("email") != null && request.getParameter("email") != "" &&
            request.getParameter("celular") != null && request.getParameter("celular") != "" &&

            request.getParameter("pisos") != null && request.getParameter("pisos") != "" &&
            request.getParameter("telefono") != null && request.getParameter("telefono") != "" &&
            request.getParameter("salida") != null && request.getParameter("salida") != "" &&
            request.getParameter("entrada") != null && request.getParameter("entrada") != "" &&
            request.getParameter("cbNivel") != null && request.getParameter("cbNivel") != "")
            {
                clsEmpresa empresa=objSucursal.getObjEmpresa();
                int IdEmpresa =objGestor.insertarEmpresa(empresa);
                int IdSucursal=0;
                if(IdEmpresa>0)
                    {
                    empresa.setInt_IdEmpresa(IdEmpresa);
                    objSucursal.setObjEmpresa(empresa);
                    objSucursal.setInt_Pisos(Integer.parseInt(request.getParameter("pisos")));
                    objSucursal.setStr_Telefono(request.getParameter("telefono"));
                    objSucursal.setStr_Entrada(request.getParameter("entrada"));
                    objSucursal.setStr_Salida(request.getParameter("salida"));
                    objSucursal.setInt_Nivel(Integer.parseInt(request.getParameter("cbNivel")));
                    IdSucursal=objGestor.insertarSucursal(objSucursal);
                    if(IdSucursal>0)
                    {
                        objSucursal.setInt_IdSucursal(IdSucursal);
                        encargado=new clsEncargado();
                        encargado.setStr_Nombre(request.getParameter("nombres"));
                        encargado.setStr_Apellido(request.getParameter("apellidos"));
                        encargado.setStr_Usuario(request.getParameter("usuario"));
                        encargado.setStr_Password(request.getParameter("pass"));
                        encargado.setStr_Email(request.getParameter("email"));
                        encargado.setStr_Celular(request.getParameter("celular"));
                        encargado.setObjSucursal(objSucursal);
                        objGestor.insertarEncargado(encargado);

                    }    
                }
            }
        %>
    </head>
<body>
    <!-- wrapper -->
    <div class="wrapper">
        <!-- header -->
        <header class="header">
            <div class="shell">
                <div class="header-top">
                    <h1 id="logo"><img  src="new/img/logo_refugiate.png" width="130" height="75"/></h1>
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
                <div class="slider">
                    <div id="bg"></div>
                        <br/><br/><br/><br/><br/><br/>
                        <h4 id="h1_cs">
                            <center>
                                Sus datos seran confiramdos en las siguientes 24 horas a través de un correo a tu bandeja de entrada de : 
                            </center>
                        </h4>
                        <h3 id="h2_cs">
                            <center>
                                <%=encargado.getStr_Email()%> 
                            </center>
                        </h3>
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
                    <p class="copy">Copyright &copy; 2012<span>|</span>Design by: 
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