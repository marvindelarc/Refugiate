<%-- 
    Document   : InciarSesion
    Created on : 12/06/2013, 07:22:22 PM
    Author     : Paulo
--%>

<%@page import="Entidades.clsEncargado"%>
<%@page import="Entidades.clsWebAdmin"%>
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
        
        <link rel="stylesheet" href="new/css/style.css" type="text/css" media="all" />
        <link rel="stylesheet" href="new/css/formulario.css" type="text/css"/>	
        <link rel="stylesheet" href="new/css/table.css" type="text/css"/>	
        <link rel="stylesheet" href="new/css/loguin.css" type="text/css"/>	
                
        <script src="new/js/jquery-1.8.0.min.js" type="text/javascript"></script>
        <script src="new/js/jquery.touchwipe.1.1.1.js" type="text/javascript"></script>
        <script src="new/js/jquery.carouFredSel-5.5.0-packed.js" type="text/javascript"></script>
        <!--[if lt IE 9]><script src="new/js/modernizr.custom.js"></script><![endif]-->
        <script src="new/js/functions.js" type="text/javascript"></script>
        <%         
        clsGestor objGestor = new clsGestor();
        clsWebAdmin admin=(clsWebAdmin) request.getSession(true).getAttribute("SessionAdmin");
        if(admin!=null){          
            response.sendRedirect("/intranet/admin/index.jsp"); 
        }
        if( request.getParameter("txtUsuario") != null && request.getParameter("txtUsuario") != "" &&
            request.getParameter("txtPassword") != null && request.getParameter("txtPassword") != "" ){
            admin=objGestor.loginWebAdmin(request.getParameter("txtUsuario"),request.getParameter("txtPassword"));
            if(admin!=null){
                HttpSession sesion = request.getSession(true);
                sesion.setAttribute("SessionAdmin", admin);  
                response.sendRedirect("/intranet/admin/index.jsp"); 
            }
            clsEncargado encargado = objGestor.loginEncargado(request.getParameter("txtUsuario"),request.getParameter("txtPassword"));
            if(encargado!=null){
                HttpSession sesion = request.getSession(true);
                sesion.setAttribute("SessionEncargado", encargado);  
                response.sendRedirect("/intranet/empresa/index.jsp"); 
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
                            <li><a href="afiliate1.jsp">Afiliate</a></li>
                            <li><a href="conocenos.jsp">Conocenos</a></li>
                            <li><a href="servicios.jsp">Servicios</a></li>
                            <li class="active home"><a href="InciarSesion.jsp">Iniciar Sesion</a></li>																					
                        </ul>
                    </nav>
                    <div class="cl">&nbsp;</div>
                </div>
                <div class="slider">
                    <div id="bg"></div>  
                    <div class="container">
                        <div class="login">
                            <div class="login_side">
                                <div class="login_inside">
                                    <h2>LOGIN</h2><br/><br/><br/><br/>
                                    <p><a href="#">Recordar contraseña?</a></p> 
                                    <p><a href="#">Necesita ayuda?</a></p><br/> 
                                </div>
                            </div>
                            <form name="frmLogin" action="InciarSesion.jsp"  method="post">
                                <label>Usuario</label>
                                <input name="txtUsuario" type="text" placeholder="Usuario" required="" id="username" />
                                <label>Contraseña</label>
                                <input name="txtPassword" type="password" placeholder="Password" required="" id="password" />
                                <input name="submit" class="submit" type="submit" value="Ingresar"/>
                            </form>
                        </div>
                    </div><!-- container -->
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